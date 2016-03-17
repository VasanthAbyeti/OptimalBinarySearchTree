import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class obst {
	static int inputLength = 0;
	static int RR[][];
	static int TT[][];
	static String values[];
	int costs[];
	static FileWriter fw;
	static BufferedWriter bw;
	
    obst(String in[], int f[]) throws IOException
    {
    	String input[] = in;
    	int freq[] = f;
        values = input;
        matrix(input, freq);
        File file = new File("Output.txt");
        fw = new FileWriter(file);
        bw = new BufferedWriter(fw);
    }
    
    public int matrix(String input[], int freq[])
    {
        int T[][] = new int[input.length][input.length];
        int R[][] = new int[input.length][input.length];
        RR=R;
        TT=T;
        inputLength = input.length;
        for(int i=0; i < T.length; i++){
            T[i][i] = freq[i];
            R[i][i] = i+1;
        }
        
        for(int l = 2; l <= input.length; l++){
            for(int i=0; i <= input.length-l; i++){
                int j = i + l -1;
                T[i][j] = 9999;
                int sum = getSum(freq, i, j);
                
                int x, y;
                //System.out.println();
                //for(x=0;x<input.length;x++)
                //{
                //	for(y=0;y<input.length;y++)
                //	{
                //		System.out.print(T[x][y]+";");
                //	}
                //	System.out.println();
                //}
                
                for(int k=i; k <= j; k++){
                     int val = sum + (k-1 < i ? 0 : T[i][k-1]) +
                            (k+1 > j ? 0 : T[k+1][j]) ;
                     
                     if(val < T[i][j]){
                    	 R[i][j]=k+1;
                         T[i][j] = val;
                     }
                }
            }
        }
        
        
        //int x, y;
        
       // System.out.println();
        //for(x=0;x<input.length;x++)
        //{
        //	for(y=0;y<input.length;y++)
        //	{
        //		System.out.print(R[x][y]+";");
        //	}
        //	System.out.println();
        //}
        
        return T[0][input.length-1];
    }
    
    private int getSum(int freq[], int i, int j){
        int sum = 0;
        for(int x = i; x <= j; x++){
            sum += freq[x];
        }
        return sum;
    }
 
    private static void printTree(int i, int j, int root, char side) throws IOException
    {
    	if(j==(inputLength-1) && i==0)
    	{
    		//System.out.println("The tree Root is : " + values[RR[i][j]-1]);
    		bw.write("The tree Root is : " + values[RR[i][j]-1]);
    		bw.newLine();
    	}
    	else
    	{
    		if(RR[i][j]!=RR[0][inputLength-1])
    		{
    		if(side == 'L')
    		{
    			//System.out.println(values[RR[i][j]-1] + " is the left child of : " + values[root-1]);
    			bw.write(values[RR[i][j]-1] + " is the left child of : " + values[root-1]);
    			bw.newLine();
    			
    		}
    		else
    		{
    			//System.out.println(values[RR[i][j]-1] + " is the right child of : " + values[root-1]);
    			bw.write(values[RR[i][j]-1] + " is the right child of : " + values[root-1]);
    			bw.newLine();
    		}
    		}
    	}
    	
    	int x =i;
    	int y =j;
    	int me = RR[x][y];
    	//left Child

    	while (y>=0 && RR[x][y]!=0)
    	{
    		if(RR[x][y]==me)
    		{
    			y--;
    		}
    		else
    		{
    			printTree(x, y, me, 'L');
    			break;
    		}
    	}
    	
    	//Right Child
    	int k =i;
    	int h =j;
    	while (k<inputLength && RR[k][h]!=0)
    	{
    		if(RR[k][h]==me)
    		{
    			k++;
    		}
    		else
    		{
    			printTree(k, h, me, 'R');
    			break;
    		}
    	}
    		
    }
    

    
    	public static void action() throws IOException
    	{
       // String input[] = {"V","A","S","A","N","T","H","K","U","M","R"};
       // int freq[] = {4,2,6,3,34,8,50,21,16,8,9};

        int L = inputLength-1;
        printTree(0,L,RR[L][L],'L');
        bw.close();
        }
}