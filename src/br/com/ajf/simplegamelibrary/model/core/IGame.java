package br.com.ajf.simplegamelibrary.model.core;

import br.com.ajf.simplegamelibrary.model.inputs.GameInput;
import br.com.ajf.simplegamelibrary.model.scenes.Scene;

import javax.swing.*;
import java.awt.*;

public interface IGame extends GameInput
{
    void start();
    
    void addScene(Scene newScene);
    
    void draw(Graphics2D g2d);
    
    void update();
    
    void resize(int x,int y,int width, int height);
    
    void setTitle(String title);
    
    void setIcon(String resourcePath);
    
    void stop();
    
    JPanel getCanvas();
    
    void startGameThread();
}