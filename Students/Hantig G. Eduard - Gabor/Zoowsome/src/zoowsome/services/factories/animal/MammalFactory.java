package zoowsome.services.factories.animal;

import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Cow;
import zoowsome.models.animals.Monkey;
import zoowsome.models.animals.Tiger;

public class MammalFactory extends SpeciesFactory {

		public Animal getAnimal(String type) throws Exception{
			if (Constants.Animals.Mammal.COW.equals(type)) {
				return new Cow(3.2, 0.01);
			} else if(Constants.Animals.Mammal.MONKEY.equals(type)) {
				return new Monkey(4.2, 0.01);
			} else if(Constants.Animals.Mammal.TIGER.equals(type)) {
				return new Tiger(4.3, 0.93);
			} else {
				throw new Exception("Invalid animal exception!");
			}
		}
}
