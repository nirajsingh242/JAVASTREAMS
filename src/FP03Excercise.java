import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03Excercise {

	
	public static void main(String[] args) {
	
		List<Integer> numbers = List.of(1, 2,3,4,5);
		
		System.out.println("\n2. Created implementation of Integer::sum method reference");

		//Here BinaryOperator functional interface is used
		BinaryOperator<Integer> IntegerSum = Integer::sum;
		
		//implemention of Integer::sum similiar to below code
		BinaryOperator<Integer> IntegerSum2 = new BinaryOperator<Integer> ()
				{

					@Override
					public Integer apply(Integer a, Integer b) {
						
						return a+b;
					}
				
				};
		
		int sum=numbers.stream()
				.reduce(0, IntegerSum2);
		
		System.out.println(sum);
		
	
	}
	

}
