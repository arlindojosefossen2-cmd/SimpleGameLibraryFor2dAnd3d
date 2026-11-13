package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.utils.GamePanelComponentResize;
import br.com.ajf.simplegamelibrary.model.utils.GameWindowClosing;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public final class GameWindow
{
    private final IGame game;
    private final JFrame window;
    
    public GameWindow(Game game, String title)
    {
        this.game = game;
        this.window = new JFrame(title);
    }
    
    public void init()
    {
        EventQueue.invokeLater(() ->
        {
            this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.window.addWindowListener(new GameWindowClosing(this.game));
            this.window.setAutoRequestFocus(true);
            this.window.add(this.game.getCanvas());
            this.window.pack();
            this.window.addComponentListener(new GamePanelComponentResize(this.game));
            
            this.window.setLocationRelativeTo(null);
            this.window.setVisible(true);
            this.game.startGameThread();
        });
    }
    
    public void setTitle(String title)
    {
        this.window.setTitle(title);
    }
    
    public void setIcon(String resourcePath)
    {
        this.window.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource(resourcePath))).getImage());
    }
}