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
    public Pawn(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	boolean retBoo = false;
	//checks to see if position entered is a valid move for a pawn
	if(((startY == 1) && (destinationY == 3) && (startX == destinationX)) || ( (startY == 6) && (destinationY == 4) && (startX == destinationX)))
	    {
		//if the pawn has not moved yet and the player would like to move it two spaces forwards, it is a valid move.
		retBoo = true;
	    }
	if((((destinationY-startY) == 1) && (startX == destinationX))|| ((destinationY-startY) == -1) && (startX == destinationX))
	    {
		//if the player would like to move the pawn forward one space, then it is a valid move.
		retBoo = true;
	    }
	return retBoo;
    }

}
