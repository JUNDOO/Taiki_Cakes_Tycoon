package Tycoon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;

public class SettingAfter extends JDialog{
	//타이머
	private JRadioButton easy = new JRadioButton("하수");
	private JRadioButton normal = new JRadioButton("중수");
	private JRadioButton hard = new JRadioButton("고수");
	private JRadioButton hell = new JRadioButton("HELL");
	
	private JRadioButton min1 = new JRadioButton("1분");
	private JRadioButton min2 = new JRadioButton("2분");
	private JRadioButton min3 = new JRadioButton("3분");
	private JRadioButton min5 = new JRadioButton("5분");
	
	public SettingAfter() {
		setTitle("환경설정");
		Container c = getContentPane();
		setLayout(new BorderLayout());
		
		JLabel modeText = new JLabel(" ┌─게임 모드를 설정합니다─┐");
		modeText.setHorizontalAlignment(SwingConstants.CENTER);
		modeText.setFont(new Font("HY엽서M", Font.BOLD, 35));
		c.add(modeText, BorderLayout.NORTH);
		
		ButtonGroup g = new ButtonGroup();
		ButtonGroup gg = new ButtonGroup();
		
		JPanel radioPanel = new JPanel();
		JPanel radioSouth = new JPanel();
		JButton bt = new JButton("확인");
		radioSouth.add(bt);
		bt.addActionListener(new ModeButtonListener());
		c.add(radioSouth, BorderLayout.SOUTH);

		easy.setFont(new Font("HY엽서M", Font.BOLD, 25));
		normal.setFont(new Font("HY엽서M", Font.BOLD, 25));
		hard.setFont(new Font("HY엽서M", Font.BOLD, 25));
		hell.setFont(new Font("HY엽서M", Font.BOLD, 25));

		min1.setFont(new Font("HY엽서M", Font.BOLD, 25));
		min2.setFont(new Font("HY엽서M", Font.BOLD, 25));
		min3.setFont(new Font("HY엽서M", Font.BOLD, 25));
		min5.setFont(new Font("HY엽서M", Font.BOLD, 25));
		
		g.add(easy); g.add(normal); g.add(hard); g.add(hell);
		
		
		JLabel timeText = new JLabel("                                                          ├   게임 시간을 설정합니다     ┤                                                         ");
		timeText.setHorizontalAlignment(SwingConstants.CENTER);
		timeText.setFont(new Font("HY엽서M", Font.BOLD, 33));
		
		JLabel closeText = new JLabel("     └──────────────┘   ");
		closeText.setHorizontalAlignment(SwingConstants.CENTER);
		closeText.setFont(new Font("HY엽서M", Font.BOLD, 32));
		
		gg.add(min1); gg.add(min2); gg.add(min3); gg.add(min5); 
		radioPanel.add(easy); radioPanel.add(normal); radioPanel.add(hard); radioPanel.add(hell);
		radioPanel.add(timeText);
		radioPanel.add(min1); radioPanel.add(min2); radioPanel.add(min3); radioPanel.add(min5);
		radioPanel.add(closeText);
		
		
		easy.addItemListener(new ModeItemListener());
		normal.addItemListener(new ModeItemListener());
		hard.addItemListener(new ModeItemListener());
		hell.addItemListener(new ModeItemListener());
	
		min1.addItemListener(new TimeItemListener());
		min2.addItemListener(new TimeItemListener());
		min3.addItemListener(new TimeItemListener());
		min5.addItemListener(new TimeItemListener());	
		
		c.add(radioPanel, BorderLayout.CENTER);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setSize(640, 280);
		
		setVisible(true);
	}
	private class ModeItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			e.getSource();
			if(e.getStateChange() == ItemEvent.DESELECTED) return;
			if(easy.isSelected()) Timer.timer = 20000;
			else if(normal.isSelected()) Timer.timer = 15000;
			else if(hard.isSelected()) Timer.timer = 10000;
			else if(hell.isSelected()) Timer.timer = 5000;
		}
	}
	private class TimeItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			e.getSource();
			if(e.getStateChange() == ItemEvent.DESELECTED) return;
			if(min1.isSelected()) Finaltimer.finaltime = 60;
			else if(min2.isSelected()) Finaltimer.finaltime = 120;
			else if(min3.isSelected()) Finaltimer.finaltime = 180;
			else if(min5.isSelected()) Finaltimer.finaltime = 300;
		}
	}
	private class ModeButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			dispose();       //다이얼로그 창만 종료
		}
		
	}
}
