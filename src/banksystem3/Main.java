
package banksystem3;
import Gpays.Login;

import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
static int acc,cvv,dcc,cvv2;
static String a,m,n,b;
PreparedStatement pa=null; 
PreparedStatement pa2=null;
private int tra22;

    public Main() {       
        initComponents();
         transactionHistory();
        avatar.setVisible(false);
      jPanel5.setBackground(new Color(255,195,113)); 
      homesec.setBackground(new Color(44,62,80));
      jPanel11.setBackground(new Color(0,147,233));      
      
    }  
   
 
    public static  int ccno()
        {
            for(int k=0; k<=14; k++)
		 {
			 acc=acc+(int)(Math.random()*1000000000*1000);
                         
		 }
         a =(Integer.toString(acc));
            return acc;
        }
    
    public static int dcno()
        {
            for(int k=0; k<=13; k++)
		 {
			 dcc=dcc+(int)(Math.random()*1000000000*1000);
                         
		 }
         n =(Integer.toString(dcc));
            return dcc;
        }
    public static  int cvvno()
        {
            for(int k=0; k<=3; k++)
		 {
			 cvv=cvv+(int)(Math.random()*100);
                         
		 }
         m =(Integer.toString(cvv));
            return cvv;
        }
     public static  int cvvnoo()
        {
            for(int k=0; k<=3; k++)
		 {
			 cvv2=cvv2+(int)(Math.random()*100);
                         
		 }
         b =(Integer.toString(cvv2));
            return cvv2;
        }
     
     
