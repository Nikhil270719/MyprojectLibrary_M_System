/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static Jframe.DBConnection.con;

/**
 *
 * @author Rw
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form ManageStudent
     */
    String studentName,course,branch;
    int studentId;
    DefaultTableModel model;
    
    

    /**
     * Creates new form ManageStudent
     */
   
    public ManageStudent() {
        initComponents();
         setStudentDetatilsToTable();
    }
    //to set set th book details in database
    public void setStudentDetatilsToTable()
    {
        try{  Class.forName("com.mysql.cj.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
                  Statement  st =con.createStatement();
                  ResultSet rs = st.executeQuery("Select * from student_details");
                  
                  
                  while(rs.next())
                  {
                      int studentId = rs.getInt("student_id");
                      String studentName =rs.getString("name");
                      String Course =rs.getString("Course");
                      String branch =rs.getString("branch");
                      
                      Object[]obj ={studentId,studentName,Course,branch};
                      model=(DefaultTableModel)tbl_studentDetails.getModel();
                      model.addRow(obj);
                      
                  }
            
        }catch(Exception e ){
           e.printStackTrace();
        }
        
    }
//to add student to student_detAILS  TABLE
    public boolean addStudent()
    {
        boolean isAdded=false;
        
        studentId =Integer.parseInt(txt_studentId.getText());
        studentName=txt_studentName.getText();
       course = combo_CourseName.getSelectedItem().toString();
       branch = Combo_branch.getSelectedItem().toString();
       
        try{
           java.sql.Connection con=DBConnection.getConnection();
           String sql ="insert into student_details values(?,?,?,?)";
          PreparedStatement pst = con. prepareStatement(sql);
          pst.setInt(1,studentId);
          pst.setString(2, studentName);
          pst.setString(3,  course );
          pst.setString(4, branch);
          
          int rowCount =pst.executeUpdate();
          if(rowCount > 0)
          {
           isAdded =true;
           
          }
          else{
              isAdded=false;
              
          }
                
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return isAdded;
    }
    //to update Student Detatils
    
    public boolean updateStudent()
    {
        boolean isUpdate = false;
        
            studentId =Integer.parseInt(txt_studentId.getText());
        studentName=txt_studentName.getText();
       course = combo_CourseName.getSelectedItem().toString();
       branch = Combo_branch.getSelectedItem().toString();
       
       
        try
        {
             java.sql.Connection con=DBConnection.getConnection();
             String sql = "update student_details set name=?,course=?,branch=? where  student_id =?";
             PreparedStatement pst = con. prepareStatement(sql);
             pst.setString(1,studentName);
             pst.setString(2,course);
             pst.setString(3, branch);
             pst.setInt(4, studentId);
             
             int rowCount = pst.executeUpdate();
             if(rowCount>0)
             {
                 isUpdate = true;
                 
             }
             else
             {
                 isUpdate = false;
             }
             
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       return isUpdate;
        
    }
    // method clear Table
    public void clearTable()
    {
        DefaultTableModel model= (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
    }
    //method to delete book detail
    public boolean deleteStudent()
            {
                boolean isDelete= false;
               studentId =Integer.parseInt(txt_studentId.getText());
                try
                {
                    java.sql.Connection con=DBConnection.getConnection();
                    String sql= "delete from student_details where student_id= ?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setInt(1, studentId);
                    
                    int rowCount = pst.executeUpdate();
                    if(rowCount>0)
                    {
                        isDelete=true;
                        
                    }else
                    {
                        isDelete=false;
                        
                    }
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
                return isDelete;
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txt_bookId1 = new app.bolivia.swing.JCTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        rSMaterialButtonCircle5 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle6 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle7 = new rojerusan.RSMaterialButtonCircle();
        txt_bookName1 = new app.bolivia.swing.JCTextField();
        combo_CourseName = new javax.swing.JComboBox<>();
        Combo_branch = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Enter BooK Id");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel3.setText("Back");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel4.setText("Back");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel5.setText("Back");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 90, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));
        jPanel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 10)); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Enter Student Id");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Studet Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, -1));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setPlaceholder("Enter Student Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel3.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Select Course");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 50));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Select Branch");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, 30));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle2.setText("Delete");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 80, 40));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle3.setText("add");
        rSMaterialButtonCircle3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle3MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 90, 40));

        rSMaterialButtonCircle4.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle4.setText("Update");
        rSMaterialButtonCircle4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle4ActionPerformed(evt);
            }
        });
        jPanel3.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 90, 40));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setPlaceholder("Enter Student Name");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, -1));

        jPanel8.setBackground(new java.awt.Color(102, 102, 255));
        jPanel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 10)); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel18.setText("Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Enter Student Id");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Enter Studet Name");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, -1));

        txt_bookId1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId1.setPlaceholder("Enter Student Id");
        txt_bookId1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookId1FocusLost(evt);
            }
        });
        txt_bookId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookId1ActionPerformed(evt);
            }
        });
        jPanel8.add(txt_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Select Course");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 50));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Select Branch");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        rSMaterialButtonCircle5.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle5.setText("Delete");
        rSMaterialButtonCircle5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle5ActionPerformed(evt);
            }
        });
        jPanel8.add(rSMaterialButtonCircle5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 80, 40));

        rSMaterialButtonCircle6.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle6.setText("add");
        rSMaterialButtonCircle6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle6MouseClicked(evt);
            }
        });
        rSMaterialButtonCircle6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle6ActionPerformed(evt);
            }
        });
        jPanel8.add(rSMaterialButtonCircle6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 90, 40));

        rSMaterialButtonCircle7.setBackground(new java.awt.Color(255, 51, 102));
        rSMaterialButtonCircle7.setText("Update");
        rSMaterialButtonCircle7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 10)); // NOI18N
        rSMaterialButtonCircle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle7ActionPerformed(evt);
            }
        });
        jPanel8.add(rSMaterialButtonCircle7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 90, 40));

        txt_bookName1.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName1.setPlaceholder("Enter Student Name");
        txt_bookName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookName1FocusLost(evt);
            }
        });
        txt_bookName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookName1ActionPerformed(evt);
            }
        });
        jPanel8.add(txt_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, -1));

        combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full Stack java", "Testing ", "Data science", "Paython Devloper " }));
        jPanel8.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 230, 30));

        Combo_branch.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        Combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "It", "CS", "plain", "Electronics " }));
        jPanel8.add(Combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 230, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 460));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 420));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Auther", "Quantity"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 102));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 400, 220));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel17.setText("Manage Student");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 290, 2));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 480, 420));

        setSize(new java.awt.Dimension(803, 429));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        HomePage home =new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
             if(deleteStudent()==true)
        {
            JOptionPane.showMessageDialog(this, "Book Delete");
            clearTable();
             setStudentDetatilsToTable();
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book deletation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4ActionPerformed
        if(updateStudent()==true)
        {
            JOptionPane.showMessageDialog(this, "student update");
            clearTable();
             setStudentDetatilsToTable();
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "student updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameFocusLost

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo =tbl_studentDetails.getSelectedRow();
        TableModel Model=tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        Combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        if(addStudent()==true)
        {
            JOptionPane.showMessageDialog(this, "Studennt Added");
            clearTable();
            setStudentDetatilsToTable();
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Student Addition Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel18MouseClicked

    private void txt_bookId1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookId1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId1FocusLost

    private void txt_bookId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookId1ActionPerformed

    private void rSMaterialButtonCircle5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle5ActionPerformed

    private void rSMaterialButtonCircle6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle6MouseClicked

    private void rSMaterialButtonCircle6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle6ActionPerformed

    private void rSMaterialButtonCircle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle7ActionPerformed

    private void txt_bookName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookName1FocusLost

    private void txt_bookName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookName1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_branch;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle5;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle6;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle7;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_bookId1;
    private app.bolivia.swing.JCTextField txt_bookName1;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
