package ARL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ARL.beans.Animals;
import ARL.repository.AnimalsRepository;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

@Controller
public class AnimalsWebController {
	
	@Autowired
	AnimalsRepository animalRepo;
	
	@GetMapping("view-animal-list-arl")
	public String ViewAnimalList(Model model) {
		
		if (animalRepo.findAll().isEmpty()) {
			return NoAnimalsARL();
		}
		
		model.addAttribute("animals", animalRepo.findAll());
		return "view-animal-list-arl";
	}
	
	@GetMapping("/enter-an-animal")
	public String EnterAnAnimal(Model model) {
		Animals newAn = new Animals();
		model.addAttribute("animals", newAn);
		return "enter-an-animal";
	}
	
	@PostMapping("/enter-an-animal")
	public String EnterAnAnimal(@ModelAttribute Animals a, Model model) {
		animalRepo.save(a);
		return ViewAnimalList(model);
	}
	
	@GetMapping("/edit/{id}")
	public String EditAnimals(@PathVariable("id")long id, Model model) {
		Animals a = animalRepo.findById(id).orElse(null);
		model.addAttribute("animals", a);
		return "enter-an-animal";
	}
	
	@PostMapping("/update/{id}")
	public String ReviseAnimals(Animals a, Model model) {
		animalRepo.save(a);
		return ViewAnimalList(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteAnimals(@PathVariable("id") long id, Model model) {
		Animals a = animalRepo.findById(id).orElse(null);
		animalRepo.delete(a);
		return ViewAnimalList(model);
	}
	
	@GetMapping("/no-animals-arl")
	public String NoAnimalsARL() {
		return "no-animals-arl";
	}
	
	@GetMapping("/view-adoptee-application-list")
	public String ViewAdopteeApps() {
		return "view-adoptee-application-list";
	}

}
