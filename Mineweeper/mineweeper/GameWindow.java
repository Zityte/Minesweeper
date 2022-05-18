package mineweeper;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameWindow extends MineWindow{

    static JButton[][] buttons; 
    static  JPanel panel = new JPanel();
    static boolean firstgame = true;
    public static void makeGameWindow() {
        System.out.println("Pannel" + panel);
        if (firstgame == false){
            for (int pos = 0; pos < sizeX*sizeY; pos++) {
                panel.remove(pos);
                }
            }
        frame.remove(panel);
        sizeX = Integer.parseInt(MineWindow.XSize.getText());
        System.out.println("sizeX " + sizeX);
        sizeY = Integer.parseInt(MineWindow.YSize.getText());
        bombamount = Integer.parseInt(MineWindow.bombs.getText());
        buttons = new JButton[sizeX][sizeY];
        board = new int[sizeX][sizeY];
        cover = new int[sizeX][sizeY];
        view = new String[sizeX][sizeY];

        
		panel.setLayout(new GridLayout(sizeY, sizeX));
		int pos = 0;
		for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
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
        frame.add(panel);
        BoardCreator.CreateBoard();
        Interaction.CreateCover();
        Interaction.CreateView();
        panel.updateUI();
        firstgame = false;
        }
        public static void UpdateTile(int x, int y) {
            Interaction.CreateView();
                    switch (view[x][y]) {
                        case "#":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//Covered.png"));
                            break;
                        case " ":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//Empty.png"));
                            break;
                        case "1":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//1.png"));
                            break;
                        case "2":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//2.png"));
                            break;
                        case "3":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//3.png"));
                            break;
                        case "4":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//4.png"));
                            break;
                        case "5":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//5.png"));
                            break;
                        case "6":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//6.png"));
                            break;
                        case "7":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//7.png"));
                            break;
                        case "8":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//8.png"));
                            break;
                        case "!":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//Flag.png"));
                            break;
                        case "9":
                            buttons[x][y].setIcon(new ImageIcon("mineweeper//resources//Bomb.png"));
                            break;
                        default:
                            break;
                    
            }
        }
        public static void UpdateWindow(){
            for (int y = 0; y < sizeY; y++) {
                for (int x = 0; x < sizeX; x++) {
                    UpdateTile(x,y);
                }
            }
        }
    }