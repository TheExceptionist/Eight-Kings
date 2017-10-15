package net.theexcetionist.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

public class GameMain extends Canvas implements Runnable{
	public static final String TITLE = "Java Game";
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	public static final int SCALE = 3;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	private boolean running = false;
	private boolean inGame = true;
	
	private Thread thread;
	
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
	}
	
	public void run() {
		while(running){
			tick();
			render();
		}
	}
	
	private void tick(){
		
	}
	
	private void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = image.getGraphics();
		
		g.fillRect(0, 0, 50, 50);
		
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

}
	