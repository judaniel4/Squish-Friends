/*
Queen

Attributes:

pieceType is Queen

Limits(moving): in any direction in a straight line.  Cannot jump over other pieces.

Let k = an integer in the subset [1,7]
-(x,y) --> (x+k,y)
-(x,y) --> (x-k,y)
-(x,y) --> (x,y+k)
-(x,y) --> (x,y-k)
-(x,y) --> (x-k,y-k)
-(x,y) --> (x+k,y+k)
-(x,y) --> (x-k,y+k)
-(x,y) --> (x+k,y-k)

*/

public class Queen extends Squishies
{
    public Queen(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
	pieceType = "Queen";
	isAlive = true;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	//checks to see if the position entered is a possible move for a queen
	if(destinationY == startY || destinationX == startX){
	    //if the queen is moving horizontally or vertically in a straight line, it is a valid move.
	    return true && isAlive;
	    }

	if(destinationY-startY == destinationX-startX || destinationY-startY == startX-destinationX){
	    //if the queen is moving diagonally, it is a valid move.
	    return true && isAlive;
	}
	else{
	    return false;
	}
    }
}
