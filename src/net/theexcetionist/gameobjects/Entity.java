package net.theexcetionist.gameobjects;

import java.awt.Graphics;

import net.theexcetionist.level.GameMap;
import net.theexcetionist.main.GameMain;

public class Entity extends GameObject{
	protected int dir;

	public Entity(String name, int ID, int x, int y, int w, int h) {
		super(name, ID, x, y, w, h);
	}
	
	public void render(Graphics g){
		super.render(g);
	}
	
	public void tick(GameMap map){
		super.tick(map);
	}
	
	public boolean move(int xa, int ya, GameMap map) {
		if (xa != 0 || ya != 0) {
			boolean stopped = false;
			
			int xt = (x + xa)/32;
			int yt = (y + ya)/32;
			
			/*if (xa < 0) {dir = 2; xt = (x + xa)/32; yt = (y  + ya)/32;}
			else if (xa > 0) {dir = 3; xt = (x + w + xa)/32; yt = (y  + ya)/32;}
			else if (ya < 0) {dir = 1; xt = (x + xa)/32; yt = (y + ya)/32;}
			else if (ya > 0) {dir = 0; xt = (x + xa)/32; yt = (y + h + ya)/32;}
			else {xt = (x + xa)/32; yt = (y + h + ya)/32;}*/
			
			
			//System.out.println(xt+" "+yt+" "+dir);
			
			if(xt < 0 || xt > map.numCols || yt < 0 || yt > map.numRows){
				return !stopped;
			}
			
			
			
			if (!stopped){//&& map.getTile(xt, yt).getPass()) {
				//if(xt )
				
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
	
}
