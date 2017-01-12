/*
Function: to initiate players, set the boards, and reset 
Attributes:
1. Current Player
Methods:
1. Initiates two instances of class Player and sets color and name for them
2. setBoard: sets up board
3. reset: 
 */
import Player.java;

public class SquishyChess{
    public String currentPlayer;
    public int numSwitch;
    public static void main(String[] args){
	public String startMessage{
	    s += 
	Player player0 = new Player;
	Player player1 = new Player;
	
	
    }
    public void firstMove(Player a, Player b){
	if (a.color == white){
	    numSwitch = 0;
	    a.move();
	}
	else{
	    numSwitch = 1;
	    b.move();
	}
    }
    public void afterFirst(Player a, Player b){
	while(a.checkmate == false && b.checkmate == false){
	    if(numSwitch == 1){
		a.move();
		numSwitch --;
	    }
	    else{
		b.move();
		numSwitch ++;
	    }
	}
    }
}
