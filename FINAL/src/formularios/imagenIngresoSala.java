package formularios;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


	public class imagenIngresoSala extends javax.swing.JPanel {
		public imagenIngresoSala(){
			this.setSize(400,280);
			}
		//@Override
		public void paintComponent (Graphics g){
			Dimension tamanio = getSize();
			ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/cine.jpg"));
			g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
			setOpaque(false);
			super.paintComponent(g);
		}
}