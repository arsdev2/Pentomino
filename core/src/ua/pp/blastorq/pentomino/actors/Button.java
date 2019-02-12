package ua.pp.blastorq.pentomino.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ua.pp.blastorq.pentomino.Area;
import ua.pp.blastorq.pentomino.Direction;
import ua.pp.blastorq.pentomino.screens.GameScreen;

public class Button extends Actor {
    public int n;
    public boolean isUsed = false;
    public Button(Vector2 vector2, final int n, final Area area) {
        this.n = n;
        setBounds(vector2.x, vector2.y, 40, 64);
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button){
                if(isUsed  && area.tryRemove(n)){
                    isUsed = false;
                }
                else if(!isUsed && area.tryAdd(n)) {
                    isUsed = true;
                }

                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        int b = isUsed ? 5 : 2;
        batch.draw(getTextureByColor(-1), this.getX(), this.getY(), this.getWidth(), this.getHeight());
        batch.draw(getTextureByColor(this.n+1), this.getX()+b, this.getY()+b, this.getWidth()-b*2, this.getHeight()-b*2);
        super.draw(batch, parentAlpha);
    }

    private Texture getTextureByColor(int color){
        Texture ret;
        color = color % 100;
        switch (color){
            case -1:
                ret = GameScreen.color_border;
                break;
            case 0:
                ret = GameScreen.color_empty;
                break;
            case 1:
                return GameScreen.color_black;
            case 2:
                ret = GameScreen.color_dblue;
                break;
            case 3:
                ret = GameScreen.color_dgreen;
                break;
            case 4:
                ret = GameScreen.color_red;
                break;
            case 5:
                ret = GameScreen.color_dviolet;
                break;
            case 6:
                ret = GameScreen.color_yellow;
                break;
            case 7:
                ret = GameScreen.color_lblue;
                break;
            case 8:
                ret = GameScreen.color_lviolet;
                break;
            case 9:
                ret = GameScreen.color_orange;
                break;
            case 10:
                ret = GameScreen.color_dred;
                break;
            case 11:
                ret = GameScreen.color_sgreen;
                break;
            case 12:
                ret = GameScreen.color_lgreen;
                break;
            default: ret = null;
        };
        return ret;
    }
}
