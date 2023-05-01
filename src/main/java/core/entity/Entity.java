package core.entity;

import core.component.Component;

import java.util.ArrayList;
import java.util.List;

abstract public class Entity {

    private final int id;
    private final List<Component> components;

    public Entity(int id) {
        this.id = id;
        components = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    public <T extends Component> void removeComponent(Class<T> componentClass) {
        components.removeIf(component -> component.getClass().isAssignableFrom(componentClass));
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", components=" + components +
                '}';
    }
}
