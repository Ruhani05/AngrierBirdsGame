package io.github.some_example_name.serializationPurpose;

import java.io.Serializable;

public class BirdDTO implements Serializable {
    public String texturePath;
    public float x, y, width, height;
    public int health;
    public boolean isDestroyed;

    public BirdDTO(String texturePath, float x, float y, float width, float height, int health, boolean isDestroyed) {
        this.texturePath = texturePath;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
        this.isDestroyed = isDestroyed;
    }
}

