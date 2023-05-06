package engine.core.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ResourceManager {

    private static final Logger rootLogger = LogManager.getRootLogger();
    private final Map<String, Resource> resourceMap;
    private final Map<String, BufferedImage> textureMap;

    private final String absolutePath = new File("").getAbsolutePath();

    public ResourceManager() {
        resourceMap = new HashMap<>();
        textureMap = new HashMap<>();
    }

    public <T extends Resource> T createResource(Class<T> resourceClass, String name, String path) {
        T resource;
        try {
            resource = resourceClass.getDeclaredConstructor(String.class, String.class).newInstance(name, path);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
        resourceMap.put(resource.getName(), resource);
        rootLogger.debug("created resource " + resource.getName());
        return resource;
    }

    public BufferedImage getTexture(String name) {
        String fullName = "resource.texture." + name;
        if (!textureMap.containsKey(fullName)) {
            loadTexture(fullName);
        }
        return textureMap.get(fullName);
    }

    public void loadTexture(String name) {
        Resource resource = resourceMap.get(name);
        File textureFile = new File(absolutePath + "\\src\\main\\resources\\textures\\" + resource.getPath());
        BufferedImage image = new BufferedImage(1, 1, 1);
        try {
            image = ImageIO.read(textureFile);
            rootLogger.debug("loaded texture " + resource.getName());
        } catch (IOException e) {
            rootLogger.error("Cannot load texture " + resource.getName() + " from " + resource.getPath());
            e.printStackTrace();
        }
        textureMap.put(resource.getName(), image);
    }

    @Override
    public String toString() {
        return "ResourceManager{" +
                "resourceMap=" + resourceMap +
                '}';
    }
}
