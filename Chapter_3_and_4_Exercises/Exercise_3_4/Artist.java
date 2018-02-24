import java.util.stream.*;
import java.util.*;

public class Artist implements Performance {

	private String name;
	private String origin;
	private List<Artist> members;

	public Artist(String name, String origin) {
		this.name = name;
		this.origin = origin;
	}

	public String getName() { return name; }
	
	public String getOrigin() { return origin; }

	public List<Artist> getMembers() { return members; }

	public Stream<Artist> getMusicians(){ return members.stream(); };

}
