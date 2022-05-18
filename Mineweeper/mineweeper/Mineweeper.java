package mineweeper;

import java.io.IOException;
import java.util.Scanner;

public class Mineweeper {
	
	static int sizeX; // width of the board
	static int sizeY; // height of the board
	static int bombamount;
	static int[][] board; // board where all the numbers are held
	static int[][] cover; // cover where the viewability of the board below and placed flags is stored
	static String[][] view;

	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		MineWindow.Makewindow();
	}
}
