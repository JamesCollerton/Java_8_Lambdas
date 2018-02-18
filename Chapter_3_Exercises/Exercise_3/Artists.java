import java.util.stream.*;
import java.util.*;

public class Artists {
	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		this.artists = artists;
	}

	public Optional<Artist> getArtist(int index) {
		try {
			return Optional.of(artists.get(index));
		} catch(IndexOutOfBoundsException e) {
			return Optional.empty();	
		}
	}

	private void indexException(int index) {
		throw new IllegalArgumentException(index +
		" doesn't correspond to an Artist");
	}

	public String getArtistName(int index) {
		Optional<Artist> artist = getArtist(index);
		return artist.isPresent() ? artist.get().getName() : "unknown";
	}
}
