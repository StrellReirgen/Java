package com.strell.water.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="pools")
public class Pool {
	@Id
    @GeneratedValue
    private Long id;
	private String address;
	private String description;
	private Double cost;
	private String size;
	@OneToMany(mappedBy="pool", fetch = FetchType.LAZY)
    private List<Review> reviews;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="host_id")
    private User host;
	@Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public Pool() {
    	
    }
    
    public Pool (String a,String b, Double c, String d, List<Review> e, User f) {
    	this.address = a;
    	this.description = b;
    	this.cost = c;
    	this.size = d;
    	this.reviews = e;
    	this.host = f;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public User getHost() {
		return host;
	}
	public void setHost(User host) {
		this.host = host;
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
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
    
}
