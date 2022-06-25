package ktra_demo1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Cau2_Search extends JFrame implements ActionListener{
	JLabel lb1,lb2,lb3;
	JButton btn1;
	JTextField txt1,txt2,txt3;
	JPanel pn1,pn2,pn3,pn;
	
	public void GUI() {
		lb1 = new JLabel("Enter code");
		lb2 = new JLabel("Course name");
		lb3 = new JLabel("Credit");
		
		txt1 = new JTextField(8);
		txt2 = new JTextField(18);
		txt2.setEnabled(false);
		txt3 = new JTextField(8);
		txt3.setEnabled(false);
		
		btn1 = new JButton("Search");
		btn1.addActionListener(this);
		
		pn = new JPanel(new GridLayout(3,1));
		pn1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pn3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pn1.add(lb1);
		pn1.add(txt1);
		pn1.add(btn1);
		
		pn2.add(lb2);
		pn2.add(txt2);
		
		pn3.add(lb3);
		pn3.add(txt3);
		
		pn.add(pn1);
		pn.add(pn2);
		pn.add(pn3);
		
		add(pn);
		setSize(300,150);
	}

	public Cau2_Search(String title) {
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
				String sql = "select * from table1 where Code = '" + txt1.getText() + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					txt2.setText(rs.getString("Name"));
					txt3.setText(String.valueOf(rs.getInt("Credit")));
				}
			} catch (Exception ex) {
			}
		}
	}

}
