package io.github.Game;

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

import java.util.ArrayList;


public class SettingsOverlay extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage Setting_stage;
    private ImageButton closeButton;
    private ImageButton LoadGameButton;
    public Boolean isActive = false;
    private Texture settings_background;
    private ImageButton MuteButton;

int first_time=0;
//    private Slider volumeSlider;

    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();



    private ArrayList<Drawable> level_button_texture(String up_texture, String down_texture ) {
        Texture buttonUpTexture = new Texture(Gdx.files.internal(up_texture));
        Texture buttonDownTexture = new Texture(Gdx.files.internal(down_texture));

        Drawable buttonUp = new TextureRegionDrawable(buttonUpTexture);
        Drawable buttonDown = new TextureRegionDrawable(buttonDownTexture);

        ArrayList<Drawable> level_button_up_down  = new ArrayList<Drawable>();
        level_button_up_down.add(buttonUp);
        level_button_up_down.add(buttonDown);
        return level_button_up_down;
    }

    private ImageButton ImageButton_create(String up_texture, String down_texture,
                                           float button_width, float button_height,
                                           float pos_X, float pos_Y) {
        ImageButton button;

        ArrayList<Drawable> button_drawable;
        button_drawable = level_button_texture(up_texture, down_texture);

        ImageButton.ImageButtonStyle button_style = new ImageButton.ImageButtonStyle();
        button_style.up = button_drawable.get(0);
        button_style.down = button_drawable.get(1);

        button = new ImageButton(button_style);
//        button.setPosition(SCREEN_WIDTH*0.5f - button.getWidth()*0.5f, SCREEN_HEIGHT*0.1f);
        button.setPosition(SCREEN_WIDTH*pos_X - button.getWidth()*0.5f, SCREEN_HEIGHT*pos_Y);

        button.setHeight(button_height); button.setWidth(button_width);
        Setting_stage.addActor(button);
        return button;
    }



    public SettingsOverlay() {

        batch = new SpriteBatch();
        settings_background = new Texture(Gdx.files.internal("menu_settings.png"));
//        settings_background.setHeight();


        System.out.println("Stage set setting");
        Setting_stage = new Stage(new ScreenViewport());

        // Create a label for "Volume"
//        Label.LabelStyle labelStyle = new Label.LabelStyle();
//        labelStyle.font = new BitmapFont();
//        Label volumeLabel = new Label("Volume", labelStyle);

        // Create a slider for volume control
//        volumeSlider = new Slider(0, 100, 1, false, new Slider.SliderStyle());
//        volumeSlider.setValue(50);  // Default value

        // Create a close button
//        Texture closeTexture = new Texture(Gdx.files.internal("close_button.png"));
//        Drawable closeDrawable = new TextureRegionDrawable(closeTexture);
//        closeButton = new ImageButton(closeDrawable);

        closeButton = ImageButton_create("close_button.png", "close_button_down.png", 100,100, 0.5f,0.5f);

        System.out.println("close button created");
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("close button clicked");
//               TutorialGame.setScreen(new TutorialGame(TutorialGame));
//                Setting_stage.clear(); // Clear the settings overlay when close is clicked
                closeOverlay();

            }
        });

        Setting_stage.addActor(closeButton);

        // LOAD GAME BUTTON
        LoadGameButton = ImageButton_create("Load_Game.png", "Load_Game.png", 400,150, 0.5f,0.6f);

        LoadGameButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("CLICKED LOAD GAME BUTTON");
//               TutorialGame.setScreen(new TutorialGame(TutorialGame));
//                Setting_stage.clear(); // Clear the settings overlay when close is clicked

            }
        });

        Setting_stage.addActor(LoadGameButton);

        // MUTE BUTTON
        MuteButton = ImageButton_create("Mute.png", "Mute.png", 400,150, 0.5f,0.2f);

        MuteButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("CLICKED MUTE BUTTON");
//               TutorialGame.setScreen(new TutorialGame(TutorialGame));
//                Setting_stage.clear(); // Clear the settings overlay when close is clicked

            }
        });

        Setting_stage.addActor(MuteButton);




//        Table table = new Table();
//        table.setFillParent(true); // Make the table take up the entire screen
//        table.center(); // Center the table
//        table.add(volumeLabel).padBottom(10).row();  // Add volume label
//        table.add(volumeSlider).padBottom(10).row();  // Add slider
//        table.add(closeButton).padTop(10);  // Add close button

//        Setting_stage.addActor(table);  // Add the table to the Setting_stage
    }

    public void render(float delta) {
        if(isActive ) {
            batch.begin();
            batch.draw(settings_background, SCREEN_WIDTH/2 - settings_background.getWidth()/2, SCREEN_HEIGHT/2 - settings_background.getHeight()/2 - 40, 500, 600);
            batch.end();
            Setting_stage.act(delta);
            Setting_stage.draw();
        }

    }

    public void resize(int width, int height) {
        Setting_stage.getViewport().update(width, height, true);
        closeButton.setPosition(Gdx.graphics.getWidth() * 0.65f - closeButton.getWidth()*0.5f, Gdx.graphics.getHeight() *0.8f - closeButton.getHeight() *0.5f);
        LoadGameButton.setPosition(Gdx.graphics.getWidth() * 0.51f - LoadGameButton.getWidth()*0.5f, Gdx.graphics.getHeight() *0.6f - closeButton.getHeight() *0.5f);
        MuteButton.setPosition(Gdx.graphics.getWidth() * 0.51f - MuteButton.getWidth()*0.5f, Gdx.graphics.getHeight() *0.4f - closeButton.getHeight() *0.5f);

//        System.out.printf("close button position: %f, %f\n"  ,Gdx.graphics.getWidth() * 0.3f - closeButton.getWidth()*0.5f , Gdx.graphics.getHeight() *0.6f - closeButton.getHeight() *0.5f);
    }

    public void dispose() {
        Setting_stage.dispose();

    }

    public Stage getStage() {
        return Setting_stage;
    }

    public void setActive(boolean active) {
        isActive = active;
        if (isActive) {
            System.out.println("Setting turned on");
            Gdx.input.setInputProcessor(Setting_stage);
            Setting_stage.getRoot().setVisible(true); // Show the stage
            System.out.println("Setting turned on - yo");


        }
    }


//    private void closeOverlay() {
//        Setting_stage.clear();  // Clear the settings overlay
//
//        setActive(false);  // Mark overlay as inactive
//
//    }

    protected void closeOverlay() {
        setActive(false);  // Mark overlay as inactive
        Setting_stage.getRoot().setVisible(false); // Hide the stage without clearing it
    }



    public boolean isActive() {
        return isActive;
    }
}
