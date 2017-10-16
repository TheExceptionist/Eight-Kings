package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import net.theexcetionist.level.GameMap;
import net.theexcetionist.main.GameMain;

public class Entity extends GameObject{
	protected int dir;
	protected int team;
	protected int xKnockback = 0, yKnockback = 0;
	protected int exit = -1;

	public Entity(String name, int ID, int x, int y, int w, int h) {
		super(name, ID, x, y, w, h);
	}
	
	public void render(Graphics g){
		super.render(g);
	}
	
	public void tick(GameMap map){
		super.tick(map);
		
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
	}
	
	protected void doHurt(int damage, int attackDir) {
		/*if (hurtTime > 0) return;

		if (level.player != null) {
			int xd = level.player.x - x;
			int yd = level.player.y - y;
			if (xd * xd + yd * yd < 80 * 80) {
				Sound.monsterHurt.play();
			}
		}
		level.add(new TextParticle("" + damage, x, y, Color.get(-1, 500, 500, 500)));*/
		health -= damage;
		if (attackDir == 0) yKnockback = +6;
		if (attackDir == 1) yKnockback = -6;
		if (attackDir == 2) xKnockback = -6;
		if (attackDir == 3) xKnockback = +6;
		//hurtTime = 10;
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
			
			
			
			//System.out.println(xt/32+" "+yt/32+" "+dir);
			
			if(xt < 0) exit = 1;
			if(xt/32 > map.numCols - 2) exit = 2;
			if( yt < 0) exit = 3;
			if(yt/32 > map.numRows - 4) exit = 4;
			
			if(exit > 0) return !stopped;
			
			
			//TileObject[] conflictTiles = map.getTilePass(getPendingBounds());
			
			if (!stopped && map.getTilePass(getPendingBounds(xt, yt))){//&& map.getTile(xt, yt).getPass()) {
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
		return true;
	}
	
	public void knockBack(){
		
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
	
	
	
}
