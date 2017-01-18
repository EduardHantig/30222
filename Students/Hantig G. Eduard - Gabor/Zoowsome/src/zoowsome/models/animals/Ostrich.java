package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Ostrich extends Bird {

	public Ostrich(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(2);
		setName("Ostrich");
		super.setMigrates(false);
		super.setAvgFlightAltitude(0);
	}
	
	public Ostrich() {
		this(2, "Ostrich", false, 0, 0.15, 0.10);
	}
	
	public Ostrich(int nrOfLegs, String name, boolean migrates, int avgFlightAltitude, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setMigrates(migrates);
		super.setAvgFlightAltitude(avgFlightAltitude);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Bird.OSTRICH);
	}
}