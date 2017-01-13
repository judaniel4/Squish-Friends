/*
Pawn

Function: to be the squishy squish

Attributes:
life is alive
pieceType Pawn

Limits(moving): first time, can move one or twice forward. Can only move one space at a time afterwards.  If it reaches the end of the board, it can become either a rook, bishop, knight, or queen.

-(x,y) --> (x,y+2)
-(x,y) --> (x,y+1)
-(x,y) --> (x+1,y+1)
-(x,y) --> (x-1,y+1)

Methods:

 */

public class Pawn extends Squishies
{
    public Pawn(int x, int y){
	xCoord = x;
	yCoord = y;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	//checks to see if position entered is a valid move for a pawn
	if((startY == 2) && (destinationY == 4))
	    {
		return true;
	    }
	if((destinationY-startY) == 1)
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }

}
