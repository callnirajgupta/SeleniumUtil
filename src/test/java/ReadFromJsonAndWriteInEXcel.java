import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromJsonAndWriteInEXcel {

	public static void main(String[] args) throws IOException {

		LinkedList<String[]> text_lines = new LinkedList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/test/resources/complete_1_21.json"))) {
	        String sCurrentLine;
	        while ((sCurrentLine = br.readLine()) != null) {
	            text_lines.add(sCurrentLine.split("\\t"));                 
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    String fileName = System.getProperty("user.dir")+"/src/test/resources/(Original) Regression Testing Working File.xlsx";
	    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileName));
	
	    
	    XSSFSheet sheet = workbook.getSheetAt(3);
	    int row_num = 98;
	    for(String[] line : text_lines){
	    	row_num++;
	    	XSSFRow row=sheet.getRow(row_num);
	    	if(row==null)
	    	 row = sheet.createRow(row_num);
	    	System.out.println("print row number"+row_num);
	        int cell_num = 0;
	        for(String value : line){
	        	System.out.println("print the line "+value);
	        	XSSFCell cell=row.getCell(0);
	        	if(cell==null)
	        	cell = row.createCell(0);
	        	
	        	//cell.setCellType(Cell.CELL_TYPE_STRING);
	        	//row.getCell(0).setCellValue(value);
	        	
	        	//row.getCell(0).setCellFormula(value);
	        	row.getCell(0).setCellValue(value);
	        	
	        }
	    }

	    FileOutputStream fileOut = new FileOutputStream(fileName);
	    workbook.write(fileOut);
	    XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
	    //workbook.setForceFormulaRecalculation(true);
	    fileOut.close();
	}

}
