package com.example.jeedemo.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Firma;
import com.example.jeedemo.service.FirmaManager;

@SessionScoped
@Named("firmaBean")
public class FirmaFormBean implements Serializable{
	private static final long serialVersionUID = 1L;
		private Firma firma = new Firma();
        private ListDataModel<Firma> firmy = new ListDataModel<Firma>();
        private List<SelectItem> lista = new ArrayList<SelectItem>();
        
        @Inject
        FirmaManager fm;
        
        public Firma getFirma() {
                return firma;
        }
        
        public void setFirma(Firma firma) {
                this.firma = firma;
        }
        
        public String addFirma(){
                fm.addFirma(firma);
                return null;
        }
        
        
        public List<Firma> getAllFirmy(){
                return fm.getAllFirmy();
        }

		public ListDataModel<Firma> getFirmy() {
			return firmy;
		}

		public void setFirmy(ListDataModel<Firma> firmy) {
			this.firmy = firmy;
		}

		public List<SelectItem> getLista() {
			return lista;
		}

		public void setLista(List<SelectItem> lista) {
			this.lista = lista;
		}
        
        
        
}