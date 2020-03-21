package Tycoon;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EastPanel extends JPanel{
	public static int score=0;
	//public static int final time = 5; //전체 시간 상수. 한 300초 주면 되나?
	public static JLabel ScoreLabel = new JLabel("0");
	public static JLabel maintimer = new JLabel(); //전체 시간 라벨
	public ImageIcon Eastimage= new ImageIcon(Main.class.getResource("../images/FISH11.png"));	//빈 상태
	public ImageIcon Upimage= new ImageIcon(Main.class.getResource("../images/Fish2.png"));	//빈 상태
	public ImageIcon Downimage= new ImageIcon(Main.class.getResource("../images/Fish1.png"));	//빈 상태
	private ImageIcon SoundON = new ImageIcon(Main.class.getResource("../images/SoundON.png"));
	private ImageIcon SoundOFF = new ImageIcon(Main.class.getResource("../images/soundOFF.png"));
	private int soundflag = 1;
	
	public EastPanel(){
		setLayout(new GridLayout(7,0));

		JLabel maintime = new JLabel("남은 시간");
		maintime.setFont(new Font("HY엽서M", Font.BOLD, 35));		//크기(35) 수정하면 Main JFrame 사이즈 바꿔줘야 함
		maintime.setOpaque(true);
		maintime.setBackground(Color.GREEN);
		maintime.setHorizontalAlignment(SwingConstants.CENTER); //글자 중앙 배치
		
		JLabel upimage = new JLabel(Upimage); upimage.setOpaque(true);
		JLabel downimage = new JLabel(Downimage); downimage.setOpaque(true);
		JButton soundButton = new JButton(SoundON);
		soundButton.setBackground(Color.ORANGE);
		soundButton.setText(" Sound ON");
		soundButton.setFont(new Font("HY엽서M", Font.BOLD, 18));
		soundButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JButton b = (JButton)e.getSource();
				if(soundflag == 0) {
					soundflag = 1;
					b.setIcon(SoundON);
					b.setBackground(Color.ORANGE);
					b.setText(" Sound ON");
					b.setFont(new Font("HY엽서M", Font.BOLD, 18));
					FishTycoon.clip.start();
					FishTycoon.clip.loop(10);
				}
				else if(soundflag == 1) {
					soundflag = 0;
					b.setIcon(SoundOFF);
					b.setOpaque(true);
					b.setBackground(Color.YELLOW);
					b.setText(" Sound OFF");
					b.setFont(new Font("HY엽서M", Font.BOLD, 17));
					FishTycoon.clip.stop();
				}
			}
		});
		
		maintimer.setFont(new Font("HY엽서M", Font.BOLD, 25));
		maintimer.setOpaque(true);
		maintimer.setBackground(Color.CYAN);
		maintimer.setHorizontalAlignment(SwingConstants.CENTER); // Eastpanel에서 가운데 정렬 !
		
		
		JLabel sc = new JLabel("점수");
		sc.setOpaque(true);
		sc.setBackground(Color.MAGENTA);
		sc.setFont(new Font("HY엽서M", Font.BOLD, 35));
		sc.setHorizontalAlignment(SwingConstants.CENTER); // Eastpanel에서 가운데 정렬 !
		
		ScoreLabel.setFont(new Font("HY엽서M", Font.BOLD, 35));
		ScoreLabel.setHorizontalAlignment(SwingConstants.CENTER); // Eastpanel에서 가운데 정렬 !
		
		add(maintime); add(maintimer); add(upimage); add(downimage); add(sc); add(ScoreLabel); 
		add(soundButton);
	
	}
	public synchronized static void SumScore(){
		score=score+1;
		setScore(score);
	}
	public synchronized static void setScore(int score){
		ScoreLabel.setText(Integer.toString(score));
		
	}
}
