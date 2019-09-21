package com.yatu.products;

public class Fruit {
	String name;
	float price;

	public Fruit(){
		this.name = new String();
		this.price = 0.0f;
	}
	
	public Fruit(String name, float price){
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
