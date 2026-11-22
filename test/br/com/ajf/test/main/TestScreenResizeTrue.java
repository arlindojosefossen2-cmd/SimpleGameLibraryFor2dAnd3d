package br.com.ajf.test.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import br.com.ajf.simplegamelibrary.model.core.Game;
import br.com.ajf.simplegamelibrary.model.core.IGame;
import br.com.ajf.simplegamelibrary.model.inputs.GameAction;
import br.com.ajf.simplegamelibrary.model.scenes.AbstractScene;

/**
*@author Arlindo Jose Fossem . Date: Nov 22, 2026.
*@version 1.0v.
*@since 1.5v.
**/
public final class TestScreenResizeTrue extends AbstractScene
{	
	private final Rectangle rect = new Rectangle(32,32,64,64);
	
	private final GameAction right = new GameAction("right");
	private final GameAction left = new GameAction("left");
	private final GameAction up = new GameAction("up");
	private final GameAction down = new GameAction("down");

	private final int speed = 12;
	
	public TestScreenResizeTrue(IGame game)
	{
		super(game);
	}

	public static void main(String[] args)
	{
		final IGame game = new Game("Test Screen Resize True",720,576,30);
		game.addScene(new TestScreenResizeTrue(game));
		game.start();
	}

	@Override
	public void draw(Graphics2D g2d)
	{
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, game.getScreenWidth(), game.getScreenHieght());
		
		g2d.setColor(Color.RED);
		g2d.fillRect(rect.x, rect.y,rect.width,rect.height);
	}

	@Override
	public void start()
	{
		game.setScreenResize(true);
		
		this.inputs.mapToKey(down, KeyEvent.VK_S);
		this.inputs.mapToKey(up, KeyEvent.VK_W);
		this.inputs.mapToKey(right, KeyEvent.VK_D);
		this.inputs.mapToKey(left, KeyEvent.VK_A);
	}

	@Override
	public void update(float delta)
	{
		if(up.ispressed())
		{
			rect.y -= speed ;
		}
		else if(down.ispressed())
		{
			rect.y += speed ;
		}
		
		else if(left.ispressed())
		{
			rect.x -= speed ;
		}
		else if(right.ispressed())
		{
			rect.x += speed ;
		}
	}

	@Override
	public void stop()
	{
//		pass
	}

	@Override
	public void resize(int xPos, int yPos, int width, int height)
	{
//		pass
	}
}