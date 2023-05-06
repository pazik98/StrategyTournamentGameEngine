import engine.Engine;
import engine.core.component.Transform;
import engine.core.entity.gameobject.GameObject;
import engine.core.entity.gameobject.GameObjectHerited;
import engine.Scene;
import engine.core.resource.ResourceManager;
import engine.core.resource.Texture;
import engine.ui.RenderWindowAWT;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Scene scene = new Scene();
        GameObject gameObject = scene.spawnObject(GameObjectHerited.class);
        gameObject.getComponent(Transform.class).setPosition(new Vector2D(100.0, 100.0));
        gameObject.setName("Tank-1");

        GameObject gameObject2 = scene.spawnObject(GameObjectHerited.class);
        gameObject2.getComponent(Transform.class).setPosition(new Vector2D(300.0, 300.0));
        gameObject2.setName("Tank-2");

        Engine engine = new Engine();
        engine.initUI();
        engine.setActiveScene(scene);
        scene.start();
    }
}
