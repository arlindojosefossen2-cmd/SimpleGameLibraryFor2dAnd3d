package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.inputs.InputProcessor;
import br.com.ajf.simplegamelibrary.model.scenes.Scene;
import br.com.ajf.simplegamelibrary.model.threads.GameThread;
import br.com.ajf.simplegamelibrary.model.utils.FrameRate;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

/**
 * The Class Game.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link IGame}
 */
public final class Game implements IGame
{
    /** The game window. */
    private final GameWindow gameWindow;
    
    /** The game panel. */
    private final GamePanel gamePanel;
    
    /** The game thread. */
    private final GameThread gameThread;
    
    /** The input processor. */
    private final InputProcessor inputProcessor;
    
    /** The frame rate. */
    private final FrameRate frameRate = new FrameRate();
    
    /** The title. */
    private String title;
    
    /** The scene. */
    private Scene scene;

	/** The resize. */
	private boolean resize;
    
    /**
     * Instantiates a new game.
     *
     * @param title the title
     * @param width the width
     * @param height the height
     * @param fps the fps
     */
    public Game(String title, int width, int height, int fps)
    {
        gameThread = new GameThread(this, fps);
        inputProcessor = new InputProcessor(this);
        gamePanel = new GamePanel(this, width, height);
        gameWindow = new GameWindow(this, title);
        setTitle(title);
    }
    
    /**
     * Start.
     */
    @Override
    public void start()
    {
        this.gameWindow.init();
        this.frameRate.initialize();
    }
    
    /**
     * Adds the scene.
     *
     * @param newScene the new scene
     */
    @Override
    public void addScene(Scene newScene)
    {
        this.scene = newScene;
    }
    
    /**
     * Resize.
     *
     * @param xPos the x pos
     * @param yPos the y pos
     * @param width the width
     * @param height the height
     */
    @Override
    public void resize(int xPos,int yPos,int width, int height)
    {
        this.scene.resize(xPos,yPos,width,height);
        this.gamePanel.resize(width, height);
    }
    
    /**
     * Draw.
     *
     * @param g2d the g 2 d
     */
    @Override
    public void draw(Graphics2D g2d)
    {
        this.scene.draw(g2d);
    }
    
    /**
     * Update.
     */
    @Override
    public void update()
    {
        this.frameRate.calculate();
        
        if (!this.scene.isActive())
        {
            this.gamePanel.draw();
            return;
        }
        
        if (!this.scene.isStarted())
        {
            this.scene.start();
            this.scene.setStart(true);
        }
        
        this.scene.update(1f / gameThread.getFps());
        
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
    
    /**
     * Sets the title.
     */
    public void setTitle()
    {
        this.gameWindow.setTitle(String.format("%s: %s", this.title, this.frameRate.getFrameRate()));
    }
    
    /**
     * Sets the title.
     *
     * @param title the new title
     */
    @Override
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * Sets the icon.
     *
     * @param resourcePath the new icon
     */
    @Override
    public void setIcon(String resourcePath)
    {
        this.gameWindow.setIcon(resourcePath);
    }
    
    /**
     * Stop.
     */
    @Override
    public void stop()
    {
        scene.stop();
        gamePanel.stop();
        gameThread.stop();
    }
    
    /**
     * Gets the canvas.
     *
     * @return the canvas
     */
    @Override
    public JPanel getCanvas()
    {
        return this.gamePanel.get();
    }
    
    /**
     * Start game thread.
     */
    @Override
    public void startGameThread()
    {
        this.gameThread.start();
    }
    
    /**
     * Gets the input processor.
     *
     * @return the input processor
     */
    public InputProcessor getInputProcessor()
    {
        return inputProcessor;
    }
    
    /**
     * Key typed.
     *
     * @param event the event
     */
    @Override
	public void keyTyped(KeyEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.keyTyped(event);
    }
    
    /**
     * Key pressed.
     *
     * @param event the event
     */
    @Override
	public void keyPressed(KeyEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.keyPressed(event);
    }
    
    /**
     * Key released.
     *
     * @param event the event
     */
    @Override
	public void keyReleased(KeyEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.keyReleased(event);
    }
    
    /**
     * Mouse clicked.
     *
     * @param event the event
     */
    @Override
	public void mouseClicked(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseClicked(event);
    }
    
    /**
     * Mouse pressed.
     *
     * @param event the event
     */
    @Override
	public void mousePressed(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mousePressed(event);
    }
    
    /**
     * Mouse released.
     *
     * @param event the event
     */
    @Override
	public void mouseReleased(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mouseReleased(event);
    }
    
    /**
     * Mouse entered.
     *
     * @param event the event
     */
    @Override
	public void mouseEntered(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseEntered(event);
    }
    
    /**
     * Mouse exited.
     *
     * @param event the event
     */
    @Override
	public void mouseExited(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        this.scene.mouseExited(event);
    }
    
    /**
     * Mouse dragged.
     *
     * @param event the event
     */
    @Override
	public void mouseDragged(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseDragged(event);
    }
    
    /**
     * Mouse moved.
     *
     * @param event the event
     */
    @Override
	public void mouseMoved(MouseEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseMoved(event);
    }
    
    /**
     * Mouse wheel moved.
     *
     * @param event the event
     */
    @Override
	public void mouseWheelMoved(MouseWheelEvent event)
    {
        if (this.scene == null)
        {
            return;
        }
        
        this.scene.mouseWheelMoved(event);
    }

	/**
	 * Checks if is screen resize.
	 *
	 * @return true, if is screen resize
	 */
	@Override
	public boolean isScreenResize()
	{
		return this.resize;
	}

	/**
	 * Sets the screen resize.
	 *
	 * @param resize the new screen resize
	 */
	@Override
	public void setScreenResize(boolean resize)
	{
		this.resize = resize;
	}

	@Override
	public int getScreenWidth()
	{
		return this.gamePanel.getImage().getWidth();
	}

	/**
	 * Gets the screen hieght.
	 *
	 * @return the screen hieght
	 */
	@Override
	public int getScreenHieght()
	{
		return this.gamePanel.getImage().getHeight();
	}

	/**
	 * Gets the window width.
	 *
	 * @return the window width
	 */
	@Override
	public int getWindowWidth()
	{
		return this.gamePanel.get().getWidth();
	}

	/**
	 * Gets the window height.
	 *
	 * @return the window height
	 */
	@Override
	public int getWindowHeight()
	{
		return this.gamePanel.get().getHeight();
	}

	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	@Override
	public BufferedImage getBuffer()
	{
		return gamePanel.getImage();
	}
}