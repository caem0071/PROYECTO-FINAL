
package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import formularios.imagenInicio;
import utilidades.Validacion;
import archivos.Archivo;
import entidades.Peliculas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmIngresoPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfTitulo;
	private JComboBox cbClasificacion;
	private JComboBox cbGenero;
	private JTextField tfIdioma;
	private JTextField tfActor;
	private JTextField tfDirector;
	private JTextField tfSipnosis;
	private JTextField tfAño;
	private JTextField tfDuracion;
	

	public FrmIngresoPelicula() {
		setResizable(false);
		setTitle("Ingreso Peliculas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 489);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegresar = new JMenu("Regresar");
		menuBar.add(mnRegresar);
		
		JMenuItem mntmMantenimientoPeliculas = new JMenuItem("Mantenimiento Peliculas");
		mntmMantenimientoPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresaPelis();
			}
		});
		mnRegresar.add(mntmMantenimientoPeliculas);
		imagenInicio contentPane = new imagenInicio();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("ID:");
		lbId.setForeground(new Color(245, 245, 245));
		lbId.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbId.setBounds(89, 23, 46, 14);
		contentPane.add(lbId);
		
		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setForeground(new Color(245, 245, 245));
		lbTitulo.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbTitulo.setBounds(254, 22, 46, 14);
		contentPane.add(lbTitulo);
		
		JLabel lbClasificacion = new JLabel("Clasificaci\u00F3n:");
		lbClasificacion.setForeground(new Color(245, 245, 245));
		lbClasificacion.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbClasificacion.setBounds(45, 88, 99, 14);
		contentPane.add(lbClasificacion);
		
		JLabel lbGenero = new JLabel("G\u00E9nero:");
		lbGenero.setForeground(new Color(245, 245, 245));
		lbGenero.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbGenero.setBounds(49, 135, 46, 14);
		contentPane.add(lbGenero);
		
		JLabel lbIdioma = new JLabel("Idioma:");
		lbIdioma.setForeground(new Color(245, 245, 245));
		lbIdioma.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbIdioma.setBounds(321, 176, 58, 14);
		contentPane.add(lbIdioma);
		
		JLabel lbActor = new JLabel("Actor:");
		lbActor.setForeground(new Color(0, 0, 0));
		lbActor.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbActor.setBounds(65, 186, 46, 14);
		contentPane.add(lbActor);
		
		JLabel lbDirector = new JLabel("Director:");
		lbDirector.setForeground(new Color(0, 0, 0));
		lbDirector.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbDirector.setBounds(64, 238, 73, 14);
		contentPane.add(lbDirector);
		
		tfId = new JTextField();
		tfId.setBackground(new Color(245, 245, 220));
		tfId.setBounds(154, 20, 58, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfTitulo = new JTextField();
		tfTitulo.setBackground(new Color(245, 245, 220));
		tfTitulo.setBounds(325, 20, 202, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		cbClasificacion = new JComboBox();
		cbClasificacion.setModel(new DefaultComboBoxModel(new String[] {"NINGUNA", "TODO PUBLICO", "ADULTOS"}));
		cbClasificacion.setBounds(154, 86, 127, 20);
		contentPane.add(cbClasificacion);
		
		cbGenero = new JComboBox();
		cbGenero.setModel(new DefaultComboBoxModel(new String[] {"NINGUNA", "DRAMA", "TERROR", "COMEDIA", "SUSPENSO", "ACCI\u00D3N"}));
		cbGenero.setBounds(154, 129, 101, 20);
		contentPane.add(cbGenero);
		
		tfIdioma = new JTextField();
		tfIdioma.setBackground(new Color(245, 245, 220));
		tfIdioma.setBounds(400, 176, 86, 20);
		contentPane.add(tfIdioma);
		tfIdioma.setColumns(10);
		
		tfDirector = new JTextField();
		tfDirector.setBackground(new Color(245, 245, 220));
		tfDirector.setBounds(155, 234, 127, 20);
		contentPane.add(tfDirector);
		tfDirector.setColumns(10);
		
		tfActor = new JTextField();
		tfActor.setBackground(new Color(245, 245, 220));
		tfActor.setBounds(153, 184, 127, 20);
		contentPane.add(tfActor);
		tfActor.setColumns(10);
		
		tfSipnosis = new JTextField();
		tfSipnosis.setBackground(new Color(245, 245, 220));
		tfSipnosis.setBounds(156, 292, 300, 55);
		contentPane.add(tfSipnosis);
		tfSipnosis.setColumns(10);
		
		JLabel lbSipnosis = new JLabel("Sipnosis:");
		lbSipnosis.setForeground(new Color(0, 0, 0));
		lbSipnosis.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lbSipnosis.setBounds(61, 294, 73, 14);
		contentPane.add(lbSipnosis);
		
		tfAño = new JTextField();
		tfAño.setBackground(new Color(245, 245, 220));
		tfAño.setBounds(396, 86, 63, 20);
		contentPane.add(tfAño);
		tfAño.setColumns(10);
		
		JLabel lblAño = new JLabel("A\u00F1o:");
		lblAño.setForeground(new Color(245, 245, 245));
		lblAño.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lblAño.setBounds(334, 89, 46, 14);
		contentPane.add(lblAño);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setForeground(new Color(245, 245, 245));
		lblDuracin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lblDuracin.setBounds(320, 128, 60, 14);
		contentPane.add(lblDuracin);
		
		tfDuracion = new JTextField();
		tfDuracion.setBackground(new Color(245, 245, 220));
		tfDuracion.setBounds(398, 123, 78, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JButton btnIngresar = new JButton("Guardar");
		btnIngresar.setIcon(new ImageIcon(FrmIngresoPelicula.class.getResource("/imagenes/kdee.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarPeliculas();
			}
		});
		btnIngresar.setBounds(101, 389, 119, 46);
		contentPane.add(btnIngresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmIngresoPelicula.class.getResource("/imagenes/eliminar.gif")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setBounds(295, 389, 123, 42);
		contentPane.add(btnLimpiar);				
		
		JLabel lblEnMinutos = new JLabel("En Minutos");
		lblEnMinutos.setForeground(new Color(245, 245, 245));
		lblEnMinutos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 13));
		lblEnMinutos.setBounds(405, 145, 71, 14);
		contentPane.add(lblEnMinutos);
	}
	
	private void limpiarFormulario() {
		tfId.setText("");
		tfTitulo.setText("");
		cbGenero.setSelectedIndex(0);
		cbClasificacion.setSelectedIndex(0);
		tfIdioma.setText("");
		tfDirector.setText("");
		tfActor.setText("");
		tfSipnosis.setText("");
		tfAño.setText("");
		tfDuracion.setText("");
	}

	public boolean formularioValido(){
		if(	tfId.getText().equals("") ||
			tfTitulo.getText().equals("") ||
			cbClasificacion.equals("") ||
			cbGenero.equals("DRAMA") ||
			tfIdioma.getText().equals("") ||
			tfDirector.getText().equals("") ||
			tfActor.getText().equals("") ||
			tfSipnosis.getText().equals("") ||
			tfAño.getText().equals("") ||
			tfDuracion.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Faltan campos por llenar","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			ArrayList<Peliculas> peliculas = Archivo.obtener_registros2();
			if(Validacion.verificarDuplicidadId(peliculas, tfId.getText())){
				JOptionPane.showMessageDialog(this,"El id de la película ya está registrado", "Validación", JOptionPane.ERROR_MESSAGE);	
				return false;
			}
		}catch(Exception e){}
		
		try{
			Integer.parseInt(tfAño.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"El año debe ser un número entero","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			Integer.parseInt(tfDuracion.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"La duración debe ser en minutos con un entero","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
	protected void ingresarPeliculas() {
		if(formularioValido()){
			 String id = tfId.getText();
			 String titulo = tfTitulo.getText();
			 String clasificacion = cbClasificacion.getSelectedItem().toString();
			 String genero = cbGenero.getSelectedItem().toString();
			 String idioma = tfIdioma.getText();
			 String actor = tfActor.getText();
			 String director = tfDirector.getText();
			 String sinopsis = tfSipnosis.getText();
			 int año = Integer.parseInt(tfAño.getText());
			 int duracion = Integer.parseInt(tfDuracion.getText());
			 
			 Peliculas p = new Peliculas(id,titulo,clasificacion,genero,idioma,actor,director,sinopsis,año,duracion);
			
			
			if(Archivo.insertar_registro2(p)){
				JOptionPane.showMessageDialog(this,
				"Se ingresó correctamente la información de la Pelicula",
				"Ingreso de Información",
				JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
			}else{
				JOptionPane.showMessageDialog(this,
				"Ocurrió un error en el ingreso",
				"Ingreso de Información",
				JOptionPane.ERROR_MESSAGE);
			}
		}			
		
	}
	
	private void regresaPelis(){
		FrmMantenimientoPeliculas frm = new FrmMantenimientoPeliculas();
		frm.setVisible(true);
		dispose();
	}
}
