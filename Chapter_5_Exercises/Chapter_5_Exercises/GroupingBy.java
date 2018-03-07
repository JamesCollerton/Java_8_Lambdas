import java.util.stream.*;
import java.util.*;
import java.util.function.*;

public class GroupingBy<T, K> implements Collector<T, Map<K, List<T>>, Map<K, List<T>>> {

	private Function<T, K> f;

	GroupingBy(Function<T, K> f) {
		this.f = f;
	}

	@Override
	public Supplier<Map<K, List<T>>> supplier() {
		return HashMap<K, List<T>>::new;
	}

	@Override
	public BiConsumer<Map<K, List<T>>, T> accumulator() {	
		return (a, b) -> {
			if(a.containsKey(b)) {
				a.get(b).add(b);
			} else {
				// Need a function here
				a.put(f.apply(b), Arrays.asList(b));
			}
		}; 
	}

	@Override
    	public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
		return Function.identity();
	};

	@Override
    	public BinaryOperator<Map<K, List<T>>> combiner() {
		return (mapA, mapB) -> {
			mapA.forEach((k, v) -> mapB.merge(k, v, v.addAll(mapB.get(k))));
		};
	};

	@Override
    	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	};

}
