package engine.core.exception;

import engine.gameobject.GameObject;

public class UnspawnedGameObjectException extends Exception {

    public UnspawnedGameObjectException(GameObject gameObject) {
        super("Cannot despawn " + gameObject + ". It wasn't spawned");
    }
}
