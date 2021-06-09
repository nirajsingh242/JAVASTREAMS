import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6,7,8,9,10);//alt_shift+L
		
		
		System.out.println("\n1. only print");
		StructuralPrint(numbers);
		
		System.out.println("\n2. prnting only even number");
		StructuralPrintEvenNumbers(numbers);

	}
	//1)//structural approach
		public static void StructuralPrint(List<Integer> numbers)
		{
			//focus on how to do it
			//meaning how to loop n all
		    for(Integer number:numbers)
		    {
		    	
		    	System.out.println(number);
		    }
		}
		
	//2) even no
		private static void StructuralPrintEvenNumbers(List<Integer> numbers) {

			 for(Integer number:numbers)
			    {
			    	if(number%2==0)
			    	System.out.println(number);
			    }
			
		}
		
		
		
		

}
