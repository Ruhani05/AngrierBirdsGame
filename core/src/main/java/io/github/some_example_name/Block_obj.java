package io.github.some_example_name;

public class Block_obj {
    private int health;

    public Block_obj(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public boolean isDestroyed() {
        return this.health == 0;
    }
}
