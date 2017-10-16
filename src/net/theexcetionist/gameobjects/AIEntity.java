package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.util.Random;

import net.theexcetionist.items.Item;
import net.theexcetionist.level.GameMap;

public class AIEntity extends Entity{
	private int attackRange = 0;

	protected Random random;
	
	protected int aiPackage;
	protected int targetX = -1, targetY = -1;
	protected int xa, ya, randomWalkTime;
	protected int left = 0, right = 0, up = 0, down = 0;
	protected Entity targetEntity;
	
	protected int level = 1;
	
	public AIEntity(String name, int ID, int x, int y, int w, int h) {
		super(name, ID, x, y, w, h);
		
		this.random = new Random();
	}
	
	public AIEntity(String name, int ID, int x, int y, int w, int h, int aiPackage, int attackRange) {
		super(name, ID, x, y, w, h);
		
		this.attackRange = attackRange;
		this.aiPackage = aiPackage;//aiPackage;
		this.random = new Random();
	}
	
	public AIEntity(String name, int ID, int x, int y, int w, int h, int aiPackage, int attackRange, int level) {
		this(name, ID, x, y, w, h, aiPackage, attackRange);
		
		this.level = level;
		this.random = new Random();
	}
	
	public Item getRandomItem(int level){
		Item item = null;
		
		for(int i = 0; i < 5; i++){
			int max = (level + 1) * 2;
			
			if(max > Item.items.length) max = Item.items.length;
			
			Item item2 = Item.getItemFromRating(random.nextInt(max));
			
			if(item2 != null && random.nextInt(2) == 1) {
				item = item2;
				break;
			}
			//System.out.println(item);
		}
		
		return item;
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		if(aiPackage == -1){
			xa = 0;
			ya = 0;
			
			if(left == 1) {xa = -1; walkDist++;}
			if(right == 1){xa =  1; walkDist++;}
			if(up == 1)   {ya = -1; walkDist++;}
			if(down == 1) {ya =  1; walkDist++;}
			
			move(xa, ya, map);
			randomMove(map);
			
			if(lookForTarget(map)) aiPackage = 1;
		}
		
		if(aiPackage == 0){
			xa = 0;
			ya = 0;
			
			if(left == 1) {xa = -1; walkDist++;}
			if(right == 1){xa =  1; walkDist++;}
			if(up == 1)   {ya = -1; walkDist++;}
			if(down == 1) {ya =  1; walkDist++;}
			
			move(xa, ya, map);
			randomMove(map);
		}
		
		//System.out.println(aiPackage);
		
		if(aiPackage == 1 && targetX > -1 && targetY > -1){
			
			//if (level.player != null && randomWalkTime == 0) {
				if(targetEntity != null && targetEntity.getBounds().intersects(getBounds())) targetEntity.doHurt(usedAttack, usedMagAttack, dir, magicAttack, this);
			
				int xd = targetX - x;
				int yd = targetY - y;
				if (xd * xd + yd * yd < 32 * attackRange * 32 * attackRange) {
					xa = 0;
					ya = 0;
					if (xd < 0) {xa = -1; walkDist++;}
					if (xd > 0) {xa = +1; walkDist++;}
					if (yd < 0) {ya = -1; walkDist++;}
					if (yd > 0) {ya = +1; walkDist++;}
					//System.out.println(x);
					//walkDist++;
				}else{
					aiPackage = -1;
				}
				
				
				//System.out.println("Working: "+targetX+" "+targetY+" "+xa+" "+ya+" "+xd+" "+yd);
			//}
				move(xa, ya, map);
				lookForTarget(map);

		}else{
			aiPackage = -1;
		}
	}
	
	private boolean lookForTarget(GameMap map) {
		for(GameObject o : map.objects){
			if(!(o instanceof Entity)) continue;
			
			Entity e = (Entity)o;
			
			if(!e.alive || e.team == team) continue;
			
			int xd = e.x - x;
			int yd = e.y - y;
			
			if (xd * xd + yd * yd < 32 * 5 * 32 * 5) {
				setTarget(e.x, e.y);
				targetEntity = e;
				return true;
			}
			
			
		}
		
		return false;
	}

	/**
	 * @param map
	 */
	public void randomMove(GameMap map){
		//System.out.println("SYEty");
//		int speed = 1;
		if (random.nextInt(100) <= 50 && randomWalkTime <= 0) {
			randomWalkTime = 60;
			
			left = random.nextInt(2);
			right = random.nextInt(2);
			up = random.nextInt(2);
			down = random.nextInt(2);
			
			//System.out.println(targetX+" "+targetY+" "+randomWalkTime);
		}
		if (randomWalkTime > 0) randomWalkTime--;
		
		
		/*int speed = 1;
		if (!move(xa * speed, ya * speed, map) || random.nextInt(200) == 0) {
			randomWalkTime = 60;
			xa = (random.nextInt(3) - 1) * random.nextInt(2);
			ya = (random.nextInt(3) - 1) * random.nextInt(2);
		}
		if (randomWalkTime > 0) randomWalkTime--;*/
		
		
		
		
	}
	
	public void render(Graphics g){
		super.render(g);
	}

	public int getAiPackage() {
		return aiPackage;
	}

	public void setAiPackage(int aiPackage) {
		this.aiPackage = aiPackage;
	}
	
	public void setTarget(int x, int y){
		targetX = x;
		targetY = y;
	}
}
