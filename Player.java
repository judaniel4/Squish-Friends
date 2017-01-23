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
	    R1 = new Rook(0,0,"white");
	    R2 = new Rook(7,0,"white");
	    Q = new Queen(4,0,"white");
	    K = new King(3,0,"white");
	}
	else if(C.equals("black")){
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
    public boolean noPieceThere(int x, int y, Board z){
	//Returns true if the space moving to is empty
	boolean retBol = false;
	if(z.getLocation(x, y).equals("E")) {
		retBol = true;
	}
	return retBol;
    }
    public boolean ownPieceThere(int x, int y, Board z){
	//Returns true if the piece which occupies the space is NOT of the player's own color
	boolean retBol = true;
	if (noPieceThere(x, y, z)){

	}
	else{
	    String p = z.getLocation(x,y);
	    if (z.equals("P")){
		int coordX = P1.xCoord;
		int coordY = P1.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P2.xCoord;
		coordY = P2.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P3.xCoord;
		coordY = P3.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P4.xCoord;
		coordY = P4.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P5.xCoord;
		coordY = P5.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P6.xCoord;
		coordY = P6.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P7.xCoord;
		coordY = P7.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = P8.xCoord;
		coordY = P8.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	    else if (z.equals("N")){
		int coordX = N1.xCoord;
		int coordY = N1.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = N2.xCoord;
		coordY = N2.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	    else if (z.equals("B")){
		int coordX = B1.xCoord;
		int coordY = B1.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = B2.xCoord;
		coordY = B2.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	    else if (z.equals("R")){
		int coordX = R1.xCoord;
		int coordY = R1.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
		coordX = R2.xCoord;
		coordY = R2.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	    else if (z.equals("K")){
		int coordX = K.xCoord;
		int coordY = K.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	    else if (z.equals("Q")){
		int coordX = Q.xCoord;
		int coordY = Q.yCoord;
		if (coordX == x && coordY == y){
		    retBol = false;
		}
	    }
	}
	
	return retBol;
    }
    public String killPiece(int coordX, int coordY, Board b){
	String pieceToKill = b.getLocation(coordX, coordY);
	b.setPieceLocation("E", coordX, coordY);
	return pieceToKill;
    }
    public void pieceDeath(String p, int coordX, int coordY){
	if (p.equals("P")){
	    if (P1.xCoord == coordX && P1.yCoord == coordY){
		P1.isAlive = false;
	    }
	    if (P2.xCoord == coordX && P2.yCoord == coordY){
		P2.isAlive = false;
	    }
	    if (P3.xCoord == coordX && P3.yCoord == coordY){
		P3.isAlive = false;
	    }
	    if (P4.xCoord == coordX && P4.yCoord == coordY){
		P4.isAlive = false;
	    }
	    if (P5.xCoord == coordX && P5.yCoord == coordY){
		P5.isAlive = false;
	    }
	    if (P6.xCoord == coordX && P6.yCoord == coordY){
		P6.isAlive = false;
	    }
	    if (P7.xCoord == coordX && P7.yCoord == coordY){
		P7.isAlive = false;
	    }
	    if (P8.xCoord == coordX && P8.yCoord == coordY){
		P8.isAlive = false;
	    }
	}
	if (p.equals("N")){
	    if (N1.xCoord == coordX && N1.yCoord == coordY){
		N1.isAlive = false;
	    }
	    if (N2.xCoord == coordX && N2.yCoord == coordY){
		N2.isAlive = false;
	    }
	}
	if (p.equals("B")){
	    if (B1.xCoord == coordX && B1.yCoord == coordY){
		B1.isAlive = false;
	    }
	    if (B2.xCoord == coordX && B2.yCoord == coordY){
		B2.isAlive = false;
	    }
	}
	if (p.equals("R")){
	    if (R1.xCoord == coordX && R1.yCoord == coordY){
		R1.isAlive = false;
	    }
	    if (R2.xCoord == coordX && R2.yCoord == coordY){
		R2.isAlive = false;
	    }
	}
	if (p.equals("Q")){
	    Q.isAlive = false;
	}
    }
    public String CanMove(String piece, int coordX, int coordY, Board B){
	String ans = "";

	if (piece.equals("p")){
	    if (P1.canMove(P1.xCoord, P1.yCoord, coordX, coordY)){
		ans += "P1";
	    }
	    if (P2.canMove(P2.xCoord, P2.yCoord, coordX, coordY)){
		ans += "P2";
	    }
	    if (P3.canMove(P3.xCoord, P3.yCoord, coordX, coordY)){
		ans += "P3";
	    }
	    if (P4.canMove(P4.xCoord, P4.yCoord, coordX, coordY)){
		ans += "P4";
	    }
	    if (P5.canMove(P5.xCoord, P5.yCoord, coordX, coordY)){
		ans += "P5";
	    }
	    if (P6.canMove(P6.xCoord, P6.yCoord, coordX, coordY)){
		ans += "P6";
	    }
	    if (P7.canMove(P7.xCoord, P7.yCoord, coordX, coordY)){
		ans += "P7";
	    }
	    if (P8.canMove(P8.xCoord, P8.yCoord, coordX, coordY)){
		ans += "P8";
	    }
	}
	else if (piece.equals("r")){
	    if (R1.canMove(R1.xCoord, R1.yCoord, coordX, coordY)){
		ans += "R1";
	    }
	    if (R2.canMove(R2.xCoord, R2.yCoord, coordX, coordY)){
		ans += "R2";
	    }
	}
	else if (piece.equals("n")){
	    if (N1.canMove(N1.xCoord, N1.yCoord, coordX, coordY)){
		ans += "N1";
	    }
	    if (N2.canMove(N2.xCoord, N2.yCoord, coordX, coordY)){
		ans += "N2";
	    }
	}
	else if (piece.equals("b")){
	    if (B1.canMove(B1.xCoord, B1.yCoord, coordX, coordY)){
		ans += "B1";
	    }
	    if (B2.canMove(B2.xCoord, B2.yCoord, coordX, coordY)){
		ans += "B2";
	    }
	}
	else if (piece.equals("q")){
	    if (Q.canMove(Q.xCoord, Q.yCoord, coordX, coordY)){
		ans += "Q";
	    }
	}
	else if (piece.equals("k")){
	    if (K.canMove(K.xCoord, K.yCoord, coordX, coordY)){
		ans += "K";
	    }
	}

	return ans;
    }
    public Board move(String piece, int coordX, int coordY, Board B){
	if (piece.equals("P1")){
	    B.setBoard(P1.xCoord, P1.yCoord, coordX, coordY);
	    P1.xCoord = coordX;
	    P1.yCoord = coordY;
	}
	else if (piece.equals("P2")){
	    B.setBoard(P2.xCoord, P2.yCoord, coordX, coordY);
	    P2.xCoord = coordX;
	    P2.yCoord = coordY;
	    }
	else if (piece.equals("P3")){
	    B.setBoard(P3.xCoord, P3.yCoord, coordX, coordY);
	    P3.xCoord = coordX;
	    P3.yCoord = coordY;
	}
	else if (piece.equals("P4")){
	    B.setBoard(P4.xCoord, P4.yCoord, coordX, coordY);
	    P4.xCoord = coordX;
	    P4.yCoord = coordY;
	}
	else if (piece.equals("P5")){
	    B.setBoard(P5.xCoord, P5.yCoord, coordX, coordY);
	    P5.xCoord = coordX;
	    P5.yCoord = coordY;
	}
	else if (piece.equals("P6")){
	    B.setBoard(P6.xCoord, P6.yCoord, coordX, coordY);
	    P6.xCoord = coordX;
	    P6.yCoord = coordY;
	}
	else if (piece.equals("P7")){
	    B.setBoard(P7.xCoord, P7.yCoord, coordX, coordY);
	    P7.xCoord = coordX;
	    P7.yCoord = coordY;
	}
	else if (piece.equals("P8")){
	    B.setBoard(P8.xCoord, P8.yCoord, coordX, coordY);
	    P8.xCoord = coordX;
	    P8.yCoord = coordY;
	}
	else if (piece.equals("R1")){
	    B.setBoard(R1.xCoord, R1.yCoord, coordX, coordY);
	    R1.xCoord = coordX;
	    R1.yCoord = coordY;
	}
	if (piece.equals("R2")){
	    B.setBoard(R2.xCoord, R2.yCoord, coordX, coordY);
	    R2.xCoord = coordX;
	    R2.yCoord = coordY;
	}
	else if (piece.equals("N1")){
	    B.setBoard(N1.xCoord, N1.yCoord, coordX, coordY);
	    N1.xCoord = coordX;
	    N1.yCoord = coordY;
	}
	else if (piece.equals("N2")){
	    B.setBoard(N2.xCoord, N2.yCoord, coordX, coordY);
	    N2.xCoord = coordX;
	    N2.yCoord = coordY;
	}
	else if (piece.equals("B1")){
	    B.setBoard(B1.xCoord, B1.yCoord, coordX, coordY);
	    B1.xCoord = coordX;
	    B1.yCoord = coordY;
	}
	else if (piece.equals("B2")){
	    B.setBoard(B2.xCoord, B2.yCoord, coordX, coordY);
	    B2.xCoord = coordX;
	    B2.yCoord = coordY;
	}
	
	else if (piece.equals("Q")){
	    B.setBoard(Q.xCoord, Q.yCoord, coordX, coordY);
	    Q.xCoord = coordX;
	    Q.yCoord = coordY;
	}
	
	else if (piece.equals("K")){
	    B.setBoard(K.xCoord, K.yCoord, coordX, coordY);
	    K.xCoord = coordX;
	    K.yCoord = coordY;
	}
	return B;
    }
}

