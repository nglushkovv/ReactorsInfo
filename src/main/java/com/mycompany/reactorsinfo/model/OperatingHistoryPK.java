/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reactorsinfo.model;

import java.io.Serializable;
import java.util.Objects;
import lombok.Getter;


@Getter
public class OperatingHistoryPK implements Serializable {
   
    private Reactor reactor;
    
    private Integer operatingYear;
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperatingHistoryPK that = (OperatingHistoryPK) o;
        return Objects.equals(reactor, that.reactor) &&
               Objects.equals(operatingYear, that.operatingYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reactor, operatingYear);
    }
}
