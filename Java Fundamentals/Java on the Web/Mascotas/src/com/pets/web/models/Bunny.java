package com.pets.web.models;

public class Bunny extends Animal implements Pet{
	public Bunny(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		if(this.getWeight()<=1) {
			return (this.getName()+" se esconde timidamente debajo de un mueble.");
		} else if((this.getWeight()>1 && this.getWeight()< 6)){
			return (this.getName()+" te olfatea y pasa su barbilla en tus zapatos.");
		} else {
			return (this.getName()+" esta recostado moviendo su nariz rapidamente.");
		}
	}

}
