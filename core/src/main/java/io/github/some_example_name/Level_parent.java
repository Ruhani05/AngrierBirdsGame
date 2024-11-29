package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class Level_parent {


    public void setupLevel(Stage stage) {}
    public Texture bg(){return new Texture("Pause_bg");}
    public ArrayList<Block> getBlocks() { return new ArrayList<>();}
    public ArrayList<Pig> getPigs() { return new ArrayList<>();}
    public ArrayList<Bird> getBirds() { return new ArrayList<>();}



}
