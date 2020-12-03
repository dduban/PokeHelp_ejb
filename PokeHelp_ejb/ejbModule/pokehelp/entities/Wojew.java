package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wojew database table.
 * 
 */
@Entity
@NamedQuery(name="Wojew.findAll", query="SELECT w FROM Wojew w")
public class Wojew implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idwoj;

	private String nazwa;

	//bi-directional many-to-one association to Kody
	@OneToMany(mappedBy="wojewBean")
	private List<Kody> kodies;

	public Wojew() {
	}

	public int getIdwoj() {
		return this.idwoj;
	}

	public void setIdwoj(int idwoj) {
		this.idwoj = idwoj;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<Kody> getKodies() {
		return this.kodies;
	}

	public void setKodies(List<Kody> kodies) {
		this.kodies = kodies;
	}

	public Kody addKody(Kody kody) {
		getKodies().add(kody);
		kody.setWojewBean(this);

		return kody;
	}

	public Kody removeKody(Kody kody) {
		getKodies().remove(kody);
		kody.setWojewBean(null);

		return kody;
	}

}