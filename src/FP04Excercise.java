import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP04Excercise {

	
	public static void main(String[] args) {
		

//Streams are lazy
//only when terminal operations is executed thenn only intermediate operations is executed in java
		List<String> courses = List.of("Spring","Spring boot","aws","Scala","microservices");
		courses.stream().peek(System.out::println).filter(course->course.length()>5).map(String::toUpperCase).peek(System.out::println).findFirst();
		//Spring
		//SPRING
		System.out.println("......................................................");
		System.out.println("......................................................");
		courses.stream().peek(System.out::println).filter(course->course.length()>11).map(String::toUpperCase).peek(System.out::println).findFirst();
		/*
		 * Spring
		 * Spring boot
		 * aws
		 * Scala
		 * microservices
		 * MICROSERVICES
		 */	
	}
	

}
