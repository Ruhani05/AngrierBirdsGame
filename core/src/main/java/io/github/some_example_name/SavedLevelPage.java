package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import io.github.Game.MyGame;
import io.github.Game.TutorialGame;
import io.github.some_example_name.serializationPurpose.BirdDTO;
import io.github.some_example_name.serializationPurpose.BlockDTO;
import io.github.some_example_name.serializationPurpose.PigDTO;
import io.github.some_example_name.serializationPurpose.SerializableLevel;

import java.util.ArrayList;
import java.util.Iterator;

public class SavedLevelPage extends LevelPage {
    private ArrayList<Bird> birds;
    private ArrayList<Pig> pigs;
    private ArrayList<Block> blocks;
    private World world;

    SerializableLevel savedLevel;
    public SavedLevelPage(Game game, SerializableLevel savedLevel) {
        //this.world = new World(new Vector2(0, -9.8f), true); // Create a new World
        super(game, savedLevel.levelNumber);
        this.birds = new ArrayList<>();
        this.pigs = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.savedLevel=savedLevel;
//        world = new World(new Vector2(0, -9.8f), true); // Gravity vector
//        contactListener = new MyContactListener(); // Initialize the contact listener
//        world.setContactListener(contactListener); // Set it for the world
//        // Deserialize birds
//        for (BirdDTO dto : savedLevel.getBirdDTOs()) {
//            birds.add(new Bird(dto, world));
//        }
//        for (PigDTO dto : savedLevel.getPigDTO()) {
//            pigs.add(new Pig(dto, world));
//        }
//        for (BlockDTO dto : savedLevel.getBlockDTO()) {
//            blocks.add(new Block(dto, world));
//        }
        // Deserialize pigs and blocks similarly
    }
    @Override
    public void show() {
        //stage = new Stage(new FitViewport(1600, 900));
        //backgroundTexture = new Texture("background.png");
//        world = new World(new Vector2(0, -9.8f), true); // Gravity vector
//        contactListener = new MyContactListener(); // Initialize the contact listener
//        world.setContactListener(contactListener); // Set it for the world
        world = new World(new Vector2(0, -9.8f), true); // Gravity vector
        contactListener = new MyContactListener(); // Initialize the contact listener
        world.setContactListener(contactListener); // Set it for the world
        // Deserialize birds
        for (BirdDTO dto : savedLevel.getBirdDTOs()) {
            birds.add(new Bird(dto, world));
        }
        for (PigDTO dto : savedLevel.getPigDTO()) {
            pigs.add(new Pig(dto, world));
        }
        for (BlockDTO dto : savedLevel.getBlockDTO()) {
            blocks.add(new Block(dto, world));
        }
        debugRenderer = new Box2DDebugRenderer();
        stage = new Stage(new ScreenViewport());
        overlayPause = new OverlayPause(this, game);
        createGroundBody();
        // Background
        // Set Input Processor
        Gdx.input.setInputProcessor(stage);
//        Image backgroundImage = new Image(backgroundTexture);
//        backgroundImage.setSize(1600, 900);  // Set full-screen size
        //stage.addActor(backgroundImage);

        // Level Setup
        //Ground ground = new Ground("grd.PNG", 800, 20);
        // Set up the ground
        ground = new Ground("grd.PNG", Gdx.graphics.getWidth(), 20, 0, SCREEN_HEIGHT * 0.2f);
        //ground.getImage().setPosition(0, SCREEN_HEIGHT * 0.2f ); // Position the ground
        stage.addActor(ground.getImage()); // Add ground to the stage
Ground step1,step2,step3;
        if(level_numb==1) {
            catapult = new Catapult("catapault.png", 0.2f, 0.3f, 125, 150, world);
             step1=new Ground("step.png",45,45,0.125f,0.25f,world);        // width=45, height=45
             step2=new Ground("step.png",45,45,0.15f,0.25f,world);
             step3=new Ground("step.png",45,45,0.15f,0.3f,world);
            stage.addActor(step1.getImage());
            stage.addActor(step2.getImage());
            stage.addActor(step3.getImage());
        }
        else if(level_numb==2){
            catapult = new Catapult("catapault.png", 0.2f, 0.23f, 125, 150, world);
             step1=new Ground("step.png",45,45,0.125f,0.17f,world);        // width=45, height=45
             step2=new Ground("step.png",45,45,0.15f,0.17f,world);
             step3=new Ground("step.png",45,45,0.15f,0.22f,world);
            stage.addActor(step1.getImage());
            stage.addActor(step2.getImage());
            stage.addActor(step3.getImage());
        }
        else{
            catapult = new Catapult("catapault.png", 0.2f, 0.23f, 125, 150, world);
//            Ground grd= new Ground("step.png",640,45,0.65f,0.24f,world);
//            stage.addActor(grd.getImage());

//             step1=new Ground("step.png",45,45,0.125f,0.25f,world);        // width=45, height=45
//             step2=new Ground("step.png",45,45,0.15f,0.25f,world);
//             step3=new Ground("step.png",45,45,0.15f,0.3f,world);

        }

        //level1 = new Level1(ground, catapult,world);
        backgroundTexture = level1.bg();
        dotTexture = new Texture(Gdx.files.internal("dot.png"));


        // Add level elements to the stage
        stage.addActor(ground.getImage());
        stage.addActor(catapult.getImage());
//        level1.setupLevel(stage);
//        // Access birds
//        birds = level1.getBirds();
//        blocks = level1.getBlocks();
//        pigs = level1.getPigs();
        for (Bird bird : birds) {
            stage.addActor(bird.getImage());
        }
        for (Pig pig : pigs) {
            stage.addActor(pig.getImage());
        }

        // Render blocks
        for (Block block : blocks) {
            stage.addActor(block.getImage());
        }
//
        // Load Pause Button Texture
        pauseTexture = new Texture("pause.png");
        pauseButton = ImageButton_create("pause.png", "pause_down.png", 150, 150, 1f, 1f);
        //pauseButton.setPosition(800, 400); // Position at top-right corner

        // Add Button to Stage
        //stage.addActor(pauseButton);
        // Add Win Button
        ImageButton winButton = ImageButton_create("win.png", "win.png", 60, 60, 0.95f, 1f);
        //stage.addActor(winButton);
        winButton.setPosition(SCREEN_WIDTH - 200 - 60 - 65, SCREEN_HEIGHT - 60);

        // Add Lose Button
        ImageButton loseButton = ImageButton_create("lose.png", "lose.png", 60, 60, 0.9f, 1f);
        //stage.addActor(loseButton);
        loseButton.setPosition(SCREEN_WIDTH - 200 - 65, SCREEN_HEIGHT - 60);


        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("clicked PAUSE");
//                showSettings = !showSettings;
//                settingsOverlay.setActive(showSettings);
                if (!overlayPause.isActive()) {
                    showPause = true;
                    overlayPause.setActive(true);
                }
                System.out.println("returned from PAUSE");
            }

        });
        // Win Button Listener
        winButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new WinScreen(game, level_numb));
            }
        });

        // Lose Button Listener
        loseButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new LoseScreen(game, level_numb));
            }
        });

        // Add InputListener for touch events
        stage.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                for (Bird bird : birds) {

                    if (bird.getBoundingRectangle().contains(x, y)) {
                        // Bird was clicked, create the slingshot joint
                        createSlingshotJoint(bird);
                        return true; // Stop further input propagation
                    }
                }
                return false; // Allow other inputs if no bird was clicked
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                if (mouseJoint != null) {
                    // Convert screen coordinates to stage coordinates
                    Vector2 target = stage.screenToStageCoordinates(new Vector2(x, y));
                    mouseJoint.setTarget(target); // Update the mouse joint's target position
                }
                //return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                if (mouseJoint != null) {
