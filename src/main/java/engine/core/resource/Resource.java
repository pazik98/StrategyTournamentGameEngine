package engine.core.resource;

public abstract class Resource {

    private String name;
    private final String path;

    public Resource(String name, String path) {
        setName(name);
        this.path = path;
    }

    protected void setName(String name) {
        this.name = "resource." + name;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
