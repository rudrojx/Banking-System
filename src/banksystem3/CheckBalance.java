package banksystem3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class check extends JFrame implements ActionListener
{
        private Container c; 
	private JLabel title; 	
	private JLabel ano;
        private JTextField tano;
       	private JButton check; 
        private JButton reset; 
	private JTextArea tout; 
	
        
        public check()
        {
            setTitle("Customer Account Info ");		 
		setBounds(300, 90, 900, 600); 		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 
		
		c = getContentPane(); 
		c.setLayout(null); 
                
                title = new JLabel("Account Info"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(400, 40); 
		title.setLocation(300, 30); 
		c.add(title); 
		
		ano = new JLabel("Account Number :-"); 
		ano.setFont(new Font("Arial", Font.PLAIN, 20)); 
		ano.setSize(190, 60); 
		ano.setLocation(100, 100); 
		c.add(ano);
		
		tano = new JTextField(); 
		tano.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tano.setSize(190, 30); 
		tano.setLocation(100, 150); 
		c.add(tano); 
                
                
		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(300, 400); 
		tout.setLocation(500, 100); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout); 
                
                reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset); 
                
                
		check = new JButton("Check"); 
		check.setFont(new Font("Arial", Font.PLAIN, 15)); 
		check.setSize(100, 20); 
		check.setLocation(150, 450); 
		check.addActionListener(this); 
		c.add(check); 
		
		
		setVisible(true);
        }
        
        public void actionPerformed(ActionEvent e) 
        {
            if (e.getSource() == check) 
            { 
			
               try {
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 
 String query=" SELECT * FROM `acc2` WHERE Account_No= '"+tano.getText()+"' ";
 Statement sta = con.createStatement();
 ResultSet rs =  sta.executeQuery(query) ;
  
 while(rs.next()){
 String data = "Name : "+ rs.getString(1) +  "\n"+"Account Type:-"+rs.getString(2)+ "\n"+"Mobile Number :-"+rs.getString(3)+ "\n"+"Account Number :-"+rs.getString(4)+ "\n"+"Balance :-"+rs.getString(5);
                                tout.setText(data );                                 
                                tout.setEditable(false);
 }
                    con.close();
                     }
                        
                        catch(Exception e1)
                                {
                                    System.out.println(e1);
                                }
        }
            else if(e.getSource()==reset)
                    {
                        String def = ""; 
                        tano.setText(def); 			
			tout.setText(def); 
			
                    }
        }
}
 class Check2 {

    public static void main(String[] args)throws Exception
    {
        check c=new check();
    }
    
}
