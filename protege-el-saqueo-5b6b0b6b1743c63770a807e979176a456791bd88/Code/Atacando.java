
public class Atacando implements EstadoSaqueador {

	@Override
	public void atacar(GamePanel p, Saqueador s) {
		System.out.println("std2");
		
		
if(!p.getAmmo().isEmpty()){
		for (int i=0; i<p.getAmmo().size(); i++){
			Balas b=p.getAmmo().get(p.getAmmo().size()-(i+1));
			if(s.getPosicionX()< b.getX() && b.getX()<s.getPosicionX()+s.ancho &&
					s.getPosicionY()<b.getY() && b.getY()<s.getPosicionY()+s.alto					){
				p.getAmmo().remove(p.getAmmo().size()-(i+1));
				s.recibedaño();

				if(s.life==0){
					s.setCurrent(s.getMuerto());
					p.muertos++;
				}
			}
			
		}
}
		
		
		
		Guardia g= p.getGuardia();
		
		
		
		
if(g.posicionX==s.getPosicionX()&&g.posicionY==s.getPosicionY()){
			
			g.recibedaño();
			if(g.getLife()==0){
				
				System.out.println("muerto");
				
			}	
		}
	













		
		if(g.posicionX<s.getPosicionX()){
			
			s.moveLeft();
		
		
			
		}else if(g.posicionX>s.getPosicionX()){
			
			s.moveRight();
			

		}else{
			
			

			if( g.posicionY>s.posicionY  ){
				
				s.moveDown();

				//s.setPosicionX(s.getPosicionX() - s.getSteps());
			
				
			}
			
			else if( g.posicionY<s.posicionY){
				s.moveUp();

				//s.setPosicionX(s.getPosicionX() + s.getSteps());
				

			}else{
				
				
				s.stop();
			}
			

			
			
		}
		
		
		
		////

		if(s.getPosicionY()<g.posicionY){
			
			s.moveDown();
		
		
			
		}else if(s.getPosicionY()>g.posicionY){
			
			s.moveUp();
			

		}else{
			
			

			if( g.posicionX>s.posicionX  ){
				s.moveRight();


				//s.setPosicionX(s.getPosicionX() - s.getSteps());
			
				
			}
			
			else if( g.posicionX<s.posicionX){
				//s.setPosicionX(s.getPosicionX() + s.getSteps());
				s.moveLeft();


			}else{
				
				
				s.stop();
			}
			

			
			
		}
		
		
		
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		////
		
		
			
			
			
			
			
			
			
			

			
			
		
		// TODO Auto-generated method stub

	
	}


