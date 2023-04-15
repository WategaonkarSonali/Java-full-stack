

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DatabaseOPerations {
	static Connection conn;
	
	
	public static void displayRecord() throws Exception {
		
		
		conn=DatabaseConnection.getConnection();
		//create a statement object
				Statement stmt=conn.createStatement();
				
				
	
	
				String s="select * from student3";
				ResultSet rs=stmt.executeQuery(s);
				
				
				
				
				System.out.println("Show record of student");
				System.out.println("SID\tSNAME");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
					//System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")+"\t"+rs.getInt("smark"));
				}
						
	}
	
	
	public static void insertion() throws Exception{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String un="root";
		String up="root";
		
		//sid | sname | email               | sphn      | sdob       | smark  | sbranch| s_age
		int sid,s_age ;
		String sname, email,sphn,sdob,sbranch;
		int  smark; 
		//load driver
		PreparedStatement pst;
		Class.forName(driver);
		//make the connection
		Connection conn=DriverManager.getConnection(url, un, up);
		//create a statement object
		//Statement stmt=conn.createStatement();
		
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("Insertion of Student Record");
		System.out.println("Enter student id to insert");
		sid=sc.nextInt();
		//String sel="select * from student where sid="+sid;
		String sel="select * from student3 where sid=?";
		pst=conn.prepareStatement(sel);
		pst.setInt(1,sid);
		ResultSet rs=pst.executeQuery();
		if(!rs.next()) {
			System.out.println("Enter name of a student");
			sname=sc.next();
			System.out.println("Enter student email");
			email=sc.next();
			
			System.out.println("Enter student  phone");
			sphn=sc.next();
			System.out.println("Enter student dob(dd-mm-yyyy");
			sdob=sc.next();
			System.out.println("Enter student marks");
			smark=sc.nextInt();
			
			System.out.println("Enter student sbranchname");
			sbranch=sc.next();
			System.out.println("Enter student age");
		s_age=sc.nextInt();
			
	//String ins="insert into student2 values("+sid+",'"+sname+"','"+email+"','"+sphn+"','"+sdob+"',"+smark+",'"+sbranch+"',"+s_age+")";
			
			String ins="insert into student3 values(?,?,?,?,?,?,?,?)";
			
			System.out.println(ins);
			pst=conn.prepareStatement(ins);
			pst.setInt(1,sid);
			pst.setString(2,sname);
			pst.setString(3,email);
			pst.setString(4,sphn);
			pst.setString(5,sdob);
			pst.setInt(6,smark);
			pst.setString(7,sbranch);
			pst.setInt(8,s_age);
	int i=pst.executeUpdate();
			if(i>0) {
				System.out.println("Student added successfully");
			}
			
		}else {
			System.out.println(sid+" already exists");
		}
		
		
		
		
		
		}
		
	
	public static void UpdateRecord()throws Exception{
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String un="root";
		String up="root";
		
		//sid | sname | email               | sphn      | sdob       | smark  | sbranch | s_age
		int sid,s_age ;
		String sname, email,sphn,sdob,sbranch;
		String upd;
		int i;
		int smark; 
		//load driver
		
		Class.forName(driver);
		//make the connection
		Connection conn=DriverManager.getConnection(url, un, up);
		//create a statement object
		Statement stmt=conn.createStatement();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter student id to insert");
		sid=sc.nextInt();
		String sel="select * from student3 where sid="+sid;
		
		ResultSet rs=stmt.executeQuery(sel);
		//ResultSet rs=stmt.executeQuery(sel);
		if(rs.next()) {  //if employee id exists then go for update
			//switch case
			while(true) {
			System.out.println("Which field he wants to update");
			System.out.println("1. update name");
			System.out.println("2. update Email");
			System.out.println("3. update phone");
			System.out.println("4. update marks");
			System.out.println("5.exit");
			
			int ch=sc.nextInt();
			switch(ch) {
			     //to change name
			case 1: System.out.println("Enter name to change");
			        String ssname=sc.next();
			      upd="update student3 set sname='"+ssname+"' where sid="+sid;
			       i=stmt.executeUpdate(upd);
			        if(i>0) {
			        	System.out.println("Name is changed successfulyy");
			        }
			        else {
			        	System.out.println("Error occured");
			        }
			        break;
			case 2://email id
				System.out.println("Enter email to change");
		        String ssmail=sc.next();
		          upd="update student3 set email='"+ssmail+"' where sid="+sid;
		        i=stmt.executeUpdate(upd);
		        if(i>0) {
		        	System.out.println("email is changed successfulyy");
		        }
		        else {
		        	System.out.println("Error occured");
		        }
		        break;
		        
			case 3://sphone
				System.out.println("Enter phone to change");
		        String ssphn=sc.next();
		          upd="update student3 set sphn='"+ssphn+"' where sid="+sid;
		        i=stmt.executeUpdate(upd);
		        if(i>0) {
		        	System.out.println("sphone is changed successfulyy");
		        }
		        else {
		        	System.out.println("Error occured");
		        }
		        break;
			case 4://smarks
				System.out.println("Enter marks to change");
		        String ssmark=sc.next();
		          upd="update student3 set smark='"+ssmark+"' where sid="+sid;
		        i=stmt.executeUpdate(upd);
		        if(i>0) {
		        	System.out.println("marks is changed successfulyy");
		        }
		        else {
		        	System.out.println("Error occured");
		        }
		        break;
			//default:System.out.println("Invalid input");
			//case 5: System.exit(0); //exit the program
		        
			}
			
			System.out.println("do you want to continue press n to exit any key to continue");
			char choice=sc.next().charAt(0);
			if(choice=='n') {
				break;
			}//if
			}//if
	        
		}}
				
				

	
	
	public static void deletion()throws Exception {
		// TODO Auto-generated method stub

		
		
		//load the driver
		//make the connection
		//create a statement object
		//exeute sql commands
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/studentdb";
		String un="root";
		String up="root";
		
		//sid | sname | email               | sphn      | sdob       | smark  | sbranch| s_age
		int sid,s_age ;
		String sname, email,sphn,sdob,sbranch;
		int  smark; 
		//load driver
		PreparedStatement pst;
		Class.forName(driver);
		//make the connection
		Connection conn=DriverManager.getConnection(url, un, up);
		//create a statement object
		//Statement stmt=conn.createStatement();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter student id to delete");
		sid=sc.nextInt();
		//String sel="select * from student where sid="+sid;
		
		String sql="select * from student3 where sid=?";
		
		pst=conn.prepareStatement(sql);
		
		pst.setInt(1,sid);
		ResultSet rs=pst.executeQuery();
	
		if(rs.next()) {
			//if record exists in the table go for delete
			String del="delete from student3 where sid=?";
			pst=conn.prepareStatement(del);
			
			pst.setInt(1,sid);
			int i=pst.executeUpdate();
			if(i>0) {
				System.out.println("student record is deleted");
			}
		}else {
			System.out.println(sid+"student with given id not exists");
		}
	}


	
}
