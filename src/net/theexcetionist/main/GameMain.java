package net.theexcetionist.main;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import net.theexcetionist.assets.Assets;
import net.theexcetionist.assets.Jukebox;
import net.theexcetionist.assets.MapLoader;
import net.theexcetionist.gameobjects.Player;
import net.theexcetionist.input.InputHandler;
import net.theexcetionist.level.GameLevel;

public class GameMain extends Canvas implements Runnable{
	public static final String TITLE = "Java Game";
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 1000;
	public static final int SCALE = 1;
	
	public static final int guiX = 1034;
	public static final int guiY = 30;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private boolean running = false;
	private boolean inGame = true;
	
	private Thread thread;
	
	private InputHandler input;
	private HUD hud;
	
	private GameLevel currentLevel;
	private GameLevel oreleon;
	private MapLoader loader;
	
	private Player player;
	
	private Font customFont;

	public void setCurrentLevel(GameLevel level){
		currentLevel = level;
	}
	
	public GameLevel getCurrentLevel(){
		return currentLevel;
	}
	
	public void init(){
		input = new InputHandler(this);
		loader = new MapLoader();
		hud = new HUD(guiX, guiY, this);
		player = new Player("Player", 0,  4 * 32, 5 * 32, 32, 32, input);
		
		oreleon = new GameLevel("Oreleon", 0, 9, 12, loader);
		
		setCurrentLevel(oreleon);
		
		oreleon.setPlayer(player);
		
		customFont = new Font(null, Font.PLAIN, 30);
		
		/*try {
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("/GUI/SDS_6x6.ttf").getFile())));
		     
		     customFont = Font.createFont(Font.TRUETYPE_FONT, new File(getClass().getResource("/GUI/SDS_6x6.ttf").getFile()));
		     this.setFont(customFont);
		} catch (IOException|FontFormatException e) {
		     e.printStackTrace();
		}*/
		
		oreleon.getCurrentMap().addObject(player);
		
		Assets.load();
		Jukebox.init();
		Jukebox.load("/Music/med_ava.wav", "forest_theme");
		Jukebox.load("/Music/mad_magic.wav", "dungeon_theme");
		//Jukebox.load("/Music/medi_start.wav", "main_theme");
		

		//Jukebox.loop("forest_theme");
		//Jukebox.load("/Music/med_ava.wav", "theme");
	}
	
	public synchronized void stop(){
		if(running) running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void start(){
		if(!running) running = true;
		thread = new Thread(this);
		thread.start();
		init();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double unprocessed = 0;
		double nsPerTick = 1000000000.0 / 60;
		int frames = 0;
		int ticks = 0;
		long lastTimer1 = System.currentTimeMillis();

		init();

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			while (unprocessed >= 1) {
				ticks++;
				tick();
				unprocessed -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				frames++;
				render();
			}

			if (System.currentTimeMillis() - lastTimer1 > 1000) {
				lastTimer1 += 1000;
				System.out.println(ticks + " ticks, " + frames + " fps");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick(){
		hud.tick();
		currentLevel.tick();
	}
	
	/*int x = 0;
	int velX = 0;*/
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = image.getGraphics();
		
		g.setFont(customFont);
		
		//g.fillRect(0, 0, 50, 50);
		//g.drawImage(Assets.testTile, x, 0, 100, 100, null);
		
		
		
		//x += velX;
		
		//if(input.right.down) velX = 1;
		//else velX = 0;
		currentLevel.render(g);
		
		//g.setColor(Color.GREEN);
		//g.drawString("Test", guiX, guiY);
		
		hud.render(g);
		
		g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, GameMain.WIDTH * GameMain.SCALE, GameMain.HEIGHT * GameMain.SCALE, null);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		GameMain game = new GameMain();
		JFrame window = new JFrame(GameMain.TITLE);
		
		window.add(game);
		window.setSize(GameMain.WIDTH * GameMain.SCALE, GameMain.HEIGHT * GameMain.SCALE);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		game.start();
	}

	public Player getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

}
	