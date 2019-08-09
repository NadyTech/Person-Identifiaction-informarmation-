package App;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controll.Controller;

public class Mainframe extends JFrame {
	
	//private  JButton clickme;
	
	private  TextPanel textpanel;      // class calling
//	private  ToolBar toolbar;        // class calling
    private FormPanel formpanel;     // class calling
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
    
    public Mainframe() {            //Constructor  declaration
		super("PERSON IMFORMATION DATA");
		setLayout(new BorderLayout());
    	
		textpanel = new TextPanel(); // class is initialising
	//	toolbar = new ToolBar();     // class is initialising
		formpanel = new FormPanel(); // class is initialising
        tablePanel = new TablePanel();
		fileChooser = new JFileChooser();	
        controller = new Controller();
        tablePanel.setData(controller.getPeople());
        
        tablePanel.setPersonTableListener(new PersonTableListener(){
        	public void rowdeleted(int row){
        	controller.removeperson(row);
        	}
        });
        fileChooser.addChoosableFileFilter(new PersonFileFilter());
		setJMenuBar(createMenuBar());
		
		
		/*toolbar.setStringListener(new StringListener() {
			public void textEmmited(String text) {  // calling methods from stringListener class
	        textpanel.appendtext(text);
			}
		});*/
		
		formpanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e){ // calling methods from FormListener
//				String name =e.getName();
//				String occupation =e.getOccupation();
//				int ageCat =e.getAgeCategory();
//				String empCat =e.getEmployeeCategory();
//				textpanel.appendtext(name +": "+occupation+": "+ageCat+", "+empCat+"\n");
//				System.out.println(e.getGender());
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});
		
		//clickme = new JButton("Click Me");

//		clickme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				textpanel.appendtext("hello Nadeem sir\n");
//			}
//		});
//	    add(clickme, BorderLayout.SOUTH);

		add(formpanel,BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
    	//add(toolbar, BorderLayout.NORTH);
    
		
		setMinimumSize(new Dimension(600,400 ));
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setVisible(true);
	}
    private JMenuBar createMenuBar(){
    	JMenuBar menubar = new JMenuBar();
   
    	
    	JMenu fileMenu = new JMenu("File");
    	JMenuItem exportDataItem = new JMenuItem("Export Data...");
    	JMenuItem importDataItem = new JMenuItem("Import Data...");
    	JMenuItem ExitItem = new JMenuItem("Exit");
        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
    	fileMenu.add(ExitItem); 
    	
    	JMenu windowMenu = new JMenu("Window");
    	JMenu showMenu = new JMenu("Show");
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
    	showFormItem.setSelected(true);
    	showMenu.add(showFormItem);
    	windowMenu.add(showMenu);
    	
    	menubar.add(fileMenu);
    	menubar.add(windowMenu);
    	showFormItem.addActionListener(new ActionListener() {
	  		public void actionPerformed(ActionEvent ev) {

	  			JCheckBoxMenuItem menuItem = 	(JCheckBoxMenuItem)ev.getSource();
				formpanel.setVisible(menuItem.isSelected());
			}
		});
    	
    	fileMenu.setMnemonic(KeyEvent.VK_F);
    	ExitItem.setMnemonic(KeyEvent.VK_X);
    	
    	ExitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
    	importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
    	importDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        if( fileChooser.showOpenDialog(Mainframe.this)==JFileChooser.APPROVE_OPTION){  		
		            try {
						controller.loadFromFile(fileChooser.getSelectedFile());
			            tablePanel.refresh();
		            } catch (IOException e) {
					   JOptionPane.showMessageDialog(Mainframe.this,"Could Not Loading Data From File","Error",JOptionPane.ERROR_MESSAGE);
					} 
		       
		        }
			}
		});
    	exportDataItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        if( fileChooser.showSaveDialog(Mainframe.this)==JFileChooser.APPROVE_OPTION){  		
		        	 try {
		    			
							controller.saveToFile (fileChooser.getSelectedFile());
						} catch (IOException e) {
						   JOptionPane.showMessageDialog(Mainframe.this,"Could Not Save Data From File","Error",JOptionPane.ERROR_MESSAGE);
						}
			       
		        	//System.out.println(fileChooser.getSelectedFile());
		        }
			}
		});
    
    	ExitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		  int action =JOptionPane.showConfirmDialog(Mainframe.this,"Do You really Want to Exit?" ,"Comfirmed Msg",JOptionPane.OK_CANCEL_OPTION);
	         
		  if(action==JOptionPane.OK_OPTION){
		  System.exit(0);			
		  }
			}
		});
    	
    	return menubar;
    	
    	
    }
}
