/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gpays;

import static java.awt.SystemColor.text;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class AccountTransfer extends javax.swing.JFrame {

/**
   /**
     * Creates new form AccountTransfer
     */
    public AccountTransfer() {
        initComponents();
        jpin.setVisible(false);
        epin.setVisible(false);
        send.setVisible(false);
         acc.setVisible(false);
        
    }
    
    
     public void rewards(){
        String[] arr={"0","1", "2", "3", "4", "5","100","0"};
      	Random r=new Random();        
      	int randomNumber=r.nextInt(arr.length);
      	//System.out.println(arr[randomNumber]);
        if(randomNumber==0){
            ImageIcon icon2 = new ImageIcon("src/Logo/2381381.png");
            JOptionPane.showMessageDialog(null, "Better Luck Next Time..!","Rewards", JOptionPane.INFORMATION_MESSAGE, icon2);
        }else{
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");            
                String query2 = "select * from account where AccountNo = '" +acc.getText()+ "' ";
                PreparedStatement pst2 = con.prepareStatement(query2);
                ResultSet rs2 = pst2.executeQuery();
                 if(rs2.next())
            {
                String depo=rs2.getString("Deposit");
                 float senderAmount;
                 senderAmount = Float.parseFloat(depo);
                 Float SenderBalanceSubstraction = senderAmount+randomNumber;
                 String SenderBalanceUpdate = Float.toString(SenderBalanceSubstraction);
                 try{
                      Connection con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;  
                      String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + acc.getText() + "' ";
                       PreparedStatement  pa=con11.prepareStatement(query);                        
                          pa.execute(); 
                          ImageIcon icon3 = new ImageIcon("src/Logo/dd.png");
       // JOptionPane.showMessageDialog(null, "Congratulation..! You have Won ₹",+randomNumber+":- Rewards", JOptionPane.WARNING_MESSAGE, icon3);
        JOptionPane.showMessageDialog(null, "Congrats!! You have Won ₹ "+ randomNumber,"Level finished", JOptionPane.WARNING_MESSAGE,icon3);
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Credited";
                String t="Rewards";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+acc.getText()+"', '"+randomNumber+"', '"+Debit+"','"+t+"')";
               PreparedStatement pst5 = con11.prepareStatement(query5);
               pst5.execute();
        
                 }catch(Exception c){
                     System.out.println(c);
                     JOptionPane.showMessageDialog(null,c); 
                 }
            }else{
                     JOptionPane.showMessageDialog(null,"Error in ResultSet"); 
                 }
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(null,e); 
            }
           
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        accno = new javax.swing.JTextField();
        cif = new javax.swing.JTextField();
        amt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        send = new javax.swing.JButton();
        term = new javax.swing.JCheckBox();
        avatar3 = new javax.swing.JLabel();
        jpin = new javax.swing.JLabel();
        epin = new javax.swing.JTextField();
        acc = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        accnolabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ciflabel = new javax.swing.JLabel();
        icocif = new javax.swing.JLabel();
        amtlabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel2.setText("Google Pay");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 220, 70));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Account No ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("CIF ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Amount ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        accno.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                accnoCaretUpdate(evt);
            }
        });
        accno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accnoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accnoMouseExited(evt);
            }
        });
        accno.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                accnoInputMethodTextChanged(evt);
            }
        });
        accno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accnoActionPerformed(evt);
            }
        });
        accno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                accnoPropertyChange(evt);
            }
        });
        getContentPane().add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 130, -1));

        cif.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cifMouseExited(evt);
            }
        });
        getContentPane().add(cif, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 130, -1));

        amt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                amtMouseExited(evt);
            }
        });
        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });
        getContentPane().add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 130, -1));

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
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 20, -1));

        send.setBackground(new java.awt.Color(102, 102, 102));
        send.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        send.setForeground(new java.awt.Color(255, 204, 0));
        send.setText("Send");
        send.setBorder(null);
        send.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });
        getContentPane().add(send, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 120, 40));

        term.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        term.setForeground(new java.awt.Color(0, 153, 204));
        term.setText("Please Select the Terms & Conditions");
        term.setBorder(null);
        term.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        term.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                termMouseClicked(evt);
            }
        });
        getContentPane().add(term, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 220, -1));

        avatar3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        avatar3.setForeground(new java.awt.Color(240, 240, 240));
        avatar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        avatar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avatar3MouseClicked(evt);
            }
        });
        getContentPane().add(avatar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 70));

        jpin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jpin.setForeground(new java.awt.Color(240, 240, 240));
        jpin.setText("Enter Pin ");
        getContentPane().add(jpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));
        getContentPane().add(epin, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 140, 40));

        acc.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        acc.setForeground(new java.awt.Color(240, 240, 240));
        acc.setText("xxxxxxxxx");
        getContentPane().add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("PAY YOUR BILLS WITH SECURE & TRUST.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, -1, -1));

        accnolabel.setForeground(new java.awt.Color(255, 51, 0));
        getContentPane().add(accnolabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 230, 20));
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));
        getContentPane().add(ciflabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 130, -1));
        getContentPane().add(icocif, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, 50, 20));

        amtlabel.setForeground(new java.awt.Color(255, 51, 51));
        getContentPane().add(amtlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 130, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/27135.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 620, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select * from account where Name='"+avatar3.getText()+"' ";
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1); 
                if(rss.next()){
                   String Na=rss.getString("Name");                   
                  Paybills p=new Paybills();
                    p.setVisible(true);
                    dispose();
                    p.avatar2.setText(Na);
                   
                    
                }else{
                JOptionPane.showMessageDialog(null,"Try Again Later","Error",JOptionPane.ERROR_MESSAGE);
                
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        // TODO add your handling code here:
      //  int amta =Integer.parseInt(amt.getText());
        try
        {
          
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            Statement st1=con.createStatement();
            ResultSet rs1 = st1.executeQuery("select * from account where Name='"+avatar3.getText()+"' ");
            String query2 = "select * from account where AccountNo = '" +accno.getText()+ "' ";
            PreparedStatement pst2 = con.prepareStatement(query2);
            ResultSet rs2 = pst2.executeQuery();
            if(rs1.next())
            {
                String ch=rs1.getString("Pin");
                String ch4= epin.getText();
                String SenderBalance = rs1.getString("Deposit");
            if( ch.equals(ch4))
            {
                  if(rs2.next())
                  {
                        String ReciverBalance= rs2.getString("Deposit");                                
                               
                                
                                float senderAmount,enteredAmount,ReciverAmount;
                                senderAmount = Float.parseFloat(SenderBalance);
                                enteredAmount = Float.parseFloat(amt.getText());
                                ReciverAmount = Float.parseFloat(ReciverBalance);
                                System.out.println(ReciverBalance);
                               
                                if( senderAmount >= enteredAmount){
                                   Float SenderBalanceSubstraction = senderAmount-enteredAmount;
                                   Float ReciverAmountAddition = enteredAmount+ReciverAmount;
                                    System.out.println(ReciverAmountAddition);
                                   String SenderBalanceUpdate = Float.toString(SenderBalanceSubstraction);
                                   String ReciverAmountUpdate = Float.toString(ReciverAmountAddition);
                
                try{
                    
                    Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;                       
                        
                        String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + acc.getText() + "' ";
                        String query22=" update account set Deposit='"+ReciverAmountUpdate+"' where AccountNo='" + accno.getText() + "' ";
                PreparedStatement  pa=con1.prepareStatement(query);
                 PreparedStatement  pa2=con1.prepareStatement(query22);
                        
                        pa.execute(); 
                        pa2.execute();
                        //JOptionPane.showMessageDialog(null,"Sucessfully Transfered...!");
                         ImageIcon icon = new ImageIcon("src/Logo/1916606.png");
                        JOptionPane.showMessageDialog(null, "Sucessfully Transfered...!","Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);
                        amtlabel.setText(""); 
                        jLabel6.setIcon(null);
                        icocif.setIcon(null);
                        
                         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String Credit = "Credited";
                String t="Transfer";
                String r="Received";
   String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit,Type) Values ('"+Date+"', '"+acc.getText()+"', '"+amt.getText()+"', '"+Debit+"','"+t+"')";
     String query6 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit,Type) Values ('"+Date+"', '"+accno.getText()+"', '"+amt.getText()+"', '"+Credit+"','"+r+"')";
       PreparedStatement pst5 = con1.prepareStatement(query5);
       PreparedStatement pst6 = con1.prepareStatement(query6);
      pst5.execute();
      pst6.execute();
        
      rewards();
      
      cif.setText("");
      accno.setText("");
      amt.setText("");
      term.setSelected(false);
      jpin.setVisible(false);
      epin.setVisible(false);
      send.setVisible(false);
                    }
            
                catch(Exception e){
                JOptionPane.showMessageDialog(null,"Server Down");
                System.out.println(e);
            }
                
            }
                                else{
                                    JOptionPane.showMessageDialog(null,"Insaficient balance in your account please check");
                                    amt.setText("");
                                }
                  }  else{
              JOptionPane.showMessageDialog(null,"Result Set Problem 2");  
            }                            
                                
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Pin");
            }
            }
            else{
              JOptionPane.showMessageDialog(null,"Result Set Problem");  
            }
            
            
        }
        catch(Exception ee){
            System.out.println(ee);
            JOptionPane.showMessageDialog(null,"Error");
        }       
        
    }//GEN-LAST:event_sendActionPerformed

    private void termMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termMouseClicked
        // TODO add your handling code here:
        if(term.isSelected()){
        jpin.setVisible(true);
        epin.setVisible(true);
        send.setVisible(true);
        }           
        else{
            JOptionPane.showMessageDialog(null,"Please Select Terms & Conditions");
        }
    }//GEN-LAST:event_termMouseClicked

    private void avatar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avatar3MouseClicked
        // TODO add your handling code here:
         acc.setVisible(true);
    }//GEN-LAST:event_avatar3MouseClicked

    private void accnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accnoActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_accnoActionPerformed

    private void accnoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accnoMouseExited
   accnocheck();
   String getac= accno.getText();
        String v=Integer.toString(9);
   if("".equals(accno.getText())){
       accnolabel.setText("Please Input Acc No");       
       if(!getac.equals(v)){
           accnolabel.setText("Please Input Valid Account Number");
       }
   }  
   
    }//GEN-LAST:event_accnoMouseExited

    void accnocheck(){
        String ano=accno.getText();
        ImageIcon icon = new ImageIcon("src/Logo/right.png");
        ImageIcon icon1 = new ImageIcon("src/Logo/cancel2.png");
        try{
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select AccountNo from account where AccountNo='"+accno.getText()+"' ";
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1); 
                if(rss.next()){
                   String acno=rss.getString("AccountNo");
                   if(acno.equals(ano)){
                      // jLabel6.setText("Account Match");
                       jLabel6.setIcon(icon);
                   }else{
                       //jLabel6.setText("Invalid");
                       jLabel6.setIcon(icon1);
                   }
                }else{
                //JOptionPane.showMessageDialog(null,"Try Again Later","Error",JOptionPane.ERROR_MESSAGE);
                   jLabel6.setIcon(icon1);
                }
        }catch(Exception e){
             System.out.println(e);
        }
    }
    private void accnoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_accnoInputMethodTextChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_accnoInputMethodTextChanged

    private void accnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accnoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_accnoMouseClicked

    private void accnoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_accnoPropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_accnoPropertyChange

    private void accnoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_accnoCaretUpdate
        // TODO add your handling code here:
         
    }//GEN-LAST:event_accnoCaretUpdate

    private void cifMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cifMouseExited
        // TODO add your handling code here:
        cifnocheck();
        String getac= cif.getText();
        String v=Integer.toString(9);
   if("".equals(cif.getText())){
       ciflabel.setText("Please Input Acc No");       
       if(!getac.equals(v)){
           ciflabel.setText("Please Input Valid Account Number");
       }
   }  
    }//GEN-LAST:event_cifMouseExited

    private void amtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amtMouseExited
        // TODO add your handling code here:        
   if("".equals(amt.getText())){
       amtlabel.setText("Please Enter Valid Amount");       
        }  
    }//GEN-LAST:event_amtMouseExited

    void cifnocheck(){
        String ano=accno.getText();
        ImageIcon icon = new ImageIcon("src/Logo/right.png");
        ImageIcon icon1 = new ImageIcon("src/Logo/cancel2.png");
        try{
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select AccountNo from account where AccountNo='"+accno.getText()+"' ";
            Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1); 
                if(rss.next()){
                   String acno=rss.getString("AccountNo");
                   if(acno.equals(ano)){
                      // jLabel6.setText("Account Match");
                       icocif.setIcon(icon);
                   }else{
                       //jLabel6.setText("Invalid");
                       icocif.setIcon(icon1);
                   }
                }else{
                //JOptionPane.showMessageDialog(null,"Try Again Later","Error",JOptionPane.ERROR_MESSAGE);
                   icocif.setIcon(icon1);
                }
        }catch(Exception e){
             System.out.println(e);
        }
    }
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
            java.util.logging.Logger.getLogger(AccountTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccountTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccountTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccountTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountTransfer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel acc;
    public static javax.swing.JTextField accno;
    private javax.swing.JLabel accnolabel;
    public static javax.swing.JTextField amt;
    private javax.swing.JLabel amtlabel;
    public static javax.swing.JLabel avatar3;
    public static javax.swing.JTextField cif;
    private javax.swing.JLabel ciflabel;
    private javax.swing.JTextField epin;
    private javax.swing.JLabel icocif;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jpin;
    private javax.swing.JButton send;
    private javax.swing.JCheckBox term;
    // End of variables declaration//GEN-END:variables
}
