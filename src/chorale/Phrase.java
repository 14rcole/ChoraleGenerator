package chorale;
import org.jfugue.*;

import java.util.ArrayList;
import java.util.Random;
public class Phrase {
	//Create array of chords that make up phrase
	private Chord[] chords;
	
	//Constructor method
	public Phrase(int phraseLength){
		chords = new Chord[phraseLength];
		for(int i = 0; i < chords.length; i++){
			chords[i] = new Chord();
		}
	}
	
	/*Generate the bass and chords for the phrase
	 * Get Markov chain weights from WeightManager class
	 * Randomly select next chord
	 * Determine bass note based on chord and inversion
	 * Assign bass note, chord, and inversion to current chord
	 */
	public void generateBassAndChords(Chord lastChord){
		ChordWeight w = currentWeight(lastChord);
		int i = 0;
		while(i < chords.length - 1){
			double roll = Math.random();
			double sum = 0.0;
			int j = 0;
			for(j = 0; j < w.getLength(); j++){
				sum += w.getWeightAt(j);
				if(roll > sum){
					continue;
				}
				else{
					chords[i] = w.getChordAt(j);
					break;
				}
			}
			if(i + 1 != chords.length && chords[i + 1].getChordName().equals("")){
				w = currentWeight(chords[i]);
				i++;
			}
			else{
				w = currentWeight(chords[i]);
				if(w.isValidNextChord(chords[i + 1].getChordName())){
					break;
				}
				else{
					double entropyRoll = Math.random();
					if(entropyRoll < 0.01){
						i++;
					}
					else if(entropyRoll < 0.2){
						w = currentWeight(chords[i -2]);
						i--;
					}
					else{
						continue;
					}
				}
			}
		}
	}
	
	public void generateFirstBassAndChords(){
		chords[0].setNameAndInversion("I", "root");
		ChordWeight w = currentWeight(chords[0]);
		int i = 1;
		while(i < chords.length - 1){
			double roll = Math.random();
			double sum = 0.0;
			int j = 0;
			for(j = 0; j < w.getLength(); j++){
				sum += w.getWeightAt(j);
				if(roll > sum){
					continue;
				}
				else{
					break;
				}
			}
			if(j < w.getLength()){
				chords[i] = w.getChordAt(j);
			}
			else{
				chords[i] = w.getChordAt(w.getLength() - 1);
			}
			if(i + 1 != chords.length && chords[i + 1].getChordName().equals("")){
				w = currentWeight(chords[i]);
				i++;
			}
			else{
				w = currentWeight(chords[i]);
				if(w.isValidNextChord(chords[i + 1].getChordName())){
					break;
				}
				else{
					double entropyRoll = Math.random();
					if(entropyRoll < 0.01){
						i++;
					}
					else if(entropyRoll < 0.2){
						w = currentWeight(chords[i -2]);
						i--;
					}
					else{
						continue;
					}
				}
			}
		}
	}
	
	private ChordWeight currentWeight(Chord lastChord){
		String name = lastChord.getNameAndInversion();
		ChordWeight cw;
		switch(name){
		case "I": cw = WeightManager.I; break;
		case "I6": cw = WeightManager.I6; break;
		case "I64": cw = WeightManager.I64; break;
		case "ii": cw = WeightManager.ii; break;
		case "ii6": cw = WeightManager.ii6; break;
		case "ii64": cw = WeightManager.ii64; break;
		case "iii": cw = WeightManager.iii; break;
		case "iii6": cw = WeightManager.iii6; break;
		case "iii64": cw = WeightManager.iii64; break;
		case "IV": cw = WeightManager.IV; break;
		case "IV6": cw = WeightManager.IV6; break;
		case "IV64": cw = WeightManager.IV64; break;
		case "V": cw = WeightManager.V; break;
		case "V6": cw =  WeightManager.V6; break;
		case "V64": cw =  WeightManager.V64; break;
		case "V7": cw =  WeightManager.V; break;
		case "V65": cw = WeightManager.V65; break;
		case "V43": cw = WeightManager.V43;break;
		case "V42": cw = WeightManager.V42; break;
		case "vi": cw = WeightManager.vi; break;
		case "vi6": cw = WeightManager.vi6; break;
		case "vi64": cw = WeightManager.vi64; break;
		case "vii": cw = WeightManager.vii; break;
		case "vii6": cw = WeightManager.vii6; break;
		case "vii64": cw = WeightManager.vii64; break;
		case "V/V": cw = WeightManager.VofV; break;
		case "V6/V": cw = WeightManager.V6ofV; break;
		case "V64/V": cw = WeightManager.V64ofV; break;
		case "V7/V": cw = WeightManager.V7ofV; break;
		case "V65/V": cw = WeightManager.V65ofV; break;
		case "V43/V": cw = WeightManager.V43ofV; break;
		case "V42/V": cw = WeightManager.V42ofV; break;
		case "V/vi": cw = WeightManager.Vofvi; break;
		case "V6/vi": cw = WeightManager.V6ofvi; break;
		case "V64/vi": cw = WeightManager.V64ofvi; break;
		case "V7/vi": cw = WeightManager.V7ofvi; break;
		case "V65/vi": cw = WeightManager.V65ofvi; break;
		case "V43/vi": cw = WeightManager.V43ofvi; break;
		case "V42/vi": cw = WeightManager.V42ofvi; break;
		default: cw = WeightManager.vii; break;
		}
		return cw;
	}
	
