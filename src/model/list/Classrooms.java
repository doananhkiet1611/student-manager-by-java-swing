package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Classroom;
import model.Province;

public class Classrooms extends ArrayList<Classroom> implements Serializable {
    public int indexOfBy(int id) {
        return this.indexOf(new Classroom(id, ""));
    }
    
    public Classroom getBy(int id) {
         for (Classroom classroom: this) {
            if (classroom.getId() == id) {
                return classroom;
            }
        }
        return null;
    }
}
