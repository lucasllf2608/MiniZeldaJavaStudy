package zeldaminiclone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Blocks> blocos  = new ArrayList<Blocks>();
	
	public World() {
		
		// hall top
		
		for(int xx = 0; xx < 15*2; xx++) {
			blocos.add(new Blocks(xx*32,0));
		}
		
		// wall bottom 
		for(int xx = 0; xx < 15*2; xx++) {
			blocos.add(new Blocks(xx*32,480-32));
		}
		
		//wall left
		for(int yy = 0; yy < 15*2; yy++) {
			blocos.add(new Blocks(0,yy*32));
		}
		
		// wall right
		for(int yy = 0; yy < 15*2; yy++) {
			blocos.add(new Blocks(640-32,yy*32 ));
		}
		
		blocos.add(new Blocks(80,32));
		
		blocos.add(new Blocks(200,102));
		blocos.add(new Blocks(235,102));
		
		blocos.add(new Blocks(300,102));
		blocos.add(new Blocks(335,102));
		
	}
	
	
	public static boolean isFree(int x, int y) {
		for(int i = 0; i < blocos.size(); i++) {
			 Blocks blocoAtual = blocos.get(i);
			if(blocoAtual.intersects(new Rectangle(x,y,32,32))){			 
				return false;
			}
		}
		
		return true; 
	}
	
		
	public void render(Graphics g) {
		for(int i = 0; i < blocos.size(); i++) {
			blocos.get(i).render(g);
		}
		
	}


}
