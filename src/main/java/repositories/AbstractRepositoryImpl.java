package repositories;

import api.data.AbstractDataStorage;
import api.repositories.AbstractRepository;
import exeptions.NoRecordException;
import model.BaseEntity;
import storages.AbstractDataStorageImpl;
import utils.FileUtils;

import java.util.List;
import java.util.Optional;

public abstract class AbstractRepositoryImpl<E extends BaseEntity>
        implements AbstractRepository<E> {

    protected final AbstractDataStorage<E> abstractDataStorage;

    protected AbstractRepositoryImpl(AbstractDataStorage<E> abstractDataStorage){
        this.abstractDataStorage = abstractDataStorage;
    }



    @Override
    public E create(E entity) {
       return abstractDataStorage.create(entity);
    }

    @Override
    public Optional<E> get(Long id) {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity->entity.getId()==id)
                .findFirst();
    }

    @Override
    public List<E> getAll() {
        return abstractDataStorage.getEntities();
    }

    @Override
    public void update(E entity) {
        int index = abstractDataStorage.getEntities().indexOf(entity);
        abstractDataStorage.getEntities().set(index, entity);
    }

    @Override
    public void delete(Long id) throws NoRecordException {
        E entityToDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity->entity.getId()==id)
                .findFirst()
                .orElseThrow(()->new NoRecordException("object",id));
        abstractDataStorage.getEntities().remove(entityToDelete);
    }

}
