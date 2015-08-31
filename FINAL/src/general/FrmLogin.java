package general;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


	public class FrmLogin extends javax.swing.JPanel {
		public FrmLogin(){
			this.setSize(400,280);
			}
		//@Override
		public void paintComponent (Graphics g){
			Dimension tamanio = getSize();
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/principal.jpg"));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}