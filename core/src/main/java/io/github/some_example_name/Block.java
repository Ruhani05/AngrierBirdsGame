package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import io.github.some_example_name.serializationPurpose.BirdDTO;
import io.github.some_example_name.serializationPurpose.BlockDTO;

public class Block {
    public String texturePath;

    private Image image;
    private int health; // Block's health
    private boolean isDestroyed;
    // Flag to mark if block is destroyed

    private Body body;
    private World world;
    private float xPercent, yPercent; // Store percentage positions
    private float widthPercent, heightPercent; // Store percentage sizes

    float SCREEN_WIDTH = Gdx.graphics.getWidth();
    float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public Block(BlockDTO dto, World world) {
        this(dto.texturePath, (dto.x+dto.width)/Gdx.graphics.getWidth(), (dto.y+dto.height*0.5f)/Gdx.graphics.getHeight(), dto.width, dto.height, world, dto.health);
        this.isDestroyed = dto.isDestroyed;
    }
    public Block(String texturePath, float x, float y, float width, float height, World world,int initialHealth) {
        Texture texture = new Texture(texturePath);
        this.texturePath=texturePath;

        //this.xPercent=x;
        this.world = world;
        this.health = initialHealth;
        this.isDestroyed = false;

       // this.yPercent=y;
        this.widthPercent=width;
        this.heightPercent=height;
        // Create Box2D Body for Block
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;  // Blocks are static
        bodyDef.position.set(SCREEN_WIDTH*x-width*0.5f,SCREEN_HEIGHT* y-height*0.5f);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width * 0.5f, height * 0.5f);

        this.body = world.createBody(bodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        fixtureDef.restitution = 0.5f; // Bounciness (if needed)
// Blocks are not affected by gravity
        fixtureDef.friction = 0.1f;

        //this.body.createFixture(fixtureDef);
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData(this);
        //body.setUserData(this);
        //shape.dispose();
        this.image = new Image(texture);
        this.image.setPosition(SCREEN_WIDTH*x-width*0.5f,SCREEN_HEIGHT* y-height*0.5f);
        this.image.setSize(width, height);  // Resize to specified dimensions
    }

    public Image getImage() {
        return image;
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
        image.draw(batch, 1);
        batch.end();
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

    public void update(float deltaTime) {
        if (isDestroyed) return; // Don't update if destroyed

        Vector2 position = body.getPosition();
        //image.setPosition(position.x, position.y);
        image.setPosition(position.x - image.getWidth() / 2f, position.y - image.getHeight() / 2f);

        image.setRotation((float) Math.toDegrees(body.getAngle()));
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public String getHealth() {
        return Integer.toString(health);  // Convert health (an integer) to a String

    }
    public int getHealthI() {//return health.to_String(());
        return health;
    }
    public Body getBody() {return body;
    }

    public void setHealth(int i) {health=i;
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
