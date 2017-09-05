
import java.awt.*;
import javax.swing.*;

import java.awt.event.* ;

import javax.swing.JFrame;
import java.sql.*;
public class ChangePasswordFrame extends JFrame implements ActionListener
  {
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  Employee em;
  ResultSet rs, rs1;
  Connection con;
  Statement stmt;
  String username;
  String password;
  JLabel jLabel1 = new JLabel();
  JTextField jTextField1 = new JTextField();
  JLabel jLabel2 = new JLabel();
  JLabel jLabel3 = new JLabel();
  JLabel jLabel4 = new JLabel();
  JPasswordField jPasswordField1 = new JPasswordField();
  JPasswordField jPasswordField2 = new JPasswordField();
  JPasswordField jPasswordField3 = new JPasswordField();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JLabel logo=LoginWindow.jLabel6;
  JLabel com=LoginWindow.jLabel5;
  JMenuBar bar;
  JMenu exitMenu=new JMenu("         Exit        ");
  JMenuItem logOutMenuItem=new JMenuItem("Back");
  JMenuItem logOutMenuItem1=new JMenuItem("Back");
  JMenuItem refresh=new JMenuItem("Refresh");
  JPopupMenu popMenu=new JPopupMenu();
  
  public ChangePasswordFrame(Employee emp)
    {
	em=emp;
	jTextField1.setEditable(false);
    jTextField1.setText(em.userName);
    try  
		{
    	bar=new JMenuBar();
     	this.setJMenuBar(bar);
        rs=null;
        con=null;
        stmt=null;
        rs1=null;
        this.setSize(screenSize);
        this.setResizable(true);
        this.setTitle("Lakshmi Motors ShowRoom Maintainence Software-->" +
        		"Password Changing Utility-->User-->"+emp.name+"");
        this.getContentPane().setLayout(null);
        jLabel1.setText("UserName");
        jLabel1.setBounds(new Rectangle(378, 237, 88, 20));
        jTextField1.setBounds(new Rectangle(510, 231, 149, 24));
        jLabel2.setText("Old Password");
        jLabel2.setBounds(new Rectangle(374, 265, 120, 31));
        jLabel3.setText("New Password");
        jLabel3.setBounds(new Rectangle(374, 299, 117, 27));
        jLabel4.setText("Confirm Password");
        jLabel4.setBounds(new Rectangle(374, 328, 132, 32));
        jPasswordField1.setBounds(new Rectangle(509, 266, 129, 26));
        jPasswordField2.setBounds(new Rectangle(509, 303, 131, 24));
        jPasswordField3.setBounds(new Rectangle(510, 337, 134, 26));
        jButton1.setText("Ok");jButton1.setToolTipText("Click Here to Change Password");
        jButton1.setBounds(new Rectangle(346, 383, 96, 37));jButton1.setMnemonic('O');
        jButton1.addActionListener(this);
        jButton2.setText("Reset");jButton2.setToolTipText("Click Here to Reset");
        jButton2.setBounds(new Rectangle(489, 382, 91, 38));jButton2.setMnemonic('R');
        jButton2.addActionListener(this);
        jButton3.setText("Exit");jButton3.setToolTipText("Click Here to GO Back");
        jButton3.setBounds(new Rectangle(613, 383, 92, 37));jButton3.setMnemonic('E');
        jButton3.addActionListener(this);
        logo.setBounds(100,150,LoginWindow.jLabel6.getWidth(),LoginWindow.jLabel6.getHeight());
		com.setBounds(100,100,LoginWindow.jLabel5.getWidth(),LoginWindow.jLabel5.getHeight());
		this.getContentPane().add(com,null);
		this.getContentPane().add(logo,null);
        this.getContentPane().add(jLabel1, null);
        this.getContentPane().add(jTextField1, null);
        this.getContentPane().add(jLabel2, null);
        this.getContentPane().add(jLabel3, null);
        this.getContentPane().add(jLabel4, null);
        this.getContentPane().add(jPasswordField1, null);
        this.getContentPane().add(jPasswordField2, null);
        this.getContentPane().add(jPasswordField3, null);
        this.getContentPane().add(jButton1, null);
        this.getContentPane().add(jButton2, null);
        this.getContentPane().add(jButton3, null);
        exitMenu.setMnemonic('X'); exitMenu.setToolTipText("Gives Option To Go Back");
    	logOutMenuItem.setText("Back");
    	logOutMenuItem.setMnemonic('B');
    	logOutMenuItem.setToolTipText("TO GO Back");
    	logOutMenuItem1.setText("Back");
    	exitMenu.add(logOutMenuItem);
    	bar.add(exitMenu);
    	logOutMenuItem.addActionListener(this);
    	logOutMenuItem1.addActionListener(this);
    	refresh.addActionListener(this);
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
//     Center the window
         this.setVisible(true);
         this.addWindowListener(new WindowCloser());
         jTextField1.requestFocus();        
        }
    catch (Exception e) 
	{
         e.printStackTrace();
        }
    }


  public void actionPerformed(ActionEvent ae)
	{
	  if(ae.getSource()==logOutMenuItem || ae.getSource()==logOutMenuItem1)
	  	{
		this.dispose();
		callb4exit();
	  	}
	  else
	  {
		try
			{
			// Load the Driver class file
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			// Make a connection to the ODBC datasource xoffice
			con = DriverManager.getConnection( "jdbc:odbc:bss");//, "scott", "tiger");

			// Create the statement
			 stmt = con.createStatement();

			// Use the created statement to CREATE the database table
			// Create Title Table
			rs=stmt.executeQuery("SELECT username,password FROM user");
			if(ae.getActionCommand().equals("Ok"))
				{
					username = jTextField1.getText();
					password = jPasswordField1.getText();
					while(rs.next())
						{
						if(username.equals(rs.getString("username")))
							{
							if(password.equals(rs.getString("password")))
								{
								if(test(jPasswordField2.getText()) && test(jPasswordField3.getText()))
									{
									if(jPasswordField2.getText().equals(jPasswordField3.getText()))
										{
										String d=jPasswordField2.getText();
										jPasswordField1.setText("");
										jPasswordField2.setText("");
										jPasswordField3.setText("");
										stmt.executeUpdate("update user set password = '"+
												d+"' where ( username = '" + username +
												"' and password =  '" + password + "' )");
										JOptionPane.showMessageDialog(null,"Password changed","",JOptionPane.INFORMATION_MESSAGE);
										this.dispose();
										callb4exit();
										}
									else
										{
										jPasswordField2.setText("");
										jPasswordField3.setText("");
										JOptionPane.showMessageDialog(null,"Password Mismatch");
										jPasswordField2.requestFocus();
										}
									}
								else
									{
									JOptionPane.showMessageDialog(null,"Password Should be Atleast 6 characters");
									jPasswordField2.setText("");
									jPasswordField3.setText("");
									}
								}
							else
								{
								JOptionPane.showMessageDialog(null,"ENTER CORRECT PASSWORD ");
								jPasswordField1.setText("");
								}
			                }
                       	}
 
	            }
		else if(ae.getActionCommand().equals("Exit"))
				{
			     this.dispose();
			     callb4exit();
			    }
		else if(ae.getActionCommand().equals("Reset") || ae.getSource().equals(refresh))
				{
			         jPasswordField1.setText("");
			         jPasswordField2.setText("");
			         jPasswordField3.setText("");
			         jTextField1.requestFocus();
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
		catch (Exception e) 
			{
			System.err.println(e.getMessage());
			}
		finally
    			{
    			try
      				{
				      if ( con != null )
				        {
					// Close the connection no matter what
					con.close();
					}
				}
			catch (SQLException sqle)
      				{
			         System.err.println(sqle.getMessage());
     				}
			}
	  }
	}
public boolean test(String str)
	{ 
	int l;
	l=str.length();
	if(l<6)
		return(false);
	else
		return(true);	
	}
public void callb4exit()
	{
	if(em.userAuthentication==1)
		{
		new SaleOrService(em);
		}
	else if(em.userAuthentication==2)
		{
		new Manager(em); 
		}
	else if(em.userAuthentication==3)
		{
		new ViewModels(em);
		}
	else if(em.userAuthentication==4)
		{
		new Supervisor(em);	
		}
	}
	public class WindowCloser extends WindowAdapter 
		{
		public void windowClosing(WindowEvent e) 
			{
			Window w = e.getWindow();
			w.setVisible(false);
			w.dispose();
			callb4exit();
			}
		}
}