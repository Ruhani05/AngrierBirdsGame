package io.github.some_example_name;

import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.util.ArrayList;

public class Structure {
    //    static Stage stage;
//    void Structure(Stage s){
//        this.stage=s;
//    }

    static void structure1(Stage stage, World world, ArrayList<Pig> pigs,ArrayList<Block> blocks){
       // Ground grd= new Ground("step.png",640,45,0.65f,0.24f);
        Pig pig1 = new Pig("pig1.png", 0.64f, 0.1f+0.14f+0.04f, 50, 50,world,4);
        Pig pig9 = new Pig("pig2.png", 0.56f, 0.1f+0.14f+0.04f, 50, 50,world,4);
        Block block1 = new Block("block3.png", 0.5f, 0.32f, 30, 120,world,10);
        Block block7 = new Block("block3.png", 0.72f, 0.3f+0.02f, 30, 120,world,10);
//        Pig pig1 = new Pig("pig1.png", 0.47f, 0.1f+0.14f+0.04f, 50, 50,world,5);
//        Pig pig9 = new Pig("pig2.png", 0.55f, 0.1f+0.14f+0.04f, 50, 50,world,5);
//        Block block1 = new Block("block3.png", 0.37f, 0.32f, 50, 50,world,2);
//        Block block7 = new Block("block3.png", 0.25f+0.35f, 0.3f+0.02f, 30, 120,world,5);
        //stage.addActor(grd.getImage());
        stage.addActor(pig1.getImage());
        stage.addActor(pig9.getImage());
        stage.addActor(block1.getImage());
        stage.addActor(block7.getImage());
        pigs.add(pig1);
        pigs.add(pig9);
        blocks.add(block1);
        blocks.add(block7);

    }
    static void structure2(Stage stage, World world, ArrayList<Pig> pigs,ArrayList<Block> blocks){
        // Ground grd= new Ground("step.png",640,45,0.65f,0.24f);
        Pig pig1 = new Pig("pig1.png", 0.64f, 0.17f, 50, 50,world,5);
        Pig pig9 = new Pig("pig2.png", 0.56f, 0.17f, 50, 50,world,5);
        Block block1 = new Block("block3.png", 0.52f, 0.26f, 30, 120,world,10);
        Block block7 = new Block("block3.png", 0.70f, 0.26f, 30, 120,world,10);
        Block block3 = new Block("block3.png", 0.61f, 0.26f, 30, 120,world,10);
        Block block4 = new Block("block1.png", 0.715f, 0.30f, 370, 30,world,20);
        Pig pig3= new Pig("pig3.png", 0.56f, 0.32f, 50, 50,world,5);
        Pig pig4= new Pig("pig4.png", 0.64f, 0.32f, 50, 50,world,5);

//        Pig pig1 = new Pig("pig1.png", 0.47f, 0.1f+0.14f+0.04f, 50, 50,world,5);
//        Pig pig9 = new Pig("pig2.png", 0.55f, 0.1f+0.14f+0.04f, 50, 50,world,5);
//        Block block1 = new Block("block3.png", 0.37f, 0.32f, 50, 50,world,2);
//        Block block7 = new Block("block3.png", 0.25f+0.35f, 0.3f+0.02f, 30, 120,world,5);
        //stage.addActor(grd.getImage());
        stage.addActor(pig1.getImage());
        stage.addActor(pig9.getImage()); stage.addActor(pig3.getImage());stage.addActor(pig4.getImage());
        stage.addActor(block1.getImage());
        stage.addActor(block7.getImage());stage.addActor(block3.getImage());stage.addActor(block4.getImage());
        pigs.add(pig1);
        pigs.add(pig9);pigs.add(pig3);pigs.add(pig4);
       blocks.add(block1);
        blocks.add(block7);blocks.add(block3);blocks.add(block4);

    }

