/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;

import com.mycompany.reactorsinfo.model.ReactorType;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 79175
 */
public abstract class Handler {
    Handler next;
    
    public abstract Map<String, ReactorType> readFile(File file);
    
    public abstract Boolean isSuitableType(String filename);
    
    public List<ReactorType> createObjects(Map<String, ReactorType> objects, String fileName) {
        List<ReactorType> listOfReactors = new ArrayList<>();
        for (HashMap.Entry<String, ReactorType> entry : objects.entrySet()){
                    ReactorType reactor = entry.getValue();
                    reactor.setName(entry.getKey());
                    reactor.setSource(fileName);
                    listOfReactors.add(reactor);
            }
        return listOfReactors;
    }
    
    public List<ReactorType> handle(File file){
        List<ReactorType> listOfReactors = new ArrayList<>();
        String fileName = file.getName();
       
        if(isSuitableType(fileName)){
            Map<String, ReactorType> objects = this.readFile(file);
            listOfReactors = createObjects(objects, fileName);
        }
         
        else{
            if(next!=null){
                listOfReactors = next.handle(file);
            }
        }
        return listOfReactors;
    }
    
    public void setNext(Handler handler) {
        next = handler;
    }
}
