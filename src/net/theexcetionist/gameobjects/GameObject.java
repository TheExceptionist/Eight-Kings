package net.theexcetionist.gameobjects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import net.theexcetionist.level.GameMap;

public class GameObject {
	protected int x, y, w, h;
	protected int health, maxHealth, defense, magDefense, attack, magAttack, maxDefense, maxMagDefense, maxAttack, maxMagAttack;
	protected int ID;
	protected String name;
	
	protected boolean alive;
	
	//protected Random random = new Random();

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
	
	public void setStats(int health, int attack, int defense, int magAttack, int magDefense){
		this.health = health;
		this.maxHealth = health;
		this.attack = attack;
		this.defense = defense;
		this.magAttack = magAttack;
		this.magDefense = magDefense;
		this.maxAttack = attack;
		this.maxDefense = defense;
		this.maxMagAttack = magAttack;
		this.maxMagDefense = magDefense;
	}
	
	public void addStats(int health, int attack, int defense, int magAttack, int magDefense){
		this.health += health;
		this.maxHealth = this.health;
		this.attack += attack;
		this.defense += defense;
		this.magAttack += magAttack;
		this.magDefense += magDefense;
		this.maxAttack = this.attack;
		this.maxDefense = this.defense;
		this.maxMagAttack = this.magAttack;
		this.maxMagDefense = this.magDefense;
	}
	
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMagDefense() {
		return magDefense;
	}

	public void setMagDefense(int magDefense) {
		this.magDefense = magDefense;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getMagAttack() {
		return magAttack;
	}

	public void setMagAttack(int magAttack) {
		this.magAttack = magAttack;
	}

	public void tick(GameMap map){
		if(health <= 0) die();
		if(health < 0) health = 0;
	}
	
	public void render(Graphics g){
		
	}
	
	public void die(){
		if(alive) alive = !alive;
		//health = 0;
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

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	//@Override
	/*public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }*/
}
