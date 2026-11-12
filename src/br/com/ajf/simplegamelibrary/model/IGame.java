package br.com.ajf.simplegamelibrary.model;

import javax.swing.*;
import java.awt.*;

public interface IGame extends GameInput
{
    void start();
    
    void addScene(Scene newScene);
    
    void draw(Graphics2D g2d);
    
    void update();
    
    void pause();
    
    void resize(int x, int y, int width, int height);
    
    void setTitle(String title);
    
    void setIcon(String resourcePath);
    
    void stop();
    
    JPanel getCanvas();
    
    void startGameThread();
    
    void resizeScene(int x, int y, int width, int height);
}