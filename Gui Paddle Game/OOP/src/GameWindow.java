import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class GameWindow extends JFrame {
		
	private JPanel contentPane;
	private final int SCREENHEIGHT= 900;
	private final int SCREENWIDTH= 1200;
	public boolean ballMove = false;
	
	private JLabel bigText = new JLabel();
	private boolean paused = false;
	
	private Paddle paddle1;
	private Ball ball1;
	
	private Timer motion = new Timer(10, new TimerListener());
	
	private int counterX = 0 , counterY = 0;
	
	public GameWindow(int paddleTipi) {
		
		paddle1 = new Paddle(450,820,paddleTipi);
		ball1 = new Ball(490,790,paddleTipi);
		init();
	}
	
	public void init(){
		
		setBounds(0, 0, SCREENWIDTH, SCREENHEIGHT);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);
		contentPane.setBackground(Color.BLACK);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.addKeyListener(new MyController());
		contentPane.add(paddle1);
		contentPane.add(ball1);
		
		bigText.setHorizontalAlignment(SwingConstants.CENTER);
		bigText.setVisible(false);
		bigText.setFont(new Font("Tekton Pro", Font.PLAIN, 53));
		bigText.setBounds(369, 265, 448, 210);
		contentPane.add(bigText);
		
		motion.start();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Properties");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmPause = new JMenuItem("Pause");
		mntmPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(paused == false){
					paused = true;
					motion.stop();
					bigText.setText("Paused");
					bigText.setVisible(true);
				}
				else{
					paused = false;
					motion.start();
					bigText.setVisible(false);
				}
			}
		});
		
		mnNewMenu.add(mntmPause);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
	}
	
	public class MyController extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
			if(ballMove && !paused){
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					int temp = paddle1.getX()+paddle1.getStep();
					if(temp >= 1050){
						temp = 1050;
					}
					paddle1.setLocation(temp, paddle1.getY());
				}
				
				else if(e.getKeyCode() == KeyEvent.VK_LEFT){
					int temp = paddle1.getX()-paddle1.getStep();
					if(temp  <= 0){
						temp = 0;
					}
					
					paddle1.setLocation(temp, paddle1.getY());
				}
			}
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					ballMove = true;
				}
				
				else if(e.getKeyCode() == KeyEvent.VK_P){
					
					if(paused == false){
						paused = true;
						motion.stop();
						bigText.setText("Paused");
						bigText.setVisible(true);
					}
					else{
						paused = false;
						motion.start();
						bigText.setVisible(false);
					}
					
				}
				
				contentPane.repaint();
		}
	}

	private class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			counterX++;
			counterY++;
			
			if(counterX == 10 ){
				
				int x = 0;
				int y = 0;
				
				if(ballMove){
					
					if(ball1.getX() <= 0){
						ball1.setXDirection(Ball.RIGHT);
					}
					
					if(ball1.getX() >= getWidth() - 2*ball1.getWidth() + 10){
						ball1.setXDirection(Ball.LEFT);
					}
					
					else {
						x = ball1.getX() + (ball1.getStep()*ball1.getXDirection());
						y = ball1.getY() + (ball1.getStep()*ball1.getYDirection());
						ball1.setLocation(x, y);
					}
				}
				
				repaint();		
				counterX = 0;
				
			}
			
			if(counterY == 10 ){
				
				int x = 0;
				int y = 0;
				
				Rectangle rec = paddle1.bounds();
				
				if(ballMove){
					
					if(ball1.getY() <= 0){
						ball1.setYDirection(Ball.DOWN);
					}
					if(rec.intersects(ball1.getBounds())){
						ball1.setYDirection(Ball.UP);
					}
					
					else if(ball1.getY() > 820){
						motion.stop();
						bigText.setText("GAME OVER");
						bigText.setVisible(true);
					}
					
					else {
						x = ball1.getX() + (ball1.getStep()*ball1.getXDirection());
						y = ball1.getY() + (ball1.getStep()*ball1.getYDirection());
						ball1.setLocation(x, y);
					}
				}
				
				repaint();					
				counterY = 0;
				
			}
		}
	}
}