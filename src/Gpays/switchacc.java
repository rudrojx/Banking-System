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
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class switchacc extends javax.swing.JFrame {

    /**
     * Creates new form switchacc
     */
    public switchacc() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pin = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Switch Account ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 255));
        jLabel3.setText("Pin :-");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, 30));
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 190, 30));

        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/gp.jpg"))); // NOI18N
        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        jPanel1.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 110, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/27620.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String password=pin.getText();
            Main m1=new Main();
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
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(switchacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(switchacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(switchacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(switchacc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new switchacc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pin;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}