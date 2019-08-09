package App;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener  {

	private  JButton hellobtn;
	private  JButton bybtn;
	
	
	//private TextPanel textpanel;//class
	
	private StringListener textListener;//class
	
	public ToolBar(){
		setBorder(BorderFactory.createEtchedBorder());
	
		hellobtn = new JButton("Hello");
		bybtn = new JButton("by");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(hellobtn);
		add(bybtn);
		
		hellobtn.addActionListener(this);
		bybtn.addActionListener(this);
	}
	
//	public void settextPanel(TextPanel textpanel){
//
//		this.textpanel=textpanel;
//	}
	public void setStringListener(StringListener listener){
		this.textListener =listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		
		if(clicked ==hellobtn){
		
			if(textListener!=null){
			 textListener.textEmmited("hello\n");
				
			}
			//	textpanel.appendtext("Hello\n");
		}else if(clicked==bybtn){
	//	textpanel.appendtext("byy...\n");
		 if(textListener!=null){
			 textListener.textEmmited("byy....\n");
		 }
		
		}
	}
}





























