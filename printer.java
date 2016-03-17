
public class printer {
	static int inputLength = 0;
	static int RR[][];
	int TT[][];
	
	printer(int iL, int R[][], int T[][])
	{
		inputLength = iL;
		RR = R;
		TT = T;
	}
	
	  public static void printTree(int i, int j, int root, char side)
	    {
	    	if(j==(inputLength-1) && i==0)
	    	{
	    		System.out.println("The tree Root is : " + RR[i][j]);
	    	}
	    	else
	    	{
	    		if(side == 'L')
	    		{
	    			System.out.println(RR[i][j] + " is the left child of : " + root);
	    		}
	    		else
	    		{
	    			System.out.println(RR[i][j] + " is the right child " + root);
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
	    }
}
