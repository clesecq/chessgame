package model;

public class Position {
    private Integer x;
    private Integer y;

    public Position(Integer x, Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer[] getPosition()
    {
        return new Integer[]{x, y};
    }
}
