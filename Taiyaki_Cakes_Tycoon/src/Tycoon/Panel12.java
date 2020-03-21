package Tycoon;
import javax.swing.*;
import java.awt.*;

public class Panel12 extends JPanel{
	public static JLabel LeftLabel12 = new JLabel();
	public static JLabel RightLabel12 = new JLabel();
	public static JPanel Panel12_1 = new JPanel(new CardLayout());   //�̹��� ���� �г��� CardLayout���� �ٲ�
	
	//�ؾ��ü����
	public Panel12(){
		JPanel Panel12_2 = new JPanel();
		setLayout(new BorderLayout());
		Panel12_2.setBackground(Color.DARK_GRAY); //�г�2 �ٹ̱� ����
		LeftLabel12.setOpaque(true);
		RightLabel12.setOpaque(true);
		LeftLabel12.setBackground(Color.DARK_GRAY);
		LeftLabel12.setForeground(Color.WHITE);
		LeftLabel12.setFont(new Font("����",Font.BOLD,15));
		RightLabel12.setBackground(Color.DARK_GRAY);
		RightLabel12.setForeground(Color.YELLOW);
		RightLabel12.setFont(new Font("����",Font.BOLD,13));

		Panel12_2.add(LeftLabel12); Panel12_2.add(RightLabel12); 
		
		add(Panel12_1, BorderLayout.CENTER);
		add(Panel12_2, BorderLayout.SOUTH);
		
		Th12 thth12 = new Th12();
		Thread th12 = new Thread(thth12);
		th12.start();
		
	}
}

class Th12 extends JPanel implements Runnable{
	private ImageIcon empty= new ImageIcon(Main.class.getResource("../images/FISHNULL.png"));	//�� ����
	private ImageIcon step1= new ImageIcon(Main.class.getResource("../images/FISH00.png"));		//���
	private ImageIcon step2= new ImageIcon(Main.class.getResource("../images/FISH11.png"));		//�ͱ����
	private ImageIcon step3= new ImageIcon(Main.class.getResource("../images/FISH22.png"));		//����
	private ImageIcon step4= new ImageIcon(Main.class.getResource("../images/FISH33.png"));		//���� (�����߰�)
	private ImageIcon burn= new ImageIcon(Main.class.getResource("../images/FISHBURN.png"));	//�¿�
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
				if(MainPanel.kcheck()==true)return; // �� Ÿ�̸Ӱ� �ى����
				String word = MainPanel.wordlist1[(int)(Math.random()*MainPanel.wordlist1.length)];
				Panel12.LeftLabel12.setText(word);
				Panel12.LeftLabel12.setForeground(Color.WHITE);
				Panel12.Panel12_1.add(label1);
				try {
					Thread.sleep(Timer.timer); // �� �ܾ� �� ��� �ð�
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				try {
				if(SouthPanel.allfree12.equals(word)) { //�´� �ܾ ġ��
					escape=0; this.stage++;
					
				}
				else if(SouthPanel.allfree12.equals(null) || !SouthPanel.allfree12.equals(word)){ //�ƹ��͵� �� �ưų�, Ʋ�� �ܾ ġ��
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
			case 0 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label1); break; // ? -> �� ����
			case 1 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label2); break; // �� ���� -> ���
			case 2 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label3); break; // ��� -> �ͱ����
			case 3 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label4); break; // �ͱ���� -> ����
			case 4 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label5); break; // ���� -> ���� (�ϼ�)
			case 5 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label1); this.stage=0; EastPanel.SumScore(); break; //���� (�ϼ�) -> �� ���� 1�� �߰�
			case 7 : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label6); this.stage=-1; break; // Ÿ���� ����
			default : Panel12.Panel12_1.removeAll(); Panel12.Panel12_1.add(label1); this.stage=0; break;
			}
		}
	}
}