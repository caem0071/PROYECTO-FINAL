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

import utilidades.Busqueda;
import utilidades.Validacion;
import archivos.Archivo;
import entidades.Peliculas;
import entidades.Sala;
import formularios.imagenEdicionPeli;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class FrmEdicionPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfTitulo;
	private JComboBox cbClasificacion;
	private JComboBox cbGenero;
	private JTextField tfIdioma;
	private JTextField tfActor;
	private JTextField tfDirector;
	private JTextField tfSipnosis;
	private JTextField tfA�o;
	private JTextField tfDuracion;
	private FrmMantenimientoPeliculas fepeli;

	public FrmEdicionPelicula(String id,FrmMantenimientoPeliculas fepeli) throws Exception{
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Edicion Peliculas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 544);
		imagenEdicionPeli contentPane = new imagenEdicionPeli();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbId = new JLabel("ID:");
		lbId.setForeground(new Color(255, 255, 255));
		lbId.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbId.setBounds(45, 47, 46, 14);
		contentPane.add(lbId);
		
		JLabel lbTitulo = new JLabel("Titulo:");
		lbTitulo.setForeground(new Color(255, 255, 255));
		lbTitulo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbTitulo.setBounds(301, 47, 67, 14);
		contentPane.add(lbTitulo);
		
		JLabel lbClasificacion = new JLabel("Clasificaci\u00F3n:");
		lbClasificacion.setForeground(new Color(255, 255, 255));
		lbClasificacion.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbClasificacion.setBounds(45, 96, 99, 14);
		contentPane.add(lbClasificacion);
		
		JLabel lbGenero = new JLabel("G\u00E9nero:");
		lbGenero.setForeground(new Color(255, 255, 255));
		lbGenero.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbGenero.setBounds(45, 144, 76, 14);
		contentPane.add(lbGenero);
		
		JLabel lbIdioma = new JLabel("Idioma:");
		lbIdioma.setForeground(new Color(0, 0, 0));
		lbIdioma.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbIdioma.setBounds(45, 189, 76, 14);
		contentPane.add(lbIdioma);
		
		JLabel lbActor = new JLabel("Actor:");
		lbActor.setForeground(new Color(0, 0, 0));
		lbActor.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbActor.setBounds(45, 232, 86, 14);
		contentPane.add(lbActor);
		
		JLabel lbDirector = new JLabel("Director:");
		lbDirector.setForeground(new Color(0, 0, 0));
		lbDirector.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbDirector.setBounds(45, 275, 99, 14);
		contentPane.add(lbDirector);
		
		tfId = new JTextField();
		tfId.setBackground(new Color(255, 240, 245));
		tfId.setBounds(152, 44, 58, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfTitulo = new JTextField();
		tfTitulo.setBackground(new Color(255, 240, 245));
		tfTitulo.setBounds(378, 44, 194, 20);
		contentPane.add(tfTitulo);
		tfTitulo.setColumns(10);
		
		cbClasificacion = new JComboBox();
		cbClasificacion.setModel(new DefaultComboBoxModel(new String[] {"NINGUNA", "TODO PUBLICO", "ADULTOS"}));
		cbClasificacion.setBounds(154, 93, 127, 20);
		contentPane.add(cbClasificacion);
		
		cbGenero = new JComboBox();
		cbGenero.setModel(new DefaultComboBoxModel(new String[] {"NINGUNA", "DRAMA", "TERROR", "COMEDIA", "SUSPENSO", "ACCI\u00D3N"}));
		cbGenero.setBounds(154, 141, 127, 20);
		contentPane.add(cbGenero);
		
		tfIdioma = new JTextField();
		tfIdioma.setBackground(new Color(255, 240, 245));
		tfIdioma.setBounds(154, 186, 86, 20);
		contentPane.add(tfIdioma);
		tfIdioma.setColumns(10);
		
		tfDirector = new JTextField();
		tfDirector.setBackground(new Color(255, 240, 245));
		tfDirector.setBounds(154, 272, 127, 20);
		contentPane.add(tfDirector);
		tfDirector.setColumns(10);
		
		tfActor = new JTextField();
		tfActor.setBackground(new Color(255, 240, 245));
		tfActor.setBounds(154, 229, 127, 20);
		contentPane.add(tfActor);
		tfActor.setColumns(10);
		
		tfSipnosis = new JTextField();
		tfSipnosis.setBackground(new Color(255, 240, 245));
		tfSipnosis.setBounds(155, 315, 301, 58);
		contentPane.add(tfSipnosis);
		tfSipnosis.setColumns(10);
		
		JLabel lbSipnosis = new JLabel("Sipnosis:");
		lbSipnosis.setForeground(new Color(255, 255, 255));
		lbSipnosis.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lbSipnosis.setBounds(45, 324, 76, 14);
		contentPane.add(lbSipnosis);
		
		tfA�o = new JTextField();
		tfA�o.setBackground(new Color(255, 240, 245));
		tfA�o.setBounds(423, 94, 63, 20);
		contentPane.add(tfA�o);
		tfA�o.setColumns(10);
		
		JLabel lblA�o = new JLabel("A\u00F1o:");
		lblA�o.setForeground(new Color(255, 255, 255));
		lblA�o.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblA�o.setBounds(348, 96, 46, 14);
		contentPane.add(lblA�o);
		
		JLabel lblDuracin = new JLabel("Duraci\u00F3n:");
		lblDuracin.setForeground(new Color(255, 255, 255));
		lblDuracin.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblDuracin.setBounds(348, 145, 67, 14);
		contentPane.add(lblDuracin);
		
		tfDuracion = new JTextField();
		tfDuracion.setBackground(new Color(255, 240, 245));
		tfDuracion.setBounds(423, 142, 86, 20);
		contentPane.add(tfDuracion);
		tfDuracion.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(FrmEdicionPelicula.class.getResource("/imagenes/GUARDAR.png")));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPeliculas();
			}
		});
		btnGuardar.setBounds(165, 423, 127, 39);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmEdicionPelicula.class.getResource("/imagenes/Eliminar (1).png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setBounds(348, 424, 127, 37);
		contentPane.add(btnLimpiar);
		
		try{
			ArrayList<Peliculas> peliculas = Archivo.obtener_registros2();
			Peliculas p = peliculas.get(Busqueda.buscarPeliculaPorId(peliculas,id));
			tfId.setText(id);
			tfTitulo.setText(p.getTitulo());
			cbClasificacion.setSelectedIndex(0);
			cbGenero.setSelectedIndex(0);
			tfIdioma.setText(p.getIdioma());
			tfDirector.setText(p.getDirector());
			tfActor.setText(p.getActor());
			tfSipnosis.setText(p.getSinopsis());
			tfA�o.setText(Integer.toString(p.getA�o()));			
			tfDuracion.setText(Integer.toString(p.getDuracion()));
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Ocurri� un error al consultar en el archivo peliculas", "Edici�n",JOptionPane.ERROR_MESSAGE);
			throw e;
		}
		
	}
	
	private void limpiarFormulario() {
		tfId.setText("");
		tfTitulo.setText("");
		cbClasificacion.setSelectedIndex(0);
		cbGenero.setSelectedIndex(0);
		tfIdioma.setText("");
		tfDirector.setText("");
		tfActor.setText("");
		tfSipnosis.setText("");
		tfA�o.setText("");
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
			tfA�o.getText().equals("") ||
			tfDuracion.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Faltan campos por llenar","Validaci�n",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			ArrayList<Peliculas> peliculas = Archivo.obtener_registros2();
			if(Validacion.verificarDuplicidadId(peliculas, tfId.getText())){
				JOptionPane.showMessageDialog(this,"La Pelicula ya se encuentra registrada", "Validaci�n", JOptionPane.ERROR_MESSAGE);	
				return false;
			}
		}catch(Exception e){}
		
		try{
			Integer.parseInt(tfA�o.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"El a�o debe ser un n�mero entero","Validaci�n",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			Integer.parseInt(tfDuracion.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"La duracion debe ser en minutos con un entero","Validaci�n",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
	protected void editarPeliculas() {
		if(formularioValido()){
			 String id = tfId.getText();
			 String titulo = tfTitulo.getText();
			 String clasificacion = cbClasificacion.getSelectedItem().toString();
			 String genero = cbGenero.getSelectedItem().toString();
			 String idioma = tfIdioma.getText();
			 String actor = tfActor.getText();
			 String director = tfDirector.getText();
			 String sinopsis = tfSipnosis.getText();
			 int a�o = Integer.parseInt(tfA�o.getText());
			 int duracion = Integer.parseInt(tfDuracion.getText());
			 
			 Peliculas p = new Peliculas(id,titulo,clasificacion,genero,idioma,actor,director,sinopsis,a�o,duracion);
			
				if(Archivo.actualizar_registro2(p)){
					JOptionPane.showMessageDialog(this,"Se edit� correctamente la informaci�n de la pelicula","Edici�n de Informaci�n",JOptionPane.INFORMATION_MESSAGE);
					fepeli.consultarPeliculas();
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this,
					"Ocurri� un error en la edici�n de pelicula",
					"Edici�n de Informaci�n",
					JOptionPane.ERROR_MESSAGE);				
			}
		}					
	}
}