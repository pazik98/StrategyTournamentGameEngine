package engine;

import engine.core.resource.ResourceManager;
import engine.core.resource.Texture;
import engine.ui.RenderWindowAWT;

import java.time.temporal.Temporal;

public class Engine {

    private ResourceManager resourceManager;
    private Scene activeScene;
    private RenderWindowAWT window;

    public Engine() {
        resourceManager = new ResourceManager();
        resourceManager.createResource(Texture.class, "tank", "tank.png");
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void setActiveScene(Scene scene) {
        activeScene = scene;
        window.setScene(scene);
    }

    public void initUI() {
        window = new RenderWindowAWT();
        window.setEngine(this);
        window.initWindow();
    }
}
