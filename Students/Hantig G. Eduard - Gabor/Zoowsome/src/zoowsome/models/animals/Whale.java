package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Whale extends Aquatic {

	public Whale(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Whale");
		super.setWatertype(watertype.Saltwater);
		super.setAvgSwimDepth(1700);
	}
	
	public Whale() {
		this(0, "Whale", watertype.Saltwater, 1700, 0.51, 0.08);
	}
	
	public Whale(int nrOfLegs, String name, watertype type, int avgSwimDepth, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setWatertype(type);
		super.setAvgSwimDepth(avgSwimDepth);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatic.WHALE);
	}
}
