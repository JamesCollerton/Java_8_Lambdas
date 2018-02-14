import java.util.stream.*;
import java.util.*;

public class Exercise2 {

	public static void main(String[] args) {

		System.out.println(CommonStreamOperations.countLowerCaseLetters("Hello"));

		List<String> list = new ArrayList<String>();

		System.out.println("" + CommonStreamOperations.maxLowerCaseLetters(list));

		Stream.of("hello", "HELLO").forEach(c -> list.add(c));

		System.out.println("" + CommonStreamOperations.maxLowerCaseLetters(list));
		
	}

}
