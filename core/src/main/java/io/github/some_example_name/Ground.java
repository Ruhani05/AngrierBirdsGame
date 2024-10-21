package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.util.Random;

public class Ground {
    private Image image;

    public Ground(String texturePath, float width, float height) {
        Texture texture = new Texture(texturePath);
        this.image = new Image(texture);
        this.image.setSize(width, height);  // Set size for the ground
        this.image.setPosition(0, 0);  // Positioning at the bottom
    }

    public Image getImage() {
        return image;
    }



public void ground_type1() {
        // Code to stack or randomly place "grd.png" to form the ground
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            float x = random.nextFloat() * 800;
            image.setPosition(x, 0);
        }
    }
}
