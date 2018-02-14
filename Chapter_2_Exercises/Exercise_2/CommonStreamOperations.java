import java.util.stream.*;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

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

	public Integer countMembers(List<Artist> artists) {
		return artists.stream()
				.mapToInt(artist -> artist.getMembers().size())
				.sum();
	}

	public static Integer countLowerCaseLetters(String input) {
		return Math.toIntExact(
				IntStream.range(0, input.length()) 
					.filter(i -> Character.isLowerCase(input.charAt(i)))
					.count()
		);
	}

	public static Optional<String> maxLowerCaseLetters(List<String> input) {
		if (input.isEmpty()) return Optional.empty();
		return Optional.of(
			IntStream.range(0, input.size())
					.reduce((i, j) -> {
						return countLowerCaseLetters(input.get(i)) > countLowerCaseLetters(input.get(j)) ? input.get(i) : input.get(j);
					})
		);
	}

}
