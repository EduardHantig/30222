package zoowsome.services.factories.animal;

import zoowsome.models.animals.Alligator;
import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Lizzard;
import zoowsome.models.animals.Snake;

public class ReptileFactory extends SpeciesFactory {

		public Animal getAnimal(String type) throws Exception{
			if (Constants.Animals.Reptile.ALLIGATOR.equals(type)) {
				return new Alligator(4.1, 0.79);
			} else if(Constants.Animals.Reptile.LIZZARD.equals(type)) {
				return new Lizzard(0.2, 0);
			} else if(Constants.Animals.Reptile.SNAKE.equals(type)) {
				return new Snake(1.7, 0.34);
			} else {
				throw new Exception("Invalid animal exception!");
			}
		}
}
