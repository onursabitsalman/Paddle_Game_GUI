import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class StartWindow extends JFrame {
	
	JLabel titleLabel = new JLabel("OOP GAME");	
	JLabel lblStart = new JLabel("START");
	JLabel lblLoad = new JLabel("LOAD");
	JLabel lblSettings = new JLabel("SETTINGS");
	JLabel lblQuit = new JLabel("QUIT");
	
	JPanel contentPanel = new JPanel();	
	JPanel menuPanel = new JPanel();
	
	//SettingsWindow sw;
	
	JLabel backgroundImage = new JLabel(new ImageIcon("Pictures/mario.jpg"));	
	
	public StartWindow() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 100, 800, 600);
		setContentPane(contentPanel);
		contentPanel.setBounds(0, 0, 784, 561);
		contentPanel.setLayout(null);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		titleLabel.setBounds(150, 80, 485, 121);
		contentPanel.add(titleLabel);
		
		menuPanel.setBounds(289, 212, 206, 232);
		contentPanel.add(menuPanel);
		menuPanel.setLayout(new GridLayout(4, 0, 5, 5));
		menuPanel.setOpaque(false);
		
		lblStart.addMouseListener(new MyMouseEvents());
		lblStart.setForeground(Color.WHITE);
		lblStart.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblStart.setHorizontalAlignment(SwingConstants.CENTER);
		menuPanel.add(lblStart);
		lblSettings.addMouseListener(new MyMouseEvents());
		
		lblLoad.addMouseListener(new MyMouseEvents());
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setForeground(Color.WHITE);
		lblLoad.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		
		menuPanel.add(lblLoad);
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		menuPanel.add(lblSettings);
		
		lblQuit.addMouseListener(new MyMouseEvents());
		lblQuit.setForeground(Color.WHITE);
		lblQuit.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblQuit.setHorizontalAlignment(SwingConstants.CENTER);
		menuPanel.add(lblQuit);
		


		backgroundImage.setBounds(0, 0, 794, 571);
		contentPanel.add(backgroundImage);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	//SettingsWindow setting = null;
	GameWindow window = null;
	

	public class MyMouseEvents extends MouseAdapter{
		
		public void mouseClicked(MouseEvent e) {
			

			if(e.getSource().equals(lblStart)){
				

					window = new GameWindow(0);
					window.setVisible(true);		
				
			}	
				
			else if(e.getSource().equals(lblSettings)){
				//setting = new SettingsWindow();
					
			}
				
			else if(e.getSource().equals(lblQuit)){
				System.exit(1);
				
			}
		}
	}
}