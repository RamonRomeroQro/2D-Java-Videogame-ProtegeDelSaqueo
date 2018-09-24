
public  class  Personaje {
	public char direccion;
	public int posicionX;
	public int posicionY;
	public int alto=16;
	public int life=5;
	public int ancho=16;
	public int steps;
	
	
	
	
	
	public Personaje(char direccion, int posicionX, int posicionY) {
		this.direccion = direccion;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
	}
	
	
	public void recibedaño(){
		this.life= this.life-1;
	}
	public int getPosicionX() {
		return posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public int getAlto() {
		return alto;
	}
	public int getLife() {
		return life;
	}
	public int getAncho() {
		return ancho;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}



	public void moveLeft() {
		setDireccion('l');
		this.setPosicionX(getPosicionX()-this.steps);
		
	}

	public void moveRight() {
		setDireccion('r');

		this.setPosicionX(getPosicionX()+this.steps);

	}

	public void moveDown() {
		setDireccion('d');

		this.setPosicionY(getPosicionY()+this.steps);

		// TODO Auto-generated method stub
		
	}

	public void moveUp() {
		setDireccion('u');

		this.setPosicionY(getPosicionY()-this.steps);

		// TODO Auto-generated method stub
		
	}


	public char getDireccion() {
		return direccion;
	}


	public int getSteps() {
		return steps;
	}


	public void setDireccion(char direccion) {
		this.direccion = direccion;
	}


	public void setSteps(int steps) {
		this.steps = steps;
	}


	


}
