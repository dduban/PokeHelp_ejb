package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the webo database table.
 * 
 */
@Entity
@NamedQuery(name="Webo.findAll", query="SELECT w FROM Webo w")
public class Webo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idWebo;

	private String nazwa;

	//bi-directional many-to-one association to Pokemon
	@OneToMany(mappedBy="weboBean")
	private List<Pokemon> pokemons;

	public Webo() {
	}

	public int getIdWebo() {
		return this.idWebo;
	}

	public void setIdWebo(int idWebo) {
		this.idWebo = idWebo;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Pokemon> getPokemons() {
		return this.pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public Pokemon addPokemon(Pokemon pokemon) {
		getPokemons().add(pokemon);
		pokemon.setWeboBean(this);

		return pokemon;
	}

	public Pokemon removePokemon(Pokemon pokemon) {
		getPokemons().remove(pokemon);
		pokemon.setWeboBean(null);

		return pokemon;
	}

}