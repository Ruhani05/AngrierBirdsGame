package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import io.github.some_example_name.serializationPurpose.BirdDTO;
import io.github.some_example_name.serializationPurpose.PigDTO;

public class Pig {
    public String texturePath;

    private Image image;
    private Body body;
    private World world;
    private int health; // Block's health
    private boolean isDestroyed;
    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public Pig(PigDTO dto, World world) {
        this(dto.texturePath, (dto.x+dto.width*0.5f+22.5f)/Gdx.graphics.getWidth(), (dto.y+dto.height*0.5f)/Gdx.graphics.getHeight(), dto.width, dto.height, world, dto.health);
        this.isDestroyed = dto.isDestroyed;
    }
    public Pig(String texturePath, float x, float y, float width, float height,World world,int initialHealth) {
        Texture texture = new Texture(texturePath);
        this.texturePath=texturePath;
        this.world=world;
        this.health = initialHealth;
        this.isDestroyed = false;
        // Create Box2D Body for Pig
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;  // Pigs are dynamic
        bodyDef.position.set(x * SCREEN_WIDTH, y * SCREEN_HEIGHT);
        body = world.createBody(bodyDef);
        CircleShape shape = new CircleShape();
        shape.setRadius(width * 0.5f);

        //this.body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;  // Pigs have mass
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.2f;  // Make pigs bounce a bit
        body.createFixture(fixtureDef);
//        this.body.createFixture(fixtureDef);
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData(this);
        //body.setUserData(this);
        shape.dispose();
        this.image = new Image(texture);
        this.image.setPosition(SCREEN_WIDTH*x-width*0.5f,SCREEN_HEIGHT* y-height*0.5f);
        this.image.setSize(width, height);  // Resize to specified dimensions
    }
    public void update(float deltaTime) {
        if (isDestroyed) return; // Don't render if destroyed

        // Sync the image's position with the Box2D body
        Vector2 position = body.getPosition();
        image.setPosition(position.x - image.getWidth() / 2f, position.y - image.getHeight() / 2f);

        // Optionally, sync rotation (if needed for the bird)
        image.setRotation((float) Math.toDegrees(body.getAngle()));
    }
    public void render(SpriteBatch batch) {
        //if (isDestroyed) return; // Don't render if destroyed
        if (isDestroyed) {
            // Move the object off-screen when destroyed
            image.setPosition(-1000, -1000); // Move it far outside the viewable area
            return; // Don't update further if destroyed
        }
        update(Gdx.graphics.getDeltaTime());
        batch.begin();
        image.draw(batch, 1); // Draw the bird's image
        batch.end();
    }
    public int getHealth() {
        return health;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
    public int getHealthI() {//return health.to_String(());
        return health;
    }

    public void reduceHealth(int damage) {
        if (isDestroyed) return; // Ignore if already destroyed
        health -= damage;
        if (health <= 0) {
            health = 0;
            isDestroyed=true;
            //destroy();
        }
    }
    private void destroy() {
        isDestroyed = true;
        world.destroyBody(body); // Remove physics body
    }
    public Body getBody() {return body;
    }

    public Image getImage() {
        return image;
    }
}
