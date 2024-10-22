package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.some_example_name.PauseScreen;

public class LevelPage extends ApplicationAdapter {
    private Stage stage;
    private Texture pauseTexture;
    private Level1 level1;

    @Override
    public void create() {
        stage = new Stage(new FitViewport(800, 600));

        // Background
        Texture backgroundTexture = new Texture("background.png");
        Image backgroundImage = new Image(backgroundTexture);
        backgroundImage.setSize(800, 600);  // Set full-screen size
        stage.addActor(backgroundImage);

        // Level Setup
        Ground ground = new Ground("grd.PNG", 800, 20);
        Catapult catapult = new Catapult("catapault.png", 220, 125, 100, 100);
        level1 = new Level1(ground, catapult);

        // Add level elements to the stage
        stage.addActor(ground.getImage());
        stage.addActor(catapult.getImage());
        level1.setupLevel(stage);

        // Load Pause Button Texture
        pauseTexture = new Texture("pause.png");
        ImageButton pauseButton = createPauseButton();
        pauseButton.setPosition(740, 550); // Position at top-right corner

        // Add Button to Stage
        stage.addActor(pauseButton);

        // Set Input Processor
        Gdx.input.setInputProcessor(stage);
    }

    private ImageButton createPauseButton() {
        // Create Drawable from Texture
        TextureRegionDrawable drawable = new TextureRegionDrawable(pauseTexture);
        ImageButton pauseButton = new ImageButton(drawable);

        // Resize Pause Button
        pauseButton.setSize(50, 50);  // Set the width and height of the button

        // Add Click Listener to Handle Button Clicks
        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Navigate to Pause Screen
                Gdx.app.log("Button", "Pause button clicked!");
                switchToPauseScreen();
            }
        });

        return pauseButton;
    }

    private void switchToPauseScreen() {
        // Switch to Pause Screen
        Gdx.app.log("Switch", "Switching to Pause Screen");
        // Assuming using `Game` class, replace with your actual Game object
        ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new PauseScreen());
    }

    @Override
    public void render() {
        ScreenUtils.clear(0f, 0f, 0f, 1f);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose() {
        stage.dispose();
        pauseTexture.dispose();
    }
}
