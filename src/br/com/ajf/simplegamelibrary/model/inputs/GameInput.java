package br.com.ajf.simplegamelibrary.model.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * The Interface GameInput. <p>Simple template for inputs.</p>
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 */
public interface GameInput
{
    
    /**
     * Key typed.
     *
     * @param event the event
     */
    default void keyTyped(KeyEvent event)
    {
    
    }
    
    /**
     * Key pressed.
     *
     * @param event the event
     */
    default void keyPressed(KeyEvent event)
    {
    
    }
    
    /**
     * Key released.
     *
     * @param event the event
     */
    default void keyReleased(KeyEvent event)
    {
    
    }
    
    /**
     * Mouse clicked.
     *
     * @param event the event
     */
    default void mouseClicked(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse pressed.
     *
     * @param event the event
     */
    default void mousePressed(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse released.
     *
     * @param event the event
     */
    default void mouseReleased(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse entered.
     *
     * @param event the event
     */
    default void mouseEntered(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse exited.
     *
     * @param event the event
     */
    default void mouseExited(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse dragged.
     *
     * @param event the event
     */
    default void mouseDragged(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse moved.
     *
     * @param event the event
     */
    default void mouseMoved(MouseEvent event)
    {
    
    }
    
    /**
     * Mouse wheel moved.
     *
     * @param event the event
     */
    default void mouseWheelMoved(MouseWheelEvent event)
    {
    
    }
}