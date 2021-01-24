package view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DAO.PokedexDAO;
import models.Pokemon;

public class EditView {

	private JFrame frame;
	private JLabel lblNumeroPK;
	private JTextField textFieldNumero;
	private JTextField textFieldNombre;
	private JTextField textFieldCategoria;
	private JTextField textFieldHabilidad;
	private JTextField textFieldAltura;
	private JTextField textFieldPeso;
	private JLabel lblTitulo;
	private JLabel lblNombrePK;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblDescripcion;
	private JButton btnAnadir;
	private JButton btnVolver;
	private JLabel lblTipo;
	private JComboBox<String> comboBoxTipo1;
	private JComboBox<String> comboBoxTipo2;
	private PokedexDAO pokemon;
	private JTextArea textAreaDescripcion;
	private Pokemon poke;
	

	/**
	 * Create the application.
	 */
	public EditView(Pokemon poke) {
		this.poke=poke;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		pokemon = new PokedexDAO();
		setFrame();
		setComponents();
		cambioPokemon();
		setListeners();
		
	}

	private void setListeners() {
		
		//Se usa para obtener los datos de los textField e introducirlos en el objeto para introducirlos en la BD
		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tipo1=" ", tipo2=" ",tipos="" ;
				
				if (!textFieldNumero.getText().isBlank() && !textFieldNombre.getText().isBlank()
						&& !textFieldHabilidad.getText().isBlank() && !textFieldCategoria.getText().isBlank()
						&& !textFieldAltura.getText().isBlank() && !textFieldPeso.getText().isBlank()
						&& !textAreaDescripcion.getText().isBlank()) {
					
					if (comboBoxTipo2.getSelectedItem().toString().isBlank()) {
						tipos = comboBoxTipo1.getSelectedItem().toString();
						
					}else {
						tipo1 = comboBoxTipo1.getSelectedItem().toString();
						tipo2 = comboBoxTipo2.getSelectedItem().toString();
						tipos = tipo1 + ", " + tipo2;
						
					}
					
	
					poke = new Pokemon(Integer.parseInt(textFieldNumero.getText()), textFieldNombre.getText(),
							textAreaDescripcion.getText(), Float.parseFloat(textFieldAltura.getText()),
							Float.parseFloat(textFieldPeso.getText()), textFieldHabilidad.getText(),
							textFieldCategoria.getText(), tipos);

					pokemon.editarPokemon(poke);
					JOptionPane.showMessageDialog(frame, "Se ha editado correctamente");
					
				}
			}

		});

		textFieldNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (c < '0' || c > '9') {
					e.consume();
				}
			}
		});

		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'')) {
					
					e.consume();
				}
			}
		});

		textFieldCategoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'')) {
					
					e.consume();
				}
			}
		});

		textFieldHabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'')) {
					
					e.consume();
				}
			}
		});

		textFieldAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && c != '.') {
					e.consume();
				}
			}
		});

		textFieldPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && c != '.') {
					e.consume();
				}
			}
		});
		
		comboBoxTipo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxTipo2.setEnabled(true);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new PokedexView();
			}
		});
		
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'') && (c=='ñ')) {//Condicional por el cual no se pueden introducir numeros
					
					e.consume();
				}
			}
		});

		textFieldCategoria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'') && (c=='ñ')) {
					e.consume();
				}
			}
		});

		textFieldHabilidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && !(c==KeyEvent.VK_SPACE) && !(c=='\'') && (c=='ñ')) {
					
					e.consume();
				}
			}
		});

		textFieldAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && c != '.') {//Condicional por el cual no se pueden introducir letras y si se pueden poner "." para que sea float
					e.consume();
				}
			}
		});

		textFieldPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c < '0' || c > '9') && c != '.') {
					e.consume();
				}
			}
		});

		
	}

	private void setComponents() {

		lblTitulo = new JLabel("Add Pokemon");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(119, 11, 139, 31);
		frame.getContentPane().add(lblTitulo);

		lblNumeroPK = new JLabel("Numero");
		lblNumeroPK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNumeroPK.setBounds(20, 54, 69, 20);
		frame.getContentPane().add(lblNumeroPK);

		textFieldNumero = new JTextField();
		textFieldNumero.setEditable(false);
		textFieldNumero.setBounds(119, 56, 86, 20);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(119, 87, 86, 20);
		frame.getContentPane().add(textFieldNombre);

		lblNombrePK = new JLabel("Nombre");
		lblNombrePK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombrePK.setBounds(20, 85, 69, 20);
		frame.getContentPane().add(lblNombrePK);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setColumns(10);
		textFieldCategoria.setBounds(119, 120, 86, 20);
		frame.getContentPane().add(textFieldCategoria);

		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoria.setBounds(20, 118, 69, 20);
		frame.getContentPane().add(lblCategoria);

		textFieldHabilidad = new JTextField();
		textFieldHabilidad.setColumns(10);
		textFieldHabilidad.setBounds(119, 153, 86, 20);
		frame.getContentPane().add(textFieldHabilidad);

		lblHabilidad = new JLabel("Habilidad");
		lblHabilidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHabilidad.setBounds(20, 151, 69, 20);
		frame.getContentPane().add(lblHabilidad);

		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(119, 186, 86, 20);
		frame.getContentPane().add(textFieldAltura);

		lblAltura = new JLabel("Altura");
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAltura.setBounds(20, 184, 69, 20);
		frame.getContentPane().add(lblAltura);

		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(119, 219, 86, 20);
		frame.getContentPane().add(textFieldPeso);

		lblPeso = new JLabel("Peso");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPeso.setBounds(20, 217, 69, 20);
		frame.getContentPane().add(lblPeso);

		lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescripcion.setBounds(20, 250, 89, 20);
		frame.getContentPane().add(lblDescripcion);

		btnAnadir = new JButton("Add");
		btnAnadir.setBounds(277, 371, 89, 23);
		frame.getContentPane().add(btnAnadir);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(56, 371, 89, 23);
		frame.getContentPane().add(btnVolver);

		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(297, 54, 69, 20);
		frame.getContentPane().add(lblTipo);

		comboBoxTipo1 = new JComboBox<String>();
		comboBoxTipo1.setBounds(277, 86, 89, 21);
		frame.getContentPane().add(comboBoxTipo1);

		comboBoxTipo2 = new JComboBox<String>();
		comboBoxTipo2.setBounds(277, 119, 89, 21);
		frame.getContentPane().add(comboBoxTipo2);
		comboBoxTipo2.setEnabled(false);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(119, 250, 180, 75);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setLineWrap(true);
		frame.getContentPane().add(textAreaDescripcion);

		rellenarComboBox();
	}

	private void setFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}

	private void rellenarComboBox() {

		ArrayList<String> rellenoComboBox = pokemon.BuscarTipos();
		comboBoxTipo2.addItem("");
		for (int i = 0; i < rellenoComboBox.size(); i++) {
			comboBoxTipo1.addItem(rellenoComboBox.get(i));
			comboBoxTipo2.addItem(rellenoComboBox.get(i));
		}

	}
	
	/**
	 * Funcion para rellenar el pokemon segun la posicion
	 */
	public void cambioPokemon() {
		String[] tipos = poke.getTipos().split(", ");
		String numero=String.valueOf(poke.getNumero());
		textFieldHabilidad.setText(poke.getHabilidad());
		textFieldCategoria.setText(poke.getCategoria());
		textFieldNombre.setText(poke.getNombre());
		textFieldAltura.setText(Float.toString(poke.getAltura()));
		textFieldPeso.setText(Float.toString(poke.getPeso()));
		textFieldNumero.setText(Integer.toString(poke.getNumero()));
		textAreaDescripcion.setText(poke.getDescripcion());
		while (numero.length()<3) {
			numero="0"+numero;
		}
		if (tipos.length>1) {
			comboBoxTipo1.setSelectedItem(tipos[0]);
			comboBoxTipo2.setSelectedItem(tipos[1]);
		}else {
			comboBoxTipo1.setSelectedItem(tipos[0]);
		}
			
	}
}
