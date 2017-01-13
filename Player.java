import java.util.Scanner;
public class Player{
    public String color;
    public int pawns;
    public int queen;
    public int knight;
    public int bishop;
    public int rook;
    public Boolean checkmate;
    public Player(String C){
	color = C;
	pawns = 8;
	queen = 1;
	knight = 2;
	bishop = 2;
	rook = 2;
	checkmate = false;
    }
    public void instantiatePieces(){
        Pawn P1 = new Pawn();
	Pawn P2 = new Pawn();
	Pawn P3 = new Pawn();
	Pawn P4 = new Pawn();
	Pawn P5 = new Pawn();
	Pawn P6 = new Pawn();
	Pawn P7 = new Pawn();
	Pawn P8 = new Pawn();
	Knight N1 = new Knight();
	Knight N2 = new Knight();
	Bishop B1 = new Bishop();
	Bishop B2 = new Bishop();
	Rook R1 = new Rook();
	Rook R2 = new Rook();
	Queen Q = new Queen();
	King K = new King();
    }
    
    public void move(){
	/*	Scanner scanner = new Scanner(System.in);
	System.out.println("Select the piece you would like to move");

	String pieceToMove = Scanner.next();*/
    }
}