/************************************************ Home Section ************************************************************/
     public  void hompanel(){
        
         try{
            Connection connn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");             
            String querya="Select * from account where Username='"+avatar.getText()+"' ";
            Statement stt=connn.createStatement();
            ResultSet rsss=stt.executeQuery(querya);      

        if(rsss.next())
    
        {
   
     String AccountNo00=rsss.getString("AccountNo");     
     String Name00=rsss.getString("Name");      
     String balance=rsss.getString("Deposit");   
     String Cname = rsss.getString("Name");
     acno123.setText(AccountNo00);
     name598.setText(Name00); 
     String bal = String.format("%s",balance);
     bal2.setText(bal);
     CusName.setText(Cname);
     
        }
        else{
         JOptionPane.showMessageDialog(null,"No Data"); 
         }
 
        
        
        }catch(Exception e){          
             System.out.println(e);
        }    
       creditdeatils();  
       transactionHistory();
    }
     
      public static void transactionHistory(){
      
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            String query = "Select * from transactions where AccountNo='"+acno123.getText()+"' ";
             String querys = "Select * from account where AccountNo='"+acno123.getText()+"' ";
            PreparedStatement pst = connect.prepareStatement(query);
            PreparedStatement psts = connect.prepareStatement(querys);
            ResultSet rs = pst.executeQuery();
             ResultSet rss = psts.executeQuery();
            DefaultTableModel tableModel = (DefaultTableModel)tra.getModel();            
            tableModel.setRowCount(0);
           
            while(rs.next()){
                                            
                String SenderDate = rs.getNString("Date");                 
                    float Senderamount = rs.getFloat("Amount");
                String SenderDebit = rs.getNString("CreditDebit");
                String Types=rs.getNString("Type");                
                Object SenderTableData[] ={SenderDate, Types,Senderamount, SenderDebit};
                                            
                tableModel = (DefaultTableModel)tra.getModel();                
                tableModel.addRow(SenderTableData);
                
            }
            connect.close();                            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

   }
     
     
     public void creditdeatils(){
           try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement stt=conn.createStatement();
            String query="Select * from credit where AccountNo='"+acno123.getText()+"' ";          
            ResultSet rss=stt.executeQuery(query);      

        if(rss.next())
    
        {
   
     String CardNoo=rss.getString("CardNO");         
     String balancee=rss.getString("Balance");  
     String bal1 = String.format("%s", balancee);
     ccno12.setText(CardNoo);    
     bal3.setText(bal1);
     
        }
        else{
            System.out.println("no data found");
         //JOptionPane.showMessageDialog(null,"No Such Data Found"); 
         }
 
        conn.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             System.out.println(e);
        }        
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        avatar = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        CusName = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        profile = new javax.swing.JButton();
        addmoney = new javax.swing.JButton();
        withdraw = new javax.swing.JButton();
        transfer = new javax.swing.JButton();
        carddeatils = new javax.swing.JButton();
        home = new javax.swing.JButton();
        accounts = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homesec = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name598 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tra = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        bal2 = new javax.swing.JLabel();
        acno123 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        ccno12 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        bal3 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel82 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        accs = new javax.swing.JTextField();
        accty4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        accno3 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cna = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        mob6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cifno2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        accno8 = new javax.swing.JLabel();
        bal = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ava = new javax.swing.JLabel();
        accno2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        na = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        adno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        accty = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        em2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        mob2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        dob3 = new javax.swing.JTextField();
        ava22 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        cardno33 = new javax.swing.JLabel();
        na23 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        inrate = new javax.swing.JLabel();
        cardno45 = new javax.swing.JLabel();
        cvv1 = new javax.swing.JLabel();
        bal66 = new javax.swing.JLabel();
        issuedate = new javax.swing.JLabel();
        expirydate = new javax.swing.JLabel();
        ctype = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        dname = new javax.swing.JLabel();
        dcardno2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        dcardno = new javax.swing.JLabel();
        dcvv = new javax.swing.JLabel();
        iss = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel76 = new javax.swing.JLabel();
        ccno8 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        bal56 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        cardno8 = new javax.swing.JLabel();
        holderna = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        addmoney2 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setBackground(new java.awt.Color(102, 102, 255));
        logout.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        logout.setForeground(new java.awt.Color(240, 240, 240));
        logout.setText("LOG-OUT");
        logout.setBorder(null);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 62, 20));

        jLabel1.setBackground(new java.awt.Color(153, 255, 102));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("BASONA RESERVED BANK OF INDIA");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 402, -1));
        jPanel1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        close.setBackground(new java.awt.Color(102, 102, 255));
        close.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setText("X");
        close.setBorder(null);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        jPanel1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 830, 90));

        jPanel2.setBackground(new java.awt.Color(204, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 160, -1));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/1.png"))); // NOI18N
        jPanel2.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 70));

        CusName.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        CusName.setForeground(new java.awt.Color(255, 255, 255));
        CusName.setText("Custome Name");
        jPanel2.add(CusName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 35, 130, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 90));

        jPanel3.setBackground(new java.awt.Color(255, 204, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setBackground(new java.awt.Color(58, 131, 218));
        profile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setText("Profile ");
        profile.setBorder(null);
        profile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel3.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 142, 130, 46));

        addmoney.setBackground(new java.awt.Color(58, 131, 218));
        addmoney.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addmoney.setForeground(new java.awt.Color(255, 255, 255));
        addmoney.setText("Add Money");
        addmoney.setBorder(null);
        addmoney.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addmoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmoneyActionPerformed(evt);
            }
        });
        jPanel3.add(addmoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 206, 130, 41));

        withdraw.setBackground(new java.awt.Color(58, 131, 218));
        withdraw.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        withdraw.setForeground(new java.awt.Color(255, 255, 255));
        withdraw.setText("Withdraw");
        withdraw.setBorder(null);
        withdraw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });
        jPanel3.add(withdraw, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 265, 130, 46));

        transfer.setBackground(new java.awt.Color(58, 131, 218));
        transfer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        transfer.setForeground(new java.awt.Color(255, 255, 255));
        transfer.setText("Transfer");
        transfer.setBorder(null);
        transfer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferActionPerformed(evt);
            }
        });
        jPanel3.add(transfer, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 322, 130, 47));

        carddeatils.setBackground(new java.awt.Color(58, 131, 218));
        carddeatils.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        carddeatils.setForeground(new java.awt.Color(255, 255, 255));
        carddeatils.setText("Card Details ");
        carddeatils.setBorder(null);
        carddeatils.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        carddeatils.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carddeatilsActionPerformed(evt);
            }
        });
        jPanel3.add(carddeatils, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 380, 130, 50));

        home.setBackground(new java.awt.Color(58, 131, 218));
        home.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");
        home.setBorder(null);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel3.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, 130, 53));

        accounts.setBackground(new java.awt.Color(58, 131, 218));
        accounts.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        accounts.setForeground(new java.awt.Color(255, 255, 255));
        accounts.setText("Account");
        accounts.setBorder(null);
        accounts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsActionPerformed(evt);
            }
        });
        jPanel3.add(accounts, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 82, 130, 42));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 460));

        homesec.setBackground(new java.awt.Color(44, 62, 80));
        homesec.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Home Section ");
        homesec.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 11, -1, -1));

        name598.setFont(new java.awt.Font("Trebuchet MS", 0, 19)); // NOI18N
        name598.setForeground(new java.awt.Color(240, 240, 240));
        name598.setText("Candidate Name");
        homesec.add(name598, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, -1));

        tra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DATE", "DESCRIPTION", "AMOUNT", "TYPE"
            }
        ));
        jScrollPane1.setViewportView(tra);

        homesec.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 470, 340));

        jPanel12.setBackground(new java.awt.Color(0, 147, 233));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(240, 240, 240));
        jLabel33.setText("Available Balance");
        jPanel12.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel34.setText("BRB");
        jPanel12.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 13, -1, -1));

        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(240, 240, 240));
        jLabel35.setText("Account ");
        jPanel12.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 47, -1, -1));

        bal2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bal2.setForeground(new java.awt.Color(240, 240, 240));
        bal2.setText("xxxxxxxxxxx");
        jPanel12.add(bal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 83, 123, -1));

        acno123.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        acno123.setForeground(new java.awt.Color(240, 240, 240));
        acno123.setText(":");
        jPanel12.add(acno123, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 51, 96, 14));

        jLabel90.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(240, 240, 240));
        jLabel90.setText("₹ ");
        jPanel12.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        homesec.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 260, 120));

        jPanel13.setBackground(new java.awt.Color(0, 147, 233));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(240, 240, 240));
        jLabel36.setText("Credit Card Balance");
        jPanel13.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 11, -1, -1));

        ccno12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ccno12.setForeground(new java.awt.Color(240, 240, 240));
        ccno12.setText("xxxxxxxxxxxx 123");
        jPanel13.add(ccno12, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 47, -1, -1));

        jLabel38.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel38.setText("VISA");
        jPanel13.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 13, -1, -1));

        bal3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        bal3.setForeground(new java.awt.Color(240, 240, 240));
        bal3.setText("xxxxxxxx");
        jPanel13.add(bal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 83, 105, -1));

        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(240, 240, 240));
        jLabel37.setText("₹ ");
        jPanel13.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 20, -1));

        homesec.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 260, 120));

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 147, 233));
        jLabel29.setText("All Last Transaction ");
        homesec.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, -1, -1));

        jLabel32.setForeground(new java.awt.Color(240, 240, 240));
        jLabel32.setText("Welcome To Basona Reserved Bank");
        homesec.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        homesec.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 32, 120, 10));

        jLabel82.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(240, 240, 240));
        jLabel82.setText("Hello ,");
        homesec.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/gpay.png"))); // NOI18N
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        homesec.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 110, 40));

        jTabbedPane1.addTab("tab1", homesec);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 16)); // NOI18N
        jLabel3.setText("My Account");

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel15.setText("PassBook");
        jPanel10.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 11, -1, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel16.setText("Basona Reserved Bank ");
        jPanel10.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel17.setText("Account Status  :");
        jPanel10.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel18.setText("Account Type   :");
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        accs.setEditable(false);
        accs.setBackground(new java.awt.Color(204, 255, 204));
        accs.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(accs, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 137, -1));

        accty4.setEditable(false);
        accty4.setBackground(new java.awt.Color(204, 255, 204));
        accty4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(accty4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 137, -1));

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel19.setText("Account No  :");
        jPanel10.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, -1, -1));

        accno3.setEditable(false);
        accno3.setBackground(new java.awt.Color(204, 255, 204));
        accno3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(accno3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 137, -1));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel20.setText("Customer Name :");
        jPanel10.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        cna.setEditable(false);
        cna.setBackground(new java.awt.Color(204, 255, 204));
        cna.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(cna, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 139, -1));

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel21.setText("Branch  :    SHEORAPHULI ZAMINDAR ROAD");
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        mob6.setEditable(false);
        mob6.setBackground(new java.awt.Color(204, 255, 204));
        mob6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(mob6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 137, -1));

        jLabel22.setText("Code : 1769");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel23.setText("Mobile  :");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel24.setText("CIF No  :");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        cifno2.setEditable(false);
        cifno2.setBackground(new java.awt.Color(204, 255, 204));
        cifno2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 51, 255)));
        jPanel10.add(cifno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 142, -1));

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel25.setText("IFSC  :    BRBIN001769");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 183, -1));

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel26.setText("Email :  brb1769@gmail.com");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, -1, -1));

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jLabel27.setText("Phone No :     26322828");
        jPanel10.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 150, -1));

        jPanel11.setBackground(new java.awt.Color(102, 153, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(240, 240, 240));
        jLabel28.setText("Total Balance Available ");

        accno8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        accno8.setForeground(new java.awt.Color(240, 240, 240));
        accno8.setText("xxxxxxxxx");

        bal.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        bal.setForeground(new java.awt.Color(240, 240, 240));
        bal.setText("xxxxxxxxx");

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(240, 240, 240));
        jLabel31.setText("₹ ");

        jLabel39.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(240, 240, 240));
        jLabel39.setText("Acc:");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 47, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(accno8, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accno8)
                    .addComponent(jLabel39))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bal)
                    .addComponent(jLabel31))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(294, 294, 294)
                                .addComponent(jLabel3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Account No");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 146, -1, -1));

        ava.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ava.setForeground(new java.awt.Color(240, 240, 240));
        ava.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/18.png"))); // NOI18N
        jPanel6.add(ava, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 262, -1));

        accno2.setEditable(false);
        accno2.setBackground(new java.awt.Color(153, 153, 255));
        accno2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(accno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 143, 160, 30));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Candiate Name ");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, -1));

        na.setEditable(false);
        na.setBackground(new java.awt.Color(153, 153, 255));
        na.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(na, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 187, 160, 30));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Aadhar No ");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        adno.setEditable(false);
        adno.setBackground(new java.awt.Color(153, 153, 255));
        adno.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(adno, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 245, 160, 30));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Account Type ");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, -1, -1));

        accty.setEditable(false);
        accty.setBackground(new java.awt.Color(153, 153, 255));
        accty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(accty, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 297, 160, 30));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Email");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, -1, -1));

        em2.setEditable(false);
        em2.setBackground(new java.awt.Color(153, 153, 255));
        em2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(em2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 160, 30));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Mobile ");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, -1, -1));

        mob2.setEditable(false);
        mob2.setBackground(new java.awt.Color(153, 153, 255));
        mob2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(mob2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 160, 30));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Date of Birth ");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        dob3.setEditable(false);
        dob3.setBackground(new java.awt.Color(153, 153, 255));
        dob3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 255, 51)));
        jPanel6.add(dob3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 160, 30));
        jPanel6.add(ava22, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 51, 51));
        jLabel30.setText("Profile  Details :");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.addTab("tab3", jPanel6);

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(240, 225, 178));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Credit Card Detalis ");
        jPanel14.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/31.png"))); // NOI18N
        jPanel14.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Credit Card");
        jPanel14.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/27.png"))); // NOI18N
        jPanel14.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        cardno33.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cardno33.setForeground(new java.awt.Color(255, 255, 255));
        cardno33.setText("xxxxxxxxxxxxxx");
        jPanel14.add(cardno33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 150, -1));

        na23.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        na23.setForeground(new java.awt.Color(255, 255, 255));
        na23.setText("xxxxxxxxxxxxxx");
        jPanel14.add(na23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/30.png"))); // NOI18N
        jPanel14.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 280, 140));

        jLabel61.setText("Credit Card Type : ");
        jPanel14.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jLabel63.setText("Card No :");
        jPanel14.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel64.setText("CVV :");
        jPanel14.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel65.setText("Issued Date :");
        jPanel14.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel66.setText("Expiry Date :");
        jPanel14.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel67.setText("Balance :");
        jPanel14.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        inrate.setText("  2.6%");
        jPanel14.add(inrate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        cardno45.setText("xxxxxxxxxx");
        jPanel14.add(cardno45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, -1, -1));

        cvv1.setText("xxxxxxxxxx");
        jPanel14.add(cvv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        bal66.setText("xxxxxxxxxx");
        jPanel14.add(bal66, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        issuedate.setText("xxxxxxxxxx");
        jPanel14.add(issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        expirydate.setText("xxxxxxxxxx");
        jPanel14.add(expirydate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, -1));

        ctype.setText("Platinum");
        jPanel14.add(ctype, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        jLabel68.setText("Interest Rate :");
        jPanel14.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 410));

        jPanel15.setBackground(new java.awt.Color(106, 171, 167));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setText("Debit Card Details ");
        jPanel15.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/28.png"))); // NOI18N
        jPanel15.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, 40));

        jLabel49.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(240, 240, 240));
        jLabel49.setText("Debit Card");
        jPanel15.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/27.png"))); // NOI18N
        jPanel15.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        dname.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        dname.setForeground(new java.awt.Color(240, 240, 240));
        dname.setText("xxxxxxxxxxxxxxxx");
        jPanel15.add(dname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        dcardno2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        dcardno2.setForeground(new java.awt.Color(240, 240, 240));
        dcardno2.setText("xxxxxxxxxxxxxxxxx");
        jPanel15.add(dcardno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/20.png"))); // NOI18N
        jPanel15.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 290, 140));

        jLabel62.setText("Credit Card Type :  Gold ");
        jPanel15.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel69.setText("Card No  :");
        jPanel15.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel70.setText("CVV   :");
        jPanel15.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel71.setText("Issue Date  :");
        jPanel15.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel72.setText("Expiry Date  :");
        jPanel15.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        dcardno.setText("xxxxxxxxxxxx");
        jPanel15.add(dcardno, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, -1, -1));

        dcvv.setText("xxxxxxxxxxxx");
        jPanel15.add(dcvv, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, -1, -1));

        iss.setText("xxxxxxxxxxxx");
        jPanel15.add(iss, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        exp.setText("xxxxxxxxxxxxx");
        jPanel15.add(exp, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        jPanel7.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 310, 410));

        jLabel57.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel57.setText("Enter Pin ");

        jLabel58.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel58.setText("Re-enter Pin");

        jButton5.setBackground(new java.awt.Color(255, 102, 51));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton5.setText("Submit");
        jButton5.setBorder(null);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel58)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, 180, 170));

        jLabel59.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel59.setText("Enter Pin ");

        jLabel60.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel60.setText("Re-enter Pin");

        jButton9.setBackground(new java.awt.Color(255, 102, 51));
        jButton9.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButton9.setText("Submit");
        jButton9.setBorder(null);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 180, 170));

        jLabel55.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(240, 240, 240));
        jLabel55.setText("Change Credit Card Pin");
        jPanel7.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel56.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(240, 240, 240));
        jLabel56.setText("Change Debit Card Pin");
        jPanel7.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, -1, -1));
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 430));

        jTabbedPane1.addTab("tab4", jPanel7);

        jPanel8.setBackground(new java.awt.Color(151, 213, 248));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel75.setText("Add Money To Credit Balance ");
        jPanel8.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));
        jPanel8.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 240, 10));

        jLabel76.setText("Account No :");
        jPanel8.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 90, -1));
        jPanel8.add(ccno8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, -1));

        jLabel77.setText("Amount  :");
        jPanel8.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));
        jPanel8.add(amt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 180, -1));

        bal56.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        bal56.setForeground(new java.awt.Color(255, 255, 255));
        bal56.setText("xxxxxxx");
        jPanel8.add(bal56, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 290, 80, 30));
        jPanel8.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 90, -1));

        jLabel84.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("Credit Card");
        jPanel8.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, -1, -1));

        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/27.png"))); // NOI18N
        jPanel8.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 270, -1, -1));

        cardno8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cardno8.setForeground(new java.awt.Color(255, 255, 255));
        cardno8.setText("xxxxxxxxxxxxxx");
        jPanel8.add(cardno8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 150, -1));

        holderna.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        holderna.setForeground(new java.awt.Color(255, 255, 255));
        holderna.setText("xxxxxxxxxxxxxx");
        jPanel8.add(holderna, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));

        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/31.png"))); // NOI18N
        jPanel8.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 240, -1, -1));

        addmoney2.setBackground(new java.awt.Color(255, 153, 51));
        addmoney2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        addmoney2.setText("Continue ");
        addmoney2.setBorder(null);
        addmoney2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addmoney2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmoney2ActionPerformed(evt);
            }
        });
        jPanel8.add(addmoney2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 80, 30));

        jLabel89.setText("Pin :");
        jPanel8.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Reset");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 80, 30));

        jButton2.setBackground(new java.awt.Color(255, 153, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Add Money To Main Account Balance ");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 330, 30));

        jLabel6.setBackground(new java.awt.Color(197, 192, 87));
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, -8, 840, 440));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("₹ ");
        jPanel8.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 10, 30));

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/banksystem3/pics/21.png"))); // NOI18N
        jLabel83.setText("jLabel41");
        jPanel8.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 280, 140));

        jTabbedPane1.addTab("tab5", jPanel8);

        jLabel7.setText("jLabel7");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(jLabel7)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel7)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", jPanel9);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 840, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed
        accounts.setBackground(new Color(58,131,218));
        withdraw.setBackground(new Color(102,102,102));
        home.setBackground(new Color(58,131,218));
        profile.setBackground(new Color(58,131,218));
        Withdraw w=new Withdraw();
         w.setVisible(true);
         
         
    }//GEN-LAST:event_withdrawActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
       new LogIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        accounts.setBackground(new Color(58,131,218));
        profile.setBackground(new Color(102,102,102));
        home.setBackground(new Color(58,131,218));
        withdraw.setBackground(new Color(58,131,218));
        transfer.setBackground(new Color(58,131,218));
        carddeatils.setBackground(new Color(58,131,218));
        addmoney.setBackground(new Color(58,131,218));
       ProfileSection();
       
    }//GEN-LAST:event_profileActionPerformed

    private void addmoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmoneyActionPerformed
       accounts.setBackground(new Color(58,131,218));
        addmoney.setBackground(new Color(102,102,102));
        home.setBackground(new Color(58,131,218));
        profile.setBackground(new Color(58,131,218));
        withdraw.setBackground(new Color(58,131,218));
        transfer.setBackground(new Color(58,131,218));
        carddeatils.setBackground(new Color(58,131,218));
       jTabbedPane1.setSelectedIndex(4);
       
       ccno8.setText(acno123.getText());
       try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement st=con.createStatement();
            String query="Select * from credit where HolderName='"+CusName.getText()+"' ";          
            ResultSet rs=st.executeQuery(query);  
            if(rs.next())
{  
     String AccountNo=rs.getString("CardNO");
     String Name=rs.getString("HolderName");   
     String Balance=rs.getString("Balance");
     
     holderna.setText(Name);
     cardno8.setText(AccountNo);
     bal56.setText(Balance);
     
}else{
                System.out.println("No data Found ");
            }
       }catch(Exception ee){
           System.out.println(ee);
       }
    }//GEN-LAST:event_addmoneyActionPerformed

    private void transferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferActionPerformed
         transfer.setBackground(new Color(102,102,102));
         accounts.setBackground(new Color(58,131,218));
         profile.setBackground(new Color(58,131,218));
         home.setBackground(new Color(58,131,218));
         withdraw.setBackground(new Color(58,131,218));
          addmoney.setBackground(new Color(58,131,218));
          
          try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            
              String query=" select * from account where AccountNo='"+acno123.getText()+"' ";
              
               Statement stt=con.createStatement();                
                ResultSet rss=stt.executeQuery(query);  
                
                if(rss.next()){                   
                   String acc=rss.getString("AccountNo");                  
                    Transfer t= new Transfer();
                    t.setVisible(true);                                   
                    Transfer.accno.setText(acc);             
                    
                }else{
                JOptionPane.showMessageDialog(null,"Data Not Found");
                
                }
                       
        }catch(HeadlessException | SQLException e){
            System.out.println(e);
        }
     
        
    }//GEN-LAST:event_transferActionPerformed

    private void accountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountsActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(1);
         accounts.setBackground(new Color(102,102,102));
         profile.setBackground(new Color(58,131,218));
          addmoney.setBackground(new Color(58,131,218));
         home.setBackground(new Color(58,131,218));
         AccountSection();
    }//GEN-LAST:event_accountsActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
      jTabbedPane1.setSelectedIndex(0);
      home.setBackground(new Color(102,102,102));
        accounts.setBackground(new Color(58,131,218));
         profile.setBackground(new Color(58,131,218));
          addmoney.setBackground(new Color(58,131,218));
      hompanel();
    }//GEN-LAST:event_homeActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
       System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void carddeatilsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carddeatilsActionPerformed
       jTabbedPane1.setSelectedIndex(3);      
       showcredit();
       showdebit();
        carddeatils.setBackground(new Color(102,102,102));
        accounts.setBackground(new Color(58,131,218));
         addmoney.setBackground(new Color(58,131,218));
        profile.setBackground(new Color(58,131,218));
        home.setBackground(new Color(58,131,218));
        withdraw.setBackground(new Color(58,131,218));
        transfer.setBackground(new Color(58,131,218));
    }//GEN-LAST:event_carddeatilsActionPerformed

    public void showcredit(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement stt=conn.createStatement();
            String query="Select * from credit where AccountNo='"+acno123.getText()+"'";          
            ResultSet rss=stt.executeQuery(query);      

        if(rss.next())
    
        {
   
     String CardNoo=rss.getString("CardNO");         
     String balancee=rss.getString("Balance");   
     String holder=rss.getString("HolderName");
     String cvvx=rss.getString("CVV");
     String issue=rss.getString("IssueDate");
     String expiry=rss.getString("ExpiryDate");
     cardno33.setText(CardNoo);        
     bal66.setText(balancee);
     na23.setText(holder);
     cardno45.setText(CardNoo);
     cvv1.setText(cvvx);
     issuedate.setText(issue);
     expirydate.setText(expiry);
     
     
        }
        else{
            System.out.println("no data found");
         //JOptionPane.showMessageDialog(null,"No Such Data Found"); 
         }
 
        conn.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             System.out.println(e);
        }            
    }
    
    
    public void showdebit(){
    try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement stt=conn.createStatement();
            String query="Select * from debit where AccountNo='"+acno123.getText()+"'";          
            ResultSet rss=stt.executeQuery(query);      

        if(rss.next())
    
        {
   
     String CardNoo=rss.getString("CardNO");      
     String holder=rss.getString("HolderName");
     String cvvx=rss.getString("CVV");
     String issue=rss.getString("IssueDate");
     String expiry=rss.getString("ExpiryDate");
     dcardno.setText(CardNoo);      
     dname.setText(holder);
     dcardno2.setText(CardNoo);
     dcvv.setText(cvvx);
     iss.setText(issue);
     exp.setText(expiry);
     
     
        }
        else{
            System.out.println("no debit card data found");
         //JOptionPane.showMessageDialog(null,"No Such Data Found"); 
         }
 
        conn.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             System.out.println(e);
        }               
}
    
    
    private void addmoney2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmoney2ActionPerformed
        // TODO add your handling code here:
        
        tra22=Integer.parseInt(amt.getText());
        
        try{
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","")) {
                //Statement st=con.createStatement();
                //con.setAutoCommit(false);
                String query="UPDATE `account` SET `Deposit`=Deposit-"+tra22+" WHERE AccountNo='"+ccno8.getText()+"'";
                String query2="UPDATE `credit` SET `Balance`=Balance+"+tra22+" WHERE CardNO='"+cardno8.getText()+"'";
                pa=con.prepareStatement(query);
                pa2=con.prepareStatement(query2);
                
                pa.executeUpdate();
                pa2.executeUpdate();
                JOptionPane.showMessageDialog(null,"Sucessfully Transfered...!");
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String Date = sdf.format(new Date());
                String Debit = "Debited";
                String t="Credit Card";
                String query5 = "Insert into transactions(Date, AccountNo, Amount, CreditDebit, Type) Values ('"+Date+"', '"+ccno8.getText()+"', '"+tra22+"', '"+Debit+"','"+t+"')";
                PreparedStatement pst5 = con.prepareStatement(query5);
                pst5.execute();
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null,"Error");
            System.out.println(e);
        }
        
    }//GEN-LAST:event_addmoney2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        amt.setText("");
        jTextField7.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Deposit d =new Deposit();
        d.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Login l =new Login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /************************************************ Profile Section ************************************************************/
    
    public void ProfileSection(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement st=con.createStatement();
            String query="Select * from account where Username='"+avatar.getText()+"' ";          
            ResultSet rs=st.executeQuery(query);      

if(rs.next())
{  
     String AccountNo=rs.getString("AccountNo");
     String Name=rs.getString("Name");   
     String Aadhar=rs.getString("Aadhar");
     String AccountType=rs.getString("AccountType");
     String dob=rs.getString("DateofBirth");     
     String Email=rs.getString("Email");
     String Mobile=rs.getString("Mobile");
     
     ava.setText(Name);
     accno2.setText(AccountNo);
     na.setText(Name);
     adno.setText(Aadhar);
     accty.setText(AccountType);
     dob3.setText(dob);
     em2.setText(Email);
     mob2.setText(Mobile);
      String Gender = rs.getNString("Gender");
                if( "Male".equals(Gender)){
                    ava.setVisible(true);
                    ava22.setVisible(false);
                }if( "Female".equals(Gender)){
                    ava22.setVisible(true); 
                    ava22.setText(Name);
                    ava.setVisible(false);
                }
 
}
else{
         JOptionPane.showMessageDialog(accno2,"No Such Data Found"); 
         }
 
 con.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             System.out.println(e);
        }
    }
    
    public void AccountSection(){
         try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
             Statement st=con.createStatement();
            String query="Select * from account where Username='"+avatar.getText()+"' ";          
            ResultSet rs=st.executeQuery(query);      

if(rs.next())
    
   {
     String AccType=rs.getString("AccountType");
     String AccountNo=rs.getString("AccountNo");     
     String Name=rs.getString("Name");    
     String Mobile=rs.getString("Mobile");
     String cifno=rs.getString("CIF");
     String balance=rs.getString("Deposit");
     accs.setText("Active");
     accty4.setText(AccType);
     accno3.setText(AccountNo);
     cna.setText(Name);    
     mob6.setText(Mobile);
     cifno2.setText(cifno);
     accno8.setText(AccountNo);
     bal.setText(balance);
     
    
      
 
}
else{
         JOptionPane.showMessageDialog(accno2,"No Such Data Found"); 
         }
 
 con.close();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
             System.out.println(e);
        }
    }
    
    
    
    
    
    
    
    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(6, 8);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
   
    
    public void creditcard(){
         ZoneId defaultZoneId = ZoneId.systemDefault();        
         LocalDate randomDate = createRandomDate(2021, 2021);
        String date2 = Date.from(randomDate.atStartOfDay(defaultZoneId).toInstant()).toString();
        issuedate.setText(date2);
        
        ZoneId defaultZoneId2 = ZoneId.systemDefault();        
         LocalDate randomDate2 = createRandomDate(2024, 2025);
        String date22 = Date.from(randomDate2.atStartOfDay(defaultZoneId2).toInstant()).toString();
       expirydate.setText(date22);
        try{
            
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            Statement stat = con.createStatement();              
            String selectQuery = "SELECT * FROM credit Where AccountNo='"+acno123.getText()+"'";
            System.out.println(selectQuery);
            ResultSet rs=stat.executeQuery(selectQuery);
            System.out.println(rs.next());
            if(rs.next()==true)
           {
            System.out.println("Alredy Registred Credit Card Deatils");
           //JOptionPane.showMessageDialog(null,"Already Registered");
           }
           else 
           {               
               String insertQuery = "insert into credit values('" + acno123.getText() + "','" + ccno()+ "','" +name598.getText()+"','"+ cvvno()+"','"+ctype.getText()+"','"+date2+"','"+date22+"','"+bal56.getText()+"','"+inrate.getText()+"')";           
               stat.executeUpdate(insertQuery);
               
//String query="insert into credit(AccountNo,CardNo,HolderName,CVV,CardType,IssueDate,ExpiryDate,Balance,InterestRate)values(?,?,?,?,?,?,?,?,?)";
            
           }         
         
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    public void debitcard(){
         ZoneId defaultZoneId = ZoneId.systemDefault();        
         LocalDate randomDate = createRandomDate(2021, 2021);
        String date32 = Date.from(randomDate.atStartOfDay(defaultZoneId).toInstant()).toString();
        iss.setText(date32);
        
        ZoneId defaultZoneId2 = ZoneId.systemDefault();        
         LocalDate randomDate2 = createRandomDate(2024, 2025);
        String date22s = Date.from(randomDate2.atStartOfDay(defaultZoneId2).toInstant()).toString();
       exp.setText(date22s);
        try{
            
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            Statement stat = con.createStatement();              
            String selectQuery = "SELECT * FROM debit Where AccountNo='"+acno123.getText()+"'";
            System.out.println(selectQuery);
            ResultSet rs=stat.executeQuery(selectQuery);
            System.out.println(rs.next());
            if(rs.next()==true)
           {
               System.out.println("Alredy Registred Debit Card Deatils");
           //JOptionPane.showMessageDialog(null,"Already Registered");
           }
           else 
           {               
               String insertQuery = "insert into debit values('" + acno123.getText() + "','" + dcno()+ "','" +name598.getText()+"','"+ cvvnoo()+"','"+date32+"','"+date22s+"')";           
               stat.executeUpdate(insertQuery);
               
//String query="insert into credit(AccountNo,CardNo,HolderName,CVV,CardType,IssueDate,ExpiryDate,Balance,InterestRate)values(?,?,?,?,?,?,?,?,?)";
            
           }         
         
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
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
    public static javax.swing.JLabel CusName;
    private javax.swing.JTextField accno2;
    private javax.swing.JTextField accno3;
    private javax.swing.JLabel accno8;
    private javax.swing.JButton accounts;
    private javax.swing.JTextField accs;
    private javax.swing.JTextField accty;
    private javax.swing.JTextField accty4;
    public static javax.swing.JLabel acno123;
    private javax.swing.JButton addmoney;
    private javax.swing.JButton addmoney2;
    private javax.swing.JTextField adno;
    private javax.swing.JTextField amt;
    private javax.swing.JLabel ava;
    private javax.swing.JLabel ava22;
    public static javax.swing.JLabel avatar;
    private javax.swing.JLabel bal;
    public static javax.swing.JLabel bal2;
    public static javax.swing.JLabel bal3;
    public static javax.swing.JLabel bal56;
    public static javax.swing.JLabel bal66;
    private javax.swing.JButton carddeatils;
    public static javax.swing.JLabel cardno33;
    public static javax.swing.JLabel cardno45;
    private javax.swing.JLabel cardno8;
    public static javax.swing.JLabel ccno12;
    private javax.swing.JTextField ccno8;
    private javax.swing.JTextField cifno2;
    private javax.swing.JButton close;
    private javax.swing.JTextField cna;
    public static javax.swing.JLabel ctype;
    public static javax.swing.JLabel cvv1;
    public static javax.swing.JLabel dcardno;
    public static javax.swing.JLabel dcardno2;
    public static javax.swing.JLabel dcvv;
    public static javax.swing.JLabel dname;
    private javax.swing.JTextField dob3;
    private javax.swing.JTextField em2;
    public static javax.swing.JLabel exp;
    public static javax.swing.JLabel expirydate;
    private javax.swing.JLabel holderna;
    private javax.swing.JButton home;
    private javax.swing.JPanel homesec;
    public static javax.swing.JLabel inrate;
    public static javax.swing.JLabel iss;
    public static javax.swing.JLabel issuedate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton logout;
    private javax.swing.JTextField mob2;
    private javax.swing.JTextField mob6;
    private javax.swing.JTextField na;
    public static javax.swing.JLabel na23;
    public static javax.swing.JLabel name598;
    private javax.swing.JButton profile;
    public static javax.swing.JTable tra;
    private javax.swing.JButton transfer;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables

}
