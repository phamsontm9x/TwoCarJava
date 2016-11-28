package TwoCars;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Background implements Constants {
	private int bgX, bgY, speedY;
	private Image imgBg;
	
	
	public Background(int x, int y, int type) {
		bgX = x;
		bgY = y;
		speedY = SPEED;
		
		if (type == BGImage ) {
			ImageIcon icBG = new ImageIcon("res/Background.png");
			setImgBg(icBG.getImage().getScaledInstance(500, 1000, Image.SCALE_SMOOTH));
		} else {
			ImageIcon icBGShadow = new ImageIcon("res/Backgroundshadow.png");
			setImgBg(icBGShadow.getImage().getScaledInstance(500, 1000, Image.SCALE_SMOOTH));
		}
	}
	
	public void update() {
		bgY += speedY;
		if (bgY >= WINDOW_HEIGHT) {
			bgY = -WINDOW_HEIGHT;
		}
	}

	public int getBgX() {
		return bgX;
	}

	public void setBgX(int bgX) {
		this.bgX = bgX;
	}

	public int getBgY() {
		return bgY;
	}

	public void setBgY(int bgY) {
		this.bgY = bgY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public Image getImgBg() {
		return imgBg;
	}

	public void setImgBg(Image imgBg) {
		this.imgBg = imgBg;
	}
}
