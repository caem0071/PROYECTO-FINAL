package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import formularios.imagenManteniSala;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;

import utilidades.Validacion;
import archivos.Archivo;
import entidades.Sala;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class FrmMantenimientoSala extends JFrame {

	private JPanel contentPane;
	private JTextField tfConsulta;
	private JTable tResultado;
	private JComboBox cbTipo;

	
	public FrmMantenimientoSala() {
		setResizable(false);
		setTitle("Mantenimiento Salas");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 402);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMen = new JMenu("Men\u00FA");
		menuBar.add(mnMen);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backMenu();
			}
		});
		mnMen.add(mntmPrincipal);
		imagenManteniSala contentPane = new imagenManteniSala();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 50, 540, 159);
		contentPane.add(scrollPane);
		
		tResultado = new JTable();
		tResultado.setBackground(new Color(204, 153, 153));
		tResultado.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Tipo", "Capacidad"
			}
		));
		scrollPane.setViewportView(tResultado);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnIngresar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/imagenes/edit.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarSala();
			}
		});
		btnIngresar.setBounds(61, 301, 131, 42);
		contentPane.add(btnIngresar);
		
		tfConsulta = new JTextField();
		tfConsulta.setBackground(new Color(255, 255, 255));
		tfConsulta.setBounds(191, 228, 204, 23);
		contentPane.add(tfConsulta);
		tfConsulta.setColumns(10);
		
		cbTipo = new JComboBox();
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarEstadoConsulta();
			}
		});
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"TODOS", "CODIGO", "NOMBRE", "TIPO", "CAPACIDAD"}));
		cbTipo.setBounds(48, 225, 135, 29);
		contentPane.add(cbTipo);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnConsultar.setHorizontalAlignment(SwingConstants.LEFT);
		btnConsultar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/imagenes/edicion.png")));
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarSalas();
			}
		});
		btnConsultar.setBounds(405, 220, 150, 40);
		contentPane.add(btnConsultar);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnEditar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/imagenes/edit.gif")));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarSala();
			}
		});
		btnEditar.setBounds(239, 280, 130, 42);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Narkisim", Font.PLAIN, 11));
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoSala.class.getResource("/imagenes/attributes_delete_icon.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarSala();
			}
		});
		btnEliminar.setBounds(402, 296, 131, 42);
		contentPane.add(btnEliminar);
	}
	
	private boolean formularioConsultaValido(){
		String datos = tfConsulta.getText();
		String tipo = cbTipo.getSelectedItem().toString();
		if(!tipo.equals("TODOS") && datos.equals("")){
			JOptionPane.showMessageDialog(this,"Debe ingresar un valor en la caja de texto","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(tipo.equals("CAPACIDAD")){
			try{
				Integer.parseInt(datos);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"La capacidad debe ser un número","Validación",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}
	
	public void consultarSalas() {
		if(formularioConsultaValido()){
			String datos = tfConsulta.getText();
			String tipo = cbTipo.getSelectedItem().toString();
			
			try{
				ArrayList<Sala> registros = Archivo.obtener_registros();
				DefaultTableModel m =(DefaultTableModel)tResultado.getModel();
				m.setRowCount(0);
				if(tipo.equals("TODOS")){					
					for(int i=0;i<registros.size();i++){
						Sala tmp = registros.get(i);
						Vector fila = new Vector();
						fila.add(tmp.getCodigo());
						fila.add(tmp.getNombre());
						fila.add(tmp.getTipo());
						fila.add(tmp.getCapacidad());										
						m.addRow(fila);
					}	
				}else if(tipo.equals("CODIGO")){
					for(int i=0;i<registros.size();i++){
						Sala tmp = registros.get(i);
						if(tmp.getCodigo().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getCodigo());
							fila.add(tmp.getNombre());
							fila.add(tmp.getTipo());
							fila.add(tmp.getCapacidad());										
							m.addRow(fila);						
						}												
					}					
				}else if(tipo.equals("NOMBRE")){
					for(int i=0;i<registros.size();i++){
						Sala tmp = registros.get(i);
						if(tmp.getNombre().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getCodigo());
							fila.add(tmp.getNombre());
							fila.add(tmp.getTipo());
							fila.add(tmp.getCapacidad());										
							m.addRow(fila);						
						}												
					}		
						
				}else if(tipo.equals("TIPO")){
					for(int i=0;i<registros.size();i++){
						Sala tmp = registros.get(i);
						if(tmp.getTipo().toUpperCase().contains(datos.toUpperCase())){
							Vector fila = new Vector();
							fila.add(tmp.getCodigo());
							fila.add(tmp.getNombre());
							fila.add(tmp.getTipo());
							fila.add(tmp.getCapacidad());										
							m.addRow(fila);						
						}												
					}					
				}else if(tipo.equals("CAPACIDAD")){
					for(int i=0;i<registros.size();i++){
						Sala tmp = registros.get(i);
						if(Integer.toString(tmp.getCapacidad()).contains(datos)){	
						//if(tmp.getCapacidad()==Integer.parseInt(datos)){	Por el tipo de dato en la variable.	
							Vector fila = new Vector();
							fila.add(tmp.getCodigo());
							fila.add(tmp.getNombre());
							fila.add(tmp.getTipo());
							fila.add(tmp.getCapacidad());										
							m.addRow(fila);						
						}												
					}					
				}								
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"Ocurrió un error al consultar el archivo","Error",JOptionPane.ERROR_MESSAGE);
			}						
		}
		
	}

	private boolean seleccionEdicionValida(){
		int nfilas = tResultado.getSelectedRowCount();
		if(nfilas!=1){
			JOptionPane.showMessageDialog(this,"Debe seleccionar una fila para editar","Edición",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	protected void editarSala() {
		if(seleccionEdicionValida()){
			int fila = tResultado.getSelectedRow();
			String codigo = tResultado.getValueAt(fila,0).toString();
			try{
				FrmEdicionSala fesala = new FrmEdicionSala(codigo,this);
				fesala.setVisible(true);
			}catch(Exception e){}				
		}				
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

	protected void ingresarSala() {
		FrmIngresoSala fisala = new FrmIngresoSala();
		fisala.setVisible(true);	
		dispose();
	}
	
	private boolean seleccionEliminarValida(){
        int nfilas = this.tResultado.getSelectedRowCount();
        if(nfilas<1){
            JOptionPane.showMessageDialog(null,"DEBE SELECCIONAR POR LO MENOS UN REGISTRO", "EDICIÓN", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
	
	protected void eliminarSala() {
		if(seleccionEliminarValida()){
           			
			try{
				int []filas = tResultado.getSelectedRows();
				ArrayList<Sala> salas = Archivo.obtener_registros();
					for(int i=0; i<filas.length; i++){
		                int fila = filas[i];
		                String codigo = String.valueOf(tResultado.getValueAt(fila, 0));
		                Sala s = new Sala(codigo);
		                int indice = Validacion.existeSala(salas,s);
		                salas.remove(indice);
		            }
		            if(Archivo.actualizar_registros(salas)){
		            	consultarSalas();
		                JOptionPane.showMessageDialog(this, "Se realizó la eliminación con Éxito","ELIMINACIÓN", JOptionPane.INFORMATION_MESSAGE);                
		                
		            }else{
		               JOptionPane.showMessageDialog(this, "Ocurrió un error en la eliminación","ERROR", JOptionPane.ERROR_MESSAGE);            
		            }
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,"Ocurrió un error en la eliminación", "Eliminación", JOptionPane.ERROR_MESSAGE);
			}			
			         
        }        
	}


	private void backMenu(){
		FrmPrincipal frm = new FrmPrincipal();
		frm.setVisible(true);
		dispose();
	}
}
