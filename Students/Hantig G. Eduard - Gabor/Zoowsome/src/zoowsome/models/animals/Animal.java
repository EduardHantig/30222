package zoowsome.models.animals;
import java.util.Random;

import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.w3c.dom.Element;

import zoowsome.models.interfaces.XML_Parsable;
import static zoowsome.repositories.AnimalRepository.createNode;

public abstract class Animal implements Killer, XML_Parsable  {
	private int nrOfLegs;
	private String name;
	private double maintenanceCost;
	private double dangerPerc;
	private boolean takenCareOf = false;
	
	
	public Animal (double maintenanceCost, double dangerPerc) {
		this.maintenanceCost = maintenanceCost;
		this.dangerPerc = dangerPerc;
	}
	
	public boolean kill() {
		Random random = new Random();
		if (random.nextDouble() < (this.dangerPerc + getPredisposition())) {
			return true;
		}
		return false;
	}
	
	public void decodeFromXml(Element element) {
		setNrOfLegs(Integer.valueOf(element.getElementsByTagName("nrOfLegs").item(0).getTextContent())); 
		setName(element.getElementsByTagName("name").item(0).getTextContent()); 
		setMaintenanceCost(Double.valueOf(element.getElementsByTagName("maintenanceCost").item(0).getTextContent())); 
		setDangerPerc(Double.valueOf(element.getElementsByTagName("dangerPerc").item(0).getTextContent())); 
		setTakenCareOf(Boolean.valueOf(element.getElementsByTagName("takenCareOf").item(0).getTextContent()));
	}  // This-uri puse in plus
	
	
	public double getPredisposition() {
		return 0;
	}
	
	public void setMaintenanceCost(Double maintenanceCost) {
		this.maintenanceCost = maintenanceCost;
	}
	
	public void setDangerPerc(Double dangerPerc) {
		this.dangerPerc = dangerPerc;
	}
	
	public void encodeToXml(XMLEventWriter eventWriter) throws XMLStreamException { 
		createNode(eventWriter, "nrOfLegs", String.valueOf(this.nrOfLegs)); 
		createNode(eventWriter, "name", String.valueOf(this.name)); 
		createNode(eventWriter, "maintenanceCost", String.valueOf(this.maintenanceCost)); 
		createNode(eventWriter, "dangerPerc", String.valueOf(this.dangerPerc)); 
		createNode(eventWriter, "takenCareOf", String.valueOf(this.takenCareOf));
	}
	
	public int getNrOfLegs() {
		return nrOfLegs;
	}
	
	public void setNrOfLegs(int nrOfLegs) {
		this.nrOfLegs = nrOfLegs;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public double getMaintenanceCost() {
		return maintenanceCost;
	}

	public double getDangerPerc() {
		return dangerPerc;
	}

	public boolean isTakenCareOf() {
		return takenCareOf;
	}

	public void setTakenCareOf(boolean takenCareOf) {
		this.takenCareOf = takenCareOf;
	}
	
}
