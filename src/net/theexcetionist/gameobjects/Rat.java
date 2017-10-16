package net.theexcetionist.gameobjects;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;
import net.theexcetionist.level.GameMap;

public class Rat extends AIEntity{

	public Rat(String name, int ID, int x, int y, int w, int h, int aiPackage, int attackRange, int team) {
		super(name, ID, x, y, w, h, aiPackage, attackRange);
		this.team = team;
		
		setStats(20, 0, 0, 0, 0);
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		//System.out.println(aiPackage+" "+attackRange);
	}
	
	public void render(Graphics g){
		super.render(g);
		
		g.drawImage(Assets.rat, x, y, w, h, null);
	}

}
