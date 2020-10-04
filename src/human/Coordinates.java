package human;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private float x; //Поле не может быть null
    private Integer y;

    public Coordinates(float x, int y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.valueOf(x) + " " + String.valueOf(y);
    }
}
