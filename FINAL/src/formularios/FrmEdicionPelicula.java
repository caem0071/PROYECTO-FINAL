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
	private JTextField tfAño;
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
		
		tfAño = new JTextField();
		tfAño.setBackground(new Color(255, 240, 245));
		tfAño.setBounds(423, 94, 63, 20);
		contentPane.add(tfAño);
		tfAño.setColumns(10);
		
		JLabel lblAño = new JLabel("A\u00F1o:");
		lblAño.setForeground(new Color(255, 255, 255));
		lblAño.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblAño.setBounds(348, 96, 46, 14);
		contentPane.add(lblAño);
		
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
			tfAño.setText(Integer.toString(p.getAño()));			
			tfDuracion.setText(Integer.toString(p.getDuracion()));
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Ocurrió un error al consultar en el archivo peliculas", "Edición",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(this,"La Pelicula ya se encuentra registrada", "Validación", JOptionPane.ERROR_MESSAGE);	
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
			JOptionPane.showMessageDialog(this,"La duracion debe ser en minutos con un entero","Validación",JOptionPane.ERROR_MESSAGE);
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
			 int año = Integer.parseInt(tfAño.getText());
			 int duracion = Integer.parseInt(tfDuracion.getText());
			 
			 Peliculas p = new Peliculas(id,titulo,clasificacion,genero,idioma,actor,director,sinopsis,año,duracion);
			
				if(Archivo.actualizar_registro2(p)){
					JOptionPane.showMessageDialog(this,"Se editó correctamente la información de la pelicula","Edición de Información",JOptionPane.INFORMATION_MESSAGE);
					fepeli.consultarPeliculas();
					this.dispose();
				}else{
					JOptionPane.showMessageDialog(this,
					"Ocurrió un error en la edición de pelicula",
					"Edición de Información",
					JOptionPane.ERROR_MESSAGE);				
			}
		}					
	}
}