
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class AddViewFeatures extends JFrame implements ItemListener,ActionListener
{
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
JPanel jPanel1 = new JPanel();
JLabel selectBikeCategoryLabel = new JLabel();
JLabel selectBikeNameLabel = new JLabel();
JComboBox selectBikeCategoryCombo = new JComboBox();
JLabel model = new JLabel();
JComboBox selectBikeNameCombo = new JComboBox();
JTextField modelTF = new JTextField();
JLabel featuresLab = new JLabel();
JButton saveButton = new JButton();
JButton cancelButton = new JButton();
JButton exitButton = new JButton();
JLabel logo=LoginWindow.jLabel6;
JLabel com=LoginWindow.jLabel5;
JMenuBar bar;
JMenu exitMenu=new JMenu("         Exit        ");
JMenuItem logOutMenuItem=new JMenuItem("Back");
JMenuItem logOutMenuItem1=new JMenuItem("Back");
JPopupMenu popMenu=new JPopupMenu();
JMenuItem save=new JMenuItem("Save");
JMenuItem cancel=new JMenuItem("Cancel");
Employee em;
JLabel featureL1 = new JLabel();
JLabel featureL2 = new JLabel();
JLabel featureL3 = new JLabel();
JLabel featureL4 = new JLabel();
JLabel featureL5 = new JLabel();
JTextPane featureT1 = new JTextPane();
JTextPane featureT2 = new JTextPane();
JTextPane featureT3 = new JTextPane();
JTextPane featureT4 = new JTextPane();
JTextPane featureT5 = new JTextPane();
Connection con;
Statement stmt;
ResultSet rset,rset1,rset2;
public AddViewFeatures(Employee emp,int addOrView) // 1 for add and 2 for view
  {
  em=emp;
  this.setSize(screenSize);
  this.setResizable(false);
  this.setTitle("Lakshmi Motors--UserLevel--->Marketing Executive and User-->"+emp.name);
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
	  doIt();doIt1();
	
	  jPanel1.setLayout(null);
	  jPanel1.setBounds(new Rectangle(15, 14, 890, 800));
	  selectBikeCategoryLabel.setText("  Select Bike Category");
	  selectBikeCategoryLabel.setBounds(new Rectangle(373, 145, 146, 15));
	  selectBikeNameLabel.setText(" Select Bike Name");
	  selectBikeNameLabel.setBounds(new Rectangle(379, 222, 132, 15));
	  selectBikeCategoryCombo.setBounds(new Rectangle(381, 177, 124, 24));
	  model.setText("Model");
	  model.setBounds(new Rectangle(384, 299, 46, 15));
	  selectBikeNameCombo.setBounds(new Rectangle(381, 253, 124, 24));
	  modelTF.setBounds(new Rectangle(384, 327, 122, 25));
	  featuresLab.setBounds(new Rectangle(556, 141, 206, 18));
	  saveButton.setLabel("Save");
	  saveButton.setBounds(new Rectangle(402, 589, 95, 48));
	  cancelButton.setLabel("Cancel");
	  cancelButton.setBounds(new Rectangle(554, 590, 92, 46));
	  exitButton.setLabel("Exit");
	  exitButton.setBounds(new Rectangle(554, 590, 92, 46));
	  logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
	  com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
	  jPanel1.add(com,null);
	  jPanel1.add(logo,null);
    
      modelTF.setEditable(false);
      featureL1.setText("Feature 1");
      featureL1.setBounds(new Rectangle(536, 183, 65, 15));
      featureL2.setText("Feature 2");
      featureL2.setBounds(new Rectangle(536, 260, 65, 15));
      featureL3.setText("Feature 3");
      featureL3.setBounds(new Rectangle(536, 336, 65, 15));
      featureL4.setText("Feature 4");
      featureL4.setBounds(new Rectangle(536, 412, 65, 15));
      featureT1.setBounds(new Rectangle(540, 200, 450, 50));
      featureT2.setBounds(new Rectangle(540, 276, 450, 50));
      featureL5.setText("Feature 5");
      featureL5.setBounds(new Rectangle(536, 488, 65, 15));
      featureT3.setBounds(new Rectangle(540, 352, 450, 50));
      featureT4.setBounds(new Rectangle(540, 428, 450, 50));
      featureT5.setBounds(new Rectangle(540, 504, 450, 50));      

	  jPanel1.add(featureT1,null);
	  jPanel1.add(featureL1,null);
	  jPanel1.add(featureT2,null);
	  jPanel1.add(featureL2,null);
	  jPanel1.add(featureT3,null);
	  jPanel1.add(featureL3,null);
	  jPanel1.add(featureT4,null);
	  jPanel1.add(featureL4,null);
	  jPanel1.add(featureT5,null);
	  jPanel1.add(featureL5,null);
	  jPanel1.add(selectBikeNameLabel, null);
	  jPanel1.add(model, null);
	  jPanel1.add(selectBikeCategoryCombo, null);
	  jPanel1.add(selectBikeNameCombo, null);
	  jPanel1.add(selectBikeCategoryLabel, null);
	  jPanel1.add(modelTF, null);
	  jPanel1.add(featuresLab, null);
	  featuresLab.setText("Features are");
	  jPanel1.add(exitButton, null);
	  exitButton.addActionListener(this);
	  exitButton.setMnemonic('e');
      exitButton.setToolTipText("Click Here to Go back");
	  if(addOrView==1)
	  	{  
		save.addActionListener(this);
	  	cancel.addActionListener(this);
	  	popMenu.add(save);
	  	popMenu.add(cancel);
	  	popMenu.addSeparator();
	      saveButton.setToolTipText("Click this to Save or update the contents");
	      saveButton.setMnemonic('s');
	      cancelButton.setMnemonic('c');
	      cancelButton.setToolTipText("Click here to reset");
		exitButton.setBounds(new Rectangle(704, 589, 91, 47));
	  	jPanel1.add(saveButton, null);
	  	jPanel1.add(cancelButton, null);
	  	featuresLab.setText("Add Features Here");
	    this.setTitle("Lakshmi Motors--UserLevel--->Manager and User-->"+emp.name);
	    saveButton.addActionListener(this);
	    cancelButton.addActionListener(this);
  	  	}
	  else
	  	{
		featureT1.setEditable(false);
		featureT2.setEditable(false);
		featureT3.setEditable(false);
		featureT4.setEditable(false);
		featureT5.setEditable(false);
	  	}
      exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Go Back");
    	logOutMenuItem.setText("Back");
    	logOutMenuItem.setMnemonic('B');
    	logOutMenuItem.setToolTipText("TO GO Back");
    	logOutMenuItem1.setText("Back");
    	exitMenu.add(logOutMenuItem);
    	bar.add(exitMenu);
    	logOutMenuItem.addActionListener(this);
    	logOutMenuItem1.addActionListener(this);
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
  	  }
  catch (Exception e) 
  	  {
      e.printStackTrace();
  	  }
  selectBikeCategoryCombo.addItemListener(this);
  selectBikeNameCombo.addItemListener(this);
  this.show();
  this.addWindowListener(new WindowCloser(addOrView,emp));
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
	rset1=stmt.executeQuery("select distinct bikemodel from bikeavailabilitytable where bikename = '"
			+selectBikeNameCombo.getSelectedItem()+"'");
	modelTF.setText("");
	featureT1.setText("");
	featureT2.setText("");
	featureT3.setText("");
	featureT4.setText("");
	featureT5.setText("");
	while(rset1.next())
		{
		modelTF.setText(rset1.getString("bikemodel"));
		}
	rset2=stmt.executeQuery("select * from bikefeaturestable " 
			+ "where  bikename = '" +selectBikeNameCombo.getSelectedItem()+ "' and  bikemodel = " +
			modelTF.getText()+" ");
	while(rset2.next())
		{
		featureT1.setText(rset2.getString("feature1"));
		featureT2.setText(rset2.getString("feature2"));
		featureT3.setText(rset2.getString("feature3"));
		featureT4.setText(rset2.getString("feature4"));
		featureT5.setText(rset2.getString("feature5"));
		}
	}
