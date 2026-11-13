package br.com.ajf.simplegamelibrary.model.utils;

import br.com.ajf.simplegamelibrary.model.core.IGame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * The Class GameWindowClosing.
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link WindowAdapter}
 */
public final class GameWindowClosing extends WindowAdapter
{
    /** The game. */
    private final IGame game;
    
    /**
     * Instantiates a new game window closing.
     *
     * @param game the game
     */
    public GameWindowClosing(IGame game)
    {
        this.game = game;
    }
    
    /**
     * Window closing.
     *
     * @param eventWindow the event window
     */
    @Override
    public void windowClosing(WindowEvent eventWindow)
    {
        this.game.stop();
    }
}