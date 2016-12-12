package zoowsome.controllers;

import zoowsome.models.animals.Animal;
import zoowsome.models.employees.Caretaker;
import zoowsome.services.factories.animal.AnimalFactory;
import zoowsome.services.factories.animal.Constants;
import zoowsome.services.factories.animal.SpeciesFactory;
import zoowsome.services.factories.employee.EmployeeFactory;
import zoowsome.services.factories.employee.TypeEmployeeFactory;

import java.util.Random;

public class MainController {
	public static void main(String[] args) throws Exception {
		
		final String constantSpecies[] = {	Constants.Species.AQUATIC, 
											Constants.Species.BIRD,
											Constants.Species.INSECT,    // Speciile de animal
											Constants.Species.MAMMAL,
											Constants.Species.REPTILE };
	
		final String constantAnimals[][] = {
			{ Constants.Animals.Aquatic.FROG, Constants.Animals.Aquatic.SHARK, Constants.Animals.Aquatic.WHALE },
			{ Constants.Animals.Bird.COLIBRI, Constants.Animals.Bird.OSTRICH, Constants.Animals.Bird.SWAN },
			{ Constants.Animals.Insect.BUTTERFLY, Constants.Animals.Insect.COCKROACH, Constants.Animals.Insect.SPIDER },
			{ Constants.Animals.Mammal.COW, Constants.Animals.Mammal.MONKEY, Constants.Animals.Mammal.TIGER },
			{ Constants.Animals.Reptile.ALLIGATOR, Constants.Animals.Reptile.LIZZARD, Constants.Animals.Reptile.SNAKE }
		};

		// Tipurile de animal
		
		AnimalFactory animalFactory = new AnimalFactory();		// Crearea fabricii de animale
		Random random = new Random();		// Pentru Randomizarea speciilor si tipurilor de animale.
		Animal animal[] = new Animal[Constants.Numbers.NR_OF_ANIMALS];	
	
		for(int i = 0; i < Constants.Numbers.NR_OF_ANIMALS; i++) {
			int index = random.nextInt(constantSpecies.length);
			SpeciesFactory animalspeciesFactory = animalFactory.getSpeciesFactory(constantSpecies[index]);
			animal[i] = animalspeciesFactory.getAnimal(constantAnimals[index][random.nextInt(constantAnimals[index].length)]);
		}
		
		// Afisarea celor 50 de animale create
		for(int i = 0; i< Constants.Numbers.NR_OF_ANIMALS; i++) {
			System.out.printf("Animal nr %d: %s\n", i+1, animal[i].getName()); 
		}		
		
		Caretaker caretaker[] = new Caretaker[Constants.Numbers.NR_OF_CARETAKERS];
		EmployeeFactory employeeFactory = new EmployeeFactory();
		TypeEmployeeFactory typeEmployeeFactory = employeeFactory.getTypeEmployeeFactory(Constants.TypeOfEmployees.CARETAKER);
		
		for (int i = 0; i < Constants.Numbers.NR_OF_CARETAKERS; i++) {
			caretaker[i] = (Caretaker) typeEmployeeFactory.getEmployeeFactory(Constants.TypeOfEmployees.CARETAKER);
		}
		
		System.out.println();
		System.out.println("The Caretakers are: ");
		for(Caretaker thisCaretaker : caretaker) {
				System.out.println(thisCaretaker.getName());
		}
		
		for (Caretaker thisCaretaker : caretaker) {
			for (Animal thisAnimal : animal) {
				if (!thisCaretaker.isDead() && !thisAnimal.isTakenCareOf()) {
					String result = thisCaretaker.takeCareOf(thisAnimal);
					if (result.equals(Constants.Employee.Caretakers.TCO_KILLED)) {
						thisCaretaker.setDead(true);
					}
					else if (result.equals(Constants.Employee.Caretakers.TCO_NO_TIME)) {
					}
					else {
						thisAnimal.setTakenCareOf(true);
					}
				}
			}
		}
		System.out.println();
		System.out.println("Animals that has been taken care of:");
		for (int i = 0; i< Constants.Numbers.NR_OF_ANIMALS; i++) {
			if (animal[i].isTakenCareOf()) {
			System.out.println("Animal nr " + (i+1) + " " + animal[i].getName()); 
			}
		}		
		System.out.println();
		System.out.println("Animals that has NOT been taken care of:");
		for (int i = 0; i< Constants.Numbers.NR_OF_ANIMALS; i++) {
			if (!animal[i].isTakenCareOf()) {
			System.out.println("Animal nr " + (i+1) + " " + animal[i].getName()); 
			}
		}		
		System.out.println();
		System.out.println("Caretakers alive: ");
		for(Caretaker thisCaretaker : caretaker) {
			if (!thisCaretaker.isDead()) {
			System.out.println(thisCaretaker.getName());
			}
	}
			
	}
}

