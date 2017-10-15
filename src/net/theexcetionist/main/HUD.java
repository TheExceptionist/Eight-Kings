package net.theexcetionist.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	private final int x, y;
	
	public HUD(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		g.drawString("Test", x, y);
	}
	
	public void tick(){
		
	}
}
