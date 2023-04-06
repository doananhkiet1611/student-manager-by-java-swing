/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author doananhkiet
 */
public class Major implements Serializable {
    private int id;
    private String name;
    private static int sID = 0;
    
    public Major() {
        this.id = sID++;
    }

    public Major(String name) {
        this.id = sID++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
