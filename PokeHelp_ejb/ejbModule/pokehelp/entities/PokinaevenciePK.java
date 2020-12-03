package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pokinaevencie database table.
 * 
 */
@Embeddable
public class PokinaevenciePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idpokinaevencie;

	@Column(name="event_idevent", insertable=false, updatable=false)
	private int eventIdevent;

	@Column(name="pokemons_idpokemons", insertable=false, updatable=false)
	private int pokemonsIdpokemons;

	public PokinaevenciePK() {
	}
	public int getIdpokinaevencie() {
		return this.idpokinaevencie;
	}
	public void setIdpokinaevencie(int idpokinaevencie) {
		this.idpokinaevencie = idpokinaevencie;
	}
	public int getEventIdevent() {
		return this.eventIdevent;
	}
	public void setEventIdevent(int eventIdevent) {
		this.eventIdevent = eventIdevent;
	}
	public int getPokemonsIdpokemons() {
		return this.pokemonsIdpokemons;
	}
	public void setPokemonsIdpokemons(int pokemonsIdpokemons) {
		this.pokemonsIdpokemons = pokemonsIdpokemons;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PokinaevenciePK)) {
			return false;
		}
		PokinaevenciePK castOther = (PokinaevenciePK)other;
		return 
			(this.idpokinaevencie == castOther.idpokinaevencie)
			&& (this.eventIdevent == castOther.eventIdevent)
			&& (this.pokemonsIdpokemons == castOther.pokemonsIdpokemons);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idpokinaevencie;
		hash = hash * prime + this.eventIdevent;
		hash = hash * prime + this.pokemonsIdpokemons;
		
		return hash;
	}
}