/*
Generates a board / reset the pieces, prints it, and flips it for the other player's turn.
 */
public class Board{
    public String[][] board = new String[8][8];
    public Board(){
        this.newBoard();
    }
    public void newBoard(){
		for (int i = 0; i < 8; i ++){
	    board[1][i] = "P";
	    board[6][i] = "P";
	}
	board[0][0] = "R";
	board[0][1] = "N";
	board[0][2] = "B";
	board[0][3] = "K";
	board[0][4] = "Q";
	board[0][5] = "B";
	board[0][6] = "N";
	board[0][7] = "R";
	board[7][0] = "R";
	board[7][1] = "N";
	board[7][2] = "B";
	board[7][3] = "K";
	board[7][4] = "Q";
	board[7][5] = "B";
	board[7][6] = "N";
	board[7][7] = "R";
	for(int i = 2; i < 6; i ++){
	    for (int a = 0; a < 8; a ++){
		board[i][a] = "E";
	    }
	}
    }
    public void printBoard(){
        for (int i = 0; i < 8; i ++){
	    for (int a = 0; a < 8; a ++){
		System.out.print(board[i][a]);
	    }
	    System.out.println(" ");
	}
    }
    public void flipBoard(){
	for (int a = 0; a < 8; a ++){
	    String temp0 = board[0][a];
	    board[0][a] = board[7][a];
	    board[7][a] = temp0;
	    String temp1 = board[1][a];
	    board[1][a] = board[6][a];
	    board[6][a] = temp1;
	    String temp2 = board[2][a];
	    board[2][a] = board[5][a];
	    board[5][a] = temp2;
	    String temp3 = board[3][a];
	    board[3][a] = board[4][a];
	    board[4][a] = temp3;
	}
    }
    public void setPieceLocation(){
	
    }
    public static void main(String[] args){
        Board test = new Board();
	test.printBoard();
	test.flipBoard();
	test.printBoard();
    }
}
