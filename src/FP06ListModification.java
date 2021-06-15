import java.util.ArrayList;
import java.util.List;

public class FP06ListModification {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring","Spring boot","aws","Scala","microservices");
		List<String> modfiable=new ArrayList<>(courses);
		
		
		modfiable.replaceAll(str->str.toUpperCase());
		
		System.out.println(modfiable);

		modfiable.removeIf(str->str.length()<4);
		
		System.out.println(modfiable);

	}

}
