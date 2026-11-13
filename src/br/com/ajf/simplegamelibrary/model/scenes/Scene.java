package br.com.ajf.simplegamelibrary.model.scenes;

import br.com.ajf.simplegamelibrary.model.inputs.GameInput;

import java.awt.Graphics2D;

/**
 * The Interface Scene.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link GameInput}
 */
public interface Scene extends GameInput
{
    /**
     * Draw.
     *
     * @param g2d the g 2 d
     */
    void draw(Graphics2D g2d);
    
    /**
     * Checks if is active.
     *
     * @return true, if is active
     */
    boolean isActive();
    
	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	void setActive(boolean active);
    
    /**
     * Checks if is started.
     *
     * @return true, if is started
     */
    boolean isStarted();
    
    /**
     * Start.
     */
    void start();
    
    /**
     * Sets the start.
     *
     * @param start the new start
     */
    void setStart(boolean start);
    
    /**
     * Update.
     *
     * @param delta the delta
     */
    void update(float delta);
    
    /**
     * Checks if is visible.
     *
     * @return true, if is visible
     */
    boolean isVisible();
    
    /**
	 * Sets the visible.
	 *
	 * @param visible the new visible
	 */
	void setVisible(boolean visible);

    
    /**
     * Checks if is stopped.
     *
     * @return true, if is stopped
     */
    boolean isStopped();
    
    /**
     * Sets the stop.
     *
     * @param stop the new stop
     */
    void setStop(boolean stop);
    
    /**
     * Stop.
     */
    void stop();
    
    /**
     * Resize.
     *
     * @param xPos the x pos
     * @param yPos the y pos
     * @param width the width
     * @param height the height
     */
    void resize(int xPos, int yPos, int width, int height);
}