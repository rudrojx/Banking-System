/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gpays;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class MobileRecharge extends javax.swing.JFrame {

    /**
     * Creates new form MobileRecharge
     */
    public MobileRecharge() {
        initComponents();
        accno.setVisible(true);
         
    }

    public static void showallnumbers(){
         try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
           String query2 = "select MobileNo from mrecharge where AccountNo='"+accno.getText()+"'";
           Statement st = con.createStatement();
           ResultSet  rs2 = st.executeQuery(query2);
            while(rs2.next()){
                 //String nu=rs2.getString("MobileNo");
               combo1.addItem(rs2.getString("MobileNo"));             
                
            }
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
           System.out.println(e);
       }
       mob2.setText((String) combo1.getSelectedItem());
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
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        na = new javax.swing.JLabel();
        accno = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        mob1 = new javax.swing.JTextField();
        addnumber = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        mob2 = new javax.swing.JTextField();
        combo1 = new javax.swing.JComboBox<>();
        pay = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        combo2 = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        amtlabel = new javax.swing.JLabel();
        moblabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel2.setText("Google Pay");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 210, 70));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(240, 240, 240));
        jButton1.setText("X");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 20, 20));

        na.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        na.setText("xxxxxxxxxxxxx");
        na.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naMouseClicked(evt);
            }
        });
        jPanel1.add(na, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 80));

        accno.setText("xxxxxxxxxxx");
        jPanel1.add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel6.setText("Mobile Recharge Payment ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jLabel7.setText("Mobile Number");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        mob1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mob1MouseExited(evt);
            }
        });
        jPanel1.add(mob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 140, 30));

        addnumber.setBackground(new java.awt.Color(51, 51, 51));
        addnumber.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        addnumber.setForeground(new java.awt.Color(255, 255, 255));
        addnumber.setText("+ Add Number");
        addnumber.setBorder(null);
        addnumber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnumberActionPerformed(evt);
            }
        });
        jPanel1.add(addnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 110, 30));

        jLabel8.setText("Mobile Number ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));
        jPanel1.add(mob2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 130, -1));

        combo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo1MouseClicked(evt);
            }
        });
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });
        jPanel1.add(combo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 130, -1));

        pay.setBackground(new java.awt.Color(51, 51, 51));
        pay.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        pay.setForeground(new java.awt.Color(255, 255, 255));
        pay.setText("Pay");
        pay.setBorder(null);
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 100, 40));

        jLabel9.setText("Amount ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        amt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amtMouseExited(evt);
            }
        });
        jPanel1.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 130, -1));

        jLabel10.setText("Select Mobile Number ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel11.setText("Select Operator ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jio", "Aritel", "VI" }));
        jPanel1.add(combo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 130, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, 10));

        amtlabel.setForeground(new java.awt.Color(255, 51, 0));
        jPanel1.add(amtlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 130, 20));

        moblabel.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(moblabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 130, 20));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 520));

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
       try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select * from account where Name='"+na.getText()+"' ";
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1); 
                if(rss.next()){
                   String Na=rss.getString("Name");                   
                   dispose();
                     Paybills p=new Paybills();
                    p.setVisible(true);                    
                    p.avatar2.setText(Na);                  
                    
                }else{
                JOptionPane.showMessageDialog(null,"Error");                
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnumberActionPerformed
        // TODO add your handling code here:
        String num=mob1.getText();
        if(num.isEmpty()){
           JOptionPane.showMessageDialog(null, "Sorry we can't add your number ......try again");
        }else{
            combo1.addItem(num);
            mob1.setText("");
        }
        
    }//GEN-LAST:event_addnumberActionPerformed

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed
        // TODO add your handling code here:     
       mob2.setText((String) combo1.getSelectedItem());
    }//GEN-LAST:event_combo1ActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
            String query2 = "select * from account where AccountNo = '" +accno.getText()+ "' ";
            PreparedStatement pst2 = con.prepareStatement(query2);
            ResultSet rs2 = pst2.executeQuery();
            if(rs2.next())
            {
                String depo=rs2.getString("Deposit");
                 float senderAmount,enteredAmount;
                 senderAmount = Float.parseFloat(depo);
                 enteredAmount = Float.parseFloat(amt.getText());
                 if( senderAmount >= enteredAmount)
                 {
                   Float SenderBalanceSubstraction = senderAmount-enteredAmount;
                   String SenderBalanceUpdate = Float.toString(SenderBalanceSubstraction);
                   try{
                        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;  
                         String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + accno.getText() + "' ";
                         String query1="Insert into mrecharge(AccountNo, MobileNo, Operator, Amount) Values ('"+accno.getText()+"', '"+mob2.getText()+"', '"+combo2.getSelectedItem()+"', '"+amt.getText()+"')";
                         PreparedStatement  pa=con1.prepareStatement(query);
                         PreparedStatement  pa2=con1.prepareStatement(query1);
                          pa.execute(); 
                          pa2.execute();
                          
                          ImageIcon icon = new ImageIcon("src/Logo/5964748.png");
                        JOptionPane.showMessageDialog(null, "Sucessfully Recharged...!","Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);
                            //JOptionPane.showMessageDialog(null,"Sucessfully Recharged...!");
                            
                            
                            
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String t="Recharge";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+accno.getText()+"', '"+amt.getText()+"', '"+Debit+"','"+t+"')";
               PreparedStatement pst5 = con1.prepareStatement(query5);
               pst5.execute();
                
               mob2.setText("");
               amt.setText("");
                   }catch(Exception ee){
                       System.out.println(ee);
                       JOptionPane.showMessageDialog(null, ee);
                   }
                 }
                 else{
                      JOptionPane.showMessageDialog(null,"Insaficient balance in your account please check");
                                    amt.setText("");
                 }
            }else
            {
                JOptionPane.showMessageDialog(null, "Server Error");
            }
        }catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_payActionPerformed

    private void naMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naMouseClicked
        // TODO add your handling code here:
        accno.setVisible(true);
    }//GEN-LAST:event_naMouseClicked

    private void combo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo1MouseClicked
        // TODO add your handling code here:
         
    mob2.setText((String) combo1.getSelectedItem());
    }//GEN-LAST:event_combo1MouseClicked

    private void amtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amtMouseExited
        // TODO add your handling code here:
         String getac= amt.getText();
        String v=Integer.toString(0);   
       if(getac.equals(v)){
           amtlabel.setText("Please Input Valid Consumer Number");      
   }  
    }//GEN-LAST:event_amtMouseExited

    private void mob1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mob1MouseExited
        // TODO add your handling code here:
         String getac= mob1.getText();
        String v=Integer.toString(10);   
       if(getac.equals(v)){
           moblabel.setText("Please Input Valid Consumer Number");      
   }  
    }//GEN-LAST:event_mob1MouseExited

    
       
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
            java.util.logging.Logger.getLogger(MobileRecharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MobileRecharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MobileRecharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MobileRecharge.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MobileRecharge().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel accno;
    private javax.swing.JButton addnumber;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel amtlabel;
    private static javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField mob1;
    public static javax.swing.JTextField mob2;
    private javax.swing.JLabel moblabel;
    public static javax.swing.JLabel na;
    private javax.swing.JButton pay;
    // End of variables declaration//GEN-END:variables
}