import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadingPDFFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            PDDocument doc = PDDocument.load(new File(System.getProperty("user.dir")+"//src//test//resources//OddOneOut.pdf"));
            String text = new PDFTextStripper().getText(doc);;
            System.out.println("Text in PDF\n---------------------------------");
            System.out.println(text);
            } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
