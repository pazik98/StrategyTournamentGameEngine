package core.component;

import core.GameObject;

public abstract class Component implements IComponent {

    private final int id;
    private GameObject gameObject;

    public Component(int id) {
        this.id = id;
    }

    public GameObject getGameObject() {
        return gameObject;
    }

    public void setGameObject(GameObject gameObject) {
        this.gameObject = gameObject;
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
