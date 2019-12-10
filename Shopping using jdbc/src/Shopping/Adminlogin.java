package Shopping;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Adminlogin {
	ConnectionManage con = new ConnectionManage();
Scanner s = new Scanner(System.in);
	public void logdetails() throws ClassNotFoundException, SQLException {
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
			   Adminlogin admin= new Adminlogin();
			admin.adminData();
		}
	}
		Shopping a = new Shopping();
		a.choice();	
	}
	
		
		
	void adminData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("1.Add product\n2.Display Product\n3.Remove Product\n4.Update Product\n5.LogOut");
		System.out.println("Enter the Choice");
		int m = s.nextInt();
		switch(m) {
		case 1:
		     System.out.println("Enter the ProductId:");	
		     int id =s. nextInt();
		     System.out.println("Enter the ProductName:");	
		     String name =s.next();
		     System.out.println("Enter the Minsellquantity:");	
		     int min =s. nextInt();
		     System.out.println("Enter the Price");
		     int price = s.nextInt();
		     PreparedStatement st = (PreparedStatement) con.getConnection().prepareStatement("insert into addproduct(productid,productname,minsellquatity,price)values(?,?,?,?);");
		     st.setInt(1,id);
		     st.setString(2, name);
		     st.setInt(3, min);
		     st.setInt(4, price);
		     st.executeUpdate();
		     System.out.println("Product added successfully");
		    
		     break;
		case 2:
			Statement s1= (Statement) con.getConnection().createStatement();
			ResultSet r=s1.executeQuery("select * from addproduct");
			
			while(r.next())
			{
				System.out.println("######*****######");
				System.out.println("Product Id ->"+r.getInt(1)+"\n"+"Product Name->"+r.getString(2)+"\n"+"Quantity ->"+r.getInt(3)+"\n"+"Price->"+r.getInt(4));
				System.out.println("######*****######");
			}
			break;
			
		
		case 3:
			
			
			System.out.println("\nEnter the ProductId");
			int id1=s.nextInt();
			PreparedStatement stt =con.getConnection().prepareStatement("delete from addproduct where productid=?");
			stt.setInt(id1,1);
			stt.executeUpdate();
			System.out.println("Remove Sucessfully");
             break;
			
		case 4:
			Statement s2= (Statement) con.getConnection().createStatement();
			ResultSet r2=s2.executeQuery("select * from addproduct");
			
			while(r2.next())
			{
				System.out.println("######*****######");
				System.out.println("Product Id ->"+r2.getInt(1)+"\n"+"Product Name->"+r2.getString(2));
				System.out.println("######*****######");
			}
			int qua =0;
			System.out.println("Enter the ID");
			int id2 = s.nextInt();
			System.out.println("Enter the Add Quantity");
			int quantity = s.nextInt();
			Statement s3= (Statement) con.getConnection().createStatement();
			ResultSet r3=s3.executeQuery("select * from addproduct");
			
			
			while(r3.next())
			{
				int idd = r3.getInt(1);
				if(idd==id2) {
					int q=r3.getInt(3);
					qua = q+quantity;
				}
				
			}
			
			
			PreparedStatement st1 =(PreparedStatement)con.getConnection().prepareStatement("update addproduct set minsellquatity=? where productid=?");
			st1.setInt(1,qua);
			st1.setInt(2, id2);
			st1.executeUpdate();
			System.out.println("Quantity Update Successful");
			break;
		case 5:
			System.out.println("Admin Accout Logout");
			return;
		
		}
		   Adminlogin admin= new Adminlogin();
					admin.adminData();
		
		}
		

	}

	

	
		
		
		
		
	
		
			
			
			
			
			
			
			
			
			
			
			
			
			
		
			
			
			
		
			
			
			
			
			
			
			
			
			
			
		
		
		
		
	
