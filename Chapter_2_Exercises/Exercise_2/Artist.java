import java.util.List;

public class Artist {

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

}
