/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.services;

import com.mycompany.reactorsinfo.model.Country;
import com.mycompany.reactorsinfo.repository.CountryRepository;
import com.mycompany.reactorsinfo.repository.CountryRepositoryImpl;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author 79175
 */
public class CountryService {
    private CountryRepository repository;
    
    private String[][] countries = {
        {"AR", "ARGENTINA", "South America"},
        {"AM", "ARMENIA", "Asia"},
        {"BY", "BELARUS", "Europe"},
        {"BE", "BELGIUM", "Europe"},
        {"BR", "BRAZIL", "South America"},
        {"BG", "BULGARIA", "Europe"},
        {"CA", "CANADA", "North America"},
        {"CN", "CHINA", "Asia"},
        {"CZ", "CZECH REPUBLIC", "Europe"},
        {"FI", "FINLAND", "Europe"},
        {"FR", "FRANCE", "Europe"},
        {"DE", "GERMANY", "Europe"},
        {"HU", "HUNGARY", "Europe"},
        {"IN", "INDIA", "Asia"},
        {"IR", "IRAN, ISLAMIC REPUBLIC OF", "Asia"},
        {"JP", "JAPAN", "Asia"},
        {"KR", "KOREA, REPUBLIC OF", "Asia"},
        {"MX", "MEXICO", "North America"},
        {"NL", "NETHERLANDS, KINGDOM OF THE", "Europe"},
        {"PK", "PAKISTAN", "Asia"},
        {"RO", "ROMANIA", "Europe"},
        {"RU", "RUSSIA", "Europe"},
        {"SK", "SLOVAKIA", "Europe"},
        {"SI", "SLOVENIA", "Europe"},
        {"ZA", "SOUTH AFRICA", "Africa"},
        {"ES", "SPAIN", "Europe"},
        {"SE", "SWEDEN", "Europe"},
        {"CH", "SWITZERLAND", "Europe"},
        {"TW", "TAIWAN", "Asia"},
        {"UA", "UKRAINE", "Europe"},
        {"AE", "UNITED ARAB EMIRATES", "Asia"},
        {"GB", "UNITED KINGDOM", "Europe"},
        {"US", "UNITED STATES OF AMERICA", "North America"}
    };
    
    public void fillCountryTable() {
        for(String[] data: countries) {
            Country country = new Country(data[0],
                                          data[1], 
                                          data[2]);
            repository.addCountryToRepository(country);
        }
    }
    
    public void createCountryRepository(Session session) {
        repository = new CountryRepositoryImpl(session);
    }
    
    public CountryRepository getRepository() {
        return repository;
    }
    
}
