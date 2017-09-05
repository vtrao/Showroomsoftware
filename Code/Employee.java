public class Employee extends User 
	{
	double salary;
	String name;
	public Employee()
		{
		userName=new String("Customer");
		name=new String("customer");	
		}
	public Employee(String userName,int userAuthentication,
            String employeeId,String name,double salary)
		{
		super(userName,userAuthentication,employeeId);
		this.name=name;
		this.salary=salary;
		//JOptionPane.showMessageDialog(null,"Have a Nice Time! \n\n\n     ThankQ"+
        //this.userName+this.userAuthentication+this.employeeId+this.name+this.salary);
		}
	}
