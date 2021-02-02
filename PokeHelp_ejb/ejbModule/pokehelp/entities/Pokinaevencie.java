package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pokinaevencie database table.
 * 
 */
@Entity
@NamedQuery(name="Pokinaevencie.findAll", query="SELECT p FROM Pokinaevencie p")
public class Pokinaevencie implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PokinaevenciePK id;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="pokemons_idpokemons", insertable=false, updatable=false)
	private Event event;

	//bi-directional many-to-one association to Pokemon
	@ManyToOne
	@JoinColumn(name="pokemons_idpokemons", insertable=false, updatable=false)
	private Pokemon pokemon;

	public Pokinaevencie() {
	}

	public PokinaevenciePK getId() {
		return this.id;
	}

	public void setId(PokinaevenciePK id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Pokemon getPokemon() {
		return this.pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

}