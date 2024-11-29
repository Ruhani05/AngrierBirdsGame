package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Catapult {
    private Image image;
    private World world;
    private Body body; // Box2D body for the ground object

    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();

    public Catapult(String texturePath, float x, float y, float width, float height,World world) {
        Texture texture = new Texture(texturePath);
        this.world=world;
        this.image = new Image(texture);
        this.image.setPosition(SCREEN_WIDTH*x-width*0.5f,SCREEN_HEIGHT* y-height*0.5f);
        this.image.setSize(width, height);  // Resize to specified dimensions
        // Create a static body for the ground
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody; // Static body for ground
        bodyDef.position.set(SCREEN_WIDTH*x,SCREEN_HEIGHT* y); // Position in the world (adjust as needed)

        this.body = world.createBody(bodyDef);

        // Create the shape for the ground body (simple box shape)
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2f, height / 5f); // Box shape with half-width, half-height

        // Create the fixture for the ground body
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 0f; // No density for the ground
        fixtureDef.friction = 0.5f; // Ground friction
        fixtureDef.restitution = 0.0f; // No bounce

        this.body.createFixture(fixtureDef);

        // Dispose of the shape after creating the fixture
        shape.dispose();
    }

    public Image getImage() {
        return image;
    }

    public Body getBody() {return body;
    }
}
