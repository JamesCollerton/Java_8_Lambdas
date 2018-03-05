import java.util.stream.*;
import java.util.*;

public class Exercise5 {

	public static void main(String[] args) {
		//new MethodReferences();
		
		longestName();
		
	}

	public static void longestName() {
	
		Stream<String> namesOne = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
		longestNameReduce(namesOne);	
		
		Stream<String> namesTwo = Stream.of("John Lennon", "Paul McCartney", "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");
		longestNameCollector(namesTwo);

	}

	public static void longestNameReduce(Stream<String> names) {
		System.out.println(names.reduce("", (curr, nex) -> {
			return curr.length() > nex.length() ? curr : nex;
		}));
	}
	
	public static void longestNameCollector(Stream<String> names) {
		System.out.println(names.collect(Collectors.maxBy(Comparator.comparing(String::length))).get());
	}

}
