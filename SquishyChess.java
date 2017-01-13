/*
Function: to initiate players, set the boards, and reset 
Attributes:
1. Current Player
Methods:
1. Initiates two instances of class Player and sets color and name for them
2. setBoard: sets up board
3. reset: 
 */
import java.util.Scanner;

public class SquishyChess{
    public String currentPlayer;
    public int numSwitch;

    public void firstMove(Player a, Player b){
	if (a.color == "white"){
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
    public static void main(String[] args){

	 Scanner scanner = new Scanner(System.in);
	 SquishyChess currentGame = new SquishyChess();
	 
	System.out.println("Hello, welcome to Squishy Chess! Please select a side, white or black. (White goes first).");
	
	String color = scanner.next();

	Player one = new Player(color.toLowerCase());

	if (color.toLowerCase() == "white"){
	    Player two = new Player("black");
	}

	Player two = new Player("white");

	one.instantiatePieces();
	two.instantiatePieces();

        currentGame.firstMove(one, two);

	
    }
}
