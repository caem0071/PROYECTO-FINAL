package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import formularios.imagenIngresoSala;
import utilidades.Validacion;
import archivos.Archivo;
import entidades.Sala;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmIngresoSala extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfCapacidad;
	private JComboBox cbTipo;

	public FrmIngresoSala() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Ingresar Sala");
		setBounds(100, 100, 470, 289);
		imagenIngresoSala contentPane = new imagenIngresoSala();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblCodigo.setBounds(45, 48, 73, 14);
		contentPane.add(lblCodigo);
		
		tfCodigo = new JTextField();
		tfCodigo.setBackground(new Color(255, 255, 204));
		tfCodigo.setBounds(149, 45, 59, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblNombre.setBounds(45, 88, 74, 14);
		contentPane.add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBackground(new Color(255, 255, 204));
		tfNombre.setBounds(151, 84, 124, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(255, 255, 255));
		lblTipo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblTipo.setBounds(45, 126, 63, 15);
		contentPane.add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "3D", "IMAX"}));
		cbTipo.setToolTipText("");
		cbTipo.setBounds(153, 123, 98, 20);
		contentPane.add(cbTipo);
		
		JLabel lblCapacidad = new JLabel("Capacidad:");
		lblCapacidad.setForeground(new Color(255, 255, 255));
		lblCapacidad.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblCapacidad.setBounds(45, 165, 110, 14);
		contentPane.add(lblCapacidad);
		
		tfCapacidad = new JTextField();
		tfCapacidad.setBackground(new Color(255, 255, 204));
		tfCapacidad.setBounds(154, 161, 59, 20);
		contentPane.add(tfCapacidad);
		tfCapacidad.setColumns(10);
		
		JButton btnIngresar = new JButton("Guardar");
		btnIngresar.setFont(new Font("SimHei", Font.PLAIN, 12));
		btnIngresar.setVerticalAlignment(SwingConstants.TOP);
		btnIngresar.setHorizontalAlignment(SwingConstants.LEFT);
		btnIngresar.setIcon(new ImageIcon(FrmIngresoSala.class.getResource("/imagenes/kdee.png")));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresarSala();
			}
		});
		btnIngresar.setBounds(307, 52, 131, 42);
		contentPane.add(btnIngresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setFont(new Font("SimHei", Font.PLAIN, 12));
		btnLimpiar.setVerticalAlignment(SwingConstants.TOP);
		btnLimpiar.setIcon(new ImageIcon(FrmIngresoSala.class.getResource("/imagenes/eliminar.gif")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setBounds(307, 140, 131, 39);
		contentPane.add(btnLimpiar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 454, 21);
		contentPane.add(menuBar);
		
		JMenu mnMen = new JMenu("Regresar");
		menuBar.add(mnMen);
		
		JMenuItem mntmRegresar = new JMenuItem("Regresar a Mantenimiento");
		mntmRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regresarMantiSala();
			}
		});
		mnMen.add(mntmRegresar);
	}

	private void limpiarFormulario() {
		tfCodigo.setText("");
		tfNombre.setText("");
		cbTipo.setSelectedIndex(0);
		tfCapacidad.setText("");
		
	}

	public boolean formularioValido(){
		if(	tfCodigo.getText().equals("") ||
			tfNombre.getText().equals("") ||
			cbTipo.equals("NORMAL") ||
			tfCapacidad.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Faltan campos por llenar","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			ArrayList<Sala> salas = Archivo.obtener_registros();
			if(Validacion.verificarDuplicidadCodigo(salas, tfCodigo.getText())){
				JOptionPane.showMessageDialog(this,"El id de la sala ya se encuentra registrado", "Validación", JOptionPane.ERROR_MESSAGE);	
				return false;
			}
		}catch(Exception e){}
		
		try{
			Integer.parseInt(tfCapacidad.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"La capacidad debe ser un número entero","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}
	
	private void regresarMantiSala(){
		FrmMantenimientoSala fmsala = new FrmMantenimientoSala();
		fmsala.setVisible(isEnabled());
		dispose();
	}
	
	protected void ingresarSala() {
		if(formularioValido()){
			String codigo = tfCodigo.getText();
			String nombre = tfNombre.getText();
			String tipo = cbTipo.getSelectedItem().toString();
			int capacidad = Integer.parseInt(tfCapacidad.getText());
			Sala s = new Sala(codigo,nombre,tipo,capacidad);
			if(Archivo.insertar_registro(s)){
				JOptionPane.showMessageDialog(this,
				"Se ingresó correctamente la información de la Sala",
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
}
