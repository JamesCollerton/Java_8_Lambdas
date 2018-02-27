import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Partitioning {

	public static void main(String[] args) {

		Artist artA = new Artist("A", 1);
		Artist artB = new Artist("B", 2);
		Predicate<Artist> band = a -> a.getNumBandMembers() > 1;
		Map<Boolean, List<Artist>> partitioned = Stream.of(artA, artB).
								collect(Collectors.partitioningBy(band));

		partitioned.forEach((k, v) -> {
			System.out.println("Key " + k);
			v.forEach(a -> System.out.println(a.getName()));
			System.out.println();
		});

	}

}
