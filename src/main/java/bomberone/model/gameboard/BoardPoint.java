package bomberone.model.gameboard;

public interface BoardPoint {

    int getX();

    int getY();

    void setX(final int newX);

    void setY(final int newY);
    
    void setPoint(final int newX, final int newY);
    
    boolean isEquals(final BoardPoint pointToCheck);
}
