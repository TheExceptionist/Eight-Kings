package net.theexcetionist.level;

import java.awt.Graphics;

import net.theexcetionist.assets.Assets;

public class EntryTile extends Tile{

	public EntryTile(int id) {
		super(id);
		isEntry = true;
	}
	
	public void render(GameMap map, Graphics g, int x, int y){
		super.render(map, g, x, y);
		g.drawImage(Assets.entryPoint, x * tileSize, y * tileSize, tileSize, tileSize, null);
	}
	
	public void tick(){
		super.tick();
	}

}
