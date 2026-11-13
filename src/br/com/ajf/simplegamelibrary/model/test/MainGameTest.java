package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.core.Game;
import br.com.ajf.simplegamelibrary.model.core.IGame;

public final class MainGameTest
{
    private MainGameTest()
    {
    
    }
    
    public static void main(String[] args)
    {
        final IGame game = new Game("Test", 720, 576, 30);
        game.setIcon("/icon/rob.png");
        game.addScene(new TestScene(game));
        game.start();
    }
}