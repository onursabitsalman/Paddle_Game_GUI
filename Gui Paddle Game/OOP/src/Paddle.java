import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Paddle extends JLabel{
	
	private static ImageIcon [] paddleImage = {new ImageIcon("Pictures/paddle.png")};
	public static final int [] WIDTH = {150};
	public static final int [] HEIGHT = {40};
	public static final int [] STEP = {25};
	
	public static final int PADDLE1 = 0;
	public static final int PADDLE2 = 1;
	

	private int x ,type,y;
	
	public Paddle(int x,int y,int type) {

		super(paddleImage[type]);
		this.type = type;
		this.x =  x;
		this.y = y;
		setBounds(x, y, WIDTH[type], HEIGHT[type]);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getY() {
		return y;
	}
	public int getWidth(){
		return WIDTH[type];
	}
	public int getHeight(){
		return HEIGHT[type];
	}
	public int getStep(){
		return STEP[type];
	}
	public void setLocation(int x, int y){
		super.setLocation(x, y);
		this.x = x;
		this.y = y;
	}
	public void setDelay(int delay) {
	}
}
