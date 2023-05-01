package engine.core.exception;

import engine.core.GameObject;

public class UnspawnedGameObject extends Exception {

    public UnspawnedGameObject(GameObject gameObject) {
        super("Cannot despawn " + gameObject + ". It wasn't spawned");
    }
}
