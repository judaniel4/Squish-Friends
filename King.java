/*
King  
Function: to be the squishiest of them all
Attributes:
sets life to alive
pieceType is king
Limits(moving): in any direction but only one space as long as that does not put the piece in danger
- (x,y) --> (x+1,y)
- (x,y) --> (x,y+1)
- (x,y) --> (x-1,y)
- (x,y) --> (x, y-1)
Limits(eating): in any direction, but only one space as long as that does no put the piece in danger

Methods:
isCheck?: checks if the king is in check
isCheckmate?: checks if the king is in checkmate and if true, releases end game message and declares who won. Asks if they want to reset
 */
public class King extends Squishies{
    public King(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY){
	boolean retBoo = false;
	if (startY==destinationY){
	    if (startX-destinationX == 1 || destinationX-startX==1){
		retBoo = true;
	    }
	}
	if(startX==destinationX){
	    if(startY-destinationY == 1 || destinationY-startY==1){
		retBoo = true;
	    }
	}
	if(startX-destinationX == 1 || destinationX-startX == 1){
	     if(startY-destinationY == 1 || destinationY-startY==1){
		 retBoo = true;
	     }
	}
	return retBoo;
    }
}
