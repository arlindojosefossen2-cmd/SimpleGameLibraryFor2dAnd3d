package br.com.ajf.simplegamelibrary.model;

import java.awt.event.*;

public final class GamePanelComponentResize extends ComponentAdapter
{
    private final IGame game;
    
    public GamePanelComponentResize(Game game)
    {
        this.game = game;
    }
    
    @Override
    public void componentResized(ComponentEvent e)
    {
        this.game.resize(e.getComponent().getX(), e.getComponent().getY(), e.getComponent().getWidth(), e.getComponent().getHeight());
    }
}