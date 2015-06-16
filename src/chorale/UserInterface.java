package chorale;
import BreezySwing.*;
import javax.swing.*;
public class UserInterface extends GBFrame{
	JLabel nameLabel;
	JTextField nameField;
	JButton generateButton;
	Song chorale;
	
	public UserInterface(){
		nameLabel = addLabel("Chorale Name", 1, 1, 1, 1);
		nameField = addTextField("" + System.currentTimeMillis()/1000, 1, 2, 1, 1);
		generateButton = addButton("Generate", 1, 3, 1, 1);
	}
	
	public void buttonClicked(JButton buttonObj){
		chorale = new Song(nameField.getText());
		System.out.println(chorale.getName());
		chorale.generate();
		System.exit(0);
	}
	
	public static void main(String [] args){
		UserInterface uI = new UserInterface();
		uI.setSize(500, 200);
		uI.setVisible(true);
	}
}