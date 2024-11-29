package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.math.Vector2;
import io.github.some_example_name.serializationPurpose.BirdDTO;

public class Bird {
    public String texturePath;
    private Image image;
    private int health; // Block's health
    private boolean isDestroyed; // Flag to mark if block is destroyed

    private Body body;
    private World world;
    private float SCREEN_WIDTH = Gdx.graphics.getWidth();
    private float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public Bird(BirdDTO dto, World world) {
        this(dto.texturePath, (dto.x+dto.width*0.5f+22.5f)/Gdx.graphics.getWidth(), (dto.y+dto.height*0.5f)/Gdx.graphics.getHeight(), dto.width, dto.height, world, dto.health);
        this.image.setPosition(dto.x,dto.y);
        //bodyDef.position.set
        this.isDestroyed = dto.isDestroyed;
    }
    public Bird(String texturePath, float x, float y, float width, float height, World world,int initialHealth) {
        this.world = world;
        this.texturePath=texturePath;
        this.health = initialHealth;
        this.isDestroyed = false;
        // Load the image for the bird
        Texture texture = new Texture(texturePath);
        this.image = new Image(texture);
        this.image.setSize(width, height);
        this.image.setPosition(SCREEN_WIDTH * x - width * 0.5f, SCREEN_HEIGHT * y - height * 0.5f);

        // Create the Box2D body for the bird
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(SCREEN_WIDTH * x - width * 0.5f, SCREEN_HEIGHT * y - height * 0.5f); // Initial position of the bird in world coordinates
        body = world.createBody(bodyDef);

        // Create a shape for the body (a simple rectangle for the bird)
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2f, height / 2f); // Set the box size (half-width, half-height)

        // Create a fixture for the bird's body
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f; // Density for the physics body
        fixtureDef.restitution = 0.5f; // Bounciness (if needed)
        fixtureDef.friction = 0.2f; // Friction
        body.createFixture(fixtureDef);
        Fixture fixture = body.createFixture(fixtureDef);
        fixture.setUserData(this);
        //body.setUserData("Bird");
        // Clean up shape as it's no longer needed after creating the fixture
        shape.dispose();
    }
    // Method to launch the bird when interacting with slingshot (set to dynamic and apply force)
//    public void launchBird(Vector2 force) {
//        body.setType(BodyDef.BodyType.DynamicBody); // Change to dynamic body (physics enabled)
//        body.applyForce(force, body.getWorldCenter(), true); // Apply force to launch the bird
//    }
//    public void launchBird(Vector2 force) {
//        body.setType(BodyDef.BodyType.DynamicBody); // Change to dynamic body
//        body.setLinearVelocity(force.scl(0.1f)); // Adjust scaling as needed
//    }


    // Update method to sync image position with Box2D body
    public void update(float deltaTime) {

        if (isDestroyed) return; // Don't update if destroyed

        // Sync the image's position with the Box2D body
        Vector2 position = body.getPosition();
        image.setPosition(position.x - image.getWidth() / 2f, position.y - image.getHeight() / 2f);

        // Optionally, sync rotation (if needed for the bird)
        image.setRotation((float) Math.toDegrees(body.getAngle()));
    }
    // Method to return the bounding rectangle of the bird
    public Rectangle getBoundingRectangle() {
        return new Rectangle(image.getX(), image.getY(), image.getWidth(), image.getHeight());
    }

    // Method to render the bird image
    public void render(SpriteBatch batch) {
        if (isDestroyed) {
            // Move the object off-screen when destroyed
            image.setPosition(-1000, -1000); // Move it far outside the viewable area
            return; // Don't update further if destroyed
        } // Don't render if destroyed

        update(Gdx.graphics.getDeltaTime());
        batch.begin();
        image.draw(batch, 1); // Draw the bird's image
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

    public Image getImage() {
        return image;
    }

    public Body getBody() {
        return body;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }
    public int getHealthI() {//return health.to_String(());
        return health;
    }
    public String getHealth() {//return health.to_String(());
        return Integer.toString(health);  // Convert health (an integer) to a String

    }
    public String getTexture(){
        return texturePath;
    }

    public void setHealth(int i) {health=i;
    }
}
