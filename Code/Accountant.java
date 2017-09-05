
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
public class Accountant extends JFrame implements ItemListener,ActionListener
  {
  public static String bkn;//=new String();	
  Employee em;
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JPanel jPanel1 = new JPanel();
  JLabel selectBikeCategoryLabel = new JLabel();
  JComboBox selectBikeCategoryCombo = new JComboBox();
  JComboBox selectBikeNameCombo = new JComboBox();
  JLabel selectBikeNameLabel = new JLabel();
  JTextField modelTF = new JTextField();
  JLabel model = new JLabel();
  JTextField availabilityTF = new JTextField();
  JComboBox selectBikeColorCombo = new JComboBox();
  JLabel color = new JLabel();
  JLabel Availability = new JLabel();
  JLabel cost1 = new JLabel();
  JLabel rs1 = new JLabel();
  JTextField costprice = new JTextField();
  JLabel discount = new JLabel();
  JLabel rs2 = new JLabel();
  JTextField discountprice = new JTextField();
  JLabel cost = new JLabel();
  JLabel rs = new JLabel();
  JTextField calculatedcost = new JTextField();
  JButton calculateBill = new JButton();
  JButton print = new JButton();
  JMenuBar bar;
  JMenu exitMenu=new JMenu("         Exit        ");
  JMenuItem logOutMenuItem=new JMenuItem("Back");
  JMenuItem logOutMenuItem1=new JMenuItem("Back");
  JPopupMenu popMenu=new JPopupMenu();
  JMenuItem bill=new JMenuItem("Calculate Bill");
  JMenuItem pnt=new JMenuItem("Billing");
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5;
  Connection con;
  Statement stmt;
  ResultSet rset,rset1,rset2;
  SaleOrService sa;
  public Accountant(Employee emp,SaleOrService s)
    {
	em=emp;
	sa=s;
    this.setSize(screenSize);
    this.setResizable(false);
  	this.setTitle("Lakshmi Motors--UserLevel--->Accountant AND User-->"+em.name);
    this.addWindowListener(new WindowCloser());
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
    try
      	{
        bar=new JMenuBar();
    	this.setJMenuBar(bar);
    	selectBikeCategoryCombo.addItem("BK60");
    	selectBikeCategoryCombo.addItem("BK100");
    	selectBikeCategoryCombo.addItem("BK150");
    	doIt();doIt1();doIt2();
    
    	costprice.setEditable(false);
    	discountprice.setEditable(false);
    	calculatedcost.setEditable(false);
        jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(54, 73, 624, 650));
        selectBikeCategoryLabel.setText("  Select Bike Category");
        selectBikeCategoryLabel.setBounds(new Rectangle(340, 131, 185, 25));
        selectBikeCategoryCombo.setBounds(new Rectangle(346, 160, 137, 23));
        selectBikeNameCombo.setBounds(new Rectangle(537, 160, 137, 23));
        selectBikeNameLabel.setText(" Select Bike Name");
        selectBikeNameLabel.setBounds(new Rectangle(534, 132, 185, 25));
        modelTF.setEditable(false);
        modelTF.setBounds(new Rectangle(708, 159, 98, 24));
        model.setText("Model");
        model.setBounds(new Rectangle(707, 125, 164, 30));
        availabilityTF.setEditable(false);
        availabilityTF.setBounds(new Rectangle(709, 252, 98, 24));
        selectBikeColorCombo.setBounds(new Rectangle(538, 252, 137, 23));
        color.setText("Color");
        color.setBounds(new Rectangle(538, 226, 130, 18));
        Availability.setText("Availability");
        Availability.setBounds(new Rectangle(705, 225, 131, 21));
        cost1.setText("Cost Of Bike");
        cost1.setBounds(new Rectangle(535, 303, 126, 21));
        rs1.setText("Rs");
        rs1.setBounds(new Rectangle(535, 337, 34, 22));
        costprice.setBounds(new Rectangle(563, 336, 104, 23));
        discount.setText("Discount  (Offer)");
        discount.setBounds(new Rectangle(705, 303, 93, 21));
        rs2.setText("Rs");
        rs2.setBounds(new Rectangle(702, 336, 52, 19));
        discountprice.setBounds(new Rectangle(730, 336, 104, 23));
        cost.setText("Cost After Discount");
        cost.setBounds(new Rectangle(595, 407, 119, 29));
        rs.setText("Rs");
        rs.setBounds(new Rectangle(597, 448, 38, 22));
        calculatedcost.setBounds(new Rectangle(636, 447, 107, 25));
        calculateBill.setText("Calculate Bill");calculateBill.setToolTipText("TO calculate the Cost after Discount");
        calculateBill.setBounds(new Rectangle(342, 373, 148, 49));calculateBill.setMnemonic('C');
        print.setLabel("Billing");print.setText("For Billing Click here");
        print.setBounds(new Rectangle(343, 458, 143, 50));print.setMnemonic('B');
        logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
    	com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
    	jPanel1.add(com,null);
    	jPanel1.add(logo,null);
        jPanel1.add(selectBikeCategoryLabel, null);
        jPanel1.add(selectBikeCategoryCombo, null);
        jPanel1.add(selectBikeNameCombo, null);
        jPanel1.add(selectBikeNameLabel, null);
        jPanel1.add(modelTF, null);
        jPanel1.add(model, null);
        jPanel1.add(availabilityTF, null);
        jPanel1.add(selectBikeColorCombo, null);
        jPanel1.add(color, null);
        jPanel1.add(Availability, null);
        jPanel1.add(cost1, null);
        jPanel1.add(rs1, null);
        jPanel1.add(costprice, null);
        jPanel1.add(discount, null);
        jPanel1.add(rs2, null);
        jPanel1.add(discountprice, null);
        jPanel1.add(cost, null);
        jPanel1.add(rs, null);
        jPanel1.add(calculatedcost, null);
        jPanel1.add(calculateBill, null);
        jPanel1.add(print, null);        
        exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Go Back");
    	logOutMenuItem.setText("Back");
    	logOutMenuItem.setMnemonic('B');
    	logOutMenuItem.setToolTipText("TO GO Back");
    	logOutMenuItem1.setText("Back");
    	exitMenu.add(logOutMenuItem);
    	bar.add(exitMenu);
    	logOutMenuItem.addActionListener(this);
    	logOutMenuItem1.addActionListener(this);
    	bill.addActionListener(this);
    	pnt.addActionListener(this);
    	popMenu.add(bill);
    	popMenu.add(pnt);
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
    	selectBikeCategoryCombo.addItemListener(this);
    	selectBikeNameCombo.addItemListener(this);
    	selectBikeColorCombo.addItemListener(this);
    	calculateBill.addActionListener(this);
    	print.addActionListener(this);  
      	}
    catch (Exception e) { e.printStackTrace(); }
    this.show();
    }
  public class WindowCloser extends WindowAdapter
 		{
 		public void windowClosing(WindowEvent e)
 			{
 			Window w = e.getWindow();
 			w.setVisible(false);
 			w.dispose();
 			sa.envoke();
 			}
 		}
  public void doIt()
  	{
		calculatedcost.setText("");
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
			calculatedcost.setText("");
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
			calculatedcost.setText("");
			stmt=con.createStatement();
			rset2=stmt.executeQuery("select bikemodel, availability, discount, cost from bikeavailabilitytable " 
					+ "where  bikename = '" +selectBikeNameCombo.getSelectedItem()+ "' and  color = '" +
					selectBikeColorCombo.getSelectedItem()+"'");
			while(rset2.next())
				{
				modelTF.setText(rset2.getString("bikemodel"));
				availabilityTF.setText(rset2.getString("availability"));
				costprice.setText(rset2.getString("cost"));
				discountprice.setText(rset2.getString("discount"));
				}
			}
		catch (SQLException sqle)
			{
			System.err.println(sqle.getMessage());
			} 	  
	}
   public void actionPerformed(ActionEvent ae)
 		{
	    if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
	    	{
	    	this.dispose();
			sa.envoke();
	    	}
        else if(ae.getSource()==calculateBill || ae.getSource()==bill)
 			{
 			if(costprice.getText().equals("") || discountprice.getText().equals(""))
 				JOptionPane.showMessageDialog(null,"Select the Bike Category Combo to get data!");
 			calculatedcost.setText(""+(Double.parseDouble(costprice.getText())-Double.parseDouble(discountprice.getText())));
 			}
 		else if(ae.getSource()==print || ae.getSource()==pnt)
 			{
			int flag=0;
			if(costprice.getText().equals("") || discountprice.getText().equals(""))
				{
				flag=1;
 				JOptionPane.showMessageDialog(null,"Select the Bike Category Combo to get data!");
				}
			if(calculatedcost.getText().equals(""))
				{
				flag=1;
				JOptionPane.showMessageDialog(null,"Calculate the CostPrice of Bike first before printing the bill");
				}
			try
				{
				if(Integer.parseInt(availabilityTF.getText())==0)
					{
					JOptionPane.showMessageDialog(null,"Bike Out Of Stock");
					flag=1;
					}
				if(flag==0)
					{
					stmt.executeUpdate("update bikeavailabilitytable set availability = availability - 1 "+
							"where  bikename = '" +selectBikeNameCombo.getSelectedItem()+ "' and  color = '" +
							selectBikeColorCombo.getSelectedItem()+"' and bikemodel = " +
							modelTF.getText()+"" );
					bkn=selectBikeNameCombo.getSelectedItem().toString();
					//JOptionPane.showMessageDialog(null,"Saved Successfully!");
					}
				}
			catch(SQLException sqle)
				{
				System.err.println(sqle.getMessage());
				}
			if(flag==0)
				{
				this.hide();
				CustomerDetails c=new CustomerDetails(em,selectBikeNameCombo.getSelectedItem().toString(),1);//type is 1
				c.amountTF.setText(calculatedcost.getText());
				c.amountTF.setEditable(false);
				}
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
}


