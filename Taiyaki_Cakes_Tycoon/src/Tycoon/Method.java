package Tycoon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Method extends JDialog{
	public ImageIcon Northimage= new ImageIcon(Main.class.getResource("../images/Northtitle3.png"));	//�� ����
	public ImageIcon empty= new ImageIcon(Main.class.getResource("../images/FISHNULL.png"));	//�� ����
	public ImageIcon step1= new ImageIcon(Main.class.getResource("../images/FISH00.png"));		//���
	public ImageIcon step2= new ImageIcon(Main.class.getResource("../images/FISH11.png"));		//�ͱ����
	public ImageIcon step3= new ImageIcon(Main.class.getResource("../images/FISH22.png"));		//����
	public ImageIcon step4= new ImageIcon(Main.class.getResource("../images/FISH33.png"));		//���� (�����߰�)
	public ImageIcon burn= new ImageIcon(Main.class.getResource("../images/FISHBURN.png"));	//�¿�
	public JLabel label1=new JLabel(empty);		//�� ����
	public JLabel label2=new JLabel(step1);		//���
	public JLabel label3=new JLabel(step2);		//�ͱ����
	public JLabel label4=new JLabel(step3);		//����
	public JLabel label5=new JLabel(step4);		//���� (���� �߰�)
	public JLabel label6=new JLabel(burn);		//�¿�
	Method(){
		setTitle("���� ���");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel north = new JPanel();
		north.setBackground(Color.white);
		
		JLabel Northlabel = new JLabel(Northimage);
		Northlabel.setOpaque(true);
		
		north.add(Northlabel);
		c.add(north,BorderLayout.NORTH);	

		JPanel center = new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(new GridLayout(3, 5));
		JPanel south = new JPanel();
		south.setLayout(new GridLayout(5, 1));
		
		JLabel l1 = new JLabel(empty); l1.setOpaque(true); /*l1.setBackground(Color.YELLOW);*/ l1.setFont(new Font("HY����M",Font.PLAIN,20)); l1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l2 = new JLabel("��������>"); l2.setOpaque(true); l2.setBackground(Color.LIGHT_GRAY); l2.setFont(new Font("HY����M",Font.BOLD,20)); l2.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l3 = new JLabel(step1); l3.setOpaque(true); /*l3.setBackground(Color.YELLOW);*/ l3.setFont(new Font("HY����M",Font.PLAIN,20)); l3.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l4 = new JLabel("��������>"); l4.setOpaque(true); l4.setBackground(Color.LIGHT_GRAY); l4.setFont(new Font("HY����M",Font.BOLD,20)); l4.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l5 = new JLabel(step2); l5.setOpaque(true); /*l5.setBackground(Color.YELLOW);*/ l5.setFont(new Font("HY����M",Font.PLAIN,20)); l5.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l6 = new JLabel("��������>"); l6.setOpaque(true); l6.setBackground(Color.LIGHT_GRAY); l6.setFont(new Font("HY����M",Font.BOLD,20)); l6.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l7 = new JLabel(step3); l7.setOpaque(true); /*l7.setBackground(Color.YELLOW);*/ l7.setFont(new Font("HY����M",Font.PLAIN,20)); l7.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l8 = new JLabel("��������>"); l8.setOpaque(true); l8.setBackground(Color.LIGHT_GRAY); l8.setFont(new Font("HY����M",Font.BOLD,20)); l8.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l9 = new JLabel(step4); l9.setOpaque(true); /*l9.setBackground(Color.YELLOW);*/ l9.setFont(new Font("HY����M",Font.PLAIN,20)); l9.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l10 = new JLabel("�� �� �� �Է��ϸ�?"); l10.setOpaque(true); l10.setBackground(Color.LIGHT_GRAY); l10.setFont(new Font("HY����M",Font.BOLD,20)); l10.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l11 = new JLabel(empty); l11.setOpaque(true); /*l11.setBackground(Color.YELLOW);*/ l11.setFont(new Font("HY����M",Font.PLAIN,20)); l11.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l12 = new JLabel("�ϼ�! (1�� ȹ��)"); l12.setOpaque(true); l12.setBackground(Color.LIGHT_GRAY); l12.setFont(new Font("HY����M",Font.BOLD,20)); l12.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l13 = new JLabel(burn); l13.setOpaque(true); /*l13.setBackground(Color.WHITE); */l13.setFont(new Font("HY����M",Font.PLAIN,20)); l13.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l14 = new JLabel("<���� ź ��"); l14.setOpaque(true); l14.setBackground(Color.LIGHT_GRAY); l14.setFont(new Font("HY����M",Font.BOLD,20)); l14.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel l18 = new JLabel("   "); l18.setOpaque(true); l18.setBackground(Color.DARK_GRAY); l18.setFont(new Font("HY����M",Font.PLAIN,20)); l18.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel l15 = new JLabel("���ӹ�� : �� ĭ���� ���õǴ� �ܾ �ð� ���� �Է��ϸ� �ش� ĭ�� ���� �ܰ�� ����˴ϴ�."); l15.setOpaque(true); l15.setBackground(Color.YELLOW); l15.setFont(new Font("HY����M",Font.PLAIN,20)); l15.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel l16 = new JLabel("               ���������� �� ������ �� 1���� �߰��ǰ�, �¿�� �� �� �Է��Ͽ� �ٽ� �� ĭ���� ������ �մϴ�."); l16.setOpaque(true); l16.setBackground(Color.YELLOW); l16.setFont(new Font("HY����M",Font.PLAIN,20)); l16.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel l17 = new JLabel("               �ؾ�� �¿��� �ʰ� �ִ��� ���� ��������!"); l17.setOpaque(true); l17.setBackground(Color.YELLOW); l17.setFont(new Font("HY����M",Font.PLAIN,20)); l17.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel l20 = new JLabel("               ��ȯ�漳������ ���̵��� ������ �� �ְ�, ���� ���� ���� ���� �� �⺻ �ð��� �ΰ��˴ϴ�."); l20.setOpaque(true); l20.setBackground(Color.YELLOW); l20.setFont(new Font("HY����M",Font.PLAIN,20)); l20.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel l19 = new JLabel("               ��(�⺻ �ð� : ��ü 5��, �� ĭ�� 10��)"); l19.setOpaque(true); l19.setBackground(Color.YELLOW); l19.setFont(new Font("HY����M",Font.PLAIN,20)); l19.setHorizontalAlignment(SwingConstants.LEFT);
		
		center.add(l1); center.add(l2); center.add(l3); center.add(l4); center.add(l5);
		center.add(l6); center.add(l7); center.add(l8); center.add(l9); center.add(l10);
		center.add(l11); center.add(l12); center.add(l13); center.add(l14); center.add(l18);
		
		south.add(l15); south.add(l16); south.add(l17); south.add(l20); south.add(l19);
		c.add(center, BorderLayout.CENTER);
		c.add(south, BorderLayout.SOUTH);
		setSize(1120, 720);
		setVisible(true);
	}
}