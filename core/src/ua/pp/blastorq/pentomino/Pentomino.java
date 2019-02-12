package ua.pp.blastorq.pentomino;

import com.badlogic.gdx.Game;

import ua.pp.blastorq.pentomino.screens.GameScreen;
import ua.pp.blastorq.pentomino.screens.MainMenuScreen;


public class Pentomino extends Game {

    @Override
	public void create () {
		this.setScreen(new GameScreen(this));
    }

	@Override
	public void render () {
		super.render();
	}



	@Override
	public void dispose () {

	}
}
