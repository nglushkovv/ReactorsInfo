/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author 79175
 */
public class YAMLHandler extends Handler {
    @Override
    public Map<String, ReactorType> readFile(File file){
        
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, ReactorType> objects;
            objects = mapper.readValue(file,  new TypeReference<Map<String, ReactorType>>(){});
            return objects;
                
           
        } catch (Exception ex) {
            throw new IllegalArgumentException();
            
        }

    }
    
    
    
    @Override
    public Boolean isSuitableType(String fileName) {
        return "yaml".equals(fileName.substring(fileName.indexOf(".")+1));
    }
    
}
