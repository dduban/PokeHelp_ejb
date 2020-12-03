package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ulubione database table.
 * 
 */
@Embeddable
public class UlubionePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idulubione;

	@Column(name="user_iduser", insertable=false, updatable=false)
	private int userIduser;

	@Column(name="pokemons_idpokemons", insertable=false, updatable=false)
	private int pokemonsIdpokemons;

	public UlubionePK() {
	}
	public int getIdulubione() {
		return this.idulubione;
	}
	public void setIdulubione(int idulubione) {
		this.idulubione = idulubione;
	}
	public int getUserIduser() {
		return this.userIduser;
	}
	public void setUserIduser(int userIduser) {
		this.userIduser = userIduser;
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
		if (!(other instanceof UlubionePK)) {
			return false;
		}
		UlubionePK castOther = (UlubionePK)other;
		return 
			(this.idulubione == castOther.idulubione)
			&& (this.userIduser == castOther.userIduser)
			&& (this.pokemonsIdpokemons == castOther.pokemonsIdpokemons);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idulubione;
		hash = hash * prime + this.userIduser;
		hash = hash * prime + this.pokemonsIdpokemons;
		
		return hash;
	}
}