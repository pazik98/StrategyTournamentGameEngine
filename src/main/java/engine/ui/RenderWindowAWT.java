package engine.ui;

import engine.Scene;

import javax.swing.*;

public class RenderWindowAWT {
    private Scene scene;
    private JFrame frame;
    private GamePane gamePane;

    public RenderWindowAWT(Scene scene) {
        this.scene = scene;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void initWindow() {
        frame = new JFrame();
        frame.setTitle("Render Window AWT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 1000, 600);
        frame.setVisible(true);
        gamePane = new GamePane();
        gamePane.setScene(scene);
        frame.add(gamePane);

        Runnable doUpdate = () -> {
            while (true) {
                update();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        SwingUtilities.invokeLater(doUpdate);
    }

    public void update() {
        gamePane.paintComponent(gamePane.getGraphics());
    }

}
