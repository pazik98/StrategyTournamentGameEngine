package engine.core.component;

public class Render extends Component {

    private String texturePath;

    public Render(int id) {
        super(id);
    }

    public String getTexturePath() {
        return texturePath;
    }

    public void setTexturePath(String texturePath) {
        this.texturePath = texturePath;
    }

    @Override
    public String toString() {
        return "Render{" +
                "texturePath='" + texturePath + '\'' +
                '}';
    }
}
