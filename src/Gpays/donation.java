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
public class donation extends javax.swing.JFrame {

    static int n, r;
    
    public donation() {
        initComponents();
    }
    public void showdonationrecord(){
        int rupee=0,persons=0;
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query="select * from donationrecord where FundName='"+comname.getText()+"'";
           PreparedStatement ps=con.prepareStatement(query);
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
               float totalrupe=rs.getFloat("TotalAmount");
              int totperson=rs.getInt("TotalDepositor");
               rupee+=totalrupe;
               persons+=totperson;
           }
             count.setText("<html><b>"+"₹"+rupee+"</b><br></br>"+"  from  "+"<b>"+persons+"</b>"+"  donations so far"+"</html");
           
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void membersdonation(){
        try{
            Connection con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
            r=Integer.parseInt(amt.getText());
           String query22="Insert into donationrecord( FundName, TotalAmount, TotalDepositor) Values ('"+comname.getText()+"', '"+r+"', '"+n+"')";                  
                               PreparedStatement  pa22=con11.prepareStatement(query22);
                               pa22.execute();
        }catch(Exception e){
            System.out.println(e);
        }
    }
     public void rewards(){
        String[] arr={"50","1", "2", "3", "4", "5","100","0","10"};
      	Random r=new Random();        
      	int randomNumber=r.nextInt(arr.length);
      	//System.out.println(arr[randomNumber]);
        if(randomNumber==0){
            ImageIcon icon2 = new ImageIcon("src/Logo/2381381.png");
            JOptionPane.showMessageDialog(null, "Better Luck Next Time..!","Rewards", JOptionPane.INFORMATION_MESSAGE, icon2);
        }else{
            try{
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");            
                String query2 = "select * from account where AccountNo = '" +accno.getText()+ "' ";
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
                      String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + accno.getText() + "' ";
                       PreparedStatement  pa=con11.prepareStatement(query);                        
                          pa.execute(); 
                          ImageIcon icon3 = new ImageIcon("src/Logo/dd.png");
       // JOptionPane.showMessageDialog(null, "Congratulation..! You have Won ₹",+randomNumber+":- Rewards", JOptionPane.WARNING_MESSAGE, icon3);
        JOptionPane.showMessageDialog(null, "Congrats!! You have Won ₹ "+ randomNumber,"Level finished", JOptionPane.WARNING_MESSAGE,icon3);
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Credited";
                String t="Rewards";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+accno.getText()+"', '"+randomNumber+"', '"+Debit+"','"+t+"')";
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
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        accno = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        savechild = new javax.swing.JLabel();
        pmcares = new javax.swing.JLabel();
        odishafund = new javax.swing.JLabel();
        wbrelief = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        donate = new javax.swing.JButton();
        des = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        count = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel1.setText("Google Pay");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 70));

        name.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        name.setForeground(new java.awt.Color(255, 102, 102));
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/1.png"))); // NOI18N
        name.setText("jLabel2");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 240, 80));

        accno.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accno.setText("jLabel3");
        jPanel1.add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 100, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jLabel4.setText("Community & Donations");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 240, 40));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("*  CAF India");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, -1));

        savechild.setBackground(new java.awt.Color(153, 153, 153));
        savechild.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        savechild.setForeground(new java.awt.Color(0, 102, 204));
        savechild.setText("*  Save the Children");
        savechild.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savechild.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savechildMouseClicked(evt);
            }
        });
        jPanel1.add(savechild, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        pmcares.setBackground(new java.awt.Color(153, 153, 153));
        pmcares.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        pmcares.setForeground(new java.awt.Color(0, 102, 204));
        pmcares.setText("*  PM CARES Fund");
        pmcares.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pmcares.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pmcaresMouseClicked(evt);
            }
        });
        jPanel1.add(pmcares, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        odishafund.setBackground(new java.awt.Color(153, 153, 153));
        odishafund.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        odishafund.setForeground(new java.awt.Color(0, 102, 204));
        odishafund.setText("*  Odisha Chief Minister's Relief Fund");
        odishafund.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        odishafund.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                odishafundMouseClicked(evt);
            }
        });
        jPanel1.add(odishafund, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        wbrelief.setBackground(new java.awt.Color(153, 153, 153));
        wbrelief.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        wbrelief.setForeground(new java.awt.Color(0, 102, 204));
        wbrelief.setText("*  West Bengal State Emergency Relief Fund ");
        wbrelief.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        wbrelief.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wbreliefMouseClicked(evt);
            }
        });
        jPanel1.add(wbrelief, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("*  Kerala Chief Minsters Distress Relief Fund");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 204));
        jLabel9.setText("*  GiveIndia");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        amt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amtActionPerformed(evt);
            }
        });
        jPanel1.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 180, 40));

        donate.setBackground(new java.awt.Color(102, 102, 102));
        donate.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        donate.setForeground(new java.awt.Color(153, 255, 51));
        donate.setText("Donate");
        donate.setBorder(null);
        donate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donateActionPerformed(evt);
            }
        });
        jPanel1.add(donate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, 90, 40));

        des.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        des.setToolTipText("");
        jPanel1.add(des, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 240, 130));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Donate Now");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 100, 20));

        comname.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jPanel1.add(comname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 160, 30));

        jLabel10.setText("Every Rupee Counts");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 120, -1));

        count.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jPanel1.add(count, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 220, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void amtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtActionPerformed

    private void donateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donateActionPerformed
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
                        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                        String Date2 = sdf2.format(new Date());
                        Connection con11 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","") ;  
                         String query="update account set Deposit='"+SenderBalanceUpdate+"' where AccountNo='" + accno.getText() + "' ";
                         String query1="Insert into donatedb(AccountNo, FundName, Amount, Date) Values ('"+accno.getText()+"', '"+comname.getText()+"', '"+amt.getText()+"', '"+Date2+"')";
                        
                         PreparedStatement  pa=con11.prepareStatement(query);
                         PreparedStatement  pa2=con11.prepareStatement(query1);                      
                          pa.execute(); 
                          pa2.execute();                          
                          
                          ImageIcon icon = new ImageIcon("src/Logo/1916606.png");
                        JOptionPane.showMessageDialog(null, "Sucessfully Payed...!","Customized Dialog", JOptionPane.INFORMATION_MESSAGE, icon);
                           // JOptionPane.showMessageDialog(null,"Sucessfully Payed...!");
                           n++;
                           membersdonation();                            
                           n=0;    
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String t="Donations";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+accno.getText()+"', '"+amt.getText()+"', '"+Debit+"','"+t+"')";
               PreparedStatement pst5 = con11.prepareStatement(query5);
               pst5.execute();
                //con2.setText("");
                amt.setText("");
                
               rewards();
               showdonationrecord();
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
        
    }//GEN-LAST:event_donateActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
        comname.setText("CAFIndia ");
        des.setText("<html><br>"+"Tide Over the 2nd COVID Wave"+"</br>"+"<br>"+
                "The 2nd wave of COVID has dealt a severe blow to India. We're mobilizing resources to strengthen the healthcare infrastructure, help"+"</br>"
                + "<br>"+"marginalized groups, frontline workers and essential services providers Donate Now."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void savechildMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savechildMouseClicked
        // TODO add your handling code here:
         comname.setText("Save the Children ");
        des.setText("<html><br>"+"CHIDREN IN CRISIS CANNOT WAIT"+"</br>"+"<br>"+
                "The Second wave of COVID-19 has engulfed the country"+"</br>"
                + "<br>"+"and it poses a serious threat to the health and well-being of children."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_savechildMouseClicked

    private void pmcaresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pmcaresMouseClicked
        // TODO add your handling code here:
         comname.setText("PM Cares Fund ");
        des.setText("<html><br>"+"People from all walks of life expressed their desire to donate to india's war aganist COVID-19."+"</br>"+"<br>"+
                "Respecting that spirit the prime minsiter citizens assitance and relief in emergency situations fund has been "+"</br>"
                + "<br>"+"consituted it is my appeal to my fellow indians to kindly contribute to PM cares fund."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_pmcaresMouseClicked

    private void odishafundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_odishafundMouseClicked
        // TODO add your handling code here:
         comname.setText("Odisha Relief Fund");
        des.setText("<html><br>"+"Contribute here to support Covid19 relief efforts in"+"</br>"+"<br>"+
                "Odisha. The funds will be directly deposited to the Government of Odisha "+"</br>"
                + "<br>"+"Chief Minister Relief Fund for COVID-19."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_odishafundMouseClicked

    private void wbreliefMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wbreliefMouseClicked
        // TODO add your handling code here:
         comname.setText("West Bengal Relief Fund ");
        des.setText("<html><br>"+"Support West Bengal Fight COVID-19"+"</br>"+"<br>"+
                "Help by donating to the West Bengal State Emergency Relief Fund. Contribution is entitled for 100% exemption"+"</br>"
                + "<br>"+"under 80G of the Income Tax Act. Contribution from CSR fund is also allowed"+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_wbreliefMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
          comname.setText("Kerala Refief Fund ");
        des.setText("<html><br>"+"Kerala is in a battle aganist COVID-19"+"</br>"+"<br>"+
                "The People of the State have shown great courgae and tenacity in this fight aganist the pandemic"+"</br>"
                + "<br>"+"The outbreak and the consequent disruption have affected and the lives of many. You can help by contribute in it."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
          comname.setText("Give India CovidSOS ");
        des.setText("<html><br>"+"CovidSOS: Help India breathe again"+"</br>"+"<br>"+
                "Donate to provide oxygen life saving equipment & set up covid care centers so our health workers can"+"</br>"
                + "<br>"+"safely treat & save patients. Join the mission to support critical coivd care."+"</br></html");
      showdonationrecord();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(donation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new donation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel accno;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel comname;
    private javax.swing.JLabel count;
    private javax.swing.JLabel des;
    private javax.swing.JButton donate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel name;
    private javax.swing.JLabel odishafund;
    private javax.swing.JLabel pmcares;
    private javax.swing.JLabel savechild;
    private javax.swing.JLabel wbrelief;
    // End of variables declaration//GEN-END:variables
}
