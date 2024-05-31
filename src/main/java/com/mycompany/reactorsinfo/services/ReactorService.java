/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.services;


import com.mycompany.reactorsinfo.model.OperatingHistory;
import com.mycompany.reactorsinfo.model.Reactor;
import com.mycompany.reactorsinfo.model.ReactorType;
import com.mycompany.reactorsinfo.repository.CountryRepository;
import com.mycompany.reactorsinfo.repository.ReactorRepository;
import com.mycompany.reactorsinfo.repository.ReactorRepositoryImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author 79175
 */
public class ReactorService {
    private final List<ReactorType> listOfReactorTypes = new ArrayList<>();
    private CountryRepository countryRepository;
    
    private ReactorRepository repository;

    public void createReactorsRepository(Session session) {
        repository = new ReactorRepositoryImpl(session);
    }
    
    public void setCountryRepository(CountryRepository cr) {
        countryRepository = cr;
    }
    
    
    public Reactor createReactor(List<String> attributes) {
        
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
            
            Reactor reactor = new Reactor();
            
            
            reactor.setName(attributes.get(0));
            if(repository.findTypeByClass(attributes.get(1))==null) {
                ReactorType newType = new ReactorType();
                newType.setName(attributes.get(1));
                newType.setReactorsClass(attributes.get(1));
                repository.addReactorTypeToRepository(newType);
                reactor.setType(newType);
                
            } else {
                reactor.setType(repository.findTypeByClass(attributes.get(1)));
            }
            
            reactor.setStatus(attributes.get(2));
            reactor.setLocation( attributes.get(3));
            reactor.setReferenceUnitPower(Integer.valueOf(attributes.get(4)));
            reactor.setGrossElectricalCapacity(Integer.valueOf(attributes.get(5)));
            if(!"".equals(attributes.get(6))){
                reactor.setFirstGridConnection(formatter.parse(attributes.get(6)));
            }
            reactor.setOwner(attributes.get(7));
            reactor.setOperator(attributes.get(8));
            reactor.setTermalCapacity(Double.valueOf(attributes.get(9)));
            reactor.setCountry(countryRepository.findCountryByName(attributes.get(10)));
            
            
            repository.addReactorToRepository(reactor);
            return reactor;
            
        } catch (ParseException ex) {
            Logger.getLogger(ReactorService.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public void createOperatingHistory(Reactor reactor, String[] oH) {
        Integer year = null;
        if (!oH[0].equals("")){
            year = Integer.valueOf(oH[0]);
        }
                
        OperatingHistory operatingHistory;
        if(oH[1] == null) {
            operatingHistory = new OperatingHistory(reactor,
                                                    year,
                                                    null);
        } else{ 
            operatingHistory = new OperatingHistory(reactor,
                                                    year,
                                                    Double.parseDouble(oH[1]));
        }
        repository.addOperatingHistoryToRepository(operatingHistory);
            
        
    }
    
    public void addTypesToRepository() {
        for(ReactorType reactorType: listOfReactorTypes) {
            try{
                repository.addReactorTypeToRepository(reactorType);
            } catch (Exception ex){
                
            }
        }
    }
    

    public void addTypesToList(List<ReactorType> list){
        Boolean key;
        
        for(ReactorType reactor: list){
            key = true;
            for(ReactorType repositoryReactor: listOfReactorTypes){
                if(Arrays.toString(reactor.getAtrributes()).
                        equals(Arrays.toString(repositoryReactor.getAtrributes()))) {
                    key = false;
                }
            }
            
            if(key) listOfReactorTypes.add(reactor);
            
        }
    }

    public List<ReactorType> getListOfReactorTypes() {
        return listOfReactorTypes;
    }
    
    public ReactorRepository getRepository() {
        return repository;
    }
    
    
    
}
