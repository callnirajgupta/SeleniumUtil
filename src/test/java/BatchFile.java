import java.io.IOException;

public class BatchFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 try {
			Runtime.getRuntime().exec(".//OpenFile.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
		 System.out.println("finished");
	}

}
