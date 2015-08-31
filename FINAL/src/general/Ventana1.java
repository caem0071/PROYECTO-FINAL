package general;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import general.FrmLogin;
import formularios.FrmPrincipal;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	public static JPasswordField pswField;
	public static JTextField tfUsuario;

	/**
	 * Create the frame.
	 */
	public Ventana1() {
		setResizable(false);
		setTitle("BIENVENIDOS A  CINE ESPOL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 452, 291);
		FrmLogin contentPane = new FrmLogin();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(new Color(255, 250, 205));
		lblUsuario.setFont(new Font("Mangal", Font.ITALIC, 12));
		lblUsuario.setBounds(81, 70, 64, 27);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setForeground(new Color(255, 250, 205));
		lblContrasea.setFont(new Font("Mangal", Font.ITALIC, 12));
		lblContrasea.setBounds(77, 113, 77, 22);
		contentPane.add(lblContrasea);
		
		pswField = new JPasswordField();
		pswField.setBackground(new Color(255, 239, 213));
		pswField.setBounds(172, 114, 120, 22);
		contentPane.add(pswField);
		
		tfUsuario = new JTextField();
		tfUsuario.setBackground(new Color(255, 239, 213));
		tfUsuario.setForeground(Color.LIGHT_GRAY);
		tfUsuario.setBounds(170, 72, 125, 22);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		final Login datos = new Login();
		final FrmPrincipal frm = new FrmPrincipal();
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		btnEntrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEntrar.setVerticalAlignment(SwingConstants.TOP);
		btnEntrar.setIcon(new ImageIcon(Ventana1.class.getResource("/javax/swing/plaf/metal/icons/ocean/minimize.gif")));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(datos.validaPass()==1){
					
					frm.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Invalida");
				}
				
			}
		});
		btnEntrar.setBounds(107, 188, 108, 27);
		contentPane.add(btnEntrar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setFont(new Font("Segoe Print", Font.PLAIN, 11));
		btnSalir.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalir.setVerticalAlignment(SwingConstants.TOP);
		btnSalir.setIcon(new ImageIcon(Ventana1.class.getResource("/javax/swing/plaf/metal/icons/ocean/maximize.gif")));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(249, 188, 106, 27);
		contentPane.add(btnSalir);
	}
}
