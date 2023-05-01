package Gpays;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
static int len = 6;
    public Login() {
        initComponents();
//        pin.setVisible(false);
//        la.setVisible(false);
//        log.setVisible(false); 
//        caplabel.setVisible(false);
//       changecaptcha.setVisible(false);
//       captcha.setVisible(false);
//       cap.setVisible(false);
//        

  load.setVisible(false);
  pro.setVisible(false);
  per.setVisible(false);
    captcha.setText(generateRandomPassword(len));
       //captcha.setText(generateRandomPassword(len));
    }
 public static String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        la = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        pro = new javax.swing.JProgressBar();
        load = new javax.swing.JLabel();
        per = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        log = new javax.swing.JButton();
        pin = new javax.swing.JTextField();
        caplabel = new javax.swing.JLabel();
        cap = new javax.swing.JTextField();
        captcha = new javax.swing.JLabel();
        changecaptcha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 26)); // NOI18N
        jLabel2.setText("GOOGLE PAY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, 60));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        la.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        la.setForeground(new java.awt.Color(0, 102, 153));
        la.setText("Pin ");
        jPanel1.add(la, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 40, 30));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("X");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 30, 20));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 153));
        jLabel6.setText("PAY YOUR BILLS WITH SECURE & TRUST.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));
        jPanel1.add(pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 450, -1));

        load.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        load.setText("LOADING..");
        jPanel1.add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        per.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        per.setText("0%");
        jPanel1.add(per, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 40, 30));

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/8332728.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 140));

        log.setBackground(new java.awt.Color(51, 51, 51));
        log.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        log.setForeground(new java.awt.Color(102, 255, 102));
        log.setText("LOGIN");
        log.setBorder(null);
        log.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        jPanel1.add(log, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 80, 30));
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 140, 30));

        caplabel.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        caplabel.setForeground(new java.awt.Color(51, 102, 255));
        caplabel.setText("Captcha ");
        jPanel1.add(caplabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 70, 30));
        jPanel1.add(cap, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 140, 30));

        captcha.setFont(new java.awt.Font("Trebuchet MS", 2, 16)); // NOI18N
        captcha.setForeground(new java.awt.Color(51, 51, 51));
        captcha.setText("jLabel5");
        captcha.setIconTextGap(8);
        jPanel1.add(captcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 130, 40));

        changecaptcha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        changecaptcha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changecaptchaMouseClicked(evt);
            }
        });
        jPanel1.add(changecaptcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 40, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 110, 80));

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 520));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //dispose();
         System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        // TODO add your handling code here:
          // String password=pin.getText();
            Main m1=new Main();
             String getcap=cap.getText();
            try{
                if(getcap.equals(captcha.getText())){        
         try
        {
          
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             String query11="select Pin from account where Pin = '" +pin.getText()+ "' ";
          PreparedStatement  pa=con1.prepareStatement(query11);              
              ResultSet rs1 =  pa.executeQuery() ; 
            if(rs1.next())
            {
                String ch=rs1.getString("Pin");
                String ch4= pin.getText();                
            if( ch.equals(ch4))
            {
                try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
              String query=" select Pin from account where Pin='"+pin.getText()+"'  ";
              String query1=" select * from account where Pin='"+pin.getText()+"' ";
              
                PreparedStatement sta = con.prepareStatement(query);                
                Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query1);  
                ResultSet rs =  sta.executeQuery(query) ; 
             
               // sta.setString(1, password);                
                   
                
                if(rs.next() && rss.next()){
                   String Na=rss.getString("Name");
                   Main m=new Main() ;
                   m.setVisible(true);                    
                    dispose();
                    m1.avatar.setText(Na);
                    
                }else{
                JOptionPane.showMessageDialog(null,"Worng Password");
                pin.setText("");
                
                }
                       
        } catch(Exception ae){
            System.out.println(ae);
            JOptionPane.showMessageDialog(null,ae);
  }
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Pin");
            }
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Pin");
            }
        }catch(Exception aee){
            System.out.println(aee);
            JOptionPane.showMessageDialog(null,aee);
  }
            }else{
             JOptionPane.showMessageDialog(null,"Invalid Captcha");
              captcha.setText(generateRandomPassword(len));
              cap.setText("");
            
        }
            }
            catch(Exception e){
                System.out.println(e);        
                JOptionPane.showMessageDialog(null,e);
            }
    }//GEN-LAST:event_logActionPerformed

    private void changecaptchaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changecaptchaMouseClicked
        // TODO add your handling code here:
        captcha.setText(generateRandomPassword(len));
    }//GEN-LAST:event_changecaptchaMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Login ho = new Login(); 
         ho.setVisible(true);
         
//         try {
// for(int x = 0; x <=100; x++) 
//{ 
//    Thread.sleep(100);
//  ho.per.setText(x+"%");
//  if(x==10){
//    ho.load.setText("Loading On Modules...");
//  }if(x==20){
//    ho.load.setText("Loading Modules...");
//  }if(x==50){
//    ho.load.setText("Connecting...");
//  }
//  if(x==70){
//    ho.load.setText("Connection Sucessfull...");
//  }
//  if(x==80){
//    ho.load.setText("Launching Application...");
//  }
// ho.pro.setValue(x);
// 
//} 
//    la.setVisible(true);
//    pin.setVisible(true);
//     per.setVisible(false);
//    load.setVisible(false);
//    log.setVisible(true);
//      caplabel.setVisible(true);
//       changecaptcha.setVisible(true);
//       captcha.setVisible(true);
//       cap.setVisible(true);
//        
//       captcha.setText(generateRandomPassword(len));
//        
//} catch (Exception e) {
//    JOptionPane.showMessageDialog(null, e);
// }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField cap;
    public static javax.swing.JLabel caplabel;
    public static javax.swing.JLabel captcha;
    public static javax.swing.JLabel changecaptcha;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel la;
    private static javax.swing.JLabel load;
    private static javax.swing.JButton log;
    private static javax.swing.JLabel per;
    public static javax.swing.JTextField pin;
    private javax.swing.JProgressBar pro;
    // End of variables declaration//GEN-END:variables
}
