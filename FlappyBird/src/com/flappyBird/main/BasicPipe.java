package com.flappyBird.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicPipe extends GameObject {

	public BasicPipe(int x, int y, ID id) {
		super(x, y, id);
		velX = -5;
		length = 150;
		width = 75;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, width, length);
	}

	@Override
	public void tick() {
		x += velX;
		if (x <= -75) {
			x = Game.WIDTH - 46;
			Random r = new Random();
			length = r.nextInt(300 - 50) + 50;
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 75, length);
		g.fillRect(x, y + length + 100, 75, 400);

	}

	public void reset() {
		x = Game.WIDTH - 46;
		velX = -5;
		length = 150;
		width = 75;
	}

}
