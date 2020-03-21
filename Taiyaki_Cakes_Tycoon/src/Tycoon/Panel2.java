package Tycoon;
import javax.swing.*;
import java.awt.*;

public class Panel2 extends JPanel{
	public static JLabel LeftLabel2 = new JLabel();
	public static JLabel RightLabel2 = new JLabel();
	public static JPanel Panel2_1 = new JPanel(new CardLayout());   //�̹��� ���� �г��� CardLayout���� �ٲ�
	
	//�ؾ��ü����
	public Panel2(){
		JPanel Panel2_2 = new JPanel();
		setLayout(new BorderLayout());
		Panel2_2.setBackground(Color.DARK_GRAY); //�г�2 �ٹ̱� ����
		LeftLabel2.setOpaque(true);
		RightLabel2.setOpaque(true);
		LeftLabel2.setBackground(Color.DARK_GRAY);
		LeftLabel2.setForeground(Color.WHITE);
		LeftLabel2.setFont(new Font("����",Font.BOLD,15));
		RightLabel2.setBackground(Color.DARK_GRAY);
		RightLabel2.setForeground(Color.YELLOW);
		RightLabel2.setFont(new Font("����",Font.BOLD,13));

		Panel2_2.add(LeftLabel2); Panel2_2.add(RightLabel2); 
		
		add(Panel2_1, BorderLayout.CENTER);
		add(Panel2_2, BorderLayout.SOUTH);
		
		Th2 thth2 = new Th2();
		Thread th2 = new Thread(thth2);
		th2.start();
		
	}
}

class Th2 extends JPanel implements Runnable{
	private ImageIcon empty= new ImageIcon(Main.class.getResource("../images/FISHNULL.png"));	//�� ����
	private ImageIcon step1= new ImageIcon(Main.class.getResource("../images/FISH00.png"));		//���
	private ImageIcon step2= new ImageIcon(Main.class.getResource("../images/FISH11.png"));		//�ͱ����
	private ImageIcon step3= new ImageIcon(Main.class.getResource("../images/FISH22.png"));		//����
	private ImageIcon step4= new ImageIcon(Main.class.getResource("../images/FISH33.png"));		//���� (�����߰�)
	private ImageIcon burn= new ImageIcon(Main.class.getResource("../images/FISHBURN.png"));		//�¿�
	private JLabel label1=new JLabel(empty);		//�� ����
	private JLabel label2=new JLabel(step1);		//���
	private JLabel label3=new JLabel(step2);		//�ͱ����
	private JLabel label4=new JLabel(step3);		//����
	private JLabel label5=new JLabel(step4);		//���� (���� �߰�)
	private JLabel label6=new JLabel(burn);		//�¿�
	private int stage=0;  // ���� ����
	
	public void run() {
		while(true) {
			int escape = 1; // Ż�� ����.
			while(escape !=0) {
//				if(MainPanel.kcheck()==true)return; // �� Ÿ�̸Ӱ� �ى����
				String word = MainPanel.wordlist1[(int)(Math.random()*MainPanel.wordlist1.length)];
				Panel2.LeftLabel2.setText(word);
				Panel2.LeftLabel2.setForeground(Color.WHITE);
				Panel2.Panel2_1.add(label1);
				try {
					Thread.sleep(Timer.timer); // �� �ܾ� �� ��� �ð�
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				try {
				if(SouthPanel.allfree2.equals(word)) { //�´� �ܾ ġ��
					escape=0; this.stage++;
					
				}
				else if(SouthPanel.allfree2.equals(null) || !SouthPanel.allfree2.equals(word)){ //�ƹ��͵� �� �ưų�, Ʋ�� �ܾ ġ��
					if(this.stage==0) {
					escape=1; this.stage = 0; // �� ���¿��� ��� ��� �� (while���� ���������� �ʰ� ���ѷ���)
					} 
					else {
						escape=0; this.stage = 7; // ��ᰡ ��������� Ÿ�� ��
					}
				}
				}catch (NullPointerException e) {}
			}
			switch (this.stage) {
			case 0 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label1); break; // ? -> �� ����
			case 1 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label2); break; // �� ���� -> ���
			case 2 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label3); break; // ��� -> �ͱ����
			case 3 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label4); break; // �ͱ���� -> ����
			case 4 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label5); break; // ���� -> ���� (�ϼ�)
			case 5 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label1); this.stage=0; EastPanel.SumScore(); break; //���� (�ϼ�) -> �� ���� 1�� �߰�
			case 7 : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label6); this.stage=-1; break; // Ÿ���� ����
			default : Panel2.Panel2_1.removeAll(); Panel2.Panel2_1.add(label1); this.stage=0; break;
			}
		}
	}
}