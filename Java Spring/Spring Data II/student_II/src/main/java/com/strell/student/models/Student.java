package com.strell.student.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="student")
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=2)
    private String firstName;
	@Size(min=2)
    private String lastName;
	@Min(12)
    private Integer age;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Contact contact;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;
    
    public Student() {
        
    }
    public Student(String nombre, String apellido, Integer edad) {
        this.firstName = nombre;
        this.lastName = apellido;
        this.age = edad;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String nombre) {
		this.firstName = nombre;
	}
	public String getLastName() {
		return lastName;
	}

	public void setlastName(String apellido) {
		this.lastName = apellido;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer edad) {
		this.age = edad;
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
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact b) {
		this.contact = b;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room a) {
		this.room = a;
	}
}
