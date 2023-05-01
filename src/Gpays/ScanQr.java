package Gpays;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class ScanQr extends javax.swing.JFrame {

    public ScanQr() {
        initComponents();
        change.setVisible(false);
        sbi.setVisible(false);
        hdfc.setVisible(false);
        icici.setVisible(false);
        lb1.setVisible(false);
        ph.setVisible(false);
        pin4.setVisible(false);       
        getupid();
    }
   public static void getupid(){
       String u=upitxt.getText();
       String lastFourDigits = "";     //substring containing last 4 characters
       String firtsdigi="";
        int fdigi=u.length()-10;
if (u.length() > 11) 
{
    lastFourDigits = u.substring(u.length() - 10);
    firtsdigi =u.substring(0, fdigi);  //rudranath2438
} 
else
{
    lastFourDigits = u;
}
 
System.out.println(lastFourDigits);
lastFourDigits=sbi.getText();
u=u.replace(u,firtsdigi+lastFourDigits);
upitxt.setText(u);
   }
   public static void getacc(){
        try{
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
           String query2 = "select AccountNo from account where Pin='"+pin4.getText()+"'";
           Statement st = con.createStatement();
           ResultSet  rs2 = st.executeQuery(query2);
            while(rs2.next()){
                 //String nu=rs2.getString("MobileNo");
               cbank.addItem(rs2.getString("AccountNo"));
               cbank.setSelectedIndex(1);
                
            }
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
           System.out.println(e);
       }
    }
public static void scanqr(){
      String getlink=upitxt.getText();
       String getpath = "F:\\fileshare\\Gpay\\src\\Qr\\"+userna.getText()+".png";       
       int width =150;
       int height=150;    
       
       try{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(getlink, BarcodeFormat.QR_CODE, width, height);
         Path path2 = FileSystems.getDefault().getPath(getpath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path2);
        String picurl="F:\\fileshare\\Gpay\\src\\Qr\\"+userna.getText()+".png";
        ImageIcon imgThisImg = new ImageIcon(picurl);
        qrimg.setIcon(imgThisImg);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,"Error");
           System.out.println(e);
       }
       
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userna = new javax.swing.JLabel();
        qrimg = new javax.swing.JLabel();
        cbank = new javax.swing.JComboBox<>();
        upitxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pin4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb1 = new javax.swing.JLabel();
        change = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ph = new javax.swing.JLabel();
        sbi = new javax.swing.JRadioButton();
        hdfc = new javax.swing.JRadioButton();
        icici = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userna.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        userna.setForeground(new java.awt.Color(51, 102, 255));
        userna.setText("User Name ");
        jPanel1.add(userna, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 150, -1));
        jPanel1.add(qrimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 200, 190));

        cbank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Account Number" }));
        jPanel1.add(cbank, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 180, 30));
        jPanel1.add(upitxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 170, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel4.setText("Scan this code to pay me ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icons8-bhim-upi-50.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, 40));
        jPanel1.add(pin4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/icons8-bank-36.png"))); // NOI18N
        jLabel1.setText("Manage UPI IDs");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        lb1.setText("Choose one: -");
        jPanel1.add(lb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        change.setBackground(new java.awt.Color(51, 51, 51));
        change.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setText("Change");
        change.setBorder(null);
        change.setBorderPainted(false);
        change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeActionPerformed(evt);
            }
        });
        jPanel1.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 90, 30));

        jLabel2.setText("UPI ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, -1, -1));

        ph.setText("000000000");
        jPanel1.add(ph, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 70, -1));

        sbi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sbi.setForeground(new java.awt.Color(255, 51, 0));
        sbi.setText("@sbi");
        sbi.setContentAreaFilled(false);
        sbi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(sbi, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 443, -1, 30));

        hdfc.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hdfc.setForeground(new java.awt.Color(255, 51, 0));
        hdfc.setText("@hdfc");
        hdfc.setContentAreaFilled(false);
        hdfc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(hdfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 443, -1, 30));

        icici.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        icici.setForeground(new java.awt.Color(255, 51, 0));
        icici.setText("@icici");
        icici.setContentAreaFilled(false);
        icici.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(icici, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 443, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        change.setVisible(true);
        sbi.setVisible(true);
        hdfc.setVisible(true);
        icici.setVisible(true);
        lb1.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeActionPerformed
        // TODO add your handling code here:
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query="select * from account where Name='"+userna.getText()+"'";
            Statement st = con.createStatement();
           ResultSet  rs2 = st.executeQuery(query);
            if(rs2.next()){
                 String nu=rs2.getString("Email");
               //listname.addItem(rs2.getString("listname"));             
                if(hdfc.isSelected()){
            String u=nu;
       String lastFourDigits = "";     //substring containing last 4 characters
       String firtsdigi="";
        int fdigi=u.length()-10;
if (u.length() > 11) 
{
    lastFourDigits = u.substring(u.length() - 10);
    firtsdigi =u.substring(0, fdigi);  //rudranath2438
} 
else
{
    lastFourDigits = u;
}
 
System.out.println(lastFourDigits);
lastFourDigits=hdfc.getText();
u=u.replace(u,firtsdigi+lastFourDigits);
upitxt.setText(u);

        }
        if(icici.isSelected()){
            String u=nu;
       String lastFourDigits = "";     //substring containing last 4 characters
       String firtsdigi="";
        int fdigi=u.length()-10;
if (u.length() > 11) 
{
    lastFourDigits = u.substring(u.length() - 10);
    firtsdigi =u.substring(0, fdigi);  //rudranath2438
} 
else
{
    lastFourDigits = u;
}
 
System.out.println(lastFourDigits);
lastFourDigits=icici.getText();
u=u.replace(u,firtsdigi+lastFourDigits);
upitxt.setText(u);
        }
        if(sbi.isSelected()){            
            String u=nu;
       String lastFourDigits = "";     //substring containing last 4 characters
       String firtsdigi="";
        int fdigi=u.length()-10;
if (u.length() > 11) 
{
    lastFourDigits = u.substring(u.length() - 10);
    firtsdigi =u.substring(0, fdigi);  //rudranath2438
} 
else
{
    lastFourDigits = u;
}
 
System.out.println(lastFourDigits);
lastFourDigits=sbi.getText();
u=u.replace(u,firtsdigi+lastFourDigits);
upitxt.setText(u);
        } 
            }

        }catch(Exception e){
            System.out.println(e);
        }
       
    }//GEN-LAST:event_changeActionPerformed

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
            java.util.logging.Logger.getLogger(ScanQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScanQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScanQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScanQr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScanQr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> cbank;
    private javax.swing.JButton change;
    private javax.swing.JRadioButton hdfc;
    private javax.swing.JRadioButton icici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb1;
    public static javax.swing.JLabel ph;
    public static javax.swing.JLabel pin4;
    public static javax.swing.JLabel qrimg;
    public static javax.swing.JRadioButton sbi;
    public static javax.swing.JLabel upitxt;
    public static javax.swing.JLabel userna;
    // End of variables declaration//GEN-END:variables
}
