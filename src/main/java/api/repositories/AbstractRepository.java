package api.repositories;

import exeptions.NoRecordException;
import model.BaseEntity;
import java.util.List;
import java.util.Optional;

public interface AbstractRepository <E extends BaseEntity> {
     E create(E entity);
     Optional<E> get(Long id);
     List<E> getAll();
     void update(E entity);
     void delete(Long id) throws NoRecordException;
}
