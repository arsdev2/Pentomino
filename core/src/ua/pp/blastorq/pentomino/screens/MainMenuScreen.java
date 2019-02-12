package ua.pp.blastorq.pentomino.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import ua.pp.blastorq.pentomino.Pentomino;
import ua.pp.blastorq.pentomino.actors.ExitGameButton;
import ua.pp.blastorq.pentomino.actors.HowToButton;
import ua.pp.blastorq.pentomino.actors.StartGameButton;

public class MainMenuScreen implements Screen {
    private ShapeRenderer renderer;
    private Vector2 StartOfStartGameButton, EndOfStartGameButton, StartOfHowToButton, EndOfHowToButton, StartOfExitGameButton, EndOfExitGameButton;
    private Stage stage;
    private BitmapFont bitmapFont;
    private SpriteBatch batch;
    Pentomino game;
    public MainMenuScreen(Pentomino game) {
        this.game = game;
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        StartOfStartGameButton = new Vector2(Gdx.graphics.getWidth()/2 -200, 380);
        EndOfStartGameButton = new Vector2(550, 380);
        StartOfHowToButton = new Vector2(Gdx.graphics.getWidth()/2 -200, 270);
        EndOfHowToButton = new Vector2(550, 270);
        StartOfExitGameButton = new Vector2(Gdx.graphics.getWidth()/2 -200, 160);
        EndOfExitGameButton = new Vector2(550, 160);
        StartGameButton StartGameButton = new StartGameButton(StartOfStartGameButton, game);
        HowToButton HowToButton = new HowToButton(StartOfHowToButton, game);
        ExitGameButton ExitGameButton = new ExitGameButton(StartOfExitGameButton);
        Viewport viewport = new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage = new Stage(viewport);
        stage.addActor(StartGameButton);
        stage.addActor(HowToButton);
        stage.addActor(ExitGameButton);
        bitmapFont = new BitmapFont(Gdx.files.internal("fonts/words.fnt"));
        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.rectLine(StartOfStartGameButton, EndOfStartGameButton, 80);
        renderer.rectLine(StartOfHowToButton, EndOfHowToButton, 80);
        renderer.rectLine(StartOfExitGameButton, EndOfExitGameButton, 80);
        renderer.end();
        batch.begin();
        bitmapFont.draw(batch, "PLAY GAME", StartOfStartGameButton.x + 30, StartOfStartGameButton.y +25);
        bitmapFont.draw(batch, "HOW TO", StartOfHowToButton.x + 80, StartOfHowToButton.y +25);
        bitmapFont.draw(batch, "EXIT GAME", StartOfExitGameButton.x + 30, StartOfExitGameButton.y +25);
        batch.end();
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
