

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import soundsLoader.*;
import javax.swing.JFrame;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
    private static final int PWIDTH = 709;
    private static final int PHEIGHT = 709; //tamaño del panel
    private Thread animator; //controla la animación
    private volatile boolean running = false;
    private volatile boolean gameOver = false;
    private volatile boolean isPaused = false;

    public Guardia guardia;
    public BufferedImage background, mainMenu, gameOverMenu, introImage;
    public BufferedImage ammoSS = null;

    private ClipsLoader clipsLoader;
    private static final String SNDS_FILE = "clipsInfo.txt";

	public ArrayList <Balas> ammo = new ArrayList<Balas>();
	public Item extra;
	public int money=5000;
	public int c=0;

	private  SaqFactory factory = new SaqFactory();;
	private  int state = 0;
	public int muertos = 0;

	public ArrayList <Saqueador> oleada = new ArrayList<Saqueador>();
	private Saqueador[] tipos = new Saqueador[16];
	public int highScore = 0, yourScore = 0;
	public int numOleada=1;
	public Coordinates coordinates;

  public BufferedImage n;


   // private ClipsLoader clipsLoader;
    //private static final String SNDS_FILE = "clipsInfo.txt";

	public void nuevaoleada(){
    ammo= new ArrayList<Balas>();
		oleada = new ArrayList<Saqueador>();
		this.guardia.life=this.guardia.life+10;
		this.money=this.money+2000;

	}


public void newGame(){
	//this.m
  ammo= new ArrayList<Balas>();
  oleada = new ArrayList<Saqueador>();
	this.guardia.lammo=30;
	this.guardia.posicionX=100;
	this.guardia.posicionY=100;
	this.guardia.life=100;
	this.money=5000;
  this.muertos=0;

}

    private void init() {
        BufferedImageLoader loader = new BufferedImageLoader();
        BufferedImage guardiaSS = null;
        BufferedImage saqueadorSS = null;



        try {
        	guardiaSS = loader.loadImage("Sprites/cop.png");
            saqueadorSS = loader.loadImage("Sprites/thiefs.png");
            ammoSS = loader.loadImage("Sprites/ammo.png");
            background = loader.loadImage("Sprites/background.png");

            mainMenu = loader.loadImage("Sprites/mainMenu.png");
            introImage = loader.loadImage("Sprites/intro.png");
            gameOverMenu = loader.loadImage("Sprites/gameOver.png");
            this.n=saqueadorSS;

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.guardia = new Guardia(guardiaSS);
       //////CORRE
        tipos[0] = this.factory.crearSaqueador(saqueadorSS,0);
        tipos[1] = this.factory.crearSaqueador(saqueadorSS,1);
        tipos[2] = this.factory.crearSaqueador(saqueadorSS,2);
        tipos[3] = this.factory.crearSaqueador(saqueadorSS,3);
        tipos[4] = this.factory.crearSaqueador(saqueadorSS,4);
        tipos[5] = this.factory.crearSaqueador(saqueadorSS,5);
        tipos[6] = this.factory.crearSaqueador(saqueadorSS,6);
        tipos[7] = this.factory.crearSaqueador(saqueadorSS,7);
        tipos[8] = this.factory.crearSaqueador(saqueadorSS,8);
        tipos[9] = this.factory.crearSaqueador(saqueadorSS,9);
        tipos[10] = this.factory.crearSaqueador(saqueadorSS,10);
        tipos[11] = this.factory.crearSaqueador(saqueadorSS,11);
        tipos[12] = this.factory.crearSaqueador(saqueadorSS,12);
        tipos[13] = this.factory.crearSaqueador(saqueadorSS,13);
        tipos[14] = this.factory.crearSaqueador(saqueadorSS,14);
        tipos[15] = this.factory.crearSaqueador(saqueadorSS,15);

    }

    public GamePanel(){
        setBackground(Color.white);
        setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
        setFocusable(true);
        requestFocus();
        readyForTermination();

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                testPress(e.getKeyCode());
            }
            public void keyReleased(KeyEvent e){
                testRelease();
            }
        });

        // Initialize Clip Loaders
        clipsLoader = new ClipsLoader(SNDS_FILE);

        coordinates = new Coordinates(clipsLoader);
        addMouseListener( new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mousePress(e.getX(), e.getY());
			}
		});


        init();



    } //GamePanel()


	public void addNotify()
    {
        super.addNotify();
        startGame();
    }//addNotify

    private void startGame()
    {
        if(animator == null || !running){
            animator = new Thread(this);
            animator.start();                // start busca el run
        }
    }//startGame()

    public void stopGame(){
        running = false;
    }//stopGame()

    public void run(){
        running = true;
        while(running){
            gameUpdate();
            gameUpdate();
            gameRender();
            paintScreen();

            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){}
        }
        System.exit(0);
    }//run()


    ////WAAAA
    private void gameUpdate(){

        if(!isPaused && !gameOver){
        	if(this.state==0){
        		clipsLoader.stop("inGame");
        		clipsLoader.stop("gameOver");
        		clipsLoader.play("mainMenu", true);
        	}

		if(this.state==1){
			clipsLoader.stop("gameOver");
    		clipsLoader.stop("mainMenu");
			clipsLoader.play("inGame", true);

			if(this.money<=0 || this.guardia.getLife()<=0){
                yourScore = this.muertos;
			    if (yourScore > highScore) {
                    highScore = muertos;
                }
                newGame();
				this.state=2;
			}

			if(this.muertos==this.numOleada*10){
				this.nuevaoleada();
				this.numOleada=this.numOleada+1;
			}



			if(c%100==0){
				int x = ThreadLocalRandom.current().nextInt(1, 14+ 1);
        Saqueador n= this.factory.crearSaqueador(this.n,x);

			this.oleada.add(n);
			}

			for(int t=0; t<this.oleada.size(); t++){
				this.oleada.get(t).atacar(this, this.oleada.get(t));

			}
					if(guardia.getLammo()==0){
						int x = ThreadLocalRandom.current().nextInt(1, PWIDTH + 1);

						int y = ThreadLocalRandom.current().nextInt(30, PHEIGHT-20 + 1);

					   if(extra==null){
							extra= new Item(x,y, 30, ammoSS);

					   }
					}

					 if(extra!= null && extra.recargar(this.guardia)){
						 extra=null;
					 }


					 if(!ammo.isEmpty()){
						 for (int i=0; i<ammo.size(); i++){
							ammo.get(i).move();
						 }
			    	  }

					 c++;
			}

			if(this.state==2){
				clipsLoader.stop("inGame");
	    		clipsLoader.stop("mainMenu");
				clipsLoader.play("gameOver", true);
			}

			if(this.state==3){
                clipsLoader.stop("gameOver");
                clipsLoader.stop("inGame");

            }

        }
}//gameUpdate()

    private Graphics dbg;
    private Image dbImage = null;

    private void gameRender(){
        if(dbImage == null){
            dbImage = createImage(PWIDTH,PHEIGHT);
            if(dbImage == null){
                System.out.println("dbImage is null");
                return;
            }else{
                dbg = dbImage.getGraphics();
            }
        }


        dbg.setColor(Color.white);
        dbg.fillRect(0,0,PWIDTH,PHEIGHT);

        if(this.state == 0){
        	dbg.drawImage(mainMenu,0,0, null);
        }

        if(this.state==1){
        dbg.drawImage(background,0,0, null);


    	if(guardia.getLammo()==0){
    		try{
  	    	  extra.draw(dbg);

    		}catch (Exception e) {
    		     System.out.println("ss");
    		}

		}
  	  this.guardia.draw(dbg);
  	  for(int j=0; j<this.oleada.size();j++ ){
  		  this.oleada.get(j).draw(dbg);
  	  }



  	  if(!ammo.isEmpty()){
				 for (int i=0; i<ammo.size(); i++){
					ammo.get(i).draw(dbg);
				 }
	    	  }


  	  	dbg.setColor(new Color(255,255,0));
            dbg.setFont(new Font("TimesRoman", Font.PLAIN, 12));
        dbg.drawString(""+guardia.getLife(), 54, 25);
        dbg.drawString(""+guardia.getLammo(), 152, 25);
        dbg.drawString(""+this.money, 253, 25);
        dbg.drawString(""+this.muertos, 430, 25);
        dbg.drawString(""+this.numOleada, 672, 25);

        }

        if (state == 2){
            dbg.setFont(new Font("TimesRoman", Font.PLAIN, 48));
            dbg.setColor(new Color(255,255,0));
        	dbg.drawImage(gameOverMenu,0,0, null);
        	dbg.drawString(""+yourScore,280,398);
            dbg.drawString(""+highScore,580,398);
        }

        if (state == 3){
            dbg.drawImage(introImage, 0,0, null);
        }

    }//gameRender()

    private void gameOverMessage(){
        Graphics g;
        g=this.getGraphics();
        g.drawString("GameOver",10,10);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(dbImage != null) {
            g.drawImage(dbImage, 0, 0, null);
        }

    }

    private void readyForTermination() {
        addKeyListener( new KeyAdapter() { // listen for esc, q, end, ctrl-c
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if ((keyCode == KeyEvent.VK_ESCAPE) ||
                        (keyCode == KeyEvent.VK_Q) ||
                        (keyCode == KeyEvent.VK_END) ||
                        ((keyCode == KeyEvent.VK_C) && e.isControlDown()) ) {
                    running = false;
                }
            }
        });
    } // end of readyForTermination()


