package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int iduser;

	private String login;

	private String password;

	private String role;

	//bi-directional many-to-one association to Kody
	@OneToMany(mappedBy="user")
	private List<Kody> kodies;

	//bi-directional many-to-one association to Ulubione
	@OneToMany(mappedBy="user")
	private List<Ulubione> ulubiones;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Kody> getKodies() {
		return this.kodies;
	}

	public void setKodies(List<Kody> kodies) {
		this.kodies = kodies;
	}

	public Kody addKody(Kody kody) {
		getKodies().add(kody);
		kody.setUser(this);

		return kody;
	}

	public Kody removeKody(Kody kody) {
		getKodies().remove(kody);
		kody.setUser(null);

		return kody;
	}

	public List<Ulubione> getUlubiones() {
		return this.ulubiones;
	}

	public void setUlubiones(List<Ulubione> ulubiones) {
		this.ulubiones = ulubiones;
	}

	public Ulubione addUlubione(Ulubione ulubione) {
		getUlubiones().add(ulubione);
		ulubione.setUser(this);

		return ulubione;
	}

	public Ulubione removeUlubione(Ulubione ulubione) {
		getUlubiones().remove(ulubione);
		ulubione.setUser(null);

		return ulubione;
	}

}