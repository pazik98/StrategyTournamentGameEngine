package engine.core.System;

import engine.core.component.Transform;
import engine.gameobject.GameObject;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;
import java.util.Random;

public class RandomMovingSystem implements ISystem {

    private List<GameObject> gameObjects;
    private Random random = new Random();

    public RandomMovingSystem(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    @Override
    public void takeStep() {
        for (GameObject gameObject : gameObjects) {
            gameObject.getComponent(Transform.class).setPosition(new Vector2D(getRandomInt(0, 500), getRandomInt(0, 500)));
        }
    }

    private int getRandomInt(int min, int max) {
        int result = random.nextInt(max - min) + min;
        return result;
    }
}
