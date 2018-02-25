import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class Collectors {

	public static void main(String[] args) {

		Artist artistA = new Artist("A");
		Artist artistB = new Artist("B");
		Stream.of(artistA, artistB).collect(new CustomCollector()).forEach(System.out::println);		

	}

}
