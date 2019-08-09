package App;


import java.awt.BorderLayout;
import java.awt.ScrollPane;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel{
private JTextArea textarea;

	
	public TextPanel(){
     
		textarea = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(textarea),BorderLayout.CENTER);
	}
	public void appendtext(String text){
		textarea.append(text);
	}
}
