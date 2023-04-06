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
import model.Classroom;
import model.list.Classrooms;

/**
 *
 * @author doananhkiet
 */
public class ClassroomStore {
    public static void saveToFile(Classrooms classrooms, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);
        
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (Classroom classroom: classrooms) {
            oos.writeObject(classroom);
        }  
        oos.writeObject(Classroom.getsID());
        
        oos.flush();
        oos.close();
        fos.close();
    }
    
    public static Classrooms loadFromFile(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        Classrooms classrooms = new Classrooms();
        
        if (fileName == null || fileName.isEmpty()) {
            return classrooms;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis); 
        while (true) {
            try {
                Object obj = ois.readObject();
                if (obj instanceof Integer) {
                    Classroom.setsID((Integer) obj);
                } else {
                    Classroom classroom = (Classroom) obj;
                    classrooms.add(classroom);
                }           
            } catch(EOFException eof) {
                break;
            }
        }
        
        ois.close();
        fis.close();
        
        return classrooms;
    }
}
