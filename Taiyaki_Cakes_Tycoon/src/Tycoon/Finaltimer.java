package Tycoon;

import javax.swing.*;

public class Finaltimer extends JFrame implements Runnable{
	public static int finaltime=300; // 총 타이머.
	public void run() {
		IDinformation idscreen;
		while(true) {
			int finaltime2=finaltime-1;
			while(true) {
				try {
					EastPanel.maintimer.setText(Integer.toString(finaltime2)); //전체 시간 화면에 표시
					finaltime2--;
					Thread.sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(finaltime2==-1) {
					MainPanel.kgo(0); // 총 타이머 끝. 게임종료.
					new IDinformation();
					return ;
				}
			}
		}
	}
}