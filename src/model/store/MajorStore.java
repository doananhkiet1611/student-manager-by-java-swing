package model.store;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Major;
import model.Province;
import model.list.Majors;
import model.list.Provinces;

public class MajorStore {
    public static void saveToFile(Majors majors, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);
        
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (Major major: majors) {
            oos.writeObject(major);
        }  
        oos.writeObject(Major.getsID());
        
        oos.flush();
        oos.close();
        fos.close();
    }
    
    public static Majors loadFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        Majors majors = new Majors();
        
        if (fileName == null || fileName.isEmpty()) {
            return majors;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis); 
        while (true) {
            try {
                Object obj = ois.readObject();
                if (obj instanceof Integer) {
                    Major.setsID((Integer) obj);
                } else {
                    Major major = (Major) obj;
                    majors.add(major);
                }           
            } catch(EOFException eof) {
                break;
            }
        }
        
        ois.close();
        fis.close();
        
        return majors;
    }
}
