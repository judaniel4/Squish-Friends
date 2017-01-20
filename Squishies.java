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
    public abstract boolean canMove(int startX, int startY, int destinationX, int desinationY);
    public boolean canEat(Squishies piece){
	canMove(xCoord, yCoord, piece.xCoord, piece.YCoord){
    }
    public boolean isCheck(King Henry){
	return canEat(Henry);
	
    }
    public boolean checkMate(King Louis){
	if(isCheck(Louis)){
	    if((canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord) && (canEat(Louis))) || 
}
