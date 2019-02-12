package ua.pp.blastorq.pentomino.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ua.pp.blastorq.pentomino.Pentomino;
import ua.pp.blastorq.pentomino.screens.HowToScreen;

public class HowToButton extends Actor{
    private final Pentomino game;
    public HowToButton(Vector2 vector2, final Pentomino game) {
        this.game = game;
        setBounds(vector2.x, vector2.y, 550 - (Gdx.graphics.getWidth() / 2 - 200), 80);
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Button Pressed", "HowTo");
                game.setScreen(new HowToScreen());
                    super.touchUp(event, x, y, pointer, button);
                }
        });
    }
}