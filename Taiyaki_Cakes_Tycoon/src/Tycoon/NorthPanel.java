package Tycoon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NorthPanel extends JPanel{
	public ImageIcon Northimage= new ImageIcon(Main.class.getResource("../images/Northtitle3.png"));	//�� ����
	public NorthPanel(){
		setBackground(Color.white);
		setLayout(new FlowLayout());
		JLabel l = new JLabel(Northimage);
		l.setFont(new Font("�ü�ü", Font.BOLD, 50));
		l.setOpaque(true);
		add(l);	
	}
}
