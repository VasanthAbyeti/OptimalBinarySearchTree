import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {

	public static void main(String args[]) throws IOException
	{
	
	FileReader fr = new FileReader(args[0]);
	BufferedReader br = new BufferedReader(fr);
	
	String line;
	String input[] = new String[2];
	String tuple[];
	String key = "";
	String Pr = "";
	String keys[];
	String prob[];
	int probs[];
	
	while((line = br.readLine()) != null)
	{
		input = line.split(":");
		input[1]=input[1].trim();
		tuple = input[1].split(" ");
		
		key = key + "," + tuple[0];
		Pr = Pr + "," + tuple[1];
	}

	Pr = Pr.substring(1);
	key = key.substring(1);
	keys=key.split(",");
	probs = new int[keys.length];
	prob = Pr.split(",");
	for(int i1=0; i1<keys.length-1; i1++)
	{
		probs[i1] = (int) (Float.parseFloat(prob[i1])*1000);
	}
	
    obst ots = new obst(keys,probs);
    ots.action();
		
	}
}
