package io.github.some_example_name;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class TrajectoryRenderer {
    private ShapeRenderer shapeRenderer;

    public TrajectoryRenderer() {
        shapeRenderer = new ShapeRenderer();
    }

    public void renderTrajectory(float startX, float startY, float velocityX, float velocityY, float gravity, float timeStep, int points) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);

        float t = 0;
        for (int i = 0; i < points; i++) {
            float x = startX + velocityX * t;
            float y = startY + velocityY * t - 0.5f * gravity * t * t;

            if (i > 0) shapeRenderer.line(startX, startY, x, y);

            startX = x;
            startY = y;
            t += timeStep;
        }

        shapeRenderer.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }
}
