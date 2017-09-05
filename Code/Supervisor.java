
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Supervisor extends JFrame implements ActionListener
  {
  Date d=new Date();
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JLabel jLabel1 = new JLabel();
  JTextField customerNameTF = new JTextField();
  JLabel jLabel2 = new JLabel();
  JComboBox typeOfServiceCB = new JComboBox();
  JLabel jLabel3 = new JLabel();
  JComboBox eidCB = new JComboBox();
  JLabel jLabel4 = new JLabel();
  JTextField inTimeTF = new JTextField();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel5 = new JLabel();
  JTextField deliveredTimeTF = new JTextField();
  JLabel jLabel6 = new JLabel();
  JTextField durationTF = new JTextField();
  JLabel jLabel7 = new JLabel();
  JComboBox bikeNameCB = new JComboBox();
  JButton saveButton = new JButton();
  JButton cancelButton = new JButton();
  JButton exitButton = new JButton();
  JMenuBar bar;
  JMenu aboutMenu=new JMenu("        About        ");
  JMenu helpMenu=new JMenu("         Help        ");
  JMenu exitMenu=new JMenu("         Exit        ");
  JMenuItem branchMenuItem=new JMenuItem("Branch Details");
  JMenuItem softwareVendorMenuItem=new JMenuItem("Software Vendor Details");
  JMenuItem logOutMenuItem=new JMenuItem("Log Out");
  JMenuItem helpMenuItem=new JMenuItem("Help");  
  JMenuItem changePasswordMenuItem=new JMenuItem("Change Password");
  JMenuItem branchMenuItem1=new JMenuItem("Branch Details");
  JMenuItem softwareVendorMenuItem1=new JMenuItem("Software Vendor Details");
  JMenuItem logOutMenuItem1=new JMenuItem("Log Out");
  JMenuItem helpMenuItem1=new JMenuItem("Help");
  JMenuItem changePasswordMenuItem1=new JMenuItem("Change Password");
  JPopupMenu popMenu=new JPopupMenu();
  JMenu passwordMenu=new JMenu("       Password Utility        ");
  JMenuItem save=new JMenuItem("Save");
  JMenuItem cancel=new JMenuItem("Cancel");
  Employee emp;
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5;
  Connection con;
  Statement stmt,stmt1,stmt2;
  ResultSet rset,rset1,rset2;
  public Supervisor(Employee emp)
    {
	this.emp=emp;
    this.setSize(screenSize);
    this.setResizable(false);
  	this.setTitle("Lakshmi Motors--UserLevel--->Supervisor and User-->"+emp.name);
    try
		{
    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	con = DriverManager.getConnection( "jdbc:odbc:bss");
		}
    catch (SQLException sqle)
		{
    	System.err.println(sqle.getMessage());
		}
    catch (ClassNotFoundException cnfe)
		{
    	System.err.println(cnfe.getMessage());
		}
    dooIt();
    bar=new JMenuBar();
	this.setJMenuBar(bar);  			
	aboutMenu.setMnemonic('A');aboutMenu.setToolTipText("Gives information About Software Vendor and ShowRoom Details");  			
	helpMenu.setMnemonic('H'); helpMenu.setToolTipText("Gives Help TOpics"); 		
	exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Log Out");
	passwordMenu.setMnemonic('p');passwordMenu.setToolTipText("Provides the Password Change Utility");
	bar.add(aboutMenu);
	bar.add(helpMenu);
	bar.add(passwordMenu);
	bar.add(exitMenu);  			
	branchMenuItem.setMnemonic('B'); 
	branchMenuItem.setToolTipText("GIves Details about the Show Room"); 			
	softwareVendorMenuItem.setMnemonic('S');
	softwareVendorMenuItem.setToolTipText("Gives Details About the Vendor");
		aboutMenu.add(softwareVendorMenuItem);   			
		aboutMenu.add(branchMenuItem);  			
	logOutMenuItem.setMnemonic('g'); 
	logOutMenuItem.setToolTipText("Shuts Down the System");
		exitMenu.add(logOutMenuItem);   			
	helpMenuItem.setMnemonic('e');  
	helpMenuItem.setToolTipText("Gives Shortcuts");				
		helpMenu.add(helpMenuItem);  		
	changePasswordMenuItem.setMnemonic('w');
	changePasswordMenuItem.setToolTipText("TO Change the Password of Current User");
	    passwordMenu.add(changePasswordMenuItem);
	typeOfServiceCB.addItem("Free");
	typeOfServiceCB.addItem("Paid");
	jLabel1.setText("Customer Name");
    jLabel1.setBounds(new Rectangle(371, 217, 108, 25));
    customerNameTF.setBounds(new Rectangle(372, 243, 172, 23));
    customerNameTF.setToolTipText("Enter Customer Name here");
    jLabel2.setText("Type of Service");
    jLabel2.setBounds(new Rectangle(589, 217, 116, 23));
    typeOfServiceCB.setBounds(new Rectangle(588, 245, 122, 23));
    typeOfServiceCB.setToolTipText("Select The type of Service here");
    jLabel3.setText("Employee Allotted");
    jLabel3.setBounds(new Rectangle(737, 217, 111, 22));
    eidCB.setBounds(new Rectangle(737, 245, 128, 21));
    eidCB.setToolTipText("Select the Employee Id to Assign this service work to him");
    jLabel4.setText("In Time");
    jLabel4.setBounds(new Rectangle(591, 284, 93, 21));
    inTimeTF.setBounds(new Rectangle(591, 305, 114, 22));
    jPanel1.setLayout(null);
    jPanel1.setBounds(new Rectangle(367, 237, 526, 369));
    jLabel5.setText("Estimated Service Time in Hours");
    jLabel5.setBounds(new Rectangle(737, 278, 190, 30));
    deliveredTimeTF.setBounds(new Rectangle(737, 304, 105, 22));
    deliveredTimeTF.setToolTipText("Enter the Estimated Service Time basing on the Vehicle Condition");
    jLabel6.setText("Duration");
    jLabel6.setBounds(new Rectangle(592, 340, 109, 17));
    durationTF.setBounds(new Rectangle(593, 363, 98, 22));
    jLabel7.setText("Select Bike Name");
    jLabel7.setBounds(new Rectangle(737, 341, 101, 19));
    bikeNameCB.setBounds(new Rectangle(740, 363, 112, 20));
    bikeNameCB.setToolTipText("Select the Bike name of the Customer to be Serviced");
    saveButton.setText("Save");saveButton.setMnemonic('S');
    saveButton.setToolTipText("Click this to Save the Details");
    saveButton.setBounds(new Rectangle(483, 479, 83, 37));
    cancelButton.setText("Cancel");cancelButton.setMnemonic('C');
    cancelButton.setBounds(new Rectangle(601, 480, 81, 35));
    cancelButton.setToolTipText("Click this to Reset the Contents");
    exitButton.setText("Exit");exitButton.setMnemonic('E');
    exitButton.setBounds(new Rectangle(717, 480, 82, 36));exitButton.setToolTipText("TO Log Out Click Here");
    inTimeTF.setText((new Date()).getHours()+":"+(new Date()).getMinutes()+":"+(new Date()).getSeconds());
	logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
	com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
	jPanel1.add(com,null);
	jPanel1.add(logo,null);
    jPanel1.add(jLabel1, null);
    jPanel1.add(customerNameTF, null);
    jPanel1.add(jLabel2, null);
    jPanel1.add(typeOfServiceCB, null);
    jPanel1.add(jLabel3, null);
    jPanel1.add(eidCB, null);
    jPanel1.add(jLabel4, null);
    jPanel1.add(inTimeTF, null);
    jPanel1.add(jLabel5, null);
    jPanel1.add(deliveredTimeTF, null);
    //jPanel1.add(jLabel6, null);
    //jPanel1.add(durationTF, null);
    jPanel1.add(jLabel7, null);
    jPanel1.add(bikeNameCB, null);
    jPanel1.add(saveButton, null);
    jPanel1.add(cancelButton, null);
    jPanel1.add(exitButton, null);

	inTimeTF.setEditable(false);
	saveButton.addActionListener(this);
	cancelButton.addActionListener(this);
	exitButton.addActionListener(this);
	branchMenuItem.addActionListener(this);  			
	softwareVendorMenuItem.addActionListener(this);    	
	helpMenuItem.addActionListener(this);    		
	logOutMenuItem.addActionListener(this);  
	changePasswordMenuItem.addActionListener(this);
	branchMenuItem1.addActionListener(this);  			
	softwareVendorMenuItem1.addActionListener(this);    	
	helpMenuItem1.addActionListener(this);    		
	logOutMenuItem1.addActionListener(this); 
	changePasswordMenuItem1.addActionListener(this);
	save.addActionListener(this);
	cancel.addActionListener(this);
	popMenu.add(save);
	popMenu.add(cancel);
	popMenu.addSeparator();
	popMenu.add(branchMenuItem1);
	popMenu.add(softwareVendorMenuItem1);
	popMenu.addSeparator();
	popMenu.add(new JMenuItem("Refresh"));
	popMenu.addSeparator();
	popMenu.add(changePasswordMenuItem1);
	popMenu.addSeparator();
	popMenu.add(helpMenuItem1);
	popMenu.add(logOutMenuItem1);		
	addMouseListener( new MouseAdapter() {
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
	            popMenu.show(event.getComponent(),event.getX(),event.getY());
	          	}});
	this.getContentPane().add(jPanel1);
    this.show();
    this.addWindowListener(new WindowCloser());
    }
  public void dooIt()
  	{
	try
		{
		eidCB.removeAllItems();
		bikeNameCB.removeAllItems();
		stmt=con.createStatement();
		stmt1=con.createStatement();
		rset=stmt.executeQuery("select name,avail from employeetable where ua = "+5+" and avail > "+0+" order by avail desc");
		while(rset.next())
			eidCB.addItem(rset.getString("name"));
		rset1=stmt.executeQuery("select distinct bikename from bikeavailabilitytable ");
		while(rset1.next())
			bikeNameCB.addItem(rset1.getString("bikename"));
		}
	catch(SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		}
  	}
   public class WindowCloser extends WindowAdapter
 		{
 		public void windowClosing(WindowEvent e)
 			{
 			Window w = e.getWindow();JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
 			w.setVisible(false);
 			w.dispose();
 			new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
 			}
 		}
   public void actionPerformed(ActionEvent ae)
	{
    if(ae.getSource()==branchMenuItem || ae.getSource()==branchMenuItem1)
		JOptionPane.showMessageDialog(null,LoginWindow.branchdet);
	else if(ae.getSource()==softwareVendorMenuItem || ae.getSource()==softwareVendorMenuItem1)
				JOptionPane.showMessageDialog(null,LoginWindow.softvendor);
	else if(ae.getSource()==helpMenuItem || ae.getSource()==helpMenuItem1)
				JOptionPane.showMessageDialog(null,LoginWindow.help);
	else if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
				{JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
	  		  	this.dispose();
	  		  	new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
	  			}
	else if(ae.getSource()==changePasswordMenuItem || ae.getSource()==changePasswordMenuItem1)
	  	  		{
	  		  	this.dispose();
	  		  	new ChangePasswordFrame(emp);
	  	  		}  
	else{
	try
	    {
	    stmt=con.createStatement();
	    }
	catch (SQLException sqle)
	    {
		System.err.println(sqle.getMessage());
	    }
	 if(ae.getSource()==saveButton || ae.getSource()==save)
	 	{
		int flag=0;
		float f1=0.0f;
		try
			{
			String str=customerNameTF.getText();
			int i,l;
			char c[]=str.toCharArray();
			l=str.length();
			for(i=0;i<l;i++)
				{	
				if((c[i]>=65 && c[i]<=90) ||(c[i]>=97 && c[i]<=122) || (c[i] ==46) || (c[i]==32));
				else c[i]=(char)Integer.parseInt("venki");
				}
			if(l>50)
				{
				JOptionPane.showMessageDialog(null,"Customer Name Cant be This Much Long");
				customerNameTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"Enter a Valid Customer Name "+customerNameTF.getText());
			customerNameTF.setText("");
			flag=1;
			}
		try { 
			f1=Float.parseFloat(deliveredTimeTF.getText());
			if(f1<0)
				{
				JOptionPane.showMessageDialog(null,"Estimated Time Value Cant Be Negitive!");
				deliveredTimeTF.setText("");
				flag=1;
				}
			else if(f1>99)
				{
				JOptionPane.showMessageDialog(null,"Estimated Time Value Cant Be this Much Large! "+f1);
				deliveredTimeTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"InValid Value Enter a Integer or Real Value in Service Time of Bike Field!");
			deliveredTimeTF.setText("");
			flag=1;
			}		
		if(flag==0)
			{
			if(customerNameTF.getText().equals("") || deliveredTimeTF.getText().equals(""))
				{
				JOptionPane.showMessageDialog(null,"Some Fields are Left Without Information!\n " +
					"Cross Check Data in Fields and Try again"); 
				}
			else
				{
				try
					{
					stmt2=con.createStatement();
					stmt.executeUpdate("insert into servicestable values ('"
							+customerNameTF.getText()+"','"
							+typeOfServiceCB.getSelectedItem()+"','"
							+eidCB.getSelectedItem()+"','"
							+inTimeTF.getText()+"','"
							+deliveredTimeTF.getText()+"','"
							+bikeNameCB.getSelectedItem()+"',1,'"+
							""+d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()-100+2000)+"' )");
					customerNameTF.setText("");
					deliveredTimeTF.setText("");
					rset2=stmt2.executeQuery("select avail from employeetable where name= '"+eidCB.getSelectedItem()+"'");
					int av=0;
					while(rset2.next())
						av=rset2.getInt("avail");
					stmt1.executeUpdate("update employeetable set avail = "+(av-1)+" where name = '"+eidCB.getSelectedItem()+"'");
					//eidCB.removeItem(eidCB.getSelectedItem());
					dooIt();
					JOptionPane.showMessageDialog(null,"Saved Successfully!");
					}
				catch(SQLException sqle)
					{
					System.err.println(sqle.getMessage());
					}
				}
			}
		}
	 else if(ae.getSource()==cancelButton || ae.getSource()==cancel)
	 	{
		customerNameTF.setText("");
		deliveredTimeTF.setText("");
	 	}
	 else if(ae.getSource()==exitButton)
	 	{
	 	JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
	 	this.dispose();
	 	new LoginWindow("Lakshmi Motors Show Room Maintainence Software","ven.jpg");	
		}
	 }
	}

  public static void main(String[] args)
    {
    Supervisor supervisor1 = new Supervisor(new Employee());
    }
  }

