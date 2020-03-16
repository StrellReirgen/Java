package com.pets.web.models;

public class Cat extends Animal implements Pet{
	public Cat(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		if(this.getWeight()<=2) {
			return (this.getName()+" salta y juega persiguiendo una mosca.");
		} else if((this.getWeight()>2 && this.getWeight()< 6)){
			return (this.getName()+" te mira curiosamente y maulla.");
		} else {
			return (this.getName()+" duerme en el suelo profundamente con su barriga arriba.");
		}
	}

}
