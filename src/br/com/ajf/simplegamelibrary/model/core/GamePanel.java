package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.utils.GamePanelComponentResize;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * The Class GamePanel.
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 */
public final class GamePanel
{
    /** The game. */
    private final IGame game;
    
    /** The canvas. */
    private final JPanel canvas;
    
    /** The image. */
    private BufferedImage image;
    
    /** The graphics 2 D. */
    private Graphics2D graphics2D;
    
    /**
     * Instantiates a new game panel.
     *
     * @param game the game
     * @param width the width
     * @param height the height
     */
    public GamePanel(Game game, int width, int height)
    {
        this.game = game;
        this.canvas = createCanvas(game, width, height);
    }
    
    /**
     * Creates the default canvas set.
     *
     * @param game the game
     * @param width the width
     * @param height the height
     * @param canvas the canvas
     */
    private static void createDefaultCanvasSet(Game game, int width, int height, JPanel canvas)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setBackground(Color.BLACK);
        canvas.addComponentListener(new GamePanelComponentResize(game));
        canvas.setDoubleBuffered(true);
    }
    
    /**
     * Creates the inputs.
     *
     * @param game the game
     * @param canvas the canvas
     */
    private static void createInputs(Game game, JPanel canvas)
    {
        canvas.addKeyListener(game.getInputProcessor());
        canvas.addMouseListener(game.getInputProcessor());
        canvas.addMouseMotionListener(game.getInputProcessor());
        canvas.addMouseWheelListener(game.getInputProcessor());
        canvas.setFocusable(true);
    }
    
    /**
     * Creates the canvas.
     *
     * @param game the game
     * @param width the width
     * @param height the height
     * @return the j panel
     */
    private JPanel createCanvas(Game game, int width, int height)
    {
        final JPanel canvas = new JPanel();
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.graphics2D = image.createGraphics();
        createDefaultCanvasSet(game, width, height, canvas);
        createInputs(game, canvas);
        return canvas;
    }
    
    /**
     * Draw.
     */
    public void draw()
    {
        if (ifNotDraw())
        {
            return;
        }
        drawToImage();
        drawToScreen();
    }
    
    /**
     * If not draw.
     *
     * @return true, if successful
     */
    private boolean ifNotDraw()
    {
        return image == null || graphics2D == null || canvas == null;
    }
    
    /**
     * Draw to screen.
     */
    private void drawToScreen()
    {
        final Graphics g = this.canvas.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
    
    /**
     * Draw to image.
     */
    private void drawToImage()
    {
        this.graphics2D.clearRect(0, 0, image.getWidth(), image.getHeight());
        game.draw(graphics2D);
    }
    
    /**
     * Resize.
     *
     * @param width the width
     * @param height the height
     */
    public void resize(int width, int height)
    {
        if (graphics2D != null)
        {
            graphics2D.dispose();
        }
        
        this.canvas.setSize(new Dimension(width, height));
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.graphics2D = image.createGraphics();
        this.graphics2D.drawImage(image, width, height, null);
    }
    
    /**
     * Stop.
     */
    public void stop()
    {
        if (graphics2D != null)
        {
            graphics2D.dispose();
        }
    }
    
    /**
     * Gets the.
     *
     * @return the j panel
     */
    public JPanel get()
    {
        return this.canvas;
    }
}