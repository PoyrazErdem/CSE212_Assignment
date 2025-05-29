import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Menuprinter extends JFrame{
	private static JPanel mainPanel = new JPanel();
	private JButton addBook = new JButton("Add a new book");
	private JButton addArticle = new JButton("Add a new online article");
	private JButton createMember = new JButton("Check out a book");
	private JButton checkoutBook = new JButton("Check out a book");
	private JButton returnBook = new JButton("Return a book");
	private JButton checkoutArticle = new JButton("Give access to an online article");
	private JButton returnArticle = new JButton("End an online article access");
	private JButton displayAll = new JButton("Display all accounts");
	private JButton displayLibrary = new JButton("Display library database");
	private JButton overduePayment = new JButton("Members with overdue payments");
	private JButton exit = new JButton("Exit");
	
	public Menuprinter() {
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JButton[] buttons = {
			    addBook, addArticle, createMember, checkoutBook,returnBook, checkoutArticle, returnArticle,
			    displayAll, displayLibrary, overduePayment, exit
	    };
		
		ActionHandler handler = new ActionHandler();
        
		for (JButton b : buttons) {
	        b.setBorderPainted(false);
	        b.setContentAreaFilled(false);
	        b.setFocusPainted(false);
	        b.setOpaque(false); 
	        b.setBackground(new Color(0, 0, 0, 0)); 
	        b.setBackground(Color.WHITE);	
            b.addActionListener(handler);
            
            b.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                	b.setForeground(Color.RED);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                	b.setForeground(Color.BLACK);	
                }

                @Override
                public void mouseExited(MouseEvent e) {
                	b.setForeground(Color.BLACK);
                }
            });
	        mainPanel.add(b);	
	    }

		this.add(mainPanel);
		this.setTitle("Library Menegment System");
		this.setSize(350, 350);
		setLocationRelativeTo(null);	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
	}
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent	event) {
			if(event.getSource() == addBook) {
				
			}
			else if(event.getSource() == addArticle) {
				
			}
			else if(event.getSource() == checkoutBook) {
				
			}
			else if(event.getSource() == returnBook) {
				
			}
			else if(event.getSource() == checkoutArticle) {
				
			}
			else if(event.getSource() == displayAll) {
				
			}
			else if(event.getSource() == displayLibrary) {
				
			}
			else if(event.getSource() == overduePayment) {
				
			}
			else if(event.getSource() == exit) {
				System.exit(0);
			}

		}
	}
}
