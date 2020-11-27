import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class copywholetxtandpasteinexcel {

	public static void main(String[] args) throws IOException {
		String all= "";
		try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/complete_1_21.json"))) {
		     String sCurrentLine;
		     while ((sCurrentLine = br.readLine()) != null) {
		        all = all + "\n" + sCurrentLine;
		    }
		    } catch (IOException e) {
		        e.printStackTrace();
		}
		String fileName = System.getProperty("user.dir")+"/src/test/resources/(Original) Regression Testing Working File.xlsx";
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileName);
		
		 
		XSSFSheet sheet = workbook.getSheetAt(3);
		Row row = sheet.createRow(101);

		  Cell cell = row.createCell(0); 
		  
		  CellStyle cs = workbook.createCellStyle();
		  cs.setWrapText(true);
		  cell.setCellStyle(cs);
	      row.setHeightInPoints((2*sheet.getDefaultRowHeightInPoints()));
	      //adjust column width to fit the content
	      sheet.autoSizeColumn((short)2);
	      cell.setCellValue(all); //Write header
	      
		  
		FileOutputStream fileOut = new FileOutputStream(fileName);
		workbook.write(fileOut);
		fileOut.close();

	}

}
