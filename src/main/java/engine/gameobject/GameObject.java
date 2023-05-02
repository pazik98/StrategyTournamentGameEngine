package engine.gameobject;

import engine.Scene;
import engine.core.entity.Entity;

import java.util.Objects;

public abstract class GameObject extends Entity {

    private String name;
    private Scene scene;

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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    public String toString() {
        return "GameObject{" +
                "name='" + name + '\'' +
                "components=" + getComponents() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(name, that.name) && Objects.equals(scene, that.scene);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scene);
    }
}
