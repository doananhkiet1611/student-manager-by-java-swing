package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Classroom;
import model.Province;
import model.Subject;
import model.list.Classrooms;
import model.list.Provinces;
import model.list.Subjects;
import model.store.ClassroomStore;
import model.store.FileName;
import model.store.ProvinceStore;
import model.store.SubjectStore;
import view.ClassroomView;
import view.SubjectView;
import view.AdminHomeView;
import view.ProvinceView;

public class AdminController implements ActionListener {

    private Subjects subjects;
    private AdminHomeView homeView;
    private SubjectView subjectView;
    private Classrooms classrooms;
    private ClassroomView classroomView;
    private Provinces provinces;
    private ProvinceView provinceView;

    public AdminController() {

    }

    public Subjects getSubjects() {
        return subjects;
    }

    public AdminHomeView getHomeView() {
        return homeView;
    }

    public SubjectView getSubjectView() {
        return subjectView;
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
        
        showSubjectOnTable();
        showClassroomOnTable();
        showProvinceOnTable();
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
            showSubjectOnTable();
            return;
        }

        DefaultTableModel tableModel = (DefaultTableModel) homeView.getSubjectTable().getModel();
        tableModel.setRowCount(0);
        for (Subject subject : subjects) {
            String currentName = subject.getName();

            if (subject.getName().toLowerCase().contains(filterName.toLowerCase())) {
                Object[] row = new Object[2];
                row[0] = subject.getId();
                row[1] = subject.getName();
                tableModel.addRow(row);
            }
        }
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

    private void showSubjectOnTable() {
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
            showClassroomOnTable();
            return;
        }

        DefaultTableModel tableModel = (DefaultTableModel) homeView.getClassroomTable().getModel();
        tableModel.setRowCount(0);
        for (Classroom classroom : classrooms) {
            String currentName = classroom.getName();

            if (classroom.getName().toLowerCase().contains(filterName.toLowerCase())) {
                Object[] row = new Object[2];
                row[0] = classroom.getId();
                row[1] = classroom.getName();
                tableModel.addRow(row);
            }
        }
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

    private void showClassroomOnTable() {
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
            showProvinceOnTable();
            return;
        }

        DefaultTableModel tableModel = (DefaultTableModel) homeView.getProvinceTable().getModel();
        tableModel.setRowCount(0);
        for (Province province : provinces) {
            String currentName = province.getName();
            
            if (province.getName().toLowerCase().contains(filterName.toLowerCase())) {
                Object[] row = new Object[2];
                row[0] = province.getId();
                row[1] = province.getName();
                tableModel.addRow(row);
            }
        }
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
    
    private void showProvinceOnTable() {
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
            showSubjectOnTable();
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
                    showSubjectOnTable();
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
            showProvinceOnTable();
            return;
        }

        // update classroom button
        if (objectSource.equals(homeView.getBtnUpdateClassroom())) {
            int indexSelectedRow = homeView.getClassroomTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getClassroomTable().getModel().getValueAt(indexSelectedRow, 0);
            int classroomIndex = classrooms.indexOfByID(selectedID);

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
                    showClassroomOnTable();
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
                int classroomIndex = classrooms.indexOfByID(selectedID);

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
            if (objectSource.equals(classroomView.getBtnCanel())) {
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

        // delete classroom button
        if (objectSource.equals(homeView.getBtnDeleteProvince())) {
            deleteProvince();
            try {
                ProvinceStore.saveToFile(provinces, FileName.province);
            } catch (IOException ex) {

            }
            showProvinceOnTable();
            return;
        }

        // update province button
        if (objectSource.equals(homeView.getBtnUpdateProvince())) {
            int indexSelectedRow = homeView.getProvinceTable().getSelectedRow();
            if (indexSelectedRow == -1) {
                return;
            }

            int selectedID = (int) homeView.getProvinceTable().getModel().getValueAt(indexSelectedRow, 0);
            int provinceIndex = provinces.indexOfByID(selectedID);

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
                    showProvinceOnTable();
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
                provinceView.getiID().setText(Classroom.getsID() + "");

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
                int provinceIndex = provinces.indexOfByID(selectedID);

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
    }
}
