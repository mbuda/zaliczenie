package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Firma;

@Stateless
public class FirmaManager {

        @PersistenceContext
        EntityManager em;
        
        public void addFirma(Firma firma){
                firma.setId(null);
                em.persist(firma);
        }
        
        @SuppressWarnings("unchecked")
		public List<Firma> getAllFirmy(){
                return em.createNamedQuery("firma.getFirmy").getResultList();
        }
}