package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Province;

public class Provinces extends ArrayList<Province> {

    public int indexOfByID(int id) {
        Province province = new Province(id, "");
        return this.indexOf(province);
    }
    
}
