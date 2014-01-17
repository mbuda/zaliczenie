package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name ="firma.getFirmy" , query = "Select f FROM Firma f ")
public class Firma {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nazwa;
        
        public Long getId() {
                return id;
        }
        
        public void setId(Long id) {
                this.id = id;
        }
        
        public String getNazwa() {
                return nazwa;
        }
        
        public void setNazwa(String nazwa) {
                this.nazwa = nazwa;
        }
        
}
