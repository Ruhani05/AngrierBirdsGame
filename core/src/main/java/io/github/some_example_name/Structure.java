package io.github.some_example_name;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Structure {
    //    static Stage stage;
//    void Structure(Stage s){
//        this.stage=s;
//    }
    static void structure1(Stage stage){
        Block block1 = new Block("block1.PNG", 400, 125, 60, 30); // width=60, height=30
        Block block2 = new Block("block2.PNG", 460, 125, 60, 30);
        Block block3 = new Block("block3.PNG", 460, 155, 80, 60);
        Pig pig1 = new Pig("pig3.PNG", 420, 155, 50, 50);         // width=50, height=50
        Pig pig2 = new Pig("pig2.PNG", 460, 215, 50, 50);         // width=50, height=50
        stage.addActor(block1.getImage());
        stage.addActor(block2.getImage());
        stage.addActor(block3.getImage());
        stage.addActor(pig2.getImage());
        stage.addActor(pig1.getImage());
    }
}
