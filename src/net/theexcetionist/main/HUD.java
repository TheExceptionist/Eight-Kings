package net.theexcetionist.main;

import java.awt.Color;
import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class HUD {
	private final int x, y;
	private final int xOff = 30, yOff = 20;
	private GameMain main;
	
	public static String msg = "";
	
	public HUD(int x, int y, GameMain main){
		this.x = x;
		this.y = y;
		this.main = main;
	}
	
	public void render(Graphics g){
		g.setColor(Color.GREEN);
		
		//g.drawImage(Assets.testTile, x - 10, 0, 300, 1000, null); //dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
		//g.drawImage(Assets.testTile, x - 10 + 300, 0, 300, 1000, null);
		g.drawImage(Assets.guiBack, x - 10, 0, Assets.guiBack.getWidth() + 170, Assets.guiBack.getHeight() - 20, null);
		
		g.drawString("The "+main.getCurrentLevel().getCurrentMap().name, x + (xOff * 3) + 40, y + yOff * 2);
		g.drawString(main.getPlayer().getName(), x + xOff, y + yOff * 4);
		g.drawString(""+msg, x + xOff * 2, y + yOff * 6);
		g.drawString("Stats: ", x + xOff, y + yOff * 8);
		
		int health = main.getPlayer().getHealth();
		if(health < 0) health = 0; 
		
		g.drawString("Time Pasted: "+main.getPlayer().getWalkDist(), x + xOff * 2, y + yOff * 10);
		g.drawString("Hit: "+health+"/"+main.getPlayer().getMaxHealth(), x + xOff * 2, y + yOff * 12);
		g.drawString("Att: "+main.getPlayer().getAttack(), x + xOff * 2, y + yOff * 14);
		g.drawString("Def: "+main.getPlayer().getDefense(), x + xOff * 2, y + yOff * 16);
		g.drawString("MaA: "+main.getPlayer().getMagAttack(), x + xOff * 2, y + yOff * 18);
		g.drawString("MaD: "+main.getPlayer().getMagDefense(), x + xOff * 2, y + yOff * 20);
		
		g.drawString("Gold: "+main.getPlayer().getGold(), x + xOff * 10, y + yOff * 12);
		g.drawString("Mana: "+main.getPlayer().getMana(), x + xOff * 10, y + yOff * 14);
		g.drawString("Relics: "+main.getPlayer().getRelics(), x + xOff * 10, y + yOff * 16);
		
		g.drawString("Equipment: ", x + xOff, y + yOff * 25);
		
		/*String itemName;
		String armorName;
		
		if(main.getPlayer().getCurrentItem() != null) itemName = main.getPlayer().getCurrentItem().name;
		else itemName = "";
		
		if(main.getPlayer().getCurrentArmor() != null) armorName = main.getPlayer().getCurrentArmor().name;
		else armorName = "";
		
		g.drawString("Held Item: "+itemName, x + xOff * 2, y + yOff * 28);*/
		
		if(main.getPlayer().getCurrentItem() != null){
			g.drawString("Held Item: "+main.getPlayer().getCurrentItem().name, x + xOff * 2, y + yOff * 28);
			g.drawString("Bonus Att: +"+main.getPlayer().getCurrentItem().attackBonus, x + xOff * 3, y + yOff * 30);
			g.drawString("Bonus Def: +"+main.getPlayer().getCurrentItem().defenseBonus, x + xOff * 3, y + yOff * 32);
			g.drawString("Bonus MaA: +"+main.getPlayer().getCurrentItem().magAttack, x + xOff * 3, y + yOff * 34);
			g.drawString("Bonus MaD: +"+main.getPlayer().getCurrentItem().magDefense, x + xOff * 3, y + yOff * 36);
		}
		
		//g.drawString("Armor: "+armorName, x + xOff * 2, y + yOff * 38);
		if(main.getPlayer().getCurrentArmor() != null){	
			g.drawString("Armor: "+main.getPlayer().getCurrentArmor().name, x + xOff * 2, y + yOff * 38);
			g.drawString("Bonus Att: +"+main.getPlayer().getCurrentArmor().attackBonus, x + xOff * 3, y + yOff * 40);
			g.drawString("Bonus Def: +"+main.getPlayer().getCurrentArmor().defenseBonus, x + xOff * 3, y + yOff * 42);
			g.drawString("Bonus MaA: +"+main.getPlayer().getCurrentArmor().magAttack, x + xOff * 3, y + yOff * 44);
			g.drawString("Bonus MaD: +"+main.getPlayer().getCurrentArmor().magDefense, x + xOff * 3, y + yOff * 46);
		}
		
	}
	
	public void tick(){
		
	}
}
