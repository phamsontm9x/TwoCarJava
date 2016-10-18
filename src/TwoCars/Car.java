package TwoCars;

import java.awt.Rectangle;

public class Car implements Constants {
	private int carX, carY, SpeedX;
	private boolean isLeft, isRight, isDestroy;
	private Rectangle frameCar = new Rectangle(0, 0, 0, 0);
	
	public Car (int x, int y ,boolean left ,boolean right) {
		carX = x;
		carY = y;
		SpeedX = 2;
		isLeft = left;
		isRight = right;
		isDestroy = false;
		frameCar.setBounds(x, y, CAR_WIDTH, CAR_HEIGHT);
	}
	
	public void moveLeft() {
		if (isRight) {
			isRight = false ;
			isLeft = true;
			carX -=120;
			frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
		}
	}
	
	public void moveRight() {
		if (isLeft) {
			isLeft = false ;
			isRight = true;
			carX +=120;
			frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
		}
	}

	public boolean isLeft() {
		return isLeft;
	}

	public boolean isDestroy() {
		return isDestroy;
	}

	public void setDestroy(boolean isDestroy) {
		this.isDestroy = isDestroy;
	}

	public void setLeft(boolean isLeft) {
		this.isLeft = isLeft;
	}

	public boolean isRight() {
		return isRight;
	}

	public void setRight(boolean isRight) {
		this.isRight = isRight;
	}

	public Rectangle getFrameCar() {
		return frameCar;
	}

	public void setFrameCar(Rectangle frameCar) {
		this.frameCar = frameCar;
	}

	public int getCarX() {
		return carX;
	}

	public void setCarX(int carX) {
		this.carX = carX;
	}

	public int getCarY() {
		return carY;
	}

	public void setCarY(int carY) {
		this.carY = carY;
	}

	public int getSpeedX() {
		return SpeedX;
	}

	public void setSpeedX(int speedX) {
		SpeedX = speedX;
	}
	
}
