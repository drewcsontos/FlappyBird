package com.flappyBird.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject {
	Handler handler;
	int gravity = 2;
	int tempY;
	boolean canScore = true;
	public static boolean alive = true;
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		velX = 0;
		velY = 0;
		width = 32;
		length = 32;
		this.handler = handler;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, length);
	}

	private void collision() {
		for (int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if (tempObject.getId() == ID.BasicPipe) {
				if (getBounds().intersects(tempObject.getBounds())
						|| getBounds().intersects(tempObject.x, tempObject.y + tempObject.length + 100, 75, 400)) {
					HUD.score = 0;
					alive = false;
					reset();
					tempObject.reset();
				}
			if(x>tempObject.x )
			{
				if (canScore)
				{
				HUD.score++;
				canScore = false;
				}
			}
			else 
				canScore = true;
				
			}
		}
	}

	@Override
	public void tick() {
		tempY = y;
		y += velY;
		y += gravity;
		y = Game.clamp(y, tempY - 15, tempY + 2);
		y = Game.clamp(y, 0, Game.HEIGHT - 60);
		collision();

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(x, y, 25, 25);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("../Images/flappyBird.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image,x,y, null);
	}

	public void reset(){
		velX = 0;
		velY = 0;
		x=100;
		y=100;
	}
}
