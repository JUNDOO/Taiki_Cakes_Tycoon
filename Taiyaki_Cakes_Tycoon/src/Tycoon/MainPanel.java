package Tycoon;

import java.awt.*;
import java.io.*;

import javax.swing.*;

class MainPanel extends JPanel{
	public static String wordlist1[]= new String[120];
	//public static String wordlist2[]= new String[80]; //난이도 조절용 
	public static Timer timer = new Timer();
	public static int k=1; // 게임 정지여부 - 총 타이머랑 관련잇음(Finaltimer)

	public MainPanel(){
		Word_Read(); // 단어 채워오기.
		setLayout(new GridLayout(3,4));
		setBackground(Color.WHITE);
		
		Panel1 panel1 = new Panel1();
		add(panel1);
		
		Panel2 panel2 = new Panel2();
		add(panel2);
	
		Panel3 panel3 = new Panel3();
		add(panel3);
		
		Panel4 panel4 = new Panel4();
		add(panel4);
		
		Panel5 panel5 = new Panel5();
		add(panel5);
		
		Panel6 panel6 = new Panel6();
		add(panel6);
	
		Panel7 panel7 = new Panel7();
		add(panel7);
		
		Panel8 panel8 = new Panel8();
		add(panel8);
		
		Panel9 panel9 = new Panel9();
		add(panel9);
		
		Panel10 panel10 = new Panel10();
		add(panel10);
	
		Panel11 panel11 = new Panel11();
		add(panel11);
		
		Panel12 panel12 = new Panel12();
		add(panel12);

		timer.start();
		
		Finaltimer finaltimer = new Finaltimer();
		Thread finaltimera = new Thread(finaltimer);
		finaltimera.start();
	}
	public void Word_Read() {
		BufferedReader br=null;
		try {
			String path =  "wordlist\\wordlist1.txt";

			br=new BufferedReader(new FileReader(path));
			String c;
			int i=0; 
			while((c=br.readLine()) !=null) {
				wordlist1[i]=c;
				i++;
			}
			br.close();
		}catch(IOException e) {}
//		for(int i=0; i<wordlist1.length; i++) { // 단어목록확인용
//			System.out.print(wordlist1[i]+" ");
//		}
	}
	public synchronized static boolean kcheck() { // k값 : 게임정지여부.
		if(k==0)return true;
		else return false;
	}
	public synchronized static void kgo(int k) { // k값 넣어주기.
		MainPanel.k=k;
	}
}
