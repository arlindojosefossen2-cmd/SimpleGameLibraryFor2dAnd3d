package br.com.ajf.simplegamelibrary.model.test;

import br.com.ajf.simplegamelibrary.model.Game;
import br.com.ajf.simplegamelibrary.model.IGame;

public final class MainGameTest
{
    private MainGameTest()
    {
    
    }
    
    static void main(String[] args)
    {
        final IGame game = new Game("Test",720,576,60);
        game.addScene(new TestScene(game));
        game.start();
    }
}
