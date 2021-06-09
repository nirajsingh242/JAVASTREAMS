import java.util.List;

public class FP02Excercise {

	
	public static void main(String[] args) {
	
	
	 
		List<Integer> numbers = List.of(1, 2,3,4,5);
		System.out.println("\n1. Square of each no in list n print sum of it");

		int SumOfSquare = numbers.stream()
				.map(x -> x * x)
				.reduce(0, (x, y) -> x + y);

		System.out.println(SumOfSquare);
	
		
		
		System.out.println("\n2. Cube of each no in list n print sum of it");

		int SumOfCube = numbers.stream()
				.map(x -> x * x * x)
				.reduce(0, (x, y) -> x + y);

		System.out.println(SumOfCube); 
	
		
		
		System.out.println("\n3. Sum of odd numbers in list");

		int SumOfOddNumbers = numbers.stream()
				.filter(x->x%2!=0)
				.reduce(0, (x, y) -> x + y);

		System.out.println(SumOfOddNumbers); 
		 
	 
		/*
		 * numbers.stream() .filter(x->x%2==1) .map(x->x*x*x)
		 * .forEach(System.out::println);
		 * 
		 */ 
	 
	 
	}
	
	
	

}
