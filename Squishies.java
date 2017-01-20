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
	canMove(eater.xCoord, eater.yCoord, piece.xCoord, piece.YCoord){
	}
    }
    public boolean isCheck(King Henry, Squishies eat){
	return canEat(Henry, eat);
    }
    public boolean checkMate(King Louis, Squishies yum, Squishies checker;Board currentBoard){
	//first criteria for checkmate: King must be in check
	if(isCheck(Louis, checker)){
	    for(int x = 0; x < currentBoard.length; x ++){
		for(int y = 0; y < currentBoard[0].length; y ++){
	    //second criteria for checkmate: King cannot move to somewhere where he will be in check
		    if((canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord) && (canEat(Louis, yum))) || (canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord + 1) && (canEat(Louis, yum))) || (canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord) && (canEat(Louis, yum))) || (canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord - 1) && (canEat(Louis, yum))) || (canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord + 1) && (canEat(Louis, yum)))||(canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord - 1) && (canEat(Louis, yum)))||(canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord - 1) && (canEat(Louis, yum)))||(canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord + 1) && (canEat(Louis, yum)))){
		//third criteria for checkmate: Pieces cannot move somewhere that would take the King out of check
			for(int x = 0; x < currentBoard.length; x ++){
			    for(int y = 0; y < currentBoard[0].length; y ++){
			//iterate through the board to check if the piece can move between the king and the piece
				if (!noPieceThere(x, y, currentBoard)){
				    String currentPiece = currentBoard[x][y];
				    if(canEat(yum, currentPiece)){
					return false;
					}
				    if(yum.pieceType == "Queen"){
					//code here
					}
				    if(yum.pieceType == "Bishop"){
					//code here
					}
				    if(yum.pieceType == "Knight"){
					//code here
					}
				    if(yum.pieceType == "Rook"){
					//code here
					}
				    if(yum.pieceType == "Pawn"){
					//code here
					}
				}
			    }
			}
		    }
		}
	    }
	}
    }
}
