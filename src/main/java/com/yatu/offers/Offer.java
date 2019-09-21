package com.yatu.offers;

import com.yatu.products.Fruit;

public class Offer {
	// Fruit which offer applies
	Fruit fruit;
	//Offer text
	String text;

	public Offer() {
		
	}
	public Offer(Fruit fruit, String text) {
		this.fruit = fruit;
		this.text = text;
	}
	public Fruit getFruit() {
		return fruit;
	}
	public void setFruit(Fruit fruit) {
		this.fruit = fruit;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
