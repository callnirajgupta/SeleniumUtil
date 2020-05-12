package com.csv.writingreading;

public class CsvWriteReadTest {
	
	public static void main(String[] args) {
		
		        String fileName = System.getProperty("user.dir")+"//src//test//resources//student.csv";
		
		        System.out.println("Write CSV file:");
		
		        CsvFileWriter.writeCsvFile(fileName);
		
		        System.out.println("\nRead CSV file:");
		
		        CsvFileReader.readCsvFile(fileName);
		
		 
		
		    }


}
