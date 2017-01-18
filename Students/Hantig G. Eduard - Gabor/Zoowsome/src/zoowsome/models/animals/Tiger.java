package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Tiger extends Mammal {

	public Tiger(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(4);
		setName("Tiger");
		super.setNormalBodyTemp((float)37.5);
		super.setPercBodyHair(92);
	}
	
	public Tiger() {
		this(4, "Tiger", (float)37.5, 92, 0.29, 0.96);
	}
	
	public Tiger(int nrOfLegs, String name, float normalBodyTemp, int percBodyHair, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setNormalBodyTemp(normalBodyTemp);
		super.setPercBodyHair(percBodyHair);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Mammal.TIGER);
	}
}
