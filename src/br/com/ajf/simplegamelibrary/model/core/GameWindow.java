package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.utils.GamePanelComponentResize;
import br.com.ajf.simplegamelibrary.model.utils.GameWindowClosing;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.util.Objects;

/**
 * The Class GameWindow.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 */
public final class GameWindow
{
	/** The game. */
	private final IGame game;

	/** The window. */
	private final JFrame window;

	/**
	 * Instantiates a new game window.
	 *
	 * @param game  the game
	 * @param title the title
	 */
	public GameWindow(Game game, String title)
	{
		this.game = game;
		this.window = new JFrame(title);
	}

	/**
	 * Inits the.
	 */
	public void init()
	{
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.addWindowListener(new GameWindowClosing(this.game));
		this.window.setAutoRequestFocus(true);
		this.window.setResizable(true);
		this.window.add(this.game.getCanvas());
		this.window.pack();
		this.window.addComponentListener(new GamePanelComponentResize(this.game));

		this.window.setLocationRelativeTo(null);
		this.window.setVisible(true);
		this.game.startGameThread();
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title)
	{
		this.window.setTitle(title);
	}

	/**
	 * Sets the icon.
	 *
	 * @param resourcePath the new icon
	 */
	public void setIcon(String resourcePath)
	{
		this.window.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(resourcePath)))
				.getImage());
	}
	
	/**
	 * Stop.
	 */
	protected void stop()
	{
		this.window.dispose();
	}
}