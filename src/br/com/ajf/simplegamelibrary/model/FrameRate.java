package br.com.ajf.simplegamelibrary.model;

public class FrameRate
{
    private String frameRate;
    
    private long lastTime;
    
    private float delta;
    
    private int frameCounter;
    
    public FrameRate()
    {
    
    }
    
    public void initialize()
    {
        lastTime = System.currentTimeMillis();
        frameRate = "";
    }
    
    public void calculate()
    {
        final long current = System.currentTimeMillis();
        delta += current - lastTime;
        lastTime = current;
        frameCounter++;
        
        if (delta <= 1000)
        {
            return;
        }
        
        delta -= 1000;
        frameRate = String.format(String.valueOf(frameCounter));
        frameCounter = 0;
    }
    
    public String getFrameRate()
    {
        return frameRate;
    }
}