/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gpays;

import static Gpays.ScanQr.getacc;
import static Gpays.ScanQr.getupid;
import static Gpays.ScanQr.scanqr;
import static Gpays.Transaction.acountno;
import static Gpays.Transaction.transactionHistory;
import static Gpays.reward.rewardsection;
import static Gpays.reward.totalrewards;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
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
        check = new javax.swing.JLabel();
        pay = new javax.swing.JLabel();
        trans = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        avatar = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        reward = new javax.swing.JLabel();
        Donations = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(107, 141, 223));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        check.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        check.setForeground(new java.awt.Color(255, 255, 255));
        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/surr-575.png"))); // NOI18N
        check.setText(" Check Balance");
        check.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkMouseClicked(evt);
            }
        });
        jPanel1.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 210, -1));

        pay.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/f2.png"))); // NOI18N
        pay.setText("Pay Bills");
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payMouseClicked(evt);
            }
        });
        jPanel1.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, -1));

        trans.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        trans.setForeground(new java.awt.Color(255, 255, 255));
        trans.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/flame-1259.png"))); // NOI18N
        trans.setText("Transcation Histroy");
        trans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transMouseClicked(evt);
            }
        });
        jPanel1.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, 90));

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 20, -1));

        avatar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        avatar.setForeground(new java.awt.Color(255, 255, 255));
        avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        jPanel1.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 70));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("PAY YOUR BILLS WITH SECURE & TRUST.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, -1, 20));

        jButton2.setBackground(new java.awt.Color(255, 204, 0));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Logout");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 30));

        reward.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        reward.setForeground(new java.awt.Color(255, 255, 255));
        reward.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/rewards.png"))); // NOI18N
        reward.setText("Rewards");
        reward.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reward.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rewardMouseClicked(evt);
            }
        });
        jPanel1.add(reward, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 170, 120));

        Donations.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Donations.setForeground(new java.awt.Color(255, 255, 255));
        Donations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/dona.png"))); // NOI18N
        Donations.setText(" Donations");
        Donations.setToolTipText("");
        Donations.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Donations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DonationsMouseClicked(evt);
            }
        });
        jPanel1.add(Donations, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 170, 110));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icons8-qr-code-24.png"))); // NOI18N
        jLabel3.setText("Scan my QR");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel1.setText("Google Pay");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // dispose();
       System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void payMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payMouseClicked
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select * from account where Name='"+avatar.getText()+"' ";
            
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1);  
                
                 if(rss.next()){
                   String Na=rss.getString("Name");
                   Paybills p=new Paybills();
                    p.setVisible(true);                   
                    dispose();
                    p.avatar2.setText(Na);
                    
                }else{
                JOptionPane.showMessageDialog(null,"Error");
                
                }
        }catch(Exception e){
            
        }
        
        
    }//GEN-LAST:event_payMouseClicked

    private void checkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMouseClicked
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where Name='"+avatar.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){
                   String Na=rss.getString("Name");
                   String acc=rss.getString("AccountNO");
                   String balance=rss.getString("Deposit");
                  checkbalance ch=new checkbalance() ;
                   ch.setVisible(true);                    
                    dispose();
                    ch.name.setText(Na);
                    ch.accno.setText(acc);
                    ch.bal.setText(balance);
                    
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_checkMouseClicked

    private void transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseClicked
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where Name='"+avatar.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){
                   String Na=rss.getString("Name");
                   String acc=rss.getString("AccountNO");                   
                  Transaction t=new Transaction();
                    t.setVisible(true);
                    dispose();
                    t.na.setText(Na);
                    t.acountno.setText(acc);
                    transactionHistory();
                    
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(Exception e){
            System.out.println(e);
        }
        
    }//GEN-LAST:event_transMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       switchacc l=new switchacc();
      l.setVisible(true);
      dispose();
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rewardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rewardMouseClicked
        // TODO add your handling code here:
         try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where Name='"+avatar.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){
                  // String Na=rss.getString("Name");
                   String acc=rss.getString("AccountNO");                   
                   reward r=new reward();
                    r.setVisible(true);                   
                    r.accno.setText(acc);
                    rewardsection();
                    totalrewards();
                    
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(Exception e){
            System.out.println(e);
        }
       
        
    }//GEN-LAST:event_rewardMouseClicked

    private void DonationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DonationsMouseClicked
        // TODO add your handling code here:        
         try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where Name='"+avatar.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){
                    String Na=rss.getString("Name");
                    String acc=rss.getString("AccountNO");                   
                   donation r=new donation();
                    r.setVisible(true);                   
                    r.accno.setText(acc);
                    r.name.setText(Na);                  
                    
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_DonationsMouseClicked
 
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where Name='"+avatar.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){
                       String p=rss.getString("Pin");  
                    String Na=rss.getString("Name");                   
                     String em=rss.getString("Email"); 
                     String mob=rss.getString("Mobile");
                   ScanQr r=new ScanQr();
                    r.setVisible(true);                  
                    r.userna.setText(Na); 
                    r.upitxt.setText(em);
                    r.pin4.setText(p);
                    r.ph.setText(mob);
                    getacc();
                    getupid();
                    scanqr();
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Donations;
    public static javax.swing.JLabel avatar;
    private javax.swing.JLabel check;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pay;
    private javax.swing.JLabel reward;
    private javax.swing.JLabel trans;
    // End of variables declaration//GEN-END:variables
}