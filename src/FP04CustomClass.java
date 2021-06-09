import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}
public class FP04CustomClass {

	public static void main(String[] args) {
		
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

	

		// allMatch, noneMatch, anyMatch
		Predicate<Course> reviewScoreGreaterThan95Predicate 
			= course -> course.getReviewScore() > 95;

		Predicate<Course> reviewScoreGreaterThan90Predicate 
			= course -> course.getReviewScore() > 90;
			
		Predicate<Course> reviewScoreLessThan90Predicate 
			= course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));//false
		
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));//true
		
		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));//false
		
		System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));//true
		
		
		
		
		//sorting based on no of students
		Comparator<Course> sortingaspernoofstudents = Comparator.comparingInt(Course::getNoOfStudents);
		
		List<Course> CourseAsPerNoOfStudents=courses.stream()
				.sorted(sortingaspernoofstudents)
				.collect(Collectors.toList());
		
		System.out.println(CourseAsPerNoOfStudents);
		
		//[FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]
		
		Comparator<Course> sortingaspernoofstudentsDec = Comparator.comparingInt(Course::getNoOfStudents).reversed();
		
		List<Course> CourseAsPerNoOfStudentsDec=courses.stream()
				.sorted(sortingaspernoofstudentsDec)
				.collect(Collectors.toList());
		
		System.out.println(CourseAsPerNoOfStudentsDec);
		
		//[Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		
		
		//sorting as per no of students and course review n reversing for review score higher to lower
		
		Function<Course,Integer> reviewScore = Course::getReviewScore;
		Comparator<Course> sortingaspernoofstudentsAndReview = Comparator.comparingInt(Course::getNoOfStudents).thenComparing(reviewScore).reversed();
		List<Course> CourseAsPerNoOfStudentsAndReview=courses.stream()
				.sorted(sortingaspernoofstudentsAndReview)
				.collect(Collectors.toList());
		
		System.out.println(CourseAsPerNoOfStudentsAndReview);
	
		//limit
		System.out.println(
				courses.stream()
				.sorted(sortingaspernoofstudentsAndReview)
				.limit(5)
				.collect(Collectors.toList()));
		
		//[Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
		
		//skip
		
		System.out.println(
				courses.stream()
				.sorted(sortingaspernoofstudentsAndReview)
				.skip(3)
				.collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]
		
		
		//skip n limim both
		
		System.out.println(
				courses.stream()
				.sorted(sortingaspernoofstudentsAndReview)
				.skip(3)
				.limit(2)
				.collect(Collectors.toList()));
		//[AWS:21000:92, Spring:20000:98]
		
		System.out.println();
		System.out.println(courses);
		
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
	
	//	takeWhile() -->> take elements from start n as soon as condition matched it will skip all after that
		
		System.out.println(
			courses.stream()
			     .takeWhile(course -> course.getReviewScore()>=95)
			     .collect(Collectors.toList()));
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]
		
	//dropWhile()-->>it will keep dropping elements till condiion matched as soon as condition matched it will start colleting element from there
		
		System.out.println(
				courses.stream()
				     .dropWhile(course -> course.getReviewScore()>=95)
				     .collect(Collectors.toList()));
		//[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

		
		///min ,max 
		
		
		
		System.out.println(
				courses.stream()
				.max(sortingaspernoofstudentsAndReview));
		//Optional[FullStack:14000:91]

		System.out.println(
				courses.stream()
				.min(sortingaspernoofstudentsAndReview)
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
				);
				
		//Optional[Microservices:25000:96]
		//Microservices:25000:96
	
		System.out.println(
			courses.stream()
			.filter(reviewScoreLessThan90Predicate)
			.min(sortingaspernoofstudentsAndReview)
			.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
				);
		//Optional.empty
		//Kubernetes:20000:91
		
		//findAny and findFirst
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreLessThan90Predicate)
				.findFirst()
					);//Optional.empty
		

		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findFirst()
					);//Optional[Spring:20000:98]

		
		/*
		 * * <p>The behavior of this operation is explicitly nondeterministic; it is
		 * free to select any element in the stream. This is to allow for maximal
		 * performance in parallel operations; the cost is that multiple invocations on
		 * the same source may not return the same result. (If a stable result is
		 * desired, use {@link #findFirst()} instead.)
		 */
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findAny()
					);//Optional[Spring:20000:98]
		
	
	
	//sum avg(optional) count max
	
	System.out.println(
			courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.sum());//88000
	
	
	System.out.println(
			courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.average());//
	
	System.out.println(
			courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.count());//4
	
	System.out.println(
			courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.min());//OptionalInt[20000]
	
	
	System.out.println(
			courses.stream()
			.filter(reviewScoreGreaterThan95Predicate)
			.mapToInt(Course::getNoOfStudents)
			.max());//OptionalInt[25000]
	
	//Grouping
	System.out.println(courses.stream()
	.collect(Collectors.groupingBy(Course::getCategory))
	);
	
	/*	Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
			FullStack=[FullStack:14000:91],
			Microservices=[API:22000:97, Microservices:25000:96],
			Framework=[Spring:20000:98, Spring Boot:18000:95]}
	*/
	System.out.println(courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
			);
	
	//{Cloud=4, FullStack=1, Microservices=2, Framework=2}
	
	//1)collect 2)Collectors(para1,para2(not necessary))
	//para1-->> actual group condition
	//para2-->after groping what you want from that likie count, max of propery from each group by using maxBay()
	System.out.println(courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
			);
	
	//mapping(para1,para2)
	//para1->>to whoom to map
	//para2 in what to convert
	System.out.println(courses.stream()
			.collect(Collectors.groupingBy(Course::getCategory,Collectors.mapping(Course::getName,Collectors.toList())))
			);
			
	//Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]
	
	
	
	
	}
}
