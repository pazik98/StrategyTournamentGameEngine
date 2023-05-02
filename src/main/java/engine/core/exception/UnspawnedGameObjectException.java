package engine.core.exception;

import engine.core.GameObject;

public class UnspawnedGameObjectException extends Exception {

    public UnspawnedGameObjectException(GameObject gameObject) {
        super("Cannot despawn " + gameObject + ". It wasn't spawned");
    }
}
