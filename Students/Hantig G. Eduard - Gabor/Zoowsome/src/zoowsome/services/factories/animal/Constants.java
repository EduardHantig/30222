package zoowsome.services.factories.animal;


public final class Constants {
	public static final class Numbers {
		public static final int NR_OF_CARETAKERS = 15;
		public static final int NR_OF_ANIMALS = 18;
		public static final int MAX_SALARY = 10000;
		public static final int MAX_WORKING_HOURS = 10;
	}

	public static final class TypeOfEmployees {
		public static final String CARETAKER = "Caretaker";
	}
	
	public static final class Employee {
		
		public static final class Caretakers {
			public static final String TCO_SUCCESS = "Succes";
			public static final String TCO_KILLED = "Killed";
			public static final String TCO_NO_TIME = "No_time";
			public static final String NAME[] = {"Eduard","Raluca", "Matei", "Alexandru", "Luiza", 
												 "Mihai", "Cosmin", "Francisc", "Mădălina", "Daniela", 
												 "Petrică", "Oana", "Victor", "Marius", "Loredana"};
		}
	}
	
	public static final class Species {
		public static final String MAMMAL = "Mammal";
		public static final String REPTILE = "Reptile";
		public static final String BIRD = "Bird";
		public static final String AQUATIC = "Aquatic";
		public static final String INSECT = "Insect";
	}
	
	
	public static final class Animals {
		
		public static final class Mammal {
			public static final String TIGER = "Tiger";
			public static final String MONKEY = "Monkey";
			public static final String COW = "Cow";
		}
		
		public static final class Reptile {
			public static final String LIZZARD = "Lizzard";
			public static final String SNAKE = "Snake";
			public static final String ALLIGATOR = "Alligator";
		}
		
		public static final class Insect {
			public static final String BUTTERFLY = "Butterfly";
			public static final String SPIDER = "Spider";
			public static final String COCKROACH = "Cockroach";
		}
		
		public static final class Bird {
			public static final String COLIBRI = "Colibri";
			public static final String OSTRICH = "Ostrich";
			public static final String SWAN = "Swan";
		}
		
		public static final class Aquatic {
			public static final String WHALE = "Whale";
			public static final String SHARK = "Shark";
			public static final String FROG = "Frog";
		}
	}
	public static final class XML_TAGS {
		public static final String DISCRIMINANT = "Discriminant";
		public static final String ANIMAL = "Animal";
	}
}
