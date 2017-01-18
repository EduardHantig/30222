package zoowsome.models.animals;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import static zoowsome.repositories.AnimalRepository.createNode;

public abstract class Insect extends Animal {
	private boolean canFly;
	private boolean isDangerous;
	
	public Insect(double maintenanceCost, double dangerPerc) {
		super(maintenanceCost, dangerPerc);
	}
	
	public void decodeFromXml(Element element) {
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("canFly").item(0).getTextContent())); 
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("isDangerous").item(0).getTextContent()));
		}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException {
		super.encodeToXml(eventWriter);
		createNode(eventWriter, "canFly", String.valueOf(isCanFly()));
		createNode(eventWriter, "isDangerous", String.valueOf(isDangerous()));
	}

	public boolean isCanFly() {
		return canFly;
	}
	
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
	public boolean isDangerous() {
		return isDangerous;
	}
	
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
	
	

}
