import java.util.stream.*;
import java.util.*;

public class MethodReferences {

	 MethodReferences() {
		toUpperCase();
		countUsingReduce();
		flatMapConcatenating();	
	}

	public void toUpperCase() { 
		Stream.of("One", "Two", "Three").map(String::toUpperCase).forEach(System.out::println);
	}

	public void countUsingReduce() {
		System.out.println(Stream.of(1, 2, 3).mapToLong(Long::new).reduce(0L, Long::sum));
	}

	public void flatMapConcatenating() {
		List<Integer> listA = Stream.of(1, 2, 3).collect(Collectors.toList());
		List<Integer> listB = Stream.of(4, 5, 6).collect(Collectors.toList());
		Stream.of(listA, listB).flatMap(List::stream).forEach(System.out::println);
	}

}
