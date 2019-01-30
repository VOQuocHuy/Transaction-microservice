package fr.dauphine.miageif.msa.exemple;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Transaction {

	@Id 
    @GeneratedValue
    private Long id;
    @Column(name="IBANdest")
    private String ibansour;      
    @Column(name="IBANsour")
    private String ibandest; 
    @Column(name="typeOPER")
    private String type;    
    @Column(name="montant")
    private Double montant; 
    @Column(name="date")
    @JsonFormat(pattern = "YYYY-MM-dd")
    private Date date;    
    
    public Transaction() {}

    public Transaction(Long id, String ibansour, String ibandest, String type, Double montant, Date date) {
        this.id = id;
        this.ibansour = ibansour;
        this.ibandest = ibandest; 
        this.type = type;
        this.montant = montant;
        this.date = date;
    }
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
        
    
    public String getIbansour() {
    	return ibansour;
    }
    
    public void setIbansour(String ibansour) {
    	this.ibansour = ibansour;
    }
    
    public String getIbandest() {
    	return ibandest;
    }
    
    public void setIbandest(String ibandest) {
    	this.ibandest = ibandest;
    }
    
    public String gettype() {
    	return type;
    }
    
    public void settype(String type) {
    	this.type = type;
    }
    
    public Double getMontant() {
    	return montant;
    }
    public void setMontant(Double montant) {
    	this.montant = montant;
    }     
  
    public Date getDate() {
    	return date;
    }
    public void setDate(Date date) {
    	this.date = date;
    } 

}