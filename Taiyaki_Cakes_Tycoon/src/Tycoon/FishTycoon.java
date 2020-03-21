package Tycoon;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
public class FishTycoon extends JFrame {
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;
	public static Clip clip;
	
	private Image screenImage;
	private Graphics screenGraphic;

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/MainScreen.png")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private ImageIcon IntroButtonImage = new ImageIcon(Main.class.getResource("../images/IntroButtonImage.png"));
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private JButton StartButton = new JButton(IntroButtonImage);
	private JButton ExplainButton = new JButton(IntroButtonImage);
	private JButton SettingButton = new JButton(IntroButtonImage);
	private JButton OutButton = new JButton(IntroButtonImage);
	private int mouseX, mouseY;
	
	public FishTycoon() {
		setUndecorated(true); // ������ �����.
		setTitle("�� �� �� Ÿ �� ��");
		setSize(FishTycoon.SCREEN_WIDTH, FishTycoon.SCREEN_HEIGHT);
		setResizable(false); //â�� ũ�⸦ �������ϰ�.
		setLocationRelativeTo(null); // ��ü ������ â�� ��� �߰��ϱ�.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		
		setLayout(null);
		loadAudio("audio/music1.wav");			//ó�� ���� �� ��Ʈ�� ���� �ٷ� �򸮰� ��
		
		//���� ��� �������� ��ư
		exitButton.setBounds(1245, 0, 30, 30); 
		exitButton.setBorderPainted(false); // ��ư�� ��踦 �����.
		exitButton.setContentAreaFilled(false); // ��ư�� ����� ä�������.
		exitButton.setFocusPainted(false);  
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		//���ӽ��� ��ư
		StartButton.setBounds(850, 550, 120, 60); 
		StartButton.setBorderPainted(false);
		StartButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				StartButton.setIcon(null);
				StartButton.setText("���ӽ���");
				StartButton.setFont(new Font("HY����M", Font.PLAIN, 20));
				StartButton.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				StartButton.setText("");
				StartButton.setIcon(IntroButtonImage);
				StartButton.setBorderPainted(false);
			}
			public void mouseClicked(MouseEvent e) {
				new Main();							//���� ���� ����
				clip.stop();					//��Ʈ�� ���� ����
				loadAudio("audio/music2.wav");	//���� ���� ��ŸƮ
			}
		});
		//���ӹ�� ��ư
		ExplainButton.setBounds(1000, 550, 120, 60); 
		ExplainButton.setBorderPainted(false);
		ExplainButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				ExplainButton.setIcon(null);
				ExplainButton.setText("���ӹ��");
				ExplainButton.setFont(new Font("HY����M", Font.PLAIN, 20));
				ExplainButton.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				ExplainButton.setText("");
				ExplainButton.setIcon(IntroButtonImage);
				ExplainButton.setBorderPainted(false);
			}
			public void mouseClicked(MouseEvent e) {
				new Method();					//���� ��� ȣ��
			}
		});
		//ȯ�漳�� ��ư
		SettingButton.setBounds(850, 630, 120, 60); 
		SettingButton.setBorderPainted(false);
		SettingButton.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent e) {
				SettingButton.setIcon(null);
				SettingButton.setText("ȯ�漳��");
				SettingButton.setFont(new Font("HY����M", Font.PLAIN, 20));
				SettingButton.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				SettingButton.setText("");
				SettingButton.setIcon(IntroButtonImage);
				SettingButton.setBorderPainted(false);
			}
			public void mouseClicked(MouseEvent e) {    //ȯ�漳�� ��ư�� ������
				new SettingAfter();							//Sound �Լ� ����
			}
		});
		//������ ��ư
		OutButton.setBounds(1000, 630, 120, 60);  
		OutButton.setBorderPainted(false);
		OutButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				OutButton.setIcon(null);
				OutButton.setText("������");
				OutButton.setFont(new Font("HY����M", Font.PLAIN, 20));
				OutButton.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e) {
				OutButton.setText("");
				OutButton.setIcon(IntroButtonImage);
				OutButton.setBorderPainted(false);
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		JLabel ver = new JLabel("Team '���� �ȵǴ� ����'               ver 1.1");
		ver.setBounds(800, 500, 450, 30);
		ver.setFont(new Font("HY����M", Font.BOLD, 18));
		add(exitButton);
		add(StartButton);
		add(ExplainButton);
		add(SettingButton);
		add(OutButton);
		add(ver);
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}
	public void paint(Graphics g) {
		screenImage = createImage(FishTycoon.SCREEN_WIDTH, FishTycoon.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) { // ùȭ�� �̹��� �׸���.
		g.drawImage(introBackground, 0, 30,FishTycoon.SCREEN_WIDTH, FishTycoon.SCREEN_HEIGHT, null);
		paintComponents(g);
		this.repaint();
	}
	public void loadAudio(String pathName) {	//���� ���� �Լ�. Sound.java�� �ִ°Ŷ� ���� �Ȱ����� ����� ������ �ϴ��� �𸣰ڶ�
		try {
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start(); clip.loop(50); //����â ���ڸ��� �ٷ� �����ϰ� ��������
		}
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		new FishTycoon();		
	}
}