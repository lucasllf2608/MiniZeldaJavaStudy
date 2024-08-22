package zeldaminiclone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 640;
	public static int HEIGHT = 480;
	public static int SCALE = 3;
	public Player player; 
	public World world;
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		new Spritesheet();
		player = new Player(32, 32);
		world = new World();
	}
	
	public void tick () {
		  player.tick();
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(0,135,13));
		//g.drawImage(Spritesheet.ground, 0, 0,60,60,null);
		g.fillRect(0,0, WIDTH*SCALE, HEIGHT*SCALE);
		
		player.render(g);
		world.render(g);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("Mini Zelda");
		frame.setLocationRelativeTo(null);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		  game.requestFocus(); 
		
		new Thread(game).start();
				
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
 		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		
 		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
	}

}
