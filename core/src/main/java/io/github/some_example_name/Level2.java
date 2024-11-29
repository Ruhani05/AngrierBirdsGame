package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;

import java.util.ArrayList;


public class Level2 extends Level_parent{
    private Ground ground;
    private Catapult catapult;
    private ArrayList<Bird> birds; // Store the birds
    private ArrayList<Pig> pigs;
    private ArrayList<Block> blocks;
    World world;
    public Level2(Ground ground, Catapult catapult, World world) {
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

        Bird bird1 = new Bird("bird3.PNG", 0.216f, 0.3f, 45, 45,world,1);
        Ground step1=new Ground("step.png",45,45,0.125f,0.17f,world);
        // width=45, height=45
        Ground step2=new Ground("step.png",45,45,0.15f,0.17f,world);
        Ground step3=new Ground("step.png",45,45,0.15f,0.22f,world);

        Bird bird3 = new Bird("bird2.PNG", 0.133f, 0.22f, 45, 45,world,2);
        Bird bird2 = new Bird("bird1.PNG", 0.158f , 0.28f, 45, 45,world,2);
        Bird bird4 = new Bird("bird4.PNG", 0.1f , 0.17f, 45, 45,world,2);



        stage.addActor(step1.getImage());
        stage.addActor(step2.getImage());
        stage.addActor(step3.getImage());
        stage.addActor(bird1.getImage());
        stage.addActor(bird2.getImage());
        stage.addActor(bird3.getImage());stage.addActor(bird4.getImage());
        Structure.structure2(stage,this.world,pigs,blocks);
        birds.add(bird1); // Add birds to the list
        birds.add(bird2);
        birds.add(bird3);
        birds.add(bird4);
    }
    public ArrayList<Bird> getBirds() {
        return birds; // Expose the birds
    }

    public Texture bg() {
        Texture backgroundTexture = new Texture("lvl_bg.jpg");
        return backgroundTexture;
    }

    public ArrayList<Block> getBlocks() { return blocks;
    }

    public ArrayList<Pig> getPigs() {return pigs;
    }
}
