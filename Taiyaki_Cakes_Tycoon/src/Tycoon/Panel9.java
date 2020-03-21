package Tycoon;
import javax.swing.*;
import java.awt.*;

public class Panel9 extends JPanel{
	public static JLabel LeftLabel9 = new JLabel();
	public static JLabel RightLabel9 = new JLabel();
	public static JPanel Panel9_1 = new JPanel(new CardLayout());   //�̹��� ���� �г��� CardLayout���� �ٲ�
	
	//�ؾ��ü����
	public Panel9(){
		JPanel Panel9_2 = new JPanel();
		setLayout(new BorderLayout());
		Panel9_2.setBackground(Color.DARK_GRAY); //�г�2 �ٹ̱� ����
		LeftLabel9.setOpaque(true);
		RightLabel9.setOpaque(true);
		LeftLabel9.setBackground(Color.DARK_GRAY);
		LeftLabel9.setForeground(Color.WHITE);
		LeftLabel9.setFont(new Font("����",Font.BOLD,15));
		RightLabel9.setBackground(Color.DARK_GRAY);
		RightLabel9.setForeground(Color.YELLOW);
		RightLabel9.setFont(new Font("����",Font.BOLD,13));

		Panel9_2.add(LeftLabel9); Panel9_2.add(RightLabel9); 
		
		add(Panel9_1, BorderLayout.CENTER);
		add(Panel9_2, BorderLayout.SOUTH);
		
		Th9 thth9 = new Th9();
		Thread th9 = new Thread(thth9);
		th9.start();
		
	}
}

class Th9 extends JPanel implements Runnable{
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
				Panel9.LeftLabel9.setText(word);
				Panel9.LeftLabel9.setForeground(Color.WHITE);
				Panel9.Panel9_1.add(label1);
				try {
					Thread.sleep(Timer.timer); // �� �ܾ� �� ��� �ð�
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				try {
				if(SouthPanel.allfree9.equals(word)) { //�´� �ܾ ġ��
					escape=0; this.stage++;
					
				}
				else if(SouthPanel.allfree9.equals(null) || !SouthPanel.allfree9.equals(word)){ //�ƹ��͵� �� �ưų�, Ʋ�� �ܾ ġ��
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
			case 0 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label1); break; // ? -> �� ����
			case 1 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label2); break; // �� ���� -> ���
			case 2 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label3); break; // ��� -> �ͱ����
			case 3 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label4); break; // �ͱ���� -> ����
			case 4 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label5); break; // ���� -> ���� (�ϼ�)
			case 5 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label1); this.stage=0; EastPanel.SumScore(); break; //���� (�ϼ�) -> �� ���� 1�� �߰�
			case 7 : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label6); this.stage=-1; break; // Ÿ���� ����
			default : Panel9.Panel9_1.removeAll(); Panel9.Panel9_1.add(label1); this.stage=0; break;
			}
		}
	}
}