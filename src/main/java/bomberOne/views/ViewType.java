package bomberOne.views;

public enum ViewType {

	HOME,
	SETUP,
	GAME,
	RANK;
	
	private String path;
	
	public String getPath() {
		return this.path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
