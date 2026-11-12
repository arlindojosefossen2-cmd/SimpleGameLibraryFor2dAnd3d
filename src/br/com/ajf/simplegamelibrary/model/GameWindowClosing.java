package br.com.ajf.simplegamelibrary.model;

import java.awt.event.*;

public final class GameWindowClosing extends WindowAdapter
{
    private final IGame game;
    
    public GameWindowClosing(IGame game)
    {
        this.game = game;
    }
    
    @Override
    public void windowClosing(WindowEvent e)
    {
        this.game.stop();
    }
}