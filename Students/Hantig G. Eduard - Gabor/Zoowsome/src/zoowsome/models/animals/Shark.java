package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Shark extends Aquatic {

	public Shark(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Shark");
		super.setWatertype(watertype.Saltwater);
		super.setAvgSwimDepth(500);
	}
	
	public Shark() {
		this(0, "Shark", watertype.Saltwater, 500, 0.01, 0);
	}
	
	public Shark(int nrOfLegs, String name, watertype type, int avgSwimDepth, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setWatertype(type);
		super.setAvgSwimDepth(avgSwimDepth);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatic.SHARK);
	}
}
