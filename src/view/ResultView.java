package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


import models.Pokemon;

public class ResultView implements KeyListener  {

	private JFrame frmResultBusqueda;
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
	private Pokemon poke;
	private int indice =0;
	private JLabel lblTipos;
	private JLabel lblTiposBD;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmSalir;
	private JMenuItem mntmAnadir;
	private JMenuItem mntmQuitar;
	private ArrayList<Pokemon> listaPokemon;
	
	


	/**
	 * Create the application.
	 * @param listaPokemon 
	 */
	public ResultView(ArrayList<Pokemon> listaPokemon) {
		this.listaPokemon=listaPokemon;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		poke=listaPokemon.get(indice);
		setFrame();
		setComponents();
		cambioPokemon();
		setListeners();
		frmResultBusqueda.setVisible(true);
		
	}
	
	private void setFrame() {
		frmResultBusqueda = new JFrame();
		frmResultBusqueda.setTitle("Pokedex");
		frmResultBusqueda.setResizable(false);
		frmResultBusqueda.addKeyListener(this);
		frmResultBusqueda.setFocusable(true);
		frmResultBusqueda.setFocusTraversalKeysEnabled(false);
		try {
			frmResultBusqueda.setIconImage(ImageIO.read(new URL("https://cdn0.iconfinder.com/data/icons/pokemon-go-vol-2/135/_pokemon_moltres-512.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frmResultBusqueda.setBounds(100, 100, 724, 431);
		frmResultBusqueda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResultBusqueda.getContentPane().setLayout(null);	
	}

	private void setListeners() {
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmResultBusqueda.requestFocus();
				siguiente();
				
			}
		});
		
		btnAnterior.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				frmResultBusqueda.requestFocus();
				anterior();
		}
	});
		
		mntmSalir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			new PokedexView();	
			frmResultBusqueda.dispose();
			
		}
	});
		
		mntmAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
	
	}

	private void setComponents() {

		lblImagen = new JLabel("");
		lblImagen.setBounds(36, 76, 212, 196);
		frmResultBusqueda.getContentPane().add(lblImagen);
		
		
		
		lblNombreP = new JLabel("Nombre:");
		lblNombreP.setBounds(354, 58, 72, 21);
		frmResultBusqueda.getContentPane().add(lblNombreP);
		
		lblNumPokedex = new JLabel("Numero de la Pokedex");
		lblNumPokedex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumPokedex.setBounds(194, 19, 138, 14);
		frmResultBusqueda.getContentPane().add(lblNumPokedex);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setBounds(354, 100, 46, 14);
		frmResultBusqueda.getContentPane().add(lblAltura);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(489, 100, 46, 14);
		frmResultBusqueda.getContentPane().add(lblPeso);
		
		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(354, 136, 72, 14);
		frmResultBusqueda.getContentPane().add(lblCategoria);
		
		lblHabilidad = new JLabel("Habilidad:");
		lblHabilidad.setBounds(354, 173, 55, 14);
		frmResultBusqueda.getContentPane().add(lblHabilidad);
		
		lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(303, 221, 97, 14);
		frmResultBusqueda.getContentPane().add(lblDescripcion);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBackground(Color.LIGHT_GRAY);
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setBounds(406, 221, 212, 76);
		textAreaDescripcion.setWrapStyleWord(true);
		
		textAreaDescripcion.setLineWrap(true);
		frmResultBusqueda.getContentPane().add(textAreaDescripcion);
		
		lblHabilidadBD = new JLabel("New label");
		lblHabilidadBD.setBounds(419, 173, 89, 14);
		frmResultBusqueda.getContentPane().add(lblHabilidadBD);
		
		lblCategoriaBD = new JLabel("New label");
		lblCategoriaBD.setBounds(419, 136, 99, 14);
		frmResultBusqueda.getContentPane().add(lblCategoriaBD);
		
		lblAlturaBD = new JLabel("New label");
		lblAlturaBD.setBounds(410, 100, 69, 14);
		frmResultBusqueda.getContentPane().add(lblAlturaBD);
		
		lblPesoBD = new JLabel("New label");
		lblPesoBD.setBounds(545, 100, 73, 14);
		frmResultBusqueda.getContentPane().add(lblPesoBD);
		
		lblNombreBD = new JLabel("New label");
		lblNombreBD.setBounds(406, 61, 72, 14);
		frmResultBusqueda.getContentPane().add(lblNombreBD);
		
		lblNumPokedexBD = new JLabel("New label");
		lblNumPokedexBD.setFont(new Font("Script MT Bold", Font.BOLD, 23));
		lblNumPokedexBD.setBounds(342, 11, 84, 36);
		frmResultBusqueda.getContentPane().add(lblNumPokedexBD);
		
		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(107, 328, 89, 23);
		frmResultBusqueda.getContentPane().add(btnAnterior);
		
		btnSiguiente = new JButton("Siguiente");
		
		btnSiguiente.setBounds(529, 328, 89, 23);
		frmResultBusqueda.getContentPane().add(btnSiguiente);		
		
		lblTipos = new JLabel("Tipo:");
		lblTipos.setBounds(489, 136, 46, 14);
		frmResultBusqueda.getContentPane().add(lblTipos);
		
		lblTiposBD = new JLabel("New labe");
		lblTiposBD.setBounds(528, 136, 97, 14);
		frmResultBusqueda.getContentPane().add(lblTiposBD);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 46, 22);
		frmResultBusqueda.getContentPane().add(menuBar);
		
		mnMenu = new JMenu("Men\u00FA");
		menuBar.add(mnMenu);
				
		
		mntmAnadir = new JMenuItem("A\u00F1adir Pokemon");
		mnMenu.add(mntmAnadir);
		
		mntmQuitar = new JMenuItem("Quitar Pokemon");
		mnMenu.add(mntmQuitar);
		
		mntmSalir = new JMenuItem("Salir");
		mnMenu.add(mntmSalir);
	}

	public void cambioPokemon() {
		
		String numero=String.valueOf(poke.getNumero());
		lblHabilidadBD.setText(poke.getHabilidad());
		lblCategoriaBD.setText(poke.getCategoria());
		lblNombreBD.setText(poke.getNombre());
		lblTiposBD.setText(poke.getTipos());
		lblAlturaBD.setText(Float.toString(poke.getAltura()));
		lblPesoBD.setText(Float.toString(poke.getPeso()));
		lblNumPokedexBD.setText(Integer.toString(poke.getNumero()));
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
		if (indice-->0) {
			poke =listaPokemon.get(indice);
			cambioPokemon();
			
		}else {
			indice=listaPokemon.size()-1;
			poke =listaPokemon.get(indice);
			cambioPokemon();

		}
	}
	public void siguiente() {
		if (indice++<listaPokemon.size()-1) {
			poke =listaPokemon.get(indice);
			cambioPokemon();
			
		}else {
			indice=0;
			poke =listaPokemon.get(indice);
			cambioPokemon();

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
