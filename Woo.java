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

    public static void printBoard(int p){ //Depending on which color the current player is, the board needs to be flipped to their perspective without actually changing the board. 
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

	if (color.toLowerCase().equals("white")){ //Initializing players' colors
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
	if (one.color.equals("white")){ //This is the code for the first move of the 2 players
	    numSwitch = 0;
	    playerNum = 0;
	    System.out.println("Player one will go first since he/she is white. It is the first turn! Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
	    String firstMPiece = scanner.next();
	    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
	    String Destination = scanner.next();
	    int coordX = Integer.parseInt(Destination.substring(0,1));
	    int coordY = Integer.parseInt(Destination.substring(2,3));
	    boolean spaceEmpty = one.noPieceThere(coordX, coordY, currentBoard);
	    boolean repeat = false;
	    String canMove = one.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    while (canMove.length() == 0){ //If the list of pieces that can move to the destination is empty, then returns error that the move is invalid.
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	        canMove = one.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    }
	    if(spaceEmpty){ //If a piece can move to destination and destination is empyy, the piece moves there
	        currentBoard = one.move(canMove, coordX, coordY, currentBoard);
	    }
	    else{
		boolean ownPiece = one.ownPieceThere(coordX, coordY, currentBoard); //If the destination is occupied by an enemy piece, it takes the piece if possible
		if (ownPiece){
		    String toKill = one.killPiece(coordX, coordY, currentBoard);
		    two.pieceDeath(toKill, coordX, coordY);
		    currentBoard = one.move(canMove, coordX, coordY, currentBoard);
		}
		else{ //If the piece occupying the destination is occupied by a friendly piece, return an error, invalid move
		    System.out.println("Cannot move to a space occupied by your piece.");
		    repeat = true;
		}
	    }
	    while (repeat){ //If an error occurs, this repeats the turn
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	    }
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
	    spaceEmpty = two.noPieceThere(coordX, coordY, currentBoard);
	    System.out.println(spaceEmpty);
	    repeat = false;
	    canMove = two.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    System.out.println(canMove);
	    while (canMove.length() == 0){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	        canMove = two.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    }
	    if(spaceEmpty){
	        currentBoard = two.move(canMove, coordX, coordY, currentBoard);
	    }
	    else{
		boolean ownPiece = two.ownPieceThere(coordX, coordY, currentBoard);
		if (ownPiece){
		    String toKill = two.killPiece(coordX, coordY, currentBoard);
		    one.pieceDeath(toKill, coordX, coordY);
		    currentBoard = two.move(canMove, coordX, coordY, currentBoard);
		}
		else{
		    System.out.println("Cannot move to a space occupied by your piece.");
		    repeat = true;
		}
	    }
	    while (repeat){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	    }
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
	    boolean spaceEmpty = one.noPieceThere(coordX, coordY, currentBoard);
	    boolean repeat = false;
	    String canMove = two.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    while (canMove.length() == 0){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	        canMove = two.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    }
	    if(spaceEmpty){
	         currentBoard = two.move(canMove, coordX, coordY, currentBoard);
	    }
	    else{
		boolean ownPiece = two.ownPieceThere(coordX, coordY, currentBoard);
		if (ownPiece){
		    String toKill = two.killPiece(coordX, coordY, currentBoard);
		    one.pieceDeath(toKill, coordX, coordY);
		    currentBoard = two.move(canMove, coordX, coordY, currentBoard);
		}
		else{
		    System.out.println("Cannot move to a space occupied by your piece.");
		    repeat = true;
		}
	    }
	    while (repeat){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	    }
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
	    spaceEmpty = one.noPieceThere(coordX, coordY, currentBoard);
	    repeat = false;
	    canMove = one.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    while (canMove.length() == 0){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	        canMove = one.CanMove(firstMPiece, coordX, coordY, currentBoard);
	    }
	    if(spaceEmpty){
	         currentBoard = one.move(canMove, coordX, coordY, currentBoard);
	    }
	    else{
		boolean ownPiece = one.ownPieceThere(coordX, coordY, currentBoard);
		if (ownPiece){
		    String toKill = one.killPiece(coordX, coordY, currentBoard);
		    two.pieceDeath(toKill, coordX, coordY);
		     currentBoard = one.move(canMove, coordX, coordY, currentBoard);
		}
		else{
		    System.out.println("Cannot move to a space occupied by your piece.");
		    repeat = true;
		}
	    }
	    while (repeat){
		System.out.println("Invalid move selected. Please select a piece to move.");
		firstMPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		Destination = scanner.next();
		coordX = Integer.parseInt(Destination.substring(0,1));
		coordY = Integer.parseInt(Destination.substring(2,3));
	    }
	    System.out.println("Board After Move:");
	    printBoard(numSwitch);
	    System.out.println(" ");
	}


	boolean check = false;
	boolean mate = false;
	Board copy = new Board();
	
	while (one.checkmate == false && two.checkmate == false){
	    if (playerNum == 1){
		numSwitch = 0;
		playerNum = 0;
		System.out.println("It is Player one's turn now!");
		printBoard(numSwitch);
		System.out.println(" ");
		check = one.isCheck(one.K);
		mate = one.checkMate(one.K);
		if (check){
		    if (mate){
			System.out.println("You have been defeated.");
			break;
		    }
		    System.out.println("Your king is in check. You must either move him out of the way or block the check");
		}
		System.out.println("Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
		String MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		String destination = scanner.next();
		int CoordX = Integer.parseInt(destination.substring(0,1));
		int CoordY = Integer.parseInt(destination.substring(2,3));
		boolean spaceEmpty = one.noPieceThere(CoordX, CoordY, currentBoard);
		boolean repeat = false;
		String canMove = one.CanMove(MPiece, CoordX, CoordY, currentBoard);
		while (canMove.length() == 0){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		    canMove = one.CanMove(MPiece, CoordX, CoordY, currentBoard);
		}
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		    boolean ownPiece = one.ownPieceThere(CoordX, CoordY, currentBoard);
		    if (ownPiece){
			copy = currentBoard;
			String toKill = one.killPiece(CoordX, CoordY, currentBoard);
			two.pieceDeath(toKill, CoordX, CoordY);
			currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(toKill, CoordX, CoordY);
			}
		    }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
		while (repeat){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		}
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
		numSwitch = 1;
		playerNum = 1;
		System.out.println("It is Player two's (black) turn to move now!");
		check = two.isCheck(two.K);
		mate = two.checkMate(two.K);
		System.out.println(check);
		System.out.println(mate);
		if (check){
		    if (mate){
			System.out.println("You have been defeated.");
			break;
		    }
		    System.out.println("Your king is in check. You must either move him out of the way or block the check");
		}
		printBoard(numSwitch);
		System.out.println(" ");
		System.out.println("Please select a piece to move.");
		MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		destination = scanner.next();
		CoordX = Integer.parseInt(destination.substring(0,1));
		CoordY = Integer.parseInt(destination.substring(2,3));
		spaceEmpty = two.noPieceThere(CoordX, CoordY, currentBoard);
		repeat = false;
		canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
		while (canMove.length() == 0){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		    canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
		}
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		    boolean ownPiece = one.ownPieceThere(CoordX, CoordY, currentBoard);
		    if (ownPiece){
			copy = currentBoard;
			String toKill = one.killPiece(CoordX, CoordY, currentBoard);
			two.pieceDeath(toKill, CoordX, CoordY);
			currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(toKill, CoordX, CoordY);
			}
		    }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
		while (repeat){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		}
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
		check = two.isCheck(two.K);
		mate = two.checkMate(two.K);
		if (check){
		    if (mate){
			System.out.println("You have been defeated.");
			break;
		    }
		    System.out.println("Your king is in check. You must either move him out of the way or block the check");
		}
		System.out.println("Please select the piece you would like to move. (Please use the first letter, use 'n' for knight)");
		String MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		String destination = scanner.next();
		int CoordX = Integer.parseInt(destination.substring(0,1));
		int CoordY = Integer.parseInt(destination.substring(2,3));
		boolean spaceEmpty = two.noPieceThere(CoordX, CoordY, currentBoard);
		boolean repeat = false;
		String canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
		while (canMove.length() == 0){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		    canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
		}
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		   boolean ownPiece = one.ownPieceThere(CoordX, CoordY, currentBoard);
		   if (ownPiece){
		       copy = currentBoard;
		       String toKill = one.killPiece(CoordX, CoordY, currentBoard);
		       two.pieceDeath(toKill, CoordX, CoordY);
		       currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		       check = one.isCheck(one.K);
		       if (check){
			   System.out.println("Still in check, invalid move.");
			   repeat = true;
			   currentBoard = copy;
			   two.pieceRevive(toKill, CoordX, CoordY);
		       }
		   }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
		while (repeat){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		}
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
		numSwitch = 1;
		playerNum = 0;
		System.out.println("It is Player one's (black) turn to move now!");
		printBoard(numSwitch);
		System.out.println(" ");
		check = one.isCheck(one.K);
		mate = one.checkMate(one.K);
		if (check){
		    if (mate){
			System.out.println("You have been defeated.");
			break;
		    }
		    System.out.println("Your king is in check. You must either move him out of the way or block the check");
		}
		System.out.println("Please select a piece to move.");
		MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y");
		destination = scanner.next();
		CoordX = Integer.parseInt(destination.substring(0,1));
		CoordY = Integer.parseInt(destination.substring(2,3));
		spaceEmpty = one.noPieceThere(CoordX, CoordY, currentBoard);
		repeat = false;
		canMove = one.CanMove(MPiece, CoordX, CoordY, currentBoard);
		while (canMove.length() == 0){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		    canMove = one.CanMove(MPiece, CoordX, CoordY, currentBoard);
		}
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		    boolean ownPiece = one.ownPieceThere(CoordX, CoordY, currentBoard);
		    if (ownPiece){
			copy = currentBoard;
			String toKill = one.killPiece(CoordX, CoordY, currentBoard);
			two.pieceDeath(toKill, CoordX, CoordY);
			currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(toKill, CoordX, CoordY);
			}
		    }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
		while (repeat){
		    System.out.println("Invalid move selected. Please select a piece to move.");
		    MPiece = scanner.next();
		    System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		    destination = scanner.next();
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		}
		System.out.println("Board After Move:");
		printBoard(numSwitch);
		System.out.println(" ");
	    }
	}	
    }
}

 /*  while(canMove.length() > 2){
		System.out.println("Two different pieces of the chosen type can move to the desired destination. Please specify the x,y coordinate of the piece you desire to move.");
		startLocation = scanner.next();
		startX = Integer.parseInt(startLocation.substring(0,1));
		startY = Integer.parseInt(startLocation.substring(2,3));
	        one.forceMove(startX, startY, 
		}*/
