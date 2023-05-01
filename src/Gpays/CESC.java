/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gpays;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CESC extends javax.swing.JFrame {

    public CESC() {
        initComponents();
         acc.setVisible(false);
         
    }
    public static void showallnumbers2(){
        try{
             try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")) {
                 String query2 = "select ConsumerNo from cesccno where AccountNo='" + acc.getText() + "' ";
                 Statement st = con.createStatement();
                 ResultSet  rs2 = st.executeQuery(query2);
                 while(rs2.next()){
                     String nu=rs2.getString("ConsumerNo");
                     com1.addItem(nu);
                                     
                 }}
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e);
           System.out.println(e);
       }
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        av = new javax.swing.JLabel();
        acc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        com1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        Pay = new javax.swing.JButton();
        con2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        addAcc = new javax.swing.JButton();
        con1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sucess = new javax.swing.JLabel();
        conlabel = new javax.swing.JLabel();
        amtlabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(104, 195, 211));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel2.setText("Google Pay");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        av.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        av.setForeground(new java.awt.Color(240, 240, 240));
        av.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        av.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                avMouseClicked(evt);
            }
        });
        jPanel1.add(av, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 80));

        acc.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        acc.setForeground(new java.awt.Color(240, 240, 240));
        acc.setText("xxxxxxxxxxx");
        jPanel1.add(acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("CESC Bill Payment ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        com1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                com1MouseClicked(evt);
            }
        });
        com1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                com1ActionPerformed(evt);
            }
        });
        jPanel1.add(com1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 140, -1));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 30, 20));

        Pay.setBackground(new java.awt.Color(51, 51, 51));
        Pay.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        Pay.setForeground(new java.awt.Color(102, 255, 102));
        Pay.setText("Pay");
        Pay.setBorder(null);
        Pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayActionPerformed(evt);
            }
        });
        jPanel1.add(Pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 100, 40));
        jPanel1.add(con2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 130, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Consumer No");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Amount ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, -1, -1));

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
        jPanel1.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 130, -1));

        addAcc.setBackground(new java.awt.Color(51, 51, 51));
        addAcc.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        addAcc.setForeground(new java.awt.Color(102, 255, 102));
        addAcc.setText("+ Add Account");
        addAcc.setBorder(null);
        addAcc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAccActionPerformed(evt);
            }
        });
        jPanel1.add(addAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 100, 30));

        con1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                con1MouseExited(evt);
            }
        });
        jPanel1.add(con1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 150, 30));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Consumer No ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("PAY YOUR BILLS WITH SECURE & TRUST.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));
        jPanel1.add(sucess, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 194, 50, 20));

        conlabel.setForeground(new java.awt.Color(255, 51, 0));
        jPanel1.add(conlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 150, 20));

        amtlabel.setForeground(new java.awt.Color(255, 51, 0));
        jPanel1.add(amtlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 414, 130, 20));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Consumer No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query1=" select * from account where Name='"+av.getText()+"' ";
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

    private void addAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAccActionPerformed
         ImageIcon icon = new ImageIcon("src/Logo/right.png");
         ImageIcon icon2 = new ImageIcon("src/Logo/cancel.png");
        try{
             Connection con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;  
             String query1="Insert into cesccno(AccountNo, ConsumerNo) Values ('"+acc.getText()+"', '"+con1.getText()+"')";
              PreparedStatement  pa2=con11.prepareStatement(query1);
                          pa2.execute();             
            sucess.setIcon(icon);
        }catch(Exception e){
            System.out.println(e);
            sucess.setIcon(icon2);
        }
        
        String num=con1.getText();
        if(num.isEmpty()){
           // JOptionPane.showMessageDialog(null,  "Sorry we can't add your number ......try again", JOptionPane.INFORMATION_MESSAGE, icon2);
           JOptionPane.showMessageDialog(null, "Sorry we can't add your number ......try again");
        }else{
            com1.addItem(num);
            con1.setText("");
        }
    }//GEN-LAST:event_addAccActionPerformed

    private void com1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_com1ActionPerformed
        // TODO add your handling code here:
                con2.setText((String) com1.getSelectedItem());
    }//GEN-LAST:event_com1ActionPerformed

    private void PayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayActionPerformed
        // TODO add your handling code here:
        
         try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");            
            String query2 = "select * from account where AccountNo = '" +acc.getText()+ "' ";
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
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                        String Date2 = sdf2.format(new Date());
                        Connection con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;  
                         String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + acc.getText() + "' ";
                         String query1="Insert into cesc(AccountNo, ConsumerNo, Amount, Date) Values ('"+acc.getText()+"', '"+con2.getText()+"', '"+amt.getText()+"', '"+Date2+"')";
                         PreparedStatement  pa=con11.prepareStatement(query);
                         PreparedStatement  pa2=con11.prepareStatement(query1);
                          pa.execute(); 
                          pa2.execute();
                          
                          ImageIcon icon = new ImageIcon("src/Logo/1916606.png");
                        JOptionPane.showMessageDialog(null, "Sucessfully Payed...!","Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);
                           // JOptionPane.showMessageDialog(null,"Sucessfully Payed...!");
                            
                            
                            
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String t="Electricity";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+acc.getText()+"', '"+amt.getText()+"', '"+Debit+"','"+t+"')";
               PreparedStatement pst5 = con11.prepareStatement(query5);
               pst5.execute();
                con2.setText("");
                amt.setText("");
                
               rewards(); 
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
    }//GEN-LAST:event_PayActionPerformed

    private void avMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_avMouseClicked
        // TODO add your handling code here:
         acc.setVisible(true);
    }//GEN-LAST:event_avMouseClicked

    private void com1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_com1MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_com1MouseClicked

    private void con1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_con1MouseExited
        // TODO add your handling code here:
         String getac= con1.getText();
        String v=Integer.toString(11);   
       if(getac.equals(v)){
           conlabel.setText("Please Input Valid Consumer Number");      
   }  
    }//GEN-LAST:event_con1MouseExited

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void amtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amtMouseExited
        // TODO add your handling code here:
         String getac= amt.getText();
        String v=Integer.toString(0);   
       if(getac.equals(v)){
           amtlabel.setText("Please Input Minimum Amount 100");
       }
    }//GEN-LAST:event_amtMouseExited

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
            java.util.logging.Logger.getLogger(CESC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CESC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CESC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CESC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CESC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pay;
    public static javax.swing.JLabel acc;
    private javax.swing.JButton addAcc;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel amtlabel;
    public static javax.swing.JLabel av;
    public static javax.swing.JComboBox<String> com1;
    private javax.swing.JTextField con1;
    private javax.swing.JTextField con2;
    private javax.swing.JLabel conlabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel sucess;
    // End of variables declaration//GEN-END:variables
}
