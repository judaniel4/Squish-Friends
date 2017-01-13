/*
The super class for all the different chess pieces.
Includes the following instance variables:
1. public boolean isAlive
Includes the following methods:
1. public abstract canMove
 */
public abstract class Squishies{
    public Boolean isAlive;
    public String color;
    public int xCoord;
    public int yCoord;
    public abstract boolean canMove(int startX, int startY, int destinationX, int desinationY);
}
