package engine.core.component;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class Transform extends Component {

    private Vector2D position;
    private double rotation;
    private Vector2D scale;

    public Transform(int id) {
        super(id);
        position = new Vector2D(0.0, 0.0);
        rotation = 0.0;
        scale = new Vector2D(1.0, 1.0);
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public Vector2D getScale() {
        return scale;
    }

    public void setScale(Vector2D scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Transform{" +
                "position=" + position.getX() + ", " + position.getY() +
                ", rotation=" + rotation +
                ", scale=" + scale.getX() + ", " + scale.getY() +
                '}';
    }
}
