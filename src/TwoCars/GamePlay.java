package TwoCars;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements Runnable, KeyListener, Constants {
	
	private static Background bg1, bg2, bgShadow;
	
	public static Car car1, car2;
	
	private static Item item1, item2, item3, item4;
	
	private static Score score;
	
	private String strHighScore, namePlayer;
	
	private boolean isPlay, isReset, isSound;
	
	private Image imgScore, imgPlay, imgReset, imgVolume_on, imgVolume_off;
	
	private SoundGame soundGame, soundDesCar;
	
	
	public GamePlay () {
		initBackground();
		Start();
	}
	
	public void initBackground() {
		setBackground(Color.black);
		setDoubleBuffered(true);
		setFocusable(true);
				
		ImageIcon icScore = new ImageIcon("res/ScoreImage.png");
		imgScore = icScore.getImage().getScaledInstance(IMAGE_SCORE_WIDTH, IMAGE_SCORE_HEIGHT, Image.SCALE_SMOOTH);
		
		ImageIcon icPlay = new ImageIcon("res/play.png");
		imgPlay = icPlay.getImage().getScaledInstance(IMAGE_BUTTON_WIDTH, IMAGE_BUTTON_HEIGHT, Image.SCALE_SMOOTH);	
		
		ImageIcon icReset = new ImageIcon("res/reset.png");
		imgReset = icReset.getImage().getScaledInstance(IMAGE_BUTTON_WIDTH, IMAGE_BUTTON_HEIGHT, Image.SCALE_SMOOTH);
		
		ImageIcon icVolume_up = new ImageIcon("res/volume_up.png");
		imgVolume_on = icVolume_up.getImage().getScaledInstance(IMAGE_VOLUME_WIDTH, IMAGE_VOLUME_HEIGHT, Image.SCALE_SMOOTH);
	
		ImageIcon icVolume_off = new ImageIcon("res/volume_off.png");
		imgVolume_off = icVolume_off.getImage().getScaledInstance(IMAGE_VOLUME_WIDTH, IMAGE_VOLUME_HEIGHT, Image.SCALE_SMOOTH);
	}
	
	public void Start() {
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x=e.getX();
			    int y=e.getY();
			    if ((WINDOW_WIDTH/2 - IMAGE_BUTTON_WIDTH) < x && x < (WINDOW_WIDTH/2 + IMAGE_BUTTON_WIDTH) && ((WINDOW_HEIGHT/2 - IMAGE_BUTTON_WIDTH/2)  < y && y < (WINDOW_HEIGHT/2 + IMAGE_BUTTON_WIDTH/2)) && !isPlay) {
			    	System.out.println("t co qua day");
			    	namePlayer = JOptionPane.showInputDialog("Nhap Ten Nguoi Choi");
			    	if (namePlayer != null) {
				    	JOptionPane.showMessageDialog(null, namePlayer + " co the bat tat nhac bang cach an phim 'm'. \n Toc do cua game se tang theo diem, can chu y de khoi bat ngo");
				    	if (!isPlay && isReset) {
				    		resetGame();
				    		isPlay = true;
				    	} else {
					    	isPlay = true;
				    	}
				    	if (isSound) {
					    	soundGame.PlaySound();
				    	}
			    	}
			    }
			}
		});
		
		bg1 = new Background(BG_X, BG_Y, BGImage);
		bg2 = new Background(BG_X, BG_HEIGHT, BGImage);
		bgShadow = new Background(BG_X, BG_Y, BGShadow);
		
		car1 = new Car(CAR_X1, CAR_Y, true, false, CAR_RED);
		car2 = new Car(CAR_X2, CAR_Y, true, false, CAR_BLUE);
		
		item1 = new Item(35, 0+ITEM_Y, ITEM_BLUE);
		item2 = new Item(155, -WINDOW_HEIGHT/2+ITEM_Y, ITEM_BLUE);
		item3 = new Item(282, -ITEM_SPACE+ITEM_Y, ITEM_RED);
		item4 = new Item(400, -(WINDOW_HEIGHT/2+ITEM_SPACE)+ITEM_Y, ITEM_RED);
		
		score = new Score(SCORE_X, SCORE_Y, 0);
		soundDesCar = new SoundGame("res/SoundBoom.wav");
		soundGame = new SoundGame("res/Sound.wav");
		
		isSound = true;
		isPlay = false;
		isReset = false;
		strHighScore= null;
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void resetGame() {
		bg1 = new Background(BG_X, BG_Y, BGImage);
		bg2 = new Background(BG_X, BG_HEIGHT, BGImage);
	
		car1 = new Car(CAR_X1, CAR_Y, true, false, CAR_RED);
		car2 = new Car(CAR_X2, CAR_Y, true, false, CAR_BLUE);
		
		item1 = new Item(35, 0+ITEM_Y, ITEM_BLUE);
		item2 = new Item(155, -WINDOW_HEIGHT/2+ITEM_Y, ITEM_BLUE);
		item3 = new Item(282, -ITEM_SPACE+ITEM_Y, ITEM_RED);
		item4 = new Item(400, -(WINDOW_HEIGHT/2+ITEM_SPACE)+ITEM_Y, ITEM_RED);
		
		soundDesCar = new SoundGame("res/SoundBoom.wav");
		soundGame = new SoundGame("res/Sound.wav");
		
		score = new Score(SCORE_X, SCORE_Y, 0);
		score.setShowScore(false);
		strHighScore = null;
	
	}
	
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		DrawBackground(g);
		if (!isPlay && !isReset) {
			DrawButtonPlay(g);
		}
		DrawVolume(g);
		DrawItem(g);
		DrawScoreImage(g);
		DrawScore(g);
		if (!isPlay && isReset) {
			DrawBackgroundShadow(g);
			DrawGameOver(g);
			DrawLableScore(g);
			DrawLableHighScore(g);
			DrawButtonPlay(g);
		}
		DrawCar(g);
	}
	
	public void DrawBackground(Graphics g) {
		g.drawImage(bg1.getImgBg(), bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(bg2.getImgBg(), bg2.getBgX(), bg2.getBgY(), this);	
	}
	
	public void DrawBackgroundShadow(Graphics g) {
		g.drawImage(bgShadow.getImgBg(), bgShadow.getBgX(), bgShadow.getBgY(), this);
	}
	
	public void DrawButtonPlay(Graphics g) {
		if (!isPlay && isReset) {
			g.drawImage(imgReset, WINDOW_WIDTH/2 - IMAGE_BUTTON_WIDTH/2 , WINDOW_HEIGHT/2 - IMAGE_BUTTON_HEIGHT/2, this);
		} else {
			g.drawImage(imgPlay, WINDOW_WIDTH/2 - IMAGE_BUTTON_WIDTH/2 , WINDOW_HEIGHT/2 - IMAGE_BUTTON_HEIGHT/2, this);
		}
	}
	
	public void DrawVolume(Graphics g) {
		if (isSound) {
			g.drawImage(imgVolume_on, WINDOW_WIDTH - 60, 0, this);
		} else {
			g.drawImage(imgVolume_off, WINDOW_WIDTH - 60, 0, this);
		}
	}
	
	public void DrawGameOver(Graphics g) {
		String s = "GAME OVER";
		Font font = new Font("Dialog",Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(s, WINDOW_WIDTH/2 - 150, WINDOW_HEIGHT/2 - 230 );
	}
	
	public void DrawLableScore(Graphics g) {
		int sum = item1.getSum()+item2.getSum()+item3.getSum()+item4.getSum();
		score.setScore(sum);
		String s = Integer.toString(sum);
		s = "SCORE    "+s;
		Font font = new Font("Dialog",Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(s, WINDOW_WIDTH/2 - 85, WINDOW_HEIGHT/2 - 150 );
	}
	
	public void DrawLableHighScore(Graphics g) {
		if (strHighScore == null) {
			int newscore = score.getScore();
			strHighScore = score.CompareScore(newscore);
		}
		String s = "BEST     "+strHighScore;
		Font font = new Font("Dialog",Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(s, WINDOW_WIDTH/2 - 85, WINDOW_HEIGHT/2 - 100 );
	}
	
	public void DrawCar(Graphics g) {
		g.drawImage(car1.getImageCar(), car1.getCarX(), car1.getCarY(), this);
		g.drawImage(car2.getImageCar(), car2.getCarX(), car2.getCarY(), this);
	}
	
	public void DrawItem(Graphics g) {
		if (item1.isOnScreen()) {
			g.drawImage(item1.getImageItem(), item1.getItemX(), item1.getItemY(), this);
		}
		if (item2.isOnScreen()) {
			g.drawImage(item2.getImageItem(), item2.getItemX(), item2.getItemY(), this);
		}
		if (item3.isOnScreen()) {
			g.drawImage(item3.getImageItem(), item3.getItemX(), item3.getItemY(), this);
		}
		if (item4.isOnScreen()) {
			g.drawImage(item4.getImageItem(), item4.getItemX(), item4.getItemY(), this);
		}
	}
	
	public void DrawScoreImage(Graphics g) {
		g.drawImage(imgScore, score.getScoreX(), score.getScoreY(), this);
	}
	
	public void DrawScore(Graphics g) {
		int sum = item1.getSum()+item2.getSum()+item3.getSum()+item4.getSum();
		String s = Integer.toString(sum);
		if (sum < 10) {
			s = '0'+s;
		} else  if (sum < 30 ) {
			bg1.setSpeedY(SPEED_X2);
			bg2.setSpeedY(SPEED_X2);
			item1.setSpeedY(SPEED_X2);
			item2.setSpeedY(SPEED_X2);
			item3.setSpeedY(SPEED_X2);
			item4.setSpeedY(SPEED_X2);
			car1.setSpeedX(SPEED_X2);
			car2.setSpeedX(SPEED_X2);
		} else {
			bg1.setSpeedY(SPEED_X3);
			bg2.setSpeedY(SPEED_X3);
			item1.setSpeedY(SPEED_X3);
			item2.setSpeedY(SPEED_X3);
			item3.setSpeedY(SPEED_X3);
			item4.setSpeedY(SPEED_X3);
			car1.setSpeedX(SPEED_X3);
			car2.setSpeedX(SPEED_X3);
		}
		Font font = new Font("Dialog",Font.BOLD, 25);
		g.setFont(font);
		g.setColor(Color.WHITE);
		g.drawString(s, SCORE_X+20, SCORE_Y+33 );
		g.setColor(new Color(192, 226, 255));
	}
	
	public void DrawRectangle(Graphics g) {
		//car
		g.drawRect(car1.getCarX(), car1.getCarY(), CAR_HEIGHT, CAR_WIDTH);
		g.drawRect(car2.getCarX(), car2.getCarY(), CAR_HEIGHT, CAR_WIDTH);
		
		// item
		g.drawRect(item1.getItemX(), item1.getItemY(), ITEM_HEIGHT, ITEM_WIDTH);
		g.drawRect(item2.getItemX(), item2.getItemY(), ITEM_HEIGHT, ITEM_WIDTH);
		g.drawRect(item3.getItemX(), item3.getItemY(), ITEM_HEIGHT, ITEM_WIDTH);
		g.drawRect(item4.getItemX(), item4.getItemY(), ITEM_HEIGHT, ITEM_WIDTH);
	}

	@Override
	public void run() {
			addKeyListener(this);
		while (true) {
			if(isPlay){
				if (car1.isDestroy() == false && car2.isDestroy() == false) {
					bg1.update();
					bg2.update();
					
					item1.update();
					item2.update();
					item3.update();
					item4.update();
				} else {
					isReset = true;
					isPlay = false;
					score.setShowScore(true);
			    	if (isSound) {
						soundGame.StopSound();
						soundDesCar.PlaySound();
			    	}
				}
				try {
					Thread.sleep(FPS);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				
			} 
			repaint();
		}
	}	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
        if (e.getKeyCode() == KeyEvent.VK_A) {
            car1.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            car1.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            car2.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            car2.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {
        	if (isSound) {
        		soundGame.StopSound();
        	} else {
        		soundGame.PlaySound();
        	}
        	isSound = !isSound;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub}
	}

	
}
