import java.awt.Color;
import java.awt.Graphics;

public class Balas {

	public int x;

	public int y;
	
	public Color c = new Color(0,0,0);
	public char direction;
	public int speed=5;

	public int size=5;
	
	
	
	
	
	
	
public Balas(Guardia g) {
		// TODO Auto-generated constructor stub
	
	this.direction=g.getDireccion();
	if(g.getDireccion()=='r'){
		this.x=g.posicionX+g.ancho;
		this.y=-(this.size/2)+g.posicionY+g.alto/2;
		
	}else if(g.getDireccion()=='l'){
		this.x=g.posicionX;
		this.y=-(this.size/2)+g.posicionY+g.alto/2;
		
	}else if(g.getDireccion()=='u'){
		this.x=-(this.size/2)+g.posicionX+g.ancho/2;
		this.y=g.posicionY;
		
	}else if(g.getDireccion()=='d'){
		this.x=-(this.size/2)+g.posicionX+g.ancho/2;
		this.y=g.posicionY+g.alto;
		
	}
	
	
	
	}





public void move(){

	if (this.getDirection()=='r'){
			setX(getX()+getSpeed());
			
	}
			
	if ( getDirection()=='l'){
		 setX( getX()-this.getSpeed());
		
	}
	
	if( getDirection()=='u' ){
		
		 setY( getY()-getSpeed());
		
	}
	
	if( getDirection()=='d'){
				
				 setY( getY()+getSpeed());
				
				
			}
	
	  
}
	
	public void draw(Graphics g){
		g.setColor(c);
		g.fillOval( this.x, this.y, this.size, this.size);
	}





	public int getX() {
		return x;
	}





	public int getY() {
		return y;
	}










	public Color getC() {
		return c;
	}





	public int getDirection() {
		return direction;
	}





	public int getSpeed() {
		return speed;
	}





	public void setX(int x) {
		this.x = x;
	}





	public void setY(int y) {
		this.y = y;
	}






	public void setC(Color c) {
		this.c = c;
	}





	public void setDirection(char direction) {
		this.direction = direction;
	}





	public void setSpeed(int speed) {
		this.speed = speed;
	}









	public int getSize() {
		return size;
	}










	public void setSize(int size) {
		this.size = size;
	}
	
	
	

}
