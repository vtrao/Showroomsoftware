
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;
public class ViewModels extends JFrame implements ActionListener,ItemListener
  {
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JLabel selectBikeCategoryLabel = new JLabel();
  JLabel rs1 = new JLabel();
  JTextField availabilityTF = new JTextField();   //availabilityTF
  JLabel color = new JLabel();
 //JButton photoGallary = new JButton();
  JLabel selectBikeNameLabel = new JLabel();
  JComboBox selectBikeCategoryCombo = new JComboBox();
  JButton viewFeaturesButton = new JButton();
  JLabel discountcost = new JLabel();
  JPanel jPanel1 = new JPanel();
  JLabel model = new JLabel();
  JLabel Availability = new JLabel();  
  JComboBox selectBikeNameCombo = new JComboBox();
  JLabel rs = new JLabel();
  JTextField discountTF = new JTextField();   //discountTF2
  JTextField modelTF = new JTextField();		//modelTF
  JTextField costAfterDiscountTF=new JTextField(); //costAfterDiscountTF3
  JLabel costAfterDiscountLab=new JLabel();
  JLabel rs2=new JLabel();
  JLabel cost1 = new JLabel();
  JTextField costprice = new JTextField();  //costprice 1
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5;
  JComboBox selectBikeColorCombo = new JComboBox();
  Employee emp;
  String name;  
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
  JMenuItem viewFeatures=new JMenuItem("View Features");
  Connection con;
  Statement stmt;
  ResultSet rset,rset1,rset2;
public ViewModels(Employee ee)
    {
	emp=ee;
    this.setSize(screenSize);
    this.setResizable(false);
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
    if(emp.userAuthentication==1)
    	name=new String("Accountant");
    else if(emp.userAuthentication==2)
    	name=new String("Manager");
    else if(emp.userAuthentication==3)
    	name=new String("Marketing Executive");
    else if(emp.userAuthentication==4)
    	name=new String("Supervisor");
    else
    	name=new String("Customer");
  	this.setTitle("Lakshmi Motors--UserLevel--->"+name+" and User-->"+emp.name);
	bar=new JMenuBar();
	this.setJMenuBar(bar); 
	if(emp.userAuthentication==3)
		{ 			
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
				viewFeatures.setToolTipText("TO View The Features of Various Bikes");
				viewFeatures.addActionListener(this);
				popMenu.add(viewFeatures);
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
		}
	else 
		{
		exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Go Back");
		logOutMenuItem.setMnemonic('O'); logOutMenuItem.setText("LogOut");
		logOutMenuItem.setToolTipText("Goes back TO Previous System");
		exitMenu.add(logOutMenuItem);
		bar.add(exitMenu);
		logOutMenuItem.addActionListener(this);
		logOutMenuItem1.addActionListener(this);
		if(emp.userAuthentication==2)
				{
				logOutMenuItem1.setText("Back");
				logOutMenuItem.setText("Back");logOutMenuItem.setMnemonic('B');
				viewFeatures.setToolTipText("TO View The Features of Various Bikes");
				viewFeatures.addActionListener(this);
				popMenu.add(viewFeatures);
				popMenu.addSeparator();
				}
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
		}	
    try
      	{
    	selectBikeCategoryCombo.setToolTipText("Select the Bike Category and go on to select Bike Name");
    	selectBikeCategoryCombo.addItem("BK60");
    	selectBikeCategoryCombo.addItem("BK100");
    	selectBikeCategoryCombo.addItem("BK150");
    	selectBikeNameCombo.setToolTipText("Select the Bike Name here and go on to select the Bike Colors");
    	selectBikeColorCombo.setToolTipText("Select Bike Colors to view the details");
    	doIt();doIt1();doIt2();
    	selectBikeCategoryLabel.setText("  Select Bike Category");
    	selectBikeCategoryLabel.setBounds(new Rectangle(336, 172, 130, 15));
   	    rs1.setBounds(new Rectangle(350, 386, 16, 15));
   	    availabilityTF.setBounds(new Rectangle(691, 288, 91, 21));
   	    color.setBounds(new Rectangle(517, 258, 30, 15));
   	    //photoGallary.setBounds(new Rectangle(512, 335, 126, 45));
   	    selectBikeNameLabel.setBounds(new Rectangle(514, 172, 120, 15));
   	    selectBikeCategoryCombo.setBounds(new Rectangle(342, 204, 124, 24));
   	    viewFeaturesButton.setBounds(new Rectangle(689, 434, 127, 47));
   	    viewFeaturesButton.setMnemonic('F');
   	    viewFeaturesButton.setToolTipText("TO View The Features of Various Bikes");
   	    discountcost.setBounds(new Rectangle(541, 354, 163, 15));
   	    costAfterDiscountLab.setBounds(700,354,163,15);
   	    costAfterDiscountTF.setBounds(700,380,102,25);
   	    costAfterDiscountTF.setEditable(false);
   	    jPanel1.setBounds(new Rectangle(315, 164, 657, 565));
   	    model.setBounds(new Rectangle(690, 173, 44, 15));
   	    Availability.setBounds(new Rectangle(691, 260, 62, 15));
   	    selectBikeNameCombo.setBounds(new Rectangle(514, 205, 124, 24));
   	    rs.setBounds(new Rectangle(522, 386, 16, 15));
   	    rs2.setBounds(680,386,16,15);
   	    rs2.setText("Rs");
   	    discountTF.setBounds(new Rectangle(543, 380, 102, 25));
   	    modelTF.setBounds(new Rectangle(687, 206, 94, 23));
   	    cost1.setBounds(new Rectangle(370, 355, 109, 15));
   	    costprice.setBounds(new Rectangle(370, 380, 102, 25));
   	    selectBikeColorCombo.setBounds(new Rectangle(516, 286, 124, 24));
  	    costprice.setEditable(false);
   	    cost1.setText("Cost Of Bike");
   	    modelTF.setEditable(false);
   	    discountTF.setEditable(false);
   	    rs.setText("Rs");
   	    Availability.setText("Availability");
   	    model.setText("Model");
  	    jPanel1.setLayout(null);
   	    discountcost.setText("Discount Offered");
   	    costAfterDiscountLab.setText("Cost After Discount");
   	    viewFeaturesButton.setLabel("View Featues");
   	    selectBikeNameLabel.setText(" Select Bike Name");
   	   // photoGallary.setLabel("PhotoGallary!");
   	    color.setText("Color");
   	    availabilityTF.setEditable(false);
   	    rs1.setText("Rs");
   	    logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
		com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
		jPanel1.add(com,null);
		jPanel1.add(logo,null);

        this.getContentPane().add(jPanel1);
        jPanel1.add(costAfterDiscountTF);
        jPanel1.add(costAfterDiscountLab);
        jPanel1.add(rs2);
   	    jPanel1.add(selectBikeCategoryLabel, null);
   	    jPanel1.add(selectBikeCategoryCombo, null);
   	    jPanel1.add(selectBikeNameCombo, null);
   	    jPanel1.add(selectBikeNameLabel, null);
   	    jPanel1.add(modelTF, null);
   	    jPanel1.add(model, null);
   	    jPanel1.add(availabilityTF, null);
   	    jPanel1.add(color, null);
   	    jPanel1.add(Availability, null);
   	    jPanel1.add(cost1, null);
   	    jPanel1.add(rs1, null);
   	    jPanel1.add(costprice, null);
   	    jPanel1.add(discountcost, null);
   	    jPanel1.add(rs, null);
   	    jPanel1.add(discountTF, null);
   	    if(emp.userAuthentication==2 || emp.userAuthentication==3)
   	    	jPanel1.add(viewFeaturesButton, null);
   	   // jPanel1.add(photoGallary, null);
   	    jPanel1.add(selectBikeColorCombo, null);	
		viewFeaturesButton.addActionListener(this);
		//photoGallary.addActionListener(this);
		selectBikeNameCombo.addItemListener(this);
		selectBikeColorCombo.addItemListener(this);
		selectBikeCategoryCombo.addItemListener(this);
        }
    catch(Exception e)
      	{
    	e.printStackTrace();
      	}
   	this.show();
   	this.addWindowListener(new WindowCloser(emp));
   	}
  public void doIt()
  	{
	  selectBikeNameCombo.removeAllItems();
		try
			{
			stmt=con.createStatement();
			rset=stmt.executeQuery("select distinct bikename from bikeavailabilitytable where bikecategory = '"
					+selectBikeCategoryCombo.getSelectedItem()+"'");			
			while(rset.next())
				selectBikeNameCombo.addItem(rset.getString("bikename"));
			}
		catch (SQLException sqle)
			{
			System.err.println(sqle.getMessage());
			}
  	}
  public void doIt1()
  	{
		try
		{
		stmt=con.createStatement();
		rset1=stmt.executeQuery("select distinct color from bikeavailabilitytable where bikename = '"
				+selectBikeNameCombo.getSelectedItem()+"'");
		selectBikeColorCombo.removeAllItems();
		while(rset1.next())
			{
			selectBikeColorCombo.addItem(rset1.getString("color"));
			}
		}
	catch (SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		}
  	}
  public void doIt2()
  	{
	  try
		{
		stmt=con.createStatement();
		rset2=stmt.executeQuery("select bikemodel, availability, discount, cost from bikeavailabilitytable " 
				+ "where  bikename = '" +selectBikeNameCombo.getSelectedItem()+ "' and  color = '" +
				selectBikeColorCombo.getSelectedItem()+"'");
		while(rset2.next())
			{
			modelTF.setText(rset2.getString("bikemodel"));
			availabilityTF.setText(rset2.getString("availability"));
			discountTF.setText(rset2.getString("discount"));
			costprice.setText(rset2.getString("cost"));
			costAfterDiscountTF.setText(""+(Double.parseDouble(costprice.getText())-Double.parseDouble(discountTF.getText())));
			}
		}
	catch (SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		}
  	}
  public class WindowCloser extends WindowAdapter
 	{
 	Employee emp;
 	public WindowCloser(Employee emp)
 		{
 		this.emp=emp;
 		}
 	public void windowClosing(WindowEvent e)
 		{
 		Window w = e.getWindow();
 		//w.setVisible(false);
 		if(emp.userAuthentication==2)
 			{
 			w.dispose();
 			new Manager(emp);				
 			}
 		else if(emp.userAuthentication==3)
 			{
 			JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
 			w.dispose();
 			new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
 			}
 		else
 			{
 			JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
 			w.dispose();
 			new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
 			}
 		}
 	}
  public void itemStateChanged(ItemEvent ie)
  	{
	if(ie.getSource()==selectBikeCategoryCombo)
	 	{
		doIt();
	 	}
	else if(ie.getSource()==selectBikeNameCombo)
 		{
		 doIt1();
 		}	
	else if(ie.getSource()==selectBikeColorCombo)
		{
		doIt2();
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
			{
			if(emp.userAuthentication==2)
				{
				this.dispose();
				new Manager(emp);				
				}
			else if(emp.userAuthentication==3)
				{
				JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
				this.dispose();
				new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
				}
			else
				{
				JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
				this.dispose();
				new LoginWindow("Lakshmi Motors Show Room Maintainence Software","f/ven.jpg");
				}
		  	}
		else if(ae.getSource()==changePasswordMenuItem || ae.getSource()==changePasswordMenuItem1)
		  	  		{
		  		  	this.dispose();
		  		  	new ChangePasswordFrame(emp);
		  	  		}  
    else if(ae.getSource()==viewFeaturesButton || ae.getSource()==viewFeatures)
		  {
		  this.dispose();
		  new AddViewFeatures(emp,2); 
		  }
  	} 
  public void envoke()
  	{
    this.show();
    logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
	com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
    jPanel1.add(com,null);
	jPanel1.add(logo,null);
  	}
  public static void main(String args[])
  	{
	new ViewModels(new Employee());  
  	}
}

