package core.component;

import core.GameObject;
import core.entity.Entity;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentManager {

    private final List<Component> components;
    private int componentIdCounter = 0;

    public ComponentManager() {
        components = new ArrayList<>();
    }

    private int generateComponentId() {
        return componentIdCounter++;
    }

    public <T extends Component> T createComponent(Class<T> componentClass, GameObject gameObject) {
        int id = generateComponentId();
        T component;
        try {
            component = componentClass.getDeclaredConstructor(int.class).newInstance(id);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        components.add(component);
        gameObject.addComponent(component);
        component.setGameObject(gameObject);
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
        component.getGameObject().removeComponent(component.getClass());
        component.setGameObject(null);
        components.remove(component);
    }

    public void destroyComponent(Component component) {
        component.getGameObject().removeComponent(component.getClass());
        component.setGameObject(null);
        components.remove(component);
    }

    @Override
    public String toString() {
        return "ComponentManager{" +
                "components=" + components +
                '}';
    }
}
