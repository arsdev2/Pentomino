package ua.pp.blastorq.pentomino.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ua.pp.blastorq.pentomino.Pentomino;
import ua.pp.blastorq.pentomino.screens.GameScreen;

public class StartGameButton extends Actor{
    Pentomino game;
    public StartGameButton(Vector2 vector2, final Pentomino game) {
        this.game = game;
        setBounds(vector2.x, vector2.y, 550 - (Gdx.graphics.getWidth() / 2 - 200), 80);
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    game.setScreen(new GameScreen(game));
                    super.touchUp(event, x, y, pointer, button);
                }
        });
    }
}