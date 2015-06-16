package chorale;
import java.io.File;
import java.util.ArrayList;
public class Chord {
	private Note sopranoNote, altoNote, tenorNote, bassNote;
	private String chordName, inversion;
	
	public Chord(){
		sopranoNote = new Note();
		altoNote = new Note();
		tenorNote = new Note();
		bassNote = new Note();
		chordName = "";
		inversion = "";
	}
	
	public Chord(String nm){
		sopranoNote = new Note();
		altoNote = new Note();
		tenorNote = new Note();
		bassNote = new Note();
		chordName = nm;
		inversion = "";
	}
	
	public Chord(String nm, String inv, Note b){
		sopranoNote = new Note();
		altoNote = new Note();
		tenorNote = new Note();
		bassNote = b;
		chordName = nm;
		inversion = inv;
	}
	
	public void setSoprano(Note n){
		sopranoNote = n;
	}
	
	public void setAlto(Note n){
		altoNote = n;
	}
	
	public void setTenor(Note n){
		tenorNote = n;
	}
	
	public void setBass(Note n){
		bassNote = n;
	}
	
	public void setChordName(String nm){
		chordName = nm;
	}
	
	public void setInversion(String inv){
		inversion = inv;
	}
	
	public void setNameAndInversion(String nm, String inv){
		chordName = nm;
		inversion = inv;
		bassNote = XMLParser.getBassNote(this);
	}
	
	public Note getSoprano(){
		return sopranoNote;
	}
	
	public Note getAlto(){
		return altoNote;
	}
	
	public Note getTenor(){
		return tenorNote;
	}
	
	public Note getBass(){
		return bassNote;
	}
	
	public String getChordName(){
		return chordName;
	}
	
	public String getInversion(){
		return inversion;
	}
	
	public String getNameAndInversion(){
		String nameWithInversion = chordName;
		if(chordName.indexOf("7") == -1){
			switch(inversion){
				case "root": nameWithInversion = chordName; break;
				case "first": nameWithInversion = chordName + "6"; break;
				case "second": nameWithInversion = chordName + "64"; break;
				default: nameWithInversion = chordName; break;
			}
		}
		else{
			switch(inversion){
			case "root": nameWithInversion = chordName; break;
			case "first": nameWithInversion = chordName.substring(0, chordName.length()-1) + "65"; break;
			case "second": nameWithInversion = chordName.substring(0, chordName.length()-1) + "43"; break;
			case "third": nameWithInversion = chordName.substring(0, chordName.length()-1) + "42"; break;
			}
		}
		return nameWithInversion;
	}
	
	public ArrayList<Chord> validNextChords(){
		ArrayList<Chord> validNextChords = new ArrayList<Chord>();
		if(chordName == "I"){
			validNextChords.add(new Chord("I"));
			validNextChords.add(new Chord("ii"));
			validNextChords.add(new Chord("V/V"));
			validNextChords.add(new Chord("V7/V"));
			validNextChords.add(new Chord("iii"));
			validNextChords.add(new Chord("V/vi"));
			validNextChords.add(new Chord("V7/vi"));
			validNextChords.add(new Chord("IV"));
			validNextChords.add(new Chord("V"));
			validNextChords.add(new Chord("V7"));
			validNextChords.add(new Chord("vi"));
			validNextChords.add(new Chord("vii"));
		}
		else if(chordName == "ii"){
			validNextChords.add(new Chord("ii"));
		}
		else if(chordName == "iii"){
			validNextChords.add(new Chord("V"));
			validNextChords.add(new Chord("vi"));
			validNextChords.add(new Chord("ii"));
		}
		else if(chordName == "IV"){
			validNextChords.add(new Chord("I"));
			validNextChords.add(new Chord("ii"));
			validNextChords.add(new Chord("V/V"));
			validNextChords.add(new Chord("V7/V"));
			validNextChords.add(new Chord("V"));
			validNextChords.add(new Chord("V7"));
		}
		else if(chordName == "V" || chordName == "V7"){
			validNextChords.add(new Chord("I"));
			validNextChords.add(new Chord("vi"));
		}
		else if(chordName == "vi"){
			validNextChords.add(new Chord("IV"));
			validNextChords.add(new Chord("ii"));
			validNextChords.add(new Chord("V"));
			validNextChords.add(new Chord("V7"));
		}
		else if(chordName == "vii"){
			validNextChords.add(new Chord("I"));
		}
		else if(chordName == "V/V" || chordName == "V7/V"){
			validNextChords.add(new Chord("V"));
		}
		else if(chordName == "V/vi" || chordName == "V7/vi"){
			validNextChords.add(new Chord("vi"));
		}
		return validNextChords;
	}
	
	public static boolean isPerfectFifth(Note note1, Note note2){
		if(Math.abs(note1.compareTo(note2) % 12) == 7)
			return true;
		return false;
	}
	
	public static boolean isOctaveOrUnison(Note note1, Note note2){
		if(Math.abs(note1.compareTo(note2) % 12) == 0)
			return true;
		return false;
	}
	
	public String toString(){
		return chordName + " " + inversion + " " + bassNote.toString() + " " + sopranoNote.toString();
	}
}