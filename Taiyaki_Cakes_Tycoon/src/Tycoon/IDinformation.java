package Tycoon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IDinformation extends JDialog{
	private String grade="";
	public IDinformation() { //�⺻ ������
		setTitle("                             �� ���� !!!");
		setLocationRelativeTo(null); // ��ü ������ â�� ��� �߰��ϱ�.
		Container c = getContentPane();
		c.setLayout(new GridLayout(2,2,0,5));
		if(EastPanel.score>=20)grade="A+";
		else if (EastPanel.score<20 && EastPanel.score>=15)grade="A";
		else if (EastPanel.score<15 && EastPanel.score>=10)grade="B+";
		else if (EastPanel.score<10 && EastPanel.score>=7)grade="B";
		else if (EastPanel.score<7 && EastPanel.score>=4)grade="C+";
		else if (EastPanel.score<4 && EastPanel.score>=2)grade="C";
		else grade="F";
		
		JLabel l1 = new JLabel("�ϼ��� �ؾ ���� : ");
		JLabel l2 = new JLabel(Integer.toString(EastPanel.score));
		JLabel l3 = new JLabel("         ��� : ");
		JLabel l4 = new JLabel(grade);
		l1.setFont(new Font("HY����M", Font.BOLD,16)); l2.setFont(new Font("���� ���", Font.BOLD,20)); 
		l3.setFont(new Font("HY����M", Font.BOLD,16)); l4.setFont(new Font("���� ���", Font.BOLD,20));
		l1.setOpaque(true); l2.setOpaque(true); l3.setOpaque(true); l4.setOpaque(true);
		l1.setBackground(Color.YELLOW); l2.setBackground(Color.CYAN); 
		l3.setBackground(Color.YELLOW); l4.setBackground(Color.CYAN); 
		l1.setHorizontalAlignment(SwingConstants.RIGHT); l2.setHorizontalAlignment(SwingConstants.CENTER); 
		l3.setHorizontalAlignment(SwingConstants.RIGHT); l4.setHorizontalAlignment(SwingConstants.CENTER); 
		c.add(l1); c.add(l2); c.add(l3); c.add(l4);
		setSize(400, 250);
		setVisible(true);
	}
}
