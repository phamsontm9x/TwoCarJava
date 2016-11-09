package TwoCars;

public class Background implements Constants {
	private int bgX, bgY, speedY;
	
	public Background(int x,int y) {
		bgX = x;
		bgY = y;
		speedY = SPEED;
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
	
}
