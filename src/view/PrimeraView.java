package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.LoginDAO;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

public class PrimeraView {

	private JFrame frmLogin;
	private JLabel lblBienvenida;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JButton btnLogin;
	private LoginDAO login;
	private JLabel lblUsuario;
	private JLabel lblContrasena;


	/**
	 * Create the application.
	 */
	public PrimeraView() {
		login= new LoginDAO();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame();
		setComponents();
		setListeners();
		frmLogin.setVisible(true);
		
		
	}
	public void setComponents() {
		lblBienvenida = new JLabel("Bienvenido a la pokedex ");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(86, 11, 290, 65);
		frmLogin.getContentPane().add(lblBienvenida);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setBounds(71, 183, 89, 23);
		frmLogin.getContentPane().add(btnRegister);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(263, 183, 89, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(195, 75, 99, 23);
		frmLogin.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(195, 109, 99, 23);
		frmLogin.getContentPane().add(passwordField);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(81, 77, 79, 21);
		frmLogin.getContentPane().add(lblUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasena.setBounds(81, 111, 79, 21);
		frmLogin.getContentPane().add(lblContrasena);
		
	}
	public void setListeners() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (login.comprobarLogin(textFieldUsuario.getText(), String.valueOf(passwordField.getPassword()))) {
					new PokedexView();
					frmLogin.dispose();
				}else {
					System.out.println("no funsiona");
				}
				
			}
		});
		
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == KeyEvent.VK_ENTER) {
					if (login.comprobarLogin(textFieldUsuario.getText(), String.valueOf(passwordField.getPassword()))) {
						new PokedexView();
						frmLogin.dispose();
					}
					
				}
			}
			
		});
	}
	public void setFrame() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 455, 279);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		try {
			frmLogin.setIconImage(ImageIO.read(new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
}
}
