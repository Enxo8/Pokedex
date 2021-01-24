package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;



import DAO.PokedexDAO;
import models.Pokemon;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class BuscarView {

	private JFrame frame;
	private JLabel lblBuscar;
	private JTextField textFieldBuscar;
	private JRadioButton rdbtnNombre;
	private JRadioButton rdbtnTipo;
	private JRadioButton rdbtnNumero;
	private JLabel lblBuscarTF;
	private JButton btnBuscar;
	private JButton btnVolver;
	private JComboBox<String> comboBoxTipos;
	private PokedexDAO pokemon;
	private ButtonGroup grupoBotones;
	private ArrayList<Pokemon> listaPokemon;
	
	
	/**
	 * Create the application.
	 */
	public BuscarView() {
		listaPokemon= new ArrayList<Pokemon>();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		pokemon = new PokedexDAO();
		grupoBotones = new ButtonGroup();
		setFrame();
		setComponents();
		setListeners();
		frame.setVisible(true);
		
	}
	
	
	private void setComponents() {
		
		lblBuscar = new JLabel("Buscador de Pokemon");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscar.setBounds(145, 11, 187, 38);
		frame.getContentPane().add(lblBuscar);
		
		rdbtnNombre = new JRadioButton("Nombre");
		
		rdbtnNombre.setBounds(46, 62, 73, 23);
		frame.getContentPane().add(rdbtnNombre);
		
		rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.setBounds(321, 62, 58, 23);
		frame.getContentPane().add(rdbtnTipo);
		
		rdbtnNumero = new JRadioButton("Numero de Pokedex");
		rdbtnNumero.setBounds(155, 62, 121, 23);
		frame.getContentPane().add(rdbtnNumero);
		
		lblBuscarTF = new JLabel("Buscar");
		lblBuscarTF.setBounds(46, 138, 46, 14);
		frame.getContentPane().add(lblBuscarTF);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(280, 226, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(66, 226, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		textFieldBuscar = new JTextField();
		textFieldBuscar.setEnabled(false);
		textFieldBuscar.setBounds(102, 135, 86, 20);
		frame.getContentPane().add(textFieldBuscar);
		textFieldBuscar.setColumns(10);
		
		comboBoxTipos = new JComboBox<String>();
		comboBoxTipos.setEnabled(false);
		comboBoxTipos.setBounds(280, 134, 89, 22);
		frame.getContentPane().add(comboBoxTipos);
		rellenarComboBox();
		
		grupoBotones.add(rdbtnNumero);
		grupoBotones.add(rdbtnNombre);
		grupoBotones.add(rdbtnTipo);
		
		
	}
	
	private void setListeners() {
		
		rdbtnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxTipos.setEnabled(true);
				textFieldBuscar.setEnabled(false);
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnTipo.isSelected()) {
					listaPokemon=pokemon.buscarPokemonTipo(comboBoxTipos.getSelectedItem().toString());
					new ResultView(listaPokemon);
					frame.dispose();
				}else if (rdbtnNombre.isSelected()) {
					listaPokemon=pokemon.buscarPokemonNombre(textFieldBuscar.getText());
					new ResultView(listaPokemon);
					frame.dispose();
				}else if (rdbtnNumero.isSelected()) {
					listaPokemon=pokemon.buscarPokemonNumero(Integer.parseInt(textFieldBuscar.getText()));
					new ResultView(listaPokemon);
					frame.dispose();
				}
				
			}
		});
		
		textFieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (rdbtnNombre.isSelected()) {
					if (!(c < '0'|| c > '9')) {
						e.consume();
					}
					
				}else if (rdbtnNumero.isSelected()) {
							if (c < '0' || c > '9') {//Condicional por el cual no se pueden introducir letras en el campo de numero
								e.consume();
							}
						}
					
				}
			
		});
		
		rdbtnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxTipos.setEnabled(false);
				textFieldBuscar.setEnabled(true);
			}
		});
		
		rdbtnNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxTipos.setEnabled(false);
				textFieldBuscar.setEnabled(true);
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new PokedexView();
				frame.dispose();
			}
		});
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 474, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	}
	
	public void rellenarComboBox() {//Rellena comboBox
		
		ArrayList<String>rellenoComboBox = pokemon.BuscarTipos();
		
		for (int i = 0; i < rellenoComboBox.size(); i++) {
			comboBoxTipos.addItem(rellenoComboBox.get(i));
		}
	}
	
}
