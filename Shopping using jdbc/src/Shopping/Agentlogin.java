package Shopping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Agentlogin {
ConnectionManage con = new ConnectionManage();
		Scanner s = new Scanner(System.in);
	
		public void logdetails1() throws ClassNotFoundException, SQLException {
			System.out.println("Enter the UserName");
		    String username = s.next();
			System.out.println("Enter the Password");
			String password = s.next();
			Statement s11= (Statement) con.getConnection().createStatement();
			ResultSet rr=s11.executeQuery("select * from adminlogin");
			while(rr.next())
			{
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2))) {
				
				System.out.println("Sucessfully Verified");
				   Agentlogin agent= new Agentlogin();
				agent.agentData();
			}
		}
			Shopping a = new Shopping();
			a.choice();	
		}
		
	     void agentData()throws ClassNotFoundException, SQLException  {
		   System.out.println("Enter the Choice:\n1.BuySell\n2.View product\n3.Logout");
		     int p=s.nextInt();
		     switch(p)
				 {
			case 1:
		    System.out.println("Enter the product ID");
			int id5=s.nextInt();
			System.out.println("Enter the quantity");
			int q1=s.nextInt();
		    Statement s14=(Statement) con.getConnection().createStatement();
		    ResultSet r1=s14.executeQuery("select * from addproduct");
		    int price=0;
			while(r1.next())
			{
			if(id5==r1.getInt(1))
			{
			  price=r1.getInt(4);
				}
				}
			  float amount=price*q1;
		    System.out.println("The cost is ->"+amount);
						
			break;
		    case 2:
			Statement s1=(Statement) con.getConnection().createStatement();
			ResultSet r=s1.executeQuery("select * from addproduct");
			System.out.println("List of Products");
		    while(r.next())
			{
							
		    System.out.println("######*****######");
		    System.out.println("Product Id ->"+r.getInt(1)+"\n"+"Product Name->"+r.getString(2)+"\n"+"Quantity ->"+r.getInt(3)+"\n"+"Price->"+r.getInt(4));
			System.out.println("######*****######");
			}
			 break;
		    case 3:
		    case 5:
				System.out.println("Agent Account Logout");
				return;
				 }
		     Agentlogin agent= new Agentlogin();
				agent.agentData();
		 
		}
		}
	

	


			

		
		
		
	