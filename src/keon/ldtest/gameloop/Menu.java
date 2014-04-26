package keon.ldtest.gameloop;

import keon.ldtest.entity.Entity;
import keon.ldtest.entity.TileWorld;
import keon.ldtest.entity.World;
import keon.ldtest.entity.tile.Tile;
import keon.ldtest.helpers.AnimationFactory;
import keon.ldtest.render.Camera;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState{

	Animation a;
	Camera c = new Camera(32,32);
	TileWorld w = new TileWorld(c, 100, 100);
	
	@Override
	public void init(GameContainer gc, StateBasedGame game) throws SlickException {
		
		a = AnimationFactory.makeAnim("/res/testSheet.png", 64, 64, 200);

    	Tile.setup();
		for(int i = 0; i<100; i+=1)
		{
			for(int j = 0; j<100; j+=1)
			{
				w.setTileAt((char)((100-j)%6), i, j);
			}
		}
		Entity e = new Entity(a, 100,100);
		w.addEntity(e);
		c.setFollow(e);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame game, Graphics g)
			throws SlickException {
		w.render(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame game, int delta)
			throws SlickException {
		w.updateAll(delta);
	}

	@Override
	public int getID() {
		return 0;
	}

}
