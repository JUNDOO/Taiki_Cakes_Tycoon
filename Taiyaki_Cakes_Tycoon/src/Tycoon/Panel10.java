package Tycoon;
import javax.swing.*;
import java.awt.*;

public class Panel10 extends JPanel{
	public static JLabel LeftLabel10 = new JLabel();
	public static JLabel RightLabel10 = new JLabel();
	public static JPanel Panel10_1 = new JPanel(new CardLayout());   //이미지 들어가는 패널을 CardLayout으로 바꿈
	
	//붕어빵객체생성
	public Panel10(){
		JPanel Panel10_2 = new JPanel();
		setLayout(new BorderLayout());
		Panel10_2.setBackground(Color.DARK_GRAY); //패널2 꾸미기 시작
		LeftLabel10.setOpaque(true);
		RightLabel10.setOpaque(true);
		LeftLabel10.setBackground(Color.DARK_GRAY);
		LeftLabel10.setForeground(Color.WHITE);
		LeftLabel10.setFont(new Font("돋움",Font.BOLD,15));
		RightLabel10.setBackground(Color.DARK_GRAY);
		RightLabel10.setForeground(Color.YELLOW);
		RightLabel10.setFont(new Font("돋움",Font.BOLD,13));

		Panel10_2.add(LeftLabel10); Panel10_2.add(RightLabel10); 
		
		add(Panel10_1, BorderLayout.CENTER);
		add(Panel10_2, BorderLayout.SOUTH);
		
		Th10 thth10 = new Th10();
		Thread th10 = new Thread(thth10);
		th10.start();
		
	}
}

class Th10 extends JPanel implements Runnable{
	private ImageIcon empty= new ImageIcon(Main.class.getResource("../images/FISHNULL.png"));	//빈 상태
	private ImageIcon step1= new ImageIcon(Main.class.getResource("../images/FISH00.png"));		//재료
	private ImageIcon step2= new ImageIcon(Main.class.getResource("../images/FISH11.png"));		//익기시작
	private ImageIcon step3= new ImageIcon(Main.class.getResource("../images/FISH22.png"));		//갈변
	private ImageIcon step4= new ImageIcon(Main.class.getResource("../images/FISH33.png"));		//연기 (점수추가)
	private ImageIcon burn= new ImageIcon(Main.class.getResource("../images/FISHBURN.png"));	//태움
	private JLabel label1=new JLabel(empty);		//빈 상태
	private JLabel label2=new JLabel(step1);		//재료
	private JLabel label3=new JLabel(step2);		//익기시작
	private JLabel label4=new JLabel(step3);		//갈변
	private JLabel label5=new JLabel(step4);		//연기 (점수 추가)
	private JLabel label6=new JLabel(burn);		//태움
	private int stage=0;  // 상태 변수
	
	public void run() {
		while(true) {
			int escape = 1; // 탈출 변수.
			while(escape !=0) {
				if(MainPanel.kcheck()==true)return; // 총 타이머가 다됬는지
				String word = MainPanel.wordlist1[(int)(Math.random()*MainPanel.wordlist1.length)];
				Panel10.LeftLabel10.setText(word);
				Panel10.LeftLabel10.setForeground(Color.WHITE);
				Panel10.Panel10_1.add(label1);
				try {
					Thread.sleep(Timer.timer); // 한 단어 총 출력 시간
				} catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				try {
				if(SouthPanel.allfree10.equals(word)) { //맞는 단어를 치면
					escape=0; this.stage++;
					
				}
				else if(SouthPanel.allfree10.equals(null) || !SouthPanel.allfree10.equals(word)){ //아무것도 안 쳤거나, 틀린 단어를 치면
					if(this.stage==0) {
					escape=1; this.stage = 0; // 빈 상태에서 계속 비게 함 (while문을 빠져나가지 않고 무한루프)
					} 
					else {
						escape=0; this.stage = 7; // 재료가 들어있으면 타게 함
					}
				}
				}catch (NullPointerException e) {}
			}
			switch (this.stage) {
			case 0 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label1); break; // ? -> 빈 상태
			case 1 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label2); break; // 빈 상태 -> 재료
			case 2 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label3); break; // 재료 -> 익기시작
			case 3 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label4); break; // 익기시작 -> 갈변
			case 4 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label5); break; // 갈변 -> 연기 (완성)
			case 5 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label1); this.stage=0; EastPanel.SumScore(); break; //연기 (완성) -> 빈 상태 1점 추가
			case 7 : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label6); this.stage=-1; break; // 타버린 상태
			default : Panel10.Panel10_1.removeAll(); Panel10.Panel10_1.add(label1); this.stage=0; break;
			}
		}
	}
}