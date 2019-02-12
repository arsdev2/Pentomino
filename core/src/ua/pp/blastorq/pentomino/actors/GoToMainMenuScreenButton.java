package ua.pp.blastorq.pentomino.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ua.pp.blastorq.pentomino.Pentomino;
import ua.pp.blastorq.pentomino.screens.MainMenuScreen;

public class GoToMainMenuScreenButton extends Actor{
    Pentomino game;
    Texture icon;
    public GoToMainMenuScreenButton(final Pentomino game) {
        this.game = game;
        icon = new Texture("exit.png");
        setBounds(0, 0, icon.getWidth(), icon.getHeight());
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(icon, getX(), getY(), getWidth(), getHeight());
        super.draw(batch, parentAlpha);
    }
}