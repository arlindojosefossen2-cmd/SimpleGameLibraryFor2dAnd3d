package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.inputs.GameInput;
import br.com.ajf.simplegamelibrary.model.scenes.Scene;

import javax.swing.JPanel;
import java.awt.Graphics2D;

/**
 * The Interface IGame.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link GameInput}
 */
public interface IGame extends GameInput
{
    /**
     * Start.
     */
    void start();
    
    /**
     * Adds the scene.
     *
     * @param newScene the new scene
     */
    void addScene(Scene newScene);
    
    /**
     * Draw.
     *
     * @param g2d the g 2 d
     */
    void draw(Graphics2D g2d);
    
    /**
     * Update.
     */
    void update();
    
    /**
     * Resize.
     *
     * @param xPos the x pos
     * @param yPos the y pos
     * @param width the width
     * @param height the height
     */
    void resize(int xPos,int yPos,int width, int height);
    
    /**
     * Sets the title.
     *
     * @param title the new title
     */
    void setTitle(String title);
    
    /**
     * Sets the icon.
     *
     * @param resourcePath the new icon
     */
    void setIcon(String resourcePath);
    
    /**
     * Stop.
     */
    void stop();
    
    /**
     * Gets the canvas.
     *
     * @return the canvas
     */
    JPanel getCanvas();
    
    /**
     * Start game thread.
     */
    void startGameThread();
}