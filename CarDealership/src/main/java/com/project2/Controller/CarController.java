package com.project2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {
	private int inventoryCounter = 0;
	
	
	@Autowired
	CarService carService;
	
	@GetMapping("/")
	public String welcome(Model model) {
		return "index";
	}
	
	@GetMapping("/inventory")
	public String inventory(Model model) {
		
		if(inventoryCounter == 0) {
			carService.pupulateCars();
			inventoryCounter++;
		}
		model.addAttribute("vehInv", carService.inventory);
		return "inventory";
	}
	@GetMapping("/details")
	public String carDetails(@RequestParam int inventoryId, Model model) {
		if(carService.selectedCar(inventoryId).getDaysBetween() > 120) {
			carService.selectedCar(inventoryId).setDiscountedPrice(carService.discount(carService.selectedCar(inventoryId).getPrice()));
		}
		System.out.println(carService.selectedCar(inventoryId).isUsed());
		

		model.addAttribute("selVeh", carService.selectedCar(inventoryId));
		
		
		return "details";
	}
	
}
