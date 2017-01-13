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
	    //a.move();
	}
	else{
	    numSwitch = 1;
	    // b.move();
	}
    }
    public void afterFirst(Player a, Player b){
	
	if(numSwitch == 1){
	    //a.move();
	    numSwitch --;
	}
	else{
	    //b.move();
	    numSwitch ++;
	}
    }
    
    public static void main(String[] args){

	 Scanner scanner = new Scanner(System.in);
	 SquishyChess currentGame = new SquishyChess();
	 
	System.out.println("Hello, welcome to Squishy Chess! Please select a side, white or black. (White goes first).");
	
	String color = scanner.next();

	Player one = new Player(color.toLowerCase());

	Player two = new Player("white");

	if (color.toLowerCase() == "white"){
	    two.color = "black";
	}

        Board currentBoard = new Board();

	System.out.println("Here is the board:");
	if (color == "white"){
	    currentBoard.printBoard();
	}
	else {
	    currentBoard.flipBoard();
	    currentBoard.printBoard();
	}
	System.out.println("It is the first turn! Please select the piece you would like to move.");
	String firstMPiece = scanner.next();
        System.out.println("Please select the destination. Please use the format: x,y");
	String Destination = scanner.next();
	int coordX = Integer.parseInt(Destination.substring(0,1));
	int coordY = Integer.parseInt(Destination.substring(2,3));
	one.move(firstMPiece.toLowerCase(), coordX, coordY);
	//	while(one.checkmate == false && two.checkmate == false){
	    
	//	}
	    //currentGame.firstMove(one, two);

	
    }
}
