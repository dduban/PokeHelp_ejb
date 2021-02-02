package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ulubione database table.
 * 
 */
@Entity
@NamedQuery(name="Ulubione.findAll", query="SELECT u FROM Ulubione u")
public class Ulubione implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UlubionePK id;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	@JoinColumn(name="pokemons_idpokemons", insertable=false, updatable=false)
	private Pokemon pokemon;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_iduser", insertable=false, updatable=false)
	private User user;

	public Ulubione() {
	}

	public UlubionePK getId() {
		return this.id;
	}

	public void setId(UlubionePK id) {
		this.id = id;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}