package ktra_demo1;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cau2 extends JFrame implements ActionListener{

	private JPanel contentPane,pn1;
	public static Cau2_Add add = new Cau2_Add("Add a new Course");
	public static Cau2_Display dis = new Cau2_Display("Display all Courses");
	public static Cau2_Search search = new Cau2_Search("Search course by course code");
	JLabel lbtitle;
	JButton btnAdd, btnDisplay, btnSearch, btnExit;
	
	public void GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 313);
		
		contentPane = new JPanel(new GridLayout(5, 1,0,20));
		contentPane.setBackground(UIManager.getColor("CheckBox.light"));
		contentPane.setBorder(new EmptyBorder(5, 5, 10, 5));
		setContentPane(contentPane);
		pn1 = new JPanel(new FlowLayout());
		
		JLabel lbtitle = new JLabel("Courses Management"); 
		lbtitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		pn1.add(lbtitle);
		contentPane.add(pn1);
		
		btnAdd = new JButton("Add a new Course");
		btnAdd.addActionListener(this);		
		btnAdd.setPreferredSize(new Dimension(250,20));
		contentPane.add(btnAdd);
		
		btnDisplay = new JButton("Display all Courses");
		btnDisplay.addActionListener(this);
		btnDisplay.setPreferredSize(new Dimension(250,20));
		contentPane.add(btnDisplay);
		
		btnSearch = new JButton("Search course by course code");
		btnSearch.addActionListener(this);
		btnSearch.setPreferredSize(new Dimension(250,20));
		contentPane.add(btnSearch);
		
		btnExit = new JButton("Exit Application");
		btnExit.addActionListener(this);
		btnExit.setPreferredSize(new Dimension(250,20));
		contentPane.add(btnExit);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new Cau2();
	}

	public Cau2() {
		GUI();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			add.setVisible(true);
		}
		if (e.getSource() == btnSearch) {
			search.setVisible(true);
		}
		if (e.getSource() == btnDisplay) {
			dis.setVisible(true);
		}
		if(e.getSource() == btnExit) {
			System.exit(0);
		}
	}

}
