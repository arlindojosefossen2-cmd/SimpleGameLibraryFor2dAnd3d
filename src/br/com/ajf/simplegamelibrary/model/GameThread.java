package br.com.ajf.simplegamelibrary.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class GameThread implements Runnable
{
    private final IGame game;
    final int fps;
    private volatile boolean running;
    private final ScheduledExecutorService es =  Executors.newSingleThreadScheduledExecutor();
    
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
       
       while(running)
       {
           currentTime = System.nanoTime();
           delta += (currentTime-lastTime)/drawInterval;
           lastTime = currentTime;
           
           if(delta >= 1)
           {
               game.update();
               delta--;
           }
       }
    }
}
