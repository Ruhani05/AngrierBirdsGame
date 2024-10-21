package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Bird {
    private Image image;

    public Bird(String texturePath, float x, float y, float width, float height) {
        Texture texture = new Texture(texturePath);
        this.image = new Image(texture);
        this.image.setPosition(x, y);
        this.image.setSize(width, height);  // Resize to specified dimensions
    }

    public Image getImage() {
        return image;
    }
}
