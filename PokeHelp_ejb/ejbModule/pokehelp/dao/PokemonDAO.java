package pokehelp.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import pokehelp.entities.Pokemon;

@Stateless
public class PokemonDAO {
	@PersistenceContext
	EntityManager em;
	
	public void create(Pokemon pokemon) {
		em.persist(pokemon);
	}
	
	public Pokemon merge(Pokemon pokemon) {
		return em.merge(pokemon);
	}
	
	public void remove(Pokemon pokemon) {
		em.remove(em.merge(pokemon));
	}
	
	public Pokemon find(Object id) {
		return em.find(Pokemon.class, id);
	}
	
	
	
	
	public List<Pokemon> getFullList() {
		List<Pokemon> list = null;

		Query query = em.createQuery("SELECT pokemon.*, typ.nazwa AS typ_nazwa, webo.Nazwa AS webo_nazwa FROM pokemon LEFT JOIN typ ON pokemon.typ = typ.idTyp LEFT JOIN webo ON pokemon.webo = webo.idWebo;");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	
	
	public List<Pokemon> getFilteredPokemons(Map<String, Object> filteredPokemons) {
		List<Pokemon> list = null;

		// 1. Build query string with parameters
		String select = "SELECT p ";
		String from = "FROM Pokemon p LEFT JOIN Typ t ON p.typBean = t.idTyp LEFT JOIN Webo w ON p.weboBean = w.idWebo";
		String where = "";
		String orderby = "";

		// search for surname
		String nazwa = (String) filteredPokemons.get("nazwa");
		if (nazwa != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.nazwa like :nazwa ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where);

		// 3. Set configured parameters
		if (nazwa != null) {
			query.setParameter("nazwa", nazwa+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	

	
	
	
}
