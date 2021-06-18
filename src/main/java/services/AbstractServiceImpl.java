package services;

import api.repositories.AbstractRepository;
import api.services.AbstractService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import exeptions.NoRecordException;
import model.BaseEntity;

import java.util.List;

public abstract class AbstractServiceImpl<E extends BaseEntity>
        implements AbstractService<E> {

    protected AbstractRepository<E> abstractRepository;

    @Override
    public E get(Long id) throws NoRecordException {
        return abstractRepository.get(id)
                .orElseThrow(NoRecordException::new);
    }

    @Override
    public List<E> getAll() {
        return abstractRepository.getAll();
    }

    @Override
    public void displayInfo(Long id) throws NoRecordException {
        System.out.println(abstractRepository.get(id).orElseThrow(NoRecordException::new));
    }

    @Override
    public List<E> sortByKey() {
        return null;
    }
}
