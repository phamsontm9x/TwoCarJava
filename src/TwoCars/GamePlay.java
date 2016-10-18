package TwoCars;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePlay extends JPanel implements Runnable, KeyListener, Constants {
	
	private static Background bg1, bg2;
	
	public static Car car1, car2;
	
	private static Item item1, item2, item3, item4;
	
	private static Score score;
	
	// car + background
	private Image imgBg, imgScore ,imgCar1, imgCar2;
	
	// item
	private Image imgItem1, imgItem2, imgItem3, imgItem4;
	
	public GamePlay () {
		initBackground();
		Start();
	}
	
	public void initBackground() {
		setBackground(Color.black);
		setDoubleBuffered(true);
		setFocusable(true);
		
		ImageIcon icBG = new ImageIcon("Background.png");
		imgBg = icBG.getImage().getScaledInstance(500, 1000, Image.SCALE_SMOOTH);
		
		ImageIcon icCar1 = new ImageIcon("CarRed.png");
		imgCar1 = icCar1.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		
		ImageIcon icCar2 = new ImageIcon("CarGreen.png");
		imgCar2 = icCar2.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		
		ImageIcon icItem1 = new ImageIcon("Item1.png");
		imgItem1 = icItem1.getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
		ImageIcon icItem2 = new ImageIcon("Item2.png");
		imgItem2 = icItem2.getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
		ImageIcon icItem3 = new ImageIcon("Item3.png");
		imgItem3 = icItem3.getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
		ImageIcon icItem4 = new ImageIcon("Item4.png");
		imgItem4 = icItem4.getImage().getScaledInstance(60, 60,Image.SCALE_SMOOTH);
		
		ImageIcon icScore = new ImageIcon("Score.png");
		imgScore = icScore.getImage().getScaledInstance(70, 45, Image.SCALE_SMOOTH);
		
	}
	
	public void Start() {
		bg1 = new Background(0, 0);
		bg2 = new Background(0, -1000);
		
		car1 = new Car(25, 750, true, false);
		car2 = new Car(275, 750, true, false);
		
		item1 = new Item(35, 90,2);
		item2 = new Item(160, -60,1);
		item3 = new Item(280, -90,2);
		item4 = new Item(400, 30,1);
		
		score = new Score(215, 30, 0);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		DrawBackground(g);
		DrawCar(g);
		//DrawRectangle(g);
		DrawItem(g);
		DrawScore(g);
	}
	
	public void DrawBackground(Graphics g) {
		g.drawImage(imgBg, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(imgBg, bg2.getBgX(), bg2.getBgY(), this);
	}
	
	public void DrawCar(Graphics g) {
		g.drawImage(imgCar1, car1.getCarX(), car1.getCarY(), this);
		g.drawImage(imgCar2, car2.getCarX(), car2.getCarY(), this);
	}
	
	public void DrawItem(Graphics g) {
		if (item1.isOnScreen()) {
			g.drawImage(imgItem1, item1.getItemX(), item1.getItemY(), this);
		}
		if (item2.isOnScreen()) {
			g.drawImage(imgItem2, item2.getItemX(), item2.getItemY(), this);
		}
		if (item3.isOnScreen()) {
			g.drawImage(imgItem3, item3.getItemX(), item3.getItemY(), this);
		}
		if (item4.isOnScreen()) {
			g.drawImage(imgItem4, item4.getItemX(), item4.getItemY(), this);
		}
	}
	
	public void DrawScore(Graphics g) {
		g.drawImage(imgScore, score.getScoreX(), score.getScoreY(), this);
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
		while (car1.isDestroy() == false && car2.isDestroy() == false) { // car1.isDestroy() == false && car2.isDestroy() == false
			bg1.update();
			bg2.update();
			
			item1.update();
			item2.update();
			item3.update();
			item4.update();

			repaint();
			try {
				Thread.sleep(17);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
