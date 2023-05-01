package banksystem3;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class BankSystem extends JFrame implements ActionListener
{	
	private Container c; 
	private JLabel title; 	
	private JLabel name;
        private JLabel ldepo;
	private JTextField tname;
         JTextField depo;
	private JCheckBox term; 
	private JButton sub; 
	private JButton reset; 
        private JTextArea tout; 
	private JLabel res; 
	private JTextArea resadd;
	int acc;
        
	public  BankSystem()
	{
		setTitle("Online Banking System ");		 
		setBounds(300, 90, 900, 600); 		
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setResizable(false); 
		
		c = getContentPane(); 
		c.setLayout(null); 
		
		title = new JLabel("New User Account Form"); 
		title.setFont(new Font("Arial", Font.PLAIN, 30)); 
		title.setSize(400, 40); 
		title.setLocation(300, 30); 
		c.add(title); 
		
		name = new JLabel("Name"); 
		name.setFont(new Font("Arial", Font.PLAIN, 20)); 
		name.setSize(100, 20); 
		name.setLocation(100, 100); 
		c.add(name);
		
		tname = new JTextField(); 
		tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tname.setSize(190, 20); 
		tname.setLocation(200, 100); 
		c.add(tname); 
                
		ldepo = new JLabel("Deposit"); 
		ldepo.setFont(new Font("Arial", Font.PLAIN, 20)); 
		ldepo.setSize(100, 20); 
		ldepo.setLocation(100, 150); 
		c.add(ldepo);
		
		depo = new JTextField(); 
		depo.setFont(new Font("Arial", Font.PLAIN, 15)); 
		depo.setSize(180, 20); 
		depo.setLocation(200, 160); 
		c.add(depo);
                
		term = new JCheckBox("Accept Terms And Conditions."); 
		term.setFont(new Font("Arial", Font.PLAIN, 15)); 
		term.setSize(250, 20); 
		term.setLocation(150, 400); 
		c.add(term); 

		sub = new JButton("Submit"); 
		sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
		sub.setSize(100, 20); 
		sub.setLocation(150, 450); 
		sub.addActionListener(this); 
		c.add(sub); 

		reset = new JButton("Reset"); 
		reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
		reset.setSize(100, 20); 
		reset.setLocation(270, 450); 
		reset.addActionListener(this); 
		c.add(reset); 
		
		tout = new JTextArea(); 
		tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
		tout.setSize(300, 400); 
		tout.setLocation(500, 100); 
		tout.setLineWrap(true); 
		tout.setEditable(false); 
		c.add(tout); 

		res = new JLabel(""); 
		res.setFont(new Font("Arial", Font.PLAIN, 20)); 
		res.setSize(500, 25); 
		res.setLocation(100, 500); 
		c.add(res); 

		resadd = new JTextArea(); 
		resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
		resadd.setSize(200, 75); 
		resadd.setLocation(580, 175); 
		resadd.setLineWrap(true); 
		c.add(resadd); 
		
		
		setVisible(true);
                      
		
	}
        public int Accno()
        {
            for(int k=0; k<=10; k++)
		 {
			 acc=acc+(int)(Math.random()*100000000);
                         
		 }
            String a=(Integer.toString(acc));
            return acc;
        }
	
	public void actionPerformed(ActionEvent e) 
        {
            String msg = "" + tname.getText();
                msg += " \n";
		if (e.getSource() == sub) { 
			if (term.isSelected()) 
                        {				 				
                          try {
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root",""); 

          String query = "INSERT INTO acc VALUES ('"+tname.getText()+"','"+Accno()+"','"+depo.getText()+"')";

                    Statement sta = con.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(sub, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(sub,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
String data = "Name : "	+ tname.getText() +  "\n"+"Account Number:-"+Accno()+ "\n"+"Deposit Amount :-"+depo.getText();
                                tout.setText(data );                                 
                                tout.setEditable(false);
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
               
			else { 
				tout.setText(""); 
				resadd.setText(""); 
				res.setText("Please accept the"
							+ " terms & conditions.."); 
			} 
		} 

		else if (e.getSource() == reset) { 
			String def = ""; 
			tname.setText(def); 
			res.setText(def); 
			tout.setText(def); 
			term.setSelected(false); 
			resadd.setText(def); 
		} 
		
		
	}
}
class Banking{
public static void main(String[] args)throws Exception
{
	BankSystem f = new BankSystem(); 
	
	}

}

