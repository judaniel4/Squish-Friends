/*
The super class for all the different chess pieces.
Includes the following instance variables:
1. public boolean isAlive
Includes the following methods:
1. public abstract canMove
 */
public abstract class Squishies{
    public Boolean isAlive;
    public int xCoord;
    public int yCoord;
    public String color;
    public abstract boolean canMove(int startX, int startY, int destinationX, int desinationY);
    public boolean noPieceThere(int x, int y, Board z)
    {
	if(z.board[x][y] == "E")
	    {
		return true;
	    }
    } 
}
