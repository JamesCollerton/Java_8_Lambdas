import java.util.ArrayList;

public class StreamsExample {

	public static void main(String[] args) {
		streamExample();
	}

	public static void streamExample() {
		
		ArrayList<String> arrList = new ArrayList<>();
		arrList.add("One");
		arrList.add("Two");
		arrList.add("Three");

		arrList.stream().filter(x -> "One".equals(x)).forEach(x -> System.out.println(x));

	}

}
