import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingCVSUsingScanner {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\SampleCSV.csv"));  
		sc.useDelimiter(",");
		int count=0;//sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  System.out.print("read coulmn wise *****************"+count);
		System.out.println(sc.next());  //find and returns the next complete token from this scanner  
		count++;
		}   
		sc.close();  //closes the scanner  


	}

}
