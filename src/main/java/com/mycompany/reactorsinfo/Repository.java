/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo;

import com.mycompany.reactorsinfo.model.ReactorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 79175
 */
public class Repository {
    private final List<ReactorType> listOfReactorTypes = new ArrayList<>();
    
    
    public void addTypeToRepository(List<ReactorType> list){
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
    
    public void createReactor(List<String> attributes) {
        for(String s: attributes){
            System.out.println(s);
        }
    }
    
    
}
