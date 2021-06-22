package api.data;

import java.util.List;
import model.BaseEntity;

public interface AbstractDataStorage<E extends BaseEntity> {

    void setSequenceId(Long id);

    List<E> getEntities();

    void setEntities(List<E> entities);

    E create(E entity);
}
