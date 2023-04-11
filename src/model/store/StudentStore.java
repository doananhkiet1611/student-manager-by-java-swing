package model.store;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import model.Classroom;
import model.Major;
import model.Province;
import model.Student;
import model.list.Students;

public class StudentStore {

    public static void saveToFile(Students students, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Student student : students) {
            oos.writeObject(student.getId());
            oos.writeObject(student.getFullName());
            oos.writeObject(student.getDateOfBirth());
            oos.writeObject(student.getGender());
            oos.writeObject(student.getPhoneNumber());
            oos.writeObject(student.getPlaceOfOrigin());
            oos.writeObject(student.getMajor());
            oos.writeObject(student.getClassroom());
        }
        oos.writeObject(Student.getsID());

        oos.flush();
        oos.close();
        fos.close();
    }

    public static Students loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        Students students = new Students();
        if (fileName == null || fileName.isEmpty()) {
            return students;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        while (true) {
            int id = 1;
            try {
                id = (Integer) ois.readObject();
                String fullName = (String) ois.readObject();
                Date dateOfBirth = (Date) ois.readObject();
                String gender = (String) ois.readObject();
                String phoneNumber = (String) ois.readObject();
                Province placeOfOrigin = (Province) ois.readObject();
                Major major = (Major) ois.readObject();
                Classroom classroom = (Classroom) ois.readObject();
                
                Student student = new Student(id, fullName, dateOfBirth, gender, phoneNumber, placeOfOrigin, major, classroom);
                students.add(student);
            } catch (EOFException eof) {
                Student.setsID(id);
                break;
            } finally {
                
            }
        }
        
        ois.close();
        fis.close();
        
        return students;
    }
}
