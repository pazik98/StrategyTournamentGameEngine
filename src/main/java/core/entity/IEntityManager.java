package core.entity;

public interface IEntityManager {

    <T extends Entity> T createEntity(Class<T> entityClass);

    <T extends Entity> T getEntity(int id);

    void destroyEntity(int id);
}
