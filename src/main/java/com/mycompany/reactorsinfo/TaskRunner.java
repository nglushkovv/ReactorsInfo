/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo;

import com.mycompany.reactorsinfo.DBUtil.HibernateSessionFactoryUtil;
import com.mycompany.reactorsinfo.services.CountryService;
import com.mycompany.reactorsinfo.services.ReactorService;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;

/**
 *
 * @author 79175
 */
public class TaskRunner {
    private ReactorService reactorService;
    private CountryService countryService;
    
    public TaskRunner(ReactorService rs, CountryService cs) {
        this.reactorService = rs;
        this.countryService = cs;
    }
    
    public DefaultTableModel prepareTableModel(int type) {
   Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    session.beginTransaction();
    String hql = "";
    String[] columnNames = {};

    switch(type) {
        case 0:
            hql = "SELECT r.country.region AS Страна, oh.operatingYear AS Год, " +
                  "COALESCE(SUM(ROUND((r.termalCapacity / rt.burnup * oh.annualOperatingHistory) / 100, 2)), 0) AS Объем_ежегодного_потребления " +
                  "FROM OperatingHistory oh " +
                  "JOIN oh.reactor r " +
                  "JOIN r.type rt " +
                  "WHERE oh.operatingYear >= 2014 " +
                  "GROUP BY r.country.region, oh.operatingYear " +
                  "ORDER BY r.country.region, oh.operatingYear";
            columnNames = new String[]{"Регион", "Год", "Суммарное потребление"};
            break;
       case 1:
            hql = "SELECT r.country.name AS Страна, oh.operatingYear AS Год, " +
                  "COALESCE(SUM(ROUND((r.termalCapacity / rt.burnup * oh.annualOperatingHistory) / 100, 2)), 0) AS Объем_ежегодного_потребления " +
                  "FROM OperatingHistory oh " +
                  "JOIN oh.reactor r " +
                  "JOIN r.type rt " +
                  "WHERE oh.operatingYear >= 2014 " +
                  "GROUP BY r.country.name, oh.operatingYear " +
                  "ORDER BY r.country.name, oh.operatingYear";
            columnNames = new String[] {"Страна", "Год", "Объем_ежегодного_потребления"};
            break;



        case 2:
            hql = "SELECT r.operator AS Страна, oh.operatingYear AS Год, " +
                  "COALESCE(SUM(ROUND((r.termalCapacity / rt.burnup * oh.annualOperatingHistory) / 100, 2)), 0) AS Объем_ежегодного_потребления " +
                  "FROM OperatingHistory oh " +
                  "JOIN oh.reactor r " +
                  "JOIN r.type rt " +
                  "WHERE oh.operatingYear >= 2014 " +
                  "GROUP BY r.operator, oh.operatingYear " +
                  "ORDER BY r.operator, oh.operatingYear";
            columnNames = new String[] {"Компания","Год" , "Суммарное потребление"};
            break;
        case 3:
            hql = "SELECT r.name AS Страна, oh.operatingYear AS Год, " +
                  "COALESCE(SUM(ROUND((r.termalCapacity / rt.burnup * oh.annualOperatingHistory) / 100, 2)), 0) AS Объем_ежегодного_потребления " +
                  "FROM OperatingHistory oh " +
                  "JOIN oh.reactor r " +
                  "JOIN r.type rt " +
                  "WHERE oh.operatingYear >= 2014 " +
                  "GROUP BY r.name, oh.operatingYear " +
                  "ORDER BY r.name, oh.operatingYear";
            columnNames = new String[] {"Реактор","Год" , "Суммарное потребление"};
            break;
    }
    List<Object[]> results = session.createQuery(hql).getResultList();
    session.getTransaction().commit();
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    for (Object[] row : results) {
        model.addRow(row);
    }
    session.close();
    return model; 
    
    
}
}
