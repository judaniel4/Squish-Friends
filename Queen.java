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
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY)
    {
	//checks to see if the position entered is a possible move for a queen
	if(destinationY == startY){
		//if the queen is moving horizontally or vertically in a straight line, it is a valid move.
	    if(startX < destinationX){
		for(int x = startX; x < destinationX; x ++){
		    if(noPieceThere(x + 1, startY, Woo.currentBoard)){
			return true;
		    }
		}
	    }
	    else{
		for(int y = startX; y > destinationY; y--){
		    if(noPieceThere(y - 1, startY, Woo.currentBoard)){
			return true;
		    }
		}
	    }
	}	
	
	 if(destinationX == startX){
	     if(startY < destinationY){
		 for(int x = startY; x < destinationY; x ++){
		     if(noPieceThere(startX, x + 1, Woo.currentBoard)){
			 return true;
		     }
		 }
	     }
	     if(startY > destinationY){
		 for(int y = startY; y > destinationY; y --){
		     if(noPieceThere(startX, y - 1, Woo.currentBoard)){
			 return true;
		     }
		 }
	     }
	 }

	 /*
	if ((destinationX-startX) == (destinationY-startY)){
	    if(((destinationX - startX) > 0) && ((destinationY - startY)) > 0){
		for(
		    

	    }
	 */
	if ((destinationX-startX) == ((destinationY-startY)* -1))
	    {
		//if the queen is moving diagonally in a straight line, it is a valid move.
		return true;
	    }
	else
	    {
		return false;
	    }
    }
    
}
