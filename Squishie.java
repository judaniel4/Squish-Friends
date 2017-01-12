import Board.java;

public abstract class Squishie{
    public Boolean isAlive;
    public String color;
    public int[] coordinate;
    public String type;
    public abstract Boolean canMove(int startx, int starty, int destix, int destiy){
	
    }
}
