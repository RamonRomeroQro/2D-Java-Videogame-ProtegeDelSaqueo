import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Guardia extends Personaje{
	public int lammo;
	

    public BufferedImage spriteSheet;
    public BufferedImage[] guardiaUp = new BufferedImage[3];
    public BufferedImage[] guardiaDown = new BufferedImage[3];
    public BufferedImage[] guardiaLeft = new BufferedImage[3];
    public BufferedImage[] guardiaRight = new BufferedImage[3];
    public BufferedImage[] guardiaStanding = new BufferedImage[1];
    private Animation walkup, walkdown, walkleft, walkright, animation, standing;

    public Guardia(BufferedImage ss) {
    	super('d', 100, 100);
    	this.life=100;
        this.spriteSheet = ss;
        this.steps=15;
        this.lammo=30;
      
        BufferedImage[] guardiaUp       =  {getSprite(0,0), getSprite(1,0), getSprite(2, 0)};
        BufferedImage[] guardiaDown     =  {getSprite(3,0), getSprite(4, 0), getSprite(5, 0)};
        BufferedImage[] guardiaLeft     =  {getSprite(6,0), getSprite(7, 0), getSprite(8, 0)};
        BufferedImage[] guardiaRight    =  {getSprite(9,0), getSprite(10, 0), getSprite(11, 0)};
        BufferedImage[] guardiaStanding =  {guardiaDown[0]};
        
        walkup = new Animation(guardiaUp, 1);
        walkdown = new Animation(guardiaDown, 1);
        walkleft = new Animation(guardiaLeft, 1);
        walkright = new Animation(guardiaRight, 1);
        standing = new Animation(guardiaStanding,1);
        animation = standing;
    }

    public void moveRight(){
    	this.setDireccion('r');
        this.posicionX += this.steps;
        animation = walkright;
        animation.start();
    }
    public void moveLeft(){
    	this.setDireccion('l');

        this.posicionX -= this.steps;
        animation = walkleft;
        animation.start();
    }

    public void moveUp(){
    	this.direccion='u';

        this.posicionY -= this.steps;
        animation = walkup;
        animation.start();
    }

    public void moveDown(){
    	this.direccion='d';

        this.posicionY += this.steps;
        animation = walkdown;
        animation.start();
    }

    public void stop(){
        animation.stop();
        animation.reset();
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {
        return spriteSheet.getSubimage(xGrid * 27, yGrid * 35, 18, 33);
    }

    public void draw(Graphics g) {
        animation.update();
        g.drawImage(animation.getSprite(), this.posicionX, this.posicionY, 18, 33, null);
    }

	public int getLammo() {
		return lammo;
	}

	public void setLammo(int lammo) {
		this.lammo = lammo;
	}
}
