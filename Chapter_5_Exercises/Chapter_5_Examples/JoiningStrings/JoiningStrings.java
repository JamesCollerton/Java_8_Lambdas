import java.util.stream.*;

public class JoiningStrings {

 	public static void main(String[] args) {

		Artist artA = new Artist("A");
		Artist artB = new Artist("B");
		Artist artC = new Artist("C");
		Artist artAA = new Artist("A");

		String bands = Stream.of(artA, artB, artC, artAA).
			map(a -> a.getBand()).
			collect(Collectors.joining(", ", "-", "-"));

		System.out.println(bands);

	}

}
