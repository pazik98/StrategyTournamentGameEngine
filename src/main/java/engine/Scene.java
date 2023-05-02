package engine;

import engine.core.component.*;
import engine.core.entity.EntityManager;
import engine.core.entity.IEntityManager;
import engine.core.exception.UnspawnedGameObjectException;
import engine.gameobject.Camera;
import engine.gameobject.GameObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private static final Logger rootLogger = LogManager.getRootLogger();

    IEntityManager entityManager;
    IComponentManager componentManager;
    List<GameObject> gameObjects;

    public Scene() {
        entityManager = new EntityManager();
        componentManager = new ComponentManager();
        gameObjects = new ArrayList<>();
    }

    public <T extends GameObject, K extends Component> T spawn(Class<T> gameObjectClass, Class<K>[] componentClasses) {
        T gameObject = entityManager.createEntity(gameObjectClass);
        gameObjects.add(gameObject);
        if (componentClasses != null)
            for (Class<K> componentClass : componentClasses) componentManager.createComponent(componentClass, gameObject);
        rootLogger.debug(gameObject + " spawned on " + this);
        return gameObject;
    }

    public <T extends GameObject> T spawnObject(Class<T> objectClass) {
        return (T) spawn(objectClass, new Class[]{Transform.class, Render.class});
    }

    public void despawn(GameObject gameObject) {
        try {
            destroyGameObject(gameObject);
            rootLogger.debug(gameObject + " was despawned from " + this);
        } catch (UnspawnedGameObjectException e) {
            e.printStackTrace();
        }
    }

    private void destroyGameObject(GameObject gameObject) throws UnspawnedGameObjectException {
        for (GameObject gameObj : gameObjects) {
            if (gameObj.equals(gameObject)) {
                gameObjects.remove(gameObject);
                entityManager.destroyEntity(gameObject.getId());
                return;
            }
        }
        throw new UnspawnedGameObjectException(gameObject);
    }
}
