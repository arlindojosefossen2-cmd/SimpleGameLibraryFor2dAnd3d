package br.com.ajf.simplegamelibrary.model.utils;

import br.com.ajf.simplegamelibrary.model.core.IGame;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The Class GamePanelComponentResize.
 */
public final class GamePanelComponentResize extends ComponentAdapter
{
    /** The game. */
    private final IGame game;
    
    /**
     * Instantiates a new game panel component resize.
     *
     * @param game the game
     */
    public GamePanelComponentResize(IGame game)
    {
        this.game = game;
    }
    
    /**
     * Component hidden.
     *
     * @param eventComponent the event component
     */
    @Override
    public void componentHidden(ComponentEvent eventComponent)
    {
    	 this.game.resize(eventComponent.getComponent().getX(),eventComponent.getComponent().getY(),eventComponent.getComponent().getWidth(), eventComponent.getComponent().getHeight());
    }
    
    /**
     * Component resized.
     *
     * @param eventComponent the event component
     */
    @Override
    public void componentResized(ComponentEvent eventComponent)
    {
        this.game.resize(eventComponent.getComponent().getX(),eventComponent.getComponent().getY(),eventComponent.getComponent().getWidth(), eventComponent.getComponent().getHeight());
    }
    
    /**
     * Component shown.
     *
     * @param eventComponent the event component
     */
    @Override
    public void componentShown(ComponentEvent eventComponent)
    {
    	 this.game.resize(eventComponent.getComponent().getX(),eventComponent.getComponent().getY(),eventComponent.getComponent().getWidth(), eventComponent.getComponent().getHeight());
    }
}