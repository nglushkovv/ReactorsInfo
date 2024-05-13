/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author 79175
 */
public class JSONHandler extends Handler{
    
    @Override
    public Map<String, ReactorType> readFile(File file){        
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, ReactorType> objects;
            objects = mapper.readValue(file,  new TypeReference<Map<String, ReactorType>>(){});
            return objects;
                
       } catch (IOException ex) {
            Logger.getLogger(JSONHandler.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException();
        
       }
        
    }
    

    @Override
    public Boolean isSuitableType(String fileName) {
        return "json".equals(fileName.substring(fileName.indexOf(".")+1));
    }
}
    
    



