package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.Game.SettingsOverlay;

import java.util.ArrayList;

public class OverlayPause extends ScreenAdapter {
    private SpriteBatch batch;
    private OverlaySaveGame overlaySaveGame;
    private Stage pauseStage;
    private Texture pauseBackground;
    private ImageButton resumeButton;
    private ImageButton saveButton;
    private ImageButton restartButton;
    private ImageButton settingsButton;
    private ImageButton exitButton;
    public Boolean isActive = false;
    private LevelPage levelPage;
    private SettingsOverlay settingsOverlay;
    private boolean showSettings = false;
    private boolean showSave = false;// Track whether settings overlay is shown

    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();

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

    private ImageButton createImageButton(String upTexture, String downTexture,
                                          float buttonWidth, float buttonHeight,
                                          float posX, float posY) {
        ImageButton button;
        ArrayList<Drawable> buttonDrawables = buttonTextures(upTexture, downTexture);

        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = buttonDrawables.get(0);
        buttonStyle.down = buttonDrawables.get(1);

        button = new ImageButton(buttonStyle);
        button.setPosition(SCREEN_WIDTH * posX - button.getWidth() * 0.5f, SCREEN_HEIGHT * posY);
        button.setHeight(buttonHeight);
        button.setWidth(buttonWidth);
        pauseStage.addActor(button);
        return button;
    }

    public OverlayPause(LevelPage levelPage) {
        this.levelPage = levelPage;
        batch = new SpriteBatch();
        pauseBackground = new Texture(Gdx.files.internal("menu_settings.png"));
        pauseStage = new Stage(new ScreenViewport());

        // Create buttons
        resumeButton = createImageButton("pause.png", "pause.png", 200, 100, 0.5f, 0.6f);
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                closeOverlay(); // Resume functionality
            }
        });

        saveButton = createImageButton("mute.png", "mute.png", 200, 100, 0.5f, 0.5f);
        saveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Game Saved!");
                if (!overlaySaveGame.isActive()) {
                    showSave = true;
                    overlaySaveGame.setActive(true);
                    Gdx.input.setInputProcessor(overlaySaveGame.getStage()); // Set input processor to settings overlay
                    pauseStage.getRoot().setVisible(false); // Hide pause overlay

                }
            }
        });

        restartButton = createImageButton("pause.png", "pause.png", 200, 100, 0.5f, 0.4f);
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                levelPage.restartLevel();
                closeOverlay();
                System.out.println("Level Restarted!");
            }
        });

        settingsButton = createImageButton("settings_button.png", "settings_button.png", 200, 100, 0.5f, 0.3f);
        //settingsButton.setPosition(0.5f, 0.3f);
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                // Toggle settings overlay
//                showSettings = !showSettings; // Toggle the variable
//                settingsOverlay.setActive(showSettings); // Activate or deactivate settings overlay

                if (!settingsOverlay.isActive()) {
                    showSettings = true;
                    settingsOverlay.setActive(true);
                    Gdx.input.setInputProcessor(settingsOverlay.getStage()); // Set input processor to settings overlay
                    pauseStage.getRoot().setVisible(false); // Hide pause overlay

                }
//                } else {
//                    Gdx.input.setInputProcessor(pauseStage); // Return input to pause stage
//                    pauseStage.getRoot().setVisible(true); // Show pause overlay again
               // }
            }
        });

        exitButton = createImageButton("close_button.png", "close_button_down.png", 200, 100, 0.5f, 0.2f);
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Exiting to Tutorial Page!");
                levelPage.navigateToTutorialPage();
            }
        });

        // Add buttons to the stage
        pauseStage.addActor(resumeButton);
        //pauseStage.addActor(saveButton);
        pauseStage.addActor(restartButton);
        //pauseStage.addActor(settingsButton);
        pauseStage.addActor(exitButton);
        settingsOverlay = new SettingsOverlay();
        overlaySaveGame = new OverlaySaveGame();

    }
    public void render(float delta) {
        if (isActive) {
            batch.begin();
            batch.draw(pauseBackground, SCREEN_WIDTH / 2 - pauseBackground.getWidth() / 2, SCREEN_HEIGHT / 2 - pauseBackground.getHeight() / 2);
            batch.end();

            pauseStage.act(delta);
            pauseStage.draw();
        }

        // Handle the input processor and visibility depending on the state of the settings overlay
        if (showSettings) {
            if (settingsOverlay.isActive()) {
                // Settings are active, set input to settingsOverlay
                Gdx.input.setInputProcessor(settingsOverlay.getStage());
                settingsOverlay.render(delta);
            } else {
                // Settings were active but are now closed, switch back to the pause overlay
                showSettings = false; // Ensure `showSettings` is set to false
                Gdx.input.setInputProcessor(pauseStage);
                pauseStage.getRoot().setVisible(true); // Show the pause overlay again
            }
        } else if (showSave) {
            if (overlaySaveGame.isActive()) {
                // Settings are active, set input to settingsOverlay
                Gdx.input.setInputProcessor(overlaySaveGame.getStage());
                overlaySaveGame.render(delta);
            } else {
                // Settings were active but are now closed, switch back to the pause overlay
                showSave = false; // Ensure `showSettings` is set to false
                Gdx.input.setInputProcessor(pauseStage);
                pauseStage.getRoot().setVisible(true); // Show the pause overlay again
            }

        } else {
            // If settings are not shown, set input to the main pause stage and draw it
            Gdx.input.setInputProcessor(pauseStage);
            pauseStage.act(delta);
            pauseStage.draw();
        }
    }

//
//    public void render(float delta) {
//        if (isActive) {
//            batch.begin();
//            batch.draw(pauseBackground, SCREEN_WIDTH / 2 - pauseBackground.getWidth() / 2, SCREEN_HEIGHT / 2 - pauseBackground.getHeight() / 2);
//            batch.end();
//
//            pauseStage.act(delta);
//            pauseStage.draw();
//        }
//
//        // Render settings overlay if active
//        if (!showSettings) {
//            // If settings are not shown, set input to main stage and draw it
//            Gdx.input.setInputProcessor(pauseStage);
//            pauseStage.act(delta);
//            pauseStage.draw();
//        }
//
//        // If settings are shown, set input to the settingsOverlay stage and render it
//        if (showSettings && settingsOverlay.isActive() ) {
//            //settingsOverlay.first_time=1;
//            Gdx.input.setInputProcessor(settingsOverlay.getStage());
//            settingsOverlay.render(delta);
//        }
//    }

    public void resize(int width, int height) {
        pauseStage.getViewport().update(width, height, true);
    }

    public void dispose() {
        pauseStage.dispose();
        batch.dispose();
        pauseBackground.dispose();
        settingsOverlay.dispose();
        overlaySaveGame.dispose();
    }

    public void setActive(boolean active) {
        isActive = active;
        if (isActive) {
            Gdx.input.setInputProcessor(pauseStage);
            pauseStage.getRoot().setVisible(true); // Show the stage
        }
    }

    private void closeOverlay() {
        setActive(false); // Mark overlay as inactive
        pauseStage.getRoot().setVisible(false); // Hide the stage without clearing it
        Gdx.input.setInputProcessor(levelPage.getStage()); // Set the input processor back to the main stage if needed
        showSettings = false; // Ensure showSettings is false when overlay is closed
    showSave=false;
    }

    public boolean isActive() {
        return isActive;
    }

    public Stage getStage() {
        return pauseStage;
    }
}
