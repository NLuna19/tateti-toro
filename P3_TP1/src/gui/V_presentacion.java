package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Font;

public class V_presentacion {

	private JFrame frmTateti;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_presentacion window = new V_presentacion();
					window.frmTateti.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public void setVisible(boolean valor) {
		frmTateti.setVisible(valor);
	}
	
	public V_presentacion() {
		initialize(600, 600);
	}

	public V_presentacion(int dimx, int dimy) {
		initialize(dimx, dimy);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int dimx, final int dimy) {
		frmTateti = new JFrame();
		frmTateti.setResizable(false);
		frmTateti.setTitle("TATETI");
		frmTateti.setBounds(0, 0, dimx, dimy);
		frmTateti.setLocationRelativeTo(null); // la ventana se ubica en centro de la pantalla
		frmTateti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn_inicio = new JButton("JUGAR");
		btn_inicio.setFont(new Font("Verdana", Font.PLAIN, 11));
		btn_inicio.setFocusable(false);
		btn_inicio.setBackground(SystemColor.activeCaption);
		btn_inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_data ventana = new V_data(dimx, dimy);
				ventana.setVisible(true);
				frmTateti.dispose(); //destruye ventana
			}
		});
		frmTateti.getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel lbl_imagen = new JLabel("");
		lbl_imagen.setIcon(new ImageIcon(V_presentacion.class.getResource("/imagen/tateti2_.JPG")));
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		frmTateti.getContentPane().add(lbl_imagen, BorderLayout.NORTH);
		frmTateti.getContentPane().add(btn_inicio, BorderLayout.CENTER);
	}
}
