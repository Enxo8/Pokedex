package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import DAO.LoginDAO;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeraView {

	private JFrame frame;
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
		setLiseners();
		frame.setVisible(true);
		
		
	}
	public void setComponents() {
		lblBienvenida = new JLabel("Bienvenido a la pokedex ");
		lblBienvenida.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenida.setBounds(86, 11, 290, 65);
		frame.getContentPane().add(lblBienvenida);
		
		btnRegister = new JButton("Registrarse");
		btnRegister.setBounds(71, 183, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(263, 183, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(195, 75, 99, 23);
		frame.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 109, 99, 23);
		frame.getContentPane().add(passwordField);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsuario.setBounds(81, 77, 79, 21);
		frame.getContentPane().add(lblUsuario);
		
		lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContrasena.setBounds(81, 111, 79, 21);
		frame.getContentPane().add(lblContrasena);
		
	}
	public void setLiseners() {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (login.comprobarLogin(textFieldUsuario.getText(), String.valueOf(passwordField.getPassword()))) {
					new PokedexView();
					frame.setVisible(false);
				}else {
					System.out.println("no funsiona");
				}
				
			}
		});
		
	}
	public void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 455, 279);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
}
