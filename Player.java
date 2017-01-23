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
      public void pieceRevive(String p, int coordX, int coordY){
	if (p.equals("P")){
	    if (P1.xCoord == coordX && P1.yCoord == coordY){
		P1.isAlive = true;
	    }
	    if (P2.xCoord == coordX && P2.yCoord == coordY){
		P2.isAlive = true;
	    }
	    if (P3.xCoord == coordX && P3.yCoord == coordY){
		P3.isAlive = true;
	    }
	    if (P4.xCoord == coordX && P4.yCoord == coordY){
		P4.isAlive = true;
	    }
	    if (P5.xCoord == coordX && P5.yCoord == coordY){
		P5.isAlive = true;
	    }
	    if (P6.xCoord == coordX && P6.yCoord == coordY){
		P6.isAlive = true;
	    }
	    if (P7.xCoord == coordX && P7.yCoord == coordY){
		P7.isAlive = true;
	    }
	    if (P8.xCoord == coordX && P8.yCoord == coordY){
		P8.isAlive = true;
	    }
	}
	if (p.equals("N")){
	    if (N1.xCoord == coordX && N1.yCoord == coordY){
		N1.isAlive = true;
	    }
	    if (N2.xCoord == coordX && N2.yCoord == coordY){
		N2.isAlive = true;
	    }
	}
	if (p.equals("B")){
	    if (B1.xCoord == coordX && B1.yCoord == coordY){
		B1.isAlive = true;
	    }
	    if (B2.xCoord == coordX && B2.yCoord == coordY){
		B2.isAlive = true;
	    }
	}
	if (p.equals("R")){
	    if (R1.xCoord == coordX && R1.yCoord == coordY){
		R1.isAlive = true;
	    }
	    if (R2.xCoord == coordX && R2.yCoord == coordY){
		R2.isAlive = true;
	    }
	}
	if (p.equals("Q")){
	    Q.isAlive = true;
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
    public boolean dangerCheck(String colour, int x, int y){
	boolean retBoo = false;
	for(String[] row: Woo.currentBoard.getBoard()){
	    for(String piece: row){
		if (!color.equals(colour)){
		    if (!piece.equals("E")){
			if(piece.equals("Q")){
			    retBoo = retBoo || Q.canMove(Q.xCoord, Q.yCoord, x, y);
			}
			if(piece.equals("P")){
			    retBoo = retBoo || P1.canMove(P1.xCoord, P1.yCoord, x, y)
				|| P2.canMove(P2.xCoord, P2.yCoord, x, y)
				|| P3.canMove(P3.xCoord, P3.yCoord, x, y)
				|| P4.canMove(P4.xCoord, P4.yCoord, x, y)
				|| P5.canMove(P5.xCoord, P5.yCoord, x, y)
				|| P6.canMove(P6.xCoord, P6.yCoord, x, y)
				|| P7.canMove(P7.xCoord, P7.yCoord, x, y)
				|| P8.canMove(P8.xCoord, P8.yCoord, x, y);
			}
			if(piece.equals("N")){
			    retBoo = retBoo || N1.canMove(N1.xCoord, N1.yCoord, x, y)
				|| N2.canMove(N2.xCoord, N2.yCoord, x, y);
			}
			if(piece.equals("B")){
			    retBoo = retBoo || B1.canMove(B1.xCoord, B1.yCoord, x, y)
				|| B2.canMove(B2.xCoord, B2.yCoord, x, y);
			}
			if(piece.equals("R")){
			    retBoo = retBoo || R1.canMove(R1.xCoord, R1.yCoord, x, y)
				|| R2.canMove(R2.xCoord, R2.yCoord, x, y);
			}
			if(piece.equals("K")){
			    retBoo = retBoo || K.canMove(K.xCoord, K.yCoord, x, y);
			}
		    }
		}
		if (Woo.two.color.equals(colour)){
		    if (!piece.equals("E")){
			if(piece.equals("Q")){
			    retBoo = retBoo || Q.canMove( Q.xCoord,  Q.yCoord, x, y);
			}
			if(piece.equals("P")){
			    retBoo = retBoo || P1.canMove( P1.xCoord,  P1.yCoord, x, y)
				|| P2.canMove( P2.xCoord,  P2.yCoord, x, y)
				|| P3.canMove( P3.xCoord,  P3.yCoord, x, y)
				|| P4.canMove( P4.xCoord,  P4.yCoord, x, y)
				|| P5.canMove( P5.xCoord,  P5.yCoord, x, y)
				|| P6.canMove( P6.xCoord,  P6.yCoord, x, y)
				|| P7.canMove( P7.xCoord,  P7.yCoord, x, y)
				|| P8.canMove( P8.xCoord,  P8.yCoord, x, y);
			}
			if(piece.equals("N")){
			    retBoo = retBoo || N1.canMove( N1.xCoord,  N1.yCoord, x, y)
				|| N2.canMove( N2.xCoord,  N2.yCoord, x, y);
			}
			if(piece.equals("B")){
			    retBoo = retBoo || B1.canMove( B1.xCoord,  B1.yCoord, x, y)
				|| B2.canMove( B2.xCoord,  B2.yCoord, x, y);
			}
			if(piece.equals("R")){
			    retBoo = retBoo || R1.canMove( R1.xCoord,  R1.yCoord, x, y)
				|| R2.canMove( R2.xCoord,  R2.yCoord, x, y);
			}
		    }
		}
	    }
	}
	return retBoo;
    }

    public boolean isCheck(King Henry){
	return dangerCheck(Henry.color, Henry.xCoord, Henry.yCoord);
    }
    public boolean checkMate(King Louis){
	//Checks to see if the king is in check
	boolean inCheck = isCheck(Louis);
	//Checks to see if the king can move out of check
	boolean kingMove = K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord + 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord - 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord - 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord + 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord - 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord, Louis.yCoord + 1) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord + 1, Louis.yCoord) ||
	    K.canMove(Louis.xCoord, Louis.yCoord, Louis.xCoord - 1, Louis.yCoord);
	//Checks to see if the piece can be eaten
	boolean canEated = true;
	for(String piece: Louis.checkKing()){
	    if (piece.equals("Q")){
		if(!Woo.one.color.equals(Louis.color)){		    
		    if(Woo.one.Q.xCoord == Louis.xCoord){
			if(Louis.yCoord < Woo.one.Q.yCoord){
			    for(int y = Louis.yCoord; y <= Woo.one.Q.yCoord; y++){
				//Checks to see if the piece can be eaten or blocked.
				canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
			    }
			}
			    if(Louis.yCoord > Woo.one.Q.yCoord){
				for(int y = Woo.one.Q.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.Q.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.Q.xCoord){
				for(int x = Louis.xCoord; x <= Woo.one.Q.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.yCoord > Woo.one.Q.yCoord){
				for(int x = Woo.one.Q.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}
			if (Louis.xCoord > Woo.one.Q.xCoord && Louis.yCoord >  Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX>qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.one.color, qX, qY); 
				qX++;
				qY++;
			    }
			}
			if (Louis.xCoord < Woo.one.Q.xCoord && Louis.yCoord < Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX<qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.Q.xCoord && Louis.yCoord > Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX<qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, qY); 
				kingX++;
				qY++;
			    }
			}
			if (Louis.xCoord > Woo.one.Q.xCoord && Louis.yCoord < Woo.one.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.one.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.one.Q.yCoord;
			    while(kingX>qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.one.color, qX, kingY); 
				qX++;
				kingY++;
			    }
			}
		}
		if(!Woo.two.color.equals(Louis.color)){		    
		    if(Woo.two.Q.xCoord == Louis.xCoord){
			if(Louis.yCoord < Woo.two.Q.yCoord){
			    for(int y = Louis.yCoord; y <= Woo.two.Q.yCoord; y++){
				//Checks to see if the piece can be eaten or blocked.
				canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
			    }
			}
			    if(Louis.yCoord > Woo.two.Q.yCoord){
				for(int y = Woo.two.Q.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.Q.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.Q.xCoord){
				for(int x = Louis.xCoord; x <= Woo.two.Q.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.yCoord > Woo.two.Q.yCoord){
				for(int x = Woo.two.Q.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}
			if (Louis.xCoord > Woo.two.Q.xCoord && Louis.yCoord >  Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX>qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.two.color, qX, qY); 
				qX++;
				qY++;
			    }
			}
			if (Louis.xCoord < Woo.two.Q.xCoord && Louis.yCoord < Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX<qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.two.Q.xCoord && Louis.yCoord > Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX<qX && kingY>qY){
				canEated = canEated && dangerCheck(Woo.two.color, kingX, qY); 
				kingX++;
				qY++;
			    }
			}
			if (Louis.xCoord > Woo.two.Q.xCoord && Louis.yCoord < Woo.two.Q.yCoord){
			    int kingX = Louis.xCoord;
			    int qX = Woo.two.Q.xCoord;
			    int kingY = Louis.yCoord;
			    int qY = Woo.two.Q.yCoord;
			    while(kingX>qX && kingY<qY){
				canEated = canEated && dangerCheck(Woo.two.color, qX, kingY); 
				qX++;
				kingY++;
			    }
			}
		}
	    }
	    if (piece.equals("N")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(Woo.one.N1.canMove(Woo.one.N1.xCoord, Woo.one.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N1.xCoord, Woo.one.N1.yCoord);
		    }
		    if(Woo.one.N2.canMove(Woo.one.N2.xCoord, Woo.one.N2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.N2.xCoord, Woo.one.N2.yCoord);
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){
		    if(Woo.two.N1.canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.two.N1.xCoord, Woo.two.N1.yCoord);
		    }
		    if(Woo.two.N2.canMove(Woo.two.N1.xCoord, Woo.two.N1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.N2.xCoord, Woo.two.N2.yCoord);
		    }
		}
	    }
	    if (piece.equals("R")){
		if(!Woo.one.color.equals(Louis.color)){		    
		    if(Woo.one.R1.canMove(Woo.one.R1.xCoord, Woo.one.R1.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.one.R1.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.one.R1.yCoord){
				for(int y = Louis.yCoord; y <= Woo.one.R1.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.one.R1.yCoord){
				for(int y = Woo.one.R1.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.R1.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.R1.xCoord){
				for(int x = Louis.yCoord; x <= Woo.one.R1.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.one.R1.xCoord){
				for(int x = Woo.one.R1.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		    if(Woo.one.R2.canMove(Woo.one.R2.xCoord, Woo.one.R2.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.one.R2.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.one.R2.yCoord){
				for(int y = Louis.yCoord; y <= Woo.one.R2.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.one.R2.yCoord){
				for(int y = Woo.one.R2.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.one.R2.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.one.R2.xCoord){
				for(int x = Louis.yCoord; x <= Woo.one.R2.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.one.R2.xCoord){
				for(int x = Woo.one.R2.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.one.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){		    
		    if(Woo.two.R1.canMove(Woo.two.R1.xCoord, Woo.two.R1.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.two.R1.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.two.R1.yCoord){
				for(int y = Louis.yCoord; y <= Woo.two.R1.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.two.R1.yCoord){
				for(int y = Woo.two.R1.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.R1.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.R1.xCoord){
				for(int x = Louis.yCoord; x <= Woo.two.R1.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.two.R1.xCoord){
				for(int x = Woo.two.R1.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}	
		    }
		    if(Woo.two.R2.canMove(Woo.two.R2.xCoord, Woo.two.R2.yCoord, Louis.xCoord, Louis.yCoord)){
			if(Woo.two.R2.xCoord == Louis.xCoord){
			    if(Louis.yCoord < Woo.two.R2.yCoord){
				for(int y = Louis.yCoord; y <= Woo.two.R2.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			    if(Louis.yCoord > Woo.two.R2.yCoord){
				for(int y = Woo.two.R2.yCoord; y <= Louis.yCoord; y++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, Louis.xCoord, y);
				}
			    }
			}
			if(Woo.two.R2.yCoord == Louis.yCoord){
			    if(Louis.xCoord < Woo.two.R2.xCoord){
				for(int x = Louis.yCoord; x <= Woo.two.R2.yCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			    if(Louis.xCoord > Woo.two.R2.xCoord){
				for(int x = Woo.two.R2.xCoord; x <= Louis.xCoord; x++){
				    //Checks to see if the piece can be eaten or blocked.
				    canEated = canEated && dangerCheck(Woo.two.color, x, Louis.yCoord);
				}
			    }
			}
		     }
		}
	    }
	    if(piece.equals("P")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(Woo.one.P1.canMove(Woo.one.P1.xCoord, Woo.one.P1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P1.xCoord, Woo.one.P1.yCoord);
		    }
		    if(Woo.one.P2.canMove(Woo.one.P2.xCoord, Woo.one.P2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P2.xCoord, Woo.one.P2.yCoord);
		    }
		    if(Woo.one.P3.canMove(Woo.one.P3.xCoord, Woo.one.P3.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P3.xCoord, Woo.one.P3.yCoord);
		    }
		    if(Woo.one.P4.canMove(Woo.one.P4.xCoord, Woo.one.P4.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P4.xCoord, Woo.one.P4.yCoord);
		    }
		    if(Woo.one.P5.canMove(Woo.one.P5.xCoord, Woo.one.P5.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P5.xCoord, Woo.one.P5.yCoord);
		    }
		    if(Woo.one.P6.canMove(Woo.one.P6.xCoord, Woo.one.P6.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P6.xCoord, Woo.one.P6.yCoord);
		    }
		    if(Woo.one.P7.canMove(Woo.one.P7.xCoord, Woo.one.P7.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P7.xCoord, Woo.one.P7.yCoord);
		    }
		    if(Woo.one.P8.canMove(Woo.one.P8.xCoord, Woo.one.P8.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.one.color, Woo.one.P8.xCoord, Woo.one.P8.yCoord);
		    }
		}
		if(!Woo.two.color.equals(Louis.color)){
		    if(Woo.two.P1.canMove(Woo.two.P1.xCoord, Woo.two.P1.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P1.xCoord, Woo.two.P1.yCoord);
		    }
		    if(Woo.two.P2.canMove(Woo.two.P2.xCoord, Woo.two.P2.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P2.xCoord, Woo.two.P2.yCoord);
		    }
		    if(Woo.two.P3.canMove(Woo.two.P3.xCoord, Woo.two.P3.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P3.xCoord, Woo.two.P3.yCoord);
		    }
		    if(Woo.two.P4.canMove(Woo.two.P4.xCoord, Woo.two.P4.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P4.xCoord, Woo.two.P4.yCoord);
		    }
		    if(Woo.two.P5.canMove(Woo.two.P5.xCoord, Woo.two.P5.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P5.xCoord, Woo.two.P5.yCoord);
		    }
		    if(Woo.two.P6.canMove(Woo.two.P6.xCoord, Woo.two.P6.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P6.xCoord, Woo.two.P6.yCoord);
		    }
		    if(Woo.two.P7.canMove(Woo.two.P7.xCoord, Woo.two.P7.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P7.xCoord, Woo.two.P7.yCoord);
		    }
		    if(Woo.two.P8.canMove(Woo.two.P8.xCoord, Woo.two.P8.yCoord, Louis.xCoord, Louis.yCoord)){
			canEated = canEated && dangerCheck(Woo.two.color, Woo.two.P8.xCoord, Woo.two.P8.yCoord);
		    }
		}
	    }
	    if (piece.equals("B")){
		if(!Woo.one.color.equals(Louis.color)){
		    if(Woo.one.B1.canMove(Woo.one.B1.xCoord, Woo.one.B1.yCoord, Louis.xCoord, Louis.yCoord)){
			if (Louis.xCoord + Louis.yCoord > Woo.one.B1.xCoord + Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX>b1X && kingY>b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, b1X, b1Y); 
				b1X++;
				b1Y++;
			    }
			}
			if (Louis.xCoord + Louis.yCoord < Woo.one.B1.xCoord + Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX<b1X && kingY<b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.B1.xCoord && Louis.yCoord > Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX<b1X && kingY>b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, b1Y); 
				kingX++;
				b1Y++;
			    }
			}
			if (Louis.xCoord > Woo.one.B1.xCoord && Louis.yCoord < Woo.one.B1.yCoord){
			    int kingX = Louis.xCoord;
			    int b1X = Woo.one.B1.xCoord;
			    int kingY = Louis.yCoord;
			    int b1Y = Woo.one.B1.yCoord;
			    while(kingX>b1X && kingY<b1Y){
				canEated = canEated && dangerCheck(Woo.one.color, b1X, kingY); 
				b1X++;
				kingY++;
			    }
			}
		    }
		    if(Woo.one.B1.canMove(Woo.one.B2.xCoord, Woo.one.B2.yCoord, Louis.xCoord, Louis.yCoord)){
			if (Louis.xCoord + Louis.yCoord > Woo.one.B2.xCoord + Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX>b2X && kingY>b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, b2X, b2Y); 
				b2X++;
				b2Y++;
			    }
			}
			if (Louis.xCoord + Louis.yCoord < Woo.one.B2.xCoord + Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX<b2X && kingY<b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, kingY); 
				kingX++;
				kingY++;
			    }
			}
			if (Louis.xCoord < Woo.one.B2.xCoord && Louis.yCoord > Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX<b2X && kingY>b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, kingX, b2Y); 
				kingX++;
				b2Y++;
			    }
			}
			if (Louis.xCoord > Woo.one.B2.xCoord && Louis.yCoord < Woo.one.B2.yCoord){
			    int kingX = Louis.xCoord;
			    int b2X = Woo.one.B2.xCoord;
			    int kingY = Louis.yCoord;
			    int b2Y = Woo.one.B2.yCoord;
			    while(kingX>b2X && kingY<b2Y){
				canEated = canEated && dangerCheck(Woo.one.color, b2X, kingY); 
				b2X++;
				kingY++;
			    }
			}
		    }
		}
	    }
	    if(!Woo.two.color.equals(Louis.color)){
		if(Woo.two.B1.canMove(Woo.two.B1.xCoord, Woo.two.B1.yCoord, Louis.xCoord, Louis.yCoord)){
		    if (Louis.xCoord + Louis.yCoord > Woo.two.B1.xCoord + Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX>b1X && kingY>b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b1X, b1Y); 
			    b1X++;
			    b1Y++;
			}
		    }
		    if (Louis.xCoord + Louis.yCoord < Woo.two.B1.xCoord + Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX<b1X && kingY<b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
			    kingX++;
			    kingY++;
			}
		    }
		    if (Louis.xCoord < Woo.two.B1.xCoord && Louis.yCoord > Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX<b1X && kingY>b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, b1Y); 
			    kingX++;
			    b1Y++;
			}
		    }
		    if (Louis.xCoord > Woo.two.B1.xCoord && Louis.yCoord < Woo.two.B1.yCoord){
			int kingX = Louis.xCoord;
			int b1X = Woo.two.B1.xCoord;
			int kingY = Louis.yCoord;
			int b1Y = Woo.two.B1.yCoord;
			while(kingX>b1X && kingY<b1Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b1X, kingY); 
			    b1X++;
			    kingY++;
			}
		    }
		}
		if(Woo.two.B1.canMove(Woo.two.B2.xCoord, Woo.two.B2.yCoord, Louis.xCoord, Louis.yCoord)){
		    if (Louis.xCoord + Louis.yCoord > Woo.two.B2.xCoord + Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX>b2X && kingY>b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b2X, b2Y); 
			    b2X++;
			    b2Y++;
			}
		    }
		    if (Louis.xCoord + Louis.yCoord < Woo.two.B2.xCoord + Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX<b2X && kingY<b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, kingY); 
			    kingX++;
			    kingY++;
			}
		    }
		    if (Louis.xCoord < Woo.two.B2.xCoord && Louis.yCoord > Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX<b2X && kingY>b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, kingX, b2Y); 
			    kingX++;
			    b2Y++;
			}
		    }
		    if (Louis.xCoord > Woo.two.B2.xCoord && Louis.yCoord < Woo.two.B2.yCoord){
			int kingX = Louis.xCoord;
			int b2X = Woo.two.B2.xCoord;
			int kingY = Louis.yCoord;
			int b2Y = Woo.two.B2.yCoord;
			while(kingX>b2X && kingY<b2Y){
			    canEated = canEated && dangerCheck(Woo.two.color, b2X, kingY); 
			    b2X++;
			    kingY++;
			}
		    }
		}
	    }
	}
	return inCheck || !canEated || !kingMove;
    }
}

