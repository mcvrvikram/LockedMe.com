package com.ops;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileOperations {
	private String path;
	private List<File> files = new ArrayList<>();

//	public FileOperations(List<File> files) {
//		super();
//		this.files = files;
//	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public void loadFiles() {
		FileFilter fileFilter = new FileFilter()
        {
          @Override
          public boolean accept(File file) {
            return !file.isDirectory();
          }
        };
		 
			File folder = new File(path);
			if(!files.isEmpty())
				files.clear();
			if(folder.exists()) {
				for(File each:folder.listFiles(fileFilter))
					files.add(each);
			}
			else
				System.out.println("Something went wrong, the folder ay have been moved or deleted");
			
			
		
	}
	
	
	/**Sorting list of files */
	
	public void sorting() {
		loadFiles();
		Collections.sort(files, new SortIgnoreCase());
		
				
	}
	
	/**Adding a new file */
	
	public void add(String filePath) {
		File newFile = new File(filePath);
		try {
			if (newFile.createNewFile()) {
				loadFiles();
				
			    System.out.println("File created: " + newFile.getName()+" at "+newFile.getAbsolutePath());
			    
			  } else 
			      System.out.println("File already exists.");
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	/**Searching for an user specified file */
	
	public void Search(String fileName) {
		loadFiles();
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
		loadFiles();
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
		sorting();
		System.out.println("-------------------------");
		
		if(files.isEmpty())
			System.out.println("This Directory has no files");
		else
			System.out.println("Location : "+files.get(0).getParentFile());
		for (File each: files) {
			System.out.println(each.getName());	
		}
		System.out.println("-------------------------");
	}
	
}
 