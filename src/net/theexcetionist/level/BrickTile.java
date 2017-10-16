package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class BrickTile extends Tile{

	public BrickTile(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		super.render(map, g, x, y);
		g.drawImage(Assets.brickTile[1], x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}

}