catch (SQLException sqle)
	{
	System.err.println(sqle.getMessage());
	}	
	}
public void actionPerformed(ActionEvent ae)
	{
    if(ae.getSource()==saveButton || ae.getSource()==save)
		{
		try
			{
			stmt=con.createStatement();
			stmt.executeUpdate("insert into bikefeaturestable values ('"+
					selectBikeNameCombo.getSelectedItem()+"','"+ featureT1.getText()+
					"','"+modelTF.getText()+"','"+featureT2.getText()+"','"+featureT3.getText()+
					"','"+featureT4.getText()+"','"+featureT5.getText()+"')");
			JOptionPane.showMessageDialog(null,"Saved Successfully!");
			  doIt();doIt1();
			}
		catch(SQLException sqle)
			{
			System.err.println(sqle.getMessage());
			try
				{
				stmt.executeUpdate("update bikefeaturestable set  feature1 = '"+featureT1.getText()+
					 "', feature2 = '"+featureT2.getText()+"', feature3 = '"+featureT3.getText()+
					 "', feature4 = '"+featureT4.getText()+"', feature5 = '"+featureT5.getText()+"' where "
					 +" bikename = '"+selectBikeNameCombo.getSelectedItem()+"' and bikemodel = "+
					 modelTF.getText()+"");
				JOptionPane.showMessageDialog(null,"Updated Successfully!");
				  doIt();doIt1();
				}
			catch(SQLException sqle1)
				{
				System.err.println(sqle1.getMessage());
				}
			}
		}
	else if(ae.getSource()==cancelButton || ae.getSource()==cancel)
		{
	    doIt();
	    doIt1();
		}
	else if(ae.getSource()==exitButton || ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
		{
		this.dispose();
		if(em.userAuthentication==2)
			new Manager(em);
		else
			new ViewModels(em);		
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
	}
public class WindowCloser extends WindowAdapter
		{
		int status;
		Employee ee;
		public WindowCloser(int a,Employee em)
			{
			ee=em;
			status=a;
			}
		public void windowClosing(WindowEvent e)
			{
			Window w = e.getWindow();
			w.setVisible(false);
			w.dispose();
			if(status==1)
				new Manager(ee);
			else
				new ViewModels(ee);
			}
		}
public static void main(String srgs[])
	{
	new AddViewFeatures(new Employee(),2);
	}
}

   