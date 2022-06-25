package ktra_demo1;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.*;

public class Cau2_Display extends JFrame{
	JLabel lb;
	JTextArea ta;
	JPanel pn,pn1;
	
	public void GUI() {
		lb = new JLabel("List of all course (order by Credit)");
		
		ta = new JTextArea(12,40);
		
		pn = new JPanel(new FlowLayout());
		pn1 = new JPanel(new FlowLayout());
		
		pn.add(lb);
		
		pn1.add(ta);
		
		add(pn, BorderLayout.NORTH);
		add(pn1, BorderLayout.CENTER);
		setSize(400,270);
		
		try {
			ta.setText("");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/data_kt","root","");
			java.sql.Statement stmt = con.createStatement();
			String sql = "select * from table1";
			ResultSet rs = stmt.executeQuery(sql);
			java.sql.ResultSetMetaData rsmd = rs.getMetaData();
			int socot = rsmd.getColumnCount();
			while(rs.next()) {
				for(int i = 1; i<socot; i++) {
					ta.setText(ta.getText() + rs.getObject(i) + " | ");
				}
				ta.setText(ta.getText() + rs.getObject(socot) + "\n");
			}
		} catch (Exception ex) {
		}
	}

	public Cau2_Display(String title){
		super(title);
		GUI();
	}



}
