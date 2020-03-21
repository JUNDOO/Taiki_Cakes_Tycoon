package Tycoon;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
	public Main(){
		setTitle("붕어빵타이쿤");
		setSize(1120,720);
//		setSize(620,480);    //png파일 크기 고려한 사이즈
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		setResizable(false);
		setLocationRelativeTo(null); // 전체 윈도우 창의 가운데 뜨게하기.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainPanel mainpanel = new MainPanel();
		NorthPanel northpanel = new NorthPanel();
		SouthPanel southpanel = new SouthPanel();
		EastPanel eastpanel = new EastPanel();
		
		c.add(northpanel,BorderLayout.NORTH);
		c.add(mainpanel, BorderLayout.CENTER);
		c.add(eastpanel,BorderLayout.EAST);
		c.add(southpanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
