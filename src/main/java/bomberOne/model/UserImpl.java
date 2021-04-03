package bomberOne.model;

public class UserImpl implements User {

	
	private static final long serialVersionUID = -9028500705336408837L;
	private String name;
	private int score;
	private Skins skin;
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getScore() {
		return this.score;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void setSkin(Skins skin) {
		this.skin = skin;
	}

	@Override
	public Skins getSkin() {
		return this.skin;
	}

}
