package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;


public class Level3 extends Level_parent{
    private Ground ground;
    private Catapult catapult;
    private ArrayList<Bird> birds; // Store the birds
    private ArrayList<Pig> pigs;
    private ArrayList<Block> blocks;
    World world;
    public Level3(Ground ground, Catapult catapult, World world) {
        this.ground = ground;
        this.catapult = catapult;
        this.birds = new ArrayList<>();
        this.pigs = new ArrayList<>();
        this.blocks = new ArrayList<>();
        this.world=world;
    }

    public void setupLevel(Stage stage) {
        //ground.ground_type1();

        // Adding example blocks, pigs, and birds with resized images

        Bird bird1 = new Bird("bird2.PNG", 0.216f, 0.355f, 45, 45,world,1);

        Bird bird3 = new Bird("bird1.PNG", 0.133f, 0.25f, 45, 45,world,2);
        Bird bird2 = new Bird("bird3.PNG", 0.158f , 0.25f, 45, 45,world,2);

        Bird bird4 = new Bird("bird4.PNG", 0.108f, 0.25f, 45, 45,world,2);
        Bird bird5 = new Bird("bird5.PNG", 0.083f , 0.25f, 45, 45,world,2);


       stage.addActor(bird1.getImage());
        stage.addActor(bird2.getImage());
        stage.addActor(bird3.getImage());stage.addActor(bird4.getImage());
        stage.addActor(bird5.getImage());
        Structure.structure3(stage,this.world,pigs,blocks);
        birds.add(bird1); // Add birds to the list
        birds.add(bird2);
        birds.add(bird3);
        birds.add(bird4);
        birds.add(bird5);
    }
    public ArrayList<Bird> getBirds() {
        return birds; // Expose the birds
    }

    public Texture bg() {
        Texture backgroundTexture = new Texture("level3_bg.png");
        return backgroundTexture;
    }

    public ArrayList<Block> getBlocks() { return blocks;
    }

    public ArrayList<Pig> getPigs() {return pigs;
    }
}
