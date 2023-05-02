package engine.core.component;

import java.awt.image.BufferedImage;

public class Render extends Component {

    private BufferedImage texture;

    public Render(int id) {
        super(id);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "Render{" +
                "texture=" + texture +
                '}';
    }
}
