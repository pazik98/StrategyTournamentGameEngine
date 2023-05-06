package engine.ui;

import engine.Scene;
import engine.core.component.Transform;
import engine.core.entity.gameobject.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class GamePane extends JPanel {

    private Scene scene;
    private RenderWindowAWT window;

    public void setWindow(RenderWindowAWT window) {
        this.window = window;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (scene != null) {
            List<GameObject> objects = scene.getRenderableObjects();
            for (GameObject object : objects) {
                Transform transform = object.getComponent(Transform.class);
                drawGameObject(g, object, (int) Math.round(transform.getPosition().getX()),
                        (int) Math.round(transform.getPosition().getY()));
            }
        }
    }

    private void drawGameObject(Graphics g, GameObject gameObject, int x, int y) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier", Font.BOLD,50));
        BufferedImage image = window.getEngine().getResourceManager().getTexture("tank");
        g.drawImage(image, x, y, null);
        g.drawString(gameObject.getName(), x, y);
    }
}
