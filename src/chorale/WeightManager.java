package chorale;

public class WeightManager {
	public static final ChordWeight I = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight I6 = new ChordWeight("I6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight I64 = new ChordWeight("I64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight ii = new ChordWeight("ii", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight ii6 = new ChordWeight("ii6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight ii64 = new ChordWeight("ii64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight iii = new ChordWeight("iii", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight iii6 = new ChordWeight("iii6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight iii64 = new ChordWeight("iii64", new double[]{1}, new Chord[]{
			new Chord("I", "root", new Note("C", 4))});
	
	public static final ChordWeight IV = new ChordWeight("IV", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight IV6 = new ChordWeight("IV6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight IV64 = new ChordWeight("IV64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V = new ChordWeight("V", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V6 = new ChordWeight("V6", new double[]{1}, new Chord[]{
			new Chord("I", "root", new Note("C", 4))});
	
	public static final ChordWeight V64 = new ChordWeight("V64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V7 = new ChordWeight("V7", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V65 = new ChordWeight("V65", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V43 = new ChordWeight("V43", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V42 = new ChordWeight("V42", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight vi = new ChordWeight("vi", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight vi6 = new ChordWeight("vi6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight vi64 = new ChordWeight("vi64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight vii = new ChordWeight("vii", new double[]{1}, new Chord[]{
			new Chord("I", "root", new Note("C", 4))});
	
	public static final ChordWeight vii6 = new ChordWeight("vii6", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight vii64 = new ChordWeight("vii64", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight VofV = new ChordWeight("VofV", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V6ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V64ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V7ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V65ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V43ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V42ofV = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight Vofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V6ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V64ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V7ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V65ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V43ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
	
	public static final ChordWeight V42ofvi = new ChordWeight("I", new double[]{0.2, 0.2, 0.2, 0.2, 0.2}, new Chord[]{
			new Chord("ii", "root", new Note("D", 4)), new Chord("I", "root", new Note("C", 4)),
			new Chord("IV", "root", new Note("F", 4)), new Chord("V", "root", new Note("G", 3)),
			new Chord("vii", "root", new Note("B", 3))});
}