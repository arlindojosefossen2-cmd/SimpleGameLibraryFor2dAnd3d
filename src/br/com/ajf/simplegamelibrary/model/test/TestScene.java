package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.IGame;
import br.com.ajf.simplegamelibrary.model.Scene;

import java.awt.*;
import java.awt.event.*;

public final class TestScene implements Scene
{
    private boolean start = true;
    private boolean stop = false;
    private boolean active = true;
    private boolean visible = true;
    
    private int size = 32;
    private int x,y;
    private final float speed = 120.f;
    
    private final IGame game;
    private boolean moving;
    private boolean right;
    private boolean down;
    private boolean left;
    private boolean up;
    
    public TestScene(IGame game)
    {
        this.game = game;
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        g2d.setColor(Color.RED);
        g2d.fillRect(x,y,size,size);
        System.out.println("draw");
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
        System.out.println("Start");
    }
    
    @Override
    public void setStart(boolean b)
    {
        this.start = b;
    }
    
    @Override
    public void update(float delta)
    {
        System.out.println("update:"+delta);
        
        if(moving)
        {
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
        System.out.println("Stop");
    }
    
    @Override
    public void resize(int oldWidth, int oldHeight, int width, int height)
    {
        System.out.println("resize(oldWidth= "+oldWidth+", oldHeight= "+oldHeight+"| newWidth= "+width+", newHeight= "+height+")");
        game.getCanvas().getGraphics().setColor(Color.BLUE);
        if(oldWidth < width)
            size = 64;
        else if(oldWidth > width)
            size = 32;
        
    }
    
    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = true;
            moving = true;
        }
        else  if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = true;
            moving = true;
        }
        else  if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = true;
            moving = true;
        }
        else  if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = true;
            moving = true;
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            up = false;
            moving = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            down = false;
            moving = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
            moving = false;
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
            moving = false;
        }
    }
}