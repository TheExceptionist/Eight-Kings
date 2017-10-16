package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class PathTile extends Tile{

	public PathTile(int id) {
		super(id);
		connectsToGrass = false;
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		super.render(map, g, x, y);
		
		g.drawImage(Assets.pathTile, x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}
}
