package com.votreentreprise.panier;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private String code;
    private String libelle;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
