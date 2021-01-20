package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class AnadirView {

	private JFrame frame;
	private JLabel lblTitulo;
	
	
	/**
	 * Create the application.
	 */
	public AnadirView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame();
		setLiseners();
		setComponents();
	}
	
	private void setLiseners() {
		
	}
	
	private void setComponents() {
		
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 424, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("A\u00F1adir Pokemon");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(132, 11, 125, 36);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 73, 46, 14);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(180, 73, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(180, 117, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		JLabel lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setBounds(180, 156, 46, 14);
		frame.getContentPane().add(lblHabilidad);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(lblAltura);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 156, 46, 14);
		frame.getContentPane().add(lblCategoria);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(10, 264, 46, 14);
		frame.getContentPane().add(lblNewLabel_6);
	}
}
