/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;

/**
 *
 * @author 79175
 */
@Entity
@Getter
@Table(name="OperatingHistory")
@IdClass(OperatingHistoryPK.class)
public class OperatingHistory {
    @Id
    @ManyToOne
    @JoinColumn()
    private Reactor reactor;
    @Id
    private Integer operatingYear;
    @Column(name = "annual_load_factor")
    private Double annualOperatingHistory;
    
    public OperatingHistory(){}
    
    public OperatingHistory(Reactor reactor,
                                   Integer year,
                                   Double annualOperatingHistory) {
        this.reactor = reactor;
        this.operatingYear = year;
        this.annualOperatingHistory = annualOperatingHistory;
        
    }
}
