package com.anshul.springboot.pharmacy.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anshul.springboot.pharmacy.entity.Medicine;
import com.anshul.springboot.pharmacy.service.MedicineService;


// This is our REST CONTROLLER
// The url we will use is localhost:_ _ _ _/api/..........


@Controller
//@RequestMapping()
public class MedicineRestController {

	private MedicineService medicineService;
	
	// Constructor
	@Autowired
	public MedicineRestController(MedicineService medicineService) {
		this.medicineService = medicineService;
	
	}
//*************************************************************************************

	@GetMapping("/error")
	public String HelloPage() {
		return "hello!!!";
	}
	

	
	//This is the homepage
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	
	//To get the medicine list
	@GetMapping("/medicine-list")
	public String listMedicines(Model theModel, String keyword) {
		if(keyword!=null) {
			theModel.addAttribute("medicines", medicineService.findByKeyword(keyword));

		}
		else {
		theModel.addAttribute("medicines", medicineService.findAll());
		}
		return "medicines/medicines";
	}
	
	@GetMapping("/AdditionForm")
	public String AdditionForm(Model theModel) {
		
		//for data binding
		Medicine med = new Medicine();
		theModel.addAttribute("medicines",med);
		return "medicines/additionForm";
	}
	
	@PostMapping("/save")
	public String saveMedicine(@ModelAttribute("medicines") Medicine med) {
		
		medicineService.save(med);
		
		return "redirect:/medicine-list";
	}
	
	@GetMapping("/UpdateForm")
	public String showUpdateForm(@RequestParam("medId") int theId, Model theModel) {
		
		Medicine theMed = medicineService.findById(theId);
		
		theModel.addAttribute("medicines", theMed);
		
		return "medicines/additionForm";
	}

	
	@GetMapping("/Delete")
	public String deleteMedicine(@RequestParam("medId") int theId, Model theModel) {
		
		medicineService.deleteById(theId);
		return "redirect:/medicine-list";
	}
	
	@GetMapping("/BuyMedicine")
	public String buyingMedicine(@RequestParam("medId") int theId, Model theModel) {
		
		Medicine theMed = medicineService.findById(theId);
		
		theModel.addAttribute("medicines", theMed);
		
		return "medicines/buyingForm";
	}	

	
	@RequestMapping(
			value="/BuyMedicine{medId}",
			method=RequestMethod.POST
		)
	public String buyingAndChanging(@RequestParam("medId") int theId, int keyword, Model theModel) {
		
		Medicine theMed = medicineService.findById(theId);
		theMed.setAvailable(theMed.getAvailable()-keyword);
		medicineService.save(theMed);
		return "redirect:/medicine-list";
	}	
	
	
	////////////////////////////////PRODUCTION///////////////////////////////////////////////
		
	
	//*************************************************************************************
}


