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
	Woo currentGame = new Woo();
	Scanner scanner = new Scanner(System.in);
	 
	System.out.println("Hello, welcome to Squishy Chess! You will be player one and your opponent will be player 2. Player 1 is always white, and goes first.");

	
	Player one = new Player("white");
	playerNum = 1;
	Player two = new Player("black");
	one.makeKing();
	two.makeKing();
        currentBoard = new Board();


	boolean check = false;
	boolean mate = false;
	Board copy = new Board();
	boolean multiplePieces = false;
	
	while (one.checkmate == false && two.checkmate == false){
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
	    boolean success;
	    while(true){
		success = true;
		try{
		    int CoordX = Integer.parseInt(destination.substring(0,1));
		    int CoordY = Integer.parseInt(destination.substring(2,3));
		    
		}
		catch (NumberFormatException e){
		    System.out.println("Invalid coordinates entered. Please re-enter.");
		    destination = scanner.next();
		    success = false;
		}
		if (success) break;
	    }
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
	    if (canMove.length() > 2){
		System.out.println("There are two pieces of the type you inputted that can move to the destination you provided. Please input the coordinates of the piece you prefer to move.");
		String startPos = scanner.next();
		int startingX = Integer.parseInt(startPos.substring(0,1));
		int startingY = Integer.parseInt(startPos.substring(2,3));
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.manualMove(startingX, startingY, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    System.out.println(check);
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
			currentBoard = one.killPiece(CoordX, CoordY, currentBoard);
			two.pieceDeath(CoordX, CoordY);
			currentBoard = one.manualMove(startingX, startingY, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			System.out.println(check);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(CoordX, CoordY);
			}
		    }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
	    }
	    else{
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    System.out.println(check);
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
			currentBoard = one.killPiece(CoordX, CoordY, currentBoard);
			two.pieceDeath(CoordX, CoordY);
			currentBoard = one.move(canMove, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			System.out.println(check);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(CoordX, CoordY);
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


		
	    
	    numSwitch = 1;
	    playerNum = 1;
	    System.out.println(two.N2.xCoord);
	    System.out.println(two.N2.yCoord);
	    System.out.println("It is Player two's (black) turn to move now!");
	    check = two.isCheck(two.K);
	    mate = two.checkMate(two.K);
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
	    while(true){
		success = true;
		try{
		    CoordX = Integer.parseInt(destination.substring(0,1));
		    CoordY = Integer.parseInt(destination.substring(2,3));
		    
		}
		catch (NumberFormatException e){
		    System.out.println("Invalid coordinates entered. Please re-enter.");
		    destination = scanner.next();
		    success = false;
		}
		if (success) break;
	    }
	    CoordX = Integer.parseInt(destination.substring(0,1));
	    CoordY = Integer.parseInt(destination.substring(2,3));
	    spaceEmpty = two.noPieceThere(CoordX, CoordY, currentBoard);
	    repeat = false;
	    canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
	    System.out.println(canMove);
	    while (canMove.length() == 0){
		System.out.println("Invalid move selected. Please select a piece to move.");
		MPiece = scanner.next();
		System.out.println("Please select the destination. Please use the format: x,y. Use the coordinate system on the side of the board.");
		destination = scanner.next();
		CoordX = Integer.parseInt(destination.substring(0,1));
		CoordY = Integer.parseInt(destination.substring(2,3));
		canMove = two.CanMove(MPiece, CoordX, CoordY, currentBoard);
	    }
	    if (canMove.length() > 2){
		System.out.println("There are two pieces of the type you inputted that can move to the destination you provided. Please input the coordinates of the piece you prefer to move.");
		String startPos = scanner.next();
		int startingX = Integer.parseInt(startPos.substring(0,1));
		int startingY = Integer.parseInt(startPos.substring(2,3));
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = two.manualMove(startingX, startingY, CoordX, CoordY, currentBoard);
		    check = two.isCheck(one.K);
		    System.out.println(check);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		    boolean ownPiece = two.ownPieceThere(CoordX, CoordY, currentBoard);
		    if (ownPiece){
			copy = currentBoard;
			currentBoard = two.killPiece(CoordX, CoordY, currentBoard);
			one.pieceDeath(CoordX, CoordY);
			currentBoard = two.manualMove(startingX, startingY, CoordX, CoordY, currentBoard);
			check = two.isCheck(one.K);
			System.out.println(check);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(CoordX, CoordY);
			}
		    }
		    else{
			System.out.println("Cannot move to a space occupied by your piece.");
			repeat = true;
		    }
		}
	    }
	    else{
		if(spaceEmpty){
		    copy = currentBoard;
		    currentBoard = two.move(canMove, CoordX, CoordY, currentBoard);
		    check = one.isCheck(one.K);
		    if (check){
			System.out.println("Still in check, invalid move.");
			repeat = true;
			currentBoard = copy;
		    }
		}
		else{
		    boolean ownPiece = one.ownPieceThere(CoordX, CoordY, currentBoard);
		    System.out.println(ownPiece);
		    
		    if (ownPiece){
			copy = currentBoard;
			currentBoard = two.killPiece(CoordX, CoordY, currentBoard);
			one.pieceDeath(CoordX, CoordY);
			currentBoard = two.move(canMove, CoordX, CoordY, currentBoard);
			check = one.isCheck(one.K);
			if (check){
			    System.out.println("Still in check, invalid move.");
			    repeat = true;
			    currentBoard = copy;
			    two.pieceRevive(CoordX, CoordY);
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
