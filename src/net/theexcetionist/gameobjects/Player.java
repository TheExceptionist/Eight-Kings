package net.theexcetionist.gameobjects;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;
import net.theexcetionist.input.InputHandler;
import net.theexcetionist.level.GameMap;

public class Player extends Entity{
	InputHandler input;
	
	public Player(String name, int ID, int x, int y, int w, int h, InputHandler input) {
		super(name, ID, x, y, w, h);
		this.input = input;
		
		team = 0;
		
		setStats(20, 0, 0, 0, 0);
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		int xa = 0;
		int ya = 0;
		if (input.up.down) ya-=2;
		if (input.down.down) ya+=2;
		if (input.left.down) xa-=2;
		if (input.right.down) xa+=2;
		
		move(xa, ya, map);
	}
	
	public void render(Graphics g){
		super.render(g);
		
		g.drawImage(Assets.testObject, x, y, w, h, null);
		
		//System.out.println("Working");
		//g.drawRect(getBounds().x, getBounds().y, w, h);
	}

	public void setPosition(int startX, int startY, GameMap map) {
		this.x = startX;
		this.y = startY;
		
		map.addObject(this);
		
		//System.out.println("Working"+x+" "+y);
	}

}
