package Gpays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class reward extends javax.swing.JFrame {

    public reward() {
        initComponents(); 
        rewardsection();
        totalrewards();
        accno.setVisible(false);
    }
    public static void totalrewards(){
        String rew="Rewards";
        int rupee=0;
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query="select Amount from transactions where Type='"+rew+"'and AccountNo='"+accno.getText()+"'";
           PreparedStatement ps=con.prepareStatement(query);
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
               float totalrupe=rs.getFloat("Amount");
               rupee+=totalrupe;
               
           }
             totrewards.setText("<html><b>"+"₹"+rupee+"</b>"+"</html");
           
        }catch(Exception e){
            System.out.println(e);
        }
    }

   public static void rewardsection(){
       String rr="Rewards";
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query = "Select * from transactions where AccountNo='"+accno.getText()+"' and Type='"+rr+"' ";
            PreparedStatement pst = connect.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)rewardtable.getModel();            
            tableModel.setRowCount(0);
           
            while(rs.next()){
                                            
                String Dates = rs.getNString("Date");               
                float Senderamount = rs.getFloat("Amount");               
                Object SenderTableData[] ={Dates,  Senderamount};
                                            
                tableModel = (DefaultTableModel)rewardtable.getModel();                
                tableModel.addRow(SenderTableData);
                
            }
            connect.close();                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rewardtable = new javax.swing.JTable();
        accno = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        totrewards = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setText("Rewards Section");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, 50));

        rewardtable.setBackground(new java.awt.Color(255, 204, 102));
        rewardtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Amount"
            }
        ));
        jScrollPane1.setViewportView(rewardtable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 350, -1));
        jPanel1.add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 110, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/FzxBBPrs-removebg-preview.png"))); // NOI18N
        jLabel3.setText("Google Pay");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 70));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, 10));

        totrewards.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(totrewards, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 50, 40));

        jLabel2.setText("Total Rewards ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(reward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reward.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new reward().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel accno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable rewardtable;
    public static javax.swing.JLabel totrewards;
    // End of variables declaration//GEN-END:variables
}
