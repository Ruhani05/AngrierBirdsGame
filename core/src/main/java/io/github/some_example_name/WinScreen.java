package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.Game.TutorialGame;

import java.util.ArrayList;

public class WinScreen extends ScreenAdapter {
    private Stage stage;
    private Game game;
    private Texture background_texture;
    private ImageButton exitButton;
    private ImageButton nextLevelButton;
    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public WinScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new Stage(new FitViewport(1600, 900));

        // Add Next Level Button
        ImageButton nextLevelButton = createButton("confirm_save.png", "confirm_save.png", 400, 400, 100, 500);
        nextLevelButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LevelPage(game)); // Proceed to the next level
            }
        });
        stage.addActor(nextLevelButton);

        // Add Exit Button
        ImageButton exitButton = createButton("exit_level.png", "exit_level.png", 400, 400, 800, 500);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new TutorialGame(game)); // Exit to tutorial page
            }
        });
        stage.addActor(exitButton);

        // Set Input Processor
        Gdx.input.setInputProcessor(stage);
    }

    private ImageButton createButton(String upTexture, String downTexture,float button_width,float button_height,float posX, float posY) {
        ArrayList<Drawable> drawables = buttonTextures(upTexture, downTexture);
        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = drawables.get(0);
        buttonStyle.down = drawables.get(1);

        ImageButton button = new ImageButton(buttonStyle);
        button.setPosition(SCREEN_WIDTH*posX - button.getWidth()*0.5f, SCREEN_HEIGHT*posY-button.getHeight()*0.5f);

        button.setHeight(button_height); button.setWidth(button_width);
        stage.addActor(button);
        return button;
    }

    private ArrayList<Drawable> buttonTextures(String upTexture, String downTexture) {
        Texture buttonUpTexture = new Texture(Gdx.files.internal(upTexture));
        Texture buttonDownTexture = new Texture(Gdx.files.internal(downTexture));

        Drawable buttonUp = new TextureRegionDrawable(buttonUpTexture);
        Drawable buttonDown = new TextureRegionDrawable(buttonDownTexture);

        ArrayList<Drawable> drawables = new ArrayList<>();
        drawables.add(buttonUp);
        drawables.add(buttonDown);
        return drawables;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
