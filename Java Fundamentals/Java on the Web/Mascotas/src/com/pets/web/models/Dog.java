package com.pets.web.models;

public class Dog extends Animal implements Pet{
	public Dog(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		if(this.getWeight()<=2) {
			return (this.getName()+" salta a tus brazos y te lame la cara.");
		} else if((this.getWeight()>2 && this.getWeight()< 8)){
			return (this.getName()+" corre alrededor de tus piernas, agitando su cola.");
		} else {
			return (this.getName()+" este recostado en el suelo y te mira con la lengua hacia afuera.");
		}
	}
}
