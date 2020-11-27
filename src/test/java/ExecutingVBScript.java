import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class ExecutingVBScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			System.out.println(new File(System.getProperty("user.dir")+"//src//test/resources//Readfile.vbs").getAbsolutePath());
			Process process= Runtime.getRuntime().exec("wscript.exe " + new File(System.getProperty("user.dir")+"//src//test/resources//Readfile.vbs").getAbsolutePath());
			System.out.println(process.waitFor());
		   }
		   catch( Exception e ) {
		      System.out.println(e);
		      System.exit(0);
		   }
       System.out.println("execution completed");
	}

}
