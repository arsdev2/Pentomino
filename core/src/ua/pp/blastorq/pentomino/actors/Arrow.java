package ua.pp.blastorq.pentomino.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import ua.pp.blastorq.pentomino.Area;
import ua.pp.blastorq.pentomino.Direction;

public class Arrow extends Actor {

    public Arrow(Vector2 vector2, final Direction d, final Area area) {
        setBounds(vector2.x, vector2.y, 50, 50);
        addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return super.touchDown(event, x, y, pointer, button);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                switch (d) {
                    case UP:
                        Gdx.app.log("Button Pressed", "UP");
                        if(area.tryRemoveFigure(area.currentColor)){
                            if(area.currentT>0)area.currentT--;
                            if(area.tryAddFigure(area.currentColor, area.currentT, area.currentL)){
                                Gdx.app.log("Figure moved", "UP");
                            }else{
                                area.currentT++;
                                area.tryAddFigure(area.currentColor, area.currentT, area.currentL);
                            }
                        }
                        break;

                    case DOWN:
                        Gdx.app.log("Button Pressed", "DOWN");
                        if(area.tryRemoveFigure(area.currentColor)){
                            if(area.currentT<area.mH)area.currentT++;
                            if(area.tryAddFigure(area.currentColor, area.currentT, area.currentL)){
                                Gdx.app.log("Figure moved", "DOWN");
                            }else{
                                area.currentT--;
                                area.tryAddFigure(area.currentColor, area.currentT, area.currentL);
                            }
                        }
                        break;
                    case LEFT:
                        Gdx.app.log("Button Pressed", "LEFT");
                        if(area.tryRemoveFigure(area.currentColor)){
                            if(area.currentL>0)area.currentL--;
                            if(area.tryAddFigure(area.currentColor, area.currentT, area.currentL)){
                                Gdx.app.log("Figure moved", "LEFT");
                            }else{
                                area.currentL++;
                                area.tryAddFigure(area.currentColor, area.currentT, area.currentL);
                            }
                        }
                        break;
                    case RIGHT:
                        Gdx.app.log("Button Pressed", "RIGHT");
                        if(area.tryRemoveFigure(area.currentColor)){
                            if(area.currentL<area.mW)area.currentL++;
                            if(area.tryAddFigure(area.currentColor, area.currentT, area.currentL)){
                                Gdx.app.log("Figure moved", "RIGHT");
                            }else{
                                area.currentL--;
                                area.tryAddFigure(area.currentColor, area.currentT, area.currentL);
                            }
                        }
                        break;
                    case RIGHT_ROTATE:
                        Gdx.app.log("RIGHT", "ROTATE");
                        area.tryRotate(Direction.RIGHT_ROTATE);
                        break;
                    case LEFT_ROTATE:
                        Gdx.app.log("LEFT", "ROTATE");
                        area.tryRotate(Direction.LEFT_ROTATE);
                        break;
                    default:
                        break;

                }
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }
}
