package TwoCars;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Item implements Constants {
	private int itemX, itemY, speedY, typeItem ;
	private boolean onScreen;
	private boolean isSroce;
	private Rectangle frameItem = new Rectangle(0, 0, 0, 0);
	private Image imageItem;
	private int sum = 0;
	
	private ImageIcon icItem1 = new ImageIcon("res/Item1.png");
	private Image imgItem1 = icItem1.getImage().getScaledInstance(ITEM_WIDTH, ITEM_HEIGHT,Image.SCALE_SMOOTH);
	private ImageIcon icItem2 = new ImageIcon("res/Item2.png");
	private Image imgItem2 = icItem2.getImage().getScaledInstance(ITEM_WIDTH, ITEM_HEIGHT,Image.SCALE_SMOOTH);
	private ImageIcon icItem3 = new ImageIcon("res/Item3.png");
	private Image imgItem3 = icItem3.getImage().getScaledInstance(ITEM_WIDTH, ITEM_HEIGHT,Image.SCALE_SMOOTH);
	private ImageIcon icItem4 = new ImageIcon("res/Item4.png");
	private Image imgItem4 = icItem4.getImage().getScaledInstance(ITEM_WIDTH, ITEM_HEIGHT,Image.SCALE_SMOOTH);
	
	public Item (int x, int y,int type) {
		itemX = x;
		itemY = y;
		speedY = SPEED;
		onScreen = true;
		isSroce = false;
		typeItem = type;
		frameItem.setBounds(x, y, ITEM_HEIGHT, ITEM_WIDTH);
		typeItem = randomItem();
		imageCar(typeItem);
	}
	
	public void update() {
		itemY += speedY;
		if (itemY >= WINDOW_HEIGHT) {
			if (typeItem == 0 || typeItem == 2) {
				if (isSroce) {
					sum ++;
				} else {
					if (typeItem == 0) {
						GamePlay.car2.setDestroy(true);
					} else {
						GamePlay.car1.setDestroy(true);
					}
				}
			}
			itemY = 0;
			onScreen = true;
			isSroce = false;
			typeItem = randomItem();
			imageCar(typeItem);
		} 
		frameItem.setBounds(itemX, itemY, ITEM_HEIGHT, ITEM_WIDTH);
		isCollision();
	}
	
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int randomItem() {
		Random random = new Random(); 
		int type = random.nextInt(2);
		return (typeItem <2 )? (type):(type +2);
	}
	
	public void imageCar (int type) {
		if (type == 0) {
			imageItem = imgItem1;
		} else if (type ==1) {
			imageItem = imgItem2;
		} else if (type ==2) {
			imageItem = imgItem3;
		} else {
			imageItem = imgItem4;
		}
	}
	
	public void isCollision() {
		if (GamePlay.car1.getFrameCar().intersects(frameItem) && GamePlay.car1.isDestroy() == false) {
			if (typeItem == 3) {
				GamePlay.car1.setDestroy(true);
			} else {
				isSroce = true;
			}
			onScreen = false;
		}
		if (GamePlay.car2.getFrameCar().intersects(frameItem) && GamePlay.car2.isDestroy() == false) {
			if ( typeItem == 1) {
				GamePlay.car2.setDestroy(true);
			} else {
				isSroce = true;
			}
			onScreen = false;
		}
	}
	
	public int getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(int typeItem) {
		this.typeItem = typeItem;
	}

	public boolean isOnScreen() {
		return onScreen;
	}

	public void setOnScreen(boolean onScreen) {
		this.onScreen = onScreen;
	}

	public Rectangle getFrameItem() {
		return frameItem;
	}

	public void setFrameItem(Rectangle frameItem) {
		this.frameItem = frameItem;
	}

	public void setHidden (Boolean kt) {
		
	}
	
	public int getItemX() {
		return itemX;
	}

	public void setItemX(int itemX) {
		this.itemX = itemX;
	}

	public int getItemY() {
		return itemY;
	}

	public void setItemY(int itemY) {
		this.itemY = itemY;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}
	
	public Image getImageItem() {
		return imageItem;
	}

	public void setImageItem(Image imageItem) {
		this.imageItem = imageItem;
	}
}
