package core;

import core.component.Component;
import core.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject extends Entity {

    private String name;

    public GameObject(int id) {
        super(id);
        name = "GameObject " + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "name='" + name + '\'' +
                "components=" + getComponents() + '\'' +
                '}';
    }
}
