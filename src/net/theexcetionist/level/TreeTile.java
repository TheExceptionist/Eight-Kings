package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class TreeTile extends Tile {
	public TreeTile(int id) {
		super(id);
		connectsToGrass = true;
		mayPass = false;
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		super.render(map, g, x, y);
		
		g.drawImage(Assets.grassTile, x * tileSize, y * tileSize, tileSize, tileSize, null);
		g.drawImage(Assets.treeTile, x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}
}
