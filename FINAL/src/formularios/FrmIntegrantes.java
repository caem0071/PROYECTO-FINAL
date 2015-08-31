package formularios;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import formularios.imagenInte;

import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmIntegrantes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIntegrantes frame = new FrmIntegrantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmIntegrantes() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setTitle("Autores");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmIntegrantes.class.getResource("/com/sun/java/swing/plaf/motif/icons/TreeOpen.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegresar = new JMenu("Regresar");
		menuBar.add(mnRegresar);
		
		JMenuItem mntmPrincipal = new JMenuItem("Principal");
		mntmPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				regresaPrinci();
			}
		});
		mnRegresar.add(mntmPrincipal);
		imagenInte contentPane = new imagenInte();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChristhianEspinosa = new JLabel("Christhian Espinosa");
		lblChristhianEspinosa.setForeground(Color.BLACK);
		lblChristhianEspinosa.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
		lblChristhianEspinosa.setBounds(147, 49, 129, 17);
		contentPane.add(lblChristhianEspinosa);
		
		JLabel lblJonathanMarmolejo = new JLabel("Jonathan Marmolejo");
		lblJonathanMarmolejo.setForeground(Color.BLACK);
		lblJonathanMarmolejo.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
		lblJonathanMarmolejo.setBounds(147, 104, 140, 14);
		contentPane.add(lblJonathanMarmolejo);
		
		JLabel lblStephanieVillacs = new JLabel("Stephanie Villac\u00EDs");
		lblStephanieVillacs.setForeground(Color.BLACK);
		lblStephanieVillacs.setFont(new Font("Monotype Corsiva", Font.BOLD, 14));
		lblStephanieVillacs.setBounds(147, 156, 116, 17);
		contentPane.add(lblStephanieVillacs);
	}
	
	private void regresaPrinci(){
		FrmPrincipal frm = new FrmPrincipal();
		frm.setVisible(true);
		dispose();
	}

}
