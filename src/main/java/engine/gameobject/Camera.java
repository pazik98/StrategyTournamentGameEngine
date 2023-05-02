package engine.gameobject;

public class Camera extends GameObject {

    private double zoom;

    public Camera(int id) {
        super(id);
        setName("Camera");
        zoom = 1.0;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
}
