package engine.core.resource;

public class Texture extends Resource {

    public Texture(String name, String path) {
        super(name, path);
    }

    @Override
    protected void setName(String name) {
        super.setName("texture." + name);
    }
}
