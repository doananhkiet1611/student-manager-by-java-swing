package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class Person implements Serializable {

    protected int id;
    protected String fullName;
    protected Date dateOfBirth;
    protected String gender;
    protected String phoneNumber;
    protected Province placeOfOrigin;

    public Person() {

    }

    public Person(String fullName, Date dateOfBirth, String gender, String phoneNumber, Province placeOfOrigin) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.placeOfOrigin = placeOfOrigin;
    }

    public Person(int id, String fullName, Date dateOfBirth, String gender, String phoneNumber, Province placeOfOrigin) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.placeOfOrigin = placeOfOrigin;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Province getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(Province placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }
    
    public String getName() {
        return fullName.substring(fullName.lastIndexOf(" ") + 1);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        return this.getName().equals(other.getName());
    }
    
    
}
