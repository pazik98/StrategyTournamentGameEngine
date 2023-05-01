import engine.core.ComponentHeriter;
import engine.core.GameObjectHerited;
import engine.core.component.ComponentManager;
import engine.core.entity.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();
        ComponentManager componentManager = new ComponentManager();

        GameObjectHerited gameObjectHerited = entityManager.createEntity(GameObjectHerited.class);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);
        componentManager.createComponent(ComponentHeriter.class, gameObjectHerited);

        componentManager.destroyComponent(gameObjectHerited.getComponent(ComponentHeriter.class));

    }
}
