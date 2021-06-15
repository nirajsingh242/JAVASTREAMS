import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlayingWIthPrimitivesUsingStreams {

	public static void main(String[] args) {
		
		//RferencePipe lline type
		System.out.println(Stream.of(1,2,3,4,5).count());
		
		System.out.println(Stream.of(1,2,3,4,5).reduce(0,Integer::sum));
		
		//here it convert primitive to wraaper n therfore boxing n unboxing happens
		
		//we lets use StreamInt primitive type
		
		int[] array= {1,2,3,4,5};
		
		System.out.println(Arrays.stream(array).min());
		System.out.println(Arrays.stream(array).max());
		System.out.println(Arrays.stream(array).average());
		
		
		///creating Streams with primitives dynamically
		
		System.out.println(IntStream.range(1,10).sum());//exclude 10
		System.out.println(IntStream.rangeClosed(1,10).sum());//include 10
		
		System.out.println(IntStream.iterate(1,e->e+1).limit(10).peek(System.out::println).sum());//iterating with addition n summing
		//peek at each iteration print it up
		
		//first 10 even no and do sum
		System.out.println(IntStream.iterate(2,e->e+2).limit(10).peek(System.out::println).sum());//iterating with addition n summing
		
		//we cannot apply collect directly to primitive streams so we need to box
		List<Integer> variable = IntStream.iterate(2,e->e+2).limit(10).boxed().collect(Collectors.toList());
		System.out.println(variable);
		
		//calculation involving big integer
		
		System.out.println(IntStream.rangeClosed(1,10).reduce(1,(x,y)->x*y));
		
		System.out.println(IntStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE
				,BigInteger::multiply));
		
		
		
		
		
		/*
		 * int[] data = {1,2,3,4,5,6,7,8,9,10};
		 * 
		 * // To boxed array Integer[] what = Arrays.stream( data ).boxed().toArray(
		 * Integer[]::new ); Integer[] ever = IntStream.of( data ).boxed().toArray(
		 * Integer[]::new );
		 * 
		 * // To boxed list List<Integer> you = Arrays.stream( data ).boxed().collect(
		 * Collectors.toList() ); List<Integer> like = IntStream.of( data
		 * ).boxed().collect( Collectors.toList() );
		 */
		
		
	}
	//calling in main with below code
	/*
	 * int arr[] = { 1, 2, 3, 4, 5 };
	 * 
	 * int ans[] = logic(arr); System.out.println("final output : " +
	 * Arrays.toString(ans));
	 * 
	 */	
	
	public static int[] logic(int[] ar)
    {
		//converting int[] aa to Integer array
        Integer[] arr=Arrays.stream( ar ).boxed().toArray( Integer[]::new );
         Collections.rotate(Arrays.asList(arr),1);
         System.out.println("first Rotation : " +
                        Arrays.toString(arr));
         
         
       //converting Integer[] aa to Integer int[]array
        int[] newArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i].intValue();
        }
        return newArray;
    }


	
	
	

}
