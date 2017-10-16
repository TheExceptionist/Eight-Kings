package net.theexcetionist.gameobjects;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;
import net.theexcetionist.level.GameMap;

public class BlackKnight extends AIEntity{

	boolean hasRelic = false;
	
	public BlackKnight(String name, int ID, int x, int y, int w, int h,
			int aiPackage, int attackRange, int level, int team) {
		super(name, ID, x, y, w, h, aiPackage, attackRange, level);
		
		if(level == 4)
		
		System.out.println(this.team+" "+team);
			
		this.team = team;
		
		setStats(40 * level/2, 2 * level/2,2 * level/2, level/4, level/4);
		
		coolDown *= 2;
		
		gold = random.nextInt(75) + 25;
		mana = random.nextInt(20) + 10;
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		//System.out.println(aiPackage+" "+attackRange);
	}
	
	public void render(Graphics g){
		super.render(g);
		
		int dist = walkDist & coolDown;

		/*if (xa < 0) dir = 2;
		else if (xa > 0) dir = 3;
		else if (ya < 0) dir = 1;
		else if (ya > 0) dir = 0;*/
		
		if(dir == 2 && dist < coolDown/2) facing = 0;
		if(dir == 2 && dist >= coolDown/2) facing = 2;
		if(dir == 3 && dist < coolDown/2) facing = 1;
		if(dir == 3 && dist >= coolDown/2) facing = 3;
		
		if(hurtTime > 0) facing = 4;
		
		//System.out.println(walkDist);
		
		g.drawImage(Assets.knight[facing], x, y, w, h, null);
	}
	

}
