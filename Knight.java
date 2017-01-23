/*
Knight
Function: to be squish and take some L's.

Limits(moving): in any direction in an L shape.
Note: knights are the only pieces that can jump over other pieces.
-(x,y) --> (x+2, y-1)
-(x,y) --> (x+2, y+1)
-(x,y) --> (x-2, y-1)
-(x,y) --> (x-2, y+1)
-(x,y) --> (x+1, y-2)
-(x,y) --> (x+1, y+2)
-(x,y) --> (x-1, y-2)
-(x,y) --> (x-1, y+2)

Limits(eating): in any direction, but the piece must be at the end of an L shape


 */ 

public class Knight extends Squishies
{
    public Knight(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
	pieceType = "Knight";
	isAlive = true;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	boolean retBoo = false;
	//checks to see if the position entered is a possible move for a knight.
	if((startX-destinationX)==2 || (startX-destinationX)==-2)
	    {
		if ((startY-destinationY)==1 || (startY-destinationY)==-1)
		    {
			retBoo = true;
		    }
	    }
	if((startX-destinationX)==1 || (startX-destinationX)==-1)
	    {
		if ((startY-destinationY)==2 || (startY-destinationY)==-2)
		    {
			retBoo = true;
		    }
	    }
	return retBoo && isAlive;
	    
    }
}
