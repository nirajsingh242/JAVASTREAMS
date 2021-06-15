import java.util.stream.LongStream;

public class FP05ClassParallelization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time=System.currentTimeMillis();
		System.out.println(LongStream.range(0, 100000000).sum());
		System.out.println(System.currentTimeMillis()-time);
			//255 ms took
		
		long time2=System.currentTimeMillis();
		System.out.println(LongStream.range(0, 100000000).parallel().sum());
		System.out.println(System.currentTimeMillis()-time2);
		//49 ms
		
		
		//we cannort implement paraalizaton in structural one becouse it invls=ves state changes
 
	}

}
