/*
Rook

Attributes:

pieceType is rook

Limits(moving): can move either horizontally or vertically.  Cannot jump over other pieces.

Let k = an integer in the subset[1,7]
-(x,y) --> (x+k,y)
-(x,y) --> (x-k,y)
-(x,y) --> (x,y+k)
-(x,y) --> (x,y-k)

*/

public class Rook extends Squishies
{
    public Rook(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	//checks to see if the position entered is a possible move for a rook
	if((destinationY == startY) || (destinationX == startX))
	    {
		//if the rook is moving horizontally or vertically in a straight line, it is a valid move.
		return true;
	    }
	else
	    {
		return false;
	    }
    }
    
}
