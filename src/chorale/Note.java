package chorale;
import java.util.Arrays;

public class Note implements Comparable{
	private String name;
	private int octave;
	private static String[] notes = {"C", "D", "E", "F", "F#", "G", "G#", "A", "B"};
	
	public Note(){
		name = "C";
		octave = 5;
	}
	
	public Note(String nm, int oct){
		name = nm;
		octave = oct;
	}
	
	public Note(String nm){
		name = nm;
		octave = 5;
	}
	
	public String getName(){
		return name;
	}
	
	public int getOctave(){
		return octave;
	}
	
	public void setName(String nm){
		name = nm;
	}
	
	public void setOctave(int oct){
		octave = oct;
	}
	
	public int noteAsInteger(){
		int num = octave * 12;
		switch(name){
		case "C": num += 1;
		case "C#": case "Db": num += 2;
		case "D": num += 3;
		case "D#": case "Eb": num += 4;
		case "E": num += 5;
		case "F": num += 6;
		case "F#": case "Gb": num += 7;
		case "G": num += 8;
		case "G#": case "Ab": num += 9;
		case "A": num += 10;
		case "A#": case "Bb": num += 11;
		case "B": num += 12;
		}
		return num;
	}
	
	public int compareTo(Object o){
		int halfsteps = noteAsInteger() - ((Note)o).noteAsInteger();
		return halfsteps;
	}
	
	public String pattern(){
		return name + octave + "q";
	}
	
	public void makeClosestOctave(Note lastNote){
		setOctave(lastNote.getOctave());
		int distance = Math.abs(lastNote.compareTo(this));
		if(Math.abs(lastNote.compareTo(new Note(getName(), getOctave() + 1))) > distance)
			setOctave(getOctave());
		else if(Math.abs(lastNote.compareTo(new Note(getName(), getOctave() - 1))) < distance)
			setOctave(getOctave()-1);
		System.out.println(lastNote.toString() + " " + toString());
	}
	
	public String toString(){
		return name + octave;
	}
}