////////////


   private void testPress(int cx){
        if (!gameOver && !isPaused) {
        	if(this.state==1){
	        	    if(cx==37){
	                guardia.moveLeft();
	            }
	            else if(cx==38){
	                guardia.moveUp();

	            }
	            else if(cx==39){
	                guardia.moveRight();

	            }
	            else if(cx==40){
	                guardia.moveDown();
	            }

	            if(cx == 32){
	  	    	  if(guardia.lammo>0){
	  	    		guardia.setLammo((guardia.getLammo())-1);
	  	    		 Balas b = new Balas(guardia);
	  	    		 clipsLoader.play("gunshot1", false);
	  	    		 ammo.add(b);
	  	    		 }
	  	    	  }
	            }
        	}
        }

    private void testRelease(){
       guardia.stop();
    }

    private void mousePress(int cx, int cy){
    	this.state = coordinates.check(cx, cy,  this.state);
    }

    //recupera del game render

    private void paintScreen(){
        Graphics g;
        try{
            g = this.getGraphics();
            if((g != null) && (dbImage != null))
                g.drawImage(dbImage,0,0,null);
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
        }
        catch(Exception e){
            System.out.println("Graphics context error: "+e);
        }
    }

    public void pauseGame(){
        isPaused = true;
    }

    public void resumeGame(){
        isPaused = false;
    }

    public static void main(String args[]){
        JFrame app = new JFrame("Test");
        app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setResizable(false);
        app.setVisible(true);
    }

	public Guardia getGuardia() {
		return guardia;
	}

	public void setGuardia(Guardia guardia) {
		this.guardia = guardia;
	}

	public ArrayList<Balas> getAmmo() {
		return ammo;
	}
	public void setAmmo(ArrayList<Balas> ammo) {
		this.ammo = ammo;
	}

}
