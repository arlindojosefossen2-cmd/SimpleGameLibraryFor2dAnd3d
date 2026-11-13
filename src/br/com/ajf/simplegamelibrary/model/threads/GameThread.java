package br.com.ajf.simplegamelibrary.model.threads;

import br.com.ajf.simplegamelibrary.model.core.Game;
import br.com.ajf.simplegamelibrary.model.core.IGame;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class GameThread implements Runnable
{
    public final int fps;
    private final IGame game;
    private final ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();
    private volatile boolean running;
    
    public GameThread(Game game, int fps)
    {
        this.game = game;
        this.fps = fps;
    }
    
    public void stop()
    {
        running = false;
        es.shutdownNow();
    }
    
    public void start()
    {
        running = true;
        es.execute(this);
    }
    
    @Override
    public void run()
    {
        final double drawInterval = (double) 1_000_000_000 / this.fps;
        double delta = 0.;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (running)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            
            if (delta >= 1)
            {
                game.update();
                delta--;
            }
        }
    }
    
    public int fps()
    {
        return fps;
    }
}
