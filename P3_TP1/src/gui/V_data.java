package gui;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.SystemColor;

public class V_data {
	private JFrame frmTateti;
	private JPanel contentPane;
	private JTextField textField_nombre2;
	private JTextField textField_nombre1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_data window = new V_data();
					window.frmTateti.setVisible(true);
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void setVisible(boolean valor) {
		frmTateti.setVisible(valor);
	}

	/**
	 * Create the application.
	 */
	public V_data() {
		initialize(600, 600);
		
	}

	public V_data(int dimx, int dimy) {
		initialize(dimx, dimy);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int dimx, final int dimy) {
		frmTateti = new JFrame();
		frmTateti.setResizable(false);
		frmTateti.setTitle("TATETI");
		frmTateti.getContentPane().setBackground(new Color(211, 211, 211));
		frmTateti.setBounds(0, 0, dimx, dimy);
		frmTateti.setLocationRelativeTo(null);  //la ventana se ubica en el centro de la pantalla 
		frmTateti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTateti.getContentPane().setLayout(new CardLayout(0, 0));
		
		
		
		JPanel panel = new JPanel();
//		panel.setBorder(UIManager.getBorder("TextPane.border"));
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(248, 248, 255));
		frmTateti.getContentPane().add(panel, "name_783052779648400");
		panel.setLayout(new BorderLayout(0, 0));
		
