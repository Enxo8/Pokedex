package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Pokemon;

public class PokedexDAO extends AbstractDao {
	

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
	
	public int contarPokemon() {
		
		try {
			ResultSet rsContar = stmt.executeQuery("SELECT COUNT(*) from pokemon.pokemon");
			if (rsContar.next()) {
				 return rsContar.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
		
	}
	
	public ArrayList<Pokemon> BuscarPokemonNombre(String buscador) {
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
	
	public ArrayList<Pokemon> BuscarPokemonTipo(String buscador) {
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
	
	public ArrayList<Pokemon> BuscarPokemonNumero(int indice) {
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
}
