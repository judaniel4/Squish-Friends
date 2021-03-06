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
		if(!Woo.one.color.equals(Louis.color)){		    
			if(Woo.one.Q.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.one.Q.yCoord){
				for(int y = Louis.yCoord; y <= Woo.one.Q.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.one.Q.yCoord){
				for(int y = Woo.one.Q.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.Q.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.Q.xCoord){
				for(int x = Louis.xCoord; x <= Woo.one.Q.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.yCoord > Woo.one.Q.yCoord){
				for(int x = Woo.one.Q.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}
			if (Louis.xCoord > Woo.one.Q.xCoord && Louis.yCoord >  Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX>qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.one.color, qX, qY); 
				qX++;
				qY++;
			    }
			}
			if (Louis.xCoord < Woo.one.Q.xCoord && Louis.yCoord < Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX<qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.Q.xCoord && Louis.yCoord > Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX<qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, qY); 
				kingX++;
				qY++;
			    }
			}
			if (Louis.xCoord > Woo.one.Q.xCoord && Louis.yCoord < Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX>qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.one.color, qX, kingY); 
				qX++;
				kingY++;
			    }
			}
		    }
		if(!Woo.two.color.equals(Louis.color)){		    
			if(Woo.two.Q.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.two.Q.yCoord){
				for(int y = Louis.yCoord; y <= Woo.two.Q.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.two.Q.yCoord){
				for(int y = Woo.two.Q.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.Q.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.Q.xCoord){
				for(int x = Louis.xCoord; x <= Woo.two.Q.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.yCoord > Woo.two.Q.yCoord){
				for(int x = Woo.two.Q.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}
			if (Louis.xCoord > Woo.two.Q.xCoord && Louis.yCoord >  Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX>qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.two.color, qX, qY); 
				qX++;
				qY++;
			    }
			}
			if (Louis.xCoord < Woo.two.Q.xCoord && Louis.yCoord < Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX<qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.two.Q.xCoord && Louis.yCoord > Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX<qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.two.color, kingX, qY); 
				kingX++;
				qY++;
			    }
			}
			if (Louis.xCoord > Woo.two.Q.xCoord && Louis.yCoord < Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX>qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.two.color, qX, kingY); 
				qX++;
				kingY++;
			    }
			}
		    }
	    }
	    if (piece.equals("N")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(canMove(Woo.one.N1.xCoord, Woo.one.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N1.xCoord, Woo.one.N1.yCoord);
		    }
		    if(canMove(Woo.one.N2.xCoord, Woo.one.N2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N2.xCoord, Woo.one.N2.yCoord);
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){
		    if(canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.two.N1.xCoord, Woo.two.N1.yCoord);
		    }
		    if(canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.N2.xCoord, Woo.two.N2.yCoord);
		    }
		}
	    }
	    if (piece.equals("R")){
		if(!Woo.one.color.equals(Louis.color)){		    
		    if(canMove(Woo.one.R1.xCoord, Woo.one.R1.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.one.R1.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.one.R1.yCoord){
				for(int y = Louis.yCoord; y <= Woo.one.R1.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.one.R1.yCoord){
				for(int y = Woo.one.R1.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.R1.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.R1.xCoord){
				for(int x = Louis.yCoord; x <= Woo.one.R1.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.one.R1.xCoord){
				for(int x = Woo.one.R1.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		    if(canMove(Woo.one.R2.xCoord, Woo.one.R2.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.one.R2.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.one.R2.yCoord){
				for(int y = Louis.yCoord; y <= Woo.one.R2.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.one.R2.yCoord){
				for(int y = Woo.one.R2.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.R2.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.R2.xCoord){
				for(int x = Louis.yCoord; x <= Woo.one.R2.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.one.R2.xCoord){
				for(int x = Woo.one.R2.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){		    
		    if(canMove(Woo.two.R1.xCoord, Woo.two.R1.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.two.R1.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.two.R1.yCoord){
				for(int y = Louis.yCoord; y <= Woo.two.R1.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.two.R1.yCoord){
				for(int y = Woo.two.R1.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.R1.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.R1.xCoord){
				for(int x = Louis.yCoord; x <= Woo.two.R1.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.two.R1.xCoord){
				for(int x = Woo.two.R1.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		     if(canMove(Woo.two.R2.xCoord, Woo.two.R2.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.two.R2.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.two.R2.yCoord){
				for(int y = Louis.yCoord; y <= Woo.two.R2.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.two.R2.yCoord){
				for(int y = Woo.two.R2.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.R2.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.R2.xCoord){
				for(int x = Louis.yCoord; x <= Woo.two.R2.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.two.R2.xCoord){
				for(int x = Woo.two.R2.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}
		     }
		}
	    }
	    if(piece.equals("P")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(canMove(Woo.one.P1.xCoord, Woo.one.P1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P1.xCoord, Woo.one.P1.yCoord);
		    }
		    if(canMove(Woo.one.P2.xCoord, Woo.one.P2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P2.xCoord, Woo.one.P2.yCoord);
		    }
		    if(canMove(Woo.one.P3.xCoord, Woo.one.P3.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P3.xCoord, Woo.one.P3.yCoord);
		    }
		    if(canMove(Woo.one.P4.xCoord, Woo.one.P4.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P4.xCoord, Woo.one.P4.yCoord);
		    }
		    if(canMove(Woo.one.P5.xCoord, Woo.one.P5.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P5.xCoord, Woo.one.P5.yCoord);
		    }
		    if(canMove(Woo.one.P6.xCoord, Woo.one.P6.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P6.xCoord, Woo.one.P6.yCoord);
		    }
		    if(canMove(Woo.one.P7.xCoord, Woo.one.P7.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P7.xCoord, Woo.one.P7.yCoord);
		    }
		    if(canMove(Woo.one.P8.xCoord, Woo.one.P8.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P8.xCoord, Woo.one.P8.yCoord);
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){
		    if(canMove(Woo.two.P1.xCoord, Woo.two.P1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P1.xCoord, Woo.two.P1.yCoord);
		    }
		    if(canMove(Woo.two.P2.xCoord, Woo.two.P2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P2.xCoord, Woo.two.P2.yCoord);
		    }
		    if(canMove(Woo.two.P3.xCoord, Woo.two.P3.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P3.xCoord, Woo.two.P3.yCoord);
		    }
		    if(canMove(Woo.two.P4.xCoord, Woo.two.P4.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P4.xCoord, Woo.two.P4.yCoord);
		    }
		    if(canMove(Woo.two.P5.xCoord, Woo.two.P5.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P5.xCoord, Woo.two.P5.yCoord);
		    }
		    if(canMove(Woo.two.P6.xCoord, Woo.two.P6.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P6.xCoord, Woo.two.P6.yCoord);
		    }
		    if(canMove(Woo.two.P7.xCoord, Woo.two.P7.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P7.xCoord, Woo.two.P7.yCoord);
		    }
		    if(canMove(Woo.two.P8.xCoord, Woo.two.P8.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P8.xCoord, Woo.two.P8.yCoord);
		    }
		}
	    }
	    if (piece.equals("B")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(canMove(Woo.one.B1.xCoord, Woo.one.B1.yCoord, Louis.xCoord, Louis.yCoord)){
			if (Louis.xCoord + Louis.yCoord > Woo.one.B1.xCoord + Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX>b1X && kingY>b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, b1X, b1Y); 
				b1X++;
				b1Y++;
			    }
			}
			if (Louis.xCoord + Louis.yCoord < Woo.one.B1.xCoord + Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX<b1X && kingY<b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.B1.xCoord && Louis.yCoord > Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX<b1X && kingY>b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, b1Y); 
				kingX++;
				b1Y++;
			    }
			}
			if (Louis.xCoord > Woo.one.B1.xCoord && Louis.yCoord < Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX>b1X && kingY<b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, b1X, kingY); 
				b1X++;
				kingY++;
			    }
			}
		    }
		    if(canMove(Woo.one.B2.xCoord, Woo.one.B2.yCoord, Louis.xCoord, Louis.yCoord)){
			if (Louis.xCoord + Louis.yCoord > Woo.one.B2.xCoord + Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX>b2X && kingY>b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, b2X, b2Y); 
				b2X++;
				b2Y++;
			    }
			}
			if (Louis.xCoord + Louis.yCoord < Woo.one.B2.xCoord + Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX<b2X && kingY<b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.B2.xCoord && Louis.yCoord > Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX<b2X && kingY>b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, b2Y); 
				kingX++;
				b2Y++;
			    }
			}
			if (Louis.xCoord > Woo.one.B2.xCoord && Louis.yCoord < Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX>b2X && kingY<b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, b2X, kingY); 
				b2X++;
				kingY++;
			    }
			}
		    }
		}
	    }
	    if(!Woo.two.color.equals(Louis.color)){
		if(canMove(Woo.two.B1.xCoord, Woo.two.B1.yCoord, Louis.xCoord, Louis.yCoord)){
		    if (Louis.xCoord + Louis.yCoord > Woo.two.B1.xCoord + Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX>b1X && kingY>b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b1X, b1Y); 
			    b1X++;
			    b1Y++;
			}
		    }
		    if (Louis.xCoord + Louis.yCoord < Woo.two.B1.xCoord + Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX<b1X && kingY<b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
			    kingX++;
			    kingY++;
			}
		    }
		    if (Louis.xCoord < Woo.two.B1.xCoord && Louis.yCoord > Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX<b1X && kingY>b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, b1Y); 
			    kingX++;
			    b1Y++;
			}
		    }
		    if (Louis.xCoord > Woo.two.B1.xCoord && Louis.yCoord < Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX>b1X && kingY<b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b1X, kingY); 
			    b1X++;
			    kingY++;
			}
		    }
		}
		if(canMove(Woo.two.B2.xCoord, Woo.two.B2.yCoord, Louis.xCoord, Louis.yCoord)){
		    if (Louis.xCoord + Louis.yCoord > Woo.two.B2.xCoord + Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX>b2X && kingY>b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b2X, b2Y); 
			    b2X++;
			    b2Y++;
			}
		    }
		    if (Louis.xCoord + Louis.yCoord < Woo.two.B2.xCoord + Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX<b2X && kingY<b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
			    kingX++;
			    kingY++;
			}
		    }
		    if (Louis.xCoord < Woo.two.B2.xCoord && Louis.yCoord > Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX<b2X && kingY>b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, b2Y); 
			    kingX++;
			    b2Y++;
			}
		    }
		    if (Louis.xCoord > Woo.two.B2.xCoord && Louis.yCoord < Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX>b2X && kingY<b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b2X, kingY); 
			    b2X++;
			    kingY++;
			}
		    }
		}
	    }
	}
    return inCheck || !canEated || !kingMove;
    }
}

