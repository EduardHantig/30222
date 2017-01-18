package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Monkey extends Mammal {

	public Monkey(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(4);
		setName("Monkey");
		super.setNormalBodyTemp((float)37);
		super.setPercBodyHair(79);
	}
	
	public Monkey() {
		this(4, "Monkey", (float)37, 79, 0.17, 0.02);
	}
	
	public Monkey(int nrOfLegs, String name, float normalBodyTemp, int percBodyHair, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setNormalBodyTemp(normalBodyTemp);
		super.setPercBodyHair(percBodyHair);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammal.MONKEY);
	}
	
}