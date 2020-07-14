package com.strell.driver.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String number;
	@Column
    @NotNull(message="Please enter a date.")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date expirationDate;
	@Column
    @NotNull(message="Please enter a state.")
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id", nullable=false)
    private Person person;
    public License() {  
    }
    
    public License(String numero, Date fecha, String estado, Person user) {
    	this.number = numero;
    	this.expirationDate = fecha;
        this.state = estado;
        this.person = user;
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String numero) {
		this.number = numero;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date fecha) {
		this.expirationDate = fecha;
	}
	public String getState() {
		return state;
	}

	public void setState(String estado) {
		this.state = estado;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person a) {
		this.person = a;
	}
}
