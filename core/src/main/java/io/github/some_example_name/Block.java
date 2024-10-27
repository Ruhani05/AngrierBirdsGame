package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Block {
    private Image image;
    private float xPercent, yPercent; // Store percentage positions
    private float widthPercent, heightPercent; // Store percentage sizes

    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public Block(String texturePath, float x, float y, float width, float height) {
        Texture texture = new Texture(texturePath);
        this.xPercent=x;
        this.yPercent=y;
        this.widthPercent=width;
        this.heightPercent=height;
        this.image = new Image(texture);
        this.image.setPosition(SCREEN_WIDTH*x-width*0.5f,SCREEN_HEIGHT* y-height*0.5f);
        this.image.setSize(width, height);  // Resize to specified dimensions
    }

    public Image getImage() {
        return image;
    }
//    public void resize(float newWidth, float newHeight) {
//        // Resize and reposition the block based on the new screen dimensions
//        float newBlockWidth = newWidth * widthPercent;
//        float newBlockHeight = newHeight * heightPercent;
//        float newX = newWidth * xPercent - newBlockWidth * 0.5f;
//        float newY = newHeight * yPercent - newBlockHeight * 0.5f;
//
//        this.image.setSize(newBlockWidth, newBlockHeight);
//        this.image.setPosition(newX, newY);
//    }
}
