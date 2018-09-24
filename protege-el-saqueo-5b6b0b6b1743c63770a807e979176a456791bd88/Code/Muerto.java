import java.awt.Color;

public class Muerto implements EstadoSaqueador {

	@Override
	public void atacar(GamePanel p, Saqueador s) {
		System.out.println("dead");
		// TODO Auto-generated method stub
		for (int a=0; a<p.oleada.size(); a++){
		if(p.oleada.get(a).getCurrent().equals(p.oleada.get(a).getMuerto())){
			p.oleada.remove(a);
			
		}
		}

	}

}
