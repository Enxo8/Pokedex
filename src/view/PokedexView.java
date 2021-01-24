package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import DAO.PokedexDAO;
import models.Pokemon;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class PokedexView implements KeyListener {

	private JFrame frmPokedex;
	private JLabel lblImagen;
	private JLabel lblNombreP;
	private JLabel lblNumPokedex;
	private JLabel lblAltura;
	private JLabel lblPeso;
	private JLabel lblCategoria;
	private JLabel lblHabilidad;
	private JLabel lblDescripcion;
	private JTextArea textAreaDescripcion;
	private JLabel lblHabilidadBD;
	private JLabel lblCategoriaBD;
	private JLabel lblAlturaBD;
	private JLabel lblPesoBD;
	private JLabel lblNombreBD;
	private JLabel lblNumPokedexBD;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private PokedexDAO pokemon;
	private Pokemon poke;
	private int indice;
	private JLabel lblTipos;
	private JLabel lblTiposBD;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmBuscar;
	private JMenuItem mntmAnadir;
	private JMenuItem mntmQuitar;
	private JMenuItem mntmEditar;
	private String confBorrar;

	/**
	 * Create the application.
	 */
	public PokedexView() {
		pokemon = new PokedexDAO();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		indice = pokemon.contarPokemonMin();
		setFrame();
		setComponents();
		cambioPokemon(indice);
		setLiseners();
		frmPokedex.setVisible(true);
		frmPokedex.addKeyListener(this);
		frmPokedex.setFocusable(true);
		frmPokedex.setFocusTraversalKeysEnabled(false);

	}

	private void setFrame() {
		frmPokedex = new JFrame();
		frmPokedex.setTitle("Pokedex");
		frmPokedex.setResizable(false);
		try {
			frmPokedex.setIconImage(ImageIO.read(
					new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmPokedex.setBounds(100, 100, 724, 431);
		frmPokedex.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedex.getContentPane().setLayout(null);
	}

	private void setLiseners() {
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPokedex.requestFocus();
				siguiente();

			}
		});

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPokedex.requestFocus();
				anterior();
			}
		});

		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new BuscarView();
				frmPokedex.dispose();

			}
		});

		mntmAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AnadirView();
				frmPokedex.dispose();
			}
		});
		
		mntmEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(poke);
				frmPokedex.dispose();
			}
		});
		
		mntmQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confBorrar = JOptionPane.showInputDialog(frmPokedex, "Introduzca el nombre exacto del pokemon que desea borrar", JOptionPane.QUESTION_MESSAGE);
				if (confBorrar!=null) {
					if (confBorrar.equals(poke.getNombre())) {
						pokemon.borrarPokemon(poke);
						siguiente();
					}else {
						JOptionPane.showMessageDialog(frmPokedex, "No se encuentra el pokemon");
					}
				}
			}
		});
	}

	private void setComponents() {

		lblImagen = new JLabel("");
		lblImagen.setBounds(36, 58, 232, 239);
		frmPokedex.getContentPane().add(lblImagen);

		lblNombreP = new JLabel("Nombre:");
		lblNombreP.setBounds(354, 58, 72, 21);
		frmPokedex.getContentPane().add(lblNombreP);

		lblNumPokedex = new JLabel("Numero de la Pokedex");
		lblNumPokedex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumPokedex.setBounds(194, 19, 138, 14);
		frmPokedex.getContentPane().add(lblNumPokedex);

		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(354, 100, 46, 14);
		frmPokedex.getContentPane().add(lblAltura);

		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(489, 100, 46, 14);
		frmPokedex.getContentPane().add(lblPeso);

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(354, 136, 72, 14);
		frmPokedex.getContentPane().add(lblCategoria);

		lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(354, 173, 55, 14);
		frmPokedex.getContentPane().add(lblHabilidad);

		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(303, 221, 97, 14);
		frmPokedex.getContentPane().add(lblDescripcion);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(Color.LIGHT_GRAY);
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setBounds(406, 221, 212, 76);
		textAreaDescripcion.setWrapStyleWord(true);
		textAreaDescripcion.setLineWrap(true);
		frmPokedex.getContentPane().add(textAreaDescripcion);

		lblHabilidadBD = new JLabel("New label");
		lblHabilidadBD.setBounds(419, 173, 89, 14);
		frmPokedex.getContentPane().add(lblHabilidadBD);

		lblCategoriaBD = new JLabel("New label");
		lblCategoriaBD.setBounds(419, 136, 99, 14);
		frmPokedex.getContentPane().add(lblCategoriaBD);

		lblAlturaBD = new JLabel("New label");
		lblAlturaBD.setBounds(410, 100, 69, 14);
		frmPokedex.getContentPane().add(lblAlturaBD);

		lblPesoBD = new JLabel("New label");
		lblPesoBD.setBounds(545, 100, 73, 14);
		frmPokedex.getContentPane().add(lblPesoBD);

		lblNombreBD = new JLabel("New label");
		lblNombreBD.setBounds(406, 61, 72, 14);
		frmPokedex.getContentPane().add(lblNombreBD);

		lblNumPokedexBD = new JLabel("New label");
		lblNumPokedexBD.setFont(new Font("Script MT Bold", Font.BOLD, 23));
		lblNumPokedexBD.setBounds(342, 11, 84, 36);
		frmPokedex.getContentPane().add(lblNumPokedexBD);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(107, 328, 89, 23);
		frmPokedex.getContentPane().add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");

		btnSiguiente.setBounds(529, 328, 89, 23);
		frmPokedex.getContentPane().add(btnSiguiente);

		lblTipos = new JLabel("Tipo:");
		lblTipos.setBounds(489, 136, 46, 14);
		frmPokedex.getContentPane().add(lblTipos);

		lblTiposBD = new JLabel("New labe");
		lblTiposBD.setBounds(528, 136, 97, 14);
		frmPokedex.getContentPane().add(lblTiposBD);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 46, 22);
		frmPokedex.getContentPane().add(menuBar);

		mnMenu = new JMenu("Men\u00FA");
		menuBar.add(mnMenu);

		mntmBuscar = new JMenuItem("Buscar Pokemon");
		mnMenu.add(mntmBuscar);

		mntmAnadir = new JMenuItem("Anadir Pokemon");
		mnMenu.add(mntmAnadir);

		mntmQuitar = new JMenuItem("Quitar Pokemon");
		mnMenu.add(mntmQuitar);
		
		mntmEditar = new JMenuItem("Editar Pokemon");
		
		mnMenu.add(mntmEditar);
	}
	
	/**
	 * Funcion que rellena el pokemon segun la posicion en la que se encuentre.
	 * @param indice
	 */
	public void cambioPokemon(int indice) {
		String numero = String.valueOf(indice);
		poke = pokemon.pokemon(indice);
		lblHabilidadBD.setText(poke.getHabilidad());
		lblCategoriaBD.setText(poke.getCategoria());
		lblNombreBD.setText(poke.getNombre());
		lblTiposBD.setText(poke.getTipos());
		lblAlturaBD.setText(Float.toString(poke.getAltura()));
		lblPesoBD.setText(Float.toString(poke.getPeso()));
		lblNumPokedexBD.setText(Integer.toString(indice));
		textAreaDescripcion.setText(poke.getDescripcion());
		while (numero.length() < 3) {
			numero = "0" + numero;
		}
		try {
			lblImagen.setIcon(new ImageIcon(
					new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/" + numero + ".png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * Funcion que pasa al siguiente pokemon.
	 */
	public void siguiente() {
		indice++;
		boolean bul = true;
		while (bul) {
			if (pokemon.hayPokemon(indice)) {
				cambioPokemon(indice);
				bul = false;
			} else {
				indice++;
				if (indice > pokemon.contarPokemonMax()) {
					indice = pokemon.contarPokemonMin();
					cambioPokemon(indice);
					bul = false;
				} else {
					bul = true;
				}
			}
		}
	}
	
	/**
	 * Funcion que pasa al pokemon anterior
	 * 
	 */
	public void anterior() {
		indice--;
		boolean bul = true;
		while (bul) {
			if (pokemon.hayPokemon(indice)) {
				cambioPokemon(indice);
				bul = false;
			} else {
				indice--;
				if (indice < pokemon.contarPokemonMin()) {
					indice = pokemon.contarPokemonMax();
					cambioPokemon(indice);
					bul = false;
				} else {
					bul = true;
				}
			}
		}
	}
	
	
	 //Aqui se anade la accion para poder moverse entre los pokemon con las flechas
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			siguiente();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			anterior();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
