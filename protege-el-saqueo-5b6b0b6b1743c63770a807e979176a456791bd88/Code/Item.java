import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.ArrayList;

public class Item {
	public BufferedImage spriteSheet;

	public int px;
	public int py;
	public int adition;
	public int size=20;
	
	public Item(int x, int y, int adition, BufferedImage ss) {
	    this.spriteSheet = ss;
		this.px = x;
		this.py = y;
		this.adition = adition;
	}

	public boolean recargar(Guardia g){
		if(g.getPosicionX()>this.px  && g.getPosicionX()<this.px+this.size && g.getPosicionY()>this.py && g.getPosicionY()<this.py+this.size){
		g.setLammo(g.getLammo()+adition);
		return true;
		}
		else{
			return false;
		}
	}
	
	public void draw (Graphics g){
        g.drawImage(spriteSheet, this.px, this.py, this.size, this.size, null);
	}

	public int getAdition() {
		return adition;
	}

	public int getSize() {
		return size;
	}


	public void setAdition(int adition) {
		this.adition = adition;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPx() {
		return px;
	}

	public int getPy() {
		return py;
	}

	public void setPx(int px) {
		this.px = px;
	}

	public void setPy(int py) {
		this.py = py;
	}
	
}
