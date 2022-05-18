package mineweeper;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MineWindow extends Mineweeper{

    static JTextField bombs = new JTextField("30",5);
    static JTextField XSize = new JTextField("10",4);
    static JTextField YSize = new JTextField("10",4);
	static int buttonout;
	static int buttonX;
	static int buttonY;
	static boolean click;
    
    static JFrame frame = new JFrame("Mineweeper");
		
	
	public static void Makewindow() throws IOException {
		
		JPanel lrClick = new JPanel();
		JButton Clear = new JButton("Clear");
		Clear.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
            	click = false;
            }
      });
		JButton Flag = new JButton("Flag");
        Flag.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    click = true;
                }
          });
          JButton Reset = new JButton("Reset");
        Reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                GameWindow.makeGameWindow();
                }
          });
         
		lrClick.add(Clear);
        lrClick.add(Reset);
		lrClick.add(Flag);
        lrClick.add(bombs);
        lrClick.add(XSize);
        lrClick.add(YSize);
		frame.add(lrClick);
	    
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}
    public static void buttonclick(){
        Interaction.interaction(buttonX, buttonY, click, true);
        System.out.println("X " + buttonX 
        + "\nY " + buttonY 
        + "\nFlagged bombs " + Interaction.FlaggedBombs 
        + "\nPlaced flags " + Interaction.PlacedFlags); 
        
        Interaction.PrintView();
        GameWindow.UpdateWindow();
    }
  
	
	
}
