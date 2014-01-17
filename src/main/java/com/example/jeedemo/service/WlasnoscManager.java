package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.domain.Komputer;


/* 
 * This is a Stateless EJB Bean
 * All its methods are transactional
 */
@Stateless
public class WlasnoscManager {

	@PersistenceContext
	EntityManager em;

	
	public void addWlasciciel(Wlasciciel wlasciciel) {
		wlasciciel.setId(null);
		em.persist(wlasciciel);
	}
	
	public void uwlaszcz(Long komputerId, Long wlascicielId) {

		Komputer komputer = em.find(Komputer.class, komputerId);
		Wlasciciel wlasciciel = em.find(Wlasciciel.class, wlascicielId);
		wlasciciel.setMaKomp(true);

		komputer.getWlasciciele().add(wlasciciel);
	}

	@SuppressWarnings("unchecked")
	public List<Wlasciciel> getAvailableWlasciciele() {
		return em.createNamedQuery("wlasciciel.bezKompa").getResultList();
	}
	
	public Wlasciciel getWlascicielId(Long wlascicielId){
		return em.find(Wlasciciel.class, wlascicielId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Wlasciciel> getAllWlasciciele(){
		return em.createNamedQuery("wlasciciel.getAll").getResultList();
	}

	public void disposeWlasciciel(Komputer komputer, Wlasciciel wlasciciel) {

		komputer = em.find(Komputer.class, komputer.getId());
		wlasciciel = em.find(Wlasciciel.class, wlasciciel.getId());

		Wlasciciel toRemove = null;
		// lazy loading here (komputer.getWlasciciele)
		for (Wlasciciel aWlasciciel : komputer.getWlasciciele())
			if (aWlasciciel.getId().compareTo(wlasciciel.getId()) == 0) {
				toRemove = aWlasciciel;
				break;
			}

		if (toRemove != null)
			komputer.getWlasciciele().remove(toRemove);
		
		wlasciciel.setMaKomp(false);
	}
}

