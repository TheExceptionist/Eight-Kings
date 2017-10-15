package net.theexcetionist.level;

import java.awt.Graphics;
import java.util.ArrayList;

import net.theexcetionist.assets.MapLoader;

public class GameLevel {	
	private String name;
	private String mapName;
	public int numMapRows;
	public int numMapCols;
	public int ID;
	
	private ArrayList<GameMap> allMaps = new ArrayList<GameMap>();
	
	private GameMap currentMap;
	private GameMap[] sideMaps;
	private MapLoader loader;
	
	private static final int mapRows = 32;
	private static final int mapCols = 32;
	
	
	public GameLevel(String name, int ID, int rows, int cols, MapLoader loader){
		this.name = name;
		this.ID = ID;
		this.numMapRows = rows;
		this.numMapCols = cols;
		this.loader = loader;
		
		allMaps.add(new GameMap("Forest", 0, mapRows, mapCols, loader));
		allMaps.add(new GameMap("Forest", 1, mapRows, mapCols, loader));
		allMaps.add(new GameMap("Forest", 2, mapRows, mapCols, loader));
		allMaps.add(new GameMap("Forest", 3, mapRows, mapCols, loader));
		
		allMaps.add(new GameMap("Forest", 1 * mapCols, mapRows, mapCols, loader));
		
		setMap(0);
	}
	
	public void setMap(GameMap map){
		currentMap = map;
		mapName = currentMap.name;
	}
	
	public void setMap(int mapID){
		currentMap = allMaps.get(mapID);
		mapName = currentMap.name;
	}
	
	public GameMap getCurrentMap(){
		return currentMap;
	}
	
	public void tick(){
		if(currentMap == null) return;
		currentMap.tick();
	}
	
	public void render(Graphics g){
		if(currentMap == null) return;
		currentMap.render(g);
	}
}
