package storages;

import api.data.AbstractDataStorage;
import model.BaseEntity;

import java.util.List;

public abstract class AbstractDataStorageImpl<E extends BaseEntity> implements AbstractDataStorage<E> {

    private Long entityIdSequence;

    private List<E> entities;

    @Override
    public void setSequenceId(Long id) {
        entityIdSequence = id;
    }

    @Override
    public List<E> getEntities() {
        return entities;
    }

    @Override
    public void setEntities(List<E> entities) {
        this.entities = entities;
    }

    @Override
    public E create(E entity) {
        entity.setId(entityIdSequence++);
        entities.add(entity);
        return entity;
    }
}
