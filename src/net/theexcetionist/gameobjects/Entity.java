package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import net.theexcetionist.items.Item;
import net.theexcetionist.level.GameMap;
import net.theexcetionist.main.HUD;

public class Entity extends GameObject{
	protected int coolDown = 60;
	protected int facing = 0;
	
	protected int dir;
	protected int team;
	protected int xKnockback = 0, yKnockback = 0;
	protected int exit = -1;
	protected int walkDist = 0, hurtTime = 0;
	
	protected boolean attacking = false;
	protected int range = 2;
	
	protected Item currentItem;
	protected Item currentArmor;
	
	protected int gold = 0, mana = 0;
	
	protected int usedAttack, usedDefense, usedMagAttack, usedMagDefense;
	protected boolean magicAttack = false;
	
	public final int healAmount = 1;
	public int tickTime = 0;
	
	public Entity(String name, int ID, int x, int y, int w, int h) {
		super(name, ID, x, y, w, h);
	}
	
	public void updateStats(){
		if(currentItem != null && currentArmor != null) {
			usedAttack = attack + currentItem.attackBonus + currentArmor.attackBonus; 
			usedDefense = defense + currentItem.defenseBonus + currentArmor.defenseBonus; 
			usedMagAttack = magAttack + currentItem.magAttack + currentArmor.magAttack; 
			usedMagDefense = magDefense + currentItem.magDefense + currentArmor.magDefense;
			//if(name == "Player")System.out.println(name+" "+currentItem.attackBonus+" "+currentArmor+" "+usedAttack);
			
		}else
		if(currentItem != null) {
			usedAttack = attack + currentItem.attackBonus; 
			usedDefense = defense + currentItem.defenseBonus; 
			usedMagAttack = magAttack + currentItem.magAttack; 
			usedMagDefense = magDefense + currentItem.magDefense;
			//if(name == "Player")System.out.println(name+" "+currentItem.attackBonus+" "+currentArmor+" "+usedAttack);
			
		}else
		if(currentArmor != null){ 
			usedAttack = attack + currentArmor.attackBonus; 
			usedDefense = defense + currentArmor.defenseBonus; 
			usedMagAttack = magAttack + currentArmor.magAttack; 
			usedMagDefense = magDefense + currentArmor.magDefense;
		}else
		if(currentItem == null && currentArmor == null){ 
			usedAttack = attack; 
			usedDefense = defense; 
			usedMagAttack = magAttack; 
			usedMagDefense = magDefense;
		}
		
	}
	
	public void render(Graphics g){
		super.render(g);
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
		updateStats();
		
		if (xKnockback < 0) {
			move(-2, 0, map);
			xKnockback+=2;
		}
		if (xKnockback > 0) {
			move(2, 0, map);
			xKnockback-=2;
		}
		if (yKnockback < 0) {
			move(0, -2, map);
			yKnockback+=2;
		}
		if (yKnockback > 0) {
			move(0, 2, map);
			yKnockback-=2;
		}
		
		if(hurtTime > 0) hurtTime--;
		tickTime++;
	}
	
	protected void doHurt(int damage, int magDamage, int attackDir, boolean magic, Entity attacker) {
		/*if (hurtTime > 0) return;

		if (level.player != null) {
			int xd = level.player.x - x;
			int yd = level.player.y - y;
			if (xd * xd + yd * yd < 80 * 80) {
				Sound.monsterHurt.play();
			}
		}
		level.add(new TextParticle("" + damage, x, y, Color.get(-1, 500, 500, 500)));*/
		int dam = 0;
		
		if(!magic) dam = damage - usedDefense;
		else dam = magDamage - usedMagDefense;
		
		if(dam < 0) dam = 0;
		
		//System.out.println(name+" Damaged: "+dam+" Attack: "+damage+" Defense: "+ usedDefense);
		
		health -= dam;
		
		if(health < 0) {
			attacker.addMana(mana); 
			attacker.addGold(gold); 
			addMana(-mana); 
			addGold(-gold);
			
			if(this instanceof AIEntity){
				AIEntity ent = ((AIEntity)this);
				Item item = ent.getRandomItem(ent.level);
				String msg = "";
				
				msg = ent.name+" was killed. ";
				
				if(item != null){
					System.out.println(item.name);
					
					if(item.isArmor) attacker.equipArmor(item);
					else attacker.equipItem(item);
					
					msg += item.name+" was dropped.";
				}
				System.out.println(msg+" team: "+team);
				HUD.msg = msg;
				
				if(ent instanceof BlackKnight && attacker instanceof Player){
					Player p = (Player)attacker;
					BlackKnight knight = (BlackKnight) ent;
					
					if(knight.hasRelic) p.gainRelic();
				}
			}
		}
		
		if (attackDir == 0) yKnockback = +6;
		if (attackDir == 1) yKnockback = -6;
		if (attackDir == 2) xKnockback = -6;
		if (attackDir == 3) xKnockback = +6;
		//hurt = true;
		hurtTime = 10;
	}
	
