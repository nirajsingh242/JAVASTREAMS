import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviouralParameterization {
// we pass logic as paratmeter repetative code will be avaoided
	public static void main(String[] args) {
		List<Integer> numbers = List.of(6,7,8,9,10,10);//alt_shift+L
		//	Alt+shift+i-->> inline means variable value directl assigned
		
		//logic 1
		filterAndPrint(numbers, x->x%2==0);//passed even logic 
		
		//logic 2
		filterAndPrint(numbers, x->x%2!=0);//passed odd logic
		

	
				
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		//same line of code can be used multple while passing logic while local var in function parameter
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	
}
