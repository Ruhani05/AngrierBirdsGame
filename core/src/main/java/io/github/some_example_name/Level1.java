package io.github.some_example_name;

import com.badlogic.gdx.scenes.scene2d.Stage;


public class Level1 {
    private Ground ground;
    private Catapult catapult;

    public Level1(Ground ground, Catapult catapult) {
        this.ground = ground;
        this.catapult = catapult;
    }

    public void setupLevel(Stage stage) {
        ground.ground_type1();

        // Adding example blocks, pigs, and birds with resized images
        Block block1 = new Block("block1.PNG", 400, 125, 60, 30); // width=60, height=30
        Block block2 = new Block("block2.PNG", 460, 125, 60, 30);
        Block block3 = new Block("block3.PNG", 460, 155, 80, 60);
        Pig pig1 = new Pig("pig3.PNG", 420, 155, 50, 50);         // width=50, height=50
        Pig pig2 = new Pig("pig2.PNG", 460, 215, 50, 50);         // width=50, height=50

        Bird bird1 = new Bird("bird1.PNG", 120, 125, 45, 45);     // width=45, height=45
        Bird bird2 = new Bird("bird2.PNG", 170, 125, 45, 45);
        Bird bird3 = new Bird("bird3.PNG", 235 , 225, 45, 45);

        stage.addActor(block1.getImage());
        stage.addActor(block2.getImage());
        stage.addActor(block3.getImage());
        stage.addActor(pig2.getImage());
        stage.addActor(pig1.getImage());
        stage.addActor(bird1.getImage());
        stage.addActor(bird2.getImage());
        stage.addActor(bird3.getImage());
    }
}
