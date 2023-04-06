package model;

import java.io.Serializable;

public class Subject implements Serializable {
    private int id;
    private String name;
    private static int sID = 1;
    
    public Subject() {
        this.id = sID++;
    }

    public Subject(String name) {
        this.id = sID++;
        this.name = name;
    }
    
    public Subject(int id, String name) {
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
        if (sID < 1) {
            return;
        }
        Subject.sID = sID;
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
        final Subject other = (Subject) obj;
        return this.id == other.id;
    }
    
}
