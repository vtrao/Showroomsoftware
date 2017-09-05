

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ModelDiscountCost extends JFrame implements ActionListener,ItemListener
  {
  int id=0;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JPanel jPanel1 = new JPanel();
  JLabel selectBikeCategoryLab = new JLabel();
  JLabel selectBikeNameLab = new JLabel();
  JLabel modellab = new JLabel();
  JLabel colorLab = new JLabel();
  JLabel availabilityLab = new JLabel();
  JLabel costLab = new JLabel();
  JLabel rs = new JLabel();
  JLabel rs1 = new JLabel();
  JLabel discountLab = new JLabel();
  JComboBox bikeCategoryCB=new JComboBox();
  JTextField bikeNameTF = new JTextField();
  JComboBox bikeNameCB=new JComboBox();
  JTextField modelTF = new JTextField();
  JComboBox colorTF = new JComboBox();
  JTextField empNameTF=new JTextField();
  JTextField availabilityTF = new JTextField();
  JTextField costTF = new JTextField();
  JTextField discountTF = new JTextField();
  JButton saveButton = new JButton();
  JButton cancelButton = new JButton();
  JButton exitButton = new JButton();
  int type;
  JMenuBar bar;
  JMenu exitMenu=new JMenu("         Exit        ");
  JMenuItem logOutMenuItem=new JMenuItem("Back");
  JMenuItem logOutMenuItem1=new JMenuItem("Back");
  JPopupMenu popMenu=new JPopupMenu();
  JMenuItem save=new JMenuItem("Save");
  JMenuItem cancel=new JMenuItem("Cancel");
  JLabel logo1=LoginWindow.jLabel6;
  JLabel com1=LoginWindow.jLabel5;
  Manager m;
  Connection con;
  Statement stmt;
  ResultSet rset,rset1,rset2,rset4;
  public ModelDiscountCost(int typ,Manager man) // type 1,2,3 for add model,change cost,change discount
    {
	m=man;
    type=typ;
    this.setSize(screenSize);
    this.setResizable(false);
    try
    	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    con = DriverManager.getConnection( "jdbc:odbc:bss");
	    if(type==4)
	    	{
	    	stmt=con.createStatement();
	    	rset4=stmt.executeQuery("select eid from employeetable");
	    	while(rset4.next())
	    		id=rset4.getInt("eid");
	    	}
    	}
	catch (SQLException sqle)
    	{
		System.err.println(sqle.getMessage());
    	}
	catch (ClassNotFoundException cnfe)
    	{
		System.err.println(cnfe.getMessage());
	    }//JOptionPane.showMessageDialog(null,""+id);
  	try  
    	{
  		bar=new JMenuBar();
  		this.setJMenuBar(bar); 
  		bikeCategoryCB.addItem("BK60");
  		bikeCategoryCB.addItem("BK100");
  		bikeCategoryCB.addItem("BK150");
  		jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(23, 56, 690, 618));
        modelTF.setEditable(false);
        costTF.setBounds(new Rectangle(581, 299, 86, 25));
        discountTF.setBounds(new Rectangle(707, 299, 86, 25));
        if(type==1)
        	{
        	modelTF.setText("2006");
      		colorTF.addItem("Black");
      		colorTF.addItem("Blue");
      		colorTF.addItem("Red");
      		colorTF.addItem("Green");
      		colorTF.addItem("Silver");
      		colorTF.addItem("White");
        	this.setTitle("Lakshmi Motors--UserLevel--->Manager-->Add a Model");
        	selectBikeCategoryLab.setText("Select Bike Category");
        	selectBikeNameLab.setText("Enter Bike name");
        	modellab.setText("Model");
        	colorLab.setText("Select Color");
        	availabilityLab.setText("Enter Stock in GoDown");
        	costLab.setText("Enter Cost");
        	discountLab.setText("Enter Discount");
        	colorTF.setBounds(new Rectangle(540, 211, 117, 26));
            jPanel1.add(bikeCategoryCB, null);
            jPanel1.add(bikeNameTF, null);
            jPanel1.add(colorTF, null);
            jPanel1.add(rs, null);
            jPanel1.add(rs1, null);
            jPanel1.add(modelTF, null);
        	}
        else if(type==2)
        	{
        	this.setTitle("Lakshmi Motors--UserLevel--->Manager-->Modify Discount Value");
        	selectBikeCategoryLab.setText("Select Bike Category");
        	selectBikeNameLab.setText("Select Bike name");
        	modellab.setText("Model");
        	colorLab.setText("Color");
        	availabilityLab.setText("Stock");
        	costLab.setText("Previous Discount");
        	discountLab.setText("Enter New Discount");
            jPanel1.add(bikeCategoryCB, null);
            jPanel1.add(bikeNameCB, null);
            modelTF.setEditable(false);
            colorTF.setEditable(false);
            availabilityTF.setEditable(false);
            costTF.setEditable(false);
            colorTF.setBounds(new Rectangle(540, 211, 117, 26));
            bikeCategoryCB.addItemListener(this);
            bikeNameCB.addItemListener(this);
            colorTF.addItemListener(this);	doIt();doIt1();doIt2();
            jPanel1.add(colorTF, null);
            jPanel1.add(rs, null);
            jPanel1.add(rs1, null);
            jPanel1.add(modelTF, null);
        	}
        else if(type==3)
        	{
        	this.setTitle("Lakshmi Motors--UserLevel--->Manager-->Modify Cost of Bike");
        	selectBikeCategoryLab.setText("Select Bike Category");
        	selectBikeNameLab.setText("Select Bike name");
        	modellab.setText("Model");
        	colorLab.setText("Color");
        	availabilityLab.setText("Stock");
        	costLab.setText("Previous Cost");
        	discountLab.setText("Enter New Cost");
            jPanel1.add(bikeCategoryCB, null);
            jPanel1.add(bikeNameCB, null);
            modelTF.setEditable(false);
            colorTF.setEditable(false);
            availabilityTF.setEditable(false);
            costTF.setEditable(false);
            colorTF.setBounds(new Rectangle(540, 211, 117, 26));
            bikeCategoryCB.addItemListener(this);
            bikeNameCB.addItemListener(this);
            colorTF.addItemListener(this);	doIt();doIt1();doIt2();
            jPanel1.add(colorTF, null);
            jPanel1.add(rs, null);
            jPanel1.add(rs1, null);
            jPanel1.add(modelTF, null);
        	}
        else if(type==4)
        	{
        	this.setTitle("Lakshmi Motors--UserLevel--->Manager-->Add an Employee");
        	logo1.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
    		com1.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
    		jPanel1.add(com1,null);
    		jPanel1.add(logo1,null);
        	colorLab.setText("Employee name");
        	costLab.setText("Capacity");
        	discountLab.setText("User Level");
        	discountTF.setText("5"); //userlevel
        	discountTF.setEditable(false);
        	availabilityLab.setText("Salary");
        	costTF.setText("3");//capacity
            costTF.setBounds(new Rectangle(540, 299, 86, 25));
            discountTF.setBounds(new Rectangle(667, 299, 86, 25));
        	availabilityTF.setText("5000");//salary
        	//availabilityTF.setEditable(false);
        	empNameTF.setBounds(new Rectangle(540, 211, 117, 26));
            jPanel1.add(empNameTF, null);
        	}
        selectBikeCategoryLab.setBounds(new Rectangle(350, 95, 131, 24));
        selectBikeNameLab.setBounds(new Rectangle(356, 184, 129, 26));
        modellab.setBounds(new Rectangle(536, 99, 104, 16));
        colorLab.setBounds(new Rectangle(541, 185, 100, 20));
        availabilityLab.setBounds(new Rectangle(692, 184, 150, 15));
        costLab.setBounds(new Rectangle(562, 276, 130, 11));
        rs.setText("Rs");
        rs.setBounds(new Rectangle(555, 303, 28, 18));
        rs1.setText("Rs");
        rs1.setBounds(new Rectangle(684, 301, 20, 18));     
        discountLab.setBounds(new Rectangle(685, 272, 111, 18));
        bikeNameTF.setBounds(new Rectangle(357, 212, 126, 25));
        bikeCategoryCB.setBounds(new Rectangle(351, 123, 129, 25));
        bikeNameCB.setBounds(new Rectangle(357, 212, 126, 25));        
        modelTF.setBounds(new Rectangle(537, 122, 107, 24));        
        availabilityTF.setBounds(new Rectangle(694, 212, 107, 26));
        saveButton.setText("Save");
        saveButton.setToolTipText("Click this to Save or update the contents");
        saveButton.setMnemonic('s');
        saveButton.setBounds(new Rectangle(388, 453, 97, 40));
        cancelButton.setLabel("Cancel");cancelButton.setMnemonic('c');
        cancelButton.setBounds(new Rectangle(518, 451, 99, 40));
        cancelButton.setToolTipText("Click here to reset");
        exitButton.setText("Exit");exitButton.setMnemonic('e');
        exitButton.setBounds(new Rectangle(650, 452, 100, 41));
        exitButton.setToolTipText("Click Here to Go back");
		logo1.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
		com1.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
		jPanel1.add(com1,null);
		jPanel1.add(logo1,null);
        jPanel1.add(selectBikeCategoryLab, null);
        jPanel1.add(selectBikeNameLab, null);
        jPanel1.add(modellab, null);
        jPanel1.add(colorLab, null);
        jPanel1.add(availabilityLab, null);
        jPanel1.add(costLab, null);
        jPanel1.add(discountLab, null);
        jPanel1.add(availabilityTF, null);
        jPanel1.add(costTF, null);
        jPanel1.add(discountTF, null);
        jPanel1.add(cancelButton, null);
        jPanel1.add(saveButton, null);
        jPanel1.add(exitButton, null);
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

        this.getContentPane().add(jPanel1);
    	saveButton.addActionListener(this);
    	cancelButton.addActionListener(this);
    	exitButton.addActionListener(this);
    	}
    catch (Exception e) 
    	{
    	e.printStackTrace();
    	}
    this.show();
    this.addWindowListener(new WindowCloser(m));
    }
  public void doIt()
  	{
		bikeNameCB.removeAllItems();
		try
			{
			stmt=con.createStatement();
			rset=stmt.executeQuery("select distinct bikename from bikeavailabilitytable where bikecategory = '"
					+bikeCategoryCB.getSelectedItem()+"'");			
			while(rset.next())
				bikeNameCB.addItem(rset.getString("bikename"));
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
				+bikeNameCB.getSelectedItem()+"'");
		colorTF.removeAllItems();
		while(rset1.next())
			{
			colorTF.addItem(rset1.getString("color"));
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
				+ "where  bikename = '" +bikeNameCB.getSelectedItem()+ "' and  color = '" +
				colorTF.getSelectedItem()+"'");
		while(rset2.next())
			{
			modelTF.setText(rset2.getString("bikemodel"));
			availabilityTF.setText(rset2.getString("availability"));
			if(type==2)
				costTF.setText(rset2.getString("discount"));
			else if(type==3)
				costTF.setText(rset2.getString("cost"));
			}
		}
	catch (SQLException sqle)
		{
		System.err.println(sqle.getMessage());
		} 
  	}
 public void itemStateChanged(ItemEvent ie)
 	{
	if(ie.getSource()==bikeCategoryCB)
	 	{
		doIt();
	 	}
	else if(ie.getSource()==bikeNameCB)
	 	{
		doIt1();
	 	}
	else if(ie.getSource()==colorTF)
		{
		doIt2();
		}		
 	}
 public void actionPerformed(ActionEvent ae)
 	{
	 if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
	 	{
		this.dispose();
		m.envoke();
	 	}
	 else 
	 {
	try
	    {
	    stmt=con.createStatement();
	    }
	catch (SQLException sqle)
	    {
		System.err.println(sqle.getMessage());
	    }
	 int flag=0;
	 if(ae.getSource()==saveButton || ae.getSource()==save)
	 	{	
		float f2=0.0f;
		if(type==1)
			{
			float f1=0.0f;
			int i1=0;
			try
				{
				String str=bikeNameTF.getText();
				int i,l;
				char c[]=str.toCharArray();
				l=str.length();
				for(i=0;i<l;i++)
					{	
					if((c[i]>=65 && c[i]<=90) ||(c[i]>=97 && c[i]<=122) || (c[i] ==46) || (c[i]==32) || (c[i]>=48 && c[i]<=57));
					else c[i]=(char)Integer.parseInt("venki");
					}
				if(l>50)
					{
					JOptionPane.showMessageDialog(null,"Bike Name Cant be This Much Long");
					bikeNameTF.setText("");
					flag=1;
				}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"Enter a Valid Name!");
				bikeNameTF.setText("");
				flag=1;
				}
			try
				{ 
				i1=Integer.parseInt(availabilityTF.getText());
				if(i1<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					availabilityTF.setText("");
					flag=1;
					}
				}
			catch(Exception E)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter an Integer Value in Stock Field!");
				availabilityTF.setText("");
				flag=1;
				}
			try
				{ 
				f1=Float.parseFloat(costTF.getText());
				if(f1<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					costTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in Cost of Bike Field!");
				costTF.setText("");
				flag=1;
				}
			try
				{ 
				f2=Float.parseFloat(discountTF.getText()); 
				if(f2<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					discountTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in Cost of Bike Field!");
				discountTF.setText("");
				flag=1;
				}
			try
				{char c;
				if(Float.parseFloat(costTF.getText()) < Float.parseFloat(discountTF.getText()))
					 c=(char)Integer.parseInt("venki");
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"Discount Can Never Be Greater than Cost Of Bike!");
				discountTF.setText("");
				flag=1;
				}
			if(flag==0)
				{
				if(availabilityTF.getText().equals("") || bikeNameTF.getText().equals("") || 
						costTF.getText().equals("") || discountTF.getText().equals("") )
					{
					JOptionPane.showMessageDialog(null,"Some Fields are Left Without Information!\n " +
						"Cross Check Data in Fields and Try again"); 
					}
				else
					{
					try
						{
						stmt.executeUpdate("insert into bikeavailabilitytable values ('"
								+bikeCategoryCB.getSelectedItem()+ "','"
								+bikeNameTF.getText()+             "',"
								+Integer.parseInt(modelTF.getText())+",'"
								+colorTF.getSelectedItem()+        "',"
								+i1+         ","
								+f1+                 ","
								+f2+             ")");
						JOptionPane.showMessageDialog(null,"Saved Successfully!");
						bikeNameTF.setText("");
						availabilityTF.setText("");
						costTF.setText("");
						discountTF.setText("");				
						}
					catch(SQLException sqle)
						{
						System.err.println(sqle.getMessage());
						JOptionPane.showMessageDialog(null,"Model Already Exists");
						}
					}
				}
			}
		else if(type==2)
			{
			try
				{ 
				f2=Float.parseFloat(discountTF.getText());
				if(f2<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					discountTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in New Discount of Bike Field!");
				discountTF.setText("");
				flag=1;
				}
			if(flag==0){
			if(availabilityTF.getText().equals("") || 
					costTF.getText().equals("") || discountTF.getText().equals("") )
				{
				JOptionPane.showMessageDialog(null,"Some Fields are Left Without Information!\n " +
						"Cross Check Data in Fields and Try again"); 
				}		
			else
				{	
				try
					{
					stmt.executeUpdate("update bikeavailabilitytable set discount = '"
							+discountTF.getText()+ "' " +
							"where  bikename = '" +bikeNameCB.getSelectedItem()+ "' and  color = '" +
							colorTF.getSelectedItem()+"' and bikemodel = " +
							modelTF.getText()+"" );							
					JOptionPane.showMessageDialog(null,"Updated Successfully!");
					discountTF.setText("");				
					doIt();doIt1();doIt2();
					}
				catch(SQLException sqle)
					{
					System.err.println(sqle.getMessage());
					}				
				}}
			}
		else if(type==3)
			{
			try
				{ 
				f2=Float.parseFloat(discountTF.getText()); 
				if(f2<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					discountTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in New Cost of Bike Field!");
				discountTF.setText("");
				flag=1;
				}
			if(flag==0){
			if(availabilityTF.getText().equals("") || 
					costTF.getText().equals("") || discountTF.getText().equals("") )
				{
				JOptionPane.showMessageDialog(null,"Some Fields are Left Without Information!\n " +
						"Cross Check Data in Fields and Try again"); 
				}		
			else
				{
				try
					{
					stmt.executeUpdate("update bikeavailabilitytable set cost = '"
							+discountTF.getText()+ "' " +
							"where  bikename = '" +bikeNameCB.getSelectedItem()+ "' and  color = '" +
							colorTF.getSelectedItem()+"' and bikemodel = " +
							modelTF.getText()+"" );
					JOptionPane.showMessageDialog(null,"Saved Successfully!");
					discountTF.setText("");	
					doIt();doIt1();doIt2();
					}
				catch(SQLException sqle)
					{
					System.err.println(sqle.getMessage());
					}				
				} }
			}
		else if(type==4)
			{
			try
				{
				String str=empNameTF.getText();
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
					JOptionPane.showMessageDialog(null,"Name Cant be This Much Long");
					empNameTF.setText("");
					flag=1;
					}
				if(empNameTF.getText().equals(""))
					{
					JOptionPane.showMessageDialog(null,"Name Cant be Null");
					empNameTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"Enter a Valid Name!");
				empNameTF.setText("");
				flag=1;
				}			
			try //capacity
				{
				int f1;
				f1=Integer.parseInt(costTF.getText());
				if(f1<0 || f1>8)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be this!");
					costTF.setText("");
					flag=1;
					}
				}
			catch(Exception e)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter a Real Value in Cost of Bike Field!");
				costTF.setText("");
				flag=1;
				}
			try //salary
				{	 
				int i1;
				i1=Integer.parseInt(availabilityTF.getText());
				if(i1<0)
					{
					JOptionPane.showMessageDialog(null,"Value Cant Be Negitive!");
					availabilityTF.setText("");
					flag=1;
					}
				}
			catch(Exception E)
				{
				JOptionPane.showMessageDialog(null,"InValid Value Enter an Integer Value in Stock Field!");
				availabilityTF.setText("");
				flag=1;
				}
			if(flag==0)
				{
				try
					{					
					stmt.executeUpdate("insert into employeetable values ("+(++id)+",'"
							+empNameTF.getText()+     "','"
							+availabilityTF.getText()+"','"
							+discountTF.getText()+"','"
							+costTF.getText()+"')");
					empNameTF.setText("");
					JOptionPane.showMessageDialog(null,"suc");
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
		if(type==1)
			{
			bikeNameTF.setText("");
			availabilityTF.setText("");
			costTF.setText("");
			discountTF.setText("");
			}
		if(type==2 || type==3)
			{
			discountTF.setText("");
			}
		if(type==4)
			empNameTF.setText("");
	 	}
	 else if(ae.getSource()==exitButton)
	 	{
		this.dispose();
		m.envoke();
		}
	 }
 	}
 public class WindowCloser extends WindowAdapter
 	{
	Manager ma; 
	public WindowCloser(Manager m)
	 	 {
		 ma=m;
	 	 }
 	public void windowClosing(WindowEvent e)
 		  {
 		  Window w = e.getWindow();
 		  w.setVisible(false);
 		  w.dispose();
 		  ma.envoke(); 		  
 		  }
 	}
}



