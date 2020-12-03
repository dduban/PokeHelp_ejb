package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idevent;

	private byte aktywny;

	@Temporal(TemporalType.DATE)
	@Column(name="do")
	private Date do_;

	private String nazwa;

	@Temporal(TemporalType.DATE)
	private Date od;

	//bi-directional many-to-one association to Pokinaevencie
	@OneToMany(mappedBy="event")
	private List<Pokinaevencie> pokinaevencies;

	public Event() {
	}

	public int getIdevent() {
		return this.idevent;
	}

	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}

	public byte getAktywny() {
		return this.aktywny;
	}

	public void setAktywny(byte aktywny) {
		this.aktywny = aktywny;
	}

	public Date getDo_() {
		return this.do_;
	}

	public void setDo_(Date do_) {
		this.do_ = do_;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Date getOd() {
		return this.od;
	}

	public void setOd(Date od) {
		this.od = od;
	}

	public List<Pokinaevencie> getPokinaevencies() {
		return this.pokinaevencies;
	}

	public void setPokinaevencies(List<Pokinaevencie> pokinaevencies) {
		this.pokinaevencies = pokinaevencies;
	}

	public Pokinaevencie addPokinaevency(Pokinaevencie pokinaevency) {
		getPokinaevencies().add(pokinaevency);
		pokinaevency.setEvent(this);

		return pokinaevency;
	}

	public Pokinaevencie removePokinaevency(Pokinaevencie pokinaevency) {
		getPokinaevencies().remove(pokinaevency);
		pokinaevency.setEvent(null);

		return pokinaevency;
	}

}