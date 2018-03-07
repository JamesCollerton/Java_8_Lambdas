import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Exercise5 {

	public static void main(String[] args) {
		//new MethodReferences();
		
		longestName();
		countNames();	
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

	public static void countNames() {
		Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");
		names.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> {
			System.out.println("Key " + k + " Value " + v);
		});	
	}
}
