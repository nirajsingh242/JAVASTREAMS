import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP06Files {
	
	
	public static void main(String[] args) {
		
		try {
			//simply reading
			//Files.lines(Paths.get("src/file.txt")).forEach(System.out::println);
			
			
			//unque words
			 Files.lines(Paths.get("src/file.txt"))
			 .map(str->str.split(" "))//it will give for araaya
			 .flatMap(Arrays::stream)//it converts that array in one
			.distinct()//unique
			.sorted()//
			.forEach(System.out::println);
			 
			 
			 
			 
			 Files.list(Paths.get("."))//taking in lst
				.filter(Files::isDirectory)//filtering directory
				.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
