package net.theexcetionist.level;

import java.awt.Graphics;
import java.util.ArrayList;

import net.theexcetionist.assets.MapLoader;
import net.theexcetionist.gameobjects.Player;

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
	private Player player;
	
	private static final int mapRows = 32;
	private static final int mapCols = 32;
	
	
	public GameLevel(String name, int ID, int rows, int cols, MapLoader loader){
		this.name = name;
		this.ID = ID;
		this.numMapRows = rows;
		this.numMapCols = cols;
		this.loader = loader;
		
		allMaps.add(new GameMap("Beyuex's Forest", 0, mapRows, mapCols, loader, 7 * 32, 5 * 23));
		allMaps.add(new GameMap("Beyuex' Forest", 1, mapRows, mapCols, loader, 7 * 32, 5 * 23));
		allMaps.add(new GameMap("Re' Piérre Forest", 2, mapRows, mapCols, loader, 7 * 32, 5 * 23));
		allMaps.add(new GameMap("Foncé Forest", 3, mapRows, mapCols, loader, 7 * 32, 5 * 23));
		
		//allMaps.add(new GameMap("Forest", 1 * mapCols, mapRows, mapCols, loader));
		
		allMaps.add(new GameMap("Sloré's Lost Tomb", 1 * mapCols, mapRows, mapCols, loader, 7 * 32, 5 * 23));
		
		
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
		if(currentMap.exit > 0) {
			exitLevel(currentMap.exit);
		}
	}
	
	private void exitLevel(int exit) {
		currentMap.removeObject(player);
		currentMap.exit = 0;
		player.setExit(0);
		
		//System.out.println("Working");
		
		
		if(exit == 1) setMap(currentMap.id - 1);
		if(exit == 2) setMap(currentMap.id + 1);
		if(exit == 3) setMap(currentMap.id - 1 * mapCols);
		if(exit == 4) setMap(currentMap.id + 1 * mapCols);
		
		//System.out.println(currentMap.id+" "+currentMap.startX+" "+currentMap.startY);
		player.setPosition(currentMap.startX, currentMap.startY, currentMap);
	}

	public void render(Graphics g){
		if(currentMap == null) return;
		currentMap.render(g);
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
