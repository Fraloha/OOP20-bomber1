package bomberOne.model.user;

public class UserImpl implements User {

    private static final long serialVersionUID = -9028500705336408837L;
    private String name;
    private int score;
    private Skins skin;
    private Controls controls;

    public UserImpl() {

    }

    public UserImpl(final String userName, final int score) {
        this.name = userName;
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setScore(final int score) {
        this.score = score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSkin(final Skins skin) {
        this.skin = skin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Skins getSkin() {
        return this.skin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setControls(final Controls controls) {
        this.controls = controls;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Controls getControls() {
        return this.controls;
    }

}
