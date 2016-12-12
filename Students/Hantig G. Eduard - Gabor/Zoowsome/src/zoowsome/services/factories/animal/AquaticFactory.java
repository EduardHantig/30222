package zoowsome.services.factories.animal;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Frog;
import zoowsome.models.animals.Shark;
import zoowsome.models.animals.Whale;


public class AquaticFactory extends SpeciesFactory {

		public Animal getAnimal(String type) throws Exception{
			if (Constants.Animals.Aquatic.FROG.equals(type)) {
				return new Frog(0.1, 0);
			} else if(Constants.Animals.Aquatic.SHARK.equals(type)) {
				return new Shark(4.8, 0.13);
			} else if(Constants.Animals.Aquatic.WHALE.equals(type)) {
				return new Whale(6.8, 0.03);
			} else {
				throw new Exception("Invalid animal exception!");
			}
		}
}
