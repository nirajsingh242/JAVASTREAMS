import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6,7,8,9,10,10,10);//alt_shift+L
		
		
	
		System.out.println("1. Normaly approch of labda exp n method reference");

		numbers.stream().
		filter(x -> x % 2 == 0)
		.map(x -> x * x)
		.forEach(System.out::println);

		System.out.println("\n2. Level 1 dig approch of labda exp n method reference");
		// Predicate is funtionalinterface
		// returns only true or false
		Predicate<Integer> isEven = x -> x % 2 == 0;
		
		//takes input returns result
		Function<Integer, Integer> squareOfNumber = x -> x * x;
		
		//simply consumes results of previos step
		Consumer<Integer> sysoutpln = System.out::println;

		
		numbers.stream()
		.filter(isEven)
		.map(squareOfNumber)
		.forEach(sysoutpln);		
		
		System.out.println("\n2. Level 2 with new keyword dig approch of labda exp n method reference");

		// Predicate behind the scene working
		// public boolean test(Integer t) method to override
		Predicate<Integer> isEven2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer x) {

				return x % 2 == 0;
			}

		};

		// apply method need to overide
		Function<Integer, Integer> squareOfNumber2 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer x) {

				return x * x;
			}

		};

		// simply consumes results of previos step
		Consumer<Integer> sysoutpln2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer x) {
				System.out.println(x);

			}

		};

		numbers.stream()
		.filter(isEven2)
		.map(squareOfNumber2)
		.forEach(sysoutpln2);
			
		
	}
	
}
