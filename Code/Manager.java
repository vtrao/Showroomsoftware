

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Manager extends JFrame implements ActionListener
  {
  Employee em;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JPanel jPanel1 = new JPanel();
  JButton addModelButton = new JButton();
  JButton offerDiscountButton = new JButton();
  JButton modifyCostButton = new JButton();
  JButton addFeaturesToBikeButton = new JButton();
  JButton seeExistingModelButton = new JButton(); 
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
  JMenu clickHere=new JMenu("Click Here");
  JMenuItem addm=new JMenuItem("Add Model");
  JMenuItem offD=new JMenuItem("Offer Discount");
  JMenuItem cC=new JMenuItem("Change Cost Price");
  JMenuItem aE=new JMenuItem("Add or Edit Features");
  JMenuItem sE=new JMenuItem("See Existing Models");
  JMenu report=new JMenu("       Reports       ");
  JMenu report1=new JMenu("Reports");
  JMenuItem outBikeReport=new JMenuItem("Bikes Out of Stock");
  JMenuItem servicesReport=new JMenuItem("Services Took Up");
  JMenuItem currentServicesReport=new JMenuItem("Current Services Report");
  JMenuItem entireStock=new JMenuItem("Stock");
  JMenuItem entireStock1=new JMenuItem("Stock");
  JMenuItem outBikeReport1=new JMenuItem("Bikes Out of Stock");
  JMenuItem servicesReport1=new JMenuItem("Services Took Up");
  JMenuItem currentServicesReport1=new JMenuItem("Current Services Report");
  JMenuItem employeeReport=new JMenuItem("Employees");
  JMenuItem bikeReport=new JMenuItem("Bike Models Report");
  JMenuItem employeeReport1=new JMenuItem("Employees");
  JMenuItem bikeReport1=new JMenuItem("Bike Models Report");
  JMenuItem refresh=new JMenuItem("Refresh");
  JButton addEmp=new JButton("Add Employee");
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5; 	
  public Manager(Employee emp)
    {
	em=emp;
    this.setSize(screenSize);
    this.setResizable(false);
  	this.setTitle("Lakshmi Motors--UserLevel--->Manager and User-->"+emp.name);
    this.addWindowListener(new WindowCloser());
    try  
    	{
    	bar=new JMenuBar();
			this.setJMenuBar(bar);
			report1.add(employeeReport1);
			report1.add(entireStock1);
			report1.add(bikeReport1);
			report1.add(outBikeReport1);
			report1.add(servicesReport1);
			report1.add(currentServicesReport1);
			clickHere.add(addm);
			clickHere.add(offD);
			clickHere.add(cC);
			clickHere.add(aE);
			clickHere.add(sE);
			aboutMenu.setMnemonic('A');aboutMenu.setToolTipText("Gives information About Software Vendor and ShowRoom Details");  			
			helpMenu.setMnemonic('H'); helpMenu.setToolTipText("Gives Help TOpics"); 		
			exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Log Out");
			passwordMenu.setMnemonic('p');passwordMenu.setToolTipText("Provides the Password Change Utility");
			report.setMnemonic('r');report.setToolTipText("For Generation of Various Reports");
			bar.add(aboutMenu);
			bar.add(report);
			bar.add(helpMenu);
			bar.add(passwordMenu);
			bar.add(exitMenu);  	
			employeeReport.setMnemonic('p');employeeReport.setToolTipText("Generates Report on Employees");
			bikeReport.setMnemonic('k');bikeReport.setToolTipText("Generates Report on Bikes Available");
			outBikeReport.setMnemonic('u');outBikeReport.setToolTipText("Generates Report on Out of Bikes");
			servicesReport.setMnemonic('i');servicesReport.setToolTipText("Generates Report on Services took up so Far");
			currentServicesReport.setMnemonic('n');currentServicesReport.setToolTipText("Generates Report on Services in Process");
			report.add(employeeReport);
			report.add(entireStock);
			report.add(bikeReport);
			report.add(outBikeReport);
			report.add(servicesReport);
			report.add(currentServicesReport);
			branchMenuItem.setMnemonic('B'); 
			branchMenuItem.setToolTipText("Gives Details about the Show Room"); 			
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
        jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(108, 131, 500, 600));
        addModelButton.setText("Add Model");
        addModelButton.setToolTipText("To add a New Model");
        addModelButton.setBounds(new Rectangle(455, 82, 185, 78));
        addModelButton.setMnemonic('M');
        offerDiscountButton.setText("Offer Discount");
        offerDiscountButton.setToolTipText("To offer More Discount");
        offerDiscountButton.setBounds(new Rectangle(455, 191, 185, 75));
        offerDiscountButton.setMnemonic('d');
        modifyCostButton.setToolTipText("To Change the Cost Price of Bike");
        modifyCostButton.setLabel("Modify Cost Of Model");
        modifyCostButton.setMnemonic('C');
        modifyCostButton.setBounds(new Rectangle(455, 290, 181, 79));
        addFeaturesToBikeButton.setText("Add Features To Bike ");
        addFeaturesToBikeButton.setToolTipText("TO Add or Edit the Features of Bike");
        addFeaturesToBikeButton.setBounds(new Rectangle(455, 393, 182, 74));
        addFeaturesToBikeButton.setMnemonic('f');
        seeExistingModelButton.setText("See Existing Models");
        seeExistingModelButton.setToolTipText("To view Various Bike Models");
        seeExistingModelButton.setBounds(new Rectangle(455, 490, 180, 76));
        seeExistingModelButton.setMnemonic('E');
        addEmp.setToolTipText("To Add Employees");
        addEmp.setMnemonic('y');
        addEmp.setBounds(455,590,180,76);
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
		employeeReport.addActionListener(this);
		bikeReport.addActionListener(this);
		outBikeReport.addActionListener(this);
		servicesReport.addActionListener(this);
		currentServicesReport.addActionListener(this);
		employeeReport1.addActionListener(this);
		bikeReport1.addActionListener(this);
		outBikeReport1.addActionListener(this);
		servicesReport1.addActionListener(this);
		currentServicesReport1.addActionListener(this);
		entireStock.addActionListener(this);
		entireStock1.addActionListener(this);
		addm.addActionListener(this);
		offD.addActionListener(this);
		aE.addActionListener(this);
		sE.addActionListener(this);
		cC.addActionListener(this);
		refresh.addActionListener(this);
		popMenu.add(report1);
		popMenu.addSeparator();
		popMenu.add(clickHere);
		popMenu.add(branchMenuItem1);
		popMenu.addSeparator();
		popMenu.add(softwareVendorMenuItem1);
		popMenu.addSeparator();
		popMenu.add(refresh);
		popMenu.addSeparator();
		popMenu.add(changePasswordMenuItem1);
		popMenu.addSeparator();
		popMenu.add(helpMenuItem1);
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
   
        this.getContentPane().add(jPanel1);        

		logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
		com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
		jPanel1.add(com,null);
		jPanel1.add(logo,null);
        jPanel1.add(addModelButton, null);
        jPanel1.add(offerDiscountButton, null);
        jPanel1.add(modifyCostButton, null);
        jPanel1.add(addFeaturesToBikeButton, null);
        jPanel1.add(seeExistingModelButton, null); 
        jPanel1.add(addEmp,null);
        addModelButton.addActionListener(this);
        offerDiscountButton.addActionListener(this);
        modifyCostButton.addActionListener(this);
        addFeaturesToBikeButton.addActionListener(this);
        seeExistingModelButton.addActionListener(this);
        addEmp.addActionListener(this);
        }
    catch (Exception e) 
    	{
    	e.printStackTrace();
    	}
    this.show(true);
    }
  public class WindowCloser extends WindowAdapter
 	{
 	public void windowClosing(WindowEvent e)
 		{
 		Window w = e.getWindow();
 		JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
 		w.setVisible(false);
 		w.dispose();
 		new LoginWindow("Lakshmi Motors Show Room Maintainence Software","ven.jpg");
 		}
 	}
  public void actionPerformed(ActionEvent ae)
  	{
	  if(ae.getSource()==refresh)
	  	{
		 addModelButton.requestFocus(); 
	  	}
	  else if(ae.getSource()==branchMenuItem || ae.getSource()==branchMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.branchdet);
  	  else if(ae.getSource()==softwareVendorMenuItem || ae.getSource()==softwareVendorMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.softvendor);
  	  else if(ae.getSource()==helpMenuItem || ae.getSource()==helpMenuItem1)
  			JOptionPane.showMessageDialog(null,LoginWindow.help);
  	  else if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
  			{
  		    JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ");
  		  	this.dispose();
  		  	new LoginWindow("Lakshmi Motors Show Room Maintainence Software","ven.jpg");
  			}
  	  else if(ae.getSource()==changePasswordMenuItem || ae.getSource()==changePasswordMenuItem1)
  	  		{
  		  	this.dispose();
  		  	new ChangePasswordFrame(em);
  	  		}
  	  else if(ae.getSource()==addModelButton || ae.getSource()== addm)
	    {
		this.hide();  
		new ModelDiscountCost(1,this);  
	    }
	  else if(ae.getSource()==offerDiscountButton || ae.getSource()==offD)
	    {
		this.hide();
		new ModelDiscountCost(2,this);  
	    }
	  else if(ae.getSource()==modifyCostButton || ae.getSource()==cC)
	    {
		this.hide();
		new ModelDiscountCost(3,this);  
	    }
	  else if(ae.getSource()==addFeaturesToBikeButton || ae.getSource()==aE)
	    {
		this.dispose();
		new AddViewFeatures(em,1);
	    }
	  else if(ae.getSource()==seeExistingModelButton || ae.getSource()==sE)
	  	{
		this.dispose();
		new ViewModels(em);
	  	}
	  else if(ae.getSource()==employeeReport || ae.getSource()==employeeReport1)
	  	{
		this.dispose();
		String a[]={"Employee Id","Name Of the Employee","Salary"};
		new ReportGenerator("                   " +
				"        Employee Details Report",em,"select eid,name,salary from employeetable",3,a);
	  	}
	  else if(ae.getSource()==bikeReport || ae.getSource()==bikeReport1)
	  	{
		this.dispose();
		String a[]={"Bike Category","Bike Name","Model(Year)","Cost","discount"};
		new ReportGenerator("                     " +
				"               Bike Models Report",em,"select distinct bikecategory,bikename,bikemodel,cost,discount from bikeavailabilitytable",5,a);
	  	}
	  else if(ae.getSource()==entireStock || ae.getSource()==entireStock1)
	  	{
		this.dispose();
		String a[]={"Bike Category","Bike Name","Color","Model(Year)","Cost","discount","Availablity"};
		new ReportGenerator("                     " +
				"               Bike Models Report",em,"select distinct bikecategory,bikename,color,bikemodel,cost,discount,availability from bikeavailabilitytable",7,a);
	  	}
	  else if(ae.getSource()==outBikeReport || ae.getSource()==outBikeReport1)
	  	{
		this.dispose();
		String a[]={"Bike Category","Bike Name","color","Model(Year)","Stock","Cost","discount"};
		new ReportGenerator("                      " +
				"         Bikes Out of Stock Report",em,"select bikecategory,bikename,color,bikemodel,availability,cost,discount from bikeavailabilitytable where availability = 0",7,a);	
	  	}
	  else if(ae.getSource()==servicesReport || ae.getSource()==servicesReport1)
	  	{
		this.dispose();
		String a[]={"Customer Name","Type Of Service","Employee Allotted","Bike Name","Date"};
		new ReportGenerator("                      " +
				"           Services Handled Report",em,"select custname,typeofservice,eid,bikename,date from servicestable where status = 0",5,a);
	  	}
	  else if(ae.getSource()==currentServicesReport || ae.getSource()==currentServicesReport1)
	  	{
		this.dispose();
		String a[]={"Customer Name","Type Of Service","ID Of Employee Allotted","Bike Name"};
		new ReportGenerator("                      " +
				"           Current Services Report",em,"select custname,typeofservice,eid,bikename from servicestable where status = 1",4,a);
	  	}
	  else if(ae.getSource()==addEmp)
	  	{
		this.hide();
		new ModelDiscountCost(4,this);
	  	}
  	}
  public void envoke()
  	{
	this.show();
	jPanel1.add(logo,null);
	jPanel1.add(com,null);
  	}
  public static void main(String args[])
  	{
	new Manager(new Employee());  
  	}  
}

