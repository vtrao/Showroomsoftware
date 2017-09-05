
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class ReportGenerator extends JFrame implements ActionListener 
	{
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Employee emp;
	JTable table;
	JScrollPane scrollPane;
	JPanel jPanel1=new JPanel();
	JButton printButton=new JButton("Print");
	JMenuBar bar;
	JMenu exitMenu=new JMenu("   		Menu   ");
	JMenuItem logOutMenuItem=new JMenuItem("Back");
	JMenuItem logOutMenuItem1=new JMenuItem("Back");
	JMenuItem refresh=new JMenuItem("Refresh");
	JMenuItem printMenuItem=new JMenuItem("Print");
	JMenuItem printMenuItem1=new JMenuItem("Print");
	JPopupMenu popMenu=new JPopupMenu();
	Connection con;
	Statement stmt;
	ResultSet rset;int i=0,j=0;
	String [][]dataToDisplay;
	String title1;
	String []coln;
	int ncols;
	JLabel title = new JLabel();
	public ReportGenerator(String tit,Employee em,String query,int coloumns,String []a)
		{
		title1=tit;
		ncols=coloumns;
		coln=a;
		title.setText(tit);
		int d=0;
		emp=em;
		bar=new JMenuBar();
	  	this.setJMenuBar(bar);
		this.setSize(screenSize);
	    this.setResizable(false);
	  	this.setTitle("Lakshmi Motors--UserLevel--->Manager and User-->"+em.name);
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
			stmt=con.createStatement();
			rset=stmt.executeQuery(query);			
			while(rset.next())
				d=rset.getRow();
			}
		catch (SQLException sqle)
			{
		System.err.println(sqle.getMessage());
			}
	  	exitMenu.setMnemonic('M'); exitMenu.setToolTipText("Gives Option To Go Back or Print");
		logOutMenuItem.setText("Back");
		logOutMenuItem.setMnemonic('B');
		logOutMenuItem.setToolTipText("TO GO Back");
		printMenuItem.setMnemonic('r');
		printMenuItem.setToolTipText("To Print this Report");
		logOutMenuItem1.setText("Back");
		exitMenu.add(printMenuItem);
		exitMenu.addSeparator();
		exitMenu.add(logOutMenuItem);
		bar.add(exitMenu);
		logOutMenuItem.addActionListener(this);
		logOutMenuItem1.addActionListener(this);
		printMenuItem.addActionListener(this);
		printMenuItem1.addActionListener(this);	
		popMenu.add(printMenuItem1);
		popMenu.addSeparator();
		popMenu.add(refresh);
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
		dataToDisplay=new String[d][coloumns];
		try
			{
			stmt=con.createStatement();
			rset=stmt.executeQuery(query);
			for(;rset.next();i++)
				{
				for(j=0;j<coloumns;j++)
					{
					dataToDisplay[i][j]=rset.getString(j+1);
					}
				}
			}
		catch (SQLException sqle)
			{
			System.err.println(sqle.getMessage());
			}	
		printButton.setMnemonic('P');
		printButton.setToolTipText("To Print this Report");
		//exitButton.setBounds();
		printButton.addActionListener(this);
	    //title.setBounds(10,10,100,700);
		jPanel1.setLayout(new BorderLayout());
		//scrollPane.setBounds(10,150,400,700);
	    table=new JTable(dataToDisplay,a);
	    scrollPane=new JScrollPane(table);
	    table.addMouseListener( new MouseAdapter() {
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
	    scrollPane.addMouseListener( new MouseAdapter() {
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
	    JLabel lab=new JLabel(" venki  ");
	    lab.setSize(100,100);
	    title.setFont(new Font("Dialog", 0, 35));
	    jPanel1.add(title,BorderLayout.NORTH);
	    jPanel1.add(scrollPane,BorderLayout.CENTER);
	    jPanel1.add(printButton,BorderLayout.SOUTH);
	    this.getContentPane().add(jPanel1);;
	    this.show();
	    this.addWindowListener(new WindowCloser());
	    }
	public void actionPerformed(ActionEvent ae)
	  	{
		if(ae.getSource()==printMenuItem || ae.getSource()==printMenuItem1 ||ae.getSource() == printButton)
			{
			String display=new String();
			display="\n\n"+title1+"\n\n";
			for(int r=0;r<ncols;r++)
				{
				display+="                ";
				display+=coln[r];
				}
			display+="\n";
			for(int i1=0;i1<i;i1++)
				{
				display+="\n                ";
				for(int j1=0;j1<j;j1++)
					{
					display+=dataToDisplay[i1][j1];
					display+="                ";
					}
				}
			new print("\n\n   Date :"+LoginWindow.retDate()+"\n\n   Time :"+LoginWindow.retTime()+"\n\n"+display+"\n\n\n"+LoginWindow.branchdet);
			//JOptionPane.showMessageDialog(null,"\n\n   Date :"+LoginWindow.retDate()+"\n\n   Time :"+LoginWindow.retTime()+"\n\n"+display+"\n\n\n"+LoginWindow.branchdet);
			}
		else if(ae.getSource()==logOutMenuItem || /*ae.getSource()==exitButton ||*/ ae.getSource()==logOutMenuItem1)
			{
	 		this.dispose();
	 		new Manager(emp);
			}
	  	}
	public class WindowCloser extends WindowAdapter
	 	{
	 	public void windowClosing(WindowEvent e)
	 		{
	 		Window w = e.getWindow();
	 		w.setVisible(false);
	 		w.dispose();
	 		new Manager(emp);
	 		}
	 	}
	public static void main(String[] args) 
		{String[] a={"venki","pinky","ponky"};
		new ReportGenerator("hihihih",new Employee(),"select eid , salary , name from employeetable",3,a);
		}
	}
