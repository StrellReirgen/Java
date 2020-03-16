package com.pets.web.models;

public class Animal{
	private String name;
	private String breed;
	private double weight;
	
	public Animal(String nombre, String raza, double peso) {
		setName(nombre);
		setBreed(raza);
		setWeight(peso);
	}
	
	private void setName(String nombre) {
		this.name = nombre;
	}
	private void setBreed(String raza) {
		this.breed = raza;
	}
	private void setWeight(double peso) {
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
