package com.project2.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project2.Entity.Buyer;

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
		model.addAttribute("selVeh", carService.selectedCar(inventoryId));
		
		
		return "details";
	}
	@GetMapping("/buyer")
	public ModelAndView buyerDetails(@RequestParam int inventoryId, Model model) {
		
		return new ModelAndView("buyer", "buyer", new Buyer(carService.selectedCar(inventoryId))); 
	}
	@PostMapping("/buyer")
	public String soldVehicle(Model model, @ModelAttribute("buyer") Buyer buyer, HttpSession session) {
		carService.saveBuyer(buyer);
		carService.clearInv();
		
		return "purchase-success";
	}
//	@GetMapping("/purchase-success")
//	public String success(Model model) {
//		model.addAttribute("buyer", carService.lastBuyer());
//		
//		return "purchase-success";
//	}
	
}
