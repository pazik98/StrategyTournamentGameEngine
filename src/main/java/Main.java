import engine.core.ComponentHeriter;
import engine.core.GameObject;
import engine.core.GameObjectHerited;
import engine.core.Scene;
import engine.core.component.ComponentManager;
import engine.core.component.Transform;
import engine.core.entity.EntityManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Scene scene = new Scene();
        GameObject gameObject = scene.spawn(GameObjectHerited.class);
        scene.despawn(gameObject);
    }
}
