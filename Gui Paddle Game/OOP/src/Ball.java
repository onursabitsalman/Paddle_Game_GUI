import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ball extends JLabel{
	
	private static ImageIcon [] ballImage = {new ImageIcon("Pictures/ball.jpg")};
	public static final int [] WIDTH = {40};
	public static final int [] HEIGHT = {40};
	public static final int [] STEP = {15};
	
	public static final int BALL1 = 0;
	public static final int BALL2 = 1;
	
	public static final int UP = -1;
	public static final int DOWN = 1;
	
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	

	private int x ,type,y,yDirection = -1,xDirection = 1;
	
	public Ball(int x,int y,int type) {

		super(ballImage[type]);
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
	public int getXDirection() {
		return xDirection;
	}
	public void setXDirection(int xDirection) {
		this.xDirection = xDirection;
	}
	public int getYDirection() {
		return yDirection;
	}
	public void setYDirection(int direction) {
		this.yDirection = direction;
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
