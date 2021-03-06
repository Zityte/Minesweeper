package mineweeper;

public class Interaction extends Mineweeper{
	
	static int PlacedFlags = 0; //total amount of flags placed
	static int FlaggedBombs = 0; // amount of bombs flagged
	
	public static void PrintBoard()  {
		
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				System.out.print(board[j][i] + " ");
			}
			System.out.print("  ");
			for (int j = 0; j < sizeX; j++) {
				System.out.print(cover[j][i] + " ");
			}
			System.out.println();
		}
	}
	public static void interaction(int posX, int posY, Boolean click, Boolean player) {
			
		if (click) { 
			if (cover[posX][posY] == 0) {
				cover[posX][posY] = 2;
				PlacedFlags += 1;
				if (board[posX][posY] == 9) {FlaggedBombs += 1;}
				if (FlaggedBombs == PlacedFlags && FlaggedBombs == bombamount) {Victory();}
			} else {if (board[posX][posY] == 9) {FlaggedBombs --;}
			if (cover[posX][posY] == 2) {cover[posX][posY] = 0; PlacedFlags --;}
			}
		}else  if (board[posX][posY] == 9 ) {
				if (player && cover[posX][posY] != 2) {GameOver();}
		} else {
			cover[posX][posY] = 1; // else uncover tile
			if (board[posX][posY] == 0 || player){ // if tile equals 0 or the player pressed it then loop thru every adjacent tile and interact 
			
			 for (int i = posX - 1 ; i < posX + 2; i++) {
			for (int j = posY - 1; j < posY + 2; j++) { // two for loops for searching the immediate surroundings 
				
				if(i >= 0 && i < sizeX && j >= 0 && j < sizeY && board[i][j] != 9 && (i != posX || j != posY) && cover[i][j] != 1 && (board[i][j] == 0 || board[posX][posY] == 0)) // make sure everything is inbounds and it isn't a bomb
				{interaction(i,j,false,false);}
				
				}
			}
				
			
			}
		}
	}
	public static void Victory() {
		System.out.println("Victory");
		GameWindow.makeGameWindow();
	}
	public static void CreateCover() {
		cover[0][0] = 0;
		for (int i = 0; i < sizeX; i++) {
			for (int j = 0; j < sizeY; j++) {
			cover[i][j] = 0;
			}
		}
	}
	public static void GameOver() {
		System.out.println("Game over");
		GameWindow.makeGameWindow();
	}
	public static void PrintView() {
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				switch(cover[j][i]) {
				case 0:
					System.out.print("# ");
					break;
				case 1:
					if (board[j][i] != 0) {
						System.out.print(board[j][i] + " ");
					} else {System.out.print("  ");}
					
					break;
				case 2:
					System.out.print("! ");
					
				}
			}
			System.out.println();
		}
	}
	public static void CreateView() {
		for (int i = 0; i < sizeY; i++) {
			for (int j = 0; j < sizeX; j++) {
				switch(cover[j][i]) {
				case 0:
					view[j][i] = "#";
					break;
				case 1:
					if (board[j][i] != 0) {
						view[j][i] = Integer.toString(board[j][i]);
					} else {view[j][i] = " ";}
					
					break;
				case 2:
				view[j][i] = "!";
					
				}
			}
			
		}
	}
}