package general;

public class Login {
	
	public Login(){
		
	}
	
	String user = "";
	String pass="";
	
	@SuppressWarnings("deprecation")
	public int validaPass() {
		
		user = Ventana1.tfUsuario.getText();
		pass = Ventana1.pswField.getText();
		//cambio de usuario y clave
		if(user.equals("hola") && pass.equals("espol")){
			return 1;
		}
		else{
			return 0;
		}
	}

}