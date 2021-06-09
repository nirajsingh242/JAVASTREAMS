import java.util.Arrays;

public class NseitProblemStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr = { 5, 4, 6, 2, 1, 3, 8, 9, 7 };
	    int n = arr.length;
	   int[] output= printOrder(arr, n);
	   
	   for(int a:output)
	   System.out.println(a);
	}
	
	static int[] printOrder(int[] arr, int n)
	{
		
		int[] ouput=new int[n];
	    Arrays.sort(arr);
	    
	    
	    
	    
	    
	    
	    for (int i = 0; i < n / 2; i++)
	    	ouput[i]= arr[i];
	 
	    
	    for (int j = n - 1, i=n/2; j >= n / 2; j--,i++)
	    	ouput[i]= arr[j];
		
	    return ouput;
	     
	}

}
