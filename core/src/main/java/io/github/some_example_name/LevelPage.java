package io.github.some_example_name;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import io.github.Game.MyGame;
import io.github.Game.SettingsOverlay;
import io.github.Game.TutorialGame;
import io.github.some_example_name.PauseScreen;

import java.util.ArrayList;

public class LevelPage extends ScreenAdapter {
    private Stage stage;
    private Texture backgroundTexture;
    private Skin skin;
    private OverlayPause overlayPause;
    private Texture pauseTexture;
    private Level1 level1;
    private Game game;
    private boolean showPause = false;
    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    public LevelPage(Game game) { // Accept Game as a parameter
        this.game = game;
    }
    @Override
    public void show() {
        stage = new Stage(new FitViewport(800, 600));
        overlayPause = new OverlayPause(this);

        // Background
         backgroundTexture = new Texture("background.png");
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
        ImageButton pauseButton = ImageButton_create("pause.png","pause.png",200,200, 740, 550);
       pauseButton.setPosition(740, 550); // Position at top-right corner

        // Add Button to Stage
        //stage.addActor(pauseButton);

        // Set Input Processor
        Gdx.input.setInputProcessor(stage);
        pauseButton.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked PAUSE");
//                showSettings = !showSettings;
//                settingsOverlay.setActive(showSettings);
                if (!overlayPause.isActive()) {
                    showPause = true;
                    overlayPause.setActive(true);
                }
                System.out.println("returned from PAUSE" );
            }

        });
//        stage.addActor(settingsButton);
        overlayPause = new OverlayPause(this);
    }
    private ArrayList<Drawable> buttonTextures(String upTexture, String downTexture) {
        Texture buttonUpTexture = new Texture(Gdx.files.internal(upTexture));
        Texture buttonDownTexture = new Texture(Gdx.files.internal(downTexture));

        Drawable buttonUp = new TextureRegionDrawable(buttonUpTexture);
        Drawable buttonDown = new TextureRegionDrawable(buttonDownTexture);

        ArrayList<Drawable> buttonDrawables = new ArrayList<>();
        buttonDrawables.add(buttonUp);
        buttonDrawables.add(buttonDown);
        return buttonDrawables;
    }
    private ImageButton ImageButton_create(String up_texture, String down_texture,
                                           float button_width, float button_height,
                                           float pos_X, float pos_Y) {
        ImageButton button;

        ArrayList<Drawable> button_drawable;
        button_drawable = buttonTextures(up_texture, down_texture);

        ImageButton.ImageButtonStyle button_style = new ImageButton.ImageButtonStyle();
        button_style.up = button_drawable.get(0);
        button_style.down = button_drawable.get(1);

        button = new ImageButton(button_style);
//        button.setPosition(SCREEN_WIDTH*0.5f - button.getWidth()*0.5f, SCREEN_HEIGHT*0.1f);
        button.setPosition(SCREEN_WIDTH*pos_X - button.getWidth()*0.5f, SCREEN_HEIGHT*pos_Y);

        button.setHeight(button_height); button.setWidth(button_width);
        stage.addActor(button);
        return button;
    }
//    private void switchToPauseScreen() {
//        // Switch to Pause Screen
//        Gdx.app.log("Switch", "Switching to Pause Screen");
//        // Assuming using `Game` class, replace with your actual Game object
//        ((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new PauseScreen());
//    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //if (game instanceof MyGame) {
            SpriteBatch batch = ((MyGame) game).getBatch();
            batch.begin();
            batch.draw(backgroundTexture, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            batch.end();


            Gdx.input.setInputProcessor(stage);     // Revert to main stage input
            stage.act(delta);
            stage.draw();

            if (!showPause) {
                // If settings are not shown, set input to main stage and draw it
                Gdx.input.setInputProcessor(stage);
                stage.act(delta);
                stage.draw();
            }

            // If settings are shown, set input to the settingsOverlay stage and render it
            if (showPause && overlayPause.isActive() ) {
                //settingsOverlay.first_time=1;
                Gdx.input.setInputProcessor(overlayPause.getStage());
                overlayPause.render(delta);
            }


//            if (showSettings && settingsOverlay.isActive()) {
//                settingsOverlay.render(delta);
////                Gdx.input.setInputProcessor(settingsOverlay.getStage());  // Set input for settings overlay
//            }
//            else {
//                Gdx.input.setInputProcessor(stage);     // Revert to main stage input
//                stage.act(delta);
//                stage.draw();
//            }

    }
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    private void switchToPauseScreen() {
        showOverlay();
    }

    public void showOverlay() {
        overlayPause.show();
    }

    public void hideOverlay() {
        overlayPause.hide();
    }

    public void showGameSavedOverlay() {
        Dialog gameSavedDialog = new Dialog("Game Saved", skin) {
            @Override
            protected void result(Object object) {
                navigateToTutorialPage(); // Redirect after close
            }
        };
        gameSavedDialog.text("Your game has been saved!");
        gameSavedDialog.button("Close", true);
        gameSavedDialog.show(stage);
    }

    public void showSettingsOverlay() {
        Dialog settingsDialog = new Dialog("Settings", skin) {
            @Override
            protected void result(Object object) {
                hideOverlay(); // Close settings and keep the game paused
            }
        };
        settingsDialog.text("Settings Screen (Placeholder)");
        settingsDialog.button("Close", true);
        settingsDialog.show(stage);
    }

    public void restartLevel() {
        Gdx.app.log("Restart", "Restarting level...");
        dispose(); // Dispose of current level resources
        level1 = null; // Reset level1 to ensure it is reinitialized
        game.setScreen(new LevelPage(game)); // Re-initialize the LevelPage
    }

    public void navigateToTutorialPage() {
        Gdx.app.log("Exit", "Navigating to Tutorial Page");
        game.setScreen(new TutorialGame(game));
    }

    @Override
    public void dispose() {
        // Clean up resources
        stage.dispose();
        backgroundTexture.dispose();
        overlayPause.dispose();
    }

    public InputProcessor getStage() {
        return stage;
    }
}
