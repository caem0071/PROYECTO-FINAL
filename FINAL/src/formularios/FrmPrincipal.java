package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;

import java.awt.Color;




import formularios.imagenPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;


import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class FrmPrincipal extends JFrame {
	
	private JMenuItem miSalas;
	private JPanel contentPane;
	private JMenuItem miPeliculas;
	private JMenu mAcercaDe;
	private JMenu mInicio;
	private JMenuItem miSalir;
	private JMenu mMantenimiento;
	private JLabel lbBienvenida;
	
	
	public FrmPrincipal() {
		setBackground(new Color(70, 130, 180));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mInicio = new JMenu("Inicio");
		mInicio.setForeground(Color.BLUE);
		menuBar.add(mInicio);
		
		miSalir = new JMenuItem("Salir");
		miSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		miSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salir();
			}
		});
		miSalir.setForeground(Color.BLACK);
		mInicio.add(miSalir);
		
		mMantenimiento = new JMenu("Mantenimiento");
		mMantenimiento.setForeground(Color.BLUE);
		menuBar.add(mMantenimiento);
		
		//miSalas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		miSalas = new JMenuItem("Salas");
		miSalas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		miSalas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mantenimientoSala();
			}
		});
		miSalas.setForeground(Color.BLACK);
		mMantenimiento.add(miSalas);
		
		
		miPeliculas = new JMenuItem("Peliculas");
		miPeliculas.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		miPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mantenimientoPelicula();
			}
		});
		miPeliculas.setForeground(Color.BLACK);
		mMantenimiento.add(miPeliculas);
		
		mAcercaDe = new JMenu("Acerca de...");
		mAcercaDe.setForeground(Color.BLUE);
		menuBar.add(mAcercaDe);
		
		JMenuItem miIntegrantes = new JMenuItem("Integrantes");
		miIntegrantes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		miIntegrantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miIntegrantes();
			}
		});
		mAcercaDe.add(miIntegrantes);
imagenPanel contentPane = new imagenPanel();
		
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbBienvenida = new JLabel(" Bienvenidos a Cine Espol");
		lbBienvenida.setForeground(new Color(255, 255, 153));
		lbBienvenida.setFont(new Font("Tempus Sans ITC", Font.BOLD, 17));
		lbBienvenida.setBounds(37, 26, 208, 44);
		contentPane.add(lbBienvenida);
	}

	protected void mantenimientoPelicula() {
		FrmMantenimientoPeliculas fmpeli = new FrmMantenimientoPeliculas();
		fmpeli.setVisible(true);
		dispose();
	}

	protected void mantenimientoSala() {
		FrmMantenimientoSala fmsala = new FrmMantenimientoSala();
		fmsala.setVisible(true);	
		dispose();
	}

	protected void salir() {
				
		int resp = JOptionPane.showConfirmDialog(null, "¿Realmente desea salir?", "Aviso", JOptionPane.YES_NO_OPTION);

		if (resp == 0) { 
		   System.out.print("Sí");
		   System.exit(0);
		} else {
		   System.out.print("No");
		}
	}	
	
	private void miIntegrantes(){
		FrmIntegrantes frame = new FrmIntegrantes();
		frame.setVisible(true);
		dispose();
	}
}