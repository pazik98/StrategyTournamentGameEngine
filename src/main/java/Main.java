import core.ComponentHeriter;
import core.GameObject;
import core.GameObjectHerited;
import core.component.Component;
import core.component.ComponentManager;
import core.entity.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();
        ComponentManager componentManager = new ComponentManager();

        GameObjectHerited gameObjectHerited = entityManager.createEntity(GameObjectHerited.class);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);

        componentManager.destroyComponent(gameObjectHerited.getComponent(ComponentHeriter.class));

        System.out.println(componentManager);
        System.out.println(gameObjectHerited);


    }
}
