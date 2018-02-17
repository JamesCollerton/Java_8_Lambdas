import java.util.stream.*;
import java.util.*;

public class Exercise2 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Stream.of("One", "Two", "Three").forEach(x -> list.add(x));

		CommonStreamOperations.map(list.stream(), (String x) -> x.toUpperCase())
					.stream()
					.forEach(System.out::println);
		
		CommonStreamOperations.filter(list.stream(), (String x) -> "One".equals(x))
					.stream()
					.forEach(System.out::println);
	}

}
