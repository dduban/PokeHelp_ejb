package pokehelp.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pokehelp.entities.Event;


@Stateless
public class EventDAO {
	@PersistenceContext
	EntityManager em;
	
	public void create(Event event) {
		em.persist(event);
	}
	
	public Event merge(Event event) {
		return em.merge(event);
	}
	
	public void remove(Event event) {
		em.remove(em.merge(event));
	}
	
	public Event find(Object id) {
		return em.find(Event.class, id);
	}
}
