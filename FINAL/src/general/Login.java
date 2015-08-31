package general;

public class Login {
	
	public Login(){
		
	}
	
	String user = "";
	String pass="";
	
	public int validaPass() {
		
		user = Ventana1.tfUsuario.getText();
		pass = Ventana1.pswField.getText();
		
		if(user.equals("admin") && pass.equals("espol123")){
			return 1;
		}
		else{
			return 0;
		}
	}

}
