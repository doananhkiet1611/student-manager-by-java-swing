package model.store;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Classroom;
import model.Province;
import model.list.Classrooms;
import model.list.Provinces;

public class ProvinceStore {
    public static void saveToFile(Provinces provinces, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);
        
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (Province province: provinces) {
            oos.writeObject(province);
        }  
        oos.writeObject(Province.getsID());
        
        oos.flush();
        oos.close();
        fos.close();
    }
    
    public static Provinces loadFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        Provinces provinces = new Provinces();
        
        if (fileName == null || fileName.isEmpty()) {
            return provinces;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis); 
        while (true) {
            try {
                Object obj = ois.readObject();
                if (obj instanceof Integer) {
                    Province.setsID((Integer) obj);
                } else {
                    Province province = (Province) obj;
                    provinces.add(province);
                }           
            } catch(EOFException eof) {
                break;
            }
        }
        
        ois.close();
        fis.close();
        
        return provinces;
    }
}
