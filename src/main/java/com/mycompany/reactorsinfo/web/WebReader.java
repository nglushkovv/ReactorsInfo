/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.web;

import com.mycompany.reactorsinfo.model.Reactor;
import com.mycompany.reactorsinfo.services.ReactorService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 *
 * @author 79175
 */
public class WebReader {
    private HashMap<String, String> countries = new HashMap<>();
    private ReactorService reactorService;
    private List<String> attributes;
    private final WebDriver driver;

    
    public WebReader(ReactorService reactorService) {
        this.reactorService = reactorService;
        EdgeOptions options = new EdgeOptions();
        options.addArguments("headless");
        driver = new EdgeDriver(options);
    }
    
    public void start() throws IOException {
        readCountriesFromPage();
        readReactorsFromCountries();

        
    }
    private void configureDriver(){
        System.setProperty("webdriver.edge.driver", "resources/Driver/msedgedriver");
    }
    
    public void readCountriesFromPage() throws IOException {
        Document doc = Jsoup
                .connect("https://pris.iaea.org/PRIS/WorldStatistics/OperationalReactorsByCountry.aspx")
                .get();
        
        String id = "";
        String country;
        int counter = 0;
        while(true){
            id = "MainContent_MainContent_ucReport_rptReport_hypCountry_"
                    + String.valueOf(counter);
            if (doc.getElementById(id) != null){
                Element element = doc.getElementById(id);
                country = element.text();
                String[] href = element.attr("href").split("");
                
                countries.put(country, href[href.length-2]+href[href.length-1]);
            }
            else {
                break;
            }
            counter += 1;           
        }
            
          
    }
    
    public void readReactorsFromCountries() throws IOException {
        
        for(Map.Entry<String, String> country: countries.entrySet()) {
            String url = 
                    "https://pris.iaea.org/PRIS/CountryStatistics/CountryDetails.aspx?current=" + 
                    country.getValue();
            Document doc = Jsoup.connect(url).get();
            int counter = 0;
            
            while(true){
                attributes = new ArrayList<>();
                if(doc.getElementById("MainContent_MainContent_rptCountryReactors_hypReactorName_"
                           +     counter) == null) break;
                Element element = doc
                        .getElementById("MainContent_MainContent_rptCountryReactors_hypReactorName_"
                           +     counter);
                String href = element.attr("href");
                
                attributes.add(element.text());
                Element elem = element.parent();
                for(int i = 0; i < 6; i++){
                    elem = elem.nextElementSibling();
                    attributes.add(elem.text());
                }
                
                driver.get(url);
                List<String[]> operatingHistory = getAdditionalDataFromReactor("MainContent_MainContent_rptCountryReactors_hypReactorName_"
                           +     counter);
                counter += 1;
                
                attributes.add(country.getKey());
                Reactor reactor = reactorService.createReactor(attributes);
                for(String[] oh: operatingHistory) {
                    reactorService.createOperatingHistory(reactor, oh);
                }
                
            }
            
        }
    
    }

    
    public List<String[]> getAdditionalDataFromReactor(String elementId) {
        WebElement element;
        List<String[]> operatingHistory = new ArrayList<>();
        try{
            driver.findElement(By.id(elementId)).click();
            List<WebElement> elements = driver.findElements(By.className("last-child"));
            WebElement previousSibling = elements.get(1).findElement(By.xpath("./preceding-sibling::td[1]"));
            attributes.add(previousSibling.getText());
            attributes.add(elements.get(1).getText());
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        } finally {
            element = driver.findElement(By.id("MainContent_MainContent_lblThermalCapacity"));
            attributes.add(element.getText());
            try{
                operatingHistory = readOperatingHistory();
            } catch (Exception ex) {
                
            }
            
            return operatingHistory;

        }
        
        
    }
    
    public List<String[]> readOperatingHistory() {
        List<String[]> operatingHistory = new ArrayList<>();
        WebElement table = driver.findElement(By.cssSelector("table.active"));
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                if (!cells.isEmpty()) {

                    try{
                        String year = cells.get(0).getText().trim();
                        if(year.length() >4){
                            break;
                        }
                        String annualOperatingHistory = cells.get(7).getText().trim();
                        if(annualOperatingHistory.isEmpty()) {
                            annualOperatingHistory = null;
                        }
                        String[] rowData = {year, annualOperatingHistory};
                        operatingHistory.add(rowData);
                    } catch(Exception ex){
                    }
                }
        }
            return operatingHistory;
    }
}
    

   
    


        
    





  

    


