import engine.gameobject.GameObject;
import engine.gameobject.GameObjectHerited;
import engine.Scene;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger rootLogger = LogManager.getRootLogger();

    public static void main(String[] args) {
        Scene scene = new Scene();
        GameObject gameObject = scene.spawnObject(GameObjectHerited.class);
    }
}
