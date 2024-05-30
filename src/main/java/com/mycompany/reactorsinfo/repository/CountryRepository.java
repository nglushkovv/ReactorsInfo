/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reactorsinfo.repository;

import com.mycompany.reactorsinfo.model.Country;
import java.util.List;

/**
 *
 * @author 79175
 */
public interface CountryRepository {
    
    public Country findCountryByCode(String code);
    public Country findCountryByName(String name);
    public List<Country> findCountriesByRegion(String region);
    public void addCountryToRepository(Country country);
    
}
