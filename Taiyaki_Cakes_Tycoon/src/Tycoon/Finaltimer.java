package Tycoon;

import javax.swing.*;

public class Finaltimer extends JFrame implements Runnable{
	public static int finaltime=300; // �� Ÿ�̸�.
	public void run() {
		IDinformation idscreen;
		while(true) {
			int finaltime2=finaltime-1;
			while(true) {
				try {
					EastPanel.maintimer.setText(Integer.toString(finaltime2)); //��ü �ð� ȭ�鿡 ǥ��
					finaltime2--;
					Thread.sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(finaltime2==-1) {
					MainPanel.kgo(0); // �� Ÿ�̸� ��. ��������.
					new IDinformation();
					return ;
				}
			}
		}
	}
}