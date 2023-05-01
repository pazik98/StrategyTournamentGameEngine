package core;

import core.component.Component;
import core.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject extends Entity {

    private String name;
    private final List<Component> components;

    public GameObject(int id) {
        super(id);
        name = "GameObject " + id;
        components = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public <T extends Component> T getComponent(Class<T> componentClass) {
        for (Component component : components) {
            if (component.getClass().isAssignableFrom(componentClass)) {
                return componentClass.cast(component);
            }
        }
        return null;
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        components.removeIf(component -> component.getClass().isAssignableFrom(componentClass));
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "name='" + name + '\'' +
                ", components=" + components +
                '}';
    }
}
