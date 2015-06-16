package chorale;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
public class XMLParser {
	public static ArrayList<Element> getChordsFromNotes(Chord c){
		ArrayList<Element> chords = new ArrayList<Element>();
		boolean sopranoMatch = false, bassMatch = false;
		try{
			File fXmlFile = new File("/home/Ryan/workspace/ChoraleGenerator/Chords.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Chord");
			
			for(int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element)nNode;
					if(getChildElementContent(eElement, "Note1").equals(c.getSoprano().getName()) ||
							getChildElementContent(eElement, "Note2").equals(c.getSoprano().getName()) ||
							getChildElementContent(eElement, "Note3").equals(c.getSoprano().getName()) ||
							getChildElementContent(eElement, "Note4").equals(c.getSoprano().getName())){
						sopranoMatch = true;
					}
					if(getChildElementContent(eElement, "Note1").equals(c.getBass().getName()) ||
							getChildElementContent(eElement, "Note2").equals(c.getBass().getName()) ||
							getChildElementContent(eElement, "Note3").equals(c.getBass().getName()) ||
							getChildElementContent(eElement, "Note4").equals(c.getBass().getName())){
						bassMatch = true;
					}
					if(sopranoMatch && bassMatch)
						chords.add(eElement);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return chords;
	}
	
	public static ArrayList<Chord> getChordsFromBass(ArrayList<Chord> c, Note bassNote){
		ArrayList<Chord> chords = new ArrayList<Chord>();
		try{
			File fXmlFile = new File("/home/Ryan/workspace/ChoraleGenerator/Chords.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Chord");
			
			for(int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element)nNode;
					for(int j = 0; j < c.size(); j++){
						if(getChildElementContent(eElement, "Note1").equals(bassNote.getName()) ||
								getChildElementContent(eElement, "Note2").equals(bassNote.getName()) ||
								getChildElementContent(eElement, "Note3").equals(bassNote.getName()) ||
								getChildElementContent(eElement, "Note4").equals(bassNote.getName())){
							chords.add(c.get(i));
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return chords;
	}
	
	public static ArrayList<Note> getPossibleSopranoNotes(Chord c){
		ArrayList<Note> notes = new ArrayList<Note>();
		try{
			File fXmlFile = new File("/home/Ryan/workspace/ChoraleGenerator/Chords.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Chord");
			
			for(int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element)nNode;
					if(eElement.getAttribute("name").equals(c.getChordName())){
						notes.add(new Note(getChildElementContent(eElement, "Note1")));
						notes.add(new Note(getChildElementContent(eElement, "Note2")));
						notes.add(new Note(getChildElementContent(eElement, "Note3")));
						if(!getChildElementContent(eElement, "Note4").equals(""))
							notes.add(new Note(getChildElementContent(eElement, "Note4")));
						break;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return notes;
	}
	
	public static Note getBassNote(Chord c){
		try{
			File fXmlFile = new File("/home/Ryan/workspace/ChoraleGenerator/Chords.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("Chord");
			
			for(int i = 0; i < nList.getLength(); i++){
				Node nNode = nList.item(i);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element)nNode;
					if(eElement.getAttribute("name").equals(c.getChordName())){
						if(c.getInversion().equals("root"))
							 return new Note(getChildElementContent(eElement, "Note1"), 4);
						else if(c.getInversion().equals("first"))
							return new Note(getChildElementContent(eElement, "Note2"), 4);
						else if(c.getInversion().equals("second"))
							return new Note(getChildElementContent(eElement, "Note3"), 4);
						else
							return new Note(getChildElementContent(eElement, "Note4"), 4);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getChildElementContent(Element e, String childName) {
	    NodeList children = e.getElementsByTagName(childName);
	    if(children.getLength() > 0) {
	        return children.item(0).getTextContent();
	    }
	    return "";
	}
}