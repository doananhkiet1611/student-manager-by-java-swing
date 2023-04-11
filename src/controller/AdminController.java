package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import model.Classroom;
import model.Major;
import model.Province;
import model.Student;
import model.Subject;
import model.list.Classrooms;
import model.list.Majors;
import model.list.Provinces;
import model.list.Students;
import model.list.Subjects;
import model.store.ClassroomStore;
import model.store.FileName;
import model.store.MajorStore;
import model.store.ProvinceStore;
import model.store.StudentStore;
import model.store.SubjectStore;
import view.ClassroomView;
import view.SubjectView;
import view.AdminHomeView;
import view.MajorView;
import view.ProvinceView;
import view.StudentView;

public class AdminController implements ActionListener {

    private Subjects subjects;
    private AdminHomeView homeView;
    private SubjectView subjectView;
    private Classrooms classrooms;
    private ClassroomView classroomView;
    private Provinces provinces;
    private ProvinceView provinceView;

    private Majors majors;
    private MajorView majorView;

    private Students students;
    private StudentView studentView;

    public void setClassroomView(ClassroomView classroomView) {
        this.classroomView = classroomView;
    }

    public AdminController() {

    }

    private int getFisrtIntegerFromString(String str, char separate) {
        String strID = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == separate) {
                break;
            } else {
                strID = strID + ch;
            }
        }
        return Integer.parseInt(strID);
    }

    private String getFormarteDate(Date date){
        String formartedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);
        if (formartedDate.equals("01/01/0001")) {
            return "";
        } else {
            return formartedDate;
        }
    }
    
    public void initHomeView() {
        homeView = new AdminHomeView(this);

        try {
            subjects = SubjectStore.loadFromFile(FileName.subject);
        } catch (IOException | ClassNotFoundException ex) {
            subjects = new Subjects();
        }

        try {
            classrooms = ClassroomStore.loadFromFile(FileName.classroom);
        } catch (IOException | ClassNotFoundException ex) {
            classrooms = new Classrooms();
        }

        try {
            provinces = ProvinceStore.loadFromFile(FileName.province);
        } catch (IOException | ClassNotFoundException ex) {
            provinces = new Provinces();
        }

        try {
            majors = MajorStore.loadFromFile(FileName.major);
        } catch (IOException | ClassNotFoundException ex) {
            majors = new Majors();
        }

        try {
            students = StudentStore.loadFromFile(FileName.student);
        } catch (IOException | ClassNotFoundException ex) {
            students = new Students();
        }

        showSubjectOnTable(subjects);
        showClassroomOnTable(classrooms);
        showProvinceOnTable(provinces);
        showMajorOnTable(majors);
        showStudentOnTable(students);
    }

    /**
     * * Begin: Subject **
     */
    private void initInsertSubjectView(AdminHomeView homeView) {
        subjectView = new SubjectView(homeView, true, this);
        subjectView.getiID().setText(Subject.getsID() + "");
        subjectView.setVisible(true);
    }

    private void initUpdateSubjectView(AdminHomeView homeView) {
        subjectView = new SubjectView(homeView, true, this);
        subjectView.getBtnAccept().setText("UPDATE");
    }

    private Subject insertSubject() {
        String name = subjectView.getiName().getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Subject name cannot be left blank", name, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Subject subject = new Subject(name);
        subjects.add(subject);
        return subject;
    }

    private void deleteSubject() {
        int[] indexOfRows = homeView.getSubjectTable().getSelectedRows();

        //get id of selected rows
        int[] idOfSubjects = new int[indexOfRows.length];
        int idOfSubjectsIndex = 0;
        for (int rowIndex : indexOfRows) {
            int id = (int) homeView.getSubjectTable().getModel().getValueAt(rowIndex, 0);
            idOfSubjects[idOfSubjectsIndex] = id;
            idOfSubjectsIndex++;
        }

        // delete by id
        for (int subjectID : idOfSubjects) {
            Subject subject = new Subject(subjectID, "");
            subjects.remove(subject);
        }
    }

    private String updateSubject(int indexSubjectOnSubjects) {
        String newName = subjectView.getiName().getText().trim();
        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Subject name cannot be left blank");
        }

        // update subject on subjects
        subjects.get(indexSubjectOnSubjects).setName(newName);

        return newName;
    }

    private void filterSubject() {
        String filterName = homeView.getISubjectFilter().getText().trim();
        if (filterName.isEmpty()) {
            showSubjectOnTable(this.subjects);
            return;
        }

        Subjects tempSubjects = new Subjects();
        for (Subject subject : subjects) {
            String currentName = subject.getName();
            if (currentName.toLowerCase().contains(filterName.toLowerCase())) {
                tempSubjects.add(subject);
            }
        }
        
        showSubjectOnTable(tempSubjects);
    }

    // sort on table
    private void sortSubjectAscendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getSubjectTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o1.get(1).toString().compareToIgnoreCase(o2.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortSubjectDescendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getSubjectTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o2.get(1).toString().compareToIgnoreCase(o1.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortSubjectAscendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getSubjectTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o1.get(0) - (Integer) o2.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortSubjectDescendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getSubjectTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o2.get(0) - (Integer) o1.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    private void showSubjectOnTable(Subjects subjects) {
        if (subjects == null) {
            return;
        }

        //add row data to table
        DefaultTableModel tableModel = (DefaultTableModel) homeView.getSubjectTable().getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[2];
        for (Subject subject : subjects) {
            row[0] = subject.getId();
            row[1] = subject.getName();
            tableModel.addRow(row);
        }
    }

    /**
     * * End: Subject **
     */
    /**
     * * Begin: Classroom **
     */
    private void initInsertClassroomView(AdminHomeView homeView) {
        classroomView = new ClassroomView(homeView, true, this);
        classroomView.getiID().setText(Classroom.getsID() + "");
        classroomView.setVisible(true);
    }

    private Classroom insertClassroom() {
        String name = classroomView.getiName().getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Class name cannot be left blank", name, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Classroom classroom = new Classroom(name);
        classrooms.add(classroom);
        return classroom;
    }

    private void deleteClassroom() {
        int[] indexOfRows = homeView.getClassroomTable().getSelectedRows();

        //get id of selected rows
        int[] idArray = new int[indexOfRows.length];
        int idIndex = 0;
        for (int rowIndex : indexOfRows) {
            int id = (int) homeView.getClassroomTable().getModel().getValueAt(rowIndex, 0);
            idArray[idIndex] = id;
            idIndex++;
        }

        // delete by id
        for (int id : idArray) {
            Classroom classroom = new Classroom(id, "");
            classrooms.remove(classroom);
        }
    }

    private void initUpdateClassroomView(AdminHomeView homeView) {
        classroomView = new ClassroomView(homeView, true, this);
        classroomView.getBtnAccept().setText("UPDATE");
    }

    private String updateClassroom(int classroomIndex) {
        String newName = classroomView.getiName().getText().trim();
        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Class name cannot be left blank");
        }

        // update classroom on classrooms
        classrooms.get(classroomIndex).setName(newName);

        return newName;
    }

    private void filterClassroom() {
        String filterName = homeView.getiClassroomFilter().getText().trim();
        if (filterName.isEmpty()) {
            showClassroomOnTable(classrooms);
            return;
        }
        
        Classrooms tempClassrooms = new Classrooms();
        for (Classroom classroom : classrooms) {
            String currentName = classroom.getName();
            if (classroom.getName().toLowerCase().contains(filterName.toLowerCase())) {
                tempClassrooms.add(classroom);
            }
        }
        
        showClassroomOnTable(tempClassrooms);
    }

    // sort on table
    private void sortClassroomAscendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getClassroomTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o1.get(1).toString().compareToIgnoreCase(o2.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortClassroomDescendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getClassroomTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o2.get(1).toString().compareToIgnoreCase(o1.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortClassroomAscendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getClassroomTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o1.get(0) - (Integer) o2.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortClassroomDescendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getClassroomTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o2.get(0) - (Integer) o1.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    private void showClassroomOnTable(Classrooms classrooms) {
        if (classrooms == null) {
            return;
        }

        //add row data to table
        DefaultTableModel tableModel = (DefaultTableModel) homeView.getClassroomTable().getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[2];
        for (Classroom classroom : classrooms) {
            row[0] = classroom.getId();
            row[1] = classroom.getName();
            tableModel.addRow(row);
        }
    }

    /**
     * * End: Classroom**
     */
    /**
     * * Begin: Province **
     */
    private void initInsertProvinceView(AdminHomeView homeView) {
        provinceView = new ProvinceView(homeView, true, this);
        provinceView.getiID().setText(Province.getsID() + "");
        provinceView.setVisible(true);
    }

    private Province insertProvince() {
        String name = provinceView.getiName().getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Province name cannot be left blank", name, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Province province = new Province(name);
        provinces.add(province);
        return province;
    }

    private void deleteProvince() {
        int[] indexOfRows = homeView.getProvinceTable().getSelectedRows();

        //get id of selected rows
        int[] idArray = new int[indexOfRows.length];
        int idIndex = 0;
        for (int rowIndex : indexOfRows) {
            int id = (int) homeView.getProvinceTable().getModel().getValueAt(rowIndex, 0);
            idArray[idIndex] = id;
            idIndex++;
        }

        // delete by id
        for (int id : idArray) {
            Province province = new Province(id, "");
            provinces.remove(province);
        }
    }

    private void initUpdateProvinceView(AdminHomeView homeView) {
        provinceView = new ProvinceView(homeView, true, this);
        provinceView.getBtnAccept().setText("UPDATE");
    }

    private String updateProvince(int provinceIndex) {
        String newName = provinceView.getiName().getText().trim();
        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Province name cannot be left blank");
        }

        // update province on provinces
        provinces.get(provinceIndex).setName(newName);

        return newName;
    }

    private void filterProvince() {
        String filterName = homeView.getiProvinceFilter().getText().trim();
        if (filterName.isEmpty()) {
            showProvinceOnTable(provinces);
            return;
        }

        Provinces tempProvinces = new Provinces();
        for (Province province : provinces) {
            String currentName = province.getName();
            if (currentName.toLowerCase().contains(filterName.toLowerCase())) {
                tempProvinces.add(province);
            }
        }
        
        showProvinceOnTable(tempProvinces);
    }

    // sort on table
    private void sortProvinceAscendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getProvinceTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o1.get(1).toString().compareToIgnoreCase(o2.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortProvinceDescendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getProvinceTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o2.get(1).toString().compareToIgnoreCase(o1.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortProvinceAscendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getProvinceTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o1.get(0) - (Integer) o2.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortProvinceDescendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getProvinceTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o2.get(0) - (Integer) o1.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    private void showProvinceOnTable(Provinces provinces) {
        if (provinces == null) {
            return;
        }
        
        //add row data into table
        DefaultTableModel tableModel = (DefaultTableModel) homeView.getProvinceTable().getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[2];
        for (Province province : provinces) {
            row[0] = province.getId();
            row[1] = province.getName();
            tableModel.addRow(row);
        }
    }

    /**
     * * End: Province**
     */
    /**
     * * Begin: Major**
     */
    private void initInsertMajorView(AdminHomeView homeView) {
        majorView = new MajorView(homeView, true, this);
        majorView.getiID().setText(Major.getsID() + "");
        majorView.setVisible(true);
    }

    private Major insertMajor() {
        String name = majorView.getiName().getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Major name cannot be left blank", name, JOptionPane.INFORMATION_MESSAGE);
            return null;
        }
        Major major = new Major(name);
        majors.add(major);
        return major;
    }

    private void deleteMajor() {
        int[] indexOfRows = homeView.getMajorTable().getSelectedRows();

        //get id of selected rows
        int[] idArray = new int[indexOfRows.length];
        int idIndex = 0;
        for (int rowIndex : indexOfRows) {
            int id = (int) homeView.getMajorTable().getModel().getValueAt(rowIndex, 0);
            idArray[idIndex] = id;
            idIndex++;
        }

        // delete by id
        for (int id : idArray) {
            Major major = new Major(id, "");
            majors.remove(major);
        }
    }

    private void initUpdateMajorView(AdminHomeView homeView) {
        majorView = new MajorView(homeView, true, this);
        majorView.getBtnAccept().setText("UPDATE");
    }

    private String updateMajor(int majorIndex) {
        String newName = majorView.getiName().getText().trim();
        if (newName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Major name cannot be left blank");
        }

        // update major on majors
        majors.get(majorIndex).setName(newName);

        return newName;
    }

    private void filterMajor() {
        String filterName = homeView.getiMajorFilter().getText().trim();
        if (filterName.isEmpty()) {
            showMajorOnTable(majors);
            return;
        }

        Majors tempMajors = new Majors();
        for (Major major : majors) {
            String currentName = major.getName();
            if (currentName.toLowerCase().contains(filterName.toLowerCase())) {
                tempMajors.add(major);
            }
        }
        
        showMajorOnTable(tempMajors);
    }

    // sort on table
    private void sortMajorAscendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getMajorTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o1.get(1).toString().compareToIgnoreCase(o2.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortMajorDescendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getMajorTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return o2.get(1).toString().compareToIgnoreCase(o1.get(1).toString());
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortMajorAscendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getMajorTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o1.get(0) - (Integer) o2.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortMajorDescendingByID() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getMajorTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                return (Integer) o2.get(0) - (Integer) o1.get(0);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    private void showMajorOnTable(Majors majors) {
        if (majors == null) {
            return;
        }

        //add row data into table
        DefaultTableModel tableModel = (DefaultTableModel) homeView.getMajorTable().getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[2];
        for (Major major : majors) {
            row[0] = major.getId();
            row[1] = major.getName();
            tableModel.addRow(row);
        }
    }

    /**
     * * End: Major**
     */

    /**
     * * Begin: Student **
     */
    private void initInsertStudentView(AdminHomeView homeView) {
        studentView = new StudentView(homeView, true, this);
        studentView.getiID().setText(Student.getsID() + "");

        for (Province province : provinces) {
            studentView.getCbPlaceOfOrigin().addItem(province.getId() + ": " + province.getName());
        }

        for (Major major : majors) {
            studentView.getCbMajor().addItem(major.getId() + ": " + major.getName());
        }

        for (Classroom classroom : classrooms) {
            studentView.getCbClass().addItem(classroom.getId() + ": " + classroom.getName());
        }

        studentView.setVisible(true);
    }

    private Student insertStudent() {
        String fullName = studentView.getiFullname().getText().trim();
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Full name cannot be left blank", "Error", JOptionPane.INFORMATION_MESSAGE);
            return null;
        }

        Date dateOfBirth = null;
        String strDateOfBirth = studentView.getiDateOfBirth().getText().trim();
        if (strDateOfBirth.isEmpty()) {
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yy").parse("01/01/01");
            } catch (ParseException ex) {

            }
        } else {
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(strDateOfBirth);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(homeView, "Invalid date of birth", "Error", JOptionPane.INFORMATION_MESSAGE);
                return null;
            }
        }

        String gender = "";
        if (studentView.getRdoMale().isSelected()) {
            gender = studentView.getRdoMale().getText().trim();
        } else if (studentView.getRdoFemale().isSelected()) {
            gender = studentView.getRdoFemale().getText().trim();
        }

        String phoneNumber = studentView.getiPhoneNumber().getText().trim();

        String strPlaceOfOrigin = studentView.getCbPlaceOfOrigin().getSelectedItem().toString();
        int id = getFisrtIntegerFromString(strPlaceOfOrigin, ':');
        Province placeOfOrigin = provinces.getBy(id);
        if (placeOfOrigin == null) {
            JOptionPane.showMessageDialog(homeView, "Place of origin is not exist", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String strMajor = studentView.getCbMajor().getSelectedItem().toString();
        id = getFisrtIntegerFromString(strMajor, ':');
        Major major = majors.getBy(id);
        if (major == null) {
            JOptionPane.showMessageDialog(homeView, "Major is not exist", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String strClassroom = studentView.getCbClass().getSelectedItem().toString();
        id = getFisrtIntegerFromString(strClassroom, ':');
        Classroom classroom = classrooms.getBy(id);
        if (classroom == null) {
            JOptionPane.showMessageDialog(homeView, "Class is not exist", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Student student = new Student(fullName, dateOfBirth, gender, phoneNumber, placeOfOrigin, major, classroom);
        students.add(student);
        return student;
    }

    private void deleteStudent() {
        int[] indexOfRows = homeView.getStudentTable().getSelectedRows();

        //get id of selected rows
        int[] idArray = new int[indexOfRows.length];
        int idIndex = 0;
        for (int rowIndex : indexOfRows) {
            int id = (int) homeView.getStudentTable().getModel().getValueAt(rowIndex, 1);
            idArray[idIndex] = id;
            idIndex++;
        }

        // delete by id
        for (int id : idArray) {
            System.out.println(id);
            students.removeBy(id);
        }
    }

    private void initUpdateStudentView(AdminHomeView homeView) {
        studentView = new StudentView(homeView, true, this);
        studentView.getBtnAccept().setText("UPDATE");
    }

    private Student updateStudent(int studentIndex) {
        // full name
        String fullName = studentView.getiFullname().getText().trim();
        if (fullName.isEmpty()) {
            JOptionPane.showMessageDialog(homeView, "Full name cannot be left blank");
            return null;
        }
        
        // date of birth
        Date dateOfBirth = null;
        String strDateOfBirth = studentView.getiDateOfBirth().getText().trim();;
        if (strDateOfBirth.isEmpty()) {
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/0001");
            } catch (ParseException ex) {

            }
        } else {
            try {
                dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(strDateOfBirth);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(homeView, "Invalid date of birth");
                return null;
            }
        }
        
        //gender
        String gender = "";
        Enumeration enumGender = studentView.getBtnGroupGender().getElements();
        while (enumGender.hasMoreElements()) {
            AbstractButton abstractButton = (AbstractButton) enumGender.nextElement();
            if (abstractButton.isSelected()) {
                gender = abstractButton.getText();
            }
        }

        //phone number
        String phoneNumber = studentView.getiPhoneNumber().getText();

        // province
        String selectedPlaceOfOrigin = (String) studentView.getCbPlaceOfOrigin().getSelectedItem();
        String[] stringArrayPlaceOfOrigin = selectedPlaceOfOrigin.split(": ");
        Province province = new Province(Integer.parseInt(stringArrayPlaceOfOrigin[0]), stringArrayPlaceOfOrigin[1]);

        // Major
        String selectedMajor = (String) studentView.getCbMajor().getSelectedItem();
        String[] stringArrayMajor = selectedMajor.split(": ");
        Major major = new Major(Integer.parseInt(stringArrayMajor[0]), stringArrayMajor[1]);

        // Class
        String selectedClass = (String) studentView.getCbClass().getSelectedItem();
        String[] stringArrayClass = selectedClass.split(": ");
        Classroom classroom = new Classroom(Integer.parseInt(stringArrayClass[0]), stringArrayClass[1]);

        // update student on students
        Student student = students.get(studentIndex);
        student.setFullName(fullName);
        student.setDateOfBirth(dateOfBirth);
        student.setGender(gender);
        student.setPhoneNumber(phoneNumber);
        student.setPlaceOfOrigin(province);
        student.setMajor(major);
        student.setClassroom(classroom);

        return student;
    }
    
    private void filterStudent() {
        String filterName = homeView.getiStudentFilter().getText().trim();
        if (filterName.isEmpty()) {
            showStudentOnTable(this.students);
            return;
        }

        DefaultTableModel tableModel = (DefaultTableModel) homeView.getStudentTable().getModel();
        tableModel.setRowCount(0);
        
        Students tempStudents = new Students();
        for (Student student: students) {
            String currentFullName = student.getFullName();
            if (currentFullName.toLowerCase().contains(filterName.toLowerCase())) {
                tempStudents.add(student);            
            }
        }
        
        showStudentOnTable(tempStudents);
    }
    
    // sort on table
    private void sortStudentAscendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getStudentTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                String fullName1 = o1.get(2).toString();
                String fullName2 = o2.get(2).toString();
                
                String name1 = fullName1.substring(fullName1.lastIndexOf(" ") + 1);
                String name2 = fullName2.substring(fullName2.lastIndexOf(" ") + 1);
                
                return name1.compareToIgnoreCase(name2);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    // sort on table
    private void sortStudentDescendingByName() {
        DefaultTableModel dtm = (DefaultTableModel) homeView.getStudentTable().getModel();
        Vector<Vector> tableData = dtm.getDataVector();

        tableData = (Vector<Vector>) tableData.clone();

        Collections.sort(tableData, new Comparator<Vector>() {
            @Override
            public int compare(Vector o1, Vector o2) {
                String fullName1 = o1.get(2).toString();
                String fullName2 = o2.get(2).toString();
                
                String name1 = fullName1.substring(fullName1.lastIndexOf(" ") + 1);
                String name2 = fullName2.substring(fullName2.lastIndexOf(" ") + 1);
                
                return name2.compareToIgnoreCase(name1);
            }
        });

        dtm.setRowCount(0);
        for (Vector<Object> row : tableData) {
            dtm.addRow(row);
        }
    }

    private void showStudentOnTable(Students students) {
        if (students == null) {
            return;
        }

        //add row data into table
        DefaultTableModel tableModel = (DefaultTableModel) homeView.getStudentTable().getModel();
        tableModel.setRowCount(0);
        Object[] row = new Object[9];
        int no = 1;
        for (Student student : students) {
            row[0] = no++;
            row[1] = student.getId();
            row[2] = student.getFullName();
            row[3] = getFormarteDate(student.getDateOfBirth());
            row[4] = student.getGender();
            row[5] = student.getPhoneNumber();
            row[6] = student.getPlaceOfOrigin().getName();
            row[7] = student.getMajor().getName();
            row[8] = student.getClassroom().getName();

            tableModel.addRow(row);
        }
    }

    /**
     * * End: Student **
     */
    /**
     * * Handling event **
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object objectSource = e.getSource();

        /**
         * Begin: Subject *
         */
        // insert button on home view
        if (objectSource.equals(homeView.getBtnInsertSubject())) {
            initInsertSubjectView(homeView);
            return;
        }

        // delete button on home view
        if (objectSource.equals(homeView.getBtnDeleteSubject())) {
            deleteSubject();
            try {
                SubjectStore.saveToFile(subjects, FileName.subject);
            } catch (IOException ex) {

            }
            showSubjectOnTable(subjects);
            return;
        }

        // update button on home view
        if (objectSource.equals(homeView.getBtnUpdateSubject())) {
            int indexSelectedRow = homeView.getSubjectTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }
            int selectedID = (int) homeView.getSubjectTable().getModel().getValueAt(indexSelectedRow, 0);
            int indexSubjectOnSubjects = subjects.indexOfByID(selectedID);
            // show update subject view
            initUpdateSubjectView(homeView);
            subjectView.getiID().setText(subjects.get(indexSubjectOnSubjects).getId() + "");
            subjectView.getiName().setText(subjects.get(indexSubjectOnSubjects).getName());
            subjectView.setVisible(true);

            return;
        }

        // subject filter button
        if (objectSource.equals(homeView.getBtnSubjectFilter())) {
            filterSubject();
        }

        // sort combo box of subject
        if (objectSource instanceof JComboBox) {
            JComboBox cbSortBy = (JComboBox) objectSource;
            if (cbSortBy.equals(homeView.getCbSortByOfSubject())) {
                int selectedIndex = cbSortBy.getSelectedIndex();

                if (selectedIndex == 1) {
                    sortSubjectAscendingByName();
                } else if (selectedIndex == 2) {
                    sortSubjectDescendingByName();
                } else if (selectedIndex == 0) {
                    showSubjectOnTable(subjects);
                }
                return;
            }
        }

        // subject view
        if (subjectView != null) {
            String srcText = e.getActionCommand();
            // insert button on insert subject view
            if (objectSource.equals(subjectView.getBtnAccept()) && srcText.equalsIgnoreCase("INSERT")) {
                Subject newSubject = insertSubject();
                if (newSubject == null) {
                    return;
                }

                subjectView.reset();
                subjectView.getiID().setText(Subject.getsID() + "");

                try {
                    SubjectStore.saveToFile(subjects, FileName.subject);
                } catch (IOException ex) {

                }

                // update row of subject table
                DefaultTableModel tableModel = (DefaultTableModel) homeView.getSubjectTable().getModel();
                Object[] row = new Object[2];
                row[0] = newSubject.getId();
                row[1] = newSubject.getName();
                tableModel.addRow(row);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfSubject().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortSubjectAscendingByName();
                } else if (selectedIndex == 2) {
                    sortSubjectDescendingByName();
                }

                return;
            }

            // update button on update subject view
            if (objectSource.equals(subjectView.getBtnAccept()) && srcText.equalsIgnoreCase("UPDATE")) {
                //get index selected row 
                int indexSelectedRow = homeView.getSubjectTable().getSelectedRow();
                if (indexSelectedRow == -1) {
                    return;
                }

                //get selected ID
                int selectedID = (int) homeView.getSubjectTable().getModel().getValueAt(indexSelectedRow, 0);
                //find index subject on subjects
                int indexSubjectOnSubjects = subjects.indexOfByID(selectedID);

                String newName = updateSubject(indexSubjectOnSubjects);

                try {
                    SubjectStore.saveToFile(subjects, FileName.subject);
                } catch (IOException ex) {

                }

                //update subject name on table
                homeView.getSubjectTable().getModel().setValueAt(newName, indexSelectedRow, 1);

                // sort on table
                int selectedIndex = homeView.getCbSortByOfSubject().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortSubjectAscendingByName();
                } else if (selectedIndex == 2) {
                    sortSubjectDescendingByName();
                }

                subjectView.dispose();

                return;
            }

            // cancel button on insert/update subject view
            if (objectSource.equals(subjectView.getBtnCanel())) {
                subjectView.dispose();
            }
        }
        /**
         * End: Subject *
         */

        /**
         * Begin: Classroom *
         */
        // insert classroom button
        if (objectSource.equals(homeView.getBtnInsertClassroom())) {
            initInsertClassroomView(homeView);
            return;
        }

        // delete classroom button
        if (objectSource.equals(homeView.getBtnDeleteClassroom())) {
            deleteClassroom();
            try {
                ProvinceStore.saveToFile(provinces, FileName.province);
            } catch (IOException ex) {

            }
            showProvinceOnTable(provinces);
            return;
        }

        // update classroom button
        if (objectSource.equals(homeView.getBtnUpdateClassroom())) {
            int indexSelectedRow = homeView.getClassroomTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getClassroomTable().getModel().getValueAt(indexSelectedRow, 0);
            int classroomIndex = classrooms.indexOfBy(selectedID);

            // show update classroom view
            initUpdateClassroomView(homeView);
            classroomView.getiID().setText(classrooms.get(classroomIndex).getId() + "");
            classroomView.getiName().setText(classrooms.get(classroomIndex).getName());
            classroomView.setVisible(true);

            return;
        }

        // filter classroom button
        if (objectSource.equals(homeView.getBtnClassroomFilter())) {
            filterClassroom();
            return;
        }

        // sort combo box of classroom
        if (objectSource instanceof JComboBox) {
            JComboBox cbSortBy = (JComboBox) objectSource;
            if (cbSortBy.equals(homeView.getCbSortByOfClassroom())) {
                int selectedIndex = cbSortBy.getSelectedIndex();

                if (selectedIndex == 1) {
                    sortClassroomAscendingByName();
                } else if (selectedIndex == 2) {
                    sortClassroomDescendingByName();
                } else if (selectedIndex == 0) {
                    showClassroomOnTable(classrooms);
                }
                return;
            }
        }

        // classroom view
        if (classroomView != null) {
            String srcText = e.getActionCommand();
            // insert button when insert
            if (objectSource.equals(classroomView.getBtnAccept()) && srcText.equalsIgnoreCase("INSERT")) {
                Classroom newClassroom = insertClassroom();
                if (newClassroom == null) {
                    return;
                }

                classroomView.reset();
                classroomView.getiID().setText(Classroom.getsID() + "");

                try {
                    ClassroomStore.saveToFile(classrooms, FileName.classroom);
                } catch (IOException ex) {

                }

                // update row of classroom table
                DefaultTableModel tableModel = (DefaultTableModel) homeView.getClassroomTable().getModel();
                Object[] row = new Object[2];
                row[0] = newClassroom.getId();
                row[1] = newClassroom.getName();
                tableModel.addRow(row);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfClassroom().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortClassroomAscendingByName();
                } else if (selectedIndex == 2) {
                    sortClassroomDescendingByName();
                }

                return;
            }

            // update button when update
            if (objectSource.equals(classroomView.getBtnAccept()) && srcText.equalsIgnoreCase("UPDATE")) {
                //get index selected row 
                int indexSelectedRow = homeView.getClassroomTable().getSelectedRow();
                if (indexSelectedRow == -1) {
                    return;
                }

                //get selected ID
                int selectedID = (int) homeView.getClassroomTable().getModel().getValueAt(indexSelectedRow, 0);
                // find index subject on subjects
                int classroomIndex = classrooms.indexOfBy(selectedID);

                String newName = updateClassroom(classroomIndex);

                try {
                    ClassroomStore.saveToFile(classrooms, FileName.classroom);
                } catch (IOException ex) {

                }

                //update classroom name on table
                homeView.getClassroomTable().getModel().setValueAt(newName, indexSelectedRow, 1);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfClassroom().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortClassroomAscendingByName();
                } else if (selectedIndex == 2) {
                    sortClassroomDescendingByName();
                }

                classroomView.dispose();

                return;
            }

            // cancel button
            if (objectSource.equals(classroomView.getBtnCancel())) {
                classroomView.dispose();
            }
        }
        /**
         * End: Classroom *
         */

        /**
         * Begin: Province *
         */
        // insert province button
        if (objectSource.equals(homeView.getBtnInsertProvince())) {
            initInsertProvinceView(homeView);
            return;
        }

        // delete province button
        if (objectSource.equals(homeView.getBtnDeleteProvince())) {
            deleteProvince();
            try {
                ProvinceStore.saveToFile(provinces, FileName.province);
            } catch (IOException ex) {

            }
            showProvinceOnTable(provinces);
            return;
        }

        // update province button
        if (objectSource.equals(homeView.getBtnUpdateProvince())) {
            int indexSelectedRow = homeView.getProvinceTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getProvinceTable().getModel().getValueAt(indexSelectedRow, 0);
            int provinceIndex = provinces.indexOfBy(selectedID);

            // show update province view
            initUpdateProvinceView(homeView);
            provinceView.getiID().setText(provinces.get(provinceIndex).getId() + "");
            provinceView.getiName().setText(provinces.get(provinceIndex).getName());
            provinceView.setVisible(true);

            return;
        }

        // filter province button
        if (objectSource.equals(homeView.getBtnProvinceFilter())) {
            filterProvince();
            return;
        }

        // sort combo box of province
        if (objectSource instanceof JComboBox) {
            JComboBox cbSortBy = (JComboBox) objectSource;
            if (cbSortBy.equals(homeView.getCbSortByOfProvince())) {
                int selectedIndex = cbSortBy.getSelectedIndex();

                if (selectedIndex == 1) {
                    sortProvinceAscendingByName();
                } else if (selectedIndex == 2) {
                    sortProvinceDescendingByName();
                } else if (selectedIndex == 0) {
                    showProvinceOnTable(provinces);
                }
                return;
            }
        }

        // province view
        if (provinceView != null) {
            String srcText = e.getActionCommand();
            // insert button when insert
            if (objectSource.equals(provinceView.getBtnAccept()) && srcText.equalsIgnoreCase("INSERT")) {
                Province newProvince = insertProvince();
                if (newProvince == null) {
                    return;
                }

                provinceView.reset();
                provinceView.getiID().setText(Province.getsID() + "");

                try {
                    ProvinceStore.saveToFile(provinces, FileName.province);
                } catch (IOException ex) {

                }

                // update row of classroom table
                DefaultTableModel tableModel = (DefaultTableModel) homeView.getProvinceTable().getModel();
                Object[] row = new Object[2];
                row[0] = newProvince.getId();
                row[1] = newProvince.getName();
                tableModel.addRow(row);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfProvince().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortProvinceAscendingByName();
                } else if (selectedIndex == 2) {
                    sortProvinceDescendingByName();
                }

                return;
            }

            // update button when update
            if (objectSource.equals(provinceView.getBtnAccept()) && srcText.equalsIgnoreCase("UPDATE")) {
                //get index selected row 
                int indexSelectedRow = homeView.getProvinceTable().getSelectedRow();
                if (indexSelectedRow == -1) {
                    return;
                }

                //get selected ID
                int selectedID = (int) homeView.getProvinceTable().getModel().getValueAt(indexSelectedRow, 0);
                // find index province on provinces
                int provinceIndex = provinces.indexOfBy(selectedID);

                String newName = updateProvince(provinceIndex);

                try {
                    ProvinceStore.saveToFile(provinces, FileName.province);
                } catch (IOException ex) {

                }

                //update province name on table
                homeView.getProvinceTable().getModel().setValueAt(newName, indexSelectedRow, 1);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfProvince().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortProvinceAscendingByName();
                } else if (selectedIndex == 2) {
                    sortProvinceDescendingByName();
                }

                provinceView.dispose();

                return;
            }

            // cancel button
            if (objectSource.equals(provinceView.getBtnCanel())) {
                provinceView.dispose();
            }
        }
        /**
         * End: Province *
         */

        /**
         * Begin: Major *
         */
        // insert major button
        if (objectSource.equals(homeView.getBtnInsertMajor())) {
            initInsertMajorView(homeView);
            return;
        }

        // delete major button
        if (objectSource.equals(homeView.getBtnDeleteMajor())) {
            deleteMajor();
            try {
                MajorStore.saveToFile(majors, FileName.major);
            } catch (IOException ex) {

            }
            showMajorOnTable(majors);
            return;
        }

        // update province button
        if (objectSource.equals(homeView.getBtnUpdateMajor())) {
            int indexSelectedRow = homeView.getMajorTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getMajorTable().getModel().getValueAt(indexSelectedRow, 0);
            int majorIndex = majors.indexOfBy(selectedID);

            // show update major view
            initUpdateMajorView(homeView);
            majorView.getiID().setText(majors.get(majorIndex).getId() + "");
            majorView.getiName().setText(majors.get(majorIndex).getName());
            majorView.setVisible(true);

            return;
        }

        // filter major button
        if (objectSource.equals(homeView.getBtnMajorFilter())) {
            filterMajor();
            return;
        }

        // sort combo box of major
        if (objectSource instanceof JComboBox) {
            JComboBox cbSortBy = (JComboBox) objectSource;
            if (cbSortBy.equals(homeView.getCbSortByOfMajor())) {
                int selectedIndex = cbSortBy.getSelectedIndex();

                if (selectedIndex == 1) {
                    sortMajorAscendingByName();
                } else if (selectedIndex == 2) {
                    sortMajorDescendingByName();
                } else if (selectedIndex == 0) {
                    showMajorOnTable(majors);
                }
                return;
            }
        }

        // major view
        if (majorView != null) {
            String srcText = e.getActionCommand();
            // insert button when insert
            if (objectSource.equals(majorView.getBtnAccept()) && srcText.equalsIgnoreCase("INSERT")) {
                Major newMajor = insertMajor();
                if (newMajor == null) {
                    return;
                }

                majorView.reset();
                majorView.getiID().setText(Major.getsID() + "");

                try {
                    MajorStore.saveToFile(majors, FileName.major);
                } catch (IOException ex) {

                }

                // update row of classroom table
                DefaultTableModel tableModel = (DefaultTableModel) homeView.getMajorTable().getModel();
                Object[] row = new Object[2];
                row[0] = newMajor.getId();
                row[1] = newMajor.getName();
                tableModel.addRow(row);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfMajor().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortMajorAscendingByName();
                } else if (selectedIndex == 2) {
                    sortMajorDescendingByName();
                }

                return;
            }

            // update button when update
            if (objectSource.equals(majorView.getBtnAccept()) && srcText.equalsIgnoreCase("UPDATE")) {
                //get index selected row 
                int indexSelectedRow = homeView.getMajorTable().getSelectedRow();
                if (indexSelectedRow == -1) {
                    return;
                }

                //get selected ID
                int selectedID = (int) homeView.getMajorTable().getModel().getValueAt(indexSelectedRow, 0);
                // find index major on provinces
                int majorIndex = majors.indexOfBy(selectedID);

                String newName = updateMajor(majorIndex);

                try {
                    MajorStore.saveToFile(majors, FileName.major);
                } catch (IOException ex) {

                }

                //update province name on table
                homeView.getMajorTable().getModel().setValueAt(newName, indexSelectedRow, 1);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfMajor().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortMajorAscendingByName();
                } else if (selectedIndex == 2) {
                    sortMajorDescendingByName();
                }

                majorView.dispose();

                return;
            }

            // cancel button
            if (objectSource.equals(majorView.getBtnCanel())) {
                majorView.dispose();
            }
        }
        /**
         * End: Major *
         */

        /**
         * Begin: Student *
         */
        // insert student button
        if (objectSource.equals(homeView.getBtnInsertStudent())) {
            initInsertStudentView(homeView);
            return;
        }

        // delete student button
        if (objectSource.equals(homeView.getBtnDeleteStudent())) {
            deleteStudent();
            try {
                StudentStore.saveToFile(students, FileName.student);
            } catch (IOException ex) {

            }
            showStudentOnTable(students);
            return;
        }

        // update student button
        if (objectSource.equals(homeView.getBtnUpdateStudent())) {
            int indexSelectedRow = homeView.getStudentTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getStudentTable().getModel().getValueAt(indexSelectedRow, 1);
            int studentIndex = students.indexOfBy(selectedID);

            // show update student view
            initUpdateStudentView(homeView);
            
            studentView.getiID().setText(students.get(studentIndex).getId() + "");
            
            studentView.getiFullname().setText(students.get(studentIndex).getFullName());
            
            studentView.getiDateOfBirth().setText(getFormarteDate(students.get(studentIndex).getDateOfBirth()));
            //gender
            if (students.get(studentIndex).getGender().equalsIgnoreCase("Nam")) {
                studentView.getRdoMale().setSelected(true);
            } else {
                studentView.getRdoFemale().setSelected(true);
            }
            
            studentView.getiPhoneNumber().setText(students.get(studentIndex).getPhoneNumber());
            
            studentView.addListItemIntoCbPlaceOfOrgin(provinces);     
            //set selected item
            for (int i = 0; i < studentView.getCbPlaceOfOrigin().getItemCount(); i++) {
                String item = studentView.getCbPlaceOfOrigin().getItemAt(i);
                int id = this.getFisrtIntegerFromString(item, ':');
                if (id == students.get(studentIndex).getId()) {
                    studentView.getCbPlaceOfOrigin().setSelectedIndex(i);
                    break;
                }
            }

            studentView.addListItemIntoCbMajor(majors);
            //set selected item
            for (int i = 0; i < studentView.getCbMajor().getItemCount(); i++) {
                String item = studentView.getCbMajor().getItemAt(i);
                int id = this.getFisrtIntegerFromString(item, ':');
                if (id == students.get(studentIndex).getMajor().getId()) {
                    studentView.getCbMajor().setSelectedIndex(i);
                    break;
                }
            }

            studentView.addListItemIntoCbClass(classrooms);
            //set selected item
            for (int i = 0; i < studentView.getCbClass().getItemCount(); i++) {
                String item = studentView.getCbClass().getItemAt(i);
                int id = this.getFisrtIntegerFromString(item, ':');
                if (id == students.get(studentIndex).getClassroom().getId()) {
                    studentView.getCbClass().setSelectedIndex(i);
                    break;
                }
            }

            studentView.setVisible(true);

            return;
        }
        
         // filter student button
        if (objectSource.equals(homeView.getBtnStudentFilter())) {
            filterStudent();
            return;
        }
        
        // sort combo box of student
        if (objectSource instanceof JComboBox) {
            JComboBox cbSortBy = (JComboBox) objectSource;
            if (cbSortBy.equals(homeView.getCbSortByOfStudent())) {
                int selectedIndex = cbSortBy.getSelectedIndex();

                if (selectedIndex == 1) {
                    sortStudentAscendingByName();
                } else if (selectedIndex == 2) {
                    sortStudentDescendingByName();
                } else if (selectedIndex == 0) {
                    showStudentOnTable(students);
                }
                return;
            }
        }
        
        // student view
        if (studentView != null) {
            String srcText = e.getActionCommand();
            // insert button when insert
            if (objectSource.equals(studentView.getBtnAccept()) && srcText.equalsIgnoreCase("INSERT")) {
                Student newStudent = insertStudent();

                if (newStudent == null) {
                    return;
                }

                studentView.reset();
                studentView.getiID().setText(Student.getsID() + "");

                try {
                    StudentStore.saveToFile(students, FileName.student);
                } catch (IOException ex) {

                }

                // update row of classroom table
                DefaultTableModel tableModel = (DefaultTableModel) homeView.getStudentTable().getModel();
                int numberRow = tableModel.getRowCount();
                
                Object[] row = new Object[9];
                if (numberRow < 1) {
                   row[0] = 1;
                } else {
                   int lastNo = Integer.parseInt(tableModel.getValueAt(numberRow - 1, 0).toString());
                   row[0] = lastNo + 1;
                }
                row[1] = newStudent.getId();
                row[2] = newStudent.getFullName();
                row[3] = getFormarteDate(newStudent.getDateOfBirth());
                row[4] = newStudent.getGender();
                row[5] = newStudent.getPhoneNumber();
                row[6] = newStudent.getPlaceOfOrigin().getName();
                row[7] = newStudent.getMajor().getName();
                row[8] = newStudent.getClassroom().getName();
                tableModel.addRow(row);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfStudent().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortStudentAscendingByName();
                } else if (selectedIndex == 2) {
                    sortStudentDescendingByName();
                }
                return;
            }

            // update button when update
            if (objectSource.equals(studentView.getBtnAccept()) && srcText.equalsIgnoreCase("UPDATE")) {
                //get index selected row 
                int indexSelectedRow = homeView.getStudentTable().getSelectedRow();
                if (indexSelectedRow == -1) {
                    return;
                }

                //get selected ID
                int selectedID = (int) homeView.getStudentTable().getModel().getValueAt(indexSelectedRow, 1);
                // find index student on students
                int studentIndex = students.indexOfBy(selectedID);

                Student updatedStudent = updateStudent(studentIndex);

                try {
                    StudentStore.saveToFile(students, FileName.student);
                } catch (IOException ex) {

                }

                //update student on table
                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getFullName(), indexSelectedRow, 2);

                String formatedDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").format(updatedStudent.getDateOfBirth());
                if (formatedDateOfBirth.equals("01/01/0001")) {
                    homeView.getStudentTable().getModel().setValueAt("", indexSelectedRow, 3);
                } else {
                    homeView.getStudentTable().getModel().setValueAt(formatedDateOfBirth, indexSelectedRow, 3);
                }

                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getGender(), indexSelectedRow, 4);
                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getPhoneNumber(), indexSelectedRow, 5);
                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getPlaceOfOrigin().getName(), indexSelectedRow, 6);
                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getMajor().getName(), indexSelectedRow, 7);
                homeView.getStudentTable().getModel().setValueAt(updatedStudent.getClassroom().getName(), indexSelectedRow, 8);

                //sort on table
                int selectedIndex = homeView.getCbSortByOfStudent().getSelectedIndex();
                if (selectedIndex == 1) {
                    sortStudentAscendingByName();
                } else if (selectedIndex == 2) {
                    sortStudentDescendingByName();
                }
                
                studentView.dispose();

                return;
            }

            // cancel button
            if (objectSource.equals(studentView.getBtnCancel())) {
                studentView.dispose();
            }
        }
        /**
         * End: Student *
         */
    }
}
