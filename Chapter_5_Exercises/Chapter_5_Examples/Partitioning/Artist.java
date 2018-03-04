public class Artist {

	private String name;
	private int numBandMembers;

	Artist(String name, int numBandMembers) {
		this.name = name;
		this.numBandMembers = numBandMembers;
	}

	public String getName() {
		return name;
	}

	public int getNumBandMembers() {
		return numBandMembers;
	}

}
