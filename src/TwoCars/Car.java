package TwoCars;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Car implements Constants,Runnable {
	private int carX, carY, SpeedX;
	private boolean isLeft, isRight, isDestroy;
	private Rectangle frameCar = new Rectangle(0, 0, 0, 0);
	
	private Image imageCar;
	
	private ArrayList<Image>arrImageBoom;
	
	private int typeMove;
	
	private Thread move;
	
	private ImageIcon icCarRed = new ImageIcon("res/CarRed.png");
	private Image CarRed = icCarRed.getImage().getScaledInstance(CAR_HEIGHT, CAR_HEIGHT, Image.SCALE_SMOOTH);
	
	private ImageIcon icCarBlue = new ImageIcon("res/CarBlue.png");
	private Image CarBlue = icCarBlue.getImage().getScaledInstance(CAR_HEIGHT, CAR_HEIGHT, Image.SCALE_SMOOTH);
	
	private ImageIcon icBoom;
	private Image Boom;
	
	public Car (int x, int y ,boolean left ,boolean right, int typeCar) {
		carX = x;
		carY = y;
		SpeedX = 2;
		isLeft = left;
		isRight = right;
		isDestroy = false;
		typeMove = 0;
		frameCar.setBounds(x, y, CAR_WIDTH, CAR_HEIGHT);
		arrImageBoom = new ArrayList<Image>();
		
		if (typeCar == CAR_RED) {
			imageCar = CarRed;
		} else if (typeCar == CAR_BLUE) {
			imageCar = CarBlue;
		}
		for (int i = 1; i < 15 ; i++) {
			String a = "res/Boom/boom"+Integer.toString(i)+".png";
			icBoom = new ImageIcon(a);
			Boom = icBoom.getImage().getScaledInstance(CAR_HEIGHT, CAR_HEIGHT, Image.SCALE_SMOOTH);
			arrImageBoom.add(Boom);
		}
		move = new Thread(this);
		move.start();
	}
	
	public Image getImageCar() {
		return imageCar;
	}

	public void setImageCar(Image imageCar) {
		this.imageCar = imageCar;
	}

	public void moveLeft() {
		if (isRight) {
//			isRight = false ;
//			isLeft = true;
			//carX -= 120;
			//frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
			typeMove = 1;
		}
	}
	
	public void moveRight() {
		if (isLeft) {
//			isLeft = false ;
//			isRight = true;
			//carX += 120;
			//frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
			typeMove = 2;
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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (isDestroy) {
				for (int i = 0 ; i < 14; i ++) {
					imageCar = arrImageBoom.get(i);
					//frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
					try {
						move.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return;
			} else {
				if (typeMove == 0) {
					try {
						move.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (typeMove == 1) {
					for (int i = 0 ; i < 12; i ++) {
						carX -= 10;
						isRight = false ;
						isLeft = true;
						frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
						try {
							move.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						typeMove = 0;
					}
				} else if (typeMove == 2) {
					for (int i = 0 ; i < 12; i ++) {
						carX += 10;
						isLeft = false ;
						isRight = true;
						frameCar.setBounds(carX, carY, CAR_WIDTH, CAR_HEIGHT);
						try {
							move.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						typeMove = 0;
					}
				}
			}
			
		}	
	}
}
