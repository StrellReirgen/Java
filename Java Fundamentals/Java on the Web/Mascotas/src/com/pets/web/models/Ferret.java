package com.pets.web.models;

public class Ferret extends Animal implements Pet{
	public Ferret(String name, String breed, double weight) {
		super(name, breed, weight);
	}
	
	public String showAffection() {
		if(this.getWeight()<=2) {
			return (this.getName()+" se esconde debajo de tu cama y muerde tus zapatillas.");
		} else if((this.getWeight()>2 && this.getWeight()< 8)){
			return (this.getName()+" corre por el pasillo y luego se tira a descansar.");
		} else {
			return (this.getName()+" duerme tranquilamente en tu cama.");
		}
	}
}
