package gui;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import logica.Jugador;

import java.awt.Font;
import java.awt.Component;
import java.awt.SystemColor;

public class V_fin {

	private JFrame frmTateti;
	private Integer jugadas;
	private Jugador ganador;
	private Jugador perdedor;
	private String mensaje;
	private int tatetiDim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_fin window = new V_fin();
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
	public V_fin() {
		this.ganador= new Jugador("", "O");
		this.perdedor=new Jugador("", "X");
		this.mensaje="EMPATE!!";
		this.jugadas =0;
		this.tatetiDim =0;
		initialize();
	}

	public V_fin(String condicion, Integer jugadas,String ganador, Jugador jugador1, Jugador jugador2, int tatetiDimensiones) {
		if (condicion!="empate") {
			if (jugador1.getNombre().equals(ganador)) {
				this.ganador= new Jugador(jugador1.getNombre(), jugador1.getMarca());
				this.perdedor=new Jugador(jugador2.getNombre(), jugador2.getMarca());
			}
			if (jugador2.getNombre().equals(ganador)) {
				this.ganador= new Jugador(jugador2.getNombre(), jugador2.getMarca());
				this.perdedor= new Jugador(jugador1.getNombre(), jugador1.getMarca());
			}
			this.mensaje="GANO "+this.ganador.getNombre().toUpperCase()+" !!!";
		}else {
			this.ganador= new Jugador(jugador1.getNombre(), jugador1.getMarca());
			this.perdedor=new Jugador(jugador2.getNombre(), jugador2.getMarca());
			this.mensaje="EMPATE!!";
		}
		this.jugadas = jugadas;
		this.tatetiDim=tatetiDimensiones;
		initialize();
	}
	public void setVisible(boolean valor) {
		frmTateti.setVisible(valor);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTateti = new JFrame();
		frmTateti.setBackground(Color.LIGHT_GRAY);
		frmTateti.setTitle("Tateti");
		frmTateti.getContentPane().setBackground(new Color(211, 211, 211));

		frmTateti.setResizable(false);
		frmTateti.setBounds(0, 0, 300, 300);
		frmTateti.setLocationRelativeTo(null);  //la ventana se ubica en el centro de la pantalla 
		frmTateti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frmTateti.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_msj = new JPanel();
		panel_msj.setBackground(new Color(245, 245, 245));
		frmTateti.getContentPane().add(panel_msj);
		panel_msj.setLayout(new GridLayout(0, 1, 2, 2));
		
		JLabel lblGanoElJugador = new JLabel(mensaje);
		lblGanoElJugador.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblGanoElJugador.setHorizontalAlignment(SwingConstants.CENTER);
		lblGanoElJugador.setHorizontalTextPosition(SwingConstants.CENTER);
		panel_msj.add(lblGanoElJugador);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);

		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_msj.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel label_info = new JLabel("Informacion de la partida: ");
		label_info.setFont(new Font("Verdana", Font.PLAIN, 10));
		label_info.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_info);
		JLabel lbl_info_jugador1 = new JLabel(ganador.getNombre()+" jugo con: "+ganador.getMarca());
		lbl_info_jugador1.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbl_info_jugador1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_info_jugador1);
		JLabel lbl_info_jugador2 = new JLabel(perdedor.getNombre()+" jugo con: "+perdedor.getMarca());
		lbl_info_jugador2.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbl_info_jugador2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_info_jugador2);
		JLabel lbl_info_jugadasTotales = new JLabel(jugadas+" jugadas totales en un tablero de ("+tatetiDim+"X"+tatetiDim+")" );
		lbl_info_jugadasTotales.setFont(new Font("Verdana", Font.PLAIN, 10));
		lbl_info_jugadasTotales.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbl_info_jugadasTotales);
		
		JPanel panel_botones = new JPanel();
		frmTateti.getContentPane().add(panel_botones);
		panel_botones.setLayout(new GridLayout(3, 1, 0, 0));
		
		JButton btnJugarDeNuevo = new JButton("Nuevos Jugadores");
		btnJugarDeNuevo.setBackground(SystemColor.inactiveCaption);
		btnJugarDeNuevo.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_botones.add(btnJugarDeNuevo);
		btnJugarDeNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_data ventanaInicio = new V_data();
				ventanaInicio.setVisible(true);
				frmTateti.dispose();
			}
		});
		
		JButton btnNuevosJugadores = new JButton("Jugar De Nuevo");
		btnNuevosJugadores.setBackground(SystemColor.inactiveCaption);
		btnNuevosJugadores.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_botones.add(btnNuevosJugadores);
		btnNuevosJugadores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				V_juego ventanaInicio = new V_juego(600,600,ganador.getNombre(),perdedor.getNombre(),tatetiDim);
				ventanaInicio.setVisible(true);
				frmTateti.dispose();
			}
		});
		
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBackground(SystemColor.inactiveCaption);
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTateti.dispose();
			}
		});
		btn_salir.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel_botones.add(btn_salir);
		



	}
}
