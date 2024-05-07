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
    
    public abstract List<ReactorType> handle(File file);
    
    public abstract void setNext(Handler handler);
    
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
}
