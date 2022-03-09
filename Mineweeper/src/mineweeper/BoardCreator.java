package mineweeper;

import java.util.Random;

public class BoardCreator extends Mineweeper {
	static Random random = new Random();   
	
	public static void BombDrop() {
		for (int o = 0; o < bombamount; o++) {
				
				int posX = random.nextInt(sizeX);
				int posY = random.nextInt(sizeY);
				if (board[posX][posY] != 9) {
				board[posX][posY] = 9;
				
				for (int i = posX - 1 ; i < posX + 2; i++) 
					{
					for (int j = posY - 1; j < posY + 2; j++) 
						{
						if (i >= 0 && i < sizeX && j >= 0 && j < sizeY && board[i][j] != 9) { board[i][j] += 1; }
						}
					} 
				} //else {BombDrop();}
			  }
			}
			public static void CreateBoard() {
			board[0][0] = 0;
			for (int i = 0; i < sizeX; i++) {
				for (int j = 0; j < sizeY; j++) {
				board[i][j] = 0;
				}
			}
			BombDrop();
			}
}
