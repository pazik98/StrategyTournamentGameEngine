package engine.core.component;

import engine.core.GameObject;
import engine.core.entity.Entity;

public abstract class Component implements IComponent {

    private final int id;
    private Entity entity;

    public Component(int id) {
        this.id = id;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                '}';
    }
}
