package engine.ui;

import java.awt.image.BufferedImage;

public interface RenderWindow {

    void draw(int x, int y, int sizeX, int sizeY, BufferedImage texture);
}
