package br.com.ajf.simplegamelibrary.model.inputs;

import br.com.ajf.simplegamelibrary.model.core.Game;
import br.com.ajf.simplegamelibrary.model.core.IGame;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * The Class InputProcessor.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link KeyListener}
 * {@link MouseListener}
 * {@link MouseMotionListener}
 * {@link MouseWheelListener}
 */
public final class InputProcessor implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    
    /** The game. */
    private final IGame game;
    
    /**
     * Instantiates a new input processor.
     *
     * @param game the game
     */
    public InputProcessor(Game game)
    {
        this.game = game;
    }
    
    /**
     * Key typed.
     *
     * @param event the event
     */
    @Override
    public void keyTyped(KeyEvent event)
    {
        game.keyTyped(event);
    }
    
    /**
     * Key pressed.
     *
     * @param event the event
     */
    @Override
    public void keyPressed(KeyEvent event)
    {
        game.keyPressed(event);
    }
    
    /**
     * Key released.
     *
     * @param event the event
     */
    @Override
    public void keyReleased(KeyEvent event)
    {
        game.keyReleased(event);
    }
    
    /**
     * Mouse clicked.
     *
     * @param event the event
     */
    @Override
    public void mouseClicked(MouseEvent event)
    {
        game.mouseClicked(event);
    }
    
    /**
     * Mouse pressed.
     *
     * @param event the event
     */
    @Override
    public void mousePressed(MouseEvent event)
    {
        game.mousePressed(event);
    }
    
    /**
     * Mouse released.
     *
     * @param event the event
     */
    @Override
    public void mouseReleased(MouseEvent event)
    {
        game.mouseReleased(event);
    }
    
    /**
     * Mouse entered.
     *
     * @param event the event
     */
    @Override
    public void mouseEntered(MouseEvent event)
    {
        game.mouseEntered(event);
    }
    
    /**
     * Mouse exited.
     *
     * @param event the event
     */
    @Override
    public void mouseExited(MouseEvent event)
    {
        game.mouseExited(event);
    }
    
    /**
     * Mouse dragged.
     *
     * @param event the event
     */
    @Override
    public void mouseDragged(MouseEvent event)
    {
        game.mouseDragged(event);
    }
    
    /**
     * Mouse moved.
     *
     * @param event the event
     */
    @Override
    public void mouseMoved(MouseEvent event)
    {
        game.mouseMoved(event);
    }
    
    /**
     * Mouse wheel moved.
     *
     * @param event the event
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent event)
    {
        game.mouseWheelMoved(event);
    }
}