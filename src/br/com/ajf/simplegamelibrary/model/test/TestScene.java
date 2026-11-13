package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.core.IGame;
import br.com.ajf.simplegamelibrary.model.scenes.Scene;

import java.awt.*;
import java.awt.event.*;

public final class TestScene implements Scene
{
    private float speed = 120.f;
    public final IGame game;
    private boolean start = false;
    private boolean stop = false;
    private boolean active = false;
    private boolean visible = false;
    private int size = 32;
    private int x, y;
    private boolean right;
    private boolean down;
    private boolean left;
    private boolean up;
    
    public TestScene(IGame game)
    {
        this.game = game;
        setVisible(true);
        setActive(true);
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, size, size);
        System.out.println("draw");
    }
    
    @Override
    public boolean isActive()
    {
        return this.active;
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    @Override
    public boolean isStarted()
    {
        return this.start;
    }
    
    @Override
    public void start()
    {
        System.out.println("Start");
        x = 332;
        y = 432;
        speed = 128f;
        size = 48;
    }
    
    @Override
    public void setStart(boolean b)
    {
        this.start = b;
    }
    
    @Override
    public void update(float delta)
    {
        System.out.println("update:" + delta);
        
        if (up)
        {
            y -= (int) (speed * delta);
        }
        else if (down)
        {
            y += (int) (speed * delta);
        }
        else if (left)
        {
            x -= (int) (speed * delta);
        }
        else if (right)
        {
            x += (int) (speed * delta);
        }
    }
    
    @Override
    public boolean isVisible()
    {
        return this.visible;
    }
    
    public void setVisible(boolean visible)
    {
        this.visible = visible;
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
        System.out.println("Stop");
    }
    
    @Override
    public void resize(int x, int y, int width, int height)
    {
        System.out.println("Resize(x= " + x + ", y= " + y + "| width= " + width + ", height= " + height + ")");
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = true;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
    }
}