
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
public class SaleOrService extends JFrame implements ActionListener
	{
	Employee em;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JPanel jPanel2=new JPanel();
	JButton saleButton=new JButton();
	JButton serviceButton=new JButton();
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
	  JMenuItem generateSale=new JMenuItem("Generate Bill for Sale");
	  JMenuItem generateService=new JMenuItem("Generate Bill for Service");
	  JPopupMenu popMenu=new JPopupMenu();
	  JMenu passwordMenu=new JMenu("       Password Utility        ");	
	JLabel logo=LoginWindow.jLabel6;
	JLabel com=LoginWindow.jLabel5;	
	public SaleOrService(Employee emp)
		{	
		em=emp;
		try
			{
	        saleButton.setText("Generate Bill for Sales");saleButton.setMnemonic('S');
	        saleButton.setToolTipText("Click this TO go to Sales Wizard");
	        saleButton.setBounds(new Rectangle(542, 300, 200, 80));
	        serviceButton.setLabel("Generate Bill for Service");serviceButton.setMnemonic('r');
	        serviceButton.setToolTipText("Click this TO go to Service Wizard");
	        serviceButton.setBounds(new Rectangle(542, 400, 200, 80));
			this.setSize(screenSize);
			this.setResizable(false);
			this.setTitle("Lakshmi Motors--UserLevel--->Accountant and User-->"+em.name);
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
	        logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
	    	com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
	    	jPanel2.add(com,null);
	    	jPanel2.add(logo,null); 

	    	jPanel2.add(saleButton);
	    	jPanel2.add(serviceButton);
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
	    	generateSale.addActionListener(this);
	    	generateService.addActionListener(this);
	    	popMenu.add(generateSale);
	    	popMenu.add(generateService);
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
	        this.getContentPane().add(jPanel2);
	        jPanel2.setLayout(null);
	        jPanel2.setBounds(new Rectangle(54, 73, 624, 650));
	        saleButton.addActionListener(this);
	        serviceButton.addActionListener(this);
			this.show();
			this.addWindowListener(new WindowCloser());
			}
		catch(Exception e)
			{
			e.printStackTrace();
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
 		  		  	new ChangePasswordFrame(em);
 		  	  		}
 	    else if(ae.getSource()==saleButton || ae.getSource()==generateSale)
			{
			this.hide();
			new Accountant(em,this);
			}
		else if(ae.getSource()==serviceButton || ae.getSource()==generateService)
			{
			this.dispose();
			new CustomerDetails(em,"venki",2);
			}			
		}
 	public void envoke()
 		{
 		this.show();
        logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
    	com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
    	jPanel2.add(com,null);
    	jPanel2.add(logo,null);
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
}
