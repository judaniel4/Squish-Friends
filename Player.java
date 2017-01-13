import java.util.Scanner;
import java.lang.*;
public class Player{
    public String color;
    public int pawns;
    public int queen;
    public int knight;
    public int bishop;
    public int rook;
    public Boolean checkmate;
    public Pawn P1 = new Pawn(0,1);
    public Pawn P2 = new Pawn(0,2);
    public Pawn P3 = new Pawn(0,3);
    public Pawn P4 = new Pawn(0,4);
    public Pawn P5 = new Pawn(0,5);
    public Pawn P6 = new Pawn(0,6);
    public Pawn P7 = new Pawn(0,7);
    public Pawn P8 = new Pawn(0,8);
    public Knight N1 = new Knight();
    public Knight N2 = new Knight();
    public Bishop B1 = new Bishop();
    public Bishop B2 = new Bishop();
    public  Rook R1 = new Rook();
    public Rook R2 = new Rook();
    public Queen Q = new Queen();
    public King K = new King();
    public Player(String C){
	color = C;
	pawns = 8;
	queen = 1;
	knight = 2;
	bishop = 2;
	rook = 2;
	checkmate = false;
    }
    
    public void move(String piece, int coordX, int coordY){
	System.out.println(piece == "pawn");
	if (piece == "pawn"){
	    System.out.println(P1.xCoord);
	    System.out.println(P1.yCoord);
	    System.out.println(coordX);
	    System.out.println(coordY);
	    System.out.println(P1.canMove(P1.xCoord, P1.yCoord, coordX, coordY));
	    if (P1.canMove(P1.xCoord, P1.yCoord, coordX, coordY)){
		System.out.println("yay!");
	    }
	    
	}
	/*	Scanner scanner = new Scanner(System.in);
	System.out.println("Select the piece you would like to move");

	String pieceToMove = Scanner.next();*/
    }
}
