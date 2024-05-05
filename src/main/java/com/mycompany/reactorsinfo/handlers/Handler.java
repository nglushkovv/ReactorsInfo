/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.reactorsinfo.handlers;

import com.mycompany.reactorsinfo.model.Reactor;
import java.io.File;
import java.util.List;

/**
 *
 * @author 79175
 */
public interface Handler {
    
    public List<Reactor> handle(File file);
    
    public void setNext(Handler handler);
    
    public Boolean isSuitableType(String filename);
}
