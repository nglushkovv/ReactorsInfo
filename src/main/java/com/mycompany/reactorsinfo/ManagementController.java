/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo;

import com.mycompany.reactorsinfo.DBUtil.HibernateSessionFactoryUtil;
import com.mycompany.reactorsinfo.handlers.JSONHandler;
import com.mycompany.reactorsinfo.handlers.XMLHandler;
import com.mycompany.reactorsinfo.handlers.YAMLHandler;
import com.mycompany.reactorsinfo.model.ReactorType;
import com.mycompany.reactorsinfo.services.CountryService;
import com.mycompany.reactorsinfo.services.ReactorService;
import com.mycompany.reactorsinfo.web.WebReader;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 79175
 */
public final class ManagementController {
    private final JSONHandler jsonHandler;
    private final XMLHandler xmlHandler;
    private final YAMLHandler yamlHandler;
    private final ReactorService reactorService;
    private final CountryService countryService;
    private final WebReader webReader;
    private Boolean databaseMode = false;
    private TaskRunner taskRunner;
    private String DBPath;
    
    public ManagementController() {
        jsonHandler = new JSONHandler();
        xmlHandler = new XMLHandler();
        yamlHandler = new YAMLHandler();
        reactorService = new ReactorService();
        webReader = new WebReader(reactorService);
        countryService = new CountryService();
        configureHandlers();
    }
    
    public void startDatabaseMode(String mode) throws IOException {
        databaseMode = true;
        Session session = HibernateSessionFactoryUtil.getSessionFactory(DBPath).openSession();
        reactorService.createReactorsRepository(session);
        countryService.createCountryRepository(session);
        taskRunner = new TaskRunner();
        
        switch(mode){

            case "CREATE":
                countryService.fillCountryTable();

                Transaction transaction = session.beginTransaction();
                reactorService.addTypesToRepository();
                reactorService.setCountryRepository(countryService.getRepository());
                webReader.start();
                transaction.commit();
                
                break;
            case "UPDATE":
                reactorService.addTypesToRepository();
                break;
        }
            session.close();
        }
    
    
    
    
    
    
    public void readFile(File file){
       List<ReactorType> list = jsonHandler.handle(file);
       reactorService.addTypesToList(list);
       
       
    }
    
    public void configureHandlers() {
        jsonHandler.setNext(xmlHandler);
        xmlHandler.setNext(yamlHandler);
        
    }
    
    public WebReader getWebReader() {
        return webReader;
    }

    public ReactorService getReactorService() {
        return reactorService;
    }
    
    public TaskRunner getTaskRunner() {
        return taskRunner;
    }
    
    public void setDBPath(String filepath) {
        this.DBPath = filepath;
    }
    
}
