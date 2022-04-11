package mineweeper;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MineWindow extends Mineweeper{
	static int buttonout;
	static int buttonX;
	static int buttonY;
	static boolean click;
    static JButton[][] buttons = new JButton[sizeY][sizeX];
	
	public static void Makewindow() throws IOException {
		JFrame frame = new JFrame("Mineweeper");
		JPanel panel = new JPanel();
		//BufferedImage image = ImageIO.read(new File("D:\\Gams\\Tools\\Prog\\Mineweeper\\potato.jfif"));
		
		
		panel.setLayout(new GridLayout(sizeY, sizeX));
		int pos = 0;
		for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setActionCommand(Integer.toString(pos));
                panel.add(buttons[i][j], pos);
                pos++;
                buttons[i][j].setPreferredSize(new Dimension(30, 30));
                buttons[i][j].addActionListener(new ActionListener(){
                	public void actionPerformed(ActionEvent e){
                          //if(e.getSource() == buttons) {
                            System.out.println("BUUUTON " + e.getActionCommand());
                            buttonout = Integer.parseInt(e.getActionCommand());
                            buttonX = buttonout % sizeX;
                            buttonY = (buttonout - buttonX) / sizeX;
                            buttonclick();
                          // }
                    }  
                }); 
            }
        }
        UpdateWindow();
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
		lrClick.add(Clear);
		lrClick.add(Flag);
	    //JLabel label = new JLabel(new ImageIcon(image));
	    //panel.add(label);
		frame.add(lrClick);
	    frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}
    public static void buttonclick(){
        System.out.println(buttonX);
        System.out.println(buttonY);
		Interaction.interaction(buttonX, buttonY, click, true);
        Interaction.PrintView();
        System.out.println(Interaction.FlaggedBombs);
        UpdateWindow();
    }
    public static void UpdateWindow() {
        Interaction.CreateView();
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                switch (view[j][i]) {
                	case "#":
                		buttons[i][j].setIcon(new ImageIcon("resources//Covered.png"));
                		break;
                	case " ":
                		buttons[i][j].setIcon(new ImageIcon("resources//Empty.png"));
                		break;
                    case "1":
                        buttons[i][j].setIcon(new ImageIcon("resources//1.png"));
                        break;
                    case "2":
                    	buttons[i][j].setIcon(new ImageIcon("resources//2.png"));
                        break;
                    case "3":
                    	buttons[i][j].setIcon(new ImageIcon("resources//3.png"));
                    	break;
                    case "4":
                    	buttons[i][j].setIcon(new ImageIcon("resources//4.png"));
                    	break;
                    case "5":
                    	buttons[i][j].setIcon(new ImageIcon("resources//5.png"));
                    	break;
                    case "6":
                    	buttons[i][j].setIcon(new ImageIcon("resources//6.png"));
                    	break;
                    case "7":
                    	buttons[i][j].setIcon(new ImageIcon("resources//7.png"));
                    	break;
                    case "8":
                    	buttons[i][j].setIcon(new ImageIcon("resources//8.png"));
                    	break;
                    case "!":
                    	buttons[i][j].setIcon(new ImageIcon("resources//Flag.png"));
                    	break;
                    case "9":
                    	buttons[i][j].setIcon(new ImageIcon("resources//Bomb.png"));
                    	break;
                    default:
                        break;
                }
            
            }
        }
    }
	
	
}
