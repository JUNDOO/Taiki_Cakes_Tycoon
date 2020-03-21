package Tycoon;

class Timer extends Thread{
	public static int timer=10000; // 붕어빵 패널별 타이머
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
//				EastPanel.maintimer.setText(Integer.toString(EastPanel.finaltime)); //전체 시간 화면에 표시
				try {
					time--;
//					EastPanel.finaltime--;
					sleep(1000); 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(time==-1)break;
//				if(EastPanel.finaltime == -1) new IDinformation(); break; //전체 시간 종료 시 결과창 호출
				
			}
		}
	}
}
