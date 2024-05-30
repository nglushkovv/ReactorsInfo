/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.repository;

import com.mycompany.reactorsinfo.model.OperatingHistory;
import com.mycompany.reactorsinfo.model.Reactor;
import com.mycompany.reactorsinfo.model.ReactorType;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author 79175
 */
public class ReactorRepositoryImpl implements ReactorRepository{
    private final Session session; 
    
    public ReactorRepositoryImpl(Session session) {
        this.session = session;
    }

    @Override
    public Reactor findReactorByName(String name) {
        return session.find(Reactor.class, name);
    }

    @Override
    public List<Reactor> findReactorsByCountry(String country) {
        TypedQuery<Reactor> query = session.createQuery("FROM Reactor R WHERE R.country = :country", Reactor.class);
        query.setParameter("country", country);
        return query.getResultList();
    }
    
    @Override
    public ReactorType findTypeByClass(String name) {
        return session.find(ReactorType.class, name);
    }
    
    @Override
    public void addReactorToRepository(Reactor reactor){
        try{
            if(findReactorByName(reactor.getName()) == null) {
                session.persist(reactor);
            }
        } catch (Exception ex) {
            
        }
    }
    @Override
    public void addReactorTypeToRepository(ReactorType reactorType) {
        try {
            
            if(findTypeByClass(reactorType.getReactorClass()) == null){
                session.persist(reactorType);}
            
        } catch (Exception ex){

        }
    }
    
    @Override
    public List<OperatingHistory> findOperatingHistoryByReactorName(String name) {
        TypedQuery<OperatingHistory> query = session.createQuery(
        "FROM OperatingHistory OH WHERE OH.reactor.name = :name", 
        OperatingHistory.class
        );
        query.setParameter("name", name);
        return query.getResultList();
    }
    
    public void addOperatingHistoryToRepository(OperatingHistory operatingHistory) {
        try {
            session.persist(operatingHistory);
        } catch (Exception ex){
        }
    }
    
}
