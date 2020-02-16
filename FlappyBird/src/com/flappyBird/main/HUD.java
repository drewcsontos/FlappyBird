package com.flappyBird.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	public static int HEALTH = 100;
	public static int score = 0;

	public void tick() {
		HEALTH--;

		HEALTH = Game.clamp(HEALTH, 0, 100);
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		/*
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
		*/
		g.drawString("" + score, 10, 32);
	}
}
