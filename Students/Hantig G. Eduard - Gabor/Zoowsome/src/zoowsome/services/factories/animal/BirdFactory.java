package zoowsome.services.factories.animal;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Colibri;
import zoowsome.models.animals.Ostrich;
import zoowsome.models.animals.Swan;


public class BirdFactory extends SpeciesFactory {

		public Animal getAnimal(String type) throws Exception{
			if (Constants.Animals.Bird.COLIBRI.equals(type)) {
				return new Colibri(0.2, 0);
			} else if(Constants.Animals.Bird.OSTRICH.equals(type)) {
				return new Ostrich(2.4, 0.03);
			} else if(Constants.Animals.Bird.SWAN.equals(type)) {
				return new Swan(1.2, 0);
			} else {
				throw new Exception("Invalid animal exception!");
			}
		}
}
