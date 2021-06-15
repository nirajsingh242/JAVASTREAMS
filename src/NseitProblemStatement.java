import java.util.Arrays;

public class NseitProblemStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] arr = { 5, 4, 6, 2, 1, 3, 8, 9, 7 };
		
		
	    int n = arr.length;
	   int[] output= printOrder(arr, n);
	   
	   for(int a:output)
	   System.out.println(a);
/////////////////////////////////////////////////////////////////////	   
		String abc="abcdabcdabcd";
		String a="abc";
		
		System.out.println(abc.split(a,-1).length-1);
/////////////////////////////////////////////////////////////////////////////
		String[] arrString = {"A","C","B","1","0","A1" };
		 Arrays.sort(arrString);
		 for(String b:arrString)
			   System.out.println(b);
		   
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
