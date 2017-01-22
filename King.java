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
- (x,y) --> (x,y-1)

- (x,y) --> (x+1,y+1)
- (x,y) --> (x-1,y-1)
- (x,y) --> (x+1,y-1)
- (x,y) --> (x-1,y+1)
Limits(eating): in any direction, but only one space as long as that does no put the piece in danger

Methods:
isCheck?: checks if the king is in check
isCheckmate?: checks if the king is in checkmate and if true, releases end game message and declares who won. Asks if they want to reset
 */
import java.util.ArrayList;
public class King extends Squishies{
    public King(int x, int y, String C){
	xCoord = x;
	yCoord = y;
	color = C;
	pieceType = "King";
    }
    public boolean canMove(int startX, int startY, int destinationX, int destinationY){
	boolean retBoo = false;
	//checks to see if position entered is a valid move for a king
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
	//checks to see if the king will be in check if it moves to the position entered
	return retBoo && dangerCheck(this.color, destinationX, destinationY);
    }
    //Should return an Arraylist of which pieces are checking the King
    public ArrayList checkKing(){
	ArrayList<String> retArr = new ArrayList<String>(); 
	for(String[] row: Woo.currentBoard.getBoard()){
	    for(String piece: row){
		if (Woo.two.color.equals(this.color)){
		    if (!piece.equals("E")){
			if(piece.equals("Q"))
			    {
				if(canMove(Woo.two.Q.xCoord, Woo.two.Q.yCoord, this.xCoord, this.yCoord))
			       {
				    retArr.add("Q");
			       }
			    }
			if(piece.equals("P")){
			    if(canMove(Woo.one.P1.xCoord, Woo.one.P1.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P2.xCoord, Woo.two.P2.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P3.xCoord, Woo.two.P3.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P4.xCoord, Woo.two.P4.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P5.xCoord, Woo.two.P5.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P6.xCoord, Woo.two.P6.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P7.xCoord, Woo.two.P7.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.P8.xCoord, Woo.two.P8.yCoord, this.xCoord, this.yCoord))
				{
				    retArr.add("P");
				}
			}
			if(piece.equals("N")){
			    if(canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.N2.xCoord, Woo.two.N2.yCoord, this.xCoord, this.yCoord))
				{
				    retArr.add("N");
				}
			}
			if(piece.equals("B")){
			    if (canMove(Woo.one.B1.xCoord, Woo.one.B1.yCoord, this.xCoord, this.yCoord)
				|| canMove(Woo.two.B2.xCoord, Woo.two.B2.yCoord, this.xCoord, this.yCoord))
				{
				    retArr.add("B");	    
				}
			}
			if(piece.equals("R")){
			    if(canMove(Woo.one.R1.xCoord, Woo.one.R1.yCoord, this.xCoord, this.yCoord)
			       || canMove(Woo.two.R2.xCoord, Woo.two.R2.yCoord, this.xCoord, this.yCoord))
				{
				    retArr.add("R");
				}
			}
			if(piece.equals("K")){
			    if (canMove(Woo.one.K.xCoord, Woo.one.K.yCoord, this.xCoord, this.yCoord)){
				retArr.add("K");
			    }
			}
		    }
		}
	    }
	}
	return retArr;
    }
}
