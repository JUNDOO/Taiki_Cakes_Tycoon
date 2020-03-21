package Tycoon;
import javax.swing.*;
import java.awt.*;

public class Panel4 extends JPanel{
	public static JLabel LeftLabel4 = new JLabel();
	public static JLabel RightLabel4 = new JLabel();
	public static JPanel Panel4_1 = new JPanel(new CardLayout());   //�̹��� ���� �г��� CardLayout���� �ٲ�
	
	//�ؾ��ü����
	public Panel4(){
		JPanel Panel4_2 = new JPanel();
		setLayout(new BorderLayout());
		Panel4_2.setBackground(Color.DARK_GRAY); //�г�2 �ٹ̱� ����
		LeftLabel4.setOpaque(true);
		RightLabel4.setOpaque(true);
		LeftLabel4.setBackground(Color.DARK_GRAY);
		LeftLabel4.setForeground(Color.WHITE);
		LeftLabel4.setFont(new Font("����",Font.BOLD,15));
		RightLabel4.setBackground(Color.DARK_GRAY);
		RightLabel4.setForeground(Color.YELLOW);
		RightLabel4.setFont(new Font("����",Font.BOLD,13));

		Panel4_2.add(LeftLabel4); Panel4_2.add(RightLabel4); 
		
		add(Panel4_1, BorderLayout.CENTER);
		add(Panel4_2, BorderLayout.SOUTH);
		
		Th4 thth4 = new Th4();
		Thread th4 = new Thread(thth4);
		th4.start();
		
	}
}

class Th4 extends JPanel implements Runnable{
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
				Panel4.LeftLabel4.setText(word);
				Panel4.LeftLabel4.setForeground(Color.WHITE);
				Panel4.Panel4_1.add(label1);
				try {
					Thread.sleep(Timer.timer); // �� �ܾ� �� ��� �ð�
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				try {
				if(SouthPanel.allfree4.equals(word)) { //�´� �ܾ ġ��
					escape=0; this.stage++;
					
				}
				else if(SouthPanel.allfree4.equals(null) || !SouthPanel.allfree4.equals(word)){ //�ƹ��͵� �� �ưų�, Ʋ�� �ܾ ġ��
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
			case 0 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label1); break; // ? -> �� ����
			case 1 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label2); break; // �� ���� -> ���
			case 2 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label3); break; // ��� -> �ͱ����
			case 3 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label4); break; // �ͱ���� -> ����
			case 4 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label5); break; // ���� -> ���� (�ϼ�)
			case 5 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label1); this.stage=0; EastPanel.SumScore(); break; //���� (�ϼ�) -> �� ���� 1�� �߰�
			case 7 : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label6); this.stage=-1; break; // Ÿ���� ����
			default : Panel4.Panel4_1.removeAll(); Panel4.Panel4_1.add(label1); this.stage=0; break;
			}
		}
	}
}