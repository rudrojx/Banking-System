/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gpays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Transaction extends javax.swing.JFrame {

   
    public Transaction() {
        initComponents();
        transactionHistory();
    }
    
        public static void transactionHistory(){
      
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")) {
                String query = "Select * from transactions where AccountNo='"+acountno.getText()+"' ";
                PreparedStatement pst = connect.prepareStatement(query);
                ResultSet rs = pst.executeQuery();
                DefaultTableModel tableModel = (DefaultTableModel)TransactionTable.getModel();
                tableModel.setRowCount(0);
                
                while(rs.next()){
                    
                    String SenderDate = rs.getNString("Date");
                    int SenderAc = rs.getInt("AccountNo");
                    float Senderamount = rs.getFloat("Amount");
                    String SenderDebit = rs.getNString("CreditDebit");
                    String Types=rs.getNString("Type");
                    Object SenderTableData[] ={SenderDate, SenderAc, Senderamount, SenderDebit,Types};
                    
                    tableModel = (DefaultTableModel)TransactionTable.getModel();
                    tableModel.addRow(SenderTableData);
                    
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        na = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        acountno = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(55, 123, 225));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "AccountNo", "Amount", "C/D", "Type"
            }
        ));
        jScrollPane1.setViewportView(TransactionTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 430, 340));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel1.setText("Google Pay");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, 70));

        na.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        na.setForeground(new java.awt.Color(240, 240, 240));
        na.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        jPanel1.add(na, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 70));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Transaction  Histroy");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

        acountno.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        acountno.setForeground(new java.awt.Color(240, 240, 240));
        acountno.setText("xxxxxxxxxxxx");
        jPanel1.add(acountno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("X");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 0, 20, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("PAY YOUR BILLS WITH SECURE & TRUST.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select * from account where Name='"+na.getText()+"' ";
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1); 
                if(rss.next()){
                   String Na=rss.getString("Name");                   
                   dispose();
                Main m=new Main();
                m.setVisible(true);
                    m.avatar.setText(Na);
                   
                    
                }else{
                JOptionPane.showMessageDialog(null,"Error");
                
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TransactionTable;
    public static javax.swing.JLabel acountno;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel na;
    // End of variables declaration//GEN-END:variables
}