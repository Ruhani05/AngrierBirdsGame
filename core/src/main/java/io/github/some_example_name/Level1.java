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

        Bird bird1 = new Bird("bird1.PNG", 120, 125, 45, 45);     // width=45, height=45
        Bird bird2 = new Bird("bird2.PNG", 170, 125, 45, 45);
        Bird bird3 = new Bird("bird3.PNG", 235 , 225, 45, 45);


        stage.addActor(bird1.getImage());
        stage.addActor(bird2.getImage());
        stage.addActor(bird3.getImage());
        Structure.structure1(stage);
    }
}
