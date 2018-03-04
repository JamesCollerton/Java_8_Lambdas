import java.util.*;
import java.util.stream.*;

public class Grouping {

	public static void main(String[] args) {

		Artist artA = new Artist("A");
		Artist artB = new Artist("B");
		Artist artC = new Artist("B");

		Map<String, List<Artist>> bands = Stream.of(artA, artB, artC).collect(Collectors.groupingBy(a -> a.getBand()));
	
		bands.forEach((k, v) -> {
			System.out.println("Key " + k);
			v.forEach(a -> System.out.println(a.getBand()));
		});

	}

}
