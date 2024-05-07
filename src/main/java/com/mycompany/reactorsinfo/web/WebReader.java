/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.web;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author 79175
 */
public class WebReader {
    ArrayList<String> countries = new ArrayList<>();
    
    public WebReader() {
        
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
                country = doc.getElementById(id).text();
                countries.add(country);
                System.out.println(country);
            }
            else {
                break;
            }
            counter += 1;           
        }
            
          
    }
    
    public void readReactorsFromCountry() {
        
   
    
    
    }




}    

    


