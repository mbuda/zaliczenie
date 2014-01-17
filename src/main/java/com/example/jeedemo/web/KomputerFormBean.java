package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.example.jeedemo.domain.Wlasciciel;
import com.example.jeedemo.domain.Komputer;
import com.example.jeedemo.domain.Firma;
import com.example.jeedemo.service.FirmaManager;
import com.example.jeedemo.service.KomputerManager;
import com.example.jeedemo.service.WlasnoscManager;

@SessionScoped
@Named("kompBean")
public class KomputerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Komputer komputer = new Komputer();
	private ListDataModel<Komputer> kompy = new ListDataModel<Komputer>();
	private DualListModel<Wlasciciel> tempList;
	private List<Wlasciciel> wlascicieleTemp;
	
	private Komputer kompToShow = new Komputer();
	private ListDataModel<Wlasciciel> ownedWlasciciele = new ListDataModel<Wlasciciel>();

	private Long komputerId;
	private Long firmaId;
	private Long wlascicielId;
	
	
	@Inject
	private KomputerManager km;
	
	@Inject
	private FirmaManager fm;
	
	@Inject
	private WlasnoscManager wm;

	public Komputer getKomputer() {
		return komputer;
	}
	public void setKomputer(Komputer komputer) {
		this.komputer = komputer;
	}
	
	public ListDataModel<Komputer> getAllKomputers() {
		kompy.setWrappedData(km.getAllKomputers());
		return kompy;
	}

	public ListDataModel<Wlasciciel> getOwnedWlasciciele() {
		ownedWlasciciele.setWrappedData(km.getOwnedWlasciciele(kompToShow));
		return ownedWlasciciele;
	}
	
	// Actions
	public String addKomputer() {
		km.addKomputer(komputer);
		km.addFirmaToKomputer(komputer.getId(), firmaId);
		km.addWlascicieleToKomputerList(komputer.getId(), wlascicieleTemp);
		return null;
	}
	
	public Long getKomputerId(){
		return komputerId;
	}
	
	public void setKomputerId(Long komputerId){
		this.komputerId=komputerId;
	}
	
	public Long getFirmaId(){
			return firmaId;
	}
	
	public void setFirmaId(Long firmaId){
		this.firmaId=firmaId;
	}
	
	public List<Firma> getAllFirmy(){
		return fm.getAllFirmy();
	}
	
	public List<Wlasciciel> getAllWlasciciele(){
		return wm.getAllWlasciciele();
	}
	
	public Long getWlascicielId(){
		return wlascicielId;
	}
	
	public void setWlascicielId(Long wlascicielId){
		this.wlascicielId=wlascicielId;
	}
	
	public DualListModel<Wlasciciel> getTempList() {
		return (new DualListModel<Wlasciciel>(wm.getAllWlasciciele(), new ArrayList<Wlasciciel>()));
	}
	
	public void setTempList(DualListModel<Wlasciciel> tempList) {
		this.tempList=tempList;
	}
	
	public List<Wlasciciel> getSelected(){
		return tempList.getTarget();
	}
	
	public List<Wlasciciel> getWlascicieleTemp() {
		return wlascicieleTemp;
	}
	
	public void setWlascicieleTemp(List<Wlasciciel> wlascicieleTemp) {
		this.wlascicieleTemp = wlascicieleTemp;
	}
	public String deleteKomputer() {
		Komputer kompToDelete = kompy.getRowData();
		km.deleteKomputer(kompToDelete);
		return null;
	}
	
	public String showDetails() {
		kompToShow = kompy.getRowData();
		return "details";
	}
	
	public String disposeWlasciciel(){
		Wlasciciel wlascicielToDispose = ownedWlasciciele.getRowData();
		wm.disposeWlasciciel(kompToShow, wlascicielToDispose);
		return null;
	}
}
