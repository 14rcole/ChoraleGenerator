package chorale;
import java.io.File;
import java.util.Random;
import org.jfugue.*;

public class Song {
	private String name;
	private int phraseLength;
	private Phrase[] phrases;
	
	public Song(String nm){
		name = nm;
		double d = Math.random();
		if(d <= 0.25)
			phraseLength = 4;
		else if(d <= 0.5)
			phraseLength = 6;
		else
			phraseLength = 8;
		
		if(d <= 0.5)
			phrases = new Phrase[4];
		else
			phrases = new Phrase[4];
	}
	
	public void setName(String nm){
		name = nm;
	}
	
	public String getName(){
		return name;
	}
	
	public void generate(){
		for(int i = 0; i < phrases.length; i++){
			phrases[i] = new Phrase(phraseLength);
		}
		cadenceProgression();
		startingNote();
		generateBassAndChords();
		generateSoprano();
		//generateAltoAndTenor();
		//generateLilypondFile();
		//convertLilypondFile();
		generateMIDI();
		convertMIDIToWAV();
	}
	
	private void cadenceProgression(){
		phrases[phrases.length-1].setCadence("perfect authentic");
		int halfLocation = (int)(Math.random() * phrases.length); 
		phrases[halfLocation].setCadence("half");
		for(int i = 0; i < phrases.length - 1; i++){
			if(i == halfLocation){
				System.out.println(halfLocation + "     half");
				continue;
			}
			double cadenceType = Math.random();
			if(cadenceType <= 0.142857143){
				System.out.println(i + "     perfect authentic");
				phrases[i].setCadence("perfect authentic");
			}
			else if(cadenceType <= 0.285714286){
				System.out.println(i + "     half");
				phrases[i].setCadence("half");
			}
			else if(cadenceType <= 0.428571429){
				System.out.println(i + "     deceptive");
				phrases[i].setCadence("deceptive");
			}
			else if(cadenceType <= 0.571428571){
				System.out.println(i + "     plagal IV");
				phrases[i].setCadence("plagal IV");
			}
			else if(cadenceType <= 0.714285714){
				System.out.println(i + "     plagal ii6");
				phrases[i].setCadence("plagal ii6");
			}
			else if(cadenceType <= 0.857142857){
				System.out.println(i + "     imperfect authentic V");
				phrases[i].setCadence("imperfect authentic V");
			}
			else{
				System.out.println(i + "     imperfect authentic vii");
				phrases[i].setCadence("imperfect authentic vii");
			}
		}
		System.out.println(phrases.length - 1 + "     perfect authentic");
	}
	
	private Note startingNote(){
		if(Math.random() < 0.6)
			return new Note("E", 6);
		else
			return new Note("G", 6);
	}
	
	private void generateBassAndChords(){
		phrases[0].generateFirstBassAndChords();
		for(int i = 1; i < phrases.length; i++){
			phrases[i].generateBassAndChords(phrases[i - 1].getLastChord());
		}
	}
	
	public void generateSoprano(){
		phrases[0].generateSoprano(startingNote(), new Note("B", 3));
		for(int i = 1; i < phrases.length; i++){
			phrases[i].generateSoprano(phrases[i-1].getLastSoprano(), phrases[i-1].getLastBass());
		}
	}
	
	private void generateAltoAndTenor(){
		for(Phrase p : phrases){
			p.generateAltoAndTenor(new Note("C", 3), new Note("C", 4));
		}
	}
	
	private void generateLilypondFile(){
		
	}
	
	private void convertLilypondFile(){
		
	}
	
	private void generateMIDI(){
		Player player = new Player();
		Pattern chorale = new Pattern();
		for(Phrase p : phrases){
			chorale.add(p.makePattern());
		}
		try{
			player.saveMidi(chorale, new File("generatedFiles/midiFiles/" + name + ".mid"));
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	private void convertMIDIToWAV(){
		try{
		ProcessBuilder b = new ProcessBuilder("/home/Ryan/workspace/ChoraleGenerator/midiToWAV.sh",
				"generatedFiles/midiFiles/" + name + ".mid", "generatedFiles/wavFiles/" + name + ".wav");
		b.inheritIO();
		Process p = b.start();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}