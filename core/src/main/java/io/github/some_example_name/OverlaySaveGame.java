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
import io.github.some_example_name.serializationPurpose.BirdDTO;
import io.github.some_example_name.serializationPurpose.BlockDTO;
import io.github.some_example_name.serializationPurpose.PigDTO;
import io.github.some_example_name.serializationPurpose.SerializableLevel;

import java.io.*;
import java.util.ArrayList;

public class OverlaySaveGame extends ScreenAdapter {
    private SpriteBatch batch;
    private Stage saveGameStage;
    private ImageButton closeButton;
    private ImageButton confirmSaveButton;
    private Boolean isActive = false;
    private Texture saveGameBackground;
    private LevelPage levelPage;

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
        button.setPosition(SCREEN_WIDTH * posX - button.getWidth() * 0.5f, SCREEN_HEIGHT * posY-button.getHeight()*0.5f);
        button.setHeight(buttonHeight);
        button.setWidth(buttonWidth);
        saveGameStage.addActor(button);
        return button;
    }

    public OverlaySaveGame(LevelPage levelpage) {
        this.levelPage=levelpage;
        batch = new SpriteBatch();
        saveGameBackground = new Texture(Gdx.files.internal("menu_settings2.png"));//save_game_background.png
        saveGameStage = new Stage(new ScreenViewport());

        // Create Close Button
        closeButton = createImageButton("close_button.png", "close_button_down.png", 100, 100, 0.65f, 0.8f);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                closeOverlay(); // Close functionality
            }
        });
        saveGameStage.addActor(closeButton);

        // Create Confirm Save Button
        confirmSaveButton = createImageButton("confirm_save.png", "Save_game_button.png", 400, 100, 0.51f, 0.5f);//"confirm_save.png"
//        confirmSaveButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                System.out.println("Game Saved!");
//                closeOverlay();
//            }
//        });
        confirmSaveButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

//                SerializableLevel level = new SerializableLevel(
//                    levelpage.level_numb,  // Replace with the actual level number
//                    levelpage.birds,
//                    levelpage.pigs,
//                    levelpage.blocks
//                );
//                saveLevel(level);
                ArrayList<BirdDTO> birdDTOs = new ArrayList<>();
                for (Bird bird : levelpage.birds) {
                    birdDTOs.add(new BirdDTO(
                        bird.texturePath, bird.getImage().getX(), bird.getImage().getY(), bird.getImage().getWidth(), bird.getImage().getHeight(),
                        bird.getHealthI(), bird.isDestroyed()
                    ));
                }
                ArrayList<PigDTO> pigDTOs = new ArrayList<>();
                for (Pig bird : levelpage.pigs) {
                    pigDTOs.add(new PigDTO(
                        bird.texturePath, bird.getImage().getX(), bird.getImage().getY(), bird.getImage().getWidth(), bird.getImage().getHeight(),
                        bird.getHealthI(), bird.isDestroyed()
                    ));
                }
                ArrayList<BlockDTO> blockDTOs = new ArrayList<>();
                for (Block bird : levelpage.blocks) {
                    blockDTOs.add(new BlockDTO(
                        bird.texturePath, bird.getImage().getX(), bird.getImage().getY(), bird.getImage().getWidth(), bird.getImage().getHeight(),
                        bird.getHealthI(), bird.isDestroyed()
                    ));
                }
//// Repeat for pigs and blocks
                SerializableLevel level = new SerializableLevel(levelpage.level_numb, birdDTOs, pigDTOs, blockDTOs);
                saveLevel(level);

            }
        });
        saveGameStage.addActor(confirmSaveButton);
    }
//    public void saveLevel(SerializableLevel level) {
//        try (
//            FileOutputStream fileOut = new FileOutputStream("level" + level.levelNumber + ".ser");
//             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//            out.writeObject(level);
//            System.out.println("Level saved successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
public void saveLevel(SerializableLevel level) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("level" + level.levelNumber + ".txt"))) {
        // Write Birds
        for (BirdDTO bird : level.getBirdDTOs()) {
            writer.write("Bird:" + bird.texturePath + "," + bird.x + "," + bird.y + "," + bird.width + "," +
                bird.height + "," + bird.health + "," + bird.isDestroyed);
            writer.newLine();
        }

        // Write Pigs
        for (PigDTO pig : level.getPigDTO()) {
            writer.write("Pig:" + pig.texturePath + "," + pig.x + "," + pig.y + "," + pig.width + "," +
                pig.height + "," + pig.health + "," + pig.isDestroyed);
            writer.newLine();
        }

        // Write Blocks
        for (BlockDTO block : level.getBlockDTO()) {
            writer.write("Block:" + block.texturePath + "," + block.x + "," + block.y + "," + block.width + "," +
                block.height + "," + block.health + "," + block.isDestroyed);
            writer.newLine();
        }

        System.out.println("Level saved successfully to text file!");
    } catch (IOException e) {
        e.printStackTrace();
    }
}


    public void render(float delta) {
        if (isActive) {
            batch.begin();
            batch.draw(saveGameBackground, SCREEN_WIDTH / 2 - saveGameBackground.getWidth() / 2, SCREEN_HEIGHT / 2 - saveGameBackground.getHeight() / 2-40,500,600);
            batch.end();

            saveGameStage.act(delta);
            saveGameStage.draw();
        }
    }

    public void resize(int width, int height) {
        saveGameStage.getViewport().update(width, height, true);
        confirmSaveButton.setPosition(SCREEN_WIDTH * 0.51f - confirmSaveButton.getWidth() * 0.5f, SCREEN_HEIGHT * 0.2f-confirmSaveButton.getHeight()*0.5f);
        closeButton.setPosition(SCREEN_WIDTH * 0.65f - closeButton.getWidth() * 0.5f, SCREEN_HEIGHT * 0.8f-closeButton.getHeight()*0.5f);

    }

    public void dispose() {
        saveGameStage.dispose();
        batch.dispose();
        saveGameBackground.dispose();
    }

    public void setActive(boolean active) {
        isActive = active;
        if (isActive) {
            Gdx.input.setInputProcessor(saveGameStage);
            saveGameStage.getRoot().setVisible(true); // Show the stage
        }
    }

    private void closeOverlay() {
        setActive(false); // Mark overlay as inactive
        saveGameStage.getRoot().setVisible(false); // Hide the stage without clearing it
    }

    public boolean isActive() {
        return isActive;
    }

    public Stage getStage() {
        return saveGameStage;
    }
}
