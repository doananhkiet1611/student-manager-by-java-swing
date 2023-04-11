package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Student;

public class Students extends ArrayList<Student>{

    public boolean removeBy(int id) {
        Student student = null;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                student = this.get(i);
            }
        }
        
        if (student == null) {
            return false;
        }
        
        this.remove(student);
        return true;
    }

    public int indexOfBy(int id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
    
}
