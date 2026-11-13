package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.Game;
import br.com.ajf.simplegamelibrary.model.IGame;

public final class MainGameTest
{
    private MainGameTest()
    {
    
    }
    
    static void main()
    {
        final IGame game = new Game("Test", 720, 576, 30);
        game.setIcon("/icon/rob.png");
        game.addScene(new TestScene(game));
        game.start();
    }
}