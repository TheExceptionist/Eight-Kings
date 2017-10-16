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
	public static BufferedImage[] player = new BufferedImage[5];
	public static BufferedImage[] knight = new BufferedImage[5];
	public static BufferedImage[] playerBack = new BufferedImage[4];
	public static BufferedImage[] rat = new BufferedImage[5];
	public static BufferedImage[] grassTile = new BufferedImage[9];
	public static BufferedImage[] brickTile = new BufferedImage[9];
	public static BufferedImage treeTile;
	public static BufferedImage pathTile;
	public static BufferedImage brickPathTile;
	public static BufferedImage guiBack;
	public static BufferedImage sword;
	public static BufferedImage entryPoint;
	public static BufferedImage background;
	
	public static BufferedImage menuBackground;
	public static BufferedImage iconRat;
	public static BufferedImage iconHuman;
	
	public static void load(){
		SpriteLoader load = new SpriteLoader();
		
		Sprite test1 = new Sprite(load.load("/Objects/Floor.png"));
		Sprite test2 = new Sprite(load.load("/Characters/Player0.png"));
		Sprite rodents = new Sprite(load.load("/Characters/Rodent0.png"));
		Sprite tree = new Sprite(load.load("/Objects/Tree0.png"));
		Sprite gui = new Sprite(load.load("/GUI/GUI3.png"));
		Sprite items = new Sprite(load.load("/Items/ShortWep.png"));
		Sprite doors = new Sprite(load.load("/Objects/Door0.png"));
		Sprite dungeon = new Sprite(load.load("/Examples/Dungeon.png"));
		Sprite icon1 = new Sprite(load.load("/Objects/icon.png"));
		Sprite icon2 = new Sprite(load.load("/Objects/icon2.png"));
		
		menuBackground = dungeon.crop(0, 0, 480, 640, 640, 480);
		
		iconRat = icon1.crop(0, 0, 32, 32, 32, 32);
		iconHuman = icon2.crop(0, 0, 32, 32, 32, 32);
		
		background = test1.crop(1, 1, 16, 16, 16, 16);
		
		entryPoint = doors.crop(0, 0, 16, 16, 16, 16);
		
		sword = items.crop(0, 0, 16, 16, 16, 16);
		
		testTile = test1.crop(0, 1, 48, 112, 16, 16);
		
		player[0] = test2.crop(0, 0, 16, 16, 16, 16);
		player[1] = test2.crop(1, 0, 16, 16, 16, 16);
		player[2] = test2.crop(0, 1, 16, 16, 16, 16);
		player[3] = test2.crop(1, 1, 16, 16, 16, 16);
		player[4] = test2.crop(4, 0, 16, 16, 16, 16);
		
		knight[0] = test2.crop(0, 2, 16, 16, 16, 16);
		knight[1] = test2.crop(1, 2, 16, 16, 16, 16);
		knight[2] = test2.crop(0, 3, 16, 16, 16, 16);
		knight[3] = test2.crop(1, 3, 16, 16, 16, 16);
		knight[4] = test2.crop(2, 2, 16, 16, 16, 16);
		
		playerBack[0] = test2.crop(2, 0, 16, 16, 16, 16);
		playerBack[1] = test2.crop(3, 0, 16, 16, 16, 16);
		playerBack[2] = test2.crop(2, 1, 16, 16, 16, 16);
		playerBack[3] = test2.crop(3, 1, 16, 16, 16, 16);
		
		brickTile[0] = test1.crop(0, 3, 16, 16, 16, 16);
		brickTile[1] = test1.crop(1, 3, 16, 16, 16, 16);
		brickTile[2] = test1.crop(2, 3, 16, 16, 16, 16);
		
		brickTile[3] = test1.crop(0, 4, 16, 16, 16, 16);
		brickTile[4] = test1.crop(1, 4, 16, 16, 16, 16);
		brickTile[5] = test1.crop(2, 4, 16, 16, 16, 16);
		
		brickTile[6] = test1.crop(0, 5, 16, 16, 16, 16);
		brickTile[7] = test1.crop(1, 5, 16, 16, 16, 16);
		brickTile[8] = test1.crop(2, 5, 16, 16, 16, 16);

		
		grassTile[0] = test1.crop(8, 4, 16, 16, 16, 16);
		grassTile[1] = test1.crop(7, 4, 16, 16, 16, 16);
		grassTile[2] = test1.crop(9, 4, 16, 16, 16, 16);
		
		grassTile[3] = test1.crop(8, 3, 16, 16, 16, 16);
		grassTile[4] = test1.crop(7, 3, 16, 16, 16, 16);
		grassTile[5] = test1.crop(9, 3, 16, 16, 16, 16);
		
		grassTile[6] = test1.crop(8, 5, 16, 16, 16, 16);
		grassTile[7] = test1.crop(7, 5, 16, 16, 16, 16);
		grassTile[8] = test1.crop(9, 5, 16, 16, 16, 16);
		//grassTile[9] = test1.crop(1, 1, 16, 16, 16, 16);*/
		
		treeTile = tree.crop(1, 1, 48, 48, 16, 16);
		pathTile = test1.crop(1, 1, 64, 240, 16, 16);
		brickPathTile = test1.crop(1, 1, 48, 80, 16, 16);
		//grassTile = test1.crop(1, 1, 48, 112, 16, 16);
		rat[0] = rodents.crop(0, 1, 16, 16, 16, 16);
		rat[1] = rodents.crop(0, 2, 16, 16, 16, 16);
		rat[2] = rodents.crop(1, 1, 16, 16, 16, 16);
		rat[3] = rodents.crop(1, 2, 16, 16, 16, 16);
		rat[4] = rodents.crop(2, 1, 16, 16, 16, 16);
		
		
		
		guiBack = gui.crop(0, 0, 16, 16, 400, 1000);
		//guiBack = gui.crop(0, 0, 1000, 404, 404, 1000);
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
