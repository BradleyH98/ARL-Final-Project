package ARL.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Bradh 
 * CIS175 23290 Java II Spring 2023
 * Apr 2, 2023
 */

/*The way this class is built is to show off the animal before giving the ARL contact info*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animals {
	
	@Id
	@GeneratedValue
	private int id;
	private int ArlId;
	private String animalName;
	private String animalType; // dog, cat, so on.
	private String breed;
	private String aproxAge;
	private double weight;
	private String description; // A string property to describe the personality of the animal. Good around kids, needs a large space to be happy, scared of other animals, so on.
	@Autowired
	private ContactInfo contact;
}
