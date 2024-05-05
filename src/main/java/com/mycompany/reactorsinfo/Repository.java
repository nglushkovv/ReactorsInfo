/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo;

import com.mycompany.reactorsinfo.model.Reactor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 79175
 */
public class Repository {
    private final List<Reactor> listOfReactors = new ArrayList<>();
    
    public Reactor findByName(String name){
        return null;
    }
    
    public void addToRepository(List<Reactor> list){
        Boolean key;
        
        for(Reactor reactor: list){
            key = true;
            for(Reactor repositoryReactor: listOfReactors){
                if(Arrays.toString(reactor.getAtrributes()).
                        equals(Arrays.toString(repositoryReactor.getAtrributes()))) {
                    key = false;
                }
            }
            
            if(key) listOfReactors.add(reactor);
            
        }
    }
    
    public List<Reactor> getListOfReactors() {
        return listOfReactors;
    }
    
    
}