    static void structure3(Stage stage, World world, ArrayList<Pig> pigs,ArrayList<Block> blocks){
        // Ground Level Pigs
        //Ground grd= new Ground("step.png",640,45,0.65f,0.24f,world);
        Pig pig1 = new Pig("pig1.png", 0.47f, 0.1f+0.14f+0.04f, 50, 50,world,6);
        Pig pig9 = new Pig("pig2.png", 0.55f, 0.1f+0.14f+0.04f, 50, 50,world,6);
        Pig pig10 = new Pig("pig3.png", 0.65f, 0.1f+0.14f+0.04f, 50, 50,world,6);
        Pig pig11 = new Pig("pig4.png", 0.75f, 0.1f+0.14f+0.04f, 50, 50,world,6);
        Pig pig12 = new Pig("pig1.png", 0.83f, 0.1f+0.14f+0.04f, 50, 50,world,6);
/////////////////not used
//        Pig pig2 = new Pig("pig2.png", 0.2f, 0.1f+0.14f, 50, 50);
//        Pig pig3 = new Pig("pig3.png", 0.3f, 0.1f+0.14f, 50, 50);
//        Pig pig4 = new Pig("pig4.png", 0.4f, 0.1f+0.14f, 50, 50);
//        Pig pig5 = new Pig("pig1.png", 0.5f, 0.1f+0.14f, 50, 50);
////////////////////
// Middle Layer (Metal and Glass Blocks)
        Block block1 = new Block("block3.png", 0.15f+0.36f, 0.32f+0.04f, 60, 120,world,10);
        Block block7 = new Block("block3.png", 0.25f+0.35f, 0.3f+0.02f+0.04f, 60, 120,world,10);
        Block block8 = new Block("block3.png", 0.35f+0.35f, 0.3f+0.02f+0.04f, 60, 120,world,10);
        Block block9 = new Block("block3.png", 0.45f+0.34f, 0.3f+0.02f+0.04f, 60, 120,world,10);

//        Block block2 = new Block("block3.png", 0.25f+0.35f, 0.3f+0.02f, 60, 120);
//        Block block3 = new Block("block3.png", 0.35f+0.35f, 0.3f+0.02f, 60, 120);
//        Block block4 = new Block("block3.png", 0.45f+0.34f, 0.3f+0.02f, 60, 120);
        /////
        //Block block5 = new Block("block2.png", 0.3f, 0.4f+0.14f, 60, 30);
////
// Add Pigs on Middle Layer
        //Pig pig6 = new Pig("pig2.png", 0.3f, 0.45f+0.1f, 50, 50);
        Block block6 = new Block("block2.png", 0.58f, 0.40f, 180, 50,world,10);
        Block block3 = new Block("block2.png", 0.58f, 0.43f, 180, 30,world,10);
        Block block2 = new Block("block2.png", 0.685f, 0.40f, 180, 50,world,10);
        Block block4 = new Block("block2.png", 0.685f, 0.43f, 180, 30,world,10);

        Block block10 = new Block("block2.png", 0.785f, 0.4f, 180, 50,world,10);
        Block block11 = new Block("block2.png", 0.785f, 0.43f, 180, 30,world,10);
        //mid layer pigs:
        Pig pig7 = new Pig("pig4.png", 0.56f, 0.48f, 75, 70,world,6);
        Pig pig8 = new Pig("pig3.png", 0.73f, 0.48f, 70, 70,world,6);

//sq block
        Block block13 = new Block("block_g_rect.png", 0.65f, 0.53f, 75, 75,world,10);
        Block block14 = new Block("block_g_rect.png", 0.65f, 0.605f, 75, 75,world,10);
//        Block block13 = new Block("block_g_rect.png", 0.65f, 0.485f, 75, 75,world,10);
//        Block block14 = new Block("block_g_rect.png", 0.65f, 0.56f, 75, 75,world,10);

//        Block block5 = new Block("block1.png", 0.655f, 0.61f, 200, 27,world,10);
//        Pig pig13 = new Pig("pig2.png", 0.655f, 0.65f, 55, 55,world,6);
//        Block block15 = new Block("block1.png", 0.62f, 0.65f, 50, 50,world,10);
//        Block block16 = new Block("block1.png", 0.7f, 0.65f, 50, 50,world,10);
//        Block block17 = new Block("block1.png", 0.62f, 0.7f, 50, 50,world,10);
//        Block block18 = new Block("block1.png", 0.7f, 0.7f, 50, 50,world,10);
// Top Layer (Triangle Wood Blocks)
        Block block5 = new Block("block1.png", 0.683f, 0.643f, 200, 27,world,10);
        Pig pig13 = new Pig("pig2.png", 0.62f, 0.68f, 55, 55,world,6);
        Block block15 = new Block("block1.png", 0.59f, 0.69f, 50, 50,world,10);
        Block block16 = new Block("block1.png", 0.675f, 0.69f, 50, 50,world,10);
        Block block17 = new Block("block1.png", 0.59f, 0.74f, 50, 50,world,10);
        Block block18 = new Block("block1.png", 0.675f, 0.74f, 50, 50,world,10);


        Block block12= new Block("block_triangle.png", 0.665f, 0.82f, 150, 90,world,6);
       // Block block12= new Block("block_triangle.png", 0.655f, 0.6f+0.17f, 150, 90,world,6);

// Top Layer Pigs

// Add Blocks and Pigs to Stage
        //stage.addActor(grd.getImage());
        stage.addActor(block6.getImage());
        stage.addActor(block1.getImage());
        stage.addActor(block2.getImage());
        stage.addActor(block3.getImage());
        stage.addActor(block4.getImage());
        stage.addActor(block5.getImage());

        stage.addActor(block7.getImage());
        stage.addActor(block8.getImage());
        stage.addActor(block9.getImage());
        stage.addActor(block10.getImage());
        stage.addActor(block11.getImage());
        stage.addActor(block12.getImage());
        stage.addActor(block13.getImage());
        stage.addActor(block14.getImage());
        stage.addActor(block15.getImage());
        stage.addActor(block16.getImage());
        stage.addActor(block17.getImage());
        stage.addActor(block18.getImage());
        blocks.add(block1);blocks.add(block2);blocks.add(block3);blocks.add(block4);blocks.add(block5);blocks.add(block6);
        blocks.add(block7);blocks.add(block8);blocks.add(block9);blocks.add(block10);blocks.add(block11);blocks.add(block12);
        blocks.add(block13);blocks.add(block14);blocks.add(block15);blocks.add(block16);blocks.add(block17);blocks.add(block18);

        stage.addActor(pig1.getImage());
//        stage.addActor(pig2.getImage());
//        stage.addActor(pig3.getImage());
//        stage.addActor(pig4.getImage());
//        stage.addActor(pig5.getImage());
//        stage.addActor(pig6.getImage());
        stage.addActor(pig7.getImage());
        stage.addActor(pig8.getImage());
        stage.addActor(pig9.getImage());
        stage.addActor(pig10.getImage());
        stage.addActor(pig11.getImage());
        stage.addActor(pig12.getImage());stage.addActor(pig13.getImage());
        pigs.add(pig1);pigs.add(pig7);pigs.add(pig8);pigs.add(pig9);pigs.add(pig10);pigs.add(pig11);pigs.add(pig12);pigs.add(pig13);

    }


}
