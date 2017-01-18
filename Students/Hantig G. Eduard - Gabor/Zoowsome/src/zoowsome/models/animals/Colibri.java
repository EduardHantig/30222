package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Colibri extends Bird {

	public Colibri(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(2);
		setName("Colibri");
		super.setMigrates(false);
		super.setAvgFlightAltitude(15);
	}
	public Colibri() {
		this(2, "Colibri", false, 15, 0.10, 0);
	}
	public Colibri(int nrOfLegs, String name, boolean migrates, int avgFlightAltitude, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setMigrates(migrates);
		super.setAvgFlightAltitude(avgFlightAltitude);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Bird.COLIBRI);
	}
}