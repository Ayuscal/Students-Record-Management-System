/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package srms;

import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import srms.login_frame.Signup_frame;

/**
 *
 * @author Ayuscal
 */
public final class RegistrationFormDisplay extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationFormDisplay
     */
  // private String  sname;
     Connection con = null;
     java.sql.PreparedStatement ps = null, ps1 = null;
     ResultSet rs = null;
   // fee_structure fc = new fee_structure();
     
     
     
     @SuppressWarnings("UseOfObsoleteCollectionType")
     // Vector v = null;
     
     
    /**
     * Creates new form dispayRecord_frame
     */
     
  
     RegistrationFormDisplay(String result) throws SQLException, ClassNotFoundException, SecurityException, IllegalArgumentException, IllegalAccessException {
      // dispayRecord_frame df = new dispayRecord_frame();
       //df.setVisible(true);
    //  fee_structure.DISPOSE_ON_CLOSE();
       initComponents();
        Connect();
        
       //loadStudentImage(result);

       // loadTable1();
       ///for image
       //String result = null;
    /*  try { 
          Class<?> cls = Class.forName("srms.fee_structure");
           Field declaredField = cls.getDeclaredField("selectedName");
           declaredField.setAccessible(true);
           Object get = declaredField.get(new fee_structure());
           result = (String) get;
           if (result != null) {
             result = result.trim();
            } else {
                System.out.println("Error: 'result' is null.");
                 }

           
           
          
       } catch (NoSuchFieldException ex) {
           Logger.getLogger(RegistrationFormDisplay.class.getName()).log(Level.SEVERE, null, ex);
       }*/
        
    
            
        table1.setModel(new DefaultTableModel(
    new Object [][] {
        {null},
        {"Name:"},
        {"Registration_No:"},
        {"Exam Roll_No.:"},
        {"Faculty:"},
        {"Program:"},
        {"Name of Campus:"}
    },
    new String [] {
        "  ADMIT CARD"
    }
) );

        
        
        if (result == null || result.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: Student name is not provided.");
        return;
    }
    result = result.trim();
    System.out.println("Got Name: " + result);
              ps1 = con.prepareStatement("SELECT name, registration_no, roll_no, Faculty, program, name_of_camp, imag from admit_card WHERE name = ?");
              ps1.setString(1, result);
                rs = ps1.executeQuery();
                if (rs.next()){
                    String imagePath = rs.getString("imag");
                    if (imagePath != null && !imagePath.isEmpty()) {
                    File file = new File(imagePath);
                    if (file.exists()) {
                    ImageIcon icon = new ImageIcon(imagePath);
                    Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
                    lable.setIcon(new ImageIcon(img));
    } else {
        lable.setText("Image Not Found");
    }
} else {
    lable.setText("No Image");
}
                
            DefaultTableModel dtm = new DefaultTableModel(
            new Object[] {"Name", "Reg No", "Faculty", "Program"}, 0);
            dtm = new DefaultTableModel(
            new Object[] {"ADMIT CARD"," "},0);
            
            table1.setModel(dtm);

       
        // Reload the table data
        //loadTableData();
            ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        
       // while (rs.next()) {
           
            // Loop through each column
            for (int i = 1; i <= columnCount; i++) {
                 Vector<Object> row = new Vector<>();
                 row.add(metaData.getColumnName(i));  // Column name
                 row.add(rs.getString(i));  // Corresponding value
                dtm.addRow(row);  // Add row with column name and value
            //}  
             
        }
                }
           //initComponents();
            ps = con.prepareStatement("SELECT * FROM course");
                rs = ps.executeQuery();
            DefaultTableModel model =(DefaultTableModel) table2.getModel();
            model.setRowCount(0);

while(rs.next()){ 
  //  v = new Vector();
  Vector<Object> v = new Vector<>();
  //  for(int i = 1; i<=n; i++){
        v.add(rs.getString("sn"));
        v.add(rs.getString("course_code"));
        v.add(rs.getString("credit_hour"));
        v.add(rs.getString("course_item"));
       // v.add(rs.getString("Sm_yr"));
        
         //v.add(rs.getObject(i));
//}
model.addRow(v);
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lable = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Welcome", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 36), new java.awt.Color(255, 255, 255))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "HWHI COLLEGE", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 1, 36), new java.awt.Color(0, 102, 102))); // NOI18N

        table1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "  ADMIT CARD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        table2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.N.", "Course Code", "Credit Hour", "Course Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);
        if (table2.getColumnModel().getColumnCount() > 0) {
            table2.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("OFFICE OF THE EXAM MANAGEMENT");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("KATHMANDU,NEPAL");

        lable.setFont(new java.awt.Font("Segoe UI Variable", 1, 36)); // NOI18N
        lable.setForeground(new java.awt.Color(0, 102, 102));
        lable.setText("PHOTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        
    
   /* private void loadStudentImage(String result) {
    try {
        ps = con.prepareStatement("SELECT imag FROM admit_card WHERE name = ?");
        ps.setString(1, result);
        rs = ps.executeQuery();

        if (rs.next()) {
    byte[] imageBytes = rs.getBytes("imag");
    if (imageBytes != null) {
    ImageIcon icon = new ImageIcon(imageBytes);
    Image img = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
    lable.setIcon(new ImageIcon(img));
    } else {
    lable.setText("No Image");
    }

        } else {
            lable.setText("No Image Found");
        }
    } catch (SQLException ex) {
        
        
    }
}*/


//Method for connection establishment    
    public final void Connect(){
        
try{ 
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdbms","root","");
    } catch (ClassNotFoundException ex) {
    }
       
        System.out.println("Database Connected successfully.");
      //  System.out.println("SQL Query: " + ps.toString());

    }
    catch( SQLException ex)
    {
        Logger.getLogger(Signup_frame.class.getName()).log(Level.SEVERE, null, ex);
    }   
    }
    
    public static void main(String args[], String result) {
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
            java.util.logging.Logger.getLogger(RegistrationFormDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationFormDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new RegistrationFormDisplay(result).setVisible(true);
            } catch (SQLException | ClassNotFoundException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(RegistrationFormDisplay.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lable;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

  

  
}
