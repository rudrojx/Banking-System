package banksystem3;
import static banksystem3.Main.a;
import static banksystem3.Main.acc;
import static banksystem3.Main.acno123;
import static banksystem3.Main.b;
import static banksystem3.Main.bal56;
import static banksystem3.Main.ccno;
import static banksystem3.Main.ctype;
import static banksystem3.Main.cvv;
import static banksystem3.Main.cvv2;
import static banksystem3.Main.cvvno;
import static banksystem3.Main.cvvnoo;
import static banksystem3.Main.dcc;
import static banksystem3.Main.dcno;
import static banksystem3.Main.exp;
import static banksystem3.Main.expirydate;
import static banksystem3.Main.inrate;
import static banksystem3.Main.iss;
import static banksystem3.Main.issuedate;
import static banksystem3.Main.m;
import static banksystem3.Main.n;
import static banksystem3.Main.name598;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import java.time.ZoneId;
import java.util.Date;
public class CreatAcc extends javax.swing.JFrame {
    static int cvv,cvv2;
static String m,n,b,j;
int cc,branch=1769;
static String a,c,bv,gen,t;
 static long acc,dcc;       
    public CreatAcc() {
        initComponents();
        submit.setVisible(false);
    }
public long Accno()
        {
            for(int k=0; k<=13; k++)
		 {
			 acc=(long) (acc+(Math.random()*100000000));
                         
		 }
         a =(Integer.toString((int) acc));
            return acc;
        }
    public int cifno()
        {
            for(int i=0; i<=10; i++)
		 {
			 cc=cc+(int)(Math.random()*10000000);
                         
		 }
         c =(Integer.toString(cc));
            return cc;
        }

    public static long ccno()
        {
            for(int k=0; k<=13; k++)
		 {
			 acc=(long) (acc+(Math.random()*1000000000));
                         
		 }
         j =(Integer.toString((int) acc));
            return acc;
        }
    
