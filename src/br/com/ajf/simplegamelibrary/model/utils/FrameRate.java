package br.com.ajf.simplegamelibrary.model.utils;

/**
 * The Class FrameRate.
 * @author Arlindo Jose Fossem
 * @version 1.2v
 * @since 1.5v
 */
public final class FrameRate
{
    /** The Constant ONE_MILLIS. */
    private static final int ONE_MILLIS = 1000;

	/** The frame rate. */
    private String frameRating;
    
    /** The last time. */
    private long lastTime;
    
    /** The delta. */
    private float delta;
    
    /** The frame counter. */
    private int frameCounter;
    
    /**
     * Instantiates a new frame rate.
     */
    public FrameRate()
    {
    
    }
    
    /**
     * Initialize.
     */
    public void initialize()
    {
        lastTime = System.currentTimeMillis();
        frameRating = "";
    }
    
    /**
     * Calculate.
     */
    public void calculate()
    {
        final long current = System.currentTimeMillis();
        delta += current - lastTime;
        lastTime = current;
        frameCounter++;
        
        if (delta <= ONE_MILLIS)
        {
            return;
        }
        
        delta -= ONE_MILLIS;
        frameRating = String.format(String.valueOf(frameCounter));
        frameCounter = 0;
    }
    
    /**
     * Gets the frame rate.
     *
     * @return the frame rate
     */
    public String getFrameRate()
    {
        return frameRating;
    }
}