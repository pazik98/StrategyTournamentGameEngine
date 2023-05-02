package engine.core.component;

import engine.core.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ComponentManager implements IComponentManager {

    private static final Logger rootLogger = LogManager.getRootLogger();

    private final List<Component> components;
    private int componentIdCounter = 0;

    public ComponentManager() {
        components = new ArrayList<>();
    }

    private int generateComponentId() {
        return componentIdCounter++;
    }

    public <T extends Component> T createComponent(Class<T> componentClass, Entity entity) {
        int id = generateComponentId();
        T component;
        try {
            component = componentClass.getDeclaredConstructor(int.class).newInstance(id);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        components.add(component);
        entity.addComponent(component);
        component.setEntity(entity);
        rootLogger.debug("created " + component + " on " + entity);
        return component;
    }

    public <T extends Component> T getComponent(int id) {
        for (Component component : components) {
            if (component.getId() == id) {
                try {
                    return (T) component;
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void destroyComponent(int id) {
        Component component = getComponent(id);
        component.getEntity().removeComponent(component.getClass());
        component.setEntity(null);
        components.remove(component);
        rootLogger.debug("destroyed " + component);
    }

    public void destroyComponent(Component component) {
        component.getEntity().removeComponent(component.getClass());
        component.setEntity(null);
        components.remove(component);
        rootLogger.debug("destroyed " + component);
    }

    @Override
    public String toString() {
        return "ComponentManager{" +
                "components=" + components +
                '}';
    }
}
