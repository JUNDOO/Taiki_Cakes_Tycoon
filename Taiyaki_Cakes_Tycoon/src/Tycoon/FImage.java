package Tycoon;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
	
class FImage extends JPanel{
	private ImageIcon empty = new ImageIcon("../images/null.png");//빈상태
	private Image img = empty.getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
	
//public static Graphics screenGraphic2;//붕어빵 그림 그래픽	
	
//	public static Image empty=new ImageIcon(Main.class.getResource("../images/빈하나.jpg")).getImage();//빈상태
//	public static ImageIcon step1=new ImageIcon(Main.class.getResource("../images/pap.jpg"));//팥과 밀가루
//	public static ImageIcon step2=new ImageIcon(Main.class.getResource("../images/floor1.jpg"));//밀가루 팥 그위에 밀가루
//	public static ImageIcon step3=new ImageIcon(Main.class.getResource("../images/lift.jpg"));//한면 익음
//	public static ImageIcon step4=new ImageIcon(Main.class.getResource("../images/lift2.jpg"));//다른면까지익음
//	public static ImageIcon step5=new ImageIcon(Main.class.getResource("../images/amlost.jpg"));//다익음
//	//ImageIcon step6=new ImageIcon(Main.class.getResource("../images/almost.jpg"));//다익음
//	ImageIcon burn=new ImageIcon(Main.class.getResource("../images/burn.jpg"));//탄상태
//	@Override

	//붕어빵을 그리기위한 그래픽함수

}
