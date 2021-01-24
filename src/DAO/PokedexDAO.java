package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokedexDAO extends AbstractDao {
	
	/**
	 * Consulta para obtener pokemon de la base de datos y añadirlos al objeto pokemon
	 * @param indice
	 * @return
	 */
	public Pokemon pokemon(int indice) {
		String tipo = "" ;
		int indiceTipo=0;
		try {
			ResultSet rsPokemon = stmt.executeQuery("Select * from pokemon where numero = " + indice);
			if (rsPokemon.next()) {

				Pokemon pokemon = new Pokemon(rsPokemon.getInt(1), rsPokemon.getString(2), rsPokemon.getString(3),
						rsPokemon.getFloat(4), rsPokemon.getFloat(5), rsPokemon.getString(6), rsPokemon.getString(7),
						null);

				ResultSet rsTipos = stmt.executeQuery(
						"select nombre_tipo from pokemon.tipos, pokemon.pokemon_tipo where pokemon_tipo.codigo_tipo=tipos.codigo_tipo and pokemon_tipo.numero = "
								+ indice);
				if (rsTipos.next()) {
					tipo = rsTipos.getString(1);
					indiceTipo++;
					while (rsTipos.next()) {
						indiceTipo++;
						if (indiceTipo>1) {
							tipo+=", "+rsTipos.getString(1);
						}
					}
				}
				pokemon.setTipos(tipo);
				return pokemon;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * Consulta que devuelve el numero maximo de pokemon que hay en la consulta
	 * @return
	 */
	public int contarPokemonMax() {
		
		try {
			ResultSet rsContar = stmt.executeQuery("SELECT MAX(numero) from pokemon.pokemon");
			if (rsContar.next()) {
				 return rsContar.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	/**
	 * Consulta que devuelve el numero minimo de pokemon que hay en la consulta
	 * @return
	 */
	public int contarPokemonMin() {
		
		try {
			ResultSet rsContar = stmt.executeQuery("SELECT MIN(numero) from pokemon.pokemon");
			if (rsContar.next()) {
				 return rsContar.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	/**
	 * Consulta que devuelve una lista de pokemon segun el nombre
	 * @param buscador
	 * @return
	 */
	public ArrayList<Pokemon> buscarPokemonNombre(String buscador) {
		ArrayList<Pokemon>arrayListPokemon = new ArrayList<Pokemon>();
		String tipo = "" ;
		int indiceTipo=0;
		try {
			ResultSet rsBuscar = stmt.executeQuery("SELECT * from pokemon.pokemon where Nombre like '%"+ buscador +"%'");
			while (rsBuscar.next()) {
				Pokemon pokemon = new Pokemon(rsBuscar.getInt(1), rsBuscar.getString(2), rsBuscar.getString(3),
						rsBuscar.getFloat(4), rsBuscar.getFloat(5), rsBuscar.getString(6), rsBuscar.getString(7),
						null);
				Statement stmt2 = conn.createStatement();
				ResultSet rsTipos = stmt2.executeQuery(
						"select nombre_tipo from pokemon.tipos, pokemon.pokemon_tipo where pokemon_tipo.codigo_tipo=tipos.codigo_tipo and pokemon_tipo.numero = "
								+ rsBuscar.getInt(1));
				if (rsTipos.next()) {
					tipo = rsTipos.getString(1);
					indiceTipo++;
					while (rsTipos.next()) {
						indiceTipo++;
						if (indiceTipo>1) {
							tipo+=", "+rsTipos.getString(1);
						}
					}
				}
				pokemon.setTipos(tipo);
				arrayListPokemon.add(pokemon);
				
				
			}
		return arrayListPokemon;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Consulta que devuelve un arrayList de los tipos de pokemon
	 * @return
	 */
	public ArrayList<String> BuscarTipos() {
		ArrayList<String>arrayListTipos = new ArrayList<String>();
		try {
			ResultSet rsBuscarT = stmt.executeQuery("SELECT Nombre_Tipo FROM pokemon.tipos");
			while (rsBuscarT.next()) {
				arrayListTipos.add(rsBuscarT.getString(1));
			}
			return arrayListTipos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Consulta que devuelve una lista de los pokemon segun el tipo
	 * @param buscador
	 * @return
	 */
	public ArrayList<Pokemon> buscarPokemonTipo(String buscador) {
		ArrayList<Pokemon>arrayListPokemon = new ArrayList<Pokemon>();
		String tipo = "" ;
		int indiceTipo=0;
		try {
			ResultSet rsBuscar = stmt.executeQuery("SELECT * FROM pokemon.pokemon,pokemon.pokemon_tipo,pokemon.tipos where	pokemon_tipo.numero=pokemon.numero and pokemon_tipo.codigo_Tipo = tipos.Codigo_Tipo and Nombre_Tipo like '"+ buscador +"'");
			while (rsBuscar.next()) {
				Pokemon pokemon = new Pokemon(rsBuscar.getInt(1), rsBuscar.getString(2), rsBuscar.getString(3),
						rsBuscar.getFloat(4), rsBuscar.getFloat(5), rsBuscar.getString(6), rsBuscar.getString(7),
						null);
				Statement stmt2 = conn.createStatement();
				ResultSet rsTipos = stmt2.executeQuery(
						"select nombre_tipo from pokemon.tipos, pokemon.pokemon_tipo where pokemon_tipo.codigo_tipo=tipos.codigo_tipo and pokemon_tipo.numero = "
								+ rsBuscar.getInt(1));
				if (rsTipos.next()) {
					tipo = rsTipos.getString(1);
					indiceTipo++;
					while (rsTipos.next()) {
						indiceTipo++;
						if (indiceTipo>1) {
							tipo+=", "+rsTipos.getString(1);
						}
					}
				}
				pokemon.setTipos(tipo);
				arrayListPokemon.add(pokemon);
				
				
			}
		return arrayListPokemon;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Consulta que devuelve una lista de los pokemon segun el numero
	 * @param indice
	 * @return
	 */
	public ArrayList<Pokemon> buscarPokemonNumero(int indice) {
		ArrayList<Pokemon>arrayListPokemon = new ArrayList<Pokemon>();
		String tipo = "" ;
		int indiceTipo=0;
		try {
			ResultSet rsPokemon = stmt.executeQuery("Select * from pokemon where numero = " + indice);
			if (rsPokemon.next()) {

				Pokemon pokemon = new Pokemon(rsPokemon.getInt(1), rsPokemon.getString(2), rsPokemon.getString(3),
						rsPokemon.getFloat(4), rsPokemon.getFloat(5), rsPokemon.getString(6), rsPokemon.getString(7),
						null);

				ResultSet rsTipos = stmt.executeQuery(
						"select nombre_tipo from pokemon.tipos, pokemon.pokemon_tipo where pokemon_tipo.codigo_tipo=tipos.codigo_tipo and pokemon_tipo.numero = "
								+ indice);
				if (rsTipos.next()) {
					tipo = rsTipos.getString(1);
					indiceTipo++;
					while (rsTipos.next()) {
						indiceTipo++;
						if (indiceTipo>1) {
							tipo+=", "+rsTipos.getString(1);
						}
					}
				}
				pokemon.setTipos(tipo);
				arrayListPokemon.add(pokemon);
			}
			return arrayListPokemon;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}
	
	/**
	 * Devuelve true/false si existe siguiente numero o no
	 * @param indice
	 * @return
	 */
	public boolean hayPokemon(int indice) {
		
		try {
			ResultSet rsSiguiente = stmt.executeQuery("Select * from pokemon where numero = "+indice);
			if (rsSiguiente.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	/**
	 * Metodo que añade pokemon a la base de datos
	 * @param pokemon
	 */
	public void anadirPokemon(Pokemon pokemon) {
		
		try {
			String cons1 = "INSERT INTO `pokemon`.`pokemon` (`Numero`, `Nombre`, `Descripcion`, `Altura`, `Peso`, `Categoria`, `Habilidad`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(cons1);
			stmt.setInt(1, pokemon.getNumero());
			stmt.setString(2, pokemon.getNombre());
			stmt.setString(3, pokemon.getDescripcion());
			stmt.setFloat(4, pokemon.getAltura());
			stmt.setFloat(5, pokemon.getPeso());
			stmt.setString(6, pokemon.getCategoria());
			stmt.setString(7, pokemon.getHabilidad());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			String cons2 = "INSERT INTO `pokemon`.`pokemon_tipo` (`Numero`, `Codigo_Tipo`) VALUES (?, ?)";
			PreparedStatement stmt2 = conn.prepareStatement(cons2);
			String[] arrayTipo = pokemon.getTipos().split(", ");
			for (int i = 0; i < arrayTipo.length; i++) {
				stmt2.setInt(1, pokemon.getNumero());
				stmt2.setInt(2, buscarNumTipo(arrayTipo[i]));
				stmt2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Metodo que busca el numero del tipo a partir del nombre
	 * @param tipo
	 * @return
	 */
	public int buscarNumTipo(String tipo) {
		
		try {
			ResultSet rsBuscar = stmt.executeQuery("SELECT Codigo_Tipo FROM pokemon.tipos where nombre_tipo like '"+tipo+"'");
			if (rsBuscar.next()) {
				return rsBuscar.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/**
	 * Metodo para editar pokemon y actualizarlo en la BD
	 * @param pokemon
	 */
	public void editarPokemon(Pokemon pokemon) {
		try {
			String cons1 = "UPDATE pokemon SET nombre=?, descripcion=?, altura=?, peso=?, categoria=?, habilidad=? where(numero="+pokemon.getNumero()+")";
			PreparedStatement stmt = conn.prepareStatement(cons1);
			
			stmt.setString(1, pokemon.getNombre());
			stmt.setString(2, pokemon.getDescripcion());
			stmt.setFloat(3, pokemon.getAltura());
			stmt.setFloat(4, pokemon.getPeso());
			stmt.setString(5, pokemon.getCategoria());
			stmt.setString(6, pokemon.getHabilidad());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM pokemon_tipo where numero="+pokemon.getNumero());
			stmt.executeUpdate();
			anadirTipo(pokemon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para anadir pokemon a la BD 
	 * @param pokemon
	 */
	public void anadirTipo(Pokemon pokemon) {
		try {
			String cons2 = "INSERT INTO `pokemon`.`pokemon_tipo` (`Numero`, `Codigo_Tipo`) VALUES (?, ?)";
			PreparedStatement stmt2 = conn.prepareStatement(cons2);
			String[] arrayTipo = pokemon.getTipos().split(", ");
			for (int i = 0; i < arrayTipo.length; i++) {
				stmt2.setInt(1, pokemon.getNumero());
				stmt2.setInt(2, buscarNumTipo(arrayTipo[i]));
				stmt2.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para eliminar pokemon de la BD
	 * @param pokemon
	 */
	public void borrarPokemon(Pokemon pokemon) {
		
		try {
			PreparedStatement stmt = conn.prepareStatement("DELETE FROM pokemon_tipo where numero="+pokemon.getNumero());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM pokemon where numero="+pokemon.getNumero());
			stmt2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
