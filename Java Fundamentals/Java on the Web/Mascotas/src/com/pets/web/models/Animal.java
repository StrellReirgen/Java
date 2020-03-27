package com.pets.web.models;

public class Animal implements java.io.Serializable{
	private String name;
	private String breed;
	private double weight;
	
	public Animal() {
		
	}
	
	public Animal(String nombre, String raza, double peso) {
		setName(nombre);
		setBreed(raza);
		setWeight(peso);
	}
	
	public void setName(String nombre) {
		this.name = nombre;
	}
	public void setBreed(String raza) {
		this.breed = raza;
	}
	public void setWeight(double peso) {
		this.weight = peso;
	}
	public String getName() {
		return this.name;
	}
	public String getBreed() {
		return this.breed;
	}
	public double getWeight() {
		return this.weight;
	}
}
