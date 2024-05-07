/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
public class XMLHandler extends Handler {
    private Handler next;
    
    @Override
    public List<ReactorType> handle(File file) {
        List<ReactorType> listOfReactors = new ArrayList<>();
        String fileName = file.getName();
        
        if(isSuitableType(fileName)){
            try {
                XmlMapper mapper = new XmlMapper();
                Map<String, ReactorType> objects;
                objects = mapper.readValue(file, new TypeReference<Map<String, ReactorType>>() {});
                listOfReactors = createObjects(objects, fileName);
            } catch (Exception ex) {
                throw new IllegalArgumentException();
            }
           
        }
        else{
            if(next!=null){
                listOfReactors = next.handle(file);
            }
            
        }
    
    return listOfReactors;
    }
    
    @Override
    public void setNext(Handler handler) {
        next = handler;
    }
    
    @Override
    public Boolean isSuitableType(String fileName) {
        return "xml".equals(fileName.substring(fileName.indexOf(".")+1));
    }
    
}
