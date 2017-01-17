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
	String[][] ans = new String[8][8];
	for (int i = 0; i < 8; i ++){
	    for (int b = 0; b < 8; b ++){
		ans[i][b] = board[i][b];
	    }
	}
	for (int a = 0; a < 8; a ++){
	    String temp0 = ans[0][a];
	    ans[0][a] = ans[7][a];
	    ans[7][a] = temp0;
	    String temp1 = ans[1][a];
	    ans[1][a] = ans[6][a];
	    ans[6][a] = temp1;
	    String temp2 = ans[2][a];
	    ans[2][a] = ans[5][a];
	    ans[5][a] = temp2;
	    String temp3 = ans[3][a];
	    ans[3][a] = ans[4][a];
	    ans[4][a] = temp3;
	}
	for (int i = 0; i < 8; i ++){
	    for (int a = 0; a < 8; a ++){
		System.out.print(ans[i][a]);
	    }
	    System.out.println(" ");
	}
    }
    public void setPieceLocation(String name, int destinationX, int destinationY){
	board[destinationY][destinationX] = name;
    }

    public String getLocation(int x, int y){
	return board[y][x];
    }

    public int[] getCoordinate(String type){
	int[] ans = new int[2];
	return ans;
    }

    public void setBoard(int Oldx, int Oldy, int Newx ,int Newy){
	String p = getLocation(Oldx, Oldy);
	String a = getLocation(Newx, Newy);
	setPieceLocation(p, Newx, Newy);
	setPieceLocation(a, Oldx, Oldy);
    }
    public static void main(String[] args){
        Board test = new Board();
	test.printBoard();
	test.flipBoard();
	test.board[4][3] = "I";
	test.flipBoard();
	//test.printBoard();
	//System.out.println(test.getLocation(0,1));
    }
}
