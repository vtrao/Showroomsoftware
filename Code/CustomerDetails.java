
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import java.util.Date;
public class CustomerDetails extends JFrame implements ActionListener,ItemListener
  {
  Date d;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JPanel jPanel1 = new JPanel();
  JLabel customerNameL = new JLabel();
  JLabel addressL = new JLabel();
  JLabel dateL = new JLabel();
  JLabel nOfServiceL = new JLabel();
  JLabel warrantyPeriodL = new JLabel();
  JLabel phoneNumberL = new JLabel();
  JLabel cellNumberL = new JLabel();
  JLabel bikeNameL = new JLabel();
  JLabel amountL=new JLabel();
  JTextField amountTF=new JTextField();
  JComboBox customerNameCB=new JComboBox();
  JTextField customerNameTF = new JTextField();
  JTextField line1TF = new JTextField();
  JTextField line2TF = new JTextField();
  JTextField cityTF = new JTextField();
  JTextField stateTF = new JTextField();
  JTextField pinCodeTF = new JTextField();
  JTextField bikeNameTF = new JTextField();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JLabel jLabel5 = new JLabel();
  JTextField dateTF = new JTextField();
  JTextField phoneNumberTF = new JTextField();
  JTextField cellNumberTF = new JTextField();
  JTextField freeServicesTF = new JTextField();
  JTextField warrantyPeriodTF = new JTextField();
  JButton saveButton = new JButton();
  JButton cancelButton = new JButton();
  JButton exitButton = new JButton();
  JMenuBar bar;
  JMenu exitMenu=new JMenu("         Exit        ");
  JMenuItem logOutMenuItem=new JMenuItem("Back");
  JMenuItem logOutMenuItem1=new JMenuItem("Back");
  JPopupMenu popMenu=new JPopupMenu();
  JMenuItem save=new JMenuItem("Save and Print");
  JMenuItem cancel=new JMenuItem("Cancel");
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5;
  JLabel dummy=new JLabel();
  String s;
  Connection con;
  Statement stmt,stmt1,stmt2,stmt3;
  ResultSet rset,rset1,rset2;
  int type;
  Employee em;
  public CustomerDetails(Employee emp,String s1,int typee)
    {	
	em=emp;s=s1;type=typee;  
    this.setSize(screenSize);
    this.setResizable(false);
  	this.setTitle("Lakshmi Motors--UserLevel--->Accountant and User-->"+emp.name);
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection( "jdbc:odbc:bss");	
		if(type!=1)
			{
			stmt=con.createStatement();
			stmt1=con.createStatement();
			stmt2=con.createStatement();
			rset=stmt.executeQuery("select custname from servicestable where status = 1");
			while(rset.next())
				customerNameCB.addItem(rset.getString("custname"));
			doIt();
			}
		}
	catch (SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		}
	catch (ClassNotFoundException cnfe)
   		{
		System.err.println(cnfe.getMessage());
   		}	
    try
      {
      bar=new JMenuBar();
  	  this.setJMenuBar(bar); 
      jPanel1.setLayout(null);
      jPanel1.setBounds(new Rectangle(11, 47, 773, 496));
      customerNameL.setText("Customer Name");
      addressL.setText("Customer Address");
      if(type==1)
      	{
    	  bikeNameTF.setText(Accountant.bkn);
      	//JOptionPane.showMessageDialog(null,Accountant.bkn);
    	nOfServiceL.setText("Free Services");
    	warrantyPeriodL.setText("Warranty Period (in months)");
      	}
      else
      	{
    	
    	nOfServiceL.setText("Type of Service");
    	warrantyPeriodL.setText("In Time");
      	}
      phoneNumberL.setText("Phone Number(with STD Code)");
      cellNumberL.setText("Cell Number");
      jLabel1.setText("Line 1");
      jLabel2.setText("Line 2");
      jLabel3.setText("City");
      jLabel4.setText("State");
      jLabel5.setText("Pin Code");
      saveButton.setText("Save and Print");
      cancelButton.setText("Cancel");
      exitButton.setText("Exit");
      dateL.setText("Date");  
      customerNameL.setBounds(new Rectangle(347, 160, 112, 20));     
      addressL.setBounds(new Rectangle(680, 160, 126, 24));
      nOfServiceL.setBounds(new Rectangle(348, 293, 91, 29));
      warrantyPeriodL.setBounds(new Rectangle(350, 366, 167, 21));
      phoneNumberL.setBounds(new Rectangle(516, 434, 185, 25));
      cellNumberL.setBounds(new Rectangle(611, 388, 82, 28));
      customerNameTF.setBounds(new Rectangle(347, 194, 209, 24));
      customerNameCB.setBounds(new Rectangle(347, 194, 209, 24));
      line1TF.setBounds(new Rectangle(707, 196, 183, 24));
      cellNumberTF.setBounds(new Rectangle(707, 391, 137, 24));
      freeServicesTF.setBounds(new Rectangle(351, 330, 152, 26));
      line2TF.setBounds(new Rectangle(706, 233, 181, 25));
      cityTF.setBounds(new Rectangle(707, 271, 123, 24));
      stateTF.setBounds(new Rectangle(707, 311, 146, 23));
      pinCodeTF.setBounds(new Rectangle(707, 352, 97, 23));
      jLabel1.setBounds(new Rectangle(642, 204, 42, 20));
      jLabel2.setBounds(new Rectangle(644, 238, 46, 23));
      jLabel3.setBounds(new Rectangle(654, 275, 40, 19));
      jLabel4.setBounds(new Rectangle(646, 315, 48, 19));
      jLabel5.setBounds(new Rectangle(625, 353, 57, 20));
      dateTF.setBounds(new Rectangle(349, 259, 153, 27));
      warrantyPeriodTF.setBounds(new Rectangle(351, 393, 149, 25));
      saveButton.setBounds(new Rectangle(400, 574, 120, 42));
      cancelButton.setBounds(new Rectangle(568, 574, 90, 43));
      saveButton.setToolTipText("Click this to Save or update the contents");
      saveButton.setMnemonic('s');
      cancelButton.setMnemonic('c');
      cancelButton.setToolTipText("Click here to reset");
      exitButton.setMnemonic('e');
      exitButton.setToolTipText("Click Here to Go back");
      exitButton.setBounds(new Rectangle(704, 574, 91, 44));
      phoneNumberTF.setBounds(new Rectangle(708, 434, 138, 25)); 
      dateL.setBounds(new Rectangle(347, 227, 81, 26));
      bikeNameL.setText("Bike Name");
      bikeNameL.setBounds(new Rectangle(352, 430, 97, 20));
      bikeNameTF.setBounds(new Rectangle(352, 454, 149, 25));
      bikeNameTF.setEditable(false);
      amountL.setText("Amount  Rs");
      amountL.setBounds(new Rectangle(463, 500, 91, 22));
      amountTF.setBounds(new Rectangle(540, 500, 129, 26));
      logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
  	  com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
  	  jPanel1.add(com,null);
  	  jPanel1.add(logo,null);
  	exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Go Back");
	logOutMenuItem.setText("Back");
	logOutMenuItem.setMnemonic('B');
	logOutMenuItem.setToolTipText("TO GO Back");
	logOutMenuItem1.setText("Back");
	exitMenu.add(logOutMenuItem);
	bar.add(exitMenu);
	logOutMenuItem.addActionListener(this);
	logOutMenuItem1.addActionListener(this);
	save.addActionListener(this);
	cancel.addActionListener(this);
	popMenu.add(save);
	popMenu.add(cancel);
	popMenu.addSeparator();
	popMenu.add(new JMenuItem("Refresh"));
	popMenu.addSeparator();
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

  
      this.getContentPane().add(jPanel1);;
      jPanel1.add(customerNameL, null);
      jPanel1.add(addressL, null);
      jPanel1.add(dateL, null);
      jPanel1.add(nOfServiceL, null);
      jPanel1.add(warrantyPeriodL, null);
      jPanel1.add(phoneNumberL, null);
      jPanel1.add(cellNumberL, null);
      jPanel1.add(bikeNameTF,null);
      jPanel1.add(bikeNameL,null);
      if(type==1)
    	  jPanel1.add(customerNameTF, null);
      else
      { jPanel1.add(customerNameCB, null);d=new Date();}
      jPanel1.add(line1TF, null);
      jPanel1.add(line2TF, null);
      jPanel1.add(cityTF, null);
      jPanel1.add(stateTF, null);
      jPanel1.add(pinCodeTF, null);
      jPanel1.add(jLabel1, null);
      jPanel1.add(jLabel2, null);
      jPanel1.add(jLabel3, null);
      jPanel1.add(jLabel4, null);
      jPanel1.add(jLabel5, null);
      jPanel1.add(dateTF, null);
      jPanel1.add(phoneNumberTF, null);
      jPanel1.add(cellNumberTF, null);
      jPanel1.add(freeServicesTF, null);
      jPanel1.add(warrantyPeriodTF, null);
      jPanel1.add(saveButton, null);
      jPanel1.add(cancelButton, null);
      jPanel1.add(exitButton, null);
      jPanel1.add(amountL,null);
      jPanel1.add(amountTF,null);
     
      saveButton.addActionListener(this);
      cancelButton.addActionListener(this);
      exitButton.addActionListener(this);
      if(type==1)
      	{     
    	warrantyPeriodTF.setText(""+LoginWindow.warranty);      
    	freeServicesTF.setText(""+LoginWindow.freeservices);
      	}
      dateTF.setText(LoginWindow.retDate()); 
      warrantyPeriodTF.setEditable(false);
      freeServicesTF.setEditable(false);
      dateTF.setEditable(false);
 
      customerNameCB.addItemListener(this);
      }
    catch (Exception e)
      {
      e.printStackTrace();
      }
    this.show();
    this.addWindowListener(new WindowCloser());
    }
  public void itemStateChanged(ItemEvent ie)
  	{
	if(ie.getSource()==customerNameCB)
		{
		doIt();
		}
  	}
  public void doIt()
  	{
	try
		{
		phoneNumberTF.setText("");
		cellNumberTF.setText("");
		line1TF.setText("");
		line2TF.setText("");
		cityTF.setText("");
		pinCodeTF.setText("");
		stateTF.setText("");
		amountTF.setText("");
		stmt=con.createStatement();
		rset1=stmt.executeQuery("select typeofservice,intime,eid,bikename from servicestable where custname = '"+
				customerNameCB.getSelectedItem()+"'");
		while(rset1.next())
			{
			freeServicesTF.setText(rset1.getString("typeofservice"));
			warrantyPeriodTF.setText(rset1.getString("intime"));
			bikeNameTF.setText(rset1.getString("bikename"));
			dummy.setText(rset1.getString("eid"));
			}
		}
	catch(SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		}
  	}
  public void actionPerformed(ActionEvent ae)
  	{
	if(ae.getSource()==logOutMenuItem || ae.getSource()==exitButton || ae.getSource()==logOutMenuItem1)
		{
 		this.dispose();
 		new SaleOrService(em);
		}
    else if(ae.getSource()==saveButton || ae.getSource()==save)
		{
		int flag=0;
		try  // validation for customerName
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
		try  // validation for City Name
			{
			String str=cityTF.getText();
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
				JOptionPane.showMessageDialog(null,"City Name Cant be This Much Long");
				cityTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"Enter a Valid City Name "+cityTF.getText());
			cityTF.setText("");
			flag=1;
			}
		try  // validation for state Name
			{
			String str=stateTF.getText();
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
				JOptionPane.showMessageDialog(null,"State Name Cant be This Much Long");
				stateTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"Enter a Valid State Name "+stateTF.getText());
			stateTF.setText("");
			flag=1;
			}
		try	 // validation for amount
			{ 
			Float.parseFloat(amountTF.getText());
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in Amount Field!");
			amountTF.setText("");
			flag=1;
			}
		try	
			{  
			String str=pinCodeTF.getText();
			int i,l;
			char c[]=str.toCharArray();
			l=str.length();
			for(i=0;i<l;i++)
				{	
				if((c[i]>=48 && c[i]<=57));
				else c[i]=(char)Integer.parseInt("venki");
				}
			if(l>10)
				{
				JOptionPane.showMessageDialog(null,"Pin Code Cant be This Much Long");
				pinCodeTF.setText("");
				flag=1;
				}
			else if(l<6)
				{
				JOptionPane.showMessageDialog(null,"Pin Code Cant be This Much Short");
				pinCodeTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"InValid Value Enter a Integer Value in PinCode Field!");
			pinCodeTF.setText("");
			flag=1;
			}
		try	
			{
			if(cellNumberTF.getText().equals("")) ;
			else
				{
				String str=cellNumberTF.getText();
				int i,l;
				char c[]=str.toCharArray();
				l=str.length();
				for(i=0;i<l;i++)
					{	
					if((c[i]>=48 && c[i]<=57));
					else c[i]=(char)Integer.parseInt("venki");
					}
				if(l>13)
					{
					JOptionPane.showMessageDialog(null,"Cell Number Cant be This Much Long ");
					cellNumberTF.setText("");
					flag=1;
					}
				else if(l<10)
					{
					JOptionPane.showMessageDialog(null,"Cell Number Cant be This Much Short ");
					cellNumberTF.setText("");
					flag=1;
					}
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"InValid Value Enter a Integer Value in Cell Number Field!");
			cellNumberTF.setText("");
			flag=1;
			}
		try	
			{
			String str=phoneNumberTF.getText();
			int i,l;
			char c[]=str.toCharArray();
			l=str.length();
			for(i=0;i<l;i++)
				{	
				if((c[i]>=48 && c[i]<=57));
				else c[i]=(char)Integer.parseInt("venki");
				}
			if(l>13)
				{
				JOptionPane.showMessageDialog(null,"Phone Number Cant be This Much Long ");
				phoneNumberTF.setText("");
				flag=1;
				}
			else if(l<11)
				{
				JOptionPane.showMessageDialog(null,"Phone Number Cant be This Much Short ");
				phoneNumberTF.setText("");
				flag=1;
				}
			}
		catch(Exception e)
			{
			JOptionPane.showMessageDialog(null,"InValid Value Enter a Integer Value in Phone Number Field!");
			phoneNumberTF.setText("");
			flag=1;
			}
		String str;
		if(flag==0)
			{
			if(type==1)
				str=new String(customerNameTF.getText());
			else
				str=new String(customerNameCB.getSelectedItem().toString());
			if(dateTF.getText().equals("") || phoneNumberTF.getText().equals("") ||
					freeServicesTF.getText().equals("") || warrantyPeriodTF.getText().equals("") || 
					amountTF.getText().equals("") || line1TF.getText().equals("") || line2TF.getText().equals("") ||
					cityTF.getText().equals("") || stateTF.getText().equals("") || pinCodeTF.getText().equals("") )
				{
				JOptionPane.showMessageDialog(null,"Some Fields are Left Without Information!\n " +
				"Cross Check Data in Fields and Try again"); 
				}
			else
				{
				if(type==1)
					try
						{
						stmt=con.createStatement();
						stmt.executeUpdate("insert into customerdetailstable values ('"+str+"','"
							+dateTF.getText()+"','"
							+freeServicesTF.getText()+"','"
							+warrantyPeriodTF.getText()+"','"
							+phoneNumberTF.getText()+"','"
							+cellNumberTF.getText()+"','"
							+s+"','"
							+line1TF.getText()+"','"
							+line2TF.getText()+"','"
							+cityTF.getText()+"','"
							+pinCodeTF.getText()+"','"
							+stateTF.getText()+"','"
							+"NA"+"','"+"NA"+"','"+"NA"+"',1,'"
							+amountTF.getText()+"' )");
						JOptionPane.showMessageDialog(null,"Saved Successfully!");
					        String data0 = "                   Lakshmi Motors(Authorised TVS ShowRoom)                 \n";    
					        String data1 = "\n                            Sales Bill                       \n\n";
					        String data2 = "                 Bike Name :     "+bikeNameTF.getText().toString();
					        String data3 = "\n                 Customer Name:     "+customerNameTF.getText().toString();
					        String data4 = "\n                 Purchased on:  "+LoginWindow.retDate();
					        String data5 = "\n                 Bill Amount:  Rs."+amountTF.getText().toString()+"\n\n\n";
					        String data51="\n\n\n      Manager Signature                               Accountant Signature\n\n\n";
					        String data6 = LoginWindow.branchdet;   
					        String data = data0 + data1 + data2 +  data3 + data4 + data5 +data51+  data6;
					    new print(data);
						this.dispose();
				 		new SaleOrService(em);
						}
					catch(SQLException sqle)
						{
						System.err.println(sqle.getMessage());
						}
				else
					try
						{
						String se=amountTF.getText();
						stmt=con.createStatement();stmt3=con.createStatement();
						stmt.executeUpdate("insert into customerdetailstable values ('"+str+"','"
							+dateTF.getText()+"','"
							+0+"','"
							+0+"','"
							+phoneNumberTF.getText()+"','"
							+cellNumberTF.getText()+"','"
							+s+"','"
							+line1TF.getText()+"','"
							+line2TF.getText()+"','"
							+cityTF.getText()+"','"
							+pinCodeTF.getText()+"','"
							+stateTF.getText()+"','"
							+freeServicesTF.getText()+"','"
							+warrantyPeriodTF.getText()+"','"
							+""+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"',2,'"
							+amountTF.getText()+"')");
						rset2=stmt3.executeQuery("select avail from employeetable where name = '"+dummy.getText()+"'");
						int av=0;
						while(rset2.next())
							av=rset2.getInt("avail");
						stmt1.executeUpdate("update employeetable set avail = '"+av+"' where name = '"+dummy.getText()+"'");
						stmt2.executeUpdate("update servicestable set status = 0 where intime = '"
							+warrantyPeriodTF.getText()+"' and custname = '"+str+"'");
						JOptionPane.showMessageDialog(null,"Saved Successfully!");
						String data0 = "                   Lakshmi Motors(Authorised TVS ShowRoom)                 \n";    
				        String data1 = "\n                            Service Bill                       \n\n";
				        String data2 = "                 Bike Name :     "+bikeNameTF.getText().toString();
				        String data3 = "\n                 Customer Name:     "+str;
				        String data4 = "\n                 Serviced on:  "+LoginWindow.retDate();
				        String data5 = "\n                 Bill Amount:  Rs."+amountTF.getText().toString()+"\n\n\n";
				        String data51="\n\n\n      Manager Signature                               Accountant Signature\n\n\n";
				        String data6 = LoginWindow.branchdet;   
				        String data = data0 + data1 + data2 +  data3 + data4 + data5 +data51+  data6;
					    new print(data);
						customerNameCB.removeItem(customerNameCB.getSelectedItem());
						doIt();
						phoneNumberTF.setText("");
						cellNumberTF.setText("");
						customerNameTF.setText("");
						line1TF.setText("");
						line2TF.setText("");
						cityTF.setText("");
						stateTF.setText("");
					    pinCodeTF.setText("");amountTF.setText("");
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
		phoneNumberTF.setText("");
		cellNumberTF.setText("");
		customerNameTF.setText("");
		line1TF.setText("");
		line2TF.setText("");
		cityTF.setText("");
		stateTF.setText("");
	    pinCodeTF.setText("");if(type!=1)amountTF.setText("");
		}
  	}
  public class WindowCloser extends WindowAdapter
 	{
 	public void windowClosing(WindowEvent e)
 		{
 		Window w = e.getWindow();
 		w.setVisible(false);
 		w.dispose();
 		new SaleOrService(em); 		
 		}
    }
}
