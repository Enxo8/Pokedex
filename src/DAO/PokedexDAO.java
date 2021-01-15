package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}
