package model.list;

import java.io.Serializable;
import java.util.ArrayList;
import model.Province;

public class Provinces extends ArrayList<Province> {

    public int indexOfBy(int id) {
        Province province = new Province(id, "");
        return this.indexOf(province);
    }
    
    public Province getBy(int id) {
        for (Province province: this) {
            if (province.getId() == id) {
                return province;
            }
        }
        return null;
    }
}
