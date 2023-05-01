package banksystem3;
import banksystem3.check;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Withdraw extends javax.swing.JFrame  {
//private int bal;
private	int withdraw;
PreparedStatement pa=null;   

    public Withdraw() {
        initComponents();
       // bal=Integer.parseInt(jTextField3.getText());       
	
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        withd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbalance = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Withdraw Money Portal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 20, 241, 45));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Account Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 129, 29));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 115, 150, 29));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 162, 150, 30));

        withd.setBackground(new java.awt.Color(255, 153, 0));
        withd.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        withd.setForeground(new java.awt.Color(240, 240, 240));
        withd.setText("WithDraw");
        withd.setBorder(null);
        withd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdActionPerformed(evt);
            }
        });
        getContentPane().add(withd, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 121, 32));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Withdraw Amount");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 139, 33));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(240, 240, 240));
        jButton2.setText("Clear");
        jButton2.setBorder(null);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 92, 32));

        cbalance.setBackground(new java.awt.Color(255, 153, 0));
        cbalance.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cbalance.setForeground(new java.awt.Color(240, 240, 240));
        cbalance.setText("CheckBalance");
        cbalance.setBorder(null);
        cbalance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbalanceActionPerformed(evt);
            }
        });
        getContentPane().add(cbalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 110, 30));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 130, 29));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Available Balance");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 130, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/35.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void withdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdActionPerformed
        
	withdraw=Integer.parseInt(jTextField2.getText());
	try {
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
 String query="UPDATE `account` SET `Deposit`=Deposit-"+withdraw+" WHERE AccountNo='"+jTextField1.getText()+"'";
 pa=con.prepareStatement(query);
//int rs=bal-withdraw; 
//String s=String.valueOf(rs);
//jTextField3.setText(s);
//pa.setString(2,jTextField1.getText());
 //pa.setString(1,s); 
       pa.executeUpdate(); 
 JOptionPane.showMessageDialog(null,"Sucessfully Withdraw");
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String t="Withdraw";
               String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+jTextField1.getText()+"', '"+withdraw+"', '"+Debit+"','"+t+"')";
               PreparedStatement pst5 = con.prepareStatement(query5);
               pst5.execute();
       con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error");
        }
				
         try {
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
 String query=" SELECT * FROM `account` WHERE AccountNo= '"+jTextField1.getText()+"' ";
 Statement sta = con.createStatement();
 ResultSet rs =  sta.executeQuery(query) ;
  while(rs.next()){
 String data =  rs.getString(17);
 jTextField3.setText(data);
 jTextField3.setEditable(false);
       }
       }
       catch(SQLException w){}      
        
    }//GEN-LAST:event_withdActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                        
                        jTextField2.setText("");
			 jTextField3.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbalanceActionPerformed
       try {
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
 String query=" SELECT * FROM `account` WHERE AccountNo= '"+jTextField1.getText()+"' ";
 Statement sta = con.createStatement();
 ResultSet rs =  sta.executeQuery(query) ;
  while(rs.next()){
 String data =  rs.getString(17);
 jTextField3.setText(data);
 jTextField3.setEditable(false);
       }
       }
       catch(SQLException w){}
    }//GEN-LAST:event_cbalanceActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Withdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cbalance;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton withd;
    // End of variables declaration//GEN-END:variables
}
