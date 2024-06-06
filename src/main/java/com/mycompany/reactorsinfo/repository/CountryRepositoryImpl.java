/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.repository;

import com.mycompany.reactorsinfo.model.Country;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 79175
 */
public class CountryRepositoryImpl implements CountryRepository {
    private final Session session;
    
    public CountryRepositoryImpl (Session session) {
        this.session = session;
    }

    @Override
    public Country findCountryByCode(String code) {
        return session.find(Country.class, code);
    }

    @Override
    public Country findCountryByName(String name) {
        TypedQuery<Country> query = session.createQuery("FROM Country C WHERE C.name = :name", Country.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Country> findCountriesByRegion(String region) {
        TypedQuery<Country> query = session
                .createQuery("FROM Country C WHERE C.region = :region", Country.class);
        query.setParameter("region", region);
        return query.getResultList();
    }
    
    @Override
    public void addCountryToRepository(Country country) {
        try {
            Transaction transaction = session.beginTransaction();
            session.persist(country);
            transaction.commit();
        } catch (Exception ex) {
         
        }
        
    }
    
}