//                    // Destroy the joint when the user releases the touch
//                    world.destroyJoint(mouseJoint);
//                    mouseJoint = null; // Release the bird
//                }
                //return true;
                if (mouseJoint != null) {
                    // Apply force to launch the bird when touch is released
                    //Bird bird = getSelectedBird(); // Get the currently selected bird (could be the one last clicked)
                    // Vector2 velocity = bird.getBody().getLinearVelocity(); // Get the current velocity of the bird
                    // bird.launchBird(velocity.scl(2)); // Apply force to launch the bird (you can adjust the scaling factor)

                    // Destroy the joint and release the bird
                    world.destroyJoint(mouseJoint);
                    mouseJoint = null; // Release the bird
                }
            }
        });

//        stage.addActor(settingsButton);
        overlayPause = new OverlayPause(this, game);
//        // Add Listener for Bird Selection (to create slingshot joint)
//        stage.addListener(new InputListener() {
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                for (Bird bird : birds) {
//                    if (bird.getImage().getBoundingRectangle().contains(x, y)) {
//                        createSlingshotJoint(bird);  // Create joint for dragging
//                        return true; // Stop further input propagation
//                    }
//                }
//                return false;
//            }
//        });
    }
    void createGroundBody() {
        BodyDef groundDef = new BodyDef();
        //groundDef.position.set(0, SCREEN_HEIGHT * 0.2f / Gdx.graphics.getPpcY());
        if(level_numb==1){        groundDef.position.set(0, SCREEN_HEIGHT * 0.2f); // Position at y = SCREEN_HEIGHT * 0.2f
        }
        else if(level_numb==2){        groundDef.position.set(0, SCREEN_HEIGHT * 0.11f); // Position at y = SCREEN_HEIGHT * 0.2f
        }
        else{
            groundDef.position.set(0, SCREEN_HEIGHT * 0.2f);
        }
        groundDef.type = BodyDef.BodyType.StaticBody;

        Body groundBody = world.createBody(groundDef);

        PolygonShape groundShape = new PolygonShape();
//        groundShape.setAsBox(SCREEN_WIDTH / 2f / Gdx.graphics.getPpcX(), 10 / Gdx.graphics.getPpcY());
//
//        groundBody.createFixture(groundShape, 0.0f);
        groundShape.setAsBox(SCREEN_WIDTH, 20);  // Full width, height 20

        // Attach the shape to the ground body
        groundBody.createFixture(groundShape, 0.0f);  // No friction

        groundShape.dispose();
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

    ImageButton ImageButton_create(String up_texture, String down_texture,
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
        button.setPosition(SCREEN_WIDTH * pos_X - button.getWidth() * 0.5f, SCREEN_HEIGHT * pos_Y - button.getHeight() * 0.5f);

        button.setHeight(button_height);
        button.setWidth(button_width);
        stage.addActor(button);
        return button;
    }
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        //if (game instanceof MyGame) {
//        Iterator<Block> iterator = blocks.iterator();
//        while (iterator.hasNext()) {
//            Block block = iterator.next();
//            if (block.isDestroyed()) {
//                block.getImage().setPosition(-1000, -1000);
//
//                iterator.remove(); // Remove block from the list
//            }
//        }
//        Iterator<Pig> iterator1 = pigs.iterator();
//        while (iterator1.hasNext()) {
//            Pig pig = iterator1.next();
//            if (pig.isDestroyed()) {
//                pig.getImage().setPosition(-1000, -1000);
//                iterator1.remove(); // Remove block from the list
//            }
//        }
////        Iterator<Bird> iterator2 = birds.iterator();
////        while (iterator2.hasNext()) {
////            Bird pig = iterator2.next();
////            if (pig.isDestroyed()) {
////                pig.getImage().setPosition(-1000, -1000);
////
////                iterator2.remove(); // Remove block from the list
////            }
////        }
//        Iterator<Bird> iterator2 = birds.iterator();
//        Bird previousBird = null; // Track the last active bird
//        while (iterator2.hasNext()) {
//            Bird currentBird = iterator2.next();
//
//            // If the bird is destroyed, remove it and reposition the next bird (if exists)
//            if (currentBird.isDestroyed()) {
//                currentBird.getImage().setPosition(-1000, -1000); // Move destroyed bird off-screen
//                currentBird.getBody().setTransform(-1000, -1000, 0); // Move physics body off-screen
//                iterator2.remove(); // Remove bird from the list
//
//                // Check if there's a next bird to reposition
//                if (iterator2.hasNext()) {
//                    Bird nextBird = iterator2.next();
//                    nextBird.getImage().setPosition(275.0f, 270.27588f);
//                    nextBird.getBody().setTransform(275.0f, 270.27588f, 0); // Update Box2D body
//                }
//            } else {
//                // Update the last active bird
//                previousBird = currentBird;
//            }
//        }
//        // Check for win/lose conditions
//        if (pigs.isEmpty()) {
//            game.setScreen(new WinScreen(game, level_numb)); // All pigs are destroyed, switch to WinScreen
//        } else if (birds.isEmpty()) {
//            game.setScreen(new LoseScreen(game, level_numb)); // All birds are destroyed, switch to LoseScreen
//        }
//
//        SpriteBatch batch = ((MyGame) game).getBatch();
//        batch.begin();
//        batch.draw(backgroundTexture, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
//        batch.end();
//        for (Bird bird : birds) {
//            bird.render(batch); // Render the bird, calling its update method inside the render
//        }
//        for (Pig pig : pigs) {
//            pig.render(batch);
//        }
//
//        // Render blocks
//        for (Block block : blocks) {
//            block.render(batch);
//        }
//
//        Gdx.input.setInputProcessor(stage);     // Revert to main stage input
//        stage.act(delta);
//        stage.draw();
//        //world.step(1 / 60f, 6, 2); // Step simulation (time step, velocity iterations, position iterations)
//        if (!showPause) {
//            world.step(1 / 60f, 6, 2); // Step simulation
//            // Additional updates (e.g., birds, pigs, blocks)
//        }
//
//        // Process the destruction queue to safely remove bodies
//        contactListener.processDestructionQueue(world);
//
//        // Optionally, render the debug visuals for Box2D
//        debugRenderer.render(world, batch.getProjectionMatrix()); // Render the debug visuals
//
//
//        if (!showPause) {
//            // If settings are not shown, set input to main stage and draw it
//            Gdx.input.setInputProcessor(stage);
//            stage.act(delta);
//            stage.draw();
//        }
//
//        // If settings are shown, set input to the settingsOverlay stage and render it
//        if (showPause && overlayPause.isActive()) {
//            //settingsOverlay.first_time=1;
//            Gdx.input.setInputProcessor(overlayPause.getStage());
//            overlayPause.render(delta);
//        }
//
//
////            if (showSettings && settingsOverlay.isActive()) {
////                settingsOverlay.render(delta);
//////                Gdx.input.setInputProcessor(settingsOverlay.getStage());  // Set input for settings overlay
////            }
////            else {
////                Gdx.input.setInputProcessor(stage);     // Revert to main stage input
////                stage.act(delta);
////                stage.draw();
////            }
//
//    }
public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    //if (game instanceof MyGame) {
    Iterator<Block> iterator = blocks.iterator();
    while (iterator.hasNext()) {
        Block block = iterator.next();
        if (block.isDestroyed()) {
            block.getImage().setPosition(-1000, -1000);

            iterator.remove(); // Remove block from the list
        }
    }
    Iterator<Pig> iterator1 = pigs.iterator();
    while (iterator1.hasNext()) {
        Pig pig = iterator1.next();
        if (pig.isDestroyed()) {
            pig.getImage().setPosition(-1000, -1000);
            iterator1.remove(); // Remove block from the list
        }
    }
//        Iterator<Bird> iterator2 = birds.iterator();
//        while (iterator2.hasNext()) {
//            Bird pig = iterator2.next();
//            if (pig.isDestroyed()) {
//                pig.getImage().setPosition(-1000, -1000);
//
//                iterator2.remove(); // Remove block from the list
//            }
//        }
    Iterator<Bird> iterator2 = birds.iterator();
    Bird previousBird = null; // Track the last active bird
    while (iterator2.hasNext()) {
        Bird currentBird = iterator2.next();

        // If the bird is destroyed, remove it and reposition the next bird (if exists)
        if (currentBird.isDestroyed()) {
            currentBird.getImage().setPosition(-1000, -1000); // Move destroyed bird off-screen
            currentBird.getBody().setTransform(-1000, -1000, 0); // Move physics body off-screen
            iterator2.remove(); // Remove bird from the list

            // Check if there's a next bird to reposition
            if (iterator2.hasNext()) {
                Bird nextBird = iterator2.next();
                nextBird.getImage().setPosition(catapult.getBody().getPosition().x, catapult.getBody().getPosition().y+catapult.getImage().getHeight()/2f-nextBird.getImage().getHeight()/2f);
                nextBird.getBody().setTransform(catapult.getBody().getPosition().x, catapult.getBody().getPosition().y+catapult.getImage().getHeight()/2f-nextBird.getImage().getHeight()/2f, 0); // Update Box2D body
            }
        } else {
            // Update the last active bird
            previousBird = currentBird;
        }
    }

    // Check for win/lose conditions
    if (pigs.isEmpty()) {
        game.setScreen(new WinScreen(game, level_numb)); // All pigs are destroyed, switch to WinScreen
    } else if (birds.isEmpty()) {
        game.setScreen(new LoseScreen(game, level_numb)); // All birds are destroyed, switch to LoseScreen
    }

    SpriteBatch batch = ((MyGame) game).getBatch();
    batch.begin();
    batch.draw(backgroundTexture, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
    batch.end();
    for (Bird bird : birds) {
        bird.render(batch); // Render the bird, calling its update method inside the render
    }
    for (Pig pig : pigs) {
        pig.render(batch);
    }

    // Render blocks
    for (Block block : blocks) {
        block.render(batch);
    }
    batch.begin();
    if (mouseJoint != null) {
        Vector2 birdPosition = mouseJoint.getBodyB().getPosition(); // Bird's position
        Vector2 mousePosition = mouseJoint.getTarget(); // Target position (mouse)

        float dotWidth = 10f;  // Desired width of the dot
        float dotHeight = 10f; // Desired height of the dot

        float distance = birdPosition.dst(mousePosition); // Total distance
        float dotSpacing = 10f; // Space between dots
        int numberOfDots = (int) (distance / dotSpacing); // Number of dots

        for (int i = 0; i < numberOfDots; i++) {
            float t = (float) i / (numberOfDots - 1); // Interpolation factor
            //float t=(float)i;
            float x = birdPosition.x + t * (mousePosition.x - birdPosition.x);
            float y = birdPosition.y + +t * (mousePosition.y - birdPosition.y)-0.5f*9.8f*t*t;

            // Draw the dot
            // batch.draw(dotTexture, x - dotTexture.getWidth() / 2, y - dotTexture.getHeight() / 2);
            batch.draw(dotTexture, x - dotWidth / 2, y - dotHeight / 2, dotWidth, dotHeight);

        }
    }
    batch.end();
    Gdx.input.setInputProcessor(stage);     // Revert to main stage input
    stage.act(delta);
    stage.draw();
    //world.step(1 / 60f, 6, 2); // Step simulation (time step, velocity iterations, position iterations)
    if (!showPause) {
        world.step(1 / 60f, 6, 2); // Step simulation
        // Additional updates (e.g., birds, pigs, blocks)
    }

    // Process the destruction queue to safely remove bodies
    contactListener.processDestructionQueue(world);

    // Optionally, render the debug visuals for Box2D
    //debugRenderer.render(world, batch.getProjectionMatrix()); // Render the debug visuals


    if (!showPause) {
        // If settings are not shown, set input to main stage and draw it
        Gdx.input.setInputProcessor(stage);
        stage.act(delta);
        stage.draw();
    }

    // If settings are shown, set input to the settingsOverlay stage and render it
    if (showPause && overlayPause.isActive()) {
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
        pauseButton.setPosition(Gdx.graphics.getWidth() - pauseButton.getWidth(), Gdx.graphics.getHeight() - pauseButton.getHeight());
    }

    void createSlingshotJoint(Bird bird) {
        if (groundBody == null) {
            // Create the ground body only once
            BodyDef groundDef = new BodyDef();
            groundDef.type = BodyDef.BodyType.StaticBody;
            groundDef.position.set(bird.getBody().getPosition().x, bird.getBody().getPosition().x); // Position the ground body at (0, 0)
            groundBody = world.createBody(groundDef);
        }

        // Define the MouseJoint
        MouseJointDef jointDef = new MouseJointDef();
        jointDef.bodyA = groundBody;
        jointDef.bodyB = bird.getBody(); // Attach the bird body to the joint
        jointDef.target.set(bird.getBody().getPosition()); // Set the initial position
        jointDef.maxForce = 1000.0f * bird.getBody().getMass(); // Set the max force for the slingshot

        // Create the joint in the world
        mouseJoint = (MouseJoint) world.createJoint(jointDef);
    }

    //
//    public void touchDragged(int screenX, int screenY, int pointer) {
//        if (mouseJoint != null) {
//            // Convert screen coordinates to stage coordinates
//            Vector2 target = stage.screenToStageCoordinates(new Vector2(screenX, screenY));
//            mouseJoint.setTarget(target); // Update the mouse joint's target position
//        }
//
//    }


//    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//        if (mouseJoint != null) {
//            // Apply force to launch the bird when touch is released
//            Bird bird = getSelectedBird(); // Get the currently selected bird (could be the one last clicked)
//            Vector2 velocity = bird.getBody().getLinearVelocity(); // Get the current velocity of the bird
//            bird.launchBird(velocity.scl(2)); // Apply force to launch the bird (you can adjust the scaling factor)
//
//            // Destroy the joint and release the bird
//            world.destroyJoint(mouseJoint);
//            mouseJoint = null; // Release the bird
//        }
//
//    }

    private Bird getSelectedBird() {
        // Find the bird that was selected (this could be based on the last touch position)
        for (Bird bird : birds) {
            if (bird.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.input.getY())) {
                return bird;
            }
        }
        return null; // No bird selected
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
        game.setScreen(new LevelPage(game, level_numb)); // Re-initialize the LevelPage
    }

    public void navigateToTutorialPage() {
        Gdx.app.log("Exit", "Navigating to Tutorial Page");
        game.setScreen(new TutorialGame(game));
    }

    @Override
    public void dispose() {
        // Clean up resources
        stage.dispose();
        //dotTexture.dispose();
        if (dotTexture != null) {
            dotTexture.dispose();
        }
        backgroundTexture.dispose();
        overlayPause.dispose();
    }

    public InputProcessor getStage() {
        return stage;
    }
}

//    public SavedLevelPage(Game game, SerializableLevel levelData) {
//        super(game, levelData.levelNumber);

//        // Recreate birds
//        for (Bird bird : levelData.birds) {
//            birds.add(new Bird(
//                bird.texturePath, bird.x, bird.y, bird.width, bird.height,
//                bird.initialHealth, bird.isDestroyed
//            ));
//        }
//
//        // Recreate pigs
//        for (Pig pig : levelData.pigs) {
//            pigs.add(new Pig(
//                pig.texturePath, pig.x, pig.y, pig.width, pig.height,
//                pig.initialHealth, pig.isDestroyed
//            ));
//        }
//
//        // Recreate blocks
//        for (Block block : levelData.blocks) {
//            blocks.add(new Block(
//                block.texturePath, block.x, block.y, block.width, block.height,
//                block.initialHealth, block.isDestroyed
//            ));
//        }
    //}


