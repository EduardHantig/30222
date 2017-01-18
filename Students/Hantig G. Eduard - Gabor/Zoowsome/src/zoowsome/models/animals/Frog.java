package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Frog extends Aquatic {

	public Frog(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(4);
		setName("Frog");
		super.setWatertype(watertype.Freshwater);
		super.setAvgSwimDepth(0);
	} 
	
	public Frog() {
		this(4, "Frog", watertype.Freshwater, 0, 0.01, 0);
	}
	
	public Frog(int nrOfLegs, String name, watertype type, int avgSwimDepth, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setWatertype(type);
		super.setAvgSwimDepth(avgSwimDepth);
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Aquatic.FROG);
	}
}
