package com.strell.student.models;

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

@Entity
@Table(name="contact")
public class Contact {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
    private String city;
	@Column
    @NotNull
    private String address;
	@Column
    @NotNull
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    private Student student;
    public Contact() {  
    }
    
    public Contact(String ciudad, String direccion, String estado, Student user) {
    	this.city = ciudad;
    	this.address = direccion;
        this.state = estado;
        this.student = user;
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

	public String getCity() {
		return city;
	}

	public void setCity(String numero) {
		this.city = numero;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String numero) {
		this.address = numero;
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
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student a) {
		this.student = a;
	}
}
