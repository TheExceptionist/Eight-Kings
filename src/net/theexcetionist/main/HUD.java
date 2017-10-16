package net.theexcetionist.main;

import java.awt.Color;
import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class HUD {
	private final int x, y;
	private final int xOff = 30, yOff = 20;
	private GameMain main;
	
	public HUD(int x, int y, GameMain main){
		this.x = x;
		this.y = y;
		this.main = main;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		
		g.drawImage(Assets.testTile, x - 10, 0, 300, 1000, null); //dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		g.drawImage(Assets.testTile, x - 10 + 300, 0, 300, 1000, null);
		
		g.drawString("The "+main.getCurrentLevel().getCurrentMap().name, x, y);
		g.drawString(main.getPlayer().getName(), x, y + yOff * 2);
		g.drawString("Stats: ", x, y + yOff * 6);
		
		int health = main.getPlayer().getHealth();
		if(health < 0) health = 0; 
		
		g.drawString("Hit: "+health+"/"+main.getPlayer().getMaxHealth(), x + xOff, y + yOff * 10);
		g.drawString("Att: "+main.getPlayer().getAttack(), x + xOff, y + yOff * 14);
		g.drawString("Def: "+main.getPlayer().getDefense(), x + xOff, y + yOff * 18);
		g.drawString("MaA: "+main.getPlayer().getMagAttack(), x + xOff, y + yOff * 22);
		g.drawString("MaD: "+main.getPlayer().getMagDefense(), x + xOff, y + yOff * 26);
	}
	
	public void tick(){
		
	}
}
