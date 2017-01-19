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
    public static int playerNum;
    public static Player one;
    public static Player two;
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

    public static void printBoard(int p){
	if (p == 0){
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

	if (color.toLowerCase().equals("white")){
	    one = new Player("white");
	    two = new Player("black");
	}
	else{
	    one = new Player("black");
	    two = new Player("white");
	}
        currentBoard = new Board();
	System.out.println("Here is the board:");
        printBoard(numSwitch);
	System.out.println(" ");
	if (one.color.equals("white")){
	    numSwitch = 0;
	    playerNum = 0;
	    System.out.println("Player one will go first since he/she is white. It is the first turn! Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
	    String firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
	    String Destination = scanner.next();
	    int coordX = Integer.parseInt(Destination.substring(0,1));
	    int coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (one.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(numSwitch);
	    System.out.println(" ");
	    numSwitch = 1;
	    playerNum = 1;
	    System.out.println("It is Player two's (black) turn to move now!");
	    printBoard(numSwitch);
	    System.out.println(" ");
	    System.out.println("Please select a piece to move.");
	    firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    Destination = scanner.next();
	    coordX = Integer.parseInt(Destination.substring(0,1));
	    coordY = Integer.parseInt(Destination.substring(2,3));
	    System.out.println(two.color);
	    System.out.println(two.P1.xCoord);
	    currentBoard = (two.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(numSwitch);
	    System.out.println(" ");
	}
	    
	else{
	    numSwitch = 0;
	    playerNum = 1;
	    System.out.println("Player two will go first since he/she is white. It is the first turn! Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
	    String firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    String Destination = scanner.next();
	    int coordX = Integer.parseInt(Destination.substring(0,1));
	    int coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (two.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(numSwitch);
	    System.out.println(" ");
	    numSwitch = 1;
	    playerNum = 0;
	    System.out.println("It is Player one's (black) turn to move now!");
	    printBoard(numSwitch);
	    System.out.println(" ");
	    System.out.println("Please select a piece to move.");
	    firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y");
	    Destination = scanner.next();
	    coordX = Integer.parseInt(Destination.substring(0,1));
	    coordY = Integer.parseInt(Destination.substring(2,3));
	    currentBoard = (one.move(firstMPiece.toLowerCase(), coordX, coordY, currentBoard));
	    System.out.println("Board After Move:");
	    printBoard(numSwitch);
	    System.out.println(" ");
	}
	while (one.checkmate == false && two.checkmate == false){
	    if (playerNum == 1){
		numSwitch = 0;
		playerNum = 0;
		System.out.println("It is Player one's turn now!");
		printBoard(numSwitch);
		System.out.println(" ");
		System.out.println("Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
		String MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		String destination = scanner.next();
		int CoordX = Integer.parseInt(destination.substring(0,1));
		int CoordY = Integer.parseInt(destination.substring(2,3));
		currentBoard = (one.move(MPiece.toLowerCase(), CoordX, CoordY, currentBoard));
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
		numSwitch = 1;
		playerNum = 1;
		System.out.println("It is Player two's (black) turn to move now!");
		printBoard(numSwitch);
		System.out.println(" ");
		System.out.println("Please select a piece to move.");
		MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		destination = scanner.next();
		CoordX = Integer.parseInt(destination.substring(0,1));
		CoordY = Integer.parseInt(destination.substring(2,3));
		currentBoard = (two.move(MPiece.toLowerCase(), CoordX, CoordY, currentBoard));
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
	    }
	    else{
		System.out.println("It is Player two's turn now!");
		numSwitch = 0;
		playerNum = 1;
		printBoard(numSwitch);
		System.out.println(" ");
		System.out.println("Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
		String MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		String destination = scanner.next();
		int CoordX = Integer.parseInt(destination.substring(0,1));
		int CoordY = Integer.parseInt(destination.substring(2,3));
		currentBoard = (two.move(MPiece.toLowerCase(), CoordX, CoordY, currentBoard));
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
		numSwitch = 1;
		playerNum = 0;
		System.out.println("It is Player one's (black) turn to move now!");
		printBoard(numSwitch);
		System.out.println(" ");
		System.out.println("Please select a piece to move.");
		MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		destination = scanner.next();
		CoordX = Integer.parseInt(destination.substring(0,1));
		CoordY = Integer.parseInt(destination.substring(2,3));
		currentBoard = (one.move(MPiece.toLowerCase(), CoordX, CoordY, currentBoard));
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
	    }
	}	
    }
}
