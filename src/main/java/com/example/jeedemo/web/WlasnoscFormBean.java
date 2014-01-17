package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.domain.Komputer;
import com.example.jeedemo.service.KomputerManager;
import com.example.jeedemo.service.WlasnoscManager;

@SessionScoped
@Named("wlasnoscBean")
public class WlasnoscFormBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Wlasciciel wlasciciel = new Wlasciciel();
	private ListDataModel<Wlasciciel> wlasciciele = new ListDataModel<Wlasciciel>();
	private Long wlascicielId;
	@Inject
	private WlasnoscManager wm;

	@Inject
	private KomputerManager km;
	private Long komputerId;
	
	
	public String addWlasciciel() {
		wm.addWlasciciel(wlasciciel);
		return null;
	}
	
	public Wlasciciel getWlasciciel(){
		return wlasciciel;
	}
	
	public void setWlasciciel(Wlasciciel wlasciciel){
		this.wlasciciel=wlasciciel;
	}
	public Long getWlascicielId() {
		return wlascicielId;
	}
	public void setWlascicielId(Long wlascicielId) {
		this.wlascicielId = wlascicielId;
	}
	public Long getKomputerId() {
		return komputerId;
	}
	public void setKomputerId(Long komputerId) {
		this.komputerId = komputerId;
	}

	public List<Wlasciciel> getAvailableWlasciciele() {
		return wm.getAvailableWlasciciele();
	}

	public List<Komputer> getAllKomputers() {
		return km.getAllKomputers();
	}

	public String uwlaszcz() {
		wm.uwlaszcz(komputerId, wlascicielId);
		return null;
	}
	
	public ListDataModel<Wlasciciel> getAllWlasciciele(){
		wlasciciele.setWrappedData(wm.getAllWlasciciele());
		return wlasciciele;
	}
}

