package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class LevelPage extends ScreenAdapter {
    private Stage stage;
    private Level1 level1;

    @Override
    public void show() {
        stage = new Stage(new FitViewport(800, 600));

        // Background
        Texture backgroundTexture = new Texture("background.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setSize(800, 600);  // Set full-screen size
        stage.addActor(backgroundImage);

        // Level Setup
        Ground ground = new Ground("grd.PNG", 800, 20);
        Catapult catapult = new Catapult("catapault.png", 220,125,100,100);
        level1 = new Level1(ground, catapult);

        // Add level elements to the stage
        stage.addActor(ground.getImage());
        stage.addActor(catapult.getImage());
        level1.setupLevel(stage);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta ) {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
