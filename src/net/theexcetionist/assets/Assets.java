package net.theexcetionist.assets;

import java.awt.image.BufferedImage;

public class Assets {
//	public static BufferedImage bg_blue, bg_greem, bg_orange, br_red; 
//	public static BufferedImage s_wall, s_wall1, s_wall2, s_wall3;
//	public static BufferedImage t_wall, t_wall1, t_wall2, t_wall3;
//	public static BufferedImage player, player2, waffle;
//	public static BufferedImage door;
//	public static BufferedImage logo, ink;
	public static BufferedImage testTile;
	public static BufferedImage testObject;
	public static BufferedImage rat;
	public static BufferedImage grassTile;
	public static BufferedImage treeTile;
	public static BufferedImage pathTile;
	public static BufferedImage guiBack;
	
	public static void load(){
		SpriteLoader load = new SpriteLoader();
		
		Sprite test1 = new Sprite(load.load("/Objects/Floor.png"));
		Sprite test2 = new Sprite(load.load("/Characters/Player0.png"));
		Sprite rodents = new Sprite(load.load("/Characters/Rodent0.png"));
		Sprite tree = new Sprite(load.load("/Objects/Tree0.png"));
		Sprite gui = new Sprite(load.load("/GUI/GUI1.png"));
		
		testTile = test1.crop(0, 1, 48, 112, 16, 16);
		testObject = test2.crop(0, 0, 16, 16, 16, 16);
		grassTile = test1.crop(1, 1, 64, 128, 16, 16);
		treeTile = tree.crop(1, 1, 48, 48, 16, 16);
		pathTile = test1.crop(1, 1, 64, 240, 16, 16);
		//grassTile = test1.crop(1, 1, 48, 112, 16, 16);
		rat = rodents.crop(0, 1, 16, 16, 16, 16);
		guiBack = gui.crop(0, 1, 112, 0, 16, 16);
//		Sprite c1 = new Sprite(load.load("/Sprites/backgrounds/bg_blue.png"));
//		Sprite c2 = new Sprite(load.load("/Sprites/backgrounds/bg_green.png"));
//		Sprite c3 = new Sprite(load.load("/Sprites/backgrounds/bg_orange.png"));
//		Sprite c4 = new Sprite(load.load("/Sprites/backgrounds/bg_red.png"));
//		
//		Sprite t1 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_LeftRight_Blue.png"));
//		Sprite t2 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_LeftRight_Green.png"));
//		Sprite t3 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_LeftRight_Orange.png"));
//		Sprite t4 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_LeftRight_Red.png"));
//		
//		Sprite s1 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_TopBot_blue.png"));
//		Sprite s2 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_TopBot_green.png"));
//		Sprite s3 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_TopBot_orange.png"));
//		Sprite s4 = new Sprite(load.load("/Sprites/minimalistic_walls/wall_TopBot_red.png"));
//		
//		Sprite l1 = new Sprite(load.load("/Sprites/game_logo/logo_1.png"));
//		
//		Sprite p1 = new Sprite(load.load("/Sprites/player.png"));
//		
//		Sprite i1 = new Sprite(load.load("/Sprites/ink_logo.png"));
//		
//		Sprite w1 = new Sprite(load.load("/Sprites/waffle.png"));
//		
//		ink = i1.crop(0, 0, 1400, 800, 1400, 800);
//		
//		bg_blue = c1.crop(0, 0, 32, 32, 32, 32);
//		bg_greem = c2.crop(0, 0, 32, 32, 32, 32);
//		br_red = c3.crop(0, 0, 32, 32, 32, 32);
//		bg_orange = c4.crop(0, 0, 32, 32, 32, 32);
//		
//		logo = l1.crop(0, 0, 2160, 1080, 2160, 1080);
//		
//		t_wall = t1.crop(0, 0, 32, 32, 32, 32);
//		t_wall1 = t2.crop(0, 0, 32, 32, 32, 32);
//		t_wall2 = t3.crop(0, 0, 32, 32, 32, 32);
//		t_wall3 = t4.crop(0, 0, 32, 32, 32, 32);
//		
//		s_wall = s1.crop(0, 0, 32, 32, 32, 32);
//		s_wall1 = s2.crop(0, 0, 32, 32, 32, 32);
//		s_wall2 = s3.crop(0, 0, 32, 32, 32, 32);
//		s_wall3 = s4.crop(0, 0, 32, 32, 32, 32);
//		
//		player = p1.crop(0, 0, 16, 16, 16, 16);
//		player2 = p1.crop(1, 0, 16, 16, 16, 16);
//		
//		waffle = w1.crop(0, 0, 32, 32, 32, 32);
	}
}
