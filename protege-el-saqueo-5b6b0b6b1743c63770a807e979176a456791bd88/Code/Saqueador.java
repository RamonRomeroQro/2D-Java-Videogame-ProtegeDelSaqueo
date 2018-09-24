import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class Saqueador extends Personaje{
    public BufferedImage spriteSheet;
    public BufferedImage[] saqueadorUp = new BufferedImage[3];
    public BufferedImage[] saqueadorDown = new BufferedImage[3];
    public BufferedImage[] saqueadorLeft = new BufferedImage[3];
    public BufferedImage[] saqueadorRight = new BufferedImage[3];
    public BufferedImage[] saqueadorStanding = new BufferedImage[2];
    private Animation walkup, walkdown, walkleft, walkright, animation, standing;



    ///

    public int objetivoX;
    public int objetivoY;

	public EstadoSaqueador robando = new Robando();
	public EstadoSaqueador atacando = new Atacando();
	public EstadoSaqueador muerto = new Muerto();

	public EstadoSaqueador current=robando;


	public void clonacion(Saqueador s){
		  spriteSheet = s.spriteSheet;
	     saqueadorUp = s.saqueadorUp;
	      saqueadorDown = s.saqueadorDown;
	      saqueadorLeft = s.saqueadorLeft;
	     saqueadorRight = s.saqueadorRight;
	 saqueadorStanding = s.saqueadorStanding;
	    walkup=s.walkup;
	    walkdown=s.walkdown;
	    walkleft=s.walkleft;
	    walkright=s.walkright;
	    animation=s.animation;
	    standing=s.standing;

objetivoX=s.objetivoX;
	    objetivoY=s.objetivoY;

	 robando= s.robando;
	 atacando = s.atacando;
		 muerto = s.muerto;

		 current=s.current;
		  direccion=s.direccion;
			 posicionX=s.posicionX;
			 posicionY=s.posicionY;
		 alto=s.alto;
			 life=s.life;
		 ancho=s.ancho;
		 steps=s.steps;
	}


	public void atacar(GamePanel p, Saqueador s){

		this.current.atacar(p, s);


	}




    ///









    public Saqueador(BufferedImage ss, int n,int x, int y, int objX, int objY) {
    	super('l', x, y);
    	this.steps=1;
    	this.objetivoX=objX;
    	this.objetivoY=objY;

        this.spriteSheet = ss;
        BufferedImage[] saqueadorDown = {getSprite(0, n), getSprite(1, n), getSprite(2, n), getSprite(3,n)};
        BufferedImage[] saqueadorRight     =  {getSprite(4, n), getSprite(5, n), getSprite(6, n), getSprite(7,n)};
        BufferedImage[] saqueadorUp     =  {getSprite(8, n), getSprite(9, n), getSprite(10, n), getSprite(11,n)};
        BufferedImage[] saqueadorLeft     =  {getSprite(12, n), getSprite(13, n), getSprite(14, n), getSprite(15,n)};
        BufferedImage[] saqueadorStanding =  {getSprite(0, n), getSprite(0,n)};

        walkup = new Animation(saqueadorUp, 1);
        walkdown = new Animation(saqueadorDown, 1);
        walkleft = new Animation(saqueadorLeft, 1);
        walkright = new Animation(saqueadorRight, 1);
        standing = new Animation(saqueadorStanding,1);
        animation = standing;
    }

    public void moveRight(){
        this.posicionX+= this.steps;
        animation = walkright;
        animation.start();
    }
    public void moveLeft(){
        this.posicionX -= this.steps;
        animation = walkleft;
        animation.start();
    }

    public void moveUp(){
        this.posicionY -= this.steps;
        animation = walkup;
        animation.start();
    }

    public void moveDown(){
        this.posicionY += this.steps;
        animation = walkdown;
        animation.start();
    }

    public void stop(){
        animation.stop();
        animation.reset();
    }

    public BufferedImage getSprite(int xGrid, int yGrid) {
        return spriteSheet.getSubimage(xGrid * 26, yGrid * 28, 26, 28);
    }

    public void draw(Graphics g) {
        animation.update();
        g.drawImage(animation.getSprite(), this.posicionX, this.posicionY, 26, 28, null);
    }





	public EstadoSaqueador getRobando() {
		return robando;
	}





	public EstadoSaqueador getAtacando() {
		return atacando;
	}





	public EstadoSaqueador getCurrent() {
		return current;
	}





	public void setRobando(EstadoSaqueador robando) {
		this.robando = robando;
	}





	public void setAtacando(EstadoSaqueador atacando) {
		this.atacando = atacando;
	}





	public void setCurrent(EstadoSaqueador current) {
		this.current = current;
	}





	public EstadoSaqueador getMuerto() {
		return muerto;
	}





	public void setMuerto(EstadoSaqueador muerto) {
		this.muerto = muerto;
	}
}
