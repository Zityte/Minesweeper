package mineweeper;

import java.util.Scanner;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Mineweeper {
	
	static JFrame frame = new JFrame();
	static int sizeX = 10; // width of the board
	static int sizeY = 8; // height of the board
	static int[][] board = new int[sizeX][sizeY]; // board where all the numbers are held
	static int[][] cover = new int[sizeX][sizeY]; // cover where the viewability of the board below and placed flags is stored
	static int bombamount = 10;

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		Interaction.CreateCover();
		BoardCreator.CreateBoard();
		while (true) {
		Interaction.PrintView();
		Interaction.interaction(scan.nextInt(), scan.nextInt(), scan.nextBoolean(), true);
		}
		
	}
	

}
