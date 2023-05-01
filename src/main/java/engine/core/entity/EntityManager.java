package engine.core.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class EntityManager implements IEntityManager {

    private static final Logger rootLogger = LogManager.getRootLogger();

    private final List<Entity> entities;
    private int entityIdCounter = 0;

    public EntityManager() {
        entities = new ArrayList<>();
    }

    private int generateEntityId() {
        return entityIdCounter++;
    }

    @Override
    public <T extends Entity> T createEntity(Class<T> entityClass) {
        int id = generateEntityId();
        T entity;
        try {
            entity = entityClass.getDeclaredConstructor(int.class).newInstance(id);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        entities.add(entity);
        rootLogger.debug("created entity " + entity);
        return entity;
    }

    @Override
    public <T extends Entity> T getEntity(int id) {
        for (Entity entity : entities) {
            if (entity.getId() == id) {
                try {
                    return (T) entity;
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void destroyEntity(int id) {
        Entity entity = getEntity(id);
        entities.remove(entity);
        rootLogger.debug("removed entity " + entity);
    }

    @Override
    public String toString() {
        return "EntityManager{" +
                "entities=" + entities +
                '}';
    }
}
