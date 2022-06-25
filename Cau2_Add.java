package ktra_demo1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

public class Cau2_Add extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3;
	JButton btn1,btn2;
	JTextField txt1,txt2,txt3;
	JPanel pn1,pn2,pn3,pn4,pn5,pn;
	
	public void GUI() {
		lb1 = new JLabel("Code");
		lb2 = new JLabel("Name");
		lb3 = new JLabel("Credit");
		
		txt1 = new JTextField(8);
		txt2 = new JTextField(20);
		txt3 = new JTextField(8);
		
		btn1 = new JButton("Add");
		btn2 = new JButton("Clear");
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		pn = new JPanel(new BorderLayout());
		pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn4 = new JPanel(new GridLayout(3, 1));
		pn5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pn1.add(lb1);
		pn1.add(txt1);
		
		pn2.add(lb2);
		pn2.add(txt2);
		
		pn3.add(lb3);
		pn3.add(txt3);
		
		pn4.add(pn1);
		pn4.add(pn2);
		pn4.add(pn3);
		
		pn5.add(btn1);
		pn5.add(btn2);
		
		pn.add(pn5, BorderLayout.SOUTH);
		pn.add(pn4, BorderLayout.NORTH);
		
		add(pn);
		setSize(280,180);
	}

	public Cau2_Add(String title) {
		super(title);
		GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn1) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data_kt","root","");
				java.sql.Statement stmt = con.createStatement();
				String sql = "insert into table1 values('" + txt1.getText() + "','" + txt2.getText() + "', " + txt3.getText() + ")";
				stmt.executeUpdate(sql);
			} catch (Exception ex) {
			}
		}
		if(e.getSource() == btn2) {
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
		}
	}
	
}
