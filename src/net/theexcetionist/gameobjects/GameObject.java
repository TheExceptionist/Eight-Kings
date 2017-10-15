package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import net.theexcetionist.level.GameMap;

public class GameObject {
	protected int x, y, w, h;
	protected int health;
	protected int ID;
	protected String name;
	
	protected boolean alive;

	public GameObject(String name, int ID, int x, int y, int w, int h){
		this.name = name;
		this.ID = ID;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		//if(ID == 1)System.out.println(name+""+ID+" "+x+" "+y);
		
		alive = true;
	}
	
	public void tick(GameMap map){
		if(health < 0) die();
	}
	
	public void render(Graphics g){
		
	}
	
	public void die(){
		if(alive) alive = !alive;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x, y, w, h);
	}
	
}
