package com.csv.sahithi;

import com.csv.writingreading.CsvFileReader;
import com.csv.writingreading.CsvFileWriter;

public class ReadCSVFileMainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fileName = System.getProperty("user.dir")+"//src//test//resources//SampleCSV.csv";
		
       

        System.out.println("\nRead CSV file:");

        //CsvFileReaderSahithi.readCsvFile(fileName);
        EmployeeDetails employee=CsvFileReaderSahithi.getdata(fileName,1); 
        System.out.println("SSn"+employee.getSSN());

	}

}
