package Tycoon;

class Timer extends Thread{
	public static int timer=10000; // �ؾ �гκ� Ÿ�̸�
	public void run() {
		while(true) {
			int escape=0;
			int time = (timer/1000)-1;
			while(true) {
				if(MainPanel.k==0)return;
				Panel1.RightLabel1.setText(Integer.toString(time));
				Panel2.RightLabel2.setText(Integer.toString(time));
				Panel3.RightLabel3.setText(Integer.toString(time));
				Panel4.RightLabel4.setText(Integer.toString(time));
				Panel5.RightLabel5.setText(Integer.toString(time));
				Panel6.RightLabel6.setText(Integer.toString(time));
				Panel7.RightLabel7.setText(Integer.toString(time));
				Panel8.RightLabel8.setText(Integer.toString(time));
				Panel9.RightLabel9.setText(Integer.toString(time));
				Panel10.RightLabel10.setText(Integer.toString(time));
				Panel11.RightLabel11.setText(Integer.toString(time));
				Panel12.RightLabel12.setText(Integer.toString(time));
//				EastPanel.maintimer.setText(Integer.toString(EastPanel.finaltime)); //��ü �ð� ȭ�鿡 ǥ��
				try {
					time--;
//					EastPanel.finaltime--;
					sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(time==-1)break;
//				if(EastPanel.finaltime == -1) new IDinformation(); break; //��ü �ð� ���� �� ���â ȣ��
				
			}
		}
	}
}
