package gui;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.BorderLayout;

public class Acerca_De {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acerca_De window = new Acerca_De();
					window.frame.setVisible(true);
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
		frame.setVisible(valor);
	}
	
	public Acerca_De() {
		initialize(600, 600);
	}

	public Acerca_De(int dimx, int dimy) {
		initialize(dimx, dimy);
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final int dimx, final int dimy) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("TATETI ATREVIDO");
		frame.setBounds(20, 100, dimx, dimy);
		
				/*agrego imagen*/
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel lbl_imagen = new JLabel("");
		
		
		ImageIcon img=new ImageIcon(Acerca_De.class.getResource("/imagen/acerca_de.png"));//ruta o imagen q quiero guardar grande
  		//este codigo es para escalar la imagen
  		Image i=img.getImage();//guardo la imagen original en i(convierto ImageIcon en Image)
  		Image new_img=i.getScaledInstance(dimx, 578,Image.SCALE_SMOOTH);//escalo imagen (al JLabel-cuadro1)y la guardo en new_img
  		img=new ImageIcon(new_img);//guardo la imagen escalada a la img (del principio, el JLabel)
  		
		
		lbl_imagen.setIcon(img);
		lbl_imagen.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lbl_imagen, BorderLayout.CENTER);
	}
}
