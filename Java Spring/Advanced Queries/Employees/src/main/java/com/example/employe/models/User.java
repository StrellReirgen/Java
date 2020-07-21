package com.example.employe.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstName;
	    private String lastName;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    @OneToMany(mappedBy="boss",fetch = FetchType.LAZY)
	    private List<User> employee;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="boss_id")
	    private User boss;
	   
	    public User() {
		}
	    
	    public User(String nombre, String apellido) {
	    	this.firstName = nombre;
	    	this.lastName = apellido;
		}
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    public List<User> getEmployee() {
	        return employee;
	    }
	    public void setEmployee(List<User> empleado) {
	        this.employee = empleado;
	    }
	    public User getBoss() {
	        return boss;
	    }
	    public void setBoss(User jefe) {
	        this.boss = jefe;
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
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
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
}
