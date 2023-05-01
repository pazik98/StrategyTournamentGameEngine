package core.component;

import core.GameObject;

public interface IComponentManager {

    <T extends Component> T createComponent(Class<T> componentClass);

    void assignComponent(Component component, GameObject gameObject);

    <T extends Component> T getComponent(int id);

    void destroyComponent(int id);
}
