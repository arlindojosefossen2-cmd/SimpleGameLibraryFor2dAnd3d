package br.com.ajf.simplegamelibrary.model;

import java.awt.event.*;

public final class InputProcessor implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    private final IGame game;
    
    public InputProcessor(Game game)
    {
        this.game = game;
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        game.keyTyped(e);
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        game.keyPressed(e);
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        game.keyReleased(e);
    }
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        game.mouseClicked(e);
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        game.mousePressed(e);
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        game.mouseReleased(e);
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        game.mouseEntered(e);
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        game.mouseExited(e);
    }
    
    @Override
    public void mouseDragged(MouseEvent e)
    {
        game.mouseDragged(e);
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        game.mouseMoved(e);
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        game.mouseWheelMoved(e);
    }
}