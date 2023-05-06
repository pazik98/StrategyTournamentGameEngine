package engine.core.System;

import engine.core.component.Transform;
import engine.core.entity.gameobject.GameObject;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.Random;

public class RandomMovingSystem implements ISystem {

    private List<GameObject> gameObjects;
    private final Random random = new Random();

    public RandomMovingSystem(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    public void takeStep() {
        for (GameObject gameObject : gameObjects) {
            Vector2D oldPosition = gameObject.getComponent(Transform.class).getPosition();
            gameObject.getComponent(Transform.class)
                    .setPosition(new Vector2D(oldPosition.getX() + getRandomInt(-10, 10), oldPosition.getY() + getRandomInt(-15, +15)));
        }
    }

    private int getRandomInt(int min, int max) {
        int result = random.nextInt(max - min) + min;
        return result;
    }
}
