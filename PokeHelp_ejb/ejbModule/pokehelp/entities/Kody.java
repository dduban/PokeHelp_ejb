package pokehelp.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the kody database table.
 * 
 */
@Entity
@NamedQuery(name="Kody.findAll", query="SELECT k FROM Kody k")
public class Kody implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private KodyPK id;

	private int kod;

	private int lvl;

	private String nickname;

	private String team;

	@ManyToOne
	@JoinColumn(name="user_iduser", insertable=false, updatable=false)
	private User user;

	@ManyToOne
	@JoinColumn(name="wojew")
	private Wojew wojewBean;

	public Kody() {
	}
	
	public Kody(KodyPK id, int kod, int lvl, String nickname, String team, Wojew wojewBean) {
        this.id = id;
        this.kod = kod;
        this.lvl = lvl;
        this.nickname = nickname;
        this.team = team;
        this.wojewBean = wojewBean;
    }

	public KodyPK getId() {
		return this.id;
	}

	public void setId(KodyPK id) {
		this.id = id;
	}

	public int getKod() {
		return this.kod;
	}

	public void setKod(int kod) {
		this.kod = kod;
	}

	public int getLvl() {
		return this.lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTeam() {
		return this.team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Wojew getWojewBean() {
		return this.wojewBean;
	}

	public void setWojewBean(Wojew wojewBean) {
		this.wojewBean = wojewBean;
	}

}