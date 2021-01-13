package view;

import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;

public class LoginView {

	private JFrame frame;
	private JLabel lblNombreView;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
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
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 545, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNombreView = new JLabel("");
		lblNombreView.setBounds(149, 0, 195, 78);
		frame.getContentPane().add(lblNombreView);
		try {
			lblNombreView.setIcon(new ImageIcon(new URL("https://fontmeme.com/temporary/99539124d9d3d600c1118503b27d0917.png")));
			
			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsuario.setBounds(39, 107, 70, 14);
			frame.getContentPane().add(lblUsuario);
			
			textFieldUsuario = new JTextField();
			textFieldUsuario.setBounds(149, 104, 86, 20);
			frame.getContentPane().add(textFieldUsuario);
			textFieldUsuario.setColumns(10);
			
			JLabel lblPassword = new JLabel("Contrase\u00F1a");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setBounds(39, 159, 86, 17);
			frame.getContentPane().add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(149, 156, 86, 20);
			frame.getContentPane().add(passwordField);
			
			JButton btnRegistro = new JButton("Crear Usuario");
			btnRegistro.setBounds(39, 242, 115, 23);
			frame.getContentPane().add(btnRegistro);
			
			JButton btnLogin = new JButton("Iniciar Sesion");
			btnLogin.setBounds(255, 242, 115, 23);
			frame.getContentPane().add(btnLogin);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
