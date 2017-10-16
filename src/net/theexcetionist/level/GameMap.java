package net.theexcetionist.level;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import net.theexcetionist.assets.Jukebox;
import net.theexcetionist.assets.MapLoader;
import net.theexcetionist.gameobjects.BlackKnight;
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
	
	public boolean visited = false;
	public boolean entered = false;
	public int enteredID = 100;
	//public boolean onHealingTile = false;
	
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
	
	public void respawnEntities(){
		if(id == 0){
			objects.add(new Rat("Rat", 1, 13 * 32, 3 * 32, 32, 32, 1, 3, 1));
			objects.add(new Rat("Black Rat", 1, 20 * 32, 14 * 32, 32, 32, 1, 3, 2, 1));
			objects.add(new Rat("Rat", 1, 13 * 32, 25 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 1){
			objects.add(new Rat("Black Rat", 1, 5 * 32, 3 * 32, 32, 32, 2, 3, 1));
			objects.add(new Rat("Rat", 1, 20 * 32, 3 * 32, 32, 32, 1, 3, 1));
			objects.add(new Rat("Black Rat", 1, 13 * 32, 24 * 32, 32, 32, 2, 3, 1));
		}
		if(id == 2){
			objects.add(new Rat("Rat", 1, 2 * 32, 6 * 32, 32, 32, 1, 3, 1));
			objects.add(new Rat("Red Rat", 1, 20 * 32, 3 * 32, 32, 32, 2, 3, 1));
			objects.add(new Rat("Biled Rat", 1, 15 * 32, 20 * 32, 32, 32, 3, 3, 1));
			objects.add(new Rat("Biled Rat", 1, 20 * 32, 3 * 32, 32, 32, 2, 3, 1));
			objects.add(new Rat("Rat", 1, 15 * 32, 20 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 3){
			objects.add(new Rat("Black Rat", 1, 28 * 32, 15 * 32, 32, 32, 1, 3, 1));
			objects.add(new Rat("Blighted Rat", 1, 28 * 32, 3 * 32, 32, 32, 3, 3, 1));
			objects.add(new Rat("Black Rat", 1, 31 * 32, 20 * 32, 32, 32, 2, 3, 1));
			objects.add(new Rat("Black Rat", 1, 23 * 32, 15 * 32, 32, 32, 2, 3, 1));
		}
		if(id == 100){
			objects.add(new Rat("Dungeon Rat", 1, 5 * 32, 25 * 32, 32, 32, 1, 3, 1));
			
			objects.add(new BlackKnight("Sir Farelle", 1, 25 * 32, 3 * 32, 32, 32, 1, 2, 2, 1));
			objects.add(new BlackKnight("Sir Mineres", 1, 28 * 32, 3 * 32, 32, 32, 1, 2, 2, 1));
			objects.add(new BlackKnight("High Scribe Carleon", 1, 28 * 32, 25 * 32, 32, 32, 1, 2, 3, 1));
			objects.add(new BlackKnight("Grand Knight Lerox", 1, 15 * 32, 16 * 32, 32, 32, 1, 2, 4, 1));
		}	
	}
	
	public void despawnEntities(){
		objects.removeAll(objects);
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
			
			respawnEntities();
			
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

			respawnEntities();
			//objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 2){
			map = loader.loadLevelFromMap(loader.loadMap("/Maps/map3.png"));//new int[numRows * numCols];
			//map[10] = 1;
			
			for(int x = 0; x < numRows; x++){
				for(int y = 0; y < numCols - 1; y++){
					//if(map[x + y * numCols] == 1) System.out.println("Hello");
					tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
				}
			}
			
			respawnEntities();

			//objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 3){
			map = loader.loadLevelFromMap(loader.loadMap("/Maps/map4.png"));//new int[numRows * numCols];
			//map[10] = 1;
			
			for(int x = 0; x < numRows; x++){
				for(int y = 0; y < numCols - 1; y++){
					//if(map[x + y * numCols] == 1) System.out.println("Hello");
					tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
				}
			}
			
			respawnEntities();

			//objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
		if(id == 100){
			
			map = loader.loadLevelFromMap(loader.loadMap("/Maps/dungeon1.png"));//new int[numRows * numCols];
			//map[10] = 1;
			
			for(int x = 0; x < numRows; x++){
				for(int y = 0; y < numCols - 1; y++){
					//if(map[x + y * numCols] == 1) System.out.println("Hello");
					tiles.add(new TileObject("Placeholder", map[x + y * numCols], x * 32, y * 32, tileSize, tileSize));
				}
			}
			
			respawnEntities();

			//objects.add(new Rat("Rat", 1, 5 * 32, 3 * 32, 32, 32, 1, 3, 1));
		}
	}
	
	public void playTheme(){
		if(id == 0 && !Jukebox.isPlaying("forest_theme")){
			if(Jukebox.isPlaying("main_theme")) Jukebox.stop("main_theme");
			Jukebox.loop("forest_theme");
		}
		if(id == 100 && !Jukebox.isPlaying("dungeon_theme")){
			if(Jukebox.isPlaying("forest_theme")) Jukebox.stop("forest_theme");
			Jukebox.loop("dungeon_theme");
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
	
	public boolean getTileEntry(Rectangle r){
		//boolean[] passTiles = new boolean[4];
		boolean canEnter = true;
		//TileObject[] conflictTiles = new TileObject[4];
		//int i = 0;
		
		//Arrays.fill(passTiles, true);
		
		for(TileObject tile : tiles){
			//System.out.println(r.x+" "+r.y+" "+tile.getBounds().x+" "+tile.getBounds().y);
			if(r.intersects(tile.getBounds())){
				//System.out.println(tile.getID());
				tile.intersects = true;
				canEnter = Tile.tiles[tile.getID()].isEntry;//){
					//conflictTiles[i] = tile;
				//}
				
				//i++;
				if(!canEnter) return canEnter;
			}else{
				tile.intersects = false;
			}
		}
		
		/*for(int n = 0; n < passTiles.length; n++){
			if(!passTiles[n]) return num[n];
		}*/
	
		return canEnter;
	}

	public Tile getTile(int x, int y){
		//if(Tile.tiles[map[x + y * numCols]] == null)System.out.println(Tile.tiles[map[x + y * numCols]]);
		//System.out.println(map+" "+id);
		if(x + y * numCols < map.length && x + y * numCols > -1) return Tile.tiles[map[x + y * numCols]];
		return Tile.tree;
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
		/*g.setColor(Color.BLUE);
		for(TileObject tile : tiles){
			//System.out.println(tile.getBounds().x+" "+tile.getBounds().y);
			if(tile.intersects) g.drawRect(tile.getX(), tile.getY(), tile.getW(), tile.getH());
		}*/
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

	public void enter() {
		entered = true;
	}
	
}
