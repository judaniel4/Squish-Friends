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
    public String pieceType;
    public abstract boolean canMove(int startX, int startY, int destinationX, int desinationY);
    public boolean canEat(Squishies food, Squishies eater){
	return canMove(eater.xCoord, eater.yCoord, food.xCoord, food.yCoord);
    }
    public boolean dangerCheck(String colour, int x, int y){
	boolean retBoo = false;
	for(String[] row: Woo.currentBoard.getBoard()){
	    for(String piece: row){
		if (Woo.one.color.equals(colour)){
		    if (!piece.equals("E")){
			if(piece.equals("Q")){
			    retBoo = retBoo || canMove(Woo.one.Q.xCoord, Woo.one.Q.yCoord, x, y);
			}
			if(piece.equals("P")){
			    retBoo = retBoo || canMove(Woo.one.P1.xCoord, Woo.one.P1.yCoord, x, y)
				|| canMove(Woo.one.P2.xCoord, Woo.one.P2.yCoord, x, y)
				|| canMove(Woo.one.P3.xCoord, Woo.one.P3.yCoord, x, y)
				|| canMove(Woo.one.P4.xCoord, Woo.one.P4.yCoord, x, y)
				|| canMove(Woo.one.P5.xCoord, Woo.one.P5.yCoord, x, y)
				|| canMove(Woo.one.P6.xCoord, Woo.one.P6.yCoord, x, y)
				|| canMove(Woo.one.P7.xCoord, Woo.one.P7.yCoord, x, y)
				|| canMove(Woo.one.P8.xCoord, Woo.one.P8.yCoord, x, y);
			}
			if(piece.equals("N")){
			    retBoo = retBoo || canMove(Woo.one.N1.xCoord, Woo.one.N1.yCoord, x, y)
				|| canMove(Woo.one.N2.xCoord, Woo.one.N2.yCoord, x, y);
			}
			if(piece.equals("B")){
			    retBoo = retBoo || canMove(Woo.one.B1.xCoord, Woo.one.B1.yCoord, x, y)
			    || canMove(Woo.one.B2.xCoord, Woo.one.B2.yCoord, x, y);
			}
			if(piece.equals("R")){
			    retBoo = retBoo || canMove(Woo.one.R1.xCoord, Woo.one.R1.yCoord, x, y)
				|| canMove(Woo.one.R2.xCoord, Woo.one.R2.yCoord, x, y);
			}
			if(piece.equals("K")){
			    retBoo = retBoo || canMove(Woo.one.K.xCoord, Woo.one.K.yCoord, x, y);
			}
		    }
		}
		if (Woo.two.color.equals(colour)){
		    if (!piece.equals("E")){
			if(piece.equals("Q")){
			    retBoo = retBoo || canMove(Woo.two.Q.xCoord, Woo.two.Q.yCoord, x, y);
			}
			if(piece.equals("P")){
			    retBoo = retBoo || canMove(Woo.two.P1.xCoord, Woo.two.P1.yCoord, x, y)
				|| canMove(Woo.two.P2.xCoord, Woo.two.P2.yCoord, x, y)
				|| canMove(Woo.two.P3.xCoord, Woo.two.P3.yCoord, x, y)
				|| canMove(Woo.two.P4.xCoord, Woo.two.P4.yCoord, x, y)
				|| canMove(Woo.two.P5.xCoord, Woo.two.P5.yCoord, x, y)
				|| canMove(Woo.two.P6.xCoord, Woo.two.P6.yCoord, x, y)
				|| canMove(Woo.two.P7.xCoord, Woo.two.P7.yCoord, x, y)
				|| canMove(Woo.two.P8.xCoord, Woo.two.P8.yCoord, x, y);
			}
			if(piece.equals("N")){
			    retBoo = retBoo || canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, x, y)
				|| canMove(Woo.two.N2.xCoord, Woo.two.N2.yCoord, x, y);
			}
			if(piece.equals("B")){
			    retBoo = retBoo || canMove(Woo.two.B1.xCoord, Woo.two.B1.yCoord, x, y)
			    || canMove(Woo.two.B2.xCoord, Woo.two.B2.yCoord, x, y);
			}
			if(piece.equals("R")){
			    retBoo = retBoo || canMove(Woo.two.R1.xCoord, Woo.two.R1.yCoord, x, y)
				|| canMove(Woo.two.R2.xCoord, Woo.two.R2.yCoord, x, y);
			}
			if(piece.equals("K")){
			    retBoo = retBoo || canMove(Woo.two.K.xCoord, Woo.two.K.yCoord, x, y);
			}
		    }
		}
	    }
	}
	return retBoo;
    }
    public boolean isCheck(King Henry){
	return dangerCheck(Henry.color, Henry.xCoord, Henry.yCoord);
    }
    public boolean checkMate(King Louis, Squishies blocker, Squishies checker, Board currentBoard){
	boolean retBoo = true;
	//Checks to see if the king is in check
	boolean inCheck = isCheck(Louis);
	//Checks to see if the king can move out of check
	boolean kingMove = canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord + 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord - 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord - 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord + 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord - 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord + 1) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord) ||
	    canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord);
	//Checks to see if the piece can be eated
	boolean canEated = true;
	for(String piece: Louis.checkKing()){
	    if (piece.equals("Q")){
		//ur fucked mate
	    }
	    if (piece.equals("N")){
		if(canMove(Woo.one.N1.xCoord, Woo.one.N1.yCoord, Louis.xCoord, Louis.yCoord)){
		    canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N1.xCoord, Woo.one.N1.yCoord);
		}
		if(canMove(Woo.one.N2.xCoord, Woo.one.N2.yCoord, Louis.xCoord, Louis.yCoord)){
		    canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N2.xCoord, Woo.one.N2.yCoord);
		}
		if(canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, Louis.xCoord, Louis.yCoord)){
		    canEated = canEated && dangerCheck(Woo.one.color, Woo.two.N1.xCoord, Woo.two.N1.yCoord);
		}
		if(canMove(Woo.one.N1.xCoord, Woo.one.N1.yCoord, Louis.xCoord, Louis.yCoord)){
		    canEated = canEated && dangerCheck(Woo.two.color, Woo.two.N2.xCoord, Woo.two.N2.yCoord);
		}
	    }
	}
	return retBoo || inCheck || kingMove || canEated;
    }
}
