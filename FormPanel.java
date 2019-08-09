package App;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.ref.PhantomReference;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

public class FormPanel extends JPanel {

	private JLabel nameLable;
	private JLabel occupationLable;
	private JLabel mobilenoLable;

	private JTextField nameTextfield;
	private JTextField occupationTextfiled;
	private JTextField mobiletextfield;
	private JButton okbtn;

	private FormListener formListener;              //calling class
	private JList ageList;
	private JComboBox empCombo;
	private JCheckBox citizenCheck;
	private JTextField taxFild;
	private JLabel taxLabel;
	
	private JRadioButton maleRadio;
	private JRadioButton femaleRadio;
	private ButtonGroup gendergroup;

	public FormPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		Border inner = BorderFactory.createTitledBorder("Add Person");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));

		nameLable = new JLabel("Name-: ");
		occupationLable = new JLabel("Occupation-: ");
		nameTextfield = new JTextField(10);
		occupationTextfiled = new JTextField(10);
	    
		
	    ageList = new JList();
		empCombo = new JComboBox();
		mobilenoLable = new JLabel("Phone No-: ");
	    mobiletextfield = new JTextField(10); 
	
		citizenCheck = new JCheckBox();
		taxFild = new JTextField(10);
	    taxLabel = new JLabel("UIDAI No : ");
	    
	    maleRadio = new JRadioButton("Male");
	    femaleRadio = new JRadioButton("Female");
	    gendergroup = new ButtonGroup();
	    // set up gender 
	    gendergroup.add(maleRadio);
	    maleRadio.setActionCommand("male");
	    femaleRadio.setActionCommand("Female");
	    gendergroup.add(femaleRadio);
	    
	    maleRadio.setSelected(true);
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    //set up tax ID
	    taxLabel.setEnabled(false);
	    taxFild.setEnabled(false);
	    citizenCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				boolean isTicked = citizenCheck.isSelected();
				taxLabel.setEnabled(isTicked);
				taxFild.setEnabled(isTicked);
			}
		});
		
		
		
		
		
		
		//set up list box
		DefaultListModel ageModel = new DefaultListModel();
		ageModel.addElement(new AgeCategory(0,"Under 18"));
		ageModel.addElement(new AgeCategory(1,"18 to 65"));
		ageModel.addElement(new AgeCategory(2,"65 to over"));
		ageList.setModel(ageModel);
		ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setPreferredSize(new Dimension(115, 66));
        ageList.setSelectedIndex(1);
	    // set up combobox
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Un-Employed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        empCombo.setEditable(true);
       
        
        
        okbtn = new JButton("Ok");
		okbtn.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {

				String name = nameTextfield.getText();
				String occupation = occupationTextfiled.getText();
 				AgeCategory ageCat =(AgeCategory) ageList.getSelectedValue();
 				String empCat = (String) empCombo.getSelectedItem();
 				String taxId =taxFild.getText();
 				boolean IndCitizen = citizenCheck.isSelected();
		
 				String gender =gendergroup.getSelection().getActionCommand();
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				
 				FormEvent ev = new FormEvent(this, name, occupation , ageCat.getId(), empCat,taxId, IndCitizen,gender);
				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}

			}
		});

       layoutComponents();
	}
	public void layoutComponents(){
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		/////////////////////////////////// 1
		/////////////////////////////////// row////////////////////////////////////
		gc.gridx = 0;
		
		gc.fill = GridBagConstraints.NONE;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(nameLable, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(nameTextfield, gc);
		/////////////////////////////////// 2
		/////////////////////////////////// row////////////////////////////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(occupationLable, gc);
		gc.gridx = 1;
		gc.gridy = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(occupationTextfiled, gc);

		/////////////////////////////////// 3
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
	
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Age : "), gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(ageList, gc);
  
		/////////////////////////////////// 3_1
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Employment : "), gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(empCombo, gc);


		/////////////////////////////////// 3_1_mobile
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(mobilenoLable, gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(mobiletextfield, gc);


		/////////////////////////////////// 3_2
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(new JLabel("Indian  CitiZen : "), gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(citizenCheck, gc);


		/////////////////////////////////// 3_3
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		add(taxLabel, gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(taxFild, gc);

        
		/////////////////////////////////// 3_4
		/////////////////////////////////// row////////////////////////////////////
	
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.05;
		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 5);
		gc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Gender : "), gc);
	
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(maleRadio, gc);

		/////////////////////////////////// row////////////////////////////////////
		
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(femaleRadio, gc);
	
		/////////////////////////////////// 4
		/////////////////////////////////// row////////////////////////////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 2.0;
		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(okbtn, gc);		
	}

	public void setFormListener(FormListener listener) {
		this.formListener = listener;
	}

}
class AgeCategory{
	private int id;
	private String text;
	public AgeCategory(int id ,String text){
		this.id =id;
		this.text =text;
	}
	public int getId() {
		return id;
	}
	public String toString(){
		return text;
	}
}
