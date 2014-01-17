package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "wlasciciel.bezKompa", query = "Select w from Wlasciciel w where w.maKomp = false")
public class Wlasciciel {
	
	private Long id;
	private String imie;
	private Boolean maKomp = false;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}

	public Boolean getMaKomp() {
		return maKomp;
	}
	public void setMaKomp(Boolean maKomp) {
		this.maKomp = maKomp;
	}
}
