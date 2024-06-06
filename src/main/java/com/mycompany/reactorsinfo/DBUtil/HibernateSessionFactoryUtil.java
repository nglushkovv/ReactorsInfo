/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.DBUtil;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author 79175
 */
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory(String DBPath) {
        if (sessionFactory == null) {
            
            try {
                Configuration configuration;
                if(DBPath == null) 
                    configuration = new Configuration().configure();
                else {

                configuration = new Configuration().configure()
                    .setProperty("hibernate.connection.url", "jdbc:h2:" +
                            DBPath.substring(0, (DBPath.indexOf("."))))
                        .setProperty("hibernate.hbm2ddl.auto", "update");
                            
                
                }
               
                
                sessionFactory = configuration.buildSessionFactory();
                sessionFactory.getCache().evictAllRegions();


            } catch (HibernateException e) {
                throw new RuntimeException();
            }
        }
        return sessionFactory;
    }
    
    
    

     
}
