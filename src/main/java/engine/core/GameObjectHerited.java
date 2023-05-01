package engine.core;

public class GameObjectHerited extends GameObject {
    public GameObjectHerited(int id) {
        super(id);
    }

    public void print() {
        System.out.println("It is herited game object!");
    }
}
