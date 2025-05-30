import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddMemberGUI extends JDialog{
	private JPanel mainPanel = new JPanel();
	private JLabel memberType = new JLabel("Select Member Type:");
	private JLabel memberName = new JLabel("Name:");
	private JLabel memberID = new JLabel("ID:");
	private JComboBox<String> enterMemberType = new JComboBox<>();
	public static JTextField enterMemberName = new JTextField(15);
	private JTextField enterMemberID = new JTextField(15);
	private JButton submitButton = new JButton("Submit");
	
	public AddMemberGUI(JFrame parent) {
		super(parent, "Add a New Article", true);
		
		enterMemberType.setEditable(false); 
		enterMemberType.addItem("Regular Member");
		enterMemberType.addItem("Student Member");
		enterMemberType.addItem("Academic Member");
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JPanel memberTypePanel = new JPanel();
		JPanel memberNamePanel = new JPanel();
		JPanel memberIDPanel = new JPanel();
		
		memberTypePanel.add(memberType);
		memberTypePanel.add(enterMemberType);
		
		memberNamePanel.add(memberName);
		memberNamePanel.add(enterMemberName);
		
		memberIDPanel.add(memberID);
		memberIDPanel.add(enterMemberID);
		
		mainPanel.add(memberTypePanel);
		mainPanel.add(memberNamePanel);
		mainPanel.add(memberIDPanel);
		mainPanel.add(submitButton);
		
		submitButton.addActionListener(e ->{
			
		});
		
		this.add(mainPanel);
		this.setTitle("Add New Member");
		this.setSize(300, 200);
		int x = parent.getX() + parent.getWidth();
	    int y = parent.getY();
	    this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}
}

