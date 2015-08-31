
package formularios;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


	public class imagenPanel extends javax.swing.JPanel {
		public imagenPanel(){
			this.setSize(400,280);
			}
		//@Override
		public void paintComponent (Graphics g){
			Dimension tamanio = getSize();
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/tumblr_mcn621Mof41qbajzvo1_1280.jpg"));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}