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
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    //to fetch the book details from the database it to book details panel 
   public void getBookDetails(){
       int bookId = Integer.parseInt(txt_bookId.getText());
       
       
       try
       {
         Connection con=DBConnection.getConnection();
            PreparedStatement pst = con. prepareStatement("Select * from book_details where book_id= ?");
           pst.setInt(1,bookId);
         ResultSet  rs =pst.executeQuery();
           
           
           if(rs.next())
           {
               lbl_IssueId.setText(rs.getString("book_id"));
               lbl_bookName.setText(rs.getString("book_name"));
              lbl_studentName.setText(rs.getString("auther"));
               lbl_dueDate.setText(rs.getString("quantity"));
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
   //to fetch the issue book details from the database and display it to panel
   public void getIssueBookDetails()
   {
    //   boolean success =false;
       
       int bookId = Integer.parseInt(txt_bookId.getText());
       int studentId =Integer.parseInt(txt_studentId.getText());
       
       try
       {
           Connection con = DBConnection.getConnection();
           String sql="select * from issue_book_details where book_id=?  and student_id=? and  status=? ";         
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
            
                lbl_IssueId.setText(rs.getString("id"));
                lbl_bookName.setText(rs.getString("book_name"));
                lbl_studentName.setText(rs.getString("student_name"));
                lbl_issueDate.setText(rs.getString("issue_date"));
                lbl_dueDate.setText(rs.getString("due_Date"));
                lbl_bookError.setText("");
                
            }else{
                lbl_bookError.setText("No Record Found");
              
                lbl_IssueId.setText(rs.getString(""));
                lbl_bookName.setText(rs.getString(""));
                lbl_studentName.setText(rs.getString(""));
                lbl_issueDate.setText(rs.getString(""));
                lbl_dueDate.setText(rs.getString(""));
            }
            
           
       }catch(SQLException e)
       {
           e.printStackTrace();
       }
       // return success;
   }
   //return the book
   public boolean returned ()
   {
       boolean isReturned = false;
       int bookId = Integer.parseInt(txt_bookId.getText());
       int studentId = Integer.parseInt(txt_studentId.getText());
       
       try
       {
           Connection con =DBConnection.getConnection();
           String sql ="update issue_book_details set status=? where student_id=? and book_id=? and status =?";
            PreparedStatement pst =con.prepareStatement(sql);
           pst.setString(1,"returned");
           pst.setInt(2,studentId);
           pst.setInt(3, bookId);
           pst.setString(4, "pending");
           
           int rowCount=pst.executeUpdate();
           if(rowCount>0)
           {
               isReturned=true;
               
           }
           else
           {
               isReturned=false;
               
           }
           
       }catch(Exception e)
       {
          e.printStackTrace();
       }
       return isReturned;
   }
 
   
 
   //updating  book count
   
   public void bookCount(){
       int bookId =Integer.parseInt(txt_bookId.getText());
       try
       {
           Connection con = DBConnection.getConnection();
           String sql = "update book_details set quatity = quantity + 1 where book_id=?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,bookId);
           
         int  rowCount = pst.executeUpdate();
           if(rowCount>0)
                 {
                     JOptionPane.showMessageDialog(this,"book count update");
                    
                 }
                 else
                 {
                         JOptionPane.showMessageDialog(this," can t update book count ");
                      
                 }
                   
       } catch (Exception ex) {
          ex.printStackTrace();
        }
   }
   //checking whether book already allocated or not

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
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_dueDate = new app.bolivia.swing.JCTextField();
        lbl_IssueId = new app.bolivia.swing.JCTextField();
        lbl_bookName = new app.bolivia.swing.JCTextField();
        lbl_studentName = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        lbl_bookError1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_issueDate = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel38 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

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

        jPanel3.setBackground(new java.awt.Color(255, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 230, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Issue Id:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Name:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Student Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        lbl_dueDate.setBackground(new java.awt.Color(255, 0, 0));
        lbl_dueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_dueDate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_dueDate.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_dueDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_dueDateFocusLost(evt);
            }
        });
        lbl_dueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_dueDateActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 210, 30));

        lbl_IssueId.setBackground(new java.awt.Color(255, 0, 0));
        lbl_IssueId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_IssueId.setForeground(new java.awt.Color(255, 255, 255));
        lbl_IssueId.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_IssueId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_IssueIdFocusLost(evt);
            }
        });
        lbl_IssueId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_IssueIdActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_IssueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 210, -1));

        lbl_bookName.setBackground(new java.awt.Color(255, 0, 0));
        lbl_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bookName.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
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
        jPanel3.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 210, -1));

        lbl_studentName.setBackground(new java.awt.Color(255, 0, 0));
        lbl_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_studentName.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
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
        jPanel3.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 210, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Due Date");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, 30));

        lbl_bookError1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_bookError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(lbl_bookError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 230, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Issue Date:");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        lbl_issueDate.setBackground(new java.awt.Color(255, 0, 0));
        lbl_issueDate.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        lbl_issueDate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_issueDate.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lbl_issueDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lbl_issueDateFocusLost(evt);
            }
        });
        lbl_issueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbl_issueDateActionPerformed(evt);
            }
        });
        jPanel3.add(lbl_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 210, -1));

        jLabel8.setBackground(new java.awt.Color(102, 102, 255));
        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel8.setText("Back");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        panal_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 410));

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
        jLabel18.setText("Return Book");
        panal_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 190, 50));

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

        panal_main.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 310, 2));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText(" Book Id");
        panal_main.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, 30));
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
        panal_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("Enter Student Id");
        panal_main.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, -1, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 51, 255));
        rSMaterialButtonCircle1.setText("Return Book");
        rSMaterialButtonCircle1.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        panal_main.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 250, 40));

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
        panal_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, -1, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("FIND");
        rSMaterialButtonCircle2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panal_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 250, 40));

        getContentPane().add(panal_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 570));

        setSize(new java.awt.Dimension(739, 414));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panal_mainFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panal_mainFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_panal_mainFocusLost

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        getIssueBookDetails();
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if( returned()==true)
       {
            JOptionPane.showMessageDialog(this," Book return successfull ");
            bookCount();
       }
       else
       {
            
           JOptionPane.showMessageDialog(this," Book return failed ");
       }
              
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
       
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        HomePage hpage=new HomePage();
        hpage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void lbl_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameActionPerformed

    private void lbl_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_studentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_studentNameFocusLost

    private void lbl_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookNameActionPerformed

    private void lbl_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bookNameFocusLost

    private void lbl_IssueIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_IssueIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_IssueIdActionPerformed

    private void lbl_IssueIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_IssueIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_IssueIdFocusLost

    private void lbl_dueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_dueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_dueDateActionPerformed

    private void lbl_dueDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_dueDateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_dueDateFocusLost

    private void lbl_issueDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbl_issueDateFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_issueDateFocusLost

    private void lbl_issueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_issueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_issueDateActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private app.bolivia.swing.JCTextField lbl_IssueId;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookError1;
    private app.bolivia.swing.JCTextField lbl_bookName;
    private app.bolivia.swing.JCTextField lbl_dueDate;
    private app.bolivia.swing.JCTextField lbl_issueDate;
    private app.bolivia.swing.JCTextField lbl_studentName;
    private javax.swing.JPanel panal_main;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo1;
    private rojeru_san.componentes.RSDateChooserBeanInfo rSDateChooserBeanInfo2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
