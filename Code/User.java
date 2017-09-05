
public class User 
	{
	String userName;
	int userAuthentication;
	String employeeId;
	public User()
		{
			
		}
	public User(String userName,int userAuthentication,
            String employeeId)
		{
		this.userName=new String(userName);
		this.userAuthentication=userAuthentication;
		this.employeeId=employeeId;
		//JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ"+
  	    //this.userName+this.userAuthentication+this.employeeId);
		}	
	}
