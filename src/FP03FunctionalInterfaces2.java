import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FP03FunctionalInterfaces2 {

	public static void main(String[] args) {List<Integer> numbers = List.of(6,7,8,9,10,10);//alt_shift+L
	
	//	Alt+shift+i-->> inline means variable value directl assigned
	
	//logic 1
	Predicate<Integer> evenLogic = x->x%2==0;
	
	//logic 2
	Predicate<Integer> oddLogic = x->x%2!=0;
	
	//takes input returns result
	Function<Integer, Integer> squareOfNumber = x -> x * x;
	
	//takes input returns result
	Function<Integer, String> squareOfNumberString = x -> x * x+" ";
	
	//simply consumes results of previos step
	Consumer<Integer> sysoutpln = System.out::println;
	
	//BinaryOperator
	BinaryOperator<Integer> IntegerSum =(x,y)->x+y;// Integer::sum;
	
	//uniaryOperator
	UnaryOperator<Integer> unaryoperator=(x)->3*x;
	System.out.println(unaryoperator.apply(3));
	
	//Supplier no input return something
	Supplier<Integer> sup=()->{
		Random random=new Random();
		return random.nextInt(1000);
	};
	System.out.println(sup.get());
	
	UnaryOperator<Integer> unaryOperator = x -> 3 * x;
	System.out.println(unaryOperator.apply(10));
	
	BiPredicate<Integer, String> biPredicate = (number,str) -> {
		return number<10 && str.length()>5;
	};
	
	System.out.println(biPredicate.test(10, "niraj"));
	
	BiFunction<Integer, String, String> biFunction = (number,str) -> {
		return number + " " + str;
	};
	
	System.out.println(biFunction.apply(15, "niraj"));
	
	BiConsumer<Integer, String> biConsumer = (s1,s2) -> {
		System.out.println(s1);
		System.out.println(s2);
	};
	
	biConsumer.accept(25, "niraj");
	
	BinaryOperator<Integer> sumBinaryOperator2 = (x, y) -> x + y;
	
	IntBinaryOperator intBinaryOperator = (x,y) -> x + y;
	
	//IntBinaryOperator
	//IntConsumer
	//IntFunction
	//IntPredicate
	//IntSupplier
	//IntToDoubleFunction
	//IntToLongFunction
	//IntUnaryOperator
	
	//Long, Double, Int
	

			
}


	
	


}
