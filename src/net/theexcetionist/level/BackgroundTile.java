package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class BackgroundTile extends Tile{

	public BackgroundTile(int id) {
		super(id);
		mayPass = false;
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		g.drawImage(Assets.background, x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}

}
