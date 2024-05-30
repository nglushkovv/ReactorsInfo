package com.mycompany.reactorsinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

/**
 *
 * @author 79175
 */
@Entity
@Getter
@Table(name = "Country")
public class Country {
    @Id
    private String code;
    
    @Column
    private String name;
    
    @Column
    private String region;
    
    public Country(){};
    
    public Country(String code,
                   String name,
                   String region) {
        this.code = code;
        this.name = name;
        this.region = region;
    }
    
}
