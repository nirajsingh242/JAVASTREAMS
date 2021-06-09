import java.util.List;

public class FP01Excercise {

	
	public static void main(String[] args) {
	
	List<String> stringList = List.of("Spring","Boot","Spring Boot","Java","AWS");
	
	System.out.println("\n3. prnting String List");
	stringList.stream()
	.forEach(System.out::println);
	
	
	System.out.println("\n3. prnting String List cotaining BOOT");
	stringList.stream()
	.filter(StringList->StringList.contains("Boot"))
	.forEach(System.out::println);
	
	
	System.out.println("\n3. prnting Corsse list which cointains atleast 4 letters");
	 stringList.stream()
	.filter(StringList->StringList.length() > 3)
	.forEach(System.out::println);
	 
	 
	 List<Integer> numbers = List.of(1,2,3,4,5);
	 System.out.println("\n4. prnting cube of odd numbers");
	 
	 numbers.stream()
	 .filter(x->x%2==1)
	 .map(x->x*x*x)
	 .forEach(System.out::println);
	
	 
	 System.out.println("\n5. prnting no of characters in each course name");
	 stringList.stream()
		.map(x->x+" "+x.length())
		.forEach(System.out::println);
	 
	 
	}
	
	
	

}
