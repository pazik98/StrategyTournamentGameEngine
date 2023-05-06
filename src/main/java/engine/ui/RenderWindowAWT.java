package engine.ui;

import engine.Engine;
import engine.Scene;
import engine.core.resource.ResourceManager;

import javax.swing.*;

public class RenderWindowAWT {

    private Engine engine;
    private Scene scene;
    private JFrame frame;
    private GamePane gamePane;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
        gamePane.setScene(scene);
    }

    public void initWindow() {
        frame = new JFrame();
        frame.setTitle("Render Window AWT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 1000, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        gamePane = new GamePane();
        gamePane.setWindow(this);
        gamePane.setScene(scene);
        frame.add(gamePane);

        Runnable doUpdate = () -> {
            while (true) {
                update();
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        SwingUtilities.invokeLater(doUpdate);
    }

    public void update() {
        if (scene != null) {
            gamePane.paintComponent(gamePane.getGraphics());
        }
    }

}
