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
		return (map, element) -> {
			K key = f.apply(element);
			List<T> elements = map.computeIfAbsent(key, k -> new ArrayList<>());
			elements.add(element);
		}; 
	}

	@Override
    	public Function<Map<K, List<T>>, Map<K, List<T>>> finisher() {
		return Function.identity();
	};

	@Override
    	public BinaryOperator<Map<K, List<T>>> combiner() {
		return (mapA, mapB) -> {
			mapA.forEach((k, v) -> {
				mapB.merge(k, v, (leftValue, rightValue) -> {
					leftValue.addAll(rightValue);
					return leftValue;
				});
			});
			return mapB;
		};
	};

	@Override
    	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	};

}
