package com.flow;

import java.io.File;
import java.util.Scanner;

import com.ops.FileOperations;

public class Menu {
	
	private static File dir;
	private static FileOperations fileOperations;
	private static Scanner sc = new Scanner(System.in);
	private static String path="/home/vikramcvrgmail/test/";
	public static void mainMenu() {
		String option;
		String InputPath;
		String isContinue="0";
		while(true) {
			System.out.println("Present working directory : "+path);
			System.out.println("Press 1 to continue ");
			System.out.println("Press any other key to go to a different directory");
			System.out.println("Press 0 to exit");
			String op=sc.nextLine();
			if(op.equals("1"))
				break;
			else if(op.equals("0"))
				return;
			System.out.println("Please enter the file Location :");
			InputPath = sc.nextLine();
			dir = new File(InputPath);
			
			if (dir.isDirectory()) {
				path=InputPath;
				break;
			}
				
			else 
				System.out.println("Invalid File Location");
		}
			
		
		
		fileOperations = new FileOperations();
		fileOperations.setPath(path);
		
		System.out.println("List of files within the current dirrectory ");
		fileOperations.display();
	
		do {
			System.out.println("1. Sort Files in Ascending order w.r.t File Names");
			System.out.println("2. File Operations(Add/Search/Delete)");
			System.out.println("3. Close Application");
			System.out.println("Enter your option  : ");
			
			option = sc.nextLine();
			switch (option) {
			
			case "1": 
					fileOperations.sorting();
					fileOperations.display();
					break;
					
			case "2": 
					Menu.subMenu();
					break;
					
			case "3":
					return;
					
			default : 
					System.out.println("Invalid Input");
					
			}
			
			while(true) {
				if (option.equals("2")) {
					isContinue="1";
					break;
				}
				System.out.println("Press 1 to continue" );
				System.out.println("Press 0 to Exit" );
				isContinue = sc.nextLine();
				if(isContinue.equals("1")||isContinue.equals("0"))
					break;
				System.out.println("Invalid Option");
			}
			
		}while(isContinue.equals("1"));
		
	}
	
	public static void subMenu() {
		String option;
		String isContinue="1";
		
		do {
			System.out.println("1. Add New File");
			System.out.println("2. Search File");
			System.out.println("3. Delete File");
			System.out.println("4. Go to Main Menu");
			System.out.println("Enter your choice : ");
			option = sc.nextLine();
			switch(option) {
			case "1":
					System.out.println("Enter the name of the file you want to add : ");
					fileOperations.add(path+sc.nextLine());
					fileOperations.sorting();
					break;
			case "2":
					System.out.println("Enter the name of the file you want to search : ");
					fileOperations.Search(sc.nextLine());
					break;
			case "3":
					System.out.println("Enter the name of the file you want to delete : ");
					fileOperations.delete(sc.nextLine());
					break;
					
			case "4":
					break;
			default:
					System.out.println("Invalid input");
					
			}
			
			
			
			while(true) {
				if(option.equals("4")) {
					isContinue="0";
					break;
				}
				 
				System.out.println("Press 1 to continue" );
				System.out.println("Press 0 to go back to Main Menu" );
				isContinue = sc.nextLine();
				if(isContinue.equals("1")||isContinue.equals("0"))
					break;
				System.out.println("Invalid Option");
			}
			
		}while(isContinue.equals("1"));
	}
}
