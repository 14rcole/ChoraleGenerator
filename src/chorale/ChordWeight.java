package chorale;

public class ChordWeight {
	private double[] weights;
	private String name;
	private Chord[] chords;
	
	public ChordWeight(String tn, double[] w, Chord[] c){
		name = tn;
		weights = w;
		chords = c;
	}
	
	public double weightSum(int endIndex){
		if(endIndex >= weights.length)
			endIndex = weights.length - 1;
		double sum = 0.0;
		for(int i = 0; i <= endIndex; i++){
			sum += weights[i];
		}
		return sum;
	}
	
	public int getLength(){
		return weights.length;
	}
	
	public double[] getWeights(){
		return weights;
	}
	
	public double getWeightAt(int index){
		if(index > weights.length){
			return 0.0;
		}
		else{
			return weights[index];
		}
	}
	
	public Chord getChordAt(int index){
		if(index >= chords.length)
			return new Chord("I", "first", new Note("C", 4));
		return chords[index];
	}
	
	public boolean isValidNextChord(String nextChord){
		for(int i = 0; i < chords.length; i++){
			if(chords[i].getChordName().equals(nextChord))
				return true;
		}
		return false;
	}
	
	public String toString(){
		String str = name + " | ";
		for(int i = 0; i< chords.length; i++){
			str += chords[i].getNameAndInversion() + " ";
		}
		return str;
	}
}
