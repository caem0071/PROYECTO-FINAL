package general;

public class Login {
	
	public Login(){
		
	}
	//cambio para prueba de GIT
	//se vera reflejado en el master
	//cambio 
	//cambio realizado en mi maquina Cristhian
	//cambio en la shell 2015
	String user = "";
	String pass="";
	
	@SuppressWarnings("deprecation")
	public int validaPass() {
		
		user = Ventana1.tfUsuario.getText();
		pass = Ventana1.pswField.getText();
		//cambio de usuario y clave
		//este es otro cambio
		if(user.equals("hola") && pass.equals("espol")){
			return 1;
		}
		else{
			return 0;
		}
	}

}
