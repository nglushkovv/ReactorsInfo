/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.repository;

import com.mycompany.reactorsinfo.model.OperatingHistory;
import com.mycompany.reactorsinfo.model.Reactor;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.util.List;


/**
 *
 * @author 79175
 */
public interface ReactorRepository {
    
    public Reactor findReactorByName(String name);
    public List<Reactor> findReactorsByCountry(String country);
    public void addReactorToRepository(Reactor reactor);
    public void addReactorTypeToRepository(ReactorType reactorType);
    public ReactorType findTypeByClass(String name);
    public List<OperatingHistory> findOperatingHistoryByReactorName(String name);
    public void addOperatingHistoryToRepository(OperatingHistory operatingHistory);
    
    
    
    
    
}
