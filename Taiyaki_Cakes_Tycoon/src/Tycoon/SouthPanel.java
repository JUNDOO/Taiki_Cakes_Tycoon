package Tycoon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SouthPanel extends JPanel{
	public static String allfree1=""; public static String allfree5=""; public static String allfree9=""; // �гΰ� �񱳵� �ܾ�.
	public static String allfree2=""; public static String allfree6=""; public static String allfree10=""; // �гΰ� �񱳵� �ܾ�.
	public static String allfree3=""; public static String allfree7=""; public static String allfree11=""; // �гΰ� �񱳵� �ܾ�.
	public static String allfree4=""; public static String allfree8=""; public static String allfree12=""; // �гΰ� �񱳵� �ܾ�.
	public SouthPanel(){
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		JLabel l = new JLabel("�ܾ� �Է� : ");
		add(l);
		JTextField tf = new JTextField(20);
		add(tf);
		MyActionListener myactionlistener = new MyActionListener();
		tf.addActionListener(myactionlistener);
	}
	private class MyActionListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			JTextField tf = (JTextField)arg0.getSource();
			
			if(tf.getText().equals(Panel1.LeftLabel1.getText())){
				allfree1 = tf.getText();
				Panel1.LeftLabel1.setText("�Է¿Ϸ�!!");
				Panel1.LeftLabel1.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel2.LeftLabel2.getText())){
				allfree2 = tf.getText();
				Panel2.LeftLabel2.setText("�Է¿Ϸ�!!");
				Panel2.LeftLabel2.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel3.LeftLabel3.getText())){
				allfree3 = tf.getText();
				Panel3.LeftLabel3.setText("�Է¿Ϸ�!!");
				Panel3.LeftLabel3.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel4.LeftLabel4.getText())){
				allfree4 = tf.getText();
				Panel4.LeftLabel4.setText("�Է¿Ϸ�!!");
				Panel4.LeftLabel4.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel5.LeftLabel5.getText())){
				allfree5 = tf.getText();
				Panel5.LeftLabel5.setText("�Է¿Ϸ�!!");
				Panel5.LeftLabel5.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel6.LeftLabel6.getText())){
				allfree6 = tf.getText();
				Panel6.LeftLabel6.setText("�Է¿Ϸ�!!");
				Panel6.LeftLabel6.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel7.LeftLabel7.getText())){
				allfree7 = tf.getText();
				Panel7.LeftLabel7.setText("�Է¿Ϸ�!!");
				Panel7.LeftLabel7.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel8.LeftLabel8.getText())){
				allfree8 = tf.getText();
				Panel8.LeftLabel8.setText("�Է¿Ϸ�!!");
				Panel8.LeftLabel8.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel9.LeftLabel9.getText())){
				allfree9 = tf.getText();
				Panel9.LeftLabel9.setText("�Է¿Ϸ�!!");
				Panel9.LeftLabel9.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel10.LeftLabel10.getText())){
				allfree10 = tf.getText();
				Panel10.LeftLabel10.setText("�Է¿Ϸ�!!");
				Panel10.LeftLabel10.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel11.LeftLabel11.getText())){
				allfree11 = tf.getText();
				Panel11.LeftLabel11.setText("�Է¿Ϸ�!!");
				Panel11.LeftLabel11.setForeground(Color.GREEN);
				tf.setText("");
			}
			else if(tf.getText().equals(Panel12.LeftLabel12.getText())){
				allfree12 = tf.getText();
				Panel12.LeftLabel12.setText("�Է¿Ϸ�!!");
				Panel12.LeftLabel12.setForeground(Color.GREEN);
				tf.setText("");
			}
			else tf.setText(""); // �ܾ� �߸��ĵ� ������.
		}
	}
}