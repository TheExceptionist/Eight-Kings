package net.theexcetionist.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import net.theexcetionist.assets.MapLoader;
import net.theexcetionist.gameobjects.GameObject;
import net.theexcetionist.gameobjects.TileObject;

public class GameMap {
	public int[] map;
	
	public String name;
	public int id;
	public int numRows;
	public int numCols;
	
	private final int tileSize = 32;
	private ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<TileObject> tiles = new ArrayList<TileObject>(); 
	private MapLoader loader;
	
	public GameMap(String name, int id, int rows, int cols, MapLoader loader){
		this.name = name;
		this.id = id;
		this.numRows = rows;
		this.numCols = cols;
		this.loader = loader;
		
		map = new int[numRows * numCols];
		
		
		map[10] = 1;
		
		for(int x = 0; x < numRows; x++){
			for(int y = 0; y < numCols - 1; y++){
				//if(map[x + y * numCols] == 1) System.out.println("Hello");
				tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
			}
		}

	}
	
	//0 = -+
	//    ++
	//1 = +-
	//    ++
	//2 = ++
	//    -+
	//3 = ++
	//    +-
	//4 = ++
	//    ++
	public TileObject[] getTilePass(Rectangle r){
		//boolean[] passTiles = new boolean[4];
		TileObject[] conflictTiles = new TileObject[4];
		int i = 0;
		
		//Arrays.fill(passTiles, true);
		
		for(TileObject tile : tiles){
			//System.out.println(r.x+" "+r.y+" "+tile.getBounds().x+" "+tile.getBounds().y);
			if(r.intersects(tile.getBounds())){
				//System.out.println(tile.getID());
				tile.intersects = true;
				if(Tile.tiles[tile.getID()].mayPass){
					conflictTiles[i] = tile;
				}
				
				i++;
			}else{
				tile.intersects = false;
			}
		}
		
		/*for(int n = 0; n < passTiles.length; n++){
			if(!passTiles[n]) return num[n];
		}*/
	
		return conflictTiles;
	}

	public Tile getTile(int x, int y){
		return Tile.tiles[map[x + y * numCols]];
	}
	
	public void setTile(int x, int y, int tileID){
		map[x + y * numCols] = tileID;
	}
	
	public void tick(){
		for(int x = 0; x < numRows; x++){
			for(int y = 0; y < numCols - 1; y++){
				getTile(x, y).tick();
			}
		}
		
		for(GameObject object : objects){
			if(!object.isAlive()) objects.remove(object);
			object.tick(this);
		}
	}
	
	public void render(Graphics g){
		for(int x = 0; x < numRows; x++){
			for(int y = 0; y < numCols - 1; y++){
				getTile(x, y).render(this, g, x, y);
			}
		}
		g.setColor(Color.BLUE);
		for(TileObject tile : tiles){
			//System.out.println(tile.getBounds().x+" "+tile.getBounds().y);
			if(tile.intersects) g.drawRect(tile.getX(), tile.getY(), tile.getW(), tile.getH());
		}
		for(GameObject object : objects){
			object.render(g);
		}
	}
	
	public void addObject(GameObject o){
		objects.add(o);
	}
	
	public void removeObject(GameObject o){
		objects.remove(o);
	}
	
}
