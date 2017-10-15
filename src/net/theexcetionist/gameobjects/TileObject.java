package net.theexcetionist.gameobjects;

public class TileObject extends GameObject{
	public boolean intersects = false;

	public TileObject(String name, int ID, int x, int y, int w, int h) {
		super(name, ID, x, y, w, h);
	}

}
