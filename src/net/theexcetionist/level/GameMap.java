package net.theexcetionist.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import net.theexcetionist.assets.Jukebox;
import net.theexcetionist.assets.MapLoader;
import net.theexcetionist.gameobjects.GameObject;
import net.theexcetionist.gameobjects.Player;
import net.theexcetionist.gameobjects.Rat;
import net.theexcetionist.gameobjects.TileObject;

public class GameMap {
	public int[] map;
	
	public String name;
	public int id;
	public int numRows;
	public int numCols;
	public int exit = 0;
	public int startX = 0, startY = 0;
	
	private final int tileSize = 32;
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	private ArrayList<TileObject> tiles = new ArrayList<TileObject>(); 
	private MapLoader loader;

	private Player player;
	
	public GameMap(String name, int id, int rows, int cols, MapLoader loader, int startX, int startY){
		this.name = name;
		this.id = id;
		this.numRows = rows;
		this.numCols = cols;
		this.loader = loader;
		this.startX = startX;
		this.startY = startY;
		
		init();
	}
	
	public GameMap(String name, int id, int rows, int cols, MapLoader loader, int startX, int startY, Player p){
		this(name, id, rows, cols, loader, startX, startY);
		
		this.player = p;
	}
	
	private void init() {
		if(id == 0){
			//Jukebox.loop("forest_theme");
			
			map = loader.loadLevelFromMap(loader.loadMap("/Maps/map1.png"));//new int[numRows * numCols];
			//map[10] = 1;
			for(int x = 0; x < numRows; x++){
				for(int y = 0; y < numCols - 1; y++){
					//if(map[x + y * numCols] == 1) System.out.println("Hello");
					tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
				}
			}
			
			objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 1){
			map = loader.loadLevelFromMap(loader.loadMap("/Maps/map2.png"));//new int[numRows * numCols];
			//map[10] = 1;
			
			for(int x = 0; x < numRows; x++){
				for(int y = 0; y < numCols - 1; y++){
					//if(map[x + y * numCols] == 1) System.out.println("Hello");
					tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
				}
			}

			objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
		
	}
	
	public void playTheme(){
		if(id == 0 && !Jukebox.isPlaying("forest_theme"))Jukebox.loop("forest_theme");
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
	public boolean getTilePass(Rectangle r){
		//boolean[] passTiles = new boolean[4];
		boolean canPass = true;
		//TileObject[] conflictTiles = new TileObject[4];
		//int i = 0;
		
		//Arrays.fill(passTiles, true);
		
		for(TileObject tile : tiles){
			//System.out.println(r.x+" "+r.y+" "+tile.getBounds().x+" "+tile.getBounds().y);
			if(r.intersects(tile.getBounds())){
				//System.out.println(tile.getID());
				tile.intersects = true;
				canPass = Tile.tiles[tile.getID()].mayPass;//){
					//conflictTiles[i] = tile;
				//}
				
				//i++;
				if(!canPass) return canPass;
			}else{
				tile.intersects = false;
			}
		}
		
		/*for(int n = 0; n < passTiles.length; n++){
			if(!passTiles[n]) return num[n];
		}*/
	
		return canPass;
	}

	public Tile getTile(int x, int y){
		//if(Tile.tiles[map[x + y * numCols]] == null)System.out.println(Tile.tiles[map[x + y * numCols]]);
		//System.out.println(map+" "+id);
		return Tile.tiles[map[x + y * numCols]];
	}
	
	public void setTile(int x, int y, int tileID){
		map[x + y * numCols] = tileID;
	}
	
	public void tick(){
		ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
		
		playTheme();
		
		for(int x = 0; x < numRows; x++){
			for(int y = 0; y < numCols - 1; y++){
				getTile(x, y).tick();
			}
		}
		
		for(GameObject object : objects){
			if(!object.isAlive()) toRemove.add(object);
			object.tick(this);
			
			if(object instanceof Player){
				Player p = (Player)object;	
				exit = p.getExit();
				
				//if(exit > 0) exitLevel(exit);
			}
		}
		
		//System.out.println(id);
		
		objects.removeAll(toRemove);
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
			if(object.isAlive())object.render(g);
		}
	}
	
	public void addObject(GameObject o){
		objects.add(o);
	}
	
	public void removeObject(GameObject o){
		objects.remove(o);
	}
	
}
