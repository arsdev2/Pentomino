package ua.pp.blastorq.pentomino.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ua.pp.blastorq.pentomino.Area;
import ua.pp.blastorq.pentomino.Constants;
import ua.pp.blastorq.pentomino.Direction;
import ua.pp.blastorq.pentomino.Pentomino;
import ua.pp.blastorq.pentomino.actors.Button;
import ua.pp.blastorq.pentomino.actors.GoToMainMenuScreenButton;
import ua.pp.blastorq.pentomino.actors.Arrow;

import static ua.pp.blastorq.pentomino.Constants.*;
public class GameScreen implements Screen {
    public static Texture color_dviolet,color_black,
            color_dblue, color_dgreen, color_dred, color_red, color_yellow, color_lblue
            , color_lviolet, color_orange, color_sgreen, color_lgreen,
            color_empty, color_border, left_arrow, right_arrow, up_arrow, down_arrow, rotate_left, rotate_right;
    public static SpriteBatch batch;
    Button[] buttons = new Button[12];
    Vector2 l_arrow, r_arrow, u_arrow, d_arrow;
    private Area area;
    private Pentomino game;
    private Arrow arrow_left_button, arrow_right_button, arrow_up_button, arrow_down_button, rotate_left_button, rotate_right_button;
    private Stage stage;
    private GoToMainMenuScreenButton goToMainMenuScreenButton;
    public GameScreen(Pentomino game) {
        this.game = game;
        Viewport viewport = new StretchViewport(V_WIDTH, V_HEIGHT);
        stage = new Stage(viewport);
        goToMainMenuScreenButton = new GoToMainMenuScreenButton(game);
        stage.addActor(goToMainMenuScreenButton);
        rotate_left = new Texture("rotate_left.png");
        rotate_right = new Texture("rotate_right.png");
        color_black = new Texture("color_black.png");
        color_dblue = new Texture("color_dblue.png");
        color_dred = new Texture("color_dred.png");
        color_dgreen = new Texture("color_dgreen.png");
        color_red = new Texture("color_red.png");
        color_dviolet = new Texture("color_fiolet.png");
        color_yellow = new Texture("color_yellow.png");
        color_lblue = new Texture("color_lblue.png");
        color_lviolet = new Texture("color_lfiolet.png");
        color_orange = new Texture("color_orange.png");
        color_sgreen = new Texture("color_sgreen.png");
        color_lgreen = new Texture("color_lgreen.png");
        color_empty = new Texture("color_empty.png");
        color_border = new Texture("color_border.png");

        left_arrow = new Texture("left-arrow.png");
        right_arrow = new Texture("right-arrow.png");
        up_arrow = new Texture("up-arrow.png");
        down_arrow = new Texture("down-arrow.png");
        l_arrow = new Vector2(Constants.V_WIDTH - 50-50-50, 0);
        r_arrow = new Vector2(Constants.V_WIDTH - 50, 0);
        u_arrow = new Vector2(Constants.V_WIDTH - 50-50, 50);
        d_arrow = new Vector2(Constants.V_WIDTH - 50-50, 0);
        area = new Area();
        arrow_left_button = new Arrow(l_arrow, Direction.LEFT, area);
        arrow_right_button = new Arrow(r_arrow, Direction.RIGHT, area);
        arrow_up_button = new Arrow(u_arrow, Direction.UP, area);
        arrow_down_button = new Arrow(d_arrow, Direction.DOWN, area);
        rotate_left_button = new Arrow(new Vector2(Constants.V_WIDTH - 50-50-50, 50),Direction.LEFT_ROTATE, area);
        rotate_right_button = new Arrow(new Vector2(Constants.V_WIDTH - 50, 50),Direction.RIGHT_ROTATE, area);
        stage.addActor(arrow_left_button);
        stage.addActor(arrow_right_button);
        stage.addActor(arrow_up_button);
        stage.addActor(arrow_down_button);
        stage.addActor(rotate_left_button);
        stage.addActor(rotate_right_button);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);

        for(int i=0; i<12; i++){
            Vector2 pos = new Vector2(30+50*i+5, 400);
            buttons[i] = new Button(pos, i, area);
            stage.addActor(buttons[i]);
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(left_arrow, Constants.V_WIDTH - 50-50-50, 0, 50, 50);
        batch.draw(right_arrow, Constants.V_WIDTH - 50, 0, 50, 50);
        batch.draw(up_arrow, Constants.V_WIDTH - 50-50, 50, 50, 50);
        batch.draw(down_arrow, Constants.V_WIDTH - 50-50, 0, 50, 50);
        batch.draw(rotate_left, Constants.V_WIDTH - 50-50-50, 50, 50, 50);
        batch.draw(rotate_right, Constants.V_WIDTH - 50, 50, 50, 50);
        batch.end();
        area.render();
        stage.act(delta);
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
