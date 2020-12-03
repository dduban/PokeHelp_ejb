package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the kody database table.
 * 
 */
@Embeddable
public class KodyPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idkody;

	@Column(name="user_iduser", insertable=false, updatable=false)
	private int userIduser;

	public KodyPK() {
	}
	public int getIdkody() {
		return this.idkody;
	}
	public void setIdkody(int idkody) {
		this.idkody = idkody;
	}
	public int getUserIduser() {
		return this.userIduser;
	}
	public void setUserIduser(int userIduser) {
		this.userIduser = userIduser;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof KodyPK)) {
			return false;
		}
		KodyPK castOther = (KodyPK)other;
		return 
			(this.idkody == castOther.idkody)
			&& (this.userIduser == castOther.userIduser);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idkody;
		hash = hash * prime + this.userIduser;
		
		return hash;
	}
}