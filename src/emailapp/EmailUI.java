package emailapp;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class EmailUI implements ActionListener, Runnable{
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JButton button;
	private JTextField textField;
	private String input;
	private JTextArea textArea;
	
	public EmailUI(String title, int width, int height)
	{
		input = "";
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setTitle(title);
		panel = new JPanel();
		label = new JLabel("Question");
		panel.add(label);
		textField = new JTextField();
		int textFieldWidth = 100;
		int textFieldHeight = 20;
		//textField.setMinimumSize(new Dimension(50, 100));
		textField.setPreferredSize(new Dimension(textFieldWidth, textFieldHeight));
		panel.add(textField);
		button = new JButton("Send");
		button.setActionCommand("Send");
		button.addActionListener(this);
		panel.add(button);
		textArea = new JTextArea();
		int textAreaWidth = 400;
		int textAreaHeight = 400;
		textArea.setPreferredSize(new Dimension(textAreaWidth, textAreaHeight));
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		panel.add(textArea);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		panel.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "sent");
//		panel.getActionMap().put("sent", new SendAction());
		panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "sent");
		panel.getActionMap().put("sent", new SendAction());
	}
	
	public class SendAction extends AbstractAction
	{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			input = textField.getText();
			textField.setText("");		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals("Send"))
		{
			input = textField.getText();
			textField.setText("");			
		}
		
	}

	@Override
	public void run() {
		frame.setVisible(true);
	}
	
	public String getInput()
	{
		String output = "";
		if(!input.isEmpty())
		{
			output = input;
			input = "";
		}
		return output;
	}	
	
	public void setLabelText(String text)
	{
		label.setText(text);
	}
	
	public void addAreaText(String text)
	{
		textArea.append(text + "\n");
	}
	
	public Font getTextAreaFont()
	{
		return textArea.getFont();
	}
	
	public void setTextAreaFont(Font font)
	{
		textArea.setFont(font);
	}
}