    public static long dcno()
        {
            for(int k=0; k<=13; k++)
		 {
			 dcc=(long) (dcc+(Math.random()*1000000000));
                         
		 }
         n =(Integer.toString((int) dcc));
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
        String cardtype = "Platinum";
        String intrate = "2.6%";
         ZoneId defaultZoneId = ZoneId.systemDefault();        
         LocalDate randomDate = createRandomDate(2021, 2021);
        String date2 = Date.from(randomDate.atStartOfDay(defaultZoneId).toInstant()).toString();
        //issuedate.setText(date2);
        
        ZoneId defaultZoneId2 = ZoneId.systemDefault();        
         LocalDate randomDate2 = createRandomDate(2024, 2025);
        String date22 = Date.from(randomDate2.atStartOfDay(defaultZoneId2).toInstant()).toString();
       //expirydate.setText(date22);
        try{
            
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            Statement stat = con.createStatement();              
            String selectQuery = "SELECT * FROM credit Where AccountNo='"+a+"'";
            System.out.println(selectQuery);
            System.out.println(a);
            ResultSet rs=stat.executeQuery(selectQuery);
            System.out.println(rs.next());
            if(rs.next()==true)
           {
            System.out.println("Alredy Registred Credit Card Deatils");
           //JOptionPane.showMessageDialog(null,"Already Registered");
           }
           else 
           {               
               String insertQuery = "insert into credit values('" + a + "','" + ccno()+ "','" +name.getText()+"','"+ cvvno()+"','"+cardtype+"','"+date2+"','"+date22+"','"+depo.getText()+"','"+intrate+"')";           
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
        //iss.setText(date32);
        
        ZoneId defaultZoneId2 = ZoneId.systemDefault();        
         LocalDate randomDate2 = createRandomDate(2024, 2025);
        String date22s = Date.from(randomDate2.atStartOfDay(defaultZoneId2).toInstant()).toString();
       //exp.setText(date22s);
        try{
            
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
            Statement stat = con.createStatement();              
            String selectQuery = "SELECT * FROM debit Where AccountNo='"+a+"'";
            System.out.println(selectQuery);
            System.out.println(a);
            ResultSet rs=stat.executeQuery(selectQuery);
            System.out.println(rs.next());
            if(rs.next()==true)
           {
               System.out.println("Alredy Registred Debit Card Deatils");
           //JOptionPane.showMessageDialog(null,"Already Registered");
           }
           else 
           {               
               String insertQuery = "insert into debit values('" + a + "','" + dcno()+ "','" +name.getText()+"','"+ cvvnoo()+"','"+date32+"','"+date22s+"')";           
               stat.executeUpdate(insertQuery);
               
//String query="insert into credit(AccountNo,CardNo,HolderName,CVV,CardType,IssueDate,ExpiryDate,Balance,InterestRate)values(?,?,?,?,?,?,?,?,?)";
            
           }         
         
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        depo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        accno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        pin = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        female = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        adhar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cif = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        bcode = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel22 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        sa = new javax.swing.JRadioButton();
        cu = new javax.swing.JRadioButton();
        op = new javax.swing.JTextField();
        terms = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("New Account Creation Portal");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 216, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Candiate Name :-");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 22));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Account Type :-");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Mobile No :-");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 96, 25));

        submit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        submit.setText("Submit");
        submit.setBorder(null);
        submit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, 101, 35));

        clear.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        clear.setText("Clear");
        clear.setBorder(null);
        clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 105, 35));
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 147, 30));
        getContentPane().add(mob, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 147, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Deposit Amount  :-");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 110, 22));
        getContentPane().add(depo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 147, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Account Number :-");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, 110, 25));

        accno.setEditable(false);
        getContentPane().add(accno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 150, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("UPI Pin :-");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));
        getContentPane().add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 130, 30));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 19)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("BASONA RESERVED BANK OF INDIA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        back.setBackground(new java.awt.Color(102, 102, 255));
        back.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(240, 240, 240));
        back.setText("Back ");
        back.setBorder(null);
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 70, 30));

        jLabel23.setForeground(new java.awt.Color(240, 240, 240));
        jLabel23.setText("India's No.1 Bank with Trust & Secure.");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, -1));
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 0, 60, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 60));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 190, 10));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Age :-");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));
        getContentPane().add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 150, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Gender :-");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        male.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        male.setText("Male");
        getContentPane().add(male, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, -1, -1));

        female.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        female.setText("Female");
        getContentPane().add(female, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Aaddhar No:-");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));
        getContentPane().add(adhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("CIF No :-");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        cif.setEditable(false);
        getContentPane().add(cif, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 150, -1));

        jLabel13.setForeground(new java.awt.Color(255, 51, 51));
        jLabel13.setText("These fields willl be provided by us ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, -1, -1));

        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setText("please note down it carefully ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 190, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Login Details :-");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, 0));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Personal Details :-");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 10));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 110, 10));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Username :-");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, -1, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 51));
        jLabel18.setText("Password :-");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, -1, -1));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(51, 51, 51));
        jLabel19.setText("Branch Code :-");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, -1));

        bcode.setEditable(false);
        getContentPane().add(bcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 150, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Account Deatils :-");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, -1, -1));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 212, 120, 10));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 51));
        jLabel21.setText("Date of Birth :-");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));
        getContentPane().add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 150, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(51, 51, 51));
        jLabel22.setText("Email :-");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 150, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("A/c Opening Date :-");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 120, -1));

        sa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sa.setText("Saving");
        getContentPane().add(sa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, -1, -1));

        cu.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cu.setText("Current");
        getContentPane().add(cu, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, -1, -1));

        op.setEditable(false);
        getContentPane().add(op, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 370, 150, -1));

        terms.setFont(new java.awt.Font("Trebuchet MS", 2, 10)); // NOI18N
        terms.setForeground(new java.awt.Color(0, 102, 102));
        terms.setText("Please Accept the, Terms & Conditions ");
        terms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                termsMouseClicked(evt);
            }
        });
        getContentPane().add(terms, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 220, -1));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 340, 10));

        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 10, 240));
        getContentPane().add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 340, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
         
        String msg = "" + name.getText();
                msg += " \n";         
