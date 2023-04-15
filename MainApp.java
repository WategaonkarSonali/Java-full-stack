

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int ch;
		Scanner sc=new Scanner(System.in);
		System.out.println("_______________*****Student Management System***************____________");
		
		while(true) {
			System.out.println("What operation you want to do?");
			System.out.println("1.Show Student records");
			System.out.println("2.Add Student Records");
			System.out.println("3.Update Student Records");
			System.out.println("4.Delete Student Records");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch){
			case 1: DatabaseOPerations.displayRecord();
			break;
			case 2:DatabaseOPerations.insertion();
			break;
			case 3:DatabaseOPerations.UpdateRecord();
			break;
			case 4:DatabaseOPerations.deletion();
			break;
			}
			System.out.println("Do you want to continue n to stop any other key to continue");
		   char choice=sc.next().charAt(0);
		   if(ch=='n') {
			   break;
		   }
		}
		}}
	
