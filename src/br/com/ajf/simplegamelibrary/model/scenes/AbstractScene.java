package br.com.ajf.simplegamelibrary.model.scenes;

import br.com.ajf.simplegamelibrary.model.core.IGame;

/**
 * The Class AbstractScene.
 *
 * @author Arlindo Jose Fossem . Date: Nov 13, 2026.
 * @version 1.0v.
 * @since 1.5v.
 * {@link Scene}
 */
public abstract class AbstractScene implements Scene
{
	/** The game. */
	protected final IGame game;
	
	/** The start. */
	protected boolean start = true;
	
	/** The stop. */
	protected boolean stop;
	
	/** The visible. */
	protected boolean visible = true;
	
	/** The active. */
	protected boolean active = true;
	
	/**
	 * Instantiates a new abstract scene.
	 *
	 * @param game the game
	 */
	public AbstractScene(IGame game)
	{
		this.game = game;
	}
	

	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	@Override
	public boolean isActive()
	{	
		return active;
	}

	/**
	 * Checks if is started.
	 *
	 * @return true, if is started
	 */
	@Override
	public boolean isStarted()
	{
		return start;
	}

	/**
	 * Sets the start.
	 *
	 * @param start the new start
	 */
	@Override
	public void setStart(boolean start)
	{
		this.start = start;
	}

	/**
	 * Checks if is visible.
	 *
	 * @return true, if is visible
	 */
	@Override
	public boolean isVisible()
	{
		return visible;
	}

	/**
	 * Checks if is stopped.
	 *
	 * @return true, if is stopped
	 */
	@Override
	public boolean isStopped()
	{
		return stop;
	}

	/**
	 * Sets the stop.
	 *
	 * @param stop the new stop
	 */
	@Override
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
	
	/**
	 * Sets the visible.
	 *
	 * @param visible the new visible
	 */
	@Override
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	@Override
	public void setActive(boolean active)
	{
		this.active = active;
	}
}