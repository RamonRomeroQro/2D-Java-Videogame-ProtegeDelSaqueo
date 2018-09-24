import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class SaqFactory {


	public Saqueador crearSaqueador(BufferedImage ss, int k) {



		if(k==0){

			Saqueador s= new Saqueador ( ss,  0, 720,  301,  463,  119);
			return s;


		}else if (k==1){
			Saqueador s= new Saqueador ( ss,  1, -20,  301,  130,  121);
				return s;
		}else if (k==2){
			Saqueador s= new Saqueador ( ss,  2, 315,  720,  85,  603);
			return s;
	}else if (k==3){
		Saqueador s= new Saqueador ( ss,  3, 720,  301,  558,  569);
		return s;
}else if (k==4){
	Saqueador s= new Saqueador ( ss,  4,-20,  301,  463,  119);
	return s;
}else if (k==5){
	Saqueador s= new Saqueador ( ss,  5, 315,  720,  130,  121);
	return s;
}else if (k==6){
	Saqueador s= new Saqueador ( ss,  6, 720,  301,  85,  603);
	return s;
}else if (k==7){
	Saqueador s= new Saqueador ( ss,  7, -20,  301,  558,  569);
	return s;
}else if (k==8){
	Saqueador s= new Saqueador ( ss,  8, 315,  720,  463,  119);
	return s;
}else if (k==9){
	Saqueador s= new Saqueador ( ss,  9,  720,  301,  130,  121);
	return s;
}else if (k==10){
	Saqueador s= new Saqueador ( ss,  10, -20,  301,  85,  603);
	return s;
}else if (k==11){
	Saqueador s= new Saqueador ( ss,  11,  315,  720,  558,  569);
	return s;
}else if (k==12){
	Saqueador s= new Saqueador ( ss,  12,  720,  301,  463,  119);
	return s;
}else if (k==13){
	Saqueador s= new Saqueador ( ss,  13, -20,  301,  130,  121);
	return s;
}else if (k==14){
	Saqueador s= new Saqueador ( ss,  14, 315,  720, 85,  603);
	return s;
}else {
	Saqueador s= new Saqueador ( ss,  15,  720,  301,  558,  569);
	return s;
}


	}

}
