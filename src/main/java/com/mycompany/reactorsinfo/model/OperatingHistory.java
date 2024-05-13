/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.model;

import java.time.Year;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 79175
 */
@Entity
@Table(name="OperatingHistory")
public class OperatingHistory {
    @Id
    @OneToMany
    @JoinColumn(name = "reactor")
    private Reactor reactor;
    @Id
    private Year year;
    @Column(name = "annual_load_factor")
    private Double annualLoadFactor;
    
    public OperatingHistory(Reactor reactor,
                                   Year year,
                                   Double annualLoadFactor) {
        this.reactor = reactor;
        this.year = year;
        this.annualLoadFactor = annualLoadFactor;
        
    }
}
