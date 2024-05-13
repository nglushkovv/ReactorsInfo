/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.web;

import com.mycompany.reactorsinfo.Repository;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author 79175
 */
public class WebReader {
    HashMap<String, String> countries = new HashMap<>();
    private Repository repository;
    private Document additionalPage;

    
    public WebReader(Repository repository) {
        this.repository = repository;
    }
    
    public void start() throws IOException {
        readCountriesFromPage();
        readReactorsFromCountries();
        

        
        
        
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
                //System.out.println(country + " " + href[href.length-2]+href[href.length-1]);
            }
            else {
                break;
            }
            counter += 1;           
        }
            
          
    }
    
    public void readReactorsFromCountries() throws IOException {
        List<String> attributes;
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
                counter += 1;
                System.out.println("------------------------------------");
                attributes.add(country.getKey());
                repository.createReactor(attributes);
                System.out.println("------------------------------------");
            }
            
        }
    
    }
    
    public void workWithAdditionalDataPages() {
        
    }
    
    
    
   
    


        
    
}




  

    


