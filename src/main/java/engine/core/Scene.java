package engine.core;

import engine.core.component.ComponentManager;
import engine.core.component.Transform;
import engine.core.entity.EntityManager;
import engine.core.exception.UnspawnedGameObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private static final Logger rootLogger = LogManager.getRootLogger();

    EntityManager entityManager;
    ComponentManager componentManager;
    List<GameObject> gameObjects;

    public Scene() {
        entityManager = new EntityManager();
        componentManager = new ComponentManager();
        gameObjects = new ArrayList<>();
    }

    public <T extends GameObject> T spawn(Class<T> gameObjectClass) {
        T gameObject = entityManager.createEntity(gameObjectClass);
        gameObjects.add(gameObject);
        componentManager.createComponent(Transform.class, gameObject);
        rootLogger.debug(gameObject + " spawned on " + this);
        return gameObject;
    }

    public void despawn(GameObject gameObject) {
        try {
            destroyGameObject(gameObject);
            rootLogger.debug(gameObject + " was despawned from " + this);
        } catch (UnspawnedGameObject e) {
            e.printStackTrace();
        }
    }

    private void destroyGameObject(GameObject gameObject) throws UnspawnedGameObject {
        for (GameObject gameObj : gameObjects) {
            if (gameObj.equals(gameObject)) {
                gameObjects.remove(gameObject);
                entityManager.destroyEntity(gameObject.getId());
                return;
            }
        }
        throw new UnspawnedGameObject(gameObject);
    }
}
