package com.strell.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=2, message="El título debe contener minimo 2 letras.")
    private String title;
	@Size(min=2, message="El artista debe contener minimo 2 letras.")
    private String artist;
    @Size(min = 3, message="La URL debe tener minimo 3 letras")
    private String url;
    @Min(1)
	@Max(10)
    private Integer rating;
    // Esto no permitirá que el campo createdAt sea modificado después de su creación.
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Song() {
    }
    
    public Song(String titulo, String artista, String ruta,Integer valor) {
        this.title = titulo;
        this.artist = artista;
        this.url = ruta;
        this.rating = valor;
       
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String nombre) {
		this.title = nombre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String creador) {
		this.artist = creador;
	}
	public String getUrl() {
		return url;
	}

	public void setUrl(String ruta) {
		this.url = ruta;
	}
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer valor) {
		this.rating = valor;
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
