/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Rw
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    //to fetch the book details from the database it to book details panel 
   public void getBookDetails(){
       int bookId = Integer.parseInt(txt_bookId.getText());
       
       
       try
       {
         Connection con=DBConnection.getConnection();
            PreparedStatement pst = con. prepareStatement("select * from book_details where book_id= ?");
           pst.setInt(1,bookId);
         ResultSet  rs =pst.executeQuery();
           
           
           if(rs.next())
           {
               lbl_bookId.setText(rs.getString("book_id"));
               lbl_bookName.setText(rs.getString("book_name"));
              lbl_auther.setText(rs.getString("auther"));
               lbl_quantity.setText(rs.getString("quantity"));
           }
           else
           {
               lbl_bookError.setText("Invalid Book Id");
           }
           
       }catch(Exception e)
               {
                   e.printStackTrace();
               }
   } 
   public void getStudentDetails(){
       int studentId = Integer.parseInt(txt_studentId.getText());
       
       
       try
       {
         Connection con=DBConnection.getConnection();
            PreparedStatement pst = con. prepareStatement("select * from student_details where student_id= ?");
           pst.setInt(1,studentId);
         ResultSet  rs =pst.executeQuery();
           
           
           if(rs.next())
           {
               lbl_studentId.setText(rs.getString("student_id"));
               lbl_studentName.setText(rs.getString("name"));
              lbl_course.setText(rs.getString("course"));
               lbl_branch.setText(rs.getString("branch"));
           }
           else
           {
               lbl_studentError.setText("Invalid Student Id");
           }
           
       }catch(Exception e)
               {
                   e.printStackTrace();
               }
   }
   //insert issue boo details to database
   public boolean issueBook(){
       boolean isIssued=false;
       int bookId = Integer.parseInt(txt_bookId.getText());
       int studentId = Integer.parseInt(date_dueDate.toString());
       String bookName=lbl_bookName.getText();
       String studentName=lbl_studentName.getText();
       
         String uIssueDate= date_issueDate.toString();
          String uDueDate=  date_dueDate.toString();
       
//       Long l1 =uIssueDate.getTime();
//      long l2 =uDueDate.getTime();
//       
//       
//      java.sql.Date sIssuDate =new java.sql.Date(uIssueDate.getTime());
//       java.sql.Date sDueDate =new java.sql.Date(uIssueDate.getTime());
        
        try
        {
            Connection con = DBConnection.getConnection();
            String sql ="insert into issue_book_details(book_id,book_name,student_id,student_name,"
                    +"issue_date,due_date,status)(?,?,?,?,?,?,?)"; 
             PreparedStatement pst =con.prepareStatement(sql);
             pst.setInt(1,bookId);
             pst.setString(2, bookName);
               pst.setInt(3,studentId);
                 pst.setString(4,studentName);
                 pst.setString(5,uIssueDate);
                 pst.setString(6,uDueDate);
                 pst.setString(7,"panding");
                 
                 int rowCount = pst.executeUpdate();
                 if(rowCount>0)
                 {
                      isIssued=true;
                      
                     
                 }
                 else
                 {
                      isIssued=false;
                      
                 }
        }
        
                 catch(SQLException e)
                         {
                         e.printStackTrace();
                         }
                            return  isIssued;
                            
        
   }
   //updating  book count
   
   public void bookCount(){
       int bookId =Integer.parseInt(txt_bookId.getText());
       try
       {
           Connection con = DBConnection.getConnection();
           String sql = "update book_details set quatity = quantity-1 where book_id=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           
         int  rowCount = pst.executeUpdate();
           if(rowCount>0)
                 {
                     JOptionPane.showMessageDialog(this,"book count update");
                     int intialCount =Integer.parseInt(lbl_quantity.getText());
                     lbl_quantity.setText(Integer.toString(intialCount-1));
                     
                 }
                 else
                 {
                         JOptionPane.showMessageDialog(this," can t update book count ");
                      
                 }
                   
       } catch (SQLException ex) {
            Logger.getLogger(IssueBook.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   //checking whether book already allocated or not
public boolean isAlreadyIssued()
{
    boolean isAlreadyIssued= false;
    
         int bookId = Integer.parseInt(txt_bookId.getText());
       int studentId = Integer.parseInt(date_dueDate.toString());
        
       try
       {
           Connection con =DBConnection.getConnection();
           String sql ="select * from issue book details where  book id =? and student id=? and status =? ";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1, bookId);
           pst.setInt(2, studentId);
           pst.setString(3,"pending");
           
           ResultSet rs=pst.executeQuery();
           
           
           if(rs.next())
           {
               isAlreadyIssued=true;
               
           }
           else
           {
                isAlreadyIssued=false;
                
           }
       }catch(Exception e)
       {
           e.printStackTrace();
       }
         return isAlreadyIssued;
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        rSDateChooserBeanInfo1 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        rSDateChooserBeanInfo2 = new rojeru_san.componentes.RSDateChooserBeanInfo();
        panal_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_branch = new app.bolivia.swing.JCTextField();
        lbl_studentId = new app.bolivia.swing.JCTextField();
        lbl_studentName = new app.bolivia.swing.JCTextField();
        lbl_course = new app.bolivia.swing.JCTextField();
        lbl_studentError = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_quantity = new app.bolivia.swing.JCTextField();
        lbl_bookId = new app.bolivia.swing.JCTextField();
        lbl_bookName = new app.bolivia.swing.JCTextField();
        lbl_auther = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_bookError1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();

        jLabel5.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Auther");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panal_main.setBackground(new java.awt.Color(255, 255, 255));
        panal_main.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                panal_mainFocusLost(evt);
            }
        });
        panal_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel1.setText("Student Details ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 200, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Branch:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student Id:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Course:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        lbl_branch.setBackground(new java.awt.Color(255, 0, 0));
        lbl_branch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        lbl_branch.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_branch.setPlaceholder(" Enter Quantity");
        lbl_branch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_branchFocusLost(evt);
            }
        });
        lbl_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_branchActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 210, -1));

        lbl_studentId.setBackground(new java.awt.Color(255, 0, 0));
        lbl_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentId.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_studentId.setPlaceholder("Enter Student Id");
        lbl_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentIdFocusLost(evt);
            }
        });
        lbl_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 210, -1));

        lbl_studentName.setBackground(new java.awt.Color(255, 0, 0));
        lbl_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentName.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_studentName.setPlaceholder("Enter Book Name");
        lbl_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_studentNameFocusLost(evt);
            }
        });
        lbl_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 210, -1));

        lbl_course.setBackground(new java.awt.Color(255, 0, 0));
        lbl_course.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        lbl_course.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_course.setPlaceholder("Enter Auther Name");
        lbl_course.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_courseFocusLost(evt);
            }
        });
        lbl_course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_courseActionPerformed(evt);
            }
        });
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 210, 30));

        lbl_studentError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 230, 30));

        panal_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 350, 410));

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(0, 0, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jLabel9.setText("Book Details ");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 190, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 300, 2));

        lbl_bookError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel3.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 230, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Book Id:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Name:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Auther:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        lbl_quantity.setBackground(new java.awt.Color(255, 0, 0));
        lbl_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        lbl_quantity.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_quantity.setPlaceholder(" Enter Quantity");
        lbl_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_quantityFocusLost(evt);
            }
        });
        lbl_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_quantityActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 210, -1));

        lbl_bookId.setBackground(new java.awt.Color(255, 0, 0));
        lbl_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookId.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_bookId.setPlaceholder("Enter Book Id");
        lbl_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_bookIdFocusLost(evt);
            }
        });
        lbl_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookIdActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 210, -1));

        lbl_bookName.setBackground(new java.awt.Color(255, 0, 0));
        lbl_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookName.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_bookName.setPlaceholder("Enter Book Name");
        lbl_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_bookNameFocusLost(evt);
            }
        });
        lbl_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_bookNameActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 210, -1));

        lbl_auther.setBackground(new java.awt.Color(255, 0, 0));
        lbl_auther.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_auther.setForeground(new java.awt.Color(255, 255, 255));
        lbl_auther.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_auther.setPlaceholder("Enter Auther Name");
        lbl_auther.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_autherFocusLost(evt);
            }
        });
        lbl_auther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_autherActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_auther, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 210, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Quantity:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        lbl_bookError1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 230, 30));

        panal_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 410));

        jLabel6.setFont(new java.awt.Font("Sitka Display", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel6.setText("Student Details ");
        panal_main.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 40));

        jLabel14.setFont(new java.awt.Font("Sitka Display", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel14.setText("Student Details ");
        panal_main.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 140, 40));

        jLabel15.setFont(new java.awt.Font("Sitka Display", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel15.setText("Student Details ");
        panal_main.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 140, 40));

        jLabel16.setFont(new java.awt.Font("Sitka Display", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel16.setText("Student Details ");
        panal_main.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 140, 40));

        jLabel17.setFont(new java.awt.Font("Sitka Display", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel17.setText("Student Details ");
        panal_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 140, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel18.setText("Issue Details");
        panal_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 190, 50));

        jPanel5.setBackground(new java.awt.Color(255, 0, 0));
        jPanel5.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        panal_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 82, 310, 2));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("Enter Book Id");
        panal_main.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, 30));
        jLabel36.getAccessibleContext().setAccessibleName("Enter Student Id");

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panal_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("Issue Date");
        panal_main.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 230, 90, 50));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("Enter Student Id");
        panal_main.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 190, -1, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("Due Date");
        panal_main.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 290, 90, 50));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Issue Book");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panal_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 250, 40));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
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
        panal_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, -1, -1));
        panal_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 230, -1));
        panal_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 300, 230, -1));

        getContentPane().add(panal_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        setSize(new java.awt.Dimension(1051, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_branchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_branchFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_branchFocusLost

    private void lbl_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_branchActionPerformed

    private void lbl_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentIdFocusLost
       
    }//GEN-LAST:event_lbl_studentIdFocusLost

    private void lbl_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentIdActionPerformed

    private void lbl_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameFocusLost

    private void lbl_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameActionPerformed

    private void lbl_courseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_courseFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_courseFocusLost

    private void lbl_courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_courseActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        HomePage hpage=new HomePage();
           hpage.setVisible(true);
           dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void lbl_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_quantityFocusLost

    private void lbl_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_quantityActionPerformed

    private void lbl_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookIdFocusLost

    private void lbl_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookIdActionPerformed

    private void lbl_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookNameFocusLost

    private void lbl_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookNameActionPerformed

    private void lbl_autherFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_autherFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_autherFocusLost

    private void lbl_autherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_autherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_autherActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       if(!txt_bookId.getText().equals(""))
       {
        getBookDetails();
       }
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
      if(lbl_quantity.getText().equals("0"))
      {
           JOptionPane.showMessageDialog(this,"book is not available");
      }
      else{
          
           if( isAlreadyIssued()==false)
        {
             if(issueBook()== true)
         {
             JOptionPane.showMessageDialog(this,"book issued  the successfully");
             bookCount();
             
         }
         else
         {
               JOptionPane.showMessageDialog(this,"cant issued  book");
         }
            
        }else
        {
             JOptionPane.showMessageDialog(this,"This student already has this book ");
            
        }
        
          
      }
        
       
        
        
        
       
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void panal_mainFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panal_mainFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panal_mainFocusLost

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
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
    private app.bolivia.swing.JCTextField lbl_auther;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookError1;
    private app.bolivia.swing.JCTextField lbl_bookId;
    private app.bolivia.swing.JCTextField lbl_bookName;
    private app.bolivia.swing.JCTextField lbl_branch;
    private app.bolivia.swing.JCTextField lbl_course;
    private app.bolivia.swing.JCTextField lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private app.bolivia.swing.JCTextField lbl_studentId;
    private app.bolivia.swing.JCTextField lbl_studentName;
    private javax.swing.JPanel panal_main;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
