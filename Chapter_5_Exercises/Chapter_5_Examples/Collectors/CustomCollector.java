import java.util.stream.*;
import java.util.*;
import java.util.function.*;

// http://blog.indrek.io/articles/creating-a-collector-in-java-8/

// This collector is going to collect a group of artists and 
// return their names.
public class CustomCollector implements Collector<Artist, List<String>, List<String>> {

	// The supplier() must return a function that creates an empty accumulator. This 
	// will also represent the result of the collection process when applied on an 
	// empty stream. Basically this is the seed for the accumulation. Notice that it
	// isn't returning the actual empty arraylist itself, but is actually returning
	// the function to make the empty arraylist.
	@Override
	public Supplier<List<String>> supplier() {
		return ArrayList::new;
	};
 	
	// The job of the accumulator() is to return a function which performs the reduction 
	// operation. It accepts two arguments. First one being the mutable result container 
	// (accumulator) and the second one the stream element that should be folded into the 
	// result container.

	// BiConsumer<Map<Integer, Integer>, Double>
	@Override
	public BiConsumer<List<String>, Artist> accumulator() {
		return (list, artist) -> list.add(artist.getName());
	};

	// The finisher() method needs to return a function which transforms the accumulator 
	// to the final result. In this case, the accumulator is the final result as well. 
	// Therefore it is possible to return the identity function.
	@Override
    	public Function<List<String>, List<String>> finisher() {
		return Function.identity();
	};

	// Two more methods need to be implemented. The combiner() method is used when 2 maps 
	// are merged. This can happen when you process the stream in parallel. When merging 
	// maps, the values for the same keys should be summed.
	@Override
    	public BinaryOperator<List<String>> combiner() {
		return (listA, listB) -> {
			listA.addAll(listB);
			return listA;
		};
	};

	@Override
    	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	};	

}
