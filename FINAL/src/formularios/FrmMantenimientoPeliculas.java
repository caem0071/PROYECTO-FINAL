package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import formularios.imagenMantenimientoPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import utilidades.Validacion;
import archivos.Archivo;
import entidades.Peliculas;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmMantenimientoPeliculas extends JFrame {

	private JPanel contentPane;
	private JTable tbResultado;
	private JTextField tfConsulta;
	private JComboBox cbTipo;
	private JButton btnEditar;

	public FrmMantenimientoPeliculas() {
		setResizable(false);
		setTitle("Mantenimiento Peliculas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 662, 315);
		imagenMantenimientoPanel contentPane = new imagenMantenimientoPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setAlwaysOnTop(false);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 625, 128);
		contentPane.add(scrollPane);
		
		tbResultado = new JTable();
		tbResultado.setForeground(new Color(255, 255, 255));
		tbResultado.setBackground(new Color(204, 51, 51));
		tbResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Título", "Clasificación", "Género", "Idioma", "Actor", "Director", "Sipnosis", "Año", "Duración"
			}
		));
		scrollPane.setViewportView(tbResultado);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnConsultar.setIcon(new ImageIcon(FrmMantenimientoPeliculas.class.getResource("/imagenes/edicion.png")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarPeliculas();
			}
		});
		btnConsultar.setBounds(462, 167, 144, 42);
		contentPane.add(btnConsultar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoPeliculas.class.getResource("/imagenes/attributes_delete_icon.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPeliculas();
			}
		});
		btnEliminar.setBounds(417, 226, 122, 40);
		contentPane.add(btnEliminar);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnIngresar.setIcon(new ImageIcon(FrmMantenimientoPeliculas.class.getResource("/imagenes/edit.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPelicula();
			}
		});
		btnIngresar.setBounds(120, 227, 119, 38);
		contentPane.add(btnIngresar);
		
		tfConsulta = new JTextField();
		tfConsulta.setForeground(new Color(255, 255, 255));
		tfConsulta.setBackground(new Color(204, 51, 51));
		tfConsulta.setBounds(220, 177, 232, 20);
		contentPane.add(tfConsulta);
		tfConsulta.setColumns(10);
		
		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizarEstadoConsulta();
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"TODOS", "ID", "TITULO", "ACTOR", "DURACION", "DIRECTOR", "A\u00D1O"}));
		cbTipo.setBounds(42, 174, 168, 26);
		contentPane.add(cbTipo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnEditar.setIcon(new ImageIcon(FrmMantenimientoPeliculas.class.getResource("/imagenes/edit.gif")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarPeliculas();
			}
		});
		btnEditar.setBounds(275, 237, 118, 39);
		contentPane.add(btnEditar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 656, 21);
		contentPane.add(menuBar);
		
		JMenu mnRegresar = new JMenu("Men\u00FA");
		menuBar.add(mnRegresar);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresarPrinci();
			}
		});
		mnRegresar.add(mntmPrincipal);
	}
	
	private void actualizarEstadoConsulta(){
		String tipo = String.valueOf(cbTipo.getSelectedItem());
		if(tipo.equals("TODOS")){
			tfConsulta.setEditable(false);
		}else{
			tfConsulta.setEditable(true);
		}
		tfConsulta.setText(null);
	}

	private boolean seleccionEdicionValida(){
		int nfilas = tbResultado.getSelectedRowCount();
		if(nfilas!=1){
			JOptionPane.showMessageDialog(this,"Debe seleccionar una fila para editar","Edición",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	protected void editarPeliculas() {
		if(seleccionEdicionValida()){
			int fila = tbResultado.getSelectedRow();
			String id = tbResultado.getValueAt(fila,0).toString();
			try{
				FrmEdicionPelicula fepeli = new FrmEdicionPelicula(id,this);
				fepeli.setVisible(true);
			}catch(Exception e){}				
		}				
		
	}

	private boolean seleccionEliminarValida(){
        int nfilas = this.tbResultado.getSelectedRowCount();
        if(nfilas<1){
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR POR LO MENOS UN REGISTRO", "ELIMINACION", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
	
	public void eliminarPeliculas() {
		if(seleccionEliminarValida()){   			
			try{
				int []filas = tbResultado.getSelectedRows();
				ArrayList<Peliculas> peliculas = Archivo.obtener_registros2();
					for(int i=0; i<filas.length; i++){
		                int fila = filas[i];
		                String id = String.valueOf(tbResultado.getValueAt(fila, 0));
		                Peliculas p = new Peliculas(id);
		                int indice = Validacion.existePelicula(peliculas, p);
		                peliculas.remove(indice);
		            }
		            if(Archivo.actualizar_registros2(peliculas)){
		            	consultarPeliculas();
		                JOptionPane.showMessageDialog(this, "Se realizó la eliminación con Éxito","ELIMINACIÓN", JOptionPane.INFORMATION_MESSAGE);                
		                
		            }else{
		               JOptionPane.showMessageDialog(this, "Ocurrió un error en la eliminación","ERROR", JOptionPane.ERROR_MESSAGE);            
		            }
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"Ocurrió un error en la eliminación", "Eliminación", JOptionPane.ERROR_MESSAGE);
			}				         
        }	
	}

	private boolean formularioConsultaValido(){
		String datos = tfConsulta.getText();
		String tipo = cbTipo.getSelectedItem().toString();
		if(!tipo.equals("TODOS") && datos.equals("")){
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor en la caja de texto","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(tipo.equals("DURACION")){
			try{
				Integer.parseInt(datos);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"La duracion debe ser un número","Validación",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	protected void consultarPeliculas() {
		if(formularioConsultaValido()){
			String datos = tfConsulta.getText();
			String tipo = cbTipo.getSelectedItem().toString();
			
			try{
				ArrayList<Peliculas> registros = Archivo.obtener_registros2();
				DefaultTableModel m =(DefaultTableModel)tbResultado.getModel();
				m.setRowCount(0);
				if(tipo.equals("TODOS")){					
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						Vector fila = new Vector();
						fila.add(tmp.getId());
						fila.add(tmp.getTitulo());
						fila.add(tmp.getClasificacion());
						fila.add(tmp.getGenero());
						fila.add(tmp.getIdioma());
						fila.add(tmp.getActor());
						fila.add(tmp.getDirector());
						fila.add(tmp.getSinopsis());
						fila.add(tmp.getAño());
						fila.add(tmp.getDuracion());
						m.addRow(fila);							
					}					
				}else if(tipo.equals("ID")){
					for(int i=0;i<registros.size();i++){
					Peliculas tmp=registros.get(i);
					Vector fila= new Vector();
					if(tmp.getId().toUpperCase().contains(datos.toUpperCase())){
					fila.add(tmp.getId());
					fila.add(tmp.getTitulo());
					fila.add(tmp.getClasificacion());
					fila.add(tmp.getGenero());
					fila.add(tmp.getIdioma());
					fila.add(tmp.getActor());
					fila.add(tmp.getDirector());
					fila.add(tmp.getSinopsis());
					fila.add(tmp.getAño());
					fila.add(tmp.getDuracion());
					m.addRow(fila);	
					}
				
					}
				}else if(tipo.equals("TITULO")){
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						if(tmp.getTitulo().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getId());
							fila.add(tmp.getTitulo());
							fila.add(tmp.getClasificacion());
							fila.add(tmp.getGenero());
							fila.add(tmp.getIdioma());
							fila.add(tmp.getActor());
							fila.add(tmp.getDirector());
							fila.add(tmp.getSinopsis());
							fila.add(tmp.getAño());
							fila.add(tmp.getDuracion());								
							m.addRow(fila);						
						}												
					}					
				}else if(tipo.equals("ACTOR")){
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						if(tmp.getActor().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getId());
							fila.add(tmp.getTitulo());
							fila.add(tmp.getClasificacion());
							fila.add(tmp.getGenero());
							fila.add(tmp.getIdioma());
							fila.add(tmp.getActor());
							fila.add(tmp.getDirector());
							fila.add(tmp.getSinopsis());
							fila.add(tmp.getAño());
							fila.add(tmp.getDuracion());								
							m.addRow(fila);						
						}												
					}		
				}else if(tipo.equals("DURACION")){
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						if(Integer.toString(tmp.getDuracion()).contains(datos)){	
							Vector fila = new Vector();
							fila.add(tmp.getId());
							fila.add(tmp.getTitulo());
							fila.add(tmp.getClasificacion());
							fila.add(tmp.getGenero());
							fila.add(tmp.getIdioma());
							fila.add(tmp.getActor());
							fila.add(tmp.getDirector());
							fila.add(tmp.getSinopsis());
							fila.add(tmp.getAño());
							fila.add(tmp.getDuracion());								
							m.addRow(fila);						
						}												
					}	
				}else if(tipo.equals("DIRECTOR")){
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						if(tmp.getDirector().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getId());
							fila.add(tmp.getTitulo());
							fila.add(tmp.getClasificacion());
							fila.add(tmp.getGenero());
							fila.add(tmp.getIdioma());
							fila.add(tmp.getActor());
							fila.add(tmp.getDirector());
							fila.add(tmp.getSinopsis());
							fila.add(tmp.getAño());
							fila.add(tmp.getDuracion());									
							m.addRow(fila);						
						}												
					}				
				}else if(tipo.equals("AÑO")){
					for(int i=0;i<registros.size();i++){
						Peliculas tmp = registros.get(i);
						if(Integer.toString(tmp.getAño()).contains(datos)){	
							Vector fila = new Vector();
							fila.add(tmp.getId());
							fila.add(tmp.getTitulo());
							fila.add(tmp.getClasificacion());
							fila.add(tmp.getGenero());
							fila.add(tmp.getIdioma());
							fila.add(tmp.getActor());
							fila.add(tmp.getDirector());
							fila.add(tmp.getSinopsis());
							fila.add(tmp.getAño());
							fila.add(tmp.getDuracion());									
							m.addRow(fila);						
						}												
					}					
				}								
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"Ocurrió un error al consultar el archivo peliculas","Error",JOptionPane.ERROR_MESSAGE);
			}						
		}		
	}
	
		

	protected void ingresarPelicula() {
		FrmIngresoPelicula frame = new FrmIngresoPelicula();
		frame.setVisible(true);
		dispose();
	}
	
	
	private void regresarPrinci(){
		FrmPrincipal fr = new FrmPrincipal();
		fr.setVisible(true);
		dispose();
	}

	
}
