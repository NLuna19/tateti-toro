package gui;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import logica.Tateti;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Component;

public class V_juego {

	private JFrame frame;
	private Tateti tateti ;
	
	/**
	 * Launch the application.
	 */	
	public void setVisible(boolean valor) {
			frame.setVisible(valor);
	}

	/**
	 * Create the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_juego window = new V_juego();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public V_juego() {
		tateti = new Tateti (3,"","");
		initialize(600, 600);
	}

	public V_juego(int dimx, int dimy, String j1, String j2, int dim) {
		tateti = new Tateti (dim,j1,j2);
		initialize(dimx, dimy);
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int tamanioVentana_x, final int tamanioVentana_y) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("TATETI ATREVIDO");
		frame.setBounds(0,0,tamanioVentana_x, tamanioVentana_y);
		frame.setLocationRelativeTo(null); //la ventana se ubica en el centro de la pantalla 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				

					/*CREACION DEL MENU */
		
		// creacion del menu Archivo
		JMenu m_archivo = new JMenu("Archivo");
		//items de menu
		JMenuItem m_archivo_nuevo = new JMenuItem("Nuevo");
		JMenuItem m_archivo_nuevaPartida = new JMenuItem("Reiniciar Partida");
		JMenuItem m_archivo_salir = new JMenuItem("Salir");
					
		
				/*ACCION DE NUEVO, NUEVA PARTIDA Y SALIR*/
		
		//nuevo
		m_archivo_nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_data inicio = new V_data( tamanioVentana_x, tamanioVentana_y);
				inicio.setVisible(true);
				frame.dispose(); //destruye ventana
			}
		});
		
		//Nueva Partida
		m_archivo_nuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				V_juego ventanaJuego = new V_juego(tamanioVentana_x, tamanioVentana_y,tateti.getNombreJugador1(), tateti.getNombreJugador2(), tateti.getDimensiones());
				ventanaJuego.setVisible(true);
				frame.dispose(); //destruye ventana
			}
		});
		// salir
		m_archivo_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//los agrego a su menu
		m_archivo.add(m_archivo_nuevo);
		m_archivo.add(m_archivo_nuevaPartida);
		m_archivo.add(m_archivo_salir);
		
		
		// creacion del menu Ayuda
		JMenu m_ayuda = new JMenu("Ayuda");
		//items de menu
		JMenuItem m_ayuda_creditos = new JMenuItem("Créditos");
		JMenuItem m_ayuda_acercade = new JMenuItem("Acerca del juego");
		
		// acerca de
		m_ayuda_acercade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acerca_De ventanaAcerca = new Acerca_De();
				ventanaAcerca.setVisible(true);
			}
		});
		//creditos
		m_ayuda_creditos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Creditos ventanaAcerca = new Creditos();
				ventanaAcerca.setVisible(true);
			}
		});
		
		//los agrego a su menu
		m_ayuda.add(m_ayuda_creditos);
		m_ayuda.add(m_ayuda_acercade);
		
		// creacion del barra de menu
		JMenuBar mb_barra = new JMenuBar();
		//agrego menus a la barra
		mb_barra.add(m_archivo);
		mb_barra.add(m_ayuda);
		
		//agrego la barra al frame
		frame.setJMenuBar(mb_barra);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));


		
		//panel que contiene todo
		JPanel panel = new JPanel();
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		panel.setForeground(Color.BLACK);
		panel.setBorder(UIManager.getBorder("TextPane.border"));
		panel.setBackground(new Color(248, 248, 255));
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_encabezado = new JPanel();
		panel_encabezado.setBackground(SystemColor.activeCaption);
		panel.add(panel_encabezado, BorderLayout.NORTH);
		panel_encabezado.setLayout(new GridLayout(0, 2, 0, 0));
		
		
// ******* NOMBRE JUGADORES
		JLabel lbl_nombrej2 = new JLabel("  |   "+tateti.getNombreJugador1()+" juega como "+ tateti.getMarcaJugador1());
		lbl_nombrej2.setFont(new Font("Verdana", Font.PLAIN, 12));
		lbl_nombrej2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_encabezado.add(lbl_nombrej2);
		
		JLabel lbl_nombrej1 = new JLabel(tateti.getNombreJugador2()+" juega como "+ tateti.getMarcaJugador2()+"   |  ");
		lbl_nombrej1.setFont(new Font("Verdana", Font.PLAIN, 12));
		lbl_nombrej1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_encabezado.add(lbl_nombrej1);
		
