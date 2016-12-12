package zoowsome.services.factories.animal;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Butterfly;
import zoowsome.models.animals.Cockroach;
import zoowsome.models.animals.Spider;


public class InsectFactory extends SpeciesFactory {

		public Animal getAnimal(String type) throws Exception{
			if (Constants.Animals.Insect.BUTTERFLY.equals(type)) {
				return new Butterfly(0.1, 0);
			} else if(Constants.Animals.Insect.COCKROACH.equals(type)) {
				return new Cockroach(0.1, 0);
			} else if(Constants.Animals.Insect.SPIDER.equals(type)) {
				return new Spider(0.7, 0.08);
			} else {
				throw new Exception("Invalid animal exception!");
			}
		}
}
