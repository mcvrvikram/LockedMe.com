package com.flow;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ops.FileOperations;

public class Menu {
	
	private static File dir;
	private static FileOperations fileOperations;
	private static Scanner sc = new Scanner(System.in);
	private static String path;
	public static void mainMenu() {
		String option;
		String isContinue="0";
		while(true) {
			
			System.out.println("Please enter the file Location :");
			path = sc.nextLine();
			dir = new File(path);
			
			if (dir.isDirectory())
				break;
			else 
				System.out.println("Invalid File Location");
		}
		
		FileFilter fileFilter = new FileFilter()
        {
          @Override
          public boolean accept(File file) {
            return !file.isDirectory();
          }
        };
        
        
		List<File> files = new ArrayList<>();
		
		for(File each:dir.listFiles(fileFilter)){
			files.add(each);
			
		}
		
		fileOperations = new FileOperations(files);
		System.out.println("List of files within the current dirrectory ");
		fileOperations.display();
	
		do {
			System.out.println("1. Sort Files in Ascending order w.r.t File Names");
			System.out.println("2. File Operations(Add/Search/Delete)");
			System.out.println("3. Close Application");
			System.out.println("Enter your option  : ");
			//System.out.println("Enter your option : ");
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
					System.out.println("-------------Thank you!-----------------");
					System.exit(0);
					
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
