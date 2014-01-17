package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Firma;
import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.domain.Komputer;

@Stateless
public class KomputerManager {

	@PersistenceContext
	private EntityManager em;

	public void addKomputer(Komputer komputer) {
		komputer.setId(null);
		em.persist(komputer);
	}

	public void addFirmaToKomputer(Long komputerId, Long firmaId){
		Komputer komputer = em.find(Komputer.class, komputerId);
		Firma firma = em.find(Firma.class, firmaId);
		komputer.setFirma(firma);
	}
	
	public void addWlascicieleToKomputerList(Long komputerId, List<Wlasciciel> tempList){
		Komputer komputer = em.find(Komputer.class, komputerId);
		for(Wlasciciel w: tempList)
			komputer.getWlasciciele().add(w);
	}
	
	public void addWlascicielToKomputer(Long komputerId, List<Long> listaId){
		Komputer komputer = em.find(Komputer.class, komputerId);
		for(Long id : listaId){
			Wlasciciel wlasciciel = em.find(Wlasciciel.class, id);
			komputer.getWlasciciele().add(wlasciciel);
		}
	}
	
	public void deleteKomputer(Komputer komputer) {
		komputer = em.find(Komputer.class, komputer.getId());
		em.remove(komputer);
	}

	@SuppressWarnings("unchecked")
	public List<Komputer> getAllKomputers() {
		return em.createNamedQuery("komputer.all").getResultList();
	}

	public List<Wlasciciel> getOwnedWlasciciele(Komputer komputer) {
		komputer = em.find(Komputer.class, komputer.getId());
		// lazy loading here - try this code without this (shallow) copying
		List<Wlasciciel> wlasciciele = new ArrayList<Wlasciciel>(komputer.getWlasciciele());
		return wlasciciele;
	}
	public EntityManager getEm() {
		return em;
	}

}

	