package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class BrickPath extends Tile{

	public BrickPath(int id) {
		super(id);
		mayPass = true;
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		g.drawImage(Assets.brickPathTile, x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}

}
