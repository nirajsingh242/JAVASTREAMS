import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1,2,3,4,5);
		//System.out.println("\n1. only print");
		//funtionalPrint(numbers);
		
		//System.out.println("\n2. prnting only even number");
		//funtionalPrintEvenNumbers(numbers);
		
		System.out.println("\n3. prnting only square of even number");
		funtionalSquarePrintEvenNumbers(numbers);
		
		}
	
	

	//focus on what to do
	//1)//funtonal approach
	public static void funtionalPrint(List<Integer> numbers)
	{
		//creats stream 
		//on each value of stream it uses method reference to values
		//:: represent method reference
	    numbers.stream().forEach(System.out::println);
	}
	
	//2) even number print 
	private static void funtionalPrintEvenNumbers(List<Integer> numbers) {
		
		//using method reference
		numbers.stream()
				.filter(FP01Functional::evenCheck)//only allow even nos
				.forEach(System.out::println);//Method reference
		
		//using lamda exp
		numbers.stream()
		.filter(number->number%2==0)///lamda expression
		.forEach(System.out::println);//Method reference

		
		
		
	}
	
	public static Boolean evenCheck(Integer number)
	{
		return number%2==0;
	}
	//3.square of even numbers
	private static void funtionalSquarePrintEvenNumbers(List<Integer> numbers) {
		
		
		//using lamda exp
		numbers.stream()
		.filter(number->number%2==0)///lamda expression
		.map(number->number*number)//mapping and manupulate 
		.forEach(System.out::println);//Method reference

		
		
		
	}
		


}
