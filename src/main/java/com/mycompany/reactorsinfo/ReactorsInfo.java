/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reactorsinfo;

/**
 *
 * @author 79175
 */
public class ReactorsInfo {

    public static void main(String[] args) {
        UserGUI gui = new UserGUI(new ManagementController());
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        gui.setTitle("ReactorsInfo");
    }
}
