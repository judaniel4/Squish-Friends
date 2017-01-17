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

public class Woo{
    public String currentPlayer;
    public static int numSwitch;
    public static Board currentBoard;
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

    public static void printBoard(Player p){
	if (p.color.equals("white")){
	    currentBoard.flipBoard();
	}
	else {
	    currentBoard.printBoard();
	}
    }
    public static void main(String[] args){

	Scanner scanner = new Scanner(System.in);
	Woo currentGame = new Woo();
	 
	System.out.println("Hello, welcome to Squishy Chess! You will be player one and your opponent will be player 2. Please select a side, white or black. (White goes first).");
	
	String color = scanner.next();

	Player one = new Player(color.toLowerCase());

	Player two = new Player("white");

	if (color.toLowerCase().equals("white")){
	    two.color = "black";
	}
        currentBoard = new Board();
	System.out.println("Here is the board:");
        printBoard(one);
	if (one.color.equals("white")){
	    numSwitch = 0;
	    System.out.println("Player one will go first since he/she is white. It is the first turn! Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
	    String firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    String Destination = scanner.next();
	    int coordX = Integer.parseInt(Destination.substring(0,1));
	    int coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (one.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(one);
	    numSwitch = 1;
	    System.out.println("It is Player two's (black) turn to move now!");
	    printBoard(two);
	    System.out.println("Please select a piece to move.");
	    firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    Destination = scanner.next();
	    coordX = Integer.parseInt(Destination.substring(0,1));
	    coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (two.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(two);
	}
	    
	else{
	    numSwitch = 1;
	    System.out.println("Player two will go first since he/she is white. It is the first turn! Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
	    String firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    String Destination = scanner.next();
	    int coordX = Integer.parseInt(Destination.substring(0,1));
	    int coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (two.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(two);
	    numSwitch = 0;
	    System.out.println("It is Player one's (black) turn to move now!");
	    printBoard(one);
	    System.out.println("Please select a piece to move.");
	    firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    Destination = scanner.next();
	    coordX = Integer.parseInt(Destination.substring(0,1));
	    coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (one.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(one);
	
	}
	

	
    }
	

}