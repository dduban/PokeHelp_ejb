package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typ database table.
 * 
 */
@Entity
@NamedQuery(name="Typ.findAll", query="SELECT t FROM Typ t")
public class Typ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTyp;

	private String nazwa;

	//bi-directional many-to-one association to Pokemon
	@OneToMany(mappedBy="typBean")
	private List<Pokemon> pokemons;

	public Typ() {
	}

	public int getIdTyp() {
		return this.idTyp;
	}

	public void setIdTyp(int idTyp) {
		this.idTyp = idTyp;
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
		pokemon.setTypBean(this);

		return pokemon;
	}

	public Pokemon removePokemon(Pokemon pokemon) {
		getPokemons().remove(pokemon);
		pokemon.setTypBean(null);

		return pokemon;
	}

}