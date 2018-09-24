import java.awt.Color;
import java.awt.Graphics;
import soundsLoader.*;

public class Coordinates {
	
	public int x;
	public int y;
	public int state;
    private ClipsLoader clipsLoader;

	public Coordinates(ClipsLoader clipsLoader){
	    this.clipsLoader = clipsLoader;
		this.x=0;
		this.y=0;
	}

	public int check(int x, int y, int currentState){
		if (currentState == 2){
		    if ((x >= 252 &&  x <= 252 + 206) && (y >= 446 && y <= 446+81)){
                clipsLoader.play("button1", false);
		    	currentState = 0;
	        }
		}
		
		else if (currentState == 0){
		    if ((x >= 387 &&  x <= 387 + 206) && (y >= 399 && y <= 399+81)){
		        clipsLoader.play("button1", false);
	            currentState = 1;
	            }
		    else if ((x >= 123 &&  x <= 123 + 206) && (y >= 399 && y <= 399 + 81)){
                clipsLoader.play("button1", false);
		    	currentState = 3;
		    }
		}

		else if (currentState == 3){
            clipsLoader.play("button1", false);
		    currentState = 0;
        }
		return currentState;
    }
	
	public int getX() { return x; }
	public int getY() { return y; }	
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }

}
