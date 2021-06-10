package bomberone.model.gameboard;

public interface BoardPoint {

    int getX();

    int getY();

    void setX(int newX);

    void setY(int newY);

    void setPoint(int newX, int newY);

    boolean isEquals(BoardPoint pointToCheck);
}
