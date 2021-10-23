package com.project2.Controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project2.Entity.Buyer;
import com.project2.Entity.Cars;

@Service
public class CarService {
	public Cars pickedCar = new Cars();
	public ArrayList<Cars> inventory = new ArrayList<Cars>();
	public ArrayList<Buyer> buyerList = new ArrayList<Buyer>();
	public long inventoryCount = 10;
	public long buyerCount = 0;
	
	private static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	public void pupulateCars() {
		inventory.add(new Cars( true, 1, "Toyota", "Camry", 2018, "$15,000.00", "It will get you to where you need to go.", "images/ToyotaCamry.jpg", "55,000", LocalDate.of(2021, 10, 10)));
		inventory.add(new Cars( false, 2, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( true, 3, "Dodge", "Challenger", 2015, "$23,000.00", "It will go fast but can go faster.", "images/DodgeChallenger.jpeg", "58,000", LocalDate.of(2021, 10, 10)));
		inventory.add(new Cars( false, 4, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( true, 5, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( false, 6, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( false, 7, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( false, 8, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( false, 9, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
		inventory.add(new Cars( false, 10, "Chevy", "Silverado", 2020, "$35,000.00", "It will tow you away.", "images/ChevySilverado.jpeg", "20,000", LocalDate.of(2020, 10, 10)));
	}
	public Cars selectedCar(int inventoryId) {
		for(int i = 0; i < inventory.size(); i++) {
			Cars tempCar = inventory.get(i);
			if(tempCar.getInventoryId() == inventoryId) {
				pickedCar = tempCar;
				return pickedCar;
			}
		}
		return pickedCar;
	}
	public String discount(String selectedCarPrice) {
		String n = selectedCarPrice.replace("$", "");
		String n2 = n.replace(",", "");
		double amount = round((Double.parseDouble(n2) * .90), 2);
		DecimalFormat df = new DecimalFormat("#,###.00");
		String discountPrice = "$" + String.valueOf(df.format(amount));
		
		return discountPrice;
	}
	public void saveBuyer(Buyer buyer) {
		buyerList.add(buyer);
		buyerCount++;
	}
	public void clearInv() {
		int boughtCarId = buyerList.size() - 1;
		for(int i = 0; i < inventoryCount; i++) {
			if(inventory.get(i).getInventoryId() == boughtCarId) {
				inventory.remove(i);
				inventoryCount--;
			}
		}
	}
	public Buyer lastBuyer() {
		Buyer lastBuyer = buyerList.get(buyerList.size()-1);
		
		return lastBuyer;
	}

}
