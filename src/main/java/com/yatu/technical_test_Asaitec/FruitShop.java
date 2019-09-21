package com.yatu.technical_test_Asaitec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.yatu.products.Apple;
import com.yatu.products.Fruit;
import com.yatu.products.Orange;
import com.yatu.products.Pear;

public class FruitShop {

	public static void main(String[] args) {
		
		// Starts input
		Scanner scan = new Scanner(System.in);
		
		// Product and price
		System.out.println("Enter product and price: ");
		//First line is file description
		scan.nextLine();
		boolean isCorrect = true;
		List<Fruit> fruits = new ArrayList<Fruit>();
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();

			if(line.isEmpty()) {
				break;
			}
			//System.out.println(line);
			Pattern pattern = Pattern.compile("([\\w]+)([,\\s]*)([+-]?\\d*\\.?\\d*)");
			Matcher matcher = pattern.matcher(line);
			
			if(matcher.matches()) {
				String name = matcher.group(1);
				float price = Float.valueOf(matcher.group(3));
				Fruit fruit = null;
				
				switch(name) {
				case "Orange":
					fruit = new Orange(price);
					break;
				case "Apple":
					fruit = new Apple(price);
					break;
				case "Pear":
					fruit = new Pear(price);
					break;
				}
				fruits.add(fruit);
			}else {
				isCorrect = false;
				break;
			}
		}
		
		if(!isCorrect) {
			System.out.println("\nInput is NOT correct");
		}
		
		// Product and quantity
		System.out.println("Enter purchase: ");
		//First line is file description
		scan.nextLine();
		float totalPrice = 0.0f;
		List<Fruit> fruitsPurchased = new ArrayList<Fruit>();
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();

			if(line.isEmpty()) {
				break;
			}
			Pattern pattern = Pattern.compile("([\\w]+)([,\\s]*)(\\d*)");
			Matcher matcher = pattern.matcher(line);
			
			if(matcher.matches()) {
				String name = matcher.group(1);
				int quantity = Integer.valueOf(matcher.group(3));
				
				for(Fruit a : fruits) {
					if(a.getName().equals(name)) {
						totalPrice += quantity*a.getPrice();
					}
				}
				
				Fruit fruit = null;
				switch(name) {
				case "Orange":
					fruit = new Orange();
					break;
				case "Apple":
					fruit = new Apple();
					break;
				case "Pear":
					fruit = new Pear();
					break;
				}
				fruitsPurchased.add(fruit);
				
			}else {
				isCorrect = false;
				break;
			}
		}
		// Ends input

		if(!isCorrect) {
			System.out.println("\nInput is NOT correct");
		}
		
		// Starts output
		//Total price
		System.out.println("\nTotal price: " + totalPrice);
		
		//List of purchased
		System.out.println("\nList of products purchased");
		for(Fruit a : fruitsPurchased) {
			System.out.println(a.getName());
		}
		// Ends output

		//Closing scanner
		scan.close();
	}

}
