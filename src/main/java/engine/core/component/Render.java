package engine.core.component;

import engine.core.resource.Texture;

public class Render extends Component {

    private Texture texture;

    public Render(int id) {
        super(id);
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "Render{" +
                "texture=" + texture +
                '}';
    }
}
