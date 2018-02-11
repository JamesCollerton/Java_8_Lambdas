import java.util.function.Predicate;

public class Exercise_1 {

	public static void main(String[] args) {
		calculatorExample();
		inferenceExample();
	}

	public static void calculatorExample() {
		System.out.println(Calculator.abs.apply(-1));
	}

	public static void inferenceExample() {

		// Inferrable because they are both void and no type confusion
		Runnable helloWorld = () -> System.out.println("hello world");

		// Will both work	
		checkOne(x -> x > 5);	
		checkTwo(x -> x > 5);	
	
	}

	public static boolean checkOne(IntPred predicate) {
		return true;	
	};

	public static boolean checkTwo(Predicate<Integer> predicate) {
		return true;
	};

}
