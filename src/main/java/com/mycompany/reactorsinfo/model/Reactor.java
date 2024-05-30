/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;



/**
 *
 * @author 79175
 */
@Data
@Entity
@Table(name = "Reactor")
public class Reactor {

    @Id
    private String name;

    @ManyToOne()
    @JoinColumn(name = "class")
    
    private ReactorType type;

    @Column
    private String status;

    @Column
    private String location;

    @Column
    private Integer referenceUnitPower;
    
    @Column
    private Integer grossElectricalCapacity;
    
    @Column
    private Date firstGridConnection;
    
    @ManyToOne
    @JoinColumn(name = "country")
    private Country country;
    @Column
    private String owner;
    @Column
    private String operator;
    @Column
    private Double termalCapacity;

    public Reactor() {}
    
    public Reactor(String name,
                   ReactorType type,
                   String status,
                   String location,
                   Integer referenceUnitPower,
                   Integer grossElectricalCapacity,
                   Date firstGridConnection,
                   String owner,
                   String operator,
                   Double termalCapacity,
                   Country country
                   ){
        this.name = name;
        this.type = type;
        this.status = status;
        this.location = location;
        this.referenceUnitPower = referenceUnitPower;
        this.grossElectricalCapacity = grossElectricalCapacity;
        this.firstGridConnection = firstGridConnection;
        this.owner = owner;
        this.operator = operator;
        this.termalCapacity = termalCapacity;
        this.country = country;
        
    }
    
    
    
}
