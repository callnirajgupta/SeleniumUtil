import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class StreamAPIReadwriteExcel {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook xssworkbook=new XSSFWorkbook(new FileInputStream("src//test//resources//book.xlsx"));
		SXSSFWorkbook wb = new SXSSFWorkbook(xssworkbook);
		
	    SXSSFSheet sheet = (SXSSFSheet) wb.getSheetAt(2);
	    //sheet.autoSizeColumn(1);
	  
		
		try {
		      File myObj = new File("src//test///resources///response.json");
		      Scanner myReader = new Scanner(myObj);
		      int counter=1;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println("json:"+data);
		        SXSSFRow row = sheet.getRow(counter);
				if (row == null)
					row = sheet.createRow(counter);
				
				SXSSFCell cell = row.getCell(1);
				if (cell == null)
			        cell = row.createCell(1);
				
			    //row is always null
			    row.getCell(1).setCellValue(data);
			    counter++;
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		FileOutputStream fileOut = new FileOutputStream("src//test//resources//book.xlsx");

		wb.write(fileOut);

	    fileOut.close();	
	    
	}

}
