package zoowsome.repositories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.text.Document;
import javax.xml.parsers.*;
import javax.xml.soap.Node;
import javax.xml.stream.*;
import javax.xml.stream.events.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import zoowsome.models.animals.Alligator;
import zoowsome.models.animals.Animal;
import zoowsome.models.animals.Butterfly;
import zoowsome.models.animals.Cockroach;
import zoowsome.models.animals.Colibri;
import zoowsome.models.animals.Cow;
import zoowsome.models.animals.Frog;
import zoowsome.models.animals.Lizzard;
import zoowsome.models.animals.Monkey;
import zoowsome.models.animals.Ostrich;
import zoowsome.models.animals.Shark;
import zoowsome.models.animals.Snake;
import zoowsome.models.animals.Spider;
import zoowsome.models.animals.Swan;
import zoowsome.models.animals.Tiger;
import zoowsome.models.animals.Whale;
import zoowsome.models.interfaces.XML_Parsable;
import zoowsome.services.factories.animal.Constants;

public class AnimalRepository {
	private static final String XML_FILENAME = "Animals.xml";
	
	public AnimalRepository() {
	}
	
	public void save(ArrayList<Animal> animals) throws FileNotFoundException, XMLStreamException { 
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		// Create XMLEventWriter
		XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(XML_FILENAME)); 
		// Create a EventFactory
		XMLEventFactory eventFactory = XMLEventFactory.newInstance(); 
		XMLEvent end = eventFactory.createDTD("\n");
		// Create and write Start Tag
		StartDocument startDocument = eventFactory.createStartDocument();
		eventWriter.add(startDocument);
		// Create content open tag
		StartElement configStartElement = eventFactory.createStartElement("", "", "content");
		eventWriter.add(configStartElement);
		eventWriter.add(end);
		
		for (XML_Parsable animal : animals) {
			StartElement sElement = eventFactory.createStartElement("", "", Constants.XML_TAGS.ANIMAL); 
			eventWriter.add(sElement);
			eventWriter.add(end);
			
			animal.encodeToXml(eventWriter);
			
			EndElement eElement = eventFactory.createEndElement("", "", Constants.XML_TAGS.ANIMAL); 
			eventWriter.add(eElement);
			eventWriter.add(end);
		}
		eventWriter.add(eventFactory.createEndElement("", "", "content")); 
		eventWriter.add(eventFactory.createEndDocument());
		eventWriter.close( );
	}
	
	public static void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
		XMLEventFactory eventFactory = XMLEventFactory.newInstance(); 
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// Create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name); 
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// Create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// Create End node
		EndElement eElement = eventFactory.createEndElement("", "", name); 
		eventWriter.add(eElement);
		eventWriter.add(end);
	}
	
	public ArrayList<Animal> load() throws ParserConfigurationException, SAXException, IOException { 
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
	
		File fXmlFile = new File(XML_FILENAME);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = (Document) dBuilder.parse(fXmlFile); 
		((org.w3c.dom.Document) doc).getDocumentElement().normalize();
		
		NodeList nodeList = ((org.w3c.dom.Document) doc).getElementsByTagName(Constants.XML_TAGS.ANIMAL);
		
		for (int i = 0; i < nodeList.getLength(); i++) { 
			Node node = (Node) nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				String discriminant = ((org.w3c.dom.Document) element).getElementsByTagName(Constants.XML_TAGS.DISCRIMINANT).item(0).getTextContent();
	
				switch (discriminant) {
				case Constants.Animals.Insect.BUTTERFLY:
						Animal butterfly = new Butterfly(); 
						butterfly.decodeFromXml((org.w3c.dom.Element) element); 
						animals.add(butterfly);
						break;
				case Constants.Animals.Insect.COCKROACH:
						Animal Cockroach = new Cockroach();
						Cockroach.decodeFromXml((org.w3c.dom.Element) element);
						animals.add(Cockroach);
						break;
				case Constants.Animals.Insect.SPIDER:
						Animal Spider = new Spider();
						Spider.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Spider);
						break;
				case Constants.Animals.Aquatic.FROG:
						Animal Frog = new Frog();
						Frog.decodeFromXml((org.w3c.dom.Element) element);
						animals.add(Frog);
						break;
				case Constants.Animals.Aquatic.SHARK:
						Animal Shark = new Shark();
						Shark.decodeFromXml((org.w3c.dom.Element) element);
						animals.add(Shark);
						break;
				case Constants.Animals.Aquatic.WHALE:
						Animal Whale = new Whale();
						Whale.decodeFromXml((org.w3c.dom.Element) element);
						animals.add(Whale);
						break;
				case Constants.Animals.Bird.COLIBRI:
						Animal Colibri = new Colibri();
						Colibri.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Colibri);
						break;
				case Constants.Animals.Bird.OSTRICH:
						Animal Ostrich = new Ostrich();
						Ostrich.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Ostrich);
						break;
				case Constants.Animals.Bird.SWAN:
						Animal Swan = new Swan();
						Swan.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Swan);
						break;
				case Constants.Animals.Mammal.COW:
						Animal Cow = new Cow();
						Cow.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Cow);
						break;
				case Constants.Animals.Mammal.MONKEY:
						Animal Monkey = new Monkey();
						Monkey.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Monkey);
						break;
				case Constants.Animals.Mammal.TIGER:
						Animal Tiger = new Tiger();
						Tiger.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Tiger);
						break;
				case Constants.Animals.Reptile.ALLIGATOR:
						Animal Alligator = new Alligator();
						Alligator.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Alligator);
						break;
				case Constants.Animals.Reptile.LIZZARD:
						Animal Lizzard = new Lizzard();
						Lizzard.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Lizzard);
						break;
				case Constants.Animals.Reptile.SNAKE:
						Animal Snake = new Snake();
						Snake.decodeFromXml((org.w3c.dom.Element)element);
						animals.add(Snake);		
						break;
				default:
					break;
	} } } 
	return animals;
			}
}
