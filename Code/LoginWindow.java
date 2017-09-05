import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
public class LoginWindow extends JFrame implements ActionListener
	{ 
	static Date d=new Date();
	static int warranty=24;
	static int freeservices=6;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	int alignIconX=0,alignIconY=0;
  	JPanel p0=new JPanel();
  	ResultSet rs;
  	Connection con;
  	Statement stmt;
  	String userName;
  	String passWord;
  	int authentication;
  	String eid;
  	String name;
  	String title;
  	double salary;
  	JPanel jPanel1 = new JPanel();
  	JLabel jLabel1 = new JLabel();
  	JLabel jLabel2 = new JLabel();
  	JLabel jLabel3 = new JLabel();
  	JTextField jTextField1 = new JTextField();
  	JPasswordField jPasswordField1 = new JPasswordField();
  	JButton jButton1 = new JButton();
  	JButton jButton2 = new JButton();
 	JPanel jPanel2 = new JPanel();
  	JLabel jLabel4 = new JLabel();
  	JButton jButton3 = new JButton();
  	public static JLabel jLabel5 = new JLabel();
  	JPanel jPanel3 = new JPanel();
  	public static JLabel jLabel6 = new JLabel();
  	JMenuBar bar;
  	JMenu aboutMenu=new JMenu("        About        ");
  	JMenu helpMenu=new JMenu("         Help        ");
  	JMenu exitMenu=new JMenu("         Exit        ");
  	JMenuItem branchMenuItem=new JMenuItem("Branch Details");
  	JMenuItem softwareVendorMenuItem=new JMenuItem("Software Vendor Details");
  	JMenuItem logOutMenuItem=new JMenuItem("Log Out");
  	JMenuItem helpMenuItem=new JMenuItem("Help");  	
 	JMenuItem branchMenuItem1=new JMenuItem("Branch Details");
  	JMenuItem softwareVendorMenuItem1=new JMenuItem("Software Vendor Details");
  	JMenuItem logOutMenuItem1=new JMenuItem("Log Out");
  	JMenuItem helpMenuItem1=new JMenuItem("Help");
  	JMenuItem refresh=new JMenuItem("Refresh");
  	JPopupMenu popMenu=new JPopupMenu();
  	public static String help=new String("\nKeyBoard ShortCuts are\n" +
  			"alt+a  About\n" +
  			"alt+a+s Software Vendor \n" +
  			"alt+a+b Branch Details\n" +
  			"alt+h  Help\n" +
  			"alt+h+e ShortCuts\n" +
  			"alt+x   Exit\n" +
  			"alt+x+g ShutDown\n" +
  			"Note: use alt+'Highlighted Character of Component to activate it'\n" +
  			"      Use Tab to go to particular componentother than alt+keys\n" +
  			"      Use Enter or Space Key to Click\n");  	
  	public static String softvendor=new String("    Developed By \n\n    " +
			"Venkata Thippanna Rao P R\n    " +
			"IIITB \n    Electronic City\n    Bangalore");
  	public static String branchdet=new String("    Branch Name: Lakshmi Motors\n    TVS Motor Cycle Show Room\n" +
				"    #11/16 Shivaji Nagar\n    Bangalore-5606000\n    " +
					"Phone:080-55551234/45\n    Cell-09886540782 ");
  	public LoginWindow(String title,String path)
  		{
  		this.title=title;
  		try
  			{
  			this.setSize(screenSize);
  			this.setResizable(false);
  			this.setTitle(title);
  			ImageIcon companyIcon = new ImageIcon("ven.jpg");
  			alignIconX=companyIcon.getIconWidth();
  			alignIconY=companyIcon.getIconHeight();
  			bar=new JMenuBar();
  			this.setJMenuBar(bar);  			
  			aboutMenu.setMnemonic('A');aboutMenu.setToolTipText("Gives information About Software Vendor and ShowRoom Details");  			
  			helpMenu.setMnemonic('H'); helpMenu.setToolTipText("Gives Help TOpics"); 		
  			exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Log Out");
  			bar.add(aboutMenu);
  			bar.add(helpMenu);
  			bar.add(exitMenu);  			
  			branchMenuItem.setMnemonic('B'); branchMenuItem.setToolTipText("GIves Details about the Show Room"); 			
  			softwareVendorMenuItem.setMnemonic('S');softwareVendorMenuItem.setToolTipText("Gives Details About the Vendor");
  				aboutMenu.add(softwareVendorMenuItem);   			
  				aboutMenu.add(branchMenuItem);  			
  			logOutMenuItem.setMnemonic('g'); logOutMenuItem.setToolTipText("Shuts Down the System");
  				exitMenu.add(logOutMenuItem);   			
  			helpMenuItem.setMnemonic('e');  helpMenuItem.setToolTipText("Gives Shortcuts");				
  				helpMenu.add(helpMenuItem);
 			p0.setLayout(null);
  			jPanel1.setLayout(null);
  			jPanel1.setBounds(new Rectangle(screenSize.width/4,screenSize.height/4+250, 219, 209));
  			jLabel1.setText("Office Use");
  			jLabel1.setBounds(new Rectangle(67, 3, 74, 25));
  			jLabel2.setText("User Name");
  			jLabel2.setBounds(new Rectangle(7, 49, 74, 27));
  			jLabel3.setText("Password");
  			jLabel3.setBounds(new Rectangle(7, 90, 66, 24));	
  			jTextField1.setBounds(new Rectangle(79,	49, 113, 25));
  			jTextField1.setToolTipText("Enter User Name Here");
  			jPasswordField1.setBounds(new Rectangle(79, 89, 114, 25));
  			jPasswordField1.setToolTipText("Enter Password Here");
  			jButton1.setText("Ok");jButton1.setToolTipText("TO Login Press This");
  			jButton1.setBounds(new Rectangle(19, 138, 78, 32));
  			jButton2.setText("Cancel");jButton2.setToolTipText("To Reset the Text Fields");
  			jButton2.setBounds(new Rectangle(115, 138, 78, 32));    
  			jPanel1.add(jLabel1, null);
  			jPanel1.add(jLabel2, null);
  			jPanel1.add(jLabel3, null);
  			jPanel1.add(jTextField1, null);
  			jPanel1.add(jPasswordField1, null);
  			jPanel1.add(jButton1, null);
  			jPanel1.add(jButton2, null);  			
  			jPanel2.setLayout(null);
  			jPanel2.setBounds(new Rectangle(screenSize.width/4 + 220,screenSize.height/4+220, 223, 221));
  			jLabel4.setText("Customer Login");
  			jLabel4.setBounds(new Rectangle(55, 28, 105, 44));
  			jButton3.setText("Login");jButton3.setToolTipText("Logs in as Customer");
  			jButton3.setBounds(new Rectangle(42, 99, 139, 90));
  			jLabel5.setText("Premier TVS Bike Show Room");
  			//l.setFont(new Font("Dialog", 10, 12));
  			jLabel5.setBounds(new Rectangle(0, 70,300, 80));  			
  			jPanel2.add(jLabel4, null);
  			jPanel2.add(jButton3, null);    
  			jPanel3.setLayout(null);
  			jPanel3.setBounds(new Rectangle(screenSize.width/4,30,540,alignIconY));    
  			jLabel6.setIcon(companyIcon);
  			jLabel6.setBounds(300, 12,alignIconX,alignIconY);       
  			jPanel3.add(jLabel5, null);
  			jPanel3.add(jLabel6, null);    
  			p0.add(jPanel1,null);
  			p0.add(jPanel2,null);
  			p0.add(jPanel3,null);   
  			branchMenuItem.addActionListener(this);  			
    		softwareVendorMenuItem.addActionListener(this);    	
    		helpMenuItem.addActionListener(this);    		
    		logOutMenuItem.addActionListener(this);  
    		branchMenuItem1.addActionListener(this);  			
    		softwareVendorMenuItem1.addActionListener(this);    	
    		helpMenuItem1.addActionListener(this);    		
    		logOutMenuItem1.addActionListener(this); 
    		refresh.addActionListener(this);
    		popMenu.add(branchMenuItem1);
    		popMenu.addSeparator();
  			popMenu.add(softwareVendorMenuItem1);
  			popMenu.addSeparator();
  			popMenu.add(refresh);
  			popMenu.addSeparator();
  			popMenu.add(helpMenuItem1);
  			popMenu.addSeparator();
  			popMenu.add(logOutMenuItem1);
  		    addMouseListener(
  		          new MouseAdapter() {
  		          public void mousePressed(MouseEvent event)
  		          {
  		                  checkmyEvent(event);
  		          }

  		          public void mouseReleased(MouseEvent event)
  		          {
  		                  checkmyEvent(event);
  		          }
  		          private void checkmyEvent(MouseEvent event)
  		          {
  		                  popMenu.show(event.getComponent(),
  		                                                  event.getX(),event.getY());
  		          }
  		          }
  		          );
  			jButton1.setMnemonic('o');
  			jButton2.setMnemonic('c');
  			jButton3.setMnemonic('l');
  			jButton1.addActionListener(this);    		
  			jButton2.addActionListener(this);
    		jButton3.addActionListener(this);
  			this.getContentPane().add(p0);   
  			this.show(true);
  			this.addWindowListener(new WindowCloser());
  			jTextField1.requestFocus();
  			}
  		catch (Exception e)	{  e.printStackTrace();	}
  		}
  	public class WindowCloser extends WindowAdapter 
  		{
  		public void windowClosing(WindowEvent e) 
  			{
  			Window w = e.getWindow();
  			JOptionPane.showMessageDialog(null,"\n\n     System Shutting Down....! \n\n\n                ThankQ\n\n");
  			w.setVisible(false);
  			w.dispose();
 			System.exit(0);
  			}  		
  		}
  	public void actionPerformed(ActionEvent ae)
  		{
  		if(ae.getSource()==refresh)
  			{
  			jTextField1.setText("");
			jPasswordField1.setText("");
			jTextField1.requestFocus();
  			}
  	    else if(ae.getSource()==branchMenuItem || ae.getSource()==branchMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.branchdet);
  		else if(ae.getSource()==softwareVendorMenuItem || ae.getSource()==softwareVendorMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.softvendor);
  		else if(ae.getSource()==helpMenuItem || ae.getSource()==helpMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.help);
  		else if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
  			{
  			JOptionPane.showMessageDialog(null,"\n\n     System Shutting Down....! \n\n\n                ThankQ\n\n");
			System.exit(0);
  			}
  		else
  		try
  			{
        	int flag=0;
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	con = DriverManager.getConnection( "jdbc:odbc:bss");
     		stmt = con.createStatement();
        	rs=stmt.executeQuery("SELECT * FROM user");
        	if(ae.getActionCommand().equals("Ok"))
				{
        		userName = jTextField1.getText();
        		passWord = jPasswordField1.getText();
        		while(rs.next())
					{
        			if(userName.equals(rs.getString("username")))
						{
        				if(passWord.equals(rs.getString("password")))
							{
        					this.dispose();
      				        authentication=rs.getInt("ua");
      				        eid=new String(rs.getString("eid"));
      				        name=new String(rs.getString("name"));
      				        salary=rs.getDouble("salary");
      				        Employee u=new Employee(userName,authentication,eid,name,salary);      				        		        
      				        if(authentication==2) //manager authentication level is set to 2
      				        	new Manager(u);
      				        else if(authentication==1) //Accountant authentication level is set to 1
      				        	new SaleOrService(u);      				        		
      				        else if(authentication==3) //marketing Executive Authentication level is set to 3
      				        	new ViewModels(u);
      				        else if(authentication==4) //Supervisor Authentication level is set to 4
      				        	new Supervisor(u);
      				        JOptionPane.showMessageDialog(null,"        Hai "+u.name 
      				        		+"\nYou are Successfully Logged In " + "\n     Click OK to Continue"); 
      				        }
        				else
							{
        					jPasswordField1.setText("");
        					jPasswordField1.requestFocus();
        					JOptionPane.showMessageDialog(null,"ENTER CORRECT PASSWORD ");
							}
        				flag=1;
						}
					}
				if(flag==0)
					{
					JOptionPane.showMessageDialog(null,"Invalid User "+ userName);
					jTextField1.setText("");
					jPasswordField1.setText("");
					}
				}
        	else if(ae.getActionCommand().equals("Cancel"))
				{
        		jTextField1.setText("");
        		jPasswordField1.setText("");
				}
        	else if(ae.getActionCommand().equals("Login"))
				{
        		this.dispose();
        		new ViewModels(new Employee());
        		JOptionPane.showMessageDialog(null, "Welcome to " + title
        				+"\n  Select Bike Category and Carry on to view the details");
				}
        	}
     	catch (SQLException sqle)           { 	System.err.println(sqle.getMessage()); }
        catch (ClassNotFoundException cnfe) {  	System.err.println(cnfe.getMessage()); }
		catch (Exception e)                 {   System.err.println(e.getMessage()); }
		finally 
			{  
			try	{	if ( con != null )	con.close(); }
			catch (SQLException sqle)       { 	System.err.println(sqle.getMessage());	}
			}
  		}
    public static String retDate()
    	{
    	return( d.getDate()+"/" + (d.getMonth()+1)+"/"+(d.getYear()-100+2000));
    	}
    public static String retTime()
    	{
    	return(d.getHours()+":"+d.getMinutes()+":"+d.getSeconds());
    	}
  	public static void main(String[] args)
  		{
  		new LoginWindow("Lakshmi Motors Show Room Maintainence Software","ven.jpg");
  		}
  	}


