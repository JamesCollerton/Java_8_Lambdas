import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

	public static void main(String[] args) {
		streamExample();
		collectMapFilterExample();
		flatMapExample();
	}

	public static ArrayList<String> createList() {
		ArrayList<String> arrList = new ArrayList<>();

		arrList.add("One");
		arrList.add("Two");
		arrList.add("Three");

		return arrList;
	}

	public static void streamExample() {
		ArrayList<String> arrList = createList();
		arrList.stream().filter(x -> "One".equals(x)).forEach(x -> System.out.println(x));
	}

	public static void collectMapFilterExample() {
		ArrayList<String> arrList = createList();
		List<String> newList = arrList.stream()
						.filter(x -> !"One".equals(x))
						.map(x -> x.toUpperCase())
						.collect(Collectors.toList());
		newList.stream().forEach(x -> System.out.println(x));
	}

	public static void flatMapExample() {
		ArrayList<String> arrList = createList();
		ArrayList<ArrayList<String>> arrArrList = new ArrayList<ArrayList<String>>();

		arrArrList.add(arrList);
		arrArrList.add(arrList);
		arrArrList.add(arrList);

		// It does pass by reference!
		arrList.set(2, "New");

		arrArrList.stream()
			.flatMap(x -> x.stream())
			.collect(Collectors.toList())
			.forEach(x -> System.out.println(x));		

	}

}
