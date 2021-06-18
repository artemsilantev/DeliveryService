package api.services;

import exeptions.NoRecordException;
import model.BaseEntity;

import java.util.List;

public interface AbstractService <E extends BaseEntity> {
    E get(Long id) throws NoRecordException;
    List<E> getAll();
    void displayInfo(Long id) throws NoRecordException;
    List<E> sortByKey();
}
