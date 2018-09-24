
public class Robando implements EstadoSaqueador {

	@Override
	public void atacar(GamePanel p, Saqueador s) {

		
if(!p.getAmmo().isEmpty()){
		for (int i=0; i<p.getAmmo().size(); i++){
			Balas b=p.getAmmo().get(p.getAmmo().size()-(i+1));
			if(s.getPosicionX()< b.getX() && b.getX()<s.getPosicionX()+s.ancho &&
					s.getPosicionY()<b.getY() && b.getY()<s.getPosicionY()+s.alto					){
				p.getAmmo().remove(p.getAmmo().size()-(i+1));
				s.recibedaño();
				s.setCurrent(s.getAtacando());
			}
			
		}
}
		
	
		
		//Guardia g= p.getGuardia();
		int locx= s.objetivoX;
		int locy= s.objetivoY;
		
		
		
		

		System.out.println(s.getPosicionX());
		System.out.println(s.getPosicionY());
		
		
	
		if(locx<s.getPosicionX()){
			
			s.moveLeft();
		
		
			
		}else if(locx>s.getPosicionX()){
			
			s.moveRight();
			

		}else{
			
			

			if( locy>s.posicionY  ){
				
				s.moveDown();

				//s.setPosicionX(s.getPosicionX() - s.getSteps());
			
				
			}
			
			else if( locy<s.posicionY){
				s.moveUp();

				//s.setPosicionX(s.getPosicionX() + s.getSteps());
				

			}else{
				
				
				s.stop();
				p.money=p.money-1;
				
				
				
			}
			

			
			
		}
		
		
		
		////

		if(s.getPosicionY()<locy){
			
			s.moveDown();
		
		
			
		}else if(s.getPosicionY()>locy){
			
			s.moveUp();
			

		}else{
			
			

			if( locx>s.posicionX  ){
				s.moveRight();


				//s.setPosicionX(s.getPosicionX() - s.getSteps());
			
				
			}
			
			else if( locx<s.posicionX){
				//s.setPosicionX(s.getPosicionX() + s.getSteps());
				s.moveLeft();


			}else{
				
				
				s.stop();
			}
			

			
			
		}
		
		
			}
		
		
		
		/*
		if(locx==s.getPosicionX()&&locy==s.posicionY){
			s.stop();
		}
		
			 
			//int a = g.getPosicionX()  - s.getPosicionX();
			//int b = g.getPosicionY() - s.getPosicionY();
			//double h = (int) Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); 
			 
			//int xMove = (int)(a / h * s.getSteps());
			//int yMove = (int)(b / h * s.getSteps());
			if(locx<=s.getPosicionX()){
				s.moveLeft();
				if(locy<=s.posicionY){
					s.moveUp();

				}else{
					s.moveDown();

				}

				
			}else{
				s.moveRight();
				if(locy<=s.posicionY){
					s.moveUp();

				}else{
					s.moveDown();
				}

			}*/
			 
			
	}

