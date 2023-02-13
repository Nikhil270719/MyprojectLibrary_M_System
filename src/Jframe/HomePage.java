/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Jframe;

import static Jframe.DBConnection.con;
import java.util.*;
import java.sql.*;

import com.mysql.cj.protocol.Resultset;
import com.sun.jdi.connect.spi.Connection;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Rw
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(51,51,51);
    Color mouseExitColor =new Color(0,0,0);
        DefaultTableModel model;
    public HomePage() {
        Timer();
        initComponents();
        showPieChart();
        setStudentDetatilsToTable();
       setBookDetatilsToTable();
       setDataToCards();
        
    }
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
    
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
     try{
         Connection con =(Connection) DBConnection.getConnection();
         String sql="select book_name,count(*)as issue_count from issue_book_details group by book_id";
         Statement st = con.createStatement();
         ResultSet rs=st.executeQuery(sql);
         while(rs.next());
         {
             barDataset.setValue(rs.getString("book_name"),new Double(rs.getDouble("issue_count")));
         }
     }catch(Exception e)
     {
         e.printStackTrace();
     }
      
      
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Isssue book_Details",barDataset, true,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelPieChart.removeAll();
        panelPieChart.add(barChartPanel, BorderLayout.CENTER);
        panelPieChart.validate();
    }
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
public void setDataToCards()
{
    Statement st = null;
    Resultset rs = null;
    
    long l =System.currentTimeMillis();
    Date todayDate = new Date(l);
    
    try
    {
        Connection con= (Connection) DBConnection.getConnection();
        st = con.createStatment();
         rs = (Resultset) st.executeQuery("select * from book_details");
        rs.last();
       lbl_noofofBooks.setText(Integer.toString(rs.getRow()));
      rs = (Resultset) st.executeQuery("select * from student_details");
      rs.last();
      lbl_noOfstudents.setText(Integer.toString(rs.getRow()));
        
        rs = (Resultset) st.executeQuery("select * from issue_book_details");
      rs.last();
    no_issueBooks.setText(Integer.toString(rs.getRow()));
        
       rs = (Resultset) st.executeQuery("select * from issue_book_details where due_date<'"+todayDate+"'and status ='"+"pending"+"'");
      rs.last();
     lbl_defaulterList.setText(Integer.toString(rs.getRows()));
      
    }catch(Exception e)
    {
        e.printStackTrace();
        
    }
}
public  void Timer()
{
      try{
        Calendar c= Calendar.getInstance();
        System.out.println("Current Date Time:");
        System.out.format("%tB %te,%tY%n",c,c,c);
        System.out.format("%tl:%tM %tp%n",c,c,c);
    jLabel164_Timer.setText("%tB %te,%tY%n",c,c,c);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCTextField1 = new app.bolivia.swing.JCTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel164_Timer = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jpanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel44 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jPanel41 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jPanel52 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jPanel54 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jPanel55 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jPanel56 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jPanel58 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jPanel59 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jPanel60 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel61 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jPanel62 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jPanel63 = new javax.swing.JPanel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jPanel64 = new javax.swing.JPanel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jPanel65 = new javax.swing.JPanel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jPanel66 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jPanel67 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPanel68 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jPanel69 = new javax.swing.JPanel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jPanel70 = new javax.swing.JPanel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jPanel71 = new javax.swing.JPanel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jPanel72 = new javax.swing.JPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jPanel73 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jPanel74 = new javax.swing.JPanel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jPanel75 = new javax.swing.JPanel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jPanel76 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jPanel77 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jPanel78 = new javax.swing.JPanel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jPanel79 = new javax.swing.JPanel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jPanel80 = new javax.swing.JPanel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jPanel81 = new javax.swing.JPanel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jPanel82 = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jPanel85 = new javax.swing.JPanel();
        lbl_noofofBooks = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        jPanel86 = new javax.swing.JPanel();
        lbl_noOfstudents = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        jPanel87 = new javax.swing.JPanel();
        no_issueBooks = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jPanel88 = new javax.swing.JPanel();
        lbl_defaulterList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookDetails = new rojeru_san.complementos.RSTableMetro();
        panelPieChart = new javax.swing.JPanel();

        jCTextField1.setText("jCTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1900, 940));
        setSize(new java.awt.Dimension(1900, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 30));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel2.setText("Welcome, admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Managment System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel5MouseReleased(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164_Timer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel164_TimerAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jLabel164_Timer.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jLabel164_TimerComponentShown(evt);
            }
        });
        jPanel5.add(jLabel164_Timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 170, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1900, 70));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/home_24px.png"))); // NOI18N
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 20));

        jLabel5.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Home Page");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, 50));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Yu Gothic Medium", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 30));

        jLabel10.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LMS Dashboard");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, 30));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 50));

        jLabel9.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Features");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 80, 30));

        jpanel7.setBackground(new java.awt.Color(0, 0, 0));
        jpanel7.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jpanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Manage Books");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        jpanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jpanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel3.add(jpanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 50));

        jPanel7.setBackground(new java.awt.Color(102, 102, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Logout");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Manage Student");
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Manage Student");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Manage Student");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel23.setBackground(new java.awt.Color(0, 0, 0));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("View Record");
        jPanel23.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel23.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel24.setBackground(new java.awt.Color(0, 0, 0));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Manage Student");
        jPanel24.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel24.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel23.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel25.setBackground(new java.awt.Color(0, 0, 0));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Manage Student");
        jPanel25.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel25.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel26.setBackground(new java.awt.Color(0, 0, 0));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel49.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Manage Student");
        jPanel26.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel26.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel25.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel23.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel7.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel43.setBackground(new java.awt.Color(0, 0, 0));
        jPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("View Issue Book");
        jPanel43.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel43.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel44.setBackground(new java.awt.Color(0, 0, 0));
        jPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel85.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Manage Student");
        jPanel44.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel44.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel43.add(jPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel45.setBackground(new java.awt.Color(0, 0, 0));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Manage Student");
        jPanel45.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel45.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel46.setBackground(new java.awt.Color(0, 0, 0));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("Manage Student");
        jPanel46.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel46.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel45.add(jPanel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel43.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel47.setBackground(new java.awt.Color(0, 0, 0));
        jPanel47.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel91.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("View Record");
        jPanel47.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel47.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel48.setBackground(new java.awt.Color(0, 0, 0));
        jPanel48.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel93.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("Manage Student");
        jPanel48.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel48.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel47.add(jPanel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel49.setBackground(new java.awt.Color(0, 0, 0));
        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Manage Student");
        jPanel49.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel49.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel50.setBackground(new java.awt.Color(0, 0, 0));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("Manage Student");
        jPanel50.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel50.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel49.add(jPanel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel47.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel43.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel7.add(jPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, 50));

        jPanel11.setBackground(new java.awt.Color(0, 0, 0));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 204, 204));
        jLabel19.setText("Manage Student");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel11.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jPanel11.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Manage Student");
        jPanel12.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel12.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Manage Student");
        jPanel13.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel13.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel14.setBackground(new java.awt.Color(0, 0, 0));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Manage Student");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel14.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel13.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel11.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel3.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 50));

        jPanel15.setBackground(new java.awt.Color(0, 0, 0));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("Issue Book");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel15.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel16.setBackground(new java.awt.Color(0, 0, 0));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Manage Student");
        jPanel16.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel16.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel17.setBackground(new java.awt.Color(0, 0, 0));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Manage Student");
        jPanel17.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel17.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel18.setBackground(new java.awt.Color(0, 0, 0));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Manage Student");
        jPanel18.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel18.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, 50));

        jPanel19.setBackground(new java.awt.Color(0, 0, 0));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setText("Return Book");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });
        jPanel19.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jPanel19.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel20.setBackground(new java.awt.Color(0, 0, 0));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Manage Student");
        jPanel20.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel20.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel19.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel21.setBackground(new java.awt.Color(0, 0, 0));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Manage Student");
        jPanel21.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel21.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Manage Student");
        jPanel22.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel22.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel21.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel19.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel3.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 210, 50));

        jPanel27.setBackground(new java.awt.Color(0, 0, 0));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(204, 204, 204));
        jLabel51.setText("View Record");
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel51MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel51MouseExited(evt);
            }
        });
        jPanel27.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jPanel27.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Manage Student");
        jPanel28.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel28.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel29.setBackground(new java.awt.Color(0, 0, 0));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Manage Student");
        jPanel29.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel29.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel30.setBackground(new java.awt.Color(0, 0, 0));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Manage Student");
        jPanel30.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel30.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel27.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel31.setBackground(new java.awt.Color(0, 0, 0));
        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("View Record");
        jPanel31.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel31.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel32.setBackground(new java.awt.Color(0, 0, 0));
        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel61.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Manage Student");
        jPanel32.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel32.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel31.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel33.setBackground(new java.awt.Color(0, 0, 0));
        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Manage Student");
        jPanel33.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel33.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel34.setBackground(new java.awt.Color(0, 0, 0));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel65.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Manage Student");
        jPanel34.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel34.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel33.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel31.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel27.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel3.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel35.setBackground(new java.awt.Color(0, 0, 0));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(204, 204, 204));
        jLabel67.setText("View Issue Book");
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel67MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel67MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel67MouseExited(evt);
            }
        });
        jPanel35.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jPanel35.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel36.setBackground(new java.awt.Color(0, 0, 0));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Manage Student");
        jPanel36.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel36.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel35.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel37.setBackground(new java.awt.Color(0, 0, 0));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Manage Student");
        jPanel37.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel37.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel38.setBackground(new java.awt.Color(0, 0, 0));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Manage Student");
        jPanel38.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel38.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel37.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel35.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel39.setBackground(new java.awt.Color(0, 0, 0));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("View Record");
        jPanel39.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel39.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel40.setBackground(new java.awt.Color(0, 0, 0));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Manage Student");
        jPanel40.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel40.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel39.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel41.setBackground(new java.awt.Color(0, 0, 0));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Manage Student");
        jPanel41.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel41.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel42.setBackground(new java.awt.Color(0, 0, 0));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setText("Manage Student");
        jPanel42.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel42.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel41.add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel39.add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel35.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel3.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jPanel51.setBackground(new java.awt.Color(0, 0, 0));
        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("View Issue Book");
        jPanel51.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel51.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel52.setBackground(new java.awt.Color(0, 0, 0));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));
        jLabel101.setText("Manage Student");
        jPanel52.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel52.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel51.add(jPanel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel53.setBackground(new java.awt.Color(0, 0, 0));
        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Manage Student");
        jPanel53.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel104.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel53.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel54.setBackground(new java.awt.Color(0, 0, 0));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel105.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Manage Student");
        jPanel54.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel54.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel53.add(jPanel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel51.add(jPanel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel55.setBackground(new java.awt.Color(0, 0, 0));
        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(255, 255, 255));
        jLabel107.setText("View Record");
        jPanel55.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel55.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel56.setBackground(new java.awt.Color(0, 0, 0));
        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel109.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(255, 255, 255));
        jLabel109.setText("Manage Student");
        jPanel56.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel110.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel56.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel55.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel57.setBackground(new java.awt.Color(0, 0, 0));
        jPanel57.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel111.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setText("Manage Student");
        jPanel57.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel112.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel57.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel58.setBackground(new java.awt.Color(0, 0, 0));
        jPanel58.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 255, 255));
        jLabel113.setText("Manage Student");
        jPanel58.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel58.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel57.add(jPanel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel55.add(jPanel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel51.add(jPanel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel59.setBackground(new java.awt.Color(0, 0, 0));
        jPanel59.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("View Issue Book");
        jPanel59.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel59.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel60.setBackground(new java.awt.Color(0, 0, 0));
        jPanel60.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(255, 255, 255));
        jLabel117.setText("Manage Student");
        jPanel60.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel118.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel60.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel59.add(jPanel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel61.setBackground(new java.awt.Color(0, 0, 0));
        jPanel61.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setText("Manage Student");
        jPanel61.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel120.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel61.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel62.setBackground(new java.awt.Color(0, 0, 0));
        jPanel62.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("Manage Student");
        jPanel62.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel122.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel62.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel61.add(jPanel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel59.add(jPanel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel63.setBackground(new java.awt.Color(0, 0, 0));
        jPanel63.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel123.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 255, 255));
        jLabel123.setText("View Record");
        jPanel63.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel124.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel63.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel64.setBackground(new java.awt.Color(0, 0, 0));
        jPanel64.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel125.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setText("Manage Student");
        jPanel64.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel126.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel64.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel63.add(jPanel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel65.setBackground(new java.awt.Color(0, 0, 0));
        jPanel65.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel127.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(255, 255, 255));
        jLabel127.setText("Manage Student");
        jPanel65.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel128.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel65.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel66.setBackground(new java.awt.Color(0, 0, 0));
        jPanel66.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(255, 255, 255));
        jLabel129.setText("Manage Student");
        jPanel66.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel130.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel66.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel65.add(jPanel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel63.add(jPanel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel59.add(jPanel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel51.add(jPanel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jPanel3.add(jPanel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jPanel67.setBackground(new java.awt.Color(0, 0, 0));
        jPanel67.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel131.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(204, 204, 204));
        jLabel131.setText("Defaulter List");
        jLabel131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel131MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel131MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel131MouseExited(evt);
            }
        });
        jPanel67.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel132.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jPanel67.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel68.setBackground(new java.awt.Color(0, 0, 0));
        jPanel68.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(255, 255, 255));
        jLabel133.setText("Manage Student");
        jPanel68.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel68.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel67.add(jPanel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel69.setBackground(new java.awt.Color(0, 0, 0));
        jPanel69.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel135.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(255, 255, 255));
        jLabel135.setText("Manage Student");
        jPanel69.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel136.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel69.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel70.setBackground(new java.awt.Color(0, 0, 0));
        jPanel70.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel137.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(255, 255, 255));
        jLabel137.setText("Manage Student");
        jPanel70.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel70.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel69.add(jPanel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel67.add(jPanel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel71.setBackground(new java.awt.Color(0, 0, 0));
        jPanel71.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel139.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(255, 255, 255));
        jLabel139.setText("View Record");
        jPanel71.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel71.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel72.setBackground(new java.awt.Color(0, 0, 0));
        jPanel72.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(255, 255, 255));
        jLabel141.setText("Manage Student");
        jPanel72.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel72.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel71.add(jPanel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel73.setBackground(new java.awt.Color(0, 0, 0));
        jPanel73.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel143.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(255, 255, 255));
        jLabel143.setText("Manage Student");
        jPanel73.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel73.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel74.setBackground(new java.awt.Color(0, 0, 0));
        jPanel74.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel145.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(255, 255, 255));
        jLabel145.setText("Manage Student");
        jPanel74.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel74.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel73.add(jPanel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel71.add(jPanel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel67.add(jPanel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel75.setBackground(new java.awt.Color(0, 0, 0));
        jPanel75.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel147.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(255, 255, 255));
        jLabel147.setText("View Issue Book");
        jPanel75.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel75.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel76.setBackground(new java.awt.Color(0, 0, 0));
        jPanel76.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(255, 255, 255));
        jLabel149.setText("Manage Student");
        jPanel76.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel150.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel76.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel75.add(jPanel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel77.setBackground(new java.awt.Color(0, 0, 0));
        jPanel77.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(255, 255, 255));
        jLabel151.setText("Manage Student");
        jPanel77.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel152.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel77.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel78.setBackground(new java.awt.Color(0, 0, 0));
        jPanel78.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel153.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(255, 255, 255));
        jLabel153.setText("Manage Student");
        jPanel78.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel154.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel78.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel77.add(jPanel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel75.add(jPanel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel79.setBackground(new java.awt.Color(0, 0, 0));
        jPanel79.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel155.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(255, 255, 255));
        jLabel155.setText("View Record");
        jPanel79.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel79.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel80.setBackground(new java.awt.Color(0, 0, 0));
        jPanel80.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel157.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(255, 255, 255));
        jLabel157.setText("Manage Student");
        jPanel80.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel80.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel79.add(jPanel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel81.setBackground(new java.awt.Color(0, 0, 0));
        jPanel81.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel159.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(255, 255, 255));
        jLabel159.setText("Manage Student");
        jPanel81.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel160.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel81.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel82.setBackground(new java.awt.Color(0, 0, 0));
        jPanel82.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel161.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setText("Manage Student");
        jPanel82.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        jLabel162.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jPanel82.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        jPanel81.add(jPanel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel79.add(jPanel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 210, 50));

        jPanel75.add(jPanel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, 50));

        jPanel67.add(jPanel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 50));

        jPanel3.add(jPanel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 210, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 790));

        jPanel83.setBackground(new java.awt.Color(255, 255, 255));
        jPanel83.setForeground(new java.awt.Color(153, 153, 153));
        jPanel83.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel84.setBackground(new java.awt.Color(255, 0, 102));
        jPanel84.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel83.add(jPanel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 90));

        jPanel85.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel85.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noofofBooks.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_noofofBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noofofBooks.setText("10");
        jPanel85.add(lbl_noofofBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, -1));

        jPanel83.add(jPanel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, 90));

        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel163.setText("Student Details");
        jPanel83.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel165.setText("No of Students");
        jPanel83.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jPanel86.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel86.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_noOfstudents.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_noOfstudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfstudents.setText("10");
        jPanel86.add(lbl_noOfstudents, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 50));

        jPanel83.add(jPanel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 160, 90));

        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel167.setText("Issued Book");
        jPanel83.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jPanel87.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));
        jPanel87.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        no_issueBooks.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        no_issueBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        no_issueBooks.setText("10");
        jPanel87.add(no_issueBooks, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 100, 70));

        jPanel83.add(jPanel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, 90));

        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel169.setText("Defaulter List  ");
        jPanel83.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, -1, -1));

        jPanel88.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));
        jPanel88.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_defaulterList.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_defaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_defaulterList.setText("10");
        jPanel88.add(lbl_defaulterList, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));

        jPanel83.add(jPanel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 170, 90));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
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
        jScrollPane1.setViewportView(tbl_studentDetails);

        jPanel83.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 460, 160));

        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel171.setText("No of Book");
        jPanel83.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel172.setText("Book Details");
        jPanel83.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

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
        jScrollPane2.setViewportView(tbl_bookDetails);

        jPanel83.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 460, 160));

        panelPieChart.setLayout(new java.awt.BorderLayout());
        jPanel83.add(panelPieChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, 250, 300));

        getContentPane().add(jPanel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 800, 650));

        setSize(new java.awt.Dimension(1020, 762));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        ManageBooks books = new ManageBooks();
        books.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
      jpanel7.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jpanel7.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jPanel11.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
       jPanel11.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
       ManageStudent student = new ManageStudent();
       student.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
       jPanel15.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
         jPanel15.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
         IssueBook issuebook = new  IssueBook();
       issuebook.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        jPanel19.setBackground(mouseEnterColor);
        
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
          jPanel19.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel35MouseExited

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
       ReturnBook rbook =new ReturnBook();
       rbook.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
       ViewAllRecord vpage = new ViewAllRecord();
       vpage.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jLabel51MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseEntered
         jPanel27.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel51MouseEntered

    private void jLabel51MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseExited
        jPanel27.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel51MouseExited

    private void jLabel67MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseEntered
          jPanel35.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel67MouseEntered

    private void jLabel67MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseExited
        jPanel35.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel67MouseExited

    private void jLabel67MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseClicked
        IssuebookDetails ibdetails = new IssuebookDetails();
        ibdetails.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel67MouseClicked

    private void jLabel131MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseEntered
         jPanel67.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel131MouseEntered

    private void jLabel131MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseExited
         jPanel67.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel131MouseExited

    private void jLabel131MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel131MouseClicked
        DefaulterList dpage =new  DefaulterList();
        dpage.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jLabel131MouseClicked

    private void jPanel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseReleased

    }//GEN-LAST:event_jPanel5MouseReleased

    private void jLabel164_TimerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel164_TimerAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel164_TimerAncestorAdded

    private void jLabel164_TimerComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel164_TimerComponentShown
        jLabel164_Timer.add(this);
        Timer();
        
     
    }//GEN-LAST:event_jLabel164_TimerComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
          
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField jCTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164_Timer;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
    private javax.swing.JPanel jPanel65;
    private javax.swing.JPanel jPanel66;
    private javax.swing.JPanel jPanel67;
    private javax.swing.JPanel jPanel68;
    private javax.swing.JPanel jPanel69;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel70;
    private javax.swing.JPanel jPanel71;
    private javax.swing.JPanel jPanel72;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JPanel jPanel85;
    private javax.swing.JPanel jPanel86;
    private javax.swing.JPanel jPanel87;
    private javax.swing.JPanel jPanel88;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel7;
    private javax.swing.JLabel lbl_defaulterList;
    private javax.swing.JLabel lbl_noOfstudents;
    private javax.swing.JLabel lbl_noofofBooks;
    private javax.swing.JLabel no_issueBooks;
    private javax.swing.JPanel panelPieChart;
    private rojeru_san.complementos.RSTableMetro tbl_bookDetails;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    // End of variables declaration//GEN-END:variables
}
