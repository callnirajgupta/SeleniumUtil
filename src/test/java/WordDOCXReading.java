import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class WordDOCXReading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		XWPFDocument document = null;
		FileInputStream fileInputStream = null;
		try {
 
			
			File fileToBeRead = new File(System.getProperty("user.dir")+"//src/test/resources//WordDocX.docx");
			fileInputStream = new FileInputStream(fileToBeRead);
			document = new XWPFDocument(fileInputStream);
			 List<XWPFParagraph> paragraphs=document.getParagraphs();
			//XWPFWordExtractor extractor = new XWPFWordExtractor(document);
			
 
			System.out.println("The Contents of the Word File are ::");
			System.out.println("--------------------------------------");
 
			System.out.println(paragraphs.get(0).getText());
 
		} catch (Exception e) {
			System.out.println("We had an error while reading the Word Doc");
		} finally {
			try {
				if (document != null) {
					document.close();
				}
				if (fileInputStream != null) {
					fileInputStream.close();
				}
			} catch (Exception ex) {
			}
		}

	}

}
