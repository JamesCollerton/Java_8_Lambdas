import java.util.stream.*;
import java.util.*;

public interface Performance {

	public String getName();

	public Stream<Artist> getMusicians();
	
	public default Stream<Artist> getAllMusicians() {
		return Stream.concat(getMusicians(), getMusicians().flatMap(a -> a.getAllMusicians()));
	}

}
