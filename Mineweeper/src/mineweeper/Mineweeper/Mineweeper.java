

import java.util.Iterator;
import java.util.Scanner;
import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.FlowLayout;

public class Mineweeper {
	
	static int sizeX = 10; // width of the board
	static int sizeY = 8; // height of the board
	static int[][] board = new int[sizeX][sizeY]; // board where all the numbers are held
	static int[][] cover = new int[sizeX][sizeY]; // cover where the viewability of the board below and placed flags is stored
	static int bombamount = 10;
	static String[][] view = new String[sizeX][sizeY];

	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		Interaction.CreateCover();
		BoardCreator.CreateBoard();
		MineWindow.Makewindow();
		int x = MineWindow.buttonX;
		int y = MineWindow.buttonY;
		Interaction.PrintView();
		
		//while (true) {
			//if (MineWindow.buttonX != x || MineWindow.buttonY != y) {
				
				//x = MineWindow.buttonX;
				//y = MineWindow.buttonY;
			//}
			
		//}
	}
}