// ******* panel principal
		JPanel panel_principal = new JPanel();
		panel_principal.setBackground(UIManager.getColor("Button.background"));
		panel.add(panel_principal);
		panel_principal.setLayout(null);
		
		// muestra de quien es el turno actual
		final JLabel lbl_NombrePorTurno = new JLabel("");
		lbl_NombrePorTurno.setFont(new Font("Verdana", Font.BOLD, 12));
		lbl_NombrePorTurno.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_NombrePorTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_NombrePorTurno.setBounds(111, 12, 360, 15);
		panel_principal.add(lbl_NombrePorTurno);
		cambiarTurno(lbl_NombrePorTurno);
		
		//panel que contiene los botones
		Panel panel_tateti = new Panel();
		panel_tateti.setBounds(111, 75, 360, 360);
		panel_tateti.setBackground(Color.WHITE);
		panel_principal.add(panel_tateti);
		
		
//******* creo botones
		final JButton[][] bot = new JButton[tateti.getDimensiones()][tateti.getDimensiones()]; //
		for (int i = 0; i < bot.length; i++) {
			for (int j = 0; j < bot[0].length; j++) {
				bot[i][j]=new JButton("");
			}
		}
				
	//agrego al panel los botones
		for (int fila = 0; fila < bot.length; fila++) {
			for (int columna = 0; columna < bot.length; columna++) {
				bot[fila][columna].setFont(new Font("Verdana", Font.PLAIN, 20));
				bot[fila][columna].setBackground(SystemColor.WHITE);
				bot[fila][columna].setBounds(0, 0, 98, 98);
				bot[fila][columna].setFocusable(false);
				panel_tateti.add(bot[fila][columna]);
			}
		}
		
		//les doy acciones
		for ( int fila = 0; fila < bot.length; fila++) {	
			final int FINALfila=fila; // necesario sino no se puede usar en metodos
			for (int columna = 0; columna < bot[0].length; columna++) {
				final int FINALcolumna=columna; // necesario sino no se puede usar en metodos
					bot[fila][columna].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							escribirJugada(bot[FINALfila][FINALcolumna], FINALfila, FINALcolumna);
							buscaGanador();
							cambiarTurno(lbl_NombrePorTurno);
						}
					});
			}
		}
		panel_tateti.setLayout(new GridLayout(0, tateti.getDimensiones(), 0, 0));
		
		JLabel lbl_fondo = new JLabel("");
		lbl_fondo.setIcon(new ImageIcon(V_juego.class.getResource("/imagen/tateti_fondogris.png")));
		lbl_fondo.setForeground(Color.LIGHT_GRAY);
		lbl_fondo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_fondo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbl_fondo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_fondo.setBounds(0, 0, 594, 534);
		panel_principal.add(lbl_fondo);
	}
	private void cambiarTurno(JLabel label) { //cambia turno y muestra de quien es el turno actual
		tateti.cambiarTurno();
		label.setText("Turno de "+ tateti.getJugadorActual());
	}
	private void escribirJugada(JButton button, int fila, int columna) {
		tateti.jugar(tateti.getTurno(), fila, columna);
		button.setText(tateti.getMarcaActual());
		button.setEnabled(false);
	}
	
	private void buscaGanador() {
			if (tateti.ganador(tateti.getTurno())){
				String ganador = tateti.getJugadorActual();
				V_fin ventanaFin = new V_fin("ganador", tateti.getJugadas(), ganador, tateti.getJugador1(), tateti.getJugador2(), tateti.getDimensiones());
				ventanaFin.setVisible(true);
				frame.dispose();
			}
			else {
				if (tateti.empate()) {
					V_fin ventanaFin = new V_fin("empate", tateti.getJugadas(), "", tateti.getJugador1(),tateti.getJugador2(), tateti.getDimensiones());
					ventanaFin.setVisible(true);
					frame.dispose();
				}
			}
	}
}
