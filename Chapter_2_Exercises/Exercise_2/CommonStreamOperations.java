import java.util.stream.*;
import java.util.List;

public class CommonStreamOperations {

	public Long addUp(Stream<Integer> numbers) {
		return numbers.count();
	}

	public List<String> namesOrigins(List<Artist> artists) { 
		return artists.stream()
				.map(a -> "Name: " + a.getName() + " Origin " + a.getOrigin())
				.collect(Collectors.toList());
	}

	public List<Album> filterAlbums(List<Album> albums) {
		return albums.stream()
				.filter(album -> album.getTrackCount() > 3)
				.collect(Collectors.toList());
	}

}
