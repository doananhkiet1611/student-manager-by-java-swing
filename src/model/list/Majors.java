package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Major;

public class Majors extends ArrayList<Major> implements Serializable {
    public int indexOfBy(int id) {
        return this.indexOf(new Major(id, ""));
    }
    
    public Major getBy(int id) {
         for (Major major: this) {
            if (major.getId() == id) {
                return major;
            }
        }
        return null;
    }
}