	public void heal(int amount){
		health += amount;
		if(health > maxHealth) health = maxHealth;
	}
	
	public void addGold(int gold2) {
		this.gold += gold2;
	}

	public void addMana(int mana2) {
		this.mana += mana2;
		
	}

	public boolean move(int xa, int ya, GameMap map) {
		if (xa != 0 || ya != 0) {
			boolean stopped = false;
			
			int xt = (x + xa)/1;
			int yt = (y + ya)/1;
			
			if (xa < 0) dir = 2;
			else if (xa > 0) dir = 3;
			else if (ya < 0) dir = 1;
			else if (ya > 0) dir = 0;
			
			
			
			//System.out.println(x+" "+y+" "+dir);
			
			if(xt < 0) exit = 1;
			if(xt/32 > map.numCols - 2) exit = 2;
			if( yt < 0) exit = 3;
			if(yt/32 > map.numRows - 4) exit = 4;
			
			if(exit > 0) return !stopped;
			
			
			//TileObject[] conflictTiles = map.getTilePass(getPendingBounds());
			
			//if(this instanceof Player)System.out.println(map.getTile(x/32, y/32).canHeal()+" "+map.getTile(x/32, y/32));
			
			if(map.getTile(x/32, y/32).canHeal() && ((tickTime & 60) == 0)){
				heal(healAmount);
				//System.out.println(healAmount);
			}
			
			if(!stopped && map.getTileEntry(getPendingBounds(xt, yt))){
				map.enter();
			}
			
			if (!stopped && map.getTilePass(getPendingBounds(xt, yt))){//&& map.getTile(xt, yt).getPass()) {
			//if(!stopped && map.getTilePass(getAttackBounds(xt, yt, dir))){
				x += xa;
				y += ya;
				
				return stopped;
			}/*else{
				x += xa;
				y += ya;
				
				return stopped;
			}*/
			//return !stopped;
		}
		
		//this.do
		
		return true;
	}
	
	public Rectangle getAttackBounds(int x, int y, int dir){
		int n = 0;
		int j = 0;
		
		if(dir == 0) n = 16;
		if(dir == 1) n = -16;
		if(dir == 2) j = -16;
		if(dir == 3) j = 16;
		
		return new Rectangle(x + j * range, y + n * range, w, h);
	}
	
	public Rectangle getPendingBounds(int x, int y){
		return new Rectangle(x, y, w, h);
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getTeam() {
		return team;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public int getxKnockback() {
		return xKnockback;
	}

	public void setxKnockback(int xKnockback) {
		this.xKnockback = xKnockback;
	}

	public int getyKnockback() {
		return yKnockback;
	}

	public void setyKnockback(int yKnockback) {
		this.yKnockback = yKnockback;
	}

	public int getExit() {
		return exit;
	}

	public void setExit(int exit) {
		this.exit = exit;
	}

	public Item getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(Item currentItem) {
		this.currentItem = currentItem;
	}

	public Item getCurrentArmor() {
		return currentArmor;
	}

	public void setCurrentArmor(Item currentArmor) {
		this.currentArmor = currentArmor;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	
	public void equipItem(Item item){
		if(item == null) return;
		if(currentItem != null && item.rating <= currentItem.rating) return;
		currentItem = item;
	}
	
	public void equipArmor(Item item){
		if(item == null) return;
		if(currentArmor != null && item.rating <= currentArmor.rating) return;
		currentArmor = item;
	}
}
