package Shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Shopping {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		ConnectionManage con = new ConnectionManage();
		Shopping a = new Shopping();
		a.choice();
	}
	
	public void choice() throws ClassNotFoundException, SQLException {
	Scanner s = new Scanner(System.in);
	
	System.out.println("1.Admin Login\n2.Agent Login\n3.Exit");
	System.out.println("Enter the Choice");
	 int n = s.nextInt();
	switch(n) {
	case 1:
		   Adminlogin admin= new Adminlogin();
		   admin.logdetails();
		   admin.adminData();
		   break;
	case 2:
		   Agentlogin agent= new Agentlogin();
		   agent.logdetails1();
		   agent.agentData();
		   break;
	case 3:
		 System.out.println("Process will be complete");
System.exit(0);	}
	

	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}