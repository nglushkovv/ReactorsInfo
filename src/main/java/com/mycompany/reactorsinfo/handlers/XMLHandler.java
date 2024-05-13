/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.io.File;
import java.util.Map;


/**
 *
 * @author 79175
 */
public class XMLHandler extends Handler {
    
    @Override
    public Map<String, ReactorType> readFile(File file) {
            try {
                XmlMapper mapper = new XmlMapper();
                Map<String, ReactorType> objects;
                objects = mapper.readValue(file, new TypeReference<Map<String, ReactorType>>() {});
                return objects;
            } catch (Exception ex) {
                throw new IllegalArgumentException();
            }
    }

    
    
    @Override
    public Boolean isSuitableType(String fileName) {
        return "xml".equals(fileName.substring(fileName.indexOf(".")+1));
    }
    
}
