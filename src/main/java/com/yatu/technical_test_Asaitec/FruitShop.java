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
		System.out.println("Enter product and prices");
		//First line is file description
		scan.nextLine();
		boolean isCorrect = true;
		Fruit fruit = new Fruit();
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
				if(name.equals("Orange")) {
					fruit = new Orange(price);
				}
				if(name.equals("Apple")) {
					fruit = new Apple(price);
				}
				if(name.equals("Pear")) {
					fruit = new Pear(price);
				}
				fruits.add(fruit);
//				System.out.println("Fruit:" + fruit.getName());
			}else {
				isCorrect = false;
				break;
			}
		}
		
		if(!isCorrect) {
			System.out.println("\nInput is NOT correct");
		}
		
		System.out.println("Enter product and prices");
		//First line is file description
		scan.nextLine();
		float totalPrice = 0.0f;
		List<Fruit> fruitsPurchased = new ArrayList<Fruit>();
		
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();

			if(line.isEmpty()) {
				break;
			}
			//System.out.println(line);
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
				if(name.equals("Orange")) {
					fruit = new Orange();
				}
				if(name.equals("Apple")) {
					fruit = new Apple();
				}
				if(name.equals("Pear")) {
					fruit = new Pear();
				}
				fruitsPurchased.add(fruit);
				
//				System.out.println("Fruit:" + fruit.getName());
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
		System.out.println("\nList of purchased fruits");
		for(Fruit a : fruitsPurchased) {
			System.out.println(a.getName());
		}
		// Ends output

		//Closing scanner
		scan.close();
	}

}
