package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = ".all", query = "Select k from Komputer k")
})
public class Komputer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String model = "unknown";
	private double szybkosc;
	@Temporal(TemporalType.DATE)
	private Date rejestracja = new Date();
	@ManyToOne
	private Firma firma;
	@ManyToMany
	private List<Wlasciciel> wlasciciele = new ArrayList<Wlasciciel>();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2, max = 20)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public double getSzybkosc() {
		return szybkosc;
	}
	public void setSzybkosc(double szybkosc) {
		this.szybkosc = szybkosc;
	}

	@Temporal(TemporalType.DATE)
	public Date getRejestracja() {
		return rejestracja;
	}
	public void setRejestracja(Date rejestracja) {
		this.rejestracja = rejestracja;
	}
	
	public Firma getFirma() {
		return firma;
	}
	public void setFirma(Firma firma) {
		this.firma = firma;
	}
	public List<Wlasciciel> getWlasciciele() {
		return wlasciciele;
	}
	public void setWlasciciele(List<Wlasciciel> wlasciciele) {
		this.wlasciciele = wlasciciele;
	}
}
