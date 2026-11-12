package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.IGame;
import br.com.ajf.simplegamelibrary.model.Scene;

import java.awt.*;

public final class TestScene implements Scene
{
    private boolean start = false;
    private boolean stop = false;
    private boolean active = true;
    private boolean visible = true;
    
    private IGame game;
    
    public TestScene(IGame game)
    {
        this.game = game;
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(Color.RED);
        g2d.fillRect(0,0,720,576);
    }
    
    @Override
    public boolean isActive()
    {
        return this.active;
    }
    
    @Override
    public boolean isStarted()
    {
        return this.start;
    }
    
    @Override
    public void start()
    {
    
    }
    
    @Override
    public void setStart(boolean b)
    {
        this.start = b;
    }
    
    @Override
    public void update()
    {
    
    }
    
    @Override
    public boolean isVisible()
    {
        return this.visible;
    }
    
    @Override
    public boolean isStopped()
    {
        return this.stop;
    }
    
    @Override
    public void setStop(boolean b)
    {
        this.stop = b;
    }
    
    @Override
    public void stop()
    {
    
    }
    
    @Override
    public void resize(int x, int y, int width, int height)
    {
    
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
}
