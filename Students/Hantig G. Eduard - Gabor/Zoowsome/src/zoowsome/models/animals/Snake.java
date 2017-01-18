package zoowsome.models.animals;

import static zoowsome.repositories.AnimalRepository.createNode;

import java.time.LocalTime;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import zoowsome.services.factories.animal.Constants;

public class Snake extends Reptile {

	public Snake(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(0);
		setName("Snake");
		super.setLaysEggs(true);
	}
	
	public Snake() {
		this(0, "Snake", true, 0.09, 0.45);
	}
	
	public Snake(int nrOfLegs, String name, boolean laysEggs, double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
		setNrOfLegs(nrOfLegs);
		setName(name);
		super.setLaysEggs(laysEggs);
	}
	
	public double getPredisposition() {
		LocalTime time = LocalTime.now();
		
		if (time.getHour() > 10 && time.getHour() < 19) {
			return 0.25;
		}
		return 0;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, Constants.XML_TAGS.DISCRIMINANT, Constants.Animals.Reptile.SNAKE);
	}
}