	//ENCABEZADO
		JPanel panel_encabezado = new JPanel();
		panel_encabezado.setAlignmentY(0.0f);
		panel_encabezado.setAlignmentX(0.0f);
		panel_encabezado.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_encabezado, BorderLayout.NORTH);
		panel_encabezado.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_titulo = new JLabel("");
		lbl_titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_titulo.setIcon(new ImageIcon(V_data.class.getResource("/imagen/cabecera_tateti.png")));
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_encabezado.add(lbl_titulo);
		
		
	//ingreso de datos
		JPanel panel_principal = new JPanel();
		panel_principal.setBackground(SystemColor.control);
		panel.add(panel_principal);
		panel_principal.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_ingresoDatos = new JPanel();
		panel_ingresoDatos.setOpaque(false);
		panel_principal.add(panel_ingresoDatos);
		panel_ingresoDatos.setLayout(null);
		
		final JLabel cuadro1 = new JLabel("");
		cuadro1.setHorizontalAlignment(SwingConstants.CENTER);
		cuadro1.setBorder(new LineBorder(new Color(0, 0, 0)));
		cuadro1.setBounds(12, 12, 100, 100);
		panel_ingresoDatos.add(cuadro1);
		
		JButton btnAgregarFoto = new JButton("Agregar Foto");
		btnAgregarFoto.setBackground(SystemColor.activeCaption);
		btnAgregarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subirFoto(arg0,cuadro1);
			}
		});
		btnAgregarFoto.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAgregarFoto.setBounds(12, 123, 100, 26);
		panel_ingresoDatos.add(btnAgregarFoto);
		
		JLabel lbl_msjnombre1 = new JLabel("INGRESE NOMBRE JUGADOR 1: ");
		lbl_msjnombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_msjnombre1.setBounds(150, 20, 212, 16);
		panel_ingresoDatos.add(lbl_msjnombre1);
		
		textField_nombre1 = new JTextField();
		textField_nombre1.setColumns(10);
		textField_nombre1.setBounds(373, 20, 130, 20);
		panel_ingresoDatos.add(textField_nombre1);
		
		JPanel panel_ingresoDatos2 = new JPanel();
		panel_ingresoDatos2.setOpaque(false);
		panel_principal.add(panel_ingresoDatos2);
		panel_ingresoDatos2.setLayout(null);
		
		final JLabel cuadro2 = new JLabel("");
		cuadro2.setHorizontalAlignment(SwingConstants.CENTER);
		cuadro2.setBounds(12, 12, 100, 100);
		cuadro2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_ingresoDatos2.add(cuadro2);
		
		JButton btnAgregarFoto2 = new JButton("Agregar Foto");
		btnAgregarFoto2.setBackground(SystemColor.activeCaption);
		btnAgregarFoto2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subirFoto(arg0,cuadro2);
			}
		});
		btnAgregarFoto2.setFont(new Font("Dialog", Font.BOLD, 10));
		btnAgregarFoto2.setBounds(12, 123, 100, 26);
		panel_ingresoDatos2.add(btnAgregarFoto2);
		
		JLabel lbl_msjnombre2 = new JLabel("INGRESE NOMBRE JUGADOR 2: ");
		lbl_msjnombre2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_msjnombre2.setBounds(150, 20, 212, 16);
		panel_ingresoDatos2.add(lbl_msjnombre2);
		
		textField_nombre2 = new JTextField();
		textField_nombre2.setBounds(373, 20, 130, 20);
		textField_nombre2.setColumns(10);
		panel_ingresoDatos2.add(textField_nombre2);
		
		
	//boton de inicio
		
		JPanel panel_alpie = new JPanel();
		panel.add(panel_alpie, BorderLayout.SOUTH);
		panel_alpie.setLayout(new GridLayout(0, 4, 0, 0));
		JButton btn_salir = new JButton("Salir");
		btn_salir.setBackground(SystemColor.control);
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTateti.dispose(); //destruye ventana
			}
		});
		panel_alpie.add(btn_salir);
		
		JLabel lbl_tamanio = new JLabel(" |   Tama\u00F1o del  tablero");
		lbl_tamanio.setBackground(SystemColor.control);
		lbl_tamanio.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_alpie.add(lbl_tamanio);
		
		
		final JComboBox<Integer> comboBox = new JComboBox<Integer>();
		comboBox.setBackground(SystemColor.control);
		comboBox.addItem(3);
		comboBox.addItem(4);
		comboBox.addItem(5);
		panel_alpie.add(comboBox);
		
		JButton btn_ingresar = new JButton("INICIAR!");
		btn_ingresar.setBackground(SystemColor.activeCaption);
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V_juego ventanaJuego = new V_juego(dimx, dimy, textField_nombre1.getText()+"",textField_nombre2.getText()+"", (int)comboBox.getSelectedItem()); 
				ventanaJuego.setVisible(true);
				frmTateti.dispose(); //destruye ventana
			}
		});
		panel_alpie.add(btn_ingresar);
		
	}
	

	
	/*cargar ruta de imagen*/
	public ImageIcon mostrarImagenes(JLabel lbl,String ruta){
		ImageIcon img=new ImageIcon(ruta);//ruta o imagen q quiero guardar grande
  		//este codigo es para escalar la imagen
  		Image i=img.getImage();//guardo la imagen original en i(convierto ImageIcon en Image)
  		Image new_img=i.getScaledInstance(100, 100,Image.SCALE_SMOOTH);//escalo imagen (al JLabel-cuadro1)y la guardo en new_img
  		img=new ImageIcon(new_img);//guardo la imagen escalada a la img (del principio, el JLabel)
  		return img;
	}
	public void subirFoto(ActionEvent arg0,JLabel cuadro) {
		//Creamos el objeto JFileChooser
		JFileChooser fc=new JFileChooser();
		
		//Creamos el filtro
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.JPG", "jpg");
		 
		//Le indicamos el filtro
		fc.setFileFilter(filtro);
		 
		//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
		int seleccion=fc.showOpenDialog(contentPane);
		 
		//Si el usuario, pincha en aceptar
		if(seleccion==JFileChooser.APPROVE_OPTION){
		 
		    //Seleccionamos el fichero
		    File fichero=new File(fc.getSelectedFile().toString());
		 
		    try(FileReader fr=new FileReader(fichero)){
		  		//poner esto si no funciona-nombre del label en este caso(profile)
		  		cuadro.setIcon(mostrarImagenes(cuadro, fc.getSelectedFile().toString()));
		  		
		    } catch (IOException e1) {
		        e1.printStackTrace();
		    }
		}
	}
}
