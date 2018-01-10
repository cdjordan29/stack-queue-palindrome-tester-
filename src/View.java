import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * View creates the GUI for Project 2
 * @author Daniel Jordan
 * @version 1.0
 */
public class View {

	Model m = new Model();
	private JFrame frame;
	private JPanel panel;
	private JTextField textbox;
	private JLabel directionLabel, outputLabel1, outputLabel2;
	private JButton goButton;
	
	/**
	 * Constructor for the View class
	 */
	public View(){
		
		
	}
	
	/**
	 * prepareGUI generates the GUI for Project 2
	 */
	public void prepareGUI(){
		
		frame = new JFrame("Project 2");
		frame.setSize(900, 600);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1));
		frame.add(panel);
		directionLabel = new JLabel();
		directionLabel.setText("Please input a palindrome");
		textbox = new JTextField();
		outputLabel1 = new JLabel();
		outputLabel1.setText("Output will be displayed here");
		outputLabel2 = new JLabel();
		outputLabel2.setText("");
		goButton = new JButton();
		goButton.setText("Go");
		panel.add(directionLabel);
		panel.add(textbox);
		panel.add(goButton);
		panel.add(outputLabel1);
		panel.add(outputLabel2);
		goButton.addActionListener((ActionEvent e) -> {
                    setModelText();
                    updateLabels();
                });
		frame.setVisible(true);
	}
	
	/**
	 * getText gets the text from the JTextField then sets it as the String of the Model
         * @return str
         */
	public String setModelText(){
		
		String str;
                String pattern = "[^\\w]";
                str = textbox.getText();
                str = str.toLowerCase();
                str = str.replaceAll(pattern, "");
                m.setS(str);
                return str;
	}
	
	/**
	 * updateLabels sets the text for output labels
	 */
	public void updateLabels(){
		
		String isPal = "true";
                String str = textbox.getText();
		if(!(m.validate(setModelText()))){
			isPal = "false";
		}
		outputLabel1.setText("Checking to see if input /" + str + "/ is palindrome");
		outputLabel2.setText("Palindrome status for /" + str + "/ is " + isPal);
	}
}
