package view;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.LoginDAO;
import models.Usuario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroView {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private	JLabel lblConfirmarContra;
	private JButton btnVolver;
	private JButton btnResgistrarse;
	private LoginDAO user;
	private JFrame padre;
	
	/**
	 * Create the application.
	 */
	public RegistroView(JFrame loginView) {
		initialize();
		this.user= new LoginDAO();
		this.padre = loginView;
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame();
		setComponents();
		setListeners();
	}
	
	public void setComponents() {
		lblTitulo = new JLabel("Resgistrarse");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(60, 11, 107, 31);
		frame.getContentPane().add(lblTitulo);
		
		lblUsuario = new JLabel("Ususario");
		lblUsuario.setBounds(25, 56, 74, 14);
		frame.getContentPane().add(lblUsuario);
		
		lblContrasena = new JLabel("Contrasena");
		lblContrasena.setBounds(25, 101, 74, 14);
		frame.getContentPane().add(lblContrasena);
		
		lblConfirmarContra = new JLabel("Confirmar contrasena");
		lblConfirmarContra.setBounds(25, 139, 142, 14);
		frame.getContentPane().add(lblConfirmarContra);
		
		textField = new JTextField();
		textField.setBounds(155, 53, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 98, 86, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(155, 136, 86, 20);
		frame.getContentPane().add(passwordField_1);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 188, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		btnResgistrarse = new JButton("Resgistrarse");
		btnResgistrarse.setBounds(155, 188, 117, 23);
		frame.getContentPane().add(btnResgistrarse);
		
		
	}
	
	public void setListeners() {
		
		btnResgistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registroCompr();
			}
		});
	}
	
	public void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 312, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
	}
	
	/**
	 * Funcion para comprobar y ejecutar el registro
	 */
	public void registroCompr() {
		String pass1 = new String(passwordField.getPassword());
		String pass2 = new String(passwordField_1.getPassword());
		String username = textField.getText();

		// Si las contraseñas coinciden
		if (pass1.equals(pass2)) {
			// Comprobar que el username no está ya registrado
			if (!user.comprobarUsuario(username)) {
				// Registrar usuario
				Usuario u = new Usuario(username, pass1);
				user.registrarUsuario(u);
				JOptionPane.showMessageDialog(frame, "Usuario registrado!!! :)", "ÉXITO",
						JOptionPane.INFORMATION_MESSAGE);
				padre.setVisible(true);
				frame.dispose();
				
			} else {// El usuario está registrado.
				JOptionPane.showMessageDialog(frame, "El usuario ya existe.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Las contraseñas no coinciden.", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
