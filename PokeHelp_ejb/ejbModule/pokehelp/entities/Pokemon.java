package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pokemons database table.
 * 
 */
@Entity
@Table(name="pokemons")
@NamedQuery(name="Pokemon.findAll", query="SELECT p FROM Pokemon p")
public class Pokemon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpokemons;

	private int maxcp;

	private String nazwa;

	private String region;

	private byte widoczny;

	//bi-directional many-to-one association to Webo
	@ManyToOne
	@JoinColumn(name="webo")
	private Webo weboBean;

	//bi-directional many-to-one association to Typ
	@ManyToOne
	@JoinColumn(name="typ")
	private Typ typBean;

	//bi-directional many-to-one association to Pokinaevencie
	@OneToMany(mappedBy="pokemon")
	private List<Pokinaevencie> pokinaevencies;

	//bi-directional many-to-one association to Ulubione
	@OneToMany(mappedBy="pokemon")
	private List<Ulubione> ulubiones;

	public Pokemon() {
	}

	public int getIdpokemons() {
		return this.idpokemons;
	}

	public void setIdpokemons(int idpokemons) {
		this.idpokemons = idpokemons;
	}

	public int getMaxcp() {
		return this.maxcp;
	}

	public void setMaxcp(int maxcp) {
		this.maxcp = maxcp;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public byte getWidoczny() {
		return this.widoczny;
	}

	public void setWidoczny(byte widoczny) {
		this.widoczny = widoczny;
	}

	public Webo getWeboBean() {
		return this.weboBean;
	}

	public void setWeboBean(Webo weboBean) {
		this.weboBean = weboBean;
	}

	public Typ getTypBean() {
		return this.typBean;
	}

	public void setTypBean(Typ typBean) {
		this.typBean = typBean;
	}

	public List<Pokinaevencie> getPokinaevencies() {
		return this.pokinaevencies;
	}

	public void setPokinaevencies(List<Pokinaevencie> pokinaevencies) {
		this.pokinaevencies = pokinaevencies;
	}

	public Pokinaevencie addPokinaevency(Pokinaevencie pokinaevency) {
		getPokinaevencies().add(pokinaevency);
		pokinaevency.setPokemon(this);

		return pokinaevency;
	}

	public Pokinaevencie removePokinaevency(Pokinaevencie pokinaevency) {
		getPokinaevencies().remove(pokinaevency);
		pokinaevency.setPokemon(null);

		return pokinaevency;
	}

	public List<Ulubione> getUlubiones() {
		return this.ulubiones;
	}

	public void setUlubiones(List<Ulubione> ulubiones) {
		this.ulubiones = ulubiones;
	}

	public Ulubione addUlubione(Ulubione ulubione) {
		getUlubiones().add(ulubione);
		ulubione.setPokemon(this);

		return ulubione;
	}

	public Ulubione removeUlubione(Ulubione ulubione) {
		getUlubiones().remove(ulubione);
		ulubione.setPokemon(null);

		return ulubione;
	}

}