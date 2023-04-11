package model;

import model.list.Results;
import java.io.Serializable;
import java.util.Date;

public class Student extends Person implements Serializable {
    private static int sID = 1;

    private Major major;
    private Classroom classroom;
//    private Results results;
    
    public Student() {
        super();
        this.id = sID++;
    }
    
    public Student(String fullName, Date dateOfBirth, String gender, String phoneNumber, Province placeOfOrigin, Major major, Classroom classroom) {
        super(fullName, dateOfBirth, gender, phoneNumber, placeOfOrigin);
        this.major = major;
        this.classroom = classroom;
        this.id = sID++;
    }
    
    public Student(int id, String fullName, Date dateOfBirth, String gender, String phoneNumber, Province placeOfOrigin, Major major, Classroom classroom) {
        super(id, fullName, dateOfBirth, gender, phoneNumber,placeOfOrigin);
        this.major = major;
        this.classroom = classroom;
    }

    public static int getsID() {
        return sID;
    }

    public static void setsID(int sID) {
        Student.sID = sID;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
