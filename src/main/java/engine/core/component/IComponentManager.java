package engine.core.component;

import engine.core.entity.Entity;

public interface IComponentManager {

    <T extends Component> T createComponent(Class<T> componentClass, Entity entity);

    <T extends Component> T getComponent(int id);

    void destroyComponent(int id);

    void destroyComponent(Component component);
}
