/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


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
    
    @Column
    private String country;
    @Column
    private String owner;
    @Column
    private String operator;
    @Column
    private Double termalCapacity;
    @Column
    private Double loadFactor;
    
    public Reactor(String name,
                   String type,
                   String status,
                   String location,
                   Integer referenceUnitPower,
                   Integer grossElectricalCapacity,
                   Date firstGridConnection,
                   String owner,
                   String operator,
                   Double termalCapacity,
                   Double loadFactor){
        
        
    }
    
    
    
}
