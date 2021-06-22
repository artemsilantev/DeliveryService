package services;

import api.repositories.AbstractRepository;
import api.services.AbstractService;
import exeptions.NoRecordException;
import model.BaseEntity;

import java.util.List;

public abstract class AbstractServiceImpl<E extends BaseEntity>
        implements AbstractService<E> {

    protected AbstractRepository<E> abstractRepository;

    protected AbstractServiceImpl(AbstractRepository<E> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }


    @Override
    public void update(E entity){
        abstractRepository.update(entity);
    }
    @Override
    public E create(E entity) {
       return abstractRepository.create(entity);
    }

    @Override
    public void delete(Long id) throws NoRecordException {
        abstractRepository.delete(id);
    }

    @Override
    public E get(Long id) throws NoRecordException {
        return abstractRepository.get(id)
                .orElseThrow(()->new NoRecordException("object",id));
    }

    @Override
    public List<E> getAll() {
        return abstractRepository.getAll();
    }


}
