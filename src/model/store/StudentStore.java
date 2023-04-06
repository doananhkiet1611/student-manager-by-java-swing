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
    public static void saveStudentToFile(Students students, String fileName) throws IOException {
        File file = FileGenegator.creatNewFile(fileName);

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for (Student student : students) {
            oos.writeObject(student);
            oos.writeObject(student.getDateOfBirth());
            oos.writeObject(student.getPlaceOfOrigin());
            oos.writeObject(student.getMajor());
            oos.writeObject(student.getClassroom());
        }

        oos.flush();
        oos.close();
        fos.close();
    }

    public static Students loadStudentFromFile(String fileName) throws IOException, ClassNotFoundException {
        Students students = new Students();
        if (fileName == null || fileName.isEmpty()) {
            return students;
        }

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        while (true) {
            try {
                Student student = (Student) ois.readObject();
                Date dateOfBirth = (Date) ois.readObject();
                Province placeOfOrigin = (Province) ois.readObject();
                Major major = (Major) ois.readObject();
                Classroom classroom = (Classroom) ois.readObject();

                student.setDateOfBirth(dateOfBirth);
                student.setPlaceOfOrigin(placeOfOrigin);
                student.setMajor(major);
                student.setClassroom(classroom);
                students.add(student);
            } catch (EOFException eof) {
                break;
            }
        }
        
        ois.close();
        fis.close();
        int lastID = students.get(students.size() - 1).getId();
        Student.setsID(lastID + 1);
        return students;
    }
}