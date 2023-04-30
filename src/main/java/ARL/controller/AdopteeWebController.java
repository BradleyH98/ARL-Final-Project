package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.Adoptee;
import ARL.repository.AdopteeRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

@Controller
public class AdopteeWebController {

	@Autowired
	AdopteeRepository adRepo;
	
	@GetMapping("/create-adoptee-application")
	public String CreateApplication(Model model) {
		Adoptee a = new Adoptee();
		model.addAttribute("adoptees", a);
		return "create-adoptee-application";
	}
	
	@PostMapping("/create-adoptee-application")
	public String CreateApplication(@ModelAttribute Adoptee a, Model model) {
		adRepo.save(a);
		return ThankYou();
	}
	
	@GetMapping("/remove/{id}")
	public String deleteAnimals(@PathVariable long id, Model model) {
		Adoptee a = adRepo.findById(id).orElse(null);
		adRepo.delete(a);
		return "create-adoptee-application";
	}
	
	@GetMapping("/thank-you")
	private String ThankYou() {
		return "thank-you";
	}
}
