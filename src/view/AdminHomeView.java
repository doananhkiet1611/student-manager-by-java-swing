/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminHomeView extends javax.swing.JFrame {
    public AdminHomeView(ActionListener actionListener) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        studentTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        studentTable.getTableHeader().setPreferredSize(new Dimension(0, 25));
        studentTable.getTableHeader().setBackground(new Color(51,51, 51));
        studentTable.getTableHeader().setForeground(new Color(220, 220, 220));
        studentTab.setFont(new Font("Arial", Font.PLAIN, 14));
        studentTable.setRowHeight(25);
        
        cbSortByOfSubject.addItem("");
        cbSortByOfSubject.addItem("Name: Ascending");
        cbSortByOfSubject.addItem("Name: Descending");
        cbSortByOfSubject.setSelectedIndex(0);
        
        cbSortByOfClassroom.addItem("");
        cbSortByOfClassroom.addItem("Name: Ascending");
        cbSortByOfClassroom.addItem("Name: Descending");
        cbSortByOfClassroom.setSelectedIndex(0);
        
        cbSortByOfProvince.addItem("");
        cbSortByOfProvince.addItem("Name: Ascending");
        cbSortByOfProvince.addItem("Name: Descending");
        cbSortByOfProvince.setSelectedIndex(0);
        
        cbSortByOfMajor.addItem("");
        cbSortByOfMajor.addItem("Name: Ascending");
        cbSortByOfMajor.addItem("Name: Descending");
        cbSortByOfMajor.setSelectedIndex(0);
        
        cbSortByOfStudent.addItem("");
        cbSortByOfStudent.addItem("Name: Ascending");
        cbSortByOfStudent.addItem("Name: Descending");
        cbSortByOfStudent.setSelectedIndex(0);
        
        addActionListenerToButtonsOfSubject(actionListener);
    }

    public JButton getBtnDeleteSubject() {
        return btnDeleteSubject;
    }

    public JButton getBtnInsertSubject() {
        return btnInsertSubject;
    }

    public JButton getBtnUpdateSubject() {
        return btnUpdateSubject;
    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public JTable getSubjectTable() {
        return subjectTable;
    }

    public JTextField getISubjectFilter() {
        return iSubjectFilter;
    }

    public JTextField getiSubjectFilter() {
        return iSubjectFilter;
    }

    public JButton getBtnSubjectFilter() {
        return btnSubjectFilter;
    }

    public JComboBox<String> getCbSortByOfSubject() {
        return cbSortByOfSubject;
    }

    public JButton getBtnDeleteClassroom() {
        return btnDeleteClassroom;
    }

    public JButton getBtnInsertClassroom() {
        return btnInsertClassroom;
    }

    public JButton getBtnUpdateClassroom() {
        return btnUpdateClassroom;
    }

    public JComboBox<String> getCbSortByOfClassroom() {
        return cbSortByOfClassroom;
    }

    public JTable getClassroomTable() {
        return classroomTable;
    }

    public JTextField getiClassroomFilter() {
        return iClassroomFilter;
    }
  
    public JButton getBtnClassroomFilter() {
        return btnClassroomFilter;
    }

    public JButton getBtnDeleteProvince() {
        return btnDeleteProvince;
    }

    public JButton getBtnInsertProvince() {
        return btnInsertProvince;
    }

    public JButton getBtnProvinceFilter() {
        return btnProvinceFilter;
    }

    public JButton getBtnUpdateProvince() {
        return btnUpdateProvince;
    }

    public JComboBox<String> getCbSortByOfProvince() {
        return cbSortByOfProvince;
    }

    public JTextField getiProvinceFilter() {
        return iProvinceFilter;
    }

    public JTable getProvinceTable() {
        return provinceTable;
    }

    public JButton getBtnDeleteStudent() {
        return btnDeleteStudent;
    }

    public JButton getBtnInsertStudent() {
        return btnInsertStudent;
    }

    public JButton getBtnStudentFilter() {
        return btnStudentFilter;
    }

    public JButton getBtnUpdateStudent() {
        return btnUpdateStudent;
    }

    public JComboBox<String> getCbSortByOfStudent() {
        return cbSortByOfStudent;
    }

    public JTextField getiStudentFilter() {
        return iStudentFilter;
    }

    public JTable getStudentTable() {
        return studentTable;
    }

    public JButton getBtnDeleteMajor() {
        return btnDeleteMajor;
    }

    public JButton getBtnInsertMajor() {
        return btnInsertMajor;
    }

    public JButton getBtnMajorFilter() {
        return btnMajorFilter;
    }

    public JComboBox<String> getCbSortByOfMajor() {
        return cbSortByOfMajor;
    }

    public JTextField getiMajorFilter() {
        return iMajorFilter;
    }

    public JTable getMajorTable() {
        return majorTable;
    }

    public JButton getBtnUpdateMajor() {
        return btnUpdateMajor;
    }
    

    public void addActionListenerToButtonsOfSubject(ActionListener actionListener){
        btnInsertSubject.addActionListener(actionListener);
        btnDeleteSubject.addActionListener(actionListener);
        btnUpdateSubject.addActionListener(actionListener);
        btnSubjectFilter.addActionListener(actionListener);
        cbSortByOfSubject.addActionListener(actionListener);
        
        btnInsertClassroom.addActionListener(actionListener);
        btnDeleteClassroom.addActionListener(actionListener);
        btnUpdateClassroom.addActionListener(actionListener);
        btnClassroomFilter.addActionListener(actionListener);
        cbSortByOfClassroom.addActionListener(actionListener);
        
        btnInsertProvince.addActionListener(actionListener);
        btnDeleteProvince.addActionListener(actionListener);
        btnUpdateProvince.addActionListener(actionListener);
        btnProvinceFilter.addActionListener(actionListener);
        cbSortByOfProvince.addActionListener(actionListener);

        btnInsertMajor.addActionListener(actionListener);
        btnDeleteMajor.addActionListener(actionListener);
        btnUpdateMajor.addActionListener(actionListener);
        btnMajorFilter.addActionListener(actionListener);
        cbSortByOfMajor.addActionListener(actionListener);
        
        btnInsertStudent.addActionListener(actionListener);
        btnDeleteStudent.addActionListener(actionListener);
        btnUpdateStudent.addActionListener(actionListener);
        btnStudentFilter.addActionListener(actionListener);
        cbSortByOfStudent.addActionListener(actionListener);
    }
    
    public void addItemListenerToComboBoxOfSubject(ItemListener itemListener) {
//        cbSortBy.addItemListener(itemListener);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        studentTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        iStudentFilter = new javax.swing.JTextField();
        btnStudentFilter = new javax.swing.JButton();
        cbSortByOfStudent = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnDeleteStudent = new javax.swing.JButton();
        btnUpdateStudent = new javax.swing.JButton();
        btnInsertStudent = new javax.swing.JButton();
        subjectTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        iSubjectFilter = new javax.swing.JTextField();
        btnSubjectFilter = new javax.swing.JButton();
        cbSortByOfSubject = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnDeleteSubject = new javax.swing.JButton();
        btnUpdateSubject = new javax.swing.JButton();
        btnInsertSubject = new javax.swing.JButton();
        classroomTab = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        classroomTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        iClassroomFilter = new javax.swing.JTextField();
        btnClassroomFilter = new javax.swing.JButton();
        cbSortByOfClassroom = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnDeleteClassroom = new javax.swing.JButton();
        btnUpdateClassroom = new javax.swing.JButton();
        btnInsertClassroom = new javax.swing.JButton();
        provinceTab = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        provinceTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        iProvinceFilter = new javax.swing.JTextField();
        btnProvinceFilter = new javax.swing.JButton();
        cbSortByOfProvince = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnDeleteProvince = new javax.swing.JButton();
        btnUpdateProvince = new javax.swing.JButton();
        btnInsertProvince = new javax.swing.JButton();
        majorTab = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        majorTable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        iMajorFilter = new javax.swing.JTextField();
        btnMajorFilter = new javax.swing.JButton();
        cbSortByOfMajor = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnDeleteMajor = new javax.swing.JButton();
        btnUpdateMajor = new javax.swing.JButton();
        btnInsertMajor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N.O", "ID", "Full Name", "Date Of Birth", "Gender", "Phone Number", "Place Of Origin", "Major", "Classroom"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(studentTable);
        if (studentTable.getColumnModel().getColumnCount() > 0) {
            studentTable.getColumnModel().getColumn(0).setMinWidth(40);
            studentTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            studentTable.getColumnModel().getColumn(1).setMinWidth(40);
            studentTable.getColumnModel().getColumn(1).setPreferredWidth(40);
            studentTable.getColumnModel().getColumn(2).setPreferredWidth(150);
            studentTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            studentTable.getColumnModel().getColumn(4).setPreferredWidth(60);
            studentTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            studentTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            studentTable.getColumnModel().getColumn(7).setPreferredWidth(120);
            studentTable.getColumnModel().getColumn(8).setPreferredWidth(70);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Full Name");

        iStudentFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iStudentFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iStudentFilterActionPerformed(evt);
            }
        });

        btnStudentFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnStudentFilter.setText("Filter");
        btnStudentFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentFilterActionPerformed(evt);
            }
        });

        cbSortByOfStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Sort By");

        btnDeleteStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteStudent.setText("DELETE");
        btnDeleteStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteStudentActionPerformed(evt);
            }
        });

        btnUpdateStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateStudent.setText("UPDATE");
        btnUpdateStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStudentActionPerformed(evt);
            }
        });

        btnInsertStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertStudent.setText("INSERT");

        javax.swing.GroupLayout studentTabLayout = new javax.swing.GroupLayout(studentTab);
        studentTab.setLayout(studentTabLayout);
        studentTabLayout.setHorizontalGroup(
            studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentTabLayout.createSequentialGroup()
                .addGroup(studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studentTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(studentTabLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortByOfStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(studentTabLayout.createSequentialGroup()
                .addContainerGap(288, Short.MAX_VALUE)
                .addComponent(btnInsertStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );
        studentTabLayout.setVerticalGroup(
            studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentTabLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSortByOfStudent)
                        .addComponent(jLabel2))
                    .addGroup(studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iStudentFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnStudentFilter)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(studentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Student", studentTab);

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        subjectTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(subjectTable);
        if (subjectTable.getColumnModel().getColumnCount() > 0) {
            subjectTable.getColumnModel().getColumn(0).setMinWidth(20);
            subjectTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            subjectTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Subject Name");

        iSubjectFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iSubjectFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iSubjectFilterActionPerformed(evt);
            }
        });

        btnSubjectFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSubjectFilter.setText("Filter");
        btnSubjectFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubjectFilterActionPerformed(evt);
            }
        });

        cbSortByOfSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Sort By");

        btnDeleteSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteSubject.setText("DELETE");
        btnDeleteSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSubjectActionPerformed(evt);
            }
        });

        btnUpdateSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateSubject.setText("UPDATE");
        btnUpdateSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSubjectActionPerformed(evt);
            }
        });

        btnInsertSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertSubject.setText("INSERT");

        javax.swing.GroupLayout subjectTabLayout = new javax.swing.GroupLayout(subjectTab);
        subjectTab.setLayout(subjectTabLayout);
        subjectTabLayout.setHorizontalGroup(
            subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectTabLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iSubjectFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubjectFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortByOfSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(subjectTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDeleteSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(subjectTabLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subjectTabLayout.setVerticalGroup(
            subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectTabLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSortByOfSubject)
                        .addComponent(jLabel4))
                    .addGroup(subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iSubjectFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubjectFilter)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(subjectTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Subject", subjectTab);

        classroomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        classroomTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(classroomTable);
        if (classroomTable.getColumnModel().getColumnCount() > 0) {
            classroomTable.getColumnModel().getColumn(0).setMinWidth(20);
            classroomTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            classroomTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Class name");

        iClassroomFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iClassroomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iClassroomFilterActionPerformed(evt);
            }
        });

        btnClassroomFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClassroomFilter.setText("Filter");
        btnClassroomFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassroomFilterActionPerformed(evt);
            }
        });

        cbSortByOfClassroom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Sort By");

        btnDeleteClassroom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteClassroom.setText("DELETE");
        btnDeleteClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClassroomActionPerformed(evt);
            }
        });

        btnUpdateClassroom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateClassroom.setText("UPDATE");
        btnUpdateClassroom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClassroomActionPerformed(evt);
            }
        });

        btnInsertClassroom.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertClassroom.setText("INSERT");

        javax.swing.GroupLayout classroomTabLayout = new javax.swing.GroupLayout(classroomTab);
        classroomTab.setLayout(classroomTabLayout);
        classroomTabLayout.setHorizontalGroup(
            classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classroomTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classroomTabLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iClassroomFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClassroomFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortByOfClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(classroomTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDeleteClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdateClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(classroomTabLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        classroomTabLayout.setVerticalGroup(
            classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classroomTabLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSortByOfClassroom)
                        .addComponent(jLabel6))
                    .addGroup(classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iClassroomFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnClassroomFilter)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(classroomTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Classroom", classroomTab);

        provinceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        provinceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(provinceTable);
        if (provinceTable.getColumnModel().getColumnCount() > 0) {
            provinceTable.getColumnModel().getColumn(0).setMinWidth(20);
            provinceTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            provinceTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Class name");

        iProvinceFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iProvinceFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iProvinceFilterActionPerformed(evt);
            }
        });

        btnProvinceFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProvinceFilter.setText("Filter");
        btnProvinceFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProvinceFilterActionPerformed(evt);
            }
        });

        cbSortByOfProvince.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Sort By");

        btnDeleteProvince.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteProvince.setText("DELETE");
        btnDeleteProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProvinceActionPerformed(evt);
            }
        });

        btnUpdateProvince.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateProvince.setText("UPDATE");
        btnUpdateProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProvinceActionPerformed(evt);
            }
        });

        btnInsertProvince.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertProvince.setText("INSERT");

        javax.swing.GroupLayout provinceTabLayout = new javax.swing.GroupLayout(provinceTab);
        provinceTab.setLayout(provinceTabLayout);
        provinceTabLayout.setHorizontalGroup(
            provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(provinceTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(provinceTabLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iProvinceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProvinceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortByOfProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(provinceTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDeleteProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(provinceTabLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        provinceTabLayout.setVerticalGroup(
            provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(provinceTabLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSortByOfProvince)
                        .addComponent(jLabel8))
                    .addGroup(provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iProvinceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnProvinceFilter)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(provinceTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteProvince, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Province", provinceTab);

        majorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        majorTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(majorTable);
        if (majorTable.getColumnModel().getColumnCount() > 0) {
            majorTable.getColumnModel().getColumn(0).setMinWidth(20);
            majorTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            majorTable.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Major name");

        iMajorFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        iMajorFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iMajorFilterActionPerformed(evt);
            }
        });

        btnMajorFilter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMajorFilter.setText("Filter");
        btnMajorFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMajorFilterActionPerformed(evt);
            }
        });

        cbSortByOfMajor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Sort By");

        btnDeleteMajor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteMajor.setText("DELETE");
        btnDeleteMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMajorActionPerformed(evt);
            }
        });

        btnUpdateMajor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUpdateMajor.setText("UPDATE");
        btnUpdateMajor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMajorActionPerformed(evt);
            }
        });

        btnInsertMajor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInsertMajor.setText("INSERT");

        javax.swing.GroupLayout majorTabLayout = new javax.swing.GroupLayout(majorTab);
        majorTab.setLayout(majorTabLayout);
        majorTabLayout.setHorizontalGroup(
            majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(majorTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(majorTabLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iMajorFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMajorFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 416, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSortByOfMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(majorTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnInsertMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnDeleteMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnUpdateMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(majorTabLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        majorTabLayout.setVerticalGroup(
            majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(majorTabLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbSortByOfMajor)
                        .addComponent(jLabel10))
                    .addGroup(majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(iMajorFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMajorFilter)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(majorTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteMajor, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Major", majorTab);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        jMenuItem2.setText("Open");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStudentFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentFilterActionPerformed

    private void iStudentFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iStudentFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iStudentFilterActionPerformed

    private void btnDeleteStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteStudentActionPerformed

    private void btnUpdateStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStudentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateStudentActionPerformed

    private void iSubjectFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iSubjectFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iSubjectFilterActionPerformed

    private void btnSubjectFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubjectFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubjectFilterActionPerformed

    private void btnDeleteSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteSubjectActionPerformed

    private void btnUpdateSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateSubjectActionPerformed

    private void iClassroomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iClassroomFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iClassroomFilterActionPerformed

    private void btnClassroomFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassroomFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClassroomFilterActionPerformed

    private void btnDeleteClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClassroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteClassroomActionPerformed

    private void btnUpdateClassroomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClassroomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateClassroomActionPerformed

    private void iProvinceFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iProvinceFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iProvinceFilterActionPerformed

    private void btnProvinceFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProvinceFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProvinceFilterActionPerformed

    private void btnDeleteProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteProvinceActionPerformed

    private void btnUpdateProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateProvinceActionPerformed

    private void iMajorFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iMajorFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iMajorFilterActionPerformed

    private void btnMajorFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMajorFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMajorFilterActionPerformed

    private void btnDeleteMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteMajorActionPerformed

    private void btnUpdateMajorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMajorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateMajorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClassroomFilter;
    private javax.swing.JButton btnDeleteClassroom;
    private javax.swing.JButton btnDeleteMajor;
    private javax.swing.JButton btnDeleteProvince;
    private javax.swing.JButton btnDeleteStudent;
    private javax.swing.JButton btnDeleteSubject;
    private javax.swing.JButton btnInsertClassroom;
    private javax.swing.JButton btnInsertMajor;
    private javax.swing.JButton btnInsertProvince;
    private javax.swing.JButton btnInsertStudent;
    private javax.swing.JButton btnInsertSubject;
    private javax.swing.JButton btnMajorFilter;
    private javax.swing.JButton btnProvinceFilter;
    private javax.swing.JButton btnStudentFilter;
    private javax.swing.JButton btnSubjectFilter;
    private javax.swing.JButton btnUpdateClassroom;
    private javax.swing.JButton btnUpdateMajor;
    private javax.swing.JButton btnUpdateProvince;
    private javax.swing.JButton btnUpdateStudent;
    private javax.swing.JButton btnUpdateSubject;
    private javax.swing.JComboBox<String> cbSortByOfClassroom;
    private javax.swing.JComboBox<String> cbSortByOfMajor;
    private javax.swing.JComboBox<String> cbSortByOfProvince;
    private javax.swing.JComboBox<String> cbSortByOfStudent;
    private javax.swing.JComboBox<String> cbSortByOfSubject;
    private javax.swing.JPanel classroomTab;
    private javax.swing.JTable classroomTable;
    private javax.swing.JTextField iClassroomFilter;
    private javax.swing.JTextField iMajorFilter;
    private javax.swing.JTextField iProvinceFilter;
    private javax.swing.JTextField iStudentFilter;
    private javax.swing.JTextField iSubjectFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JPanel majorTab;
    private javax.swing.JTable majorTable;
    private javax.swing.JPanel provinceTab;
    private javax.swing.JTable provinceTable;
    private javax.swing.JPanel studentTab;
    private javax.swing.JTable studentTable;
    private javax.swing.JPanel subjectTab;
    private javax.swing.JTable subjectTable;
    // End of variables declaration//GEN-END:variables
}
