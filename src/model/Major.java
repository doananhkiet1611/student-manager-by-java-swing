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
    private static int sID = 1;
    
    public Major() {
        this.id = sID++;
    }

    public Major(String name) {
        this.id = sID++;
        this.name = name;
    }
    
    public Major(int id, String name) {
        this.id = id;
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

    public static int getsID() {
        return sID;
    }

    public static void setsID(int sID) {
        Major.sID = sID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Major other = (Major) obj;
        return this.id == other.id;
    }
    
}
