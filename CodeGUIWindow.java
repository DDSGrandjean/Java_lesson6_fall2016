/**
* COMI2510 - Advanced Java Programming
* October 31st, 2016
* 
* Program to encode or decode a given
* paragraph, phone number, morse code, or 
* guess what language the text is written in.
* 
* @author Dylan Grandjean
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CodeGUIWindow extends JFrame
{
	private JTextArea codeField;
	private JTextArea resultField;
	private JScrollPane codePane;
	private JScrollPane resultPane;
	private JComboBox codeBox;
	private JComboBox optionBox;
	private JButton okayButton;
	private JButton exitButton;
	
	private ShiftCode codeClass = new ShiftCode();
	
	private String[] codes = {"Shift Code", "Phone Number", "Morse Code", "Language"};
	private String[] options = {"Encode", "Decode"};
	private int codeSelection;
	private boolean encode = true;
	
	/**
	 * CodeGUIWindow no-arg constructor.
	 */
	public CodeGUIWindow()
	{
		//Set title
		setTitle("Coding Program");
		
		//SetLayout Manager
		setLayout(new BorderLayout());
		
		//Create elements
		TopPanel topPanel = new TopPanel();
		CenterPanel centerPanel = new CenterPanel();
		BottomPanel bottomPanel = new BottomPanel();
		
		//Add elements to window
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		//Pack and set to visible
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Inner class which assembles JComboBox
	 * in order to place them in the top
	 * area of the BorderLayout.
	 */
	private class TopPanel extends JPanel
	{
		private TopPanel()
		{
			//Set layout
			setLayout(new GridLayout(1, 2));
			
			//Create elements
			codeBox = new JComboBox(codes);
			codeBox.addActionListener(new CodesListener());
			optionBox = new JComboBox(options);
			optionBox.addActionListener(new OptionListener());
			
			//Add elements to window
			add(codeBox);
			add(optionBox);
		}
	}
	
	/**
	 * Inner class which assembles JTextAreas
	 * in order to place them in the center
	 * area of the BorderLayout.
	 */
	private class CenterPanel extends JPanel
	{
		private CenterPanel()
		{
			//Set layout manager
			setLayout(new GridLayout(2, 1));
			
			//Create elements
			codeField = new JTextArea(10, 40);
			codeField.setLineWrap(true);
			codeField.setWrapStyleWord(true);
			codePane = new JScrollPane(codeField);
			codePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
			resultField = new JTextArea(10, 40);
			resultField.setLineWrap(true);
			resultField.setWrapStyleWord(true);
			resultPane = new JScrollPane(resultField);
			resultPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			resultField.setEditable(false);
			
			//Add elements to window
			add(codePane);
			add(resultPane);
		}
	}
	
	/**
	 * Inner class which assembles JButtons
	 * in order to place them in the bottom
	 * area of the BorderLayout.
	 */
	private class BottomPanel extends JPanel
	{
		private BottomPanel()
		{
			//Set layout manager
			setLayout(new GridLayout(1, 2));
			
			//Create elements
			okayButton = new JButton("Okay");
			okayButton.addActionListener(new OkayListener());
			exitButton = new JButton("Exit");
			exitButton.addActionListener(new ExitListener());
			
			//Add elements to window
			add(okayButton);
			add(exitButton);
		}
	}
	
	//------------------ ACTION LISTENERS -------------------
	/**
	 * Inner class which handles the event created when
	 * an element of the code combo box is selected. 
	 */
	private class CodesListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			codeSelection = codeBox.getSelectedIndex();
			if(codeSelection == 0)
				codeClass = new ShiftCode();
			else if(codeSelection == 1)
				codeClass = new PhoneCode();
			else if(codeSelection == 2)
				codeClass = new MorseCode();
			else if(codeSelection == 3)
				codeClass = new LanguageCode();
				
		}
	}
	
	/**
	 * Inner class which handles the event created when
	 * an element of the option combo box is selected. 
	 */
	private class OptionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int selection = optionBox.getSelectedIndex();
			if(selection == 0)
				encode = true;
			else if(selection == 1)
				encode = false;	
		}
	}
	
	/**
	 * Inner class which handles the event created when
	 * the okay button is pressed and process the user's
	 * request.
	 */
	private class OkayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String s;
			if(encode == true && (codeSelection == 0 || codeSelection == 2))
				s = codeClass.encodeText(codeField.getText());
			else if(encode == true)
			{
				JOptionPane.showMessageDialog(null, "This option is disabled, try switching to \"Decode\".", "Error", JOptionPane.ERROR_MESSAGE);
				s = "";
			}
			else if(encode == false && codeSelection == 2)
			{
				JOptionPane.showMessageDialog(null, "This option is disabled, try switching to \"Encode\".", "Error", JOptionPane.ERROR_MESSAGE);
				s = "";
			}
			else
				s = codeClass.decodeText(codeField.getText());
			
			resultField.setText(s);
		}
	}
	
	/**
	 * Inner class which handles the event created when
	 * the exit button is pressed and exits the program.
	 */
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	/**
	 * Main class which starts the CodeGUIWindow program
	 */
	public static void main(String[] args)
	{
		new CodeGUIWindow();
	}
}
