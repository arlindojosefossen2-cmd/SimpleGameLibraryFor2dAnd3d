package br.com.ajf.simplegamelibrary.model.scenes;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import br.com.ajf.simplegamelibrary.model.core.IGame;
import br.com.ajf.simplegamelibrary.model.inputs.GameInput;
import br.com.ajf.simplegamelibrary.model.inputs.Inputs;

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
	protected boolean start;
	
	/** The stop. */
	protected boolean stop;
	
	/** The visible. */
	protected boolean visible = true;
	
	/** The active. */
	protected boolean active = true;
	
	/** The inputs. */
	protected final GameInput inputs;
	
	/**
	 * Instantiates a new abstract scene.
	 *
	 * @param game the game
	 */
	public AbstractScene(IGame game)
	{
		this.game = game;
		this.inputs = new Inputs(game.getCanvas());
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

	/**
	 * Key typed.
	 *
	 * @param event the event
	 */
	@Override
	public void keyTyped(KeyEvent event)
	{
		inputs.keyTyped(event);
	}

	/**
	 * Key pressed.
	 *
	 * @param event the event
	 */
	@Override
	public void keyPressed(KeyEvent event)
	{
		inputs.keyPressed(event);
	}

	/**
	 * Key released.
	 *
	 * @param event the event
	 */
	@Override
	public void keyReleased(KeyEvent event)
	{
		inputs.keyReleased(event);
	}

	/**
	 * Mouse clicked.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseClicked(MouseEvent event)
	{
		inputs.mouseClicked(event);
	}

	/**
	 * Mouse pressed.
	 *
	 * @param event the event
	 */
	@Override
	public void mousePressed(MouseEvent event)
	{
		inputs.mousePressed(event);
	}

	/**
	 * Mouse released.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseReleased(MouseEvent event)
	{
		inputs.mouseReleased(event);
	}

	/**
	 * Mouse entered.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseEntered(MouseEvent event)
	{
		inputs.mouseEntered(event);
	}

	/**
	 * Mouse exited.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseExited(MouseEvent event)
	{
		inputs.mouseExited(event);
	}

	/**
	 * Mouse dragged.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseDragged(MouseEvent event)
	{
		inputs.mouseDragged(event);
	}

	/**
	 * Mouse moved.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseMoved(MouseEvent event)
	{
		inputs.mouseMoved(event);
	}

	/**
	 * Mouse wheel moved.
	 *
	 * @param event the event
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent event)
	{
		inputs.mouseWheelMoved(event);
	}
}