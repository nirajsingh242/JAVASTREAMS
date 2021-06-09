import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6,7,8,9,10,10,10);//alt_shift+L
		
		
		System.out.println("1. Adding whole list n giving single result using reduce functional approach");
		int sum=AddListFunctional(numbers);
		System.out.println(sum);
	
		System.out.println("\n2. finding greatest number in list");
		//int max=numbers.stream().reduce(0, (x,y)->x>y? x:y);//work for positive number
		int max=numbers.stream().reduce(Integer.MIN_VALUE, (x,y)-> x>y ? x:y);//work for positive as well as negative number 
		//meaning when contains only negative numbers
		System.out.println(max);  
	
		
		System.out.println("\n3. finding min value in list");
		//int max=numbers.stream().reduce(0, (x,y)->x<y? x:y);//work for positive number
		int min=numbers.stream().reduce(Integer.MAX_VALUE, (x,y)-> x<y ? x:y);//work for positive as well as negative number 
		//meaning when contains only negative numbers
		System.out.println(min);  
	
		
		System.out.println("\n4. findind distict element in list");

			numbers.stream()
			.distinct()
			.forEach(System.out::println);

			
			//by defoult it will min to max
		//	n equivalent to Comparator.naturalOrder()
		System.out.println("\n5. print sorted element in list");

			numbers.stream()
			.sorted()
			.forEach(System.out::println);

		 
		System.out.println("\n6. print sorted and distict element in list");
		
			numbers.stream()
			.sorted().distinct()
			.forEach(System.out::println);


		List<String> stringList = List.of("Spring","Boot","Spring Boot","Java","AWS");
		System.out.println("\n7. print sorted  element in String list");
		stringList.stream().sorted(Comparator.naturalOrder())
		.forEach(System.out::println);
	

		
		System.out.println("\n8. print sorted  element in String list in reverse order");
		stringList.stream().sorted(Comparator.reverseOrder())
		.forEach(System.out::println);
		
		
		System.out.println("\n9. print sorted  element in String list custome based on length of string");
		stringList.stream().sorted(Comparator.comparing(str->str.length()))
		.forEach(System.out::println);
		   
		System.out.println("\n10. print sorted  element in String list custome based on length of string in descending order");
		List<String> temp = stringList.stream().sorted(Comparator.comparing(str -> str.length()))
				.collect(Collectors.toList());
		;
		
		//Collectors-->>contains various accumulation function
		// convered List<Stream> of sorted elements as per length to List<Interger>
		// then applied Comparator.reverseOrder()
		temp.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		
		//it will work only with method reference not lamda exp due to incompatibility
		
		Function<String, Integer> keyExtractor = String::length;
		stringList.stream().sorted(Comparator.comparing(keyExtractor).reversed())
		.forEach(System.out::println);
		;
		
		
	}
	private static int AddListFunctional(List<Integer> numbers) {
		//using method reference cutstom
	//	return numbers.stream().reduce(0,FP02Functional::add);
	
		
		//using method reference inbuilt sum method
			//	return numbers.stream().reduce(0,Integer::sum);
			
		//using method reference lamda expression
		return numbers.stream().reduce(0,(x,y)->x+y);

	}
			
	private static int add(int aggregate,int nextNumber)
	{
		return aggregate+nextNumber;
	}

}
