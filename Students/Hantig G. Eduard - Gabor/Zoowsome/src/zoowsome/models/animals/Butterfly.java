package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;
import static zoowsome.repositories.AnimalRepository.createNode;

public class Butterfly extends Insect {

	public Butterfly(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Butterfly");
		super.setCanFly(true);
		super.setDangerous(false);
	}
	
	public Butterfly() {
		this(0, "Butterfly", true, false, 0.01, 0);
	}
	
	public Butterfly(int nrOfLegs, String name, boolean canFly, boolean isDangerous, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setCanFly(canFly);
		super.setDangerous(isDangerous);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Insect.BUTTERFLY);
	}
}