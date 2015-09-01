package general;

public class Login {
	
	public Login(){
		
	}
	// nuestro cambio 2015 cambio para prueba de GIT
	
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
