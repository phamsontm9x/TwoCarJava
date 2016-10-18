package TwoCars;

import java.awt.Rectangle;

public class Item implements Constants {
	private int itemX, itemY, speedY, typeItem ;
	private boolean onScreen;
	private Rectangle frameItem = new Rectangle(0, 0, 0, 0);
	
	public Item (int x, int y,int type) {
		itemX = x;
		itemY = y;
		speedY = FPS;
		onScreen = true;
		typeItem = type;
		frameItem.setBounds(x, y, ITEM_HEIGHT, ITEM_WIDTH);
	}
	
	public void update() {
		itemY += speedY;
		if (itemY >= 1000) {
			//onScreen = false;
			itemY = 10;
			onScreen = true;
		}
		frameItem.setBounds(itemX, itemY, ITEM_HEIGHT, ITEM_WIDTH);
		isCollision();
	}
	
	public void isCollision() {
		if (GamePlay.car1.getFrameCar().intersects(frameItem) && GamePlay.car1.isDestroy() == false) {
			if (typeItem == 1) {
				GamePlay.car1.setDestroy(true);
			} 
			onScreen = false;
		}
		if (GamePlay.car2.getFrameCar().intersects(frameItem) && GamePlay.car2.isDestroy() == false) {
			if (typeItem == 1) {
				GamePlay.car2.setDestroy(true);
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
	
	
	
}
