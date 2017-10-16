package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.util.Random;

import net.theexcetionist.assets.Assets;
import net.theexcetionist.input.InputHandler;
import net.theexcetionist.items.Item;
import net.theexcetionist.level.GameMap;

public class Player extends Entity{
	private int relics = 0;
	InputHandler input;

	private Random rand = new Random();
	
	public Player(String name, int ID, int x, int y, int w, int h, InputHandler input) {
		super(name, ID, x, y, w, h);
		this.input = input;
		
		team = 0;
		
		setStats(40, 0, 0, 0, 0);
		
		this.setCurrentItem(Item.club);
		this.setCurrentArmor(Item.ragged);
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		//System.out.println(currentArmor);
		
		int xa = 0;
		int ya = 0;
		if (input.up.down) ya-=2; walkDist++;
		if (input.down.down) ya+=2; walkDist++;
		if (input.left.down) xa-=2; walkDist++;
		if (input.right.down) xa+=2; walkDist++;
		
		if (input.menu.down) attacking = true;
		else attacking = false;
		
		if(attacking) {
			for(GameObject object : map.objects){
				if(!(object instanceof Entity)) continue;
				
				Entity e = (Entity) object;
				
				if(getAttackBounds(x, y, dir).intersects(e.getBounds())){
					//System.out.println("Hurt");
					e.doHurt(usedAttack, usedMagAttack, dir, magicAttack, this);
				}
			}
		}
		
		move(xa, ya, map);
	}
	
	public void upgradeRandomStat(){
		int ran = rand.nextInt(5);
		
		if(ran == 0) addStats(2, 0, 0, 0, 0);
		if(ran == 1) addStats(0, 1, 0, 0, 0);
		if(ran == 2) addStats(0, 0, 1, 0, 0);
		if(ran == 3) addStats(0, 0, 0, 1, 0);
		if(ran == 4) addStats(0, 0, 0, 0, 1);	
	}
	
	public void render(Graphics g){
		super.render(g);
		
		int dist = walkDist & coolDown;
		
		if(walkDist % 5000 == 0){
			upgradeRandomStat();
		}

		/*if (xa < 0) dir = 2;
		else if (xa > 0) dir = 3;
		else if (ya < 0) dir = 1;
		else if (ya > 0) dir = 0;*/
		
		if(dir == 2 && dist < coolDown/2) facing = 0;
		if(dir == 2 && dist >= coolDown/2) facing = 2;
		if(dir == 3 && dist < coolDown/2) facing = 1;
		if(dir == 3 && dist >= coolDown/2) facing = 3;
		
		if(hurtTime > 0) facing = 4;
		
		if(dir == 0 && attacking) g.drawImage(Assets.sword, x, y + 16, w, h, null);
		if(dir == 1 && attacking) g.drawImage(Assets.sword, x, y - 16, w, h, null);
		if(dir == 2 && attacking) g.drawImage(Assets.sword, x - 16, y, w, h, null);
		if(dir == 3 && attacking) g.drawImage(Assets.sword, x + 16, y, w, h, null);
			
		g.drawImage(Assets.player[facing], x, y, w, h, null);
		
		//System.out.println("Working");
		//g.drawRect(getBounds().x, getBounds().y, w, h);
	}

	public void setPosition(int startX, int startY, GameMap map) {
		this.x = startX;
		this.y = startY;
		
		map.addObject(this);
		
		//System.out.println("Working"+x+" "+y);
	}

	public int getRelics() {
		return relics;
	}

	public void gainRelic() {
		relics++;
		
	}

	public int getWalkDist() {
		// TODO Auto-generated method stub
		return walkDist;
	}

}
