package Tycoon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
	
class FImage extends JPanel{
	private ImageIcon empty = new ImageIcon("../images/null.png");//�����
	private Image img = empty.getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	
//public static Graphics screenGraphic2;//�ؾ �׸� �׷���	
	
//	public static Image empty=new ImageIcon(Main.class.getResource("../images/���ϳ�.jpg")).getImage();//�����
//	public static ImageIcon step1=new ImageIcon(Main.class.getResource("../images/pap.jpg"));//�ϰ� �а���
//	public static ImageIcon step2=new ImageIcon(Main.class.getResource("../images/floor1.jpg"));//�а��� �� ������ �а���
//	public static ImageIcon step3=new ImageIcon(Main.class.getResource("../images/lift.jpg"));//�Ѹ� ����
//	public static ImageIcon step4=new ImageIcon(Main.class.getResource("../images/lift2.jpg"));//�ٸ����������
//	public static ImageIcon step5=new ImageIcon(Main.class.getResource("../images/amlost.jpg"));//������
//	//ImageIcon step6=new ImageIcon(Main.class.getResource("../images/almost.jpg"));//������
//	ImageIcon burn=new ImageIcon(Main.class.getResource("../images/burn.jpg"));//ź����
//	@Override

	//�ؾ�� �׸������� �׷����Լ�

}