	public void generateSoprano(Note lastSoprano, Note lastBass){
		int lastDistance = 0;
		for(int i = 0; i < chords.length; i++){
			if(lastSoprano.compareTo(new Note("B", lastSoprano.getOctave())) == 0){
				chords[i].setSoprano(new Note("C", lastSoprano.getOctave() + 1));
				continue;
			}
			ArrayList<Note> nextNotes = XMLParser.getPossibleSopranoNotes(chords[i]);
			System.out.println(nextNotes);
			int k;
			for (k = 0; k < nextNotes.size(); k++){
				if(nextNotes.get(k).compareTo(lastSoprano) == 0 && Math.random() < 0.25)
					break;
			}
			if(k < nextNotes.size()){
				chords[i].setSoprano(nextNotes.get(k));
				lastDistance = 1;
				lastSoprano = chords[i].getSoprano();
				lastBass = chords[i].getBass();
				continue;
			}
			for(int j = nextNotes.size() - 1; j >= 0; j--){
				nextNotes.get(j).makeClosestOctave(lastSoprano);
				//if(Math.abs(nextNotes.get(j).compareTo(lastSoprano)) >= 10)
					//nextNotes.remove(j);
			}
			ArrayList<Integer>distances = new ArrayList<Integer>();
			for(int j = nextNotes.size() - 1; j >= 0; j--){
				distances.add(lastSoprano.compareTo(nextNotes.get(j)));
			}
			if(lastDistance >= 5){
				for(int j = distances.size() - 1; j >= 0; j--){
					if(distances.get(j) < 0){
						distances.remove(j);
						nextNotes.remove(j);
					}
				}
			}
			else if(lastDistance <= -5){
				for(int j = distances.size() - 1; j >= 0; j--){
					if(distances.get(j) > 0){
						distances.remove(j);
						nextNotes.remove(j);
					}
				}
			}
			for(int j = nextNotes.size() - 1; j >= 0; j--){
				if(distances.get(j) < 5 && distances.get(j) > -5){
					nextNotes.add(nextNotes.get(j));
					distances.add(distances.get(j));
				}
			}
			int nextIndex = (int)(Math.random() * nextNotes.size());
			chords[i].setSoprano(nextNotes.get(nextIndex));
			lastDistance = distances.get(nextIndex);
			lastSoprano = chords[i].getSoprano();
			lastBass = chords[i].getBass();
		}
		
		System.out.print("---------------------------------\n");
		for(int k = 0; k < chords.length; k++){
			System.out.println(chords[k].toString());
		}
	}
	
	public void generateAltoAndTenor(Note lastTenor, Note lastAlto){
		for(int i = 0; i < chords.length; i++){
			if(lastTenor.compareTo(new Note("B", lastTenor.getOctave())) == 0){
				chords[i].setTenor(new Note("C", lastTenor.getOctave() + 1));
			}
			if(lastAlto.compareTo(new Note("B", lastAlto.getOctave())) == 0){
				chords[i].setAlto(new Note("C", lastAlto.getOctave() + 1));
			}
			ArrayList<Note> nextNotes = XMLParser.getPossibleSopranoNotes(chords[i]);
		}
	}
	
	public void setCadence(String cad){
		if(cad.equals("perfect authentic")){
			chords[chords.length-1].setNameAndInversion("I", "root");
			chords[chords.length-2].setNameAndInversion("V", "root");
		}
		else if(cad.equals("half")){
			chords[chords.length-1].setNameAndInversion("V", "root");
		}
		else if(cad.equals("deceptive")){
			chords[chords.length-1].setNameAndInversion("vi", "root");
			chords[chords.length-2].setNameAndInversion("V", "root");
		}
		else if(cad.equals("plagal IV")){
			chords[chords.length-1].setNameAndInversion("I", "root");
			chords[chords.length-2].setNameAndInversion("IV", "root");
		}
		else if(cad.equals("plagal ii6")){
			chords[chords.length-1].setNameAndInversion("I", "root");
			chords[chords.length-2].setNameAndInversion("ii", "first");
		}
		else if(cad.equals("imperfect authentic V")){
			if(Math.random() < 0.3)
				chords[chords.length-1].setNameAndInversion("I", "first");
			else{
				chords[chords.length-1].setNameAndInversion("I", "root");
				if(Math.random() < 0.3)
					chords[chords.length-2].setNameAndInversion("V", "first");
				else
					chords[chords.length-2].setNameAndInversion("V", "root");
			}
		}
		else if(cad.equals("imperfect authentic vii")){
			chords[chords.length-1].setNameAndInversion("I", "root");
			chords[chords.length-2].setNameAndInversion("vii", "root");
		}
	}
	
	public boolean hasCadence(){
		if(chords[chords.length - 1].getChordName().equals(""))
			return false;
		return true;
	}
	
	public Chord getLastChord(){
		return chords[chords.length - 1];
	}
	
	public Note getLastSoprano(){
		return chords[chords.length - 1].getSoprano();
	}
	
	public Note getLastBass(){
		return chords[chords.length - 1].getBass();
	}
	
	public Pattern makePattern(){
		Pattern p = new Pattern();
		Pattern soprano = new Pattern("V0");
		//Pattern alto = new Pattern("V1");
		//Pattern tenor = new Pattern("V2");
		Pattern bass = new Pattern("V3");
		for(int i = 0; i < chords.length; i++){
			soprano.add(chords[i].getSoprano().pattern());
			//alto.add(chords[i].getAlto().pattern());
			//tenor.add(chords[i].getTenor().pattern());
			bass.add(chords[i].getBass().pattern());
		}
		p.add(soprano);
		//p.add(tenor);
		//p.add(alto);
		p.add(bass);
		return p;
	}
}