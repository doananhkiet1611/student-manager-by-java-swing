package model;

import java.io.Serializable;

public class Province implements Serializable {
    private int id;
    private String name;
    private static int sID = 1;

    public Province() {
        this.id = sID++;
    }

    public Province(String name) {
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
