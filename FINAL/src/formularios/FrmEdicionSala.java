package formularios;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import utilidades.Busqueda;
import archivos.Archivo;
import entidades.Sala;
import formularios.imagenEdicionSalas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmEdicionSala extends JFrame {

	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfCapacidad;
	private FrmMantenimientoSala fesala;
	private JComboBox cbTip;
	
	public FrmEdicionSala(String codigo,FrmMantenimientoSala fesala) throws Exception{
		setResizable(false);
		setLocationRelativeTo(null);
		this.fesala = fesala;
		
		setTitle("Editar Sala");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 499, 318);
		imagenEdicionSalas contentPane = new imagenEdicionSalas();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbCodigo = new JLabel("C\u00F3digo:");
		lbCodigo.setForeground(new Color(255, 165, 0));
		lbCodigo.setFont(new Font("MS PGothic", Font.BOLD, 13));
		lbCodigo.setBounds(30, 46, 53, 14);
		contentPane.add(lbCodigo);
		
		JLabel lbNombre = new JLabel("Nombre:");
		lbNombre.setForeground(new Color(255, 165, 0));
		lbNombre.setFont(new Font("MS PGothic", Font.BOLD, 13));
		lbNombre.setBounds(30, 91, 66, 14);
		contentPane.add(lbNombre);
		
		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setForeground(new Color(255, 165, 0));
		lbTipo.setFont(new Font("MS PGothic", Font.BOLD, 13));
		lbTipo.setBounds(30, 131, 53, 14);
		contentPane.add(lbTipo);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad:");
		lblNewLabel_3.setForeground(new Color(255, 165, 0));
		lblNewLabel_3.setFont(new Font("MS PGothic", Font.BOLD, 13));
		lblNewLabel_3.setBounds(30, 173, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		tfCodigo = new JTextField();
		tfCodigo.setBackground(new Color(230, 230, 250));
		tfCodigo.setEditable(false);
		tfCodigo.setBounds(146, 43, 126, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setBackground(new Color(230, 230, 250));
		tfNombre.setBounds(146, 88, 126, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfCapacidad = new JTextField();
		tfCapacidad.setBackground(new Color(230, 230, 250));
		tfCapacidad.setBounds(146, 170, 126, 20);
		contentPane.add(tfCapacidad);
		tfCapacidad.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarSala();
			}
		});
		btnGuardar.setIcon(new ImageIcon(FrmEdicionSala.class.getResource("/imagenes/save_24.png")));
		btnGuardar.setBounds(338, 77, 113, 45);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon(FrmEdicionSala.class.getResource("/imagenes/Eliminar (1).png")));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setBounds(338, 159, 113, 45);
		contentPane.add(btnLimpiar);
		
		try{
			ArrayList<Sala> salas = Archivo.obtener_registros();
			Sala s = salas.get(Busqueda.buscarSalaPorCodigo(salas,codigo));
			tfCodigo.setText(codigo);
			tfNombre.setText(s.getNombre());
			tfCapacidad.setText(Integer.toString(s.getCapacidad()));
			
			cbTip = new JComboBox();
			cbTip.setModel(new DefaultComboBoxModel(new String[] {"NORMAL", "3D", "IMAX"}));
			cbTip.setToolTipText("");
			cbTip.setBounds(146, 129, 98, 20);
			contentPane.add(cbTip);
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Ocurrió un error al consultar en el archivo", "Edición",JOptionPane.ERROR_MESSAGE);
			throw e;
		}
	}
	

	protected void limpiarFormulario() {
		tfNombre.setText("");
		cbTip.setSelectedIndex(0);
		tfCapacidad.setText("");		
	}


	public boolean formularioValido(){
		if(	tfCodigo.getText().equals("") ||
			tfNombre.getText().equals("") ||
			cbTip.getSelectedItem().equals("NORMAL") ||
			tfCapacidad.getText().equals("")){
			JOptionPane.showMessageDialog(this,"Faltan campos por llenar","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		try{
			Integer.parseInt(tfCapacidad.getText());
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"La capacidad debe ser un número entero","Validación",JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;
	}

	protected void editarSala() {
		if(formularioValido()){
			String codigo = tfCodigo.getText();
			String nombre = tfNombre.getText();
			String tipo = cbTip.getSelectedItem().toString();
			int capacidad = Integer.parseInt(tfCapacidad.getText());
			Sala s = new Sala(codigo,nombre,tipo,capacidad);
			if(Archivo.actualizar_registro(s)){
				JOptionPane.showMessageDialog(this,"Se editó correctamente la información de la sala","Edición de Información",JOptionPane.INFORMATION_MESSAGE);
				fesala.consultarSalas();
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this,
				"Ocurrió un error en la edición",
				"Edición de Información",
				JOptionPane.ERROR_MESSAGE);
			}
		}		
	}		
}
