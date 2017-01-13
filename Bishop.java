/*
Bishop

Attributes:

pieceType is Queen

Limits(moving): can move diagonally in a straight line.  Cannot jump over other pieces.

Let k = an integer in the subset [1,7]

-(x,y) --> (x-k,y-k)
-(x,y) --> (x+k,y+k)
-(x,y) --> (x-k,y+k)
-(x,y) --> (x+k,y-k)


 */

public class Bishop extends Squishies
{

    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	//checks to see if the position entered is a possible move for a bishop.
	if ((destinationX-startX) == (destinationY-startY))
	    {
		//if the bishop is moving diagonally in a straight line, it is a valid move.
		return true;
	    }
	if ((destinationX-startX) == ((destinationY-startY)* -1))
	    {
		//if the bishop is moving diagonally in a straight line, it is a valid move.
		return true;
	    }
	else
	    {
		return false;
	    }

    }
}    

