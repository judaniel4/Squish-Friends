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
    public Pawn P1;
    public Pawn P2;
    public Pawn P3;
    public Pawn P4;
    public Pawn P5;
    public Pawn P6;
    public Pawn P7;
    public Pawn P8;
    public Knight N1;
    public Knight N2;
    public Bishop B1;
    public Bishop B2;
    public Rook R1;
    public Rook R2;
    public Queen Q;
    public King K;
    public Player(String C){
	color = C;
	pawns = 8;
	queen = 1;
	knight = 2;
	bishop = 2;
	rook = 2;
	checkmate = false;
	if (C.equals("white")){
	    P1 = new Pawn(0,1,"white");
	    P2 = new Pawn(1,1,"white");
	    P3 = new Pawn(2,1,"white");
	    P4 = new Pawn(3,1,"white");
	    P5 = new Pawn(4,1,"white");
	    P6 = new Pawn(5,1,"white");
	    P7 = new Pawn(6,1,"white");
	    P8 = new Pawn(7,1,"white");
	    N1 = new Knight(1,0,"white");
	    N2 = new Knight(6,0,"white");
	    B1 = new Bishop(2,0,"white");
	    B2 = new Bishop(5,0,"white");
	    R1  = new Rook(0,0,"white");
	    R2 = new Rook(7,0,"white");
	    Q = new Queen(4,0,"white");
	    K = new King(3,0,"white");
	}
	else{
	    P1 = new Pawn(0,6,"black");
	    P2 = new Pawn(1,6,"black");
	    P3 = new Pawn(2,6,"black");
	    P4 = new Pawn(3,6,"black");
	    P5 = new Pawn(4,6,"black");
	    P6 = new Pawn(5,6,"black");
	    P7 = new Pawn(6,6,"black");
	    P8 = new Pawn(7,6,"black");
	    N1 = new Knight(1,7,"black");
	    N2 = new Knight(6,7,"black");
	    B1 = new Bishop(2,7,"black");
	    B2 = new Bishop(5,7,"black");
	    R1 = new Rook(0,7,"black");
	    R2 = new Rook(7,7,"black");
	    Q = new Queen(4,7,"black");
	    K = new King(3,7,"black");
	}
    }
    
    public Board move(String piece, int coordX, int coordY, Board b){
	if (piece.equals("p")){
	    System.out.println(P1.xCoord);
	    System.out.println(P1.yCoord);
	    System.out.println(coordX);
	    System.out.println(coordY);
	    System.out.println(P1.canMove(P1.xCoord, P1.yCoord, coordX, coordY));
	    if (P1.canMove(P1.xCoord, P1.yCoord, coordX, coordY)){
		b.setBoard(P1.xCoord, P1.yCoord, coordX, coordY);
		P1.xCoord = coordX;
		P1.yCoord = coordY;
	    }
	}
	return b;
    }
}
