package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Classroom;

public class Classrooms extends ArrayList<Classroom> implements Serializable {
    public int indexOfByID(int id) {
        return this.indexOf(new Classroom(id, ""));
    }
}
