package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Cockroach extends Insect {

	public Cockroach(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(6);
		setName("Cockroach");
		super.setCanFly(false);
		super.setDangerous(false);
	}
	
	public Cockroach() {
		this(6, "Cockroach", false, false, 0.01, 0);
	}
	
	public Cockroach(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setCanFly(canFly);
		super.setDangerous(isDangerous);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insect.COCKROACH);
	}
}