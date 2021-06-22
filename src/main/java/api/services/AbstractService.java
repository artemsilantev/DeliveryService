package api.services;

import exeptions.NoRecordException;
import model.BaseEntity;

import java.util.List;

public interface AbstractService <E extends BaseEntity> {
    E get(Long id) throws NoRecordException;
    E create(E entity);
    void update(E entity);
    List<E> getAll();
    void delete(Long id) throws NoRecordException;
}