try {
    
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
 String query="insert into account(Name,Mobile,Age,Gender,Aadhar,DateofBirth,Email,AccountType,AccountNo,CIF,BranchCode,OpeningDate,Username,Password,Pin,Deposit)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

PreparedStatement pst=con.prepareStatement(query);
pst.setString(1, name.getText());
pst.setString(2, mob.getText());
pst.setString(3, age.getText());
 if(male.isSelected()){
                    gen="Male";
                }if(female.isSelected()){
                    gen="Female";
                }
pst.setString(4, gen);
pst.setString(5, adhar.getText());
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
String date=sdf.format(dob.getDate());           
pst.setString(6, date);
pst.setString(7, email.getText());

if(sa.isSelected()){
    t="Saving";
}if(cu.isSelected()){
    t="Current";
}
pst.setString(8, t);
pst.setInt(9, (int) Accno());
pst.setInt(10, cifno());
 bv=(Integer.toString(branch));
pst.setString(11, bv);
   SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date2 = new Date();
    String dd=formatter.format(date2);
pst.setString(12, dd);
pst.setString(13, username.getText());
pst.setString(14, password.getText());
pst.setString(15, pin.getText());
pst.setString(16, depo.getText());

                    
                    int x =   pst.executeUpdate();
                    if (x == 0) {
                        JOptionPane.showMessageDialog(name, "This is alredy exist");
                    } else {
                         accno.setText(a);
                    cif.setText(c);
                    bcode.setText(bv);
                    op.setText(dd);
                    accno.setEditable(false);
                    creditcard();
                    debitcard();
                        JOptionPane.showMessageDialog(name,"Welcome, " + msg + "Your account is sucessfully created");
                        
                        new LogIn().setVisible(true);
                        dispose();
                    }                
     
        name.setText("");            
        mob.setText("");
        depo.setText("");
        accno.setText("");
        pin.setText("");
        age.setText("");
        adhar.setText("");
        email.setText("");
        cif.setText("");
        password.setText(""); age.setText("");
        username.setText("");
        bcode.setText("");
        op.setText("");
        male.setSelected(false);
        female.setSelected(false);
        sa.setSelected(false);
        cu.setSelected(false);
        dob.setCalendar(null);

                    con.close();
                } catch (HeadlessException | SQLException exception) {
                      JOptionPane.showMessageDialog(null,  exception);
                }                
                
    }//GEN-LAST:event_submitActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        name.setText("");
        mob.setText("");
        depo.setText("");
        accno.setText("");
        pin.setText("");
        age.setText("");
        adhar.setText("");
        email.setText("");
        cif.setText("");
        password.setText(""); age.setText("");
        username.setText("");
        bcode.setText("");
        op.setText("");
        male.setSelected(false);
        female.setSelected(false);
         sa.setSelected(false);
        cu.setSelected(false);
        dob.setCalendar(null);
            
    }//GEN-LAST:event_clearActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        LogIn l=new LogIn();
        l.setVisible(true);    
        dispose();
    }//GEN-LAST:event_backActionPerformed

    private void termsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_termsMouseClicked
        // TODO add your handling code here:
        if(terms.isSelected()){
            submit.setVisible(true);
        }else{
            submit.setVisible(false);
        }
    }//GEN-LAST:event_termsMouseClicked

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new CreatAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accno;
    private javax.swing.JTextField adhar;
    private javax.swing.JTextField age;
    private javax.swing.JButton back;
    private javax.swing.JTextField bcode;
    private javax.swing.JTextField cif;
    private javax.swing.JButton clear;
    private javax.swing.JRadioButton cu;
    private javax.swing.JTextField depo;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton female;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JRadioButton male;
    private javax.swing.JTextField mob;
    private javax.swing.JTextField name;
    private javax.swing.JTextField op;
    private javax.swing.JTextField password;
    private javax.swing.JTextField pin;
    private javax.swing.JRadioButton sa;
    private javax.swing.JButton submit;
    private javax.swing.JCheckBox terms;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
