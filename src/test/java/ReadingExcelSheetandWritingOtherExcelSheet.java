import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelSheetandWritingOtherExcelSheet {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		XSSFWorkbook xssworkbook=new XSSFWorkbook(new FileInputStream("src//test//resources//book.xlsx"));
		
	    XSSFSheet sheet =  xssworkbook.getSheetAt(0);
	    
	   int rownum= sheet.getLastRowNum();
	   
	   
	   XSSFWorkbook xssworkbookWrite=new XSSFWorkbook(new FileInputStream("src//test//resources//ExcelUsedForScreenShot.xlsx"));
		
	    XSSFSheet sheetwrite =  xssworkbookWrite.getSheet("manmohan");
		
		for (int i= 0;i<rownum;i++){
			XSSFRow row=sheet.getRow(i);
			
			String value=row.getCell(0).getStringCellValue();
			System.out.println("print value"+value );
			
			XSSFRow rowwrite = sheetwrite.getRow(i);
			if (rowwrite == null)
				rowwrite = sheetwrite.createRow(i);
			
			XSSFCell cell = rowwrite.getCell(0);
			if (cell == null)
		        cell = rowwrite.createCell(0);
			
		    //row is always null
			rowwrite.getCell(0).setCellValue(value);
		    
			
			
		}
		
		FileOutputStream fileOut = new FileOutputStream("src//test//resources//ExcelUsedForScreenShot.xlsx");

		xssworkbookWrite.write(fileOut);

	    fileOut.close();	
	    
		
	


	}

}
