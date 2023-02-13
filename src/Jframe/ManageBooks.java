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
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    String bookName,auther;
    int bookId,quantity;
    DefaultTableModel model;
    
    public ManageBooks() {
        initComponents();
         setBookDetatilsToTable();
    }
    //to set set th book details in database
    public void setBookDetatilsToTable()
    {
        try{  Class.forName("com.mysql.cj.jdbc.Driver");
                con =DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
                  Statement  st =con.createStatement();
                  ResultSet rs = st.executeQuery("Select * from book_details");
                  
                  
                  while(rs.next())
                  {
                      String bookId = rs.getString("book_id");
                      String bookName =rs.getString("book_name");
                      String author =rs.getString("auther");
                      int quantity =rs.getInt("quantity");
                      
                      Object[]obj ={bookId,bookName,author,quantity};
                      model=(DefaultTableModel)tbl_bookDetails.getModel();
                      model.addRow(obj);
                      
                  }
            
        }catch(Exception e ){
           e.printStackTrace();
        }
        
    }
//to add book to book_detAILS  TABLE
    public boolean addbook()
    {
        boolean isAdded=false;
        
        bookId =Integer.parseInt(txt_bookId.getText());
        bookName=txt_bookName.getText();
        auther =txt_autherName.getText();
        quantity =Integer.parseInt( txt_quantity.getText());
        
        try{
           java.sql.Connection con=DBConnection.getConnection();
           String sql ="insert into book_details values(?,?,?,?)";
          PreparedStatement pst = con. prepareStatement(sql);
          pst.setInt(1,bookId);
          pst.setString(2, bookName);
          pst.setString(3, auther);
          pst.setInt(4, quantity);
          
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
    //to update book Detatils
    
    public boolean updateBook()
    {
        boolean isUpdate = false;
        
         bookId =Integer.parseInt(txt_bookId.getText());
        bookName=txt_bookName.getText();
        auther =txt_autherName.getText();
        quantity =Integer.parseInt( txt_quantity.getText());
        try
        {
             java.sql.Connection con=DBConnection.getConnection();
             String sql = "update book_details set book_name=?,auther=?,quantity=? where book_id=?";
             PreparedStatement pst = con. prepareStatement(sql);
             pst.setString(1,bookName);
             pst.setString(2, auther);
             pst.setInt(3, quantity);
             pst.setInt(4, bookId);
             
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
        DefaultTableModel model= (DefaultTableModel) tbl_bookDetails.getModel();
        model.setRowCount(0);
    }
    //method to delete book detail
    public boolean deleteBook()
            {
                boolean isDelete= false;
                bookId =Integer.parseInt(txt_bookId.getText());
                try
                {
                    java.sql.Connection con=DBConnection.getConnection();
                    String sql= "delete from book_details where book_id= ?";
                    PreparedStatement pst =con.prepareStatement(sql);
                    pst.setInt(1, bookId);
                    
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
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_autherName = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
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
        jLabel8.setText("Enter Book Id");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Enter Book Name");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 120, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 30, -1));

        txt_bookId.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setText("3");
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
        jPanel3.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Auther Name");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 50));

        txt_autherName.setBackground(new java.awt.Color(102, 102, 255));
        txt_autherName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_autherName.setPlaceholder("Enter Auther Name");
        txt_autherName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_autherNameFocusLost(evt);
            }
        });
        jPanel3.add(txt_autherName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Quantity");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, 30));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setPlaceholder("Enter Quantity");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        jPanel3.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

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

        txt_bookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setPlaceholder("Enter Book Name");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        txt_bookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookNameActionPerformed(evt);
            }
        });
        jPanel3.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 200, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 420));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Auther", "Quantity"
            }
        ));
        tbl_bookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 102));
        tbl_bookDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 10)); // NOI18N
        tbl_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 12)); // NOI18N
        tbl_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 13)); // NOI18N
        tbl_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tbl_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 400, 220));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel17.setText("Manage Book");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 290, 2));

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

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_autherNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_autherNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_autherNameFocusLost

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
             if(deleteBook()==true)
        {
            JOptionPane.showMessageDialog(this, "Book Delete");
            clearTable();
            setBookDetatilsToTable();
             
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
        if(updateBook()==true)
        {
            JOptionPane.showMessageDialog(this, "Book update");
            clearTable();
            setBookDetatilsToTable();
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle4ActionPerformed

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

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

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_bookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookNameActionPerformed

    private void tbl_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bookDetailsMouseClicked
        int rowNo =tbl_bookDetails.getSelectedRow();
        TableModel Model=tbl_bookDetails.getModel();
        
        txt_bookId.setText(model.getValueAt(rowNo,0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
         txt_autherName.setText(model.getValueAt(rowNo, 2).toString());
          txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
        
        
    }//GEN-LAST:event_tbl_bookDetailsMouseClicked

    private void rSMaterialButtonCircle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3MouseClicked
        if(addbook()==true)
        {
            JOptionPane.showMessageDialog(this, "Book Added");
            clearTable();
            setBookDetatilsToTable();
             
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Book Addition Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3MouseClicked

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private app.bolivia.swing.JCTextField txt_autherName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
