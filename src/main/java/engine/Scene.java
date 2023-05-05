package engine;

import engine.core.System.RandomMovingSystem;
import engine.core.System.SystemManager;
import engine.core.component.*;
import engine.core.entity.EntityManager;
import engine.core.entity.IEntityManager;
import engine.core.exception.UnspawnedGameObjectException;
import engine.gameobject.GameObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private static final Logger rootLogger = LogManager.getRootLogger();

    private IEntityManager entityManager;
    private IComponentManager componentManager;
    private SystemManager systemManager;
    private List<GameObject> gameObjects;
    private List<GameObject> renderableObjects;

    private int tickrate = 2;
    private Thread thread;

    public Scene() {
        entityManager = new EntityManager();
        componentManager = new ComponentManager();
        systemManager = new SystemManager();
        gameObjects = new ArrayList<>();
        renderableObjects = new ArrayList<>();
        systemManager.addSystem(new RandomMovingSystem(gameObjects));


        Runnable doUpdate = () -> {
            while (true) {
                systemManager.loop();
                try {
                    Thread.sleep(1000/tickrate);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        thread = new Thread(doUpdate);
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
        T object = (T) spawn(objectClass, new Class[]{Transform.class, Render.class});
        renderableObjects.add(object);
        return object;
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

    public void start() {
        thread.start();
    }

    public void pause() {

    }

    public List<GameObject> getRenderableObjects() {
        return new ArrayList<>(renderableObjects);
    }
}
