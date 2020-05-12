package com.csv.sahithi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderSahithi {
	
	
	//Delimiter used in CSV file
	
	    private static final String COMMA_DELIMITER = ",";
	   

	     
	
	    //Student attributes index
	
	    private static final int SSN = 0;
	
	    private static final int Employee = 1;
	
	    private static final int Assignment = 2;
	
	    private static final int FilingStatus = 3;
	
	    private static final int WithHolding = 4;
	      
	    private static final int Exempt = 5;
	    
	
	     
	
	    public static List<EmployeeDetails> readCsvFile(String fileName) {
	    	 List<EmployeeDetails> employeeslist = null;
	 
	
	        BufferedReader fileReader = null;
	
	      
	
	        try {
	
	             
	
	            //Create a new list of student to be filled by CSV file data
	
	             employeeslist = new ArrayList();
	
	             
	
	            String line = "";
	
	             
	
	            //Create the file reader
	
	            fileReader = new BufferedReader(new FileReader(fileName));
	
	             
	
	            //Read the CSV file header to skip it
	
	            fileReader.readLine();
	
	             
	
	            //Read the file line by line starting from the second line
	
	            while ((line = fileReader.readLine()) != null) {
	
	                //Get all tokens available in line
	
	                String[] tokens = line.split(COMMA_DELIMITER);
	
	                if (tokens.length > 0) {
	
	                    //Create a new student object and fill his  data
	
	                	EmployeeDetails employee = new EmployeeDetails(tokens[SSN], tokens[Employee], tokens[Assignment], tokens[FilingStatus], tokens[WithHolding],tokens[Exempt]);
	
	                	employeeslist.add(employee);
	
	                }
	
	            }
	
	             
	
	            //Print the new student list
	
	            for (EmployeeDetails employee : employeeslist) {
	
	                System.out.println(employee.toString());
	
	            }
	
	        }
	
	        catch (Exception e) {
	
	            System.out.println("Error in CsvFileReader !!!");
	
	            e.printStackTrace();
	
	        } finally {
	
	            try {
	
	                fileReader.close();
	
	            } catch (IOException e) {
	
	                System.out.println("Error while closing fileReader !!!");
	
	                e.printStackTrace();
	
	            }
	
	        }
	
	    return employeeslist;
	
	    }
	    
	    public static EmployeeDetails getdata(String fileName,int row){
	    	
	    	List<EmployeeDetails> employeeslist=	readCsvFile(fileName);
	    	
	    	
	    	return employeeslist.get(row);
	    	
	    }


}
