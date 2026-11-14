package br.com.ajf.simplegamelibrary.model.threads;

import br.com.ajf.simplegamelibrary.model.core.Game;
import br.com.ajf.simplegamelibrary.model.core.IGame;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * The Class GameThread.
 * 
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 * {@link Runnable}
 */
public final class GameThread implements Runnable
{
    /** The Constant ONE_INT. */
    private static final int ONE_INT = 1;

	/** The fps. */
    private final int fps;
    
    /** The game. */
    private final IGame game;
    
    /** The scheduleExecutorService. */
    private final ScheduledExecutorService scheduleExecutorService = Executors.newSingleThreadScheduledExecutor();
    
    /** The running. */
    private boolean running;
    
    /** The delta. */
    private float delta;
    
    /**
     * Instantiates a new game thread.
     *
     * @param game the game
     * @param fps the fps
     */
    public GameThread(Game game, int fps)
    {
        this.game = game;
        this.fps = fps;
    }
    
    /**
     * Stop.
     */
    public void stop()
    {
        running = false;
        scheduleExecutorService.shutdownNow();
    }
    
    /**
     * Start.
     */
    public void start()
    {
        running = true;
        scheduleExecutorService.execute(this);
    }
    
    /**
     * Run.
     */
    @Override
    public void run()
    {
        final double drawInterval = (double) 1_000_000_000 / this.fps;
      
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (running)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            
            if (delta >= ONE_INT)
            {
                game.update();
                delta--;
            }
        }
    }
    
    /**
     * Fps.
     *
     * @return the int
     */
    public float getFps()
    {
        return delta;
    }
}