/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo;

import com.mycompany.reactorsinfo.handlers.JSONHandler;
import com.mycompany.reactorsinfo.handlers.XMLHandler;
import com.mycompany.reactorsinfo.handlers.YAMLHandler;
import com.mycompany.reactorsinfo.model.ReactorType;
import com.mycompany.reactorsinfo.web.WebReader;
import java.io.File;
import java.util.List;

/**
 *
 * @author 79175
 */
public final class ManagementController {
    private final JSONHandler jsonHandler;
    private final XMLHandler xmlHandler;
    private final YAMLHandler yamlHandler;
    private final Repository repository;
    private final WebReader webReader;
    
    public ManagementController() {
        jsonHandler = new JSONHandler();
        xmlHandler = new XMLHandler();
        yamlHandler = new YAMLHandler();
        repository = new Repository();
        webReader = new WebReader();
        
        configureHandlers();
    }
    
    public void readFile(File file){
       List<ReactorType> list = jsonHandler.handle(file);
       repository.addToRepository(list);
       
    }
    
    public void configureHandlers() {
        jsonHandler.setNext(xmlHandler);
        xmlHandler.setNext(yamlHandler);
        
    }
    
    public Repository getRepository() {
        return repository;
    }
    
    public WebReader getWebReader() {
        return webReader;
    }
    
    
}
