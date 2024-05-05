/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mycompany.reactorsinfo.model.Reactor;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 79175
 */
public class YAMLHandler implements Handler {
    private Handler next;
    
    @Override
    public List<Reactor> handle(File file) {
        List<Reactor> listOfReactors = new ArrayList<>();
        String fileName = file.getName();
        
        if(isSuitableType(fileName)){
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Reactor> objects;
            try {
                objects = mapper.readValue(file,  new TypeReference<Map<String, Reactor>>(){});
            
            for (HashMap.Entry<String, Reactor> entry : objects.entrySet()){
                    Reactor reactor = entry.getValue();
                    reactor.setName(entry.getKey());
                    reactor.setSource(file.getName());
                    listOfReactors.add(reactor);
            }
           
            } catch (Exception ex) {
               throw new IllegalArgumentException();
                    
            }
            
        }
        else{
            throw new IllegalArgumentException();
        }
        return listOfReactors;
    }
    
    @Override
    public void setNext(Handler handler) {
        next = handler;
    }
    
    @Override
    public Boolean isSuitableType(String fileName) {
        return "yaml".equals(fileName.substring(fileName.indexOf(".")+1));
    }
    
}
