package engine.core.System;

import engine.core.component.Render;
import engine.core.component.Transform;
import engine.gameobject.Camera;
import engine.gameobject.GameObject;
import engine.ui.RenderWindow;

import java.awt.*;
import java.util.List;

public class RenderSystem implements ISystem {

    private List<GameObject> gameObjects;
    private Camera activeCamera;
    private RenderWindow window;

    public RenderSystem(List<GameObject> renderableObjects) {
        this.gameObjects = renderableObjects;
    }

    public Camera getActiveCamera() {
        return activeCamera;
    }

    public void setActiveCamera(Camera activeCamera) {
        this.activeCamera = activeCamera;
    }

    private void paint() {
        for (GameObject gameObject : gameObjects) {
            Transform transform = gameObject.getComponent(Transform.class);
            Render render = gameObject.getComponent(Render.class);
            System.out.println("DRAWING " + gameObject + " \n");
            // Draw
            /*
            * window.draw(transform.getPosition().getX(), transform.getPosition().getY(), );
            */
        }
    }

    @Override
    public void takeStep() {
        paint();
    }
}
