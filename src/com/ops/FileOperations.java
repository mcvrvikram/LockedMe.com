package com.ops;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileOperations {

	private List<File> files = new ArrayList<>();

	public FileOperations(List<File> files) {
		super();
		this.files = files;
	}
	
	
	/**Sorting list of files */
	
	public void sorting() { 
		Collections.sort(files, new SortIgnoreCase());
		
				
	}
	
	/**Adding a new file */
	
	public void add(String filePath) {
		File newFile = new File(filePath);
		try {
			if (newFile.createNewFile()) {
				files.add(newFile);
				
			    System.out.println("File created: " + newFile.getName()+" at "+newFile.getAbsolutePath());
			    
			  } else 
			      System.out.println("File already exists.");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	/**Searching for an user specified file */
	
	public void Search(String fileName) {
		
		boolean isFound=false;
		for (File each: files) {
			if(each.getName().equals(fileName)) {
				isFound = true;
				break;
			}	
		}

		if(isFound)
			System.out.println("Successful, File \""+fileName+"\" found") ;
		else
			System.out.println("Unsuccessful, File "+fileName+" is not found") ;
		 
	}
	
	/**Deleting an user specified file */
	
	public void delete(String fileName) {
		
		boolean isDeleted = false;
		
		for (File each: files) {
			if(each.getName().equals(fileName)) {
				each.delete();
				files.remove(each);
				isDeleted = true;
				 break;
			}	
			
		}
		
		if (isDeleted)
		  System.out.println("File \""+fileName+"\" deleted successfully");
		else
			System.out.println("Unuccessful, File not found");
	}
	
	/**Displaying the list of files */
	
	public void display() {
		System.out.println("-------------------------");
		System.out.println("Location : "+files.get(0).getParentFile());
		if(files.size()<=0)
			System.out.println("This Directory has no files");
		for (File each: files) {
			System.out.println(each.getName());	
		}
		System.out.println("-------------------------");
	}
	
}
 