package model.list;

import java.util.ArrayList;
import model.Subject;

public class Subjects extends ArrayList<Subject> {
    public int findLargestID() {
        if (this.isEmpty()) {
            return 0;
        }
        
        int lagestID = this.get(0).getId();
        for (int i = 1; i < this.size(); i++) {
            int currentID = this.get(i).getId();
            if (currentID > lagestID) {
                lagestID = currentID;
            }
        }
        return lagestID;
    }
    
    public int indexOfByID(int id) {
        return this.indexOf(new Subject(id, ""));
    }
}
