import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(6,7,8,9,10);//alt_shift+L
		
		
		System.out.println("\n1. Adding whole list n giving single result");
		int sum=AddListStructural(numbers);
		System.out.println(sum);
	
	}

	private static int AddListStructural(List<Integer> numbers) {
			
		int sum=0;
		for(int number:numbers)
		{
			sum+=number;
		}
		return sum;
	}
			

}
