package model;

public class Position {
    private final Integer x;
    private final Integer y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer[] getPosition()
    {
        return new Integer[]{x, y};
    }
}
