package view;

import java.awt.EventQueue;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

public class PokedexView implements KeyListener {

	private JFrame frame;
	private	JLabel lblImagen;
	private JLabel lblNombreP;
	private	JLabel lblNumPokedex;
	private	JLabel lblAltura;
	private	JLabel lblPeso;
	private	JLabel lblCategoria;
	private	JLabel lblHabilidad;
	private	JLabel lblDescripcion;
	private	JTextArea textAreaDescripcion;
	private	JLabel lblHabilidadBD;
	private	JLabel lblCategoriaBD;
	private	JLabel lblAlturaBD ;
	private	JLabel lblPesoBD;
	private	JLabel lblNombreBD;
	private	JLabel lblNumPokedexBD;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private PokedexDAO pokemon;
	private Pokemon poke;
	private int indice =1;
	private JLabel lblTipos;
	private JLabel lblTiposBD;
	


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
		setFrame();
		setComponents();
		cambioPokemon(indice);
		setLiseners();
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.setFocusable(true);
		frame.setFocusTraversalKeysEnabled(false);
		
		
	}
	
	private void setFrame() {
		frame = new JFrame();
		frame.setResizable(false);
		try {
			frame.setIconImage(ImageIO.read(new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setBounds(100, 100, 724, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);	
	}

	private void setLiseners() {
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				siguiente();
				
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			anterior();
		}
	});
		
		
	}

	private void setComponents() {

		lblImagen = new JLabel("");
		lblImagen.setBounds(36, 76, 212, 196);
		frame.getContentPane().add(lblImagen);
		
		
		
		lblNombreP = new JLabel("Nombre:");
		lblNombreP.setBounds(354, 58, 72, 21);
		frame.getContentPane().add(lblNombreP);
		
		lblNumPokedex = new JLabel("Numero de la Pokedex");
		lblNumPokedex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumPokedex.setBounds(194, 11, 138, 14);
		frame.getContentPane().add(lblNumPokedex);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(354, 100, 46, 14);
		frame.getContentPane().add(lblAltura);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(489, 100, 46, 14);
		frame.getContentPane().add(lblPeso);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(354, 136, 72, 14);
		frame.getContentPane().add(lblCategoria);
		
		lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(354, 173, 55, 14);
		frame.getContentPane().add(lblHabilidad);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(303, 221, 97, 14);
		frame.getContentPane().add(lblDescripcion);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(Color.LIGHT_GRAY);
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setBounds(406, 221, 212, 76);
		textAreaDescripcion.setWrapStyleWord(true);
		
		textAreaDescripcion.setLineWrap(true);
		frame.getContentPane().add(textAreaDescripcion);
		
		lblHabilidadBD = new JLabel("New label");
		lblHabilidadBD.setBounds(419, 173, 89, 14);
		frame.getContentPane().add(lblHabilidadBD);
		
		lblCategoriaBD = new JLabel("New label");
		lblCategoriaBD.setBounds(419, 136, 99, 14);
		frame.getContentPane().add(lblCategoriaBD);
		
		lblAlturaBD = new JLabel("New label");
		lblAlturaBD.setBounds(410, 100, 69, 14);
		frame.getContentPane().add(lblAlturaBD);
		
		lblPesoBD = new JLabel("New label");
		lblPesoBD.setBounds(545, 100, 73, 14);
		frame.getContentPane().add(lblPesoBD);
		
		lblNombreBD = new JLabel("New label");
		lblNombreBD.setBounds(406, 61, 72, 14);
		frame.getContentPane().add(lblNombreBD);
		
		lblNumPokedexBD = new JLabel("New label");
		lblNumPokedexBD.setFont(new Font("Script MT Bold", Font.BOLD, 23));
		lblNumPokedexBD.setBounds(342, -3, 84, 36);
		frame.getContentPane().add(lblNumPokedexBD);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(107, 328, 89, 23);
		frame.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		
		btnSiguiente.setBounds(529, 328, 89, 23);
		frame.getContentPane().add(btnSiguiente);		
		
		lblTipos = new JLabel("Tipo:");
		lblTipos.setBounds(489, 136, 46, 14);
		frame.getContentPane().add(lblTipos);
		
		lblTiposBD = new JLabel("New labe");
		lblTiposBD.setBounds(528, 136, 97, 14);
		frame.getContentPane().add(lblTiposBD);
	}

	public void cambioPokemon(int indice) {
		String numero=String.valueOf(indice);
		poke=pokemon.pokemon(indice);
		lblHabilidadBD.setText(poke.getHabilidad());
		lblCategoriaBD.setText(poke.getCategoria());
		lblNombreBD.setText(poke.getNombre());
		lblTiposBD.setText(poke.getTipos());
		lblAlturaBD.setText(Float.toString(poke.getAltura()));
		lblPesoBD.setText(Float.toString(poke.getPeso()));
		lblNumPokedexBD.setText(Integer.toString(indice));
		textAreaDescripcion.setText(poke.getDescripcion());
		while (numero.length()<3) {
			numero="0"+numero;
		}
		try {
			lblImagen.setIcon(new ImageIcon(new URL("https://assets.pokemon.com/assets/cms2/img/pokedex/detail/"+ numero + ".png")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void anterior() {
		if (indice-->1) {
			cambioPokemon(indice);
			
		}else {
			indice=pokemon.contarPokemon();
			cambioPokemon(indice);

		}
	}
	public void siguiente() {
		if (indice++<pokemon.contarPokemon()) {
			cambioPokemon(indice);
			
		}else {
			indice=1;
			cambioPokemon(indice);

		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			siguiente();
		}else if (e.getKeyCode()== KeyEvent.VK_LEFT) {
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
