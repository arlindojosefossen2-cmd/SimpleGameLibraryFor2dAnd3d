package br.com.ajf.simplegamelibrary.model;

import java.awt.*;

public interface Scene extends GameInput
{
    void draw(Graphics2D g2d);
    
    boolean isActive();
    
    boolean isStarted();
    
    void start();
    
    void setStart(boolean b);
    
    void update();
    
    boolean isVisible();
    
    boolean isStopped();
    
    void setStop(boolean b);
    
    void stop();
    
    void resize(int x, int y, int width, int height);
}
