import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Opencmd {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		/*String destFolder="E:\\JavaScript";
        
        *  Location where the Nodejs Project is Present
        
        System.out.println(destFolder);

        String cmdPrompt="cmd";
        String path="/c";
        String npmUpdate="npm --version";
        String npm="npm";
        String update="update";

        File jsFile=new File(destFolder);
        List<String> updateCommand=new ArrayList<String>();
        updateCommand.add(cmdPrompt);
        updateCommand.add(path);
        updateCommand.add(npmUpdate);

        
    

        ProcessBuilder executeProcess=new ProcessBuilder(updateCommand);
        executeProcess.directory(jsFile);
        Process resultExecution=executeProcess.start();

        BufferedReader br=new BufferedReader(new InputStreamReader(resultExecution.getInputStream()));
        StringBuffer sb=new StringBuffer();

        String line;
        while((line=br.readLine())!=null){
            sb.append(line+System.getProperty("line.separator"));
        }
        br.close();
        int resultStatust=resultExecution.waitFor();
        System.out.println("Result of Execution"+(resultStatust==0?"\tSuccess":"\tFailure"));
*/
		
		String command = "cmd.exe /c start "+"npm --version";

		Process child = Runtime.getRuntime().exec(command);
		
		child.waitFor();

			//waitFor() to block until the process is finished
			//isAlive() to periodically check whether the process is still running
		
		//Process p = Runtime.getRuntime().exec("cmd.exe /c start dir ");
		//Process p1 = Runtime.getRuntime().exec("cmd.exe /c start cd \"E:\\rakhee\\Obligation Extractions\" && dir");
		//Process p2 = Runtime.getRuntime().exec("cmd.exe /c start cd \"E:\\oxyzen-workspace\\BrightleafDesktop\\Obligation Extractions\" && dir");
		
	}

}
