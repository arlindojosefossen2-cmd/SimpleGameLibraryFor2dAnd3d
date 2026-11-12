package br.com.ajf.simplegamelibrary.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class Game implements IGame
{
    private final GameWindow gameWindow;
    private final GamePanel gamePanel;
    private final GameThread gameThread;
    private final InputProcessor inputProcessor;
    private final FrameRate frameRate = new FrameRate();
    private String title;
    
    private Scene scene;
    
    public Game(String title, int width, int height, int fps)
    {
        gameThread = new GameThread(this, fps);
        inputProcessor = new InputProcessor(this);
        gamePanel = new GamePanel(this, width, height);
        gameWindow = new GameWindow(this, title);
        this.title = title;
    }
    
    @Override
    public void start()
    {
        this.gameWindow.init();
        this.frameRate.initialize();
    }
    
    @Override
    public void addScene(Scene newScene)
    {
        this.scene = newScene;
    }
    
    @Override
    public void pause()
    {
    
    }
    
    @Override
    public void resize(int x, int y, int width, int height)
    {
        this.gamePanel.resize(x, y, width, height);
    }
    
    @Override
    public void draw(Graphics2D g2d)
    {
        this.scene.draw(g2d);
    }
    
    @Override
    public void update()
    {
        if (!this.scene.isActive())
        {
            this.gamePanel.draw();
            return;
        }
        
        this.frameRate.calculate();
        
        if (!this.scene.isStarted())
        {
            this.scene.start();
            this.scene.setStart(true);
        }
        
        this.scene.update();
        
        if (this.scene.isVisible())
        {
            this.gamePanel.draw();
        }
        
        setTitle();
        
        if (!this.scene.isStopped())
        {
            return;
        }
        
        this.scene.setStop(false);
        this.scene.stop();
    }
    
    public void setTitle()
    {
        this.gameWindow.setTitle(String.format("%s: %s", this.title, this.frameRate.getFrameRate()));
    }
    
    @Override
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    @Override
    public void setIcon(String resourcePath)
    {
        this.gameWindow.setIcon(resourcePath);
    }
    
    @Override
    public void stop()
    {
        scene.stop();
        gamePanel.stop();
        gameThread.stop();
    }
    
    @Override
    public JPanel getCanvas()
    {
        return this.gamePanel.get();
    }
    
    @Override
    public void startGameThread()
    {
        this.gameThread.start();
    }
    
    public InputProcessor getInputProcessor()
    {
        return inputProcessor;
    }
    
    @Override
    public void resizeScene(int x, int y, int width, int height)
    {
        this.scene.resize(x, y, width, height);
    }
    
    public void keyTyped(KeyEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.keyTyped(e);
    }
    
    public void keyPressed(KeyEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.keyPressed(e);
    }
    
    public void keyReleased(KeyEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.keyReleased(e);
    }
    
    public void mouseClicked(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseClicked(e);
    }
    
    public void mousePressed(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mousePressed(e);
    }
    
    public void mouseReleased(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mouseReleased(e);
    }
    
    public void mouseEntered(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseEntered(e);
    }
    
    public void mouseExited(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mouseExited(e);
    }
    
    public void mouseDragged(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseDragged(e);
    }
    
    public void mouseMoved(MouseEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseMoved(e);
    }
    
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseWheelMoved(e);
    }
}