/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.store;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import model.Subject;
import model.list.Subjects;

/**
 *
 * @author doananhkiet
 */
public class SubjectStore {
    public static void saveToFile(Subjects subjects, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);
        
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (Subject subject: subjects) {
            oos.writeObject(subject);
        }  
        oos.writeObject(Subject.getsID());
        
        oos.flush();
        oos.close();
        fos.close();
    }
    
    public static Subjects loadFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        Subjects subjects = new Subjects();
        
        if (fileName == null || fileName.isEmpty()) {
            return subjects;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis); 
        while (true) {
            try {
                Object obj = ois.readObject();
                if (obj instanceof Integer) {
                    Subject.setsID((Integer) obj);
                } else {
                    Subject subject = (Subject) obj;
                    subjects.add(subject);
                }           
            } catch(EOFException eof) {
                break;
            }
        }
        
        ois.close();
        fis.close();
        
        return subjects;
    }
}
