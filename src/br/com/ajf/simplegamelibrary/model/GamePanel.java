package br.com.ajf.simplegamelibrary.model;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public final class GamePanel
{
    private final IGame game;
    private final JPanel canvas;
    private BufferedImage image;
    private Graphics2D graphics2D;
    
    public GamePanel(Game game, int width, int height)
    {
        this.game = game;
        this.canvas = createCanvas(game, width, height);
    }
    
    private static void createDefaultCanvasSet(Game game, int width, int height, JPanel canvas)
    {
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.addComponentListener(new GamePanelComponentResize(game));
        canvas.setBackground(Color.BLACK);
        canvas.setDoubleBuffered(true);
    }
    
    private static void createInputs(Game game, JPanel canvas)
    {
        canvas.addKeyListener(game.getInputProcessor());
        canvas.addMouseListener(game.getInputProcessor());
        canvas.addMouseMotionListener(game.getInputProcessor());
        canvas.addMouseWheelListener(game.getInputProcessor());
        canvas.setFocusable(true);
    }
    
    private JPanel createCanvas(Game game, int width, int height)
    {
        final JPanel canvas = new JPanel();
        createImage(width, height);
        
        createDefaultCanvasSet(game, width, height, canvas);
        
        createInputs(game, canvas);
        return canvas;
    }
    
    private void createImage(int width, int height)
    {
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.graphics2D = image.createGraphics();
    }
    
    public void draw()
    {
        if (ifNotDraw())
        {
            return;
        }
        drawToImage();
        drawToScreen();
    }
    
    private boolean ifNotDraw()
    {
        return image == null || canvas == null || graphics2D == null;
    }
    
    private void drawToScreen()
    {
        final Graphics g = this.canvas.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
    }
    
    private void drawToImage()
    {
        this.graphics2D.clearRect(0, 0, image.getWidth(), image.getHeight());
        game.draw(graphics2D);
    }
    
    public void resize(int x, int y, int width, int height)
    {
        if (graphics2D != null)
        {
            graphics2D.dispose();
        }
        game.resizeScene(x, y, image.getWidth(), image.getHeight());
        this.canvas.setSize(width, height);
        createImage(width, height);
        this.graphics2D.drawImage(image, width, height, null);
    }
    
    public void stop()
    {
        if (graphics2D != null)
        {
            graphics2D.dispose();
        }
    }
    
    public JPanel get()
    {
        return this.canvas;
    